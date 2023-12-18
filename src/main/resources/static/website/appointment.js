document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('appointmentForm');
  const patientIdInput = document.getElementById('patientid');
  const firstNameInput = document.getElementById('firstName');
  const lastNameInput = document.getElementById('lastName');
  const emailInput = document.getElementById('email');
  const phoneInput = document.getElementById('phoneNumber');
  const departmentSelect = document.getElementById('department');
  const errorMessage = document.getElementById('errorMessage'); // Added for error message

  // Function to populate department options
  function populateDepartments() {
    const departmentUrl = 'http://localhost:8080/departments/listDepartments';

    fetch(departmentUrl, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
      })
      .then(departments => {
        // Clear existing options
        departmentSelect.innerHTML = '<option value="">Select Department</option>';
        // Populate options
        departments.forEach(department => {
          const option = document.createElement('option');
          option.value = department.id;
          option.textContent = department.name;
          departmentSelect.appendChild(option);
        });
      })
      .catch(error => {
        // Handle fetch errors here
        console.error('Error fetching departments:', error);
      });
  }

  // Call the function to populate departments on page load
  populateDepartments();

  patientIdInput.addEventListener('blur', function () {
    const patientId = patientIdInput.value;

    if (patientId) {
      const apiUrl = `http://localhost:8080/patients/listPatients/${patientId}`;

      fetch(apiUrl, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then(response => {
          if (!response.ok) {
            if (response.status === 404) {
              // Patient not found
              throw new Error('Patient ID not found');
            } else {
              // Other error, throw the response status
              throw new Error(`HTTP error! Status: ${response.status}`);
            }
          }
          return response.json();
        })
        .then(patientData => {
          // Patient exists, reset error message
          errorMessage.textContent = '';
          // Populate form fields with the retrieved data
          firstNameInput.value = patientData.firstName || '';
          lastNameInput.value = patientData.lastName || '';
          emailInput.value = patientData.email || '';
          phoneInput.value = patientData.phoneNumber || '';
        })
        .catch(error => {
          // Handle different error scenarios
          if (error.message === 'Patient ID not found') {
            errorMessage.textContent = 'Patient ID not found. Please check the ID and try again.';
          } else {
            errorMessage.textContent = `Error: ${error.message}`;
          }
        });
    }
  });

  // Add form submission handling
  form.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Get input values for form submission
    const patientid = patientIdInput.value;
    const firstname = firstNameInput.value;
    const lastname = lastNameInput.value;
    const email = emailInput.value;
    const phoneNumber = phoneInput.value;
    const selectedDepartment = departmentSelect.value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const note = document.getElementById('message').value; // Updated to match your form element

    // Validate form data as needed

    // Create a JSON object with the appointment data
    const appointmentData = {
      patientid: patientid,
      firstname: firstname,
      lastname: lastname,
      email: email,
      phoneNumber: phoneNumber,
      department: selectedDepartment,
      date: date,
      time: time,
      note: note
    };

    // Make a POST request to create a new appointment
    fetch('/appointments/saveAppointment', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(appointmentData),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Appointment created:', data);
        alert('Appointment created successfully!');
        // You can redirect the user or perform other actions as needed
        window.location.reload();
      })
      .catch(error => {
        console.error('Error creating appointment:', error);
        alert('Error creating appointment. Please try again.');
      });
  });
});
