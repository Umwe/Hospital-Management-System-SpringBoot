# <span style="font-size:larger;">Hospital Management System SpringBoot</span>


This is a web application that allows users to manage various aspects of a hospital, such as patients, doctors, appointments, departments, and reports. It uses Spring Boot framework, Hibernate JPA for data access, MySQL for database management, and Thymeleaf for templating.


# <span style="font-size:larger;">Features</span>
User authentication and authorization
CRUD operations for patients
CRUD operations for doctors
CRUD operations for appointments
CRUD operations for departments
CRUD operations for reports
Pagination and sorting
Validation and error handling
Responsive design
Installation
To run this project locally, you need to have the following dependencies installed:

# <span style="font-size:larger;">Dependency & Version</span>
Dependency	Version.  
Spring Boot	2.6.2   
Hibernate JPA	5.6.0  
MySQL	8.0.26  
Thymeleaf	3.0.9  
Bootstrap	5.1.3  
Java 17  

To install the dependencies using Maven or Gradle, follow the instructions in the README.md file in the root directory of this repository.

To start the application using Spring Boot CLI or IDE plugin, run the following command:

./mvnw spring-boot:run -Dspring-boot.run.profiles.active=dev

This will start the application on http://localhost:8080 by default.

Usage
To access the application from your browser, go to http://localhost:8080.

You will see a login page where you can enter your username and password to log in as an admin or a doctor.  

Credentials for admin are:  
username: admin  
password: 0000  

credentials for doctor:  
username: africa    
password: 0000  

# <span style="font-size:larger;">ADMIN ROLE</span>
you can perform various tasks such as adding or editing patients, doctors, appointments, departments, and generate reports.


# <span style="font-size:larger;">Doctor Role</span>
you can create new consultation view patient list, view all consultations and sort to see according to your ID, and view all patients informations related to your own profile and appointments.  

USER ROLE  
# <span style="font-size:larger;">USER ROLE </span>
you can make an appointment on the home page and receive the notification confirming your scheduled appointment.  


# <span style="font-size:larger;">Visual of the Project</span>


# <span style="font-size:medium;">Entity Relationship Diagram/span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/ERD.png)




# <span style="font-size:medium;">1.Home Page</span>

![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/raw/master/photos/homepage.png)
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/homepage1.png)
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/contact.png)

# <span style="font-size:medium;">2.APPOINTMENT PAGE</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/appt.png)

# <span style="font-size:medium;">3.Login Page</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/login.png)

# <span style="font-size:medium;">4.Admin Dashboard</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/admindash.png)

# <span style="font-size:medium;">5.Create new Patients</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/pcreate.png)

# <span style="font-size:medium;">6.List of Patients</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/patiientlist.png)

# <span style="font-size:medium;">7.Appointment List</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/aptlist.png)

# <span style="font-size:medium;">8.Doctor Home Page</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/drdash.png)

# <span style="font-size:medium;">9.Create New Consultation</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/newcons.png)

# <span style="font-size:medium;">10. List Consultations</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/listcons.png)

# <span style="font-size:medium;">11.List Patient</span>
![HOME PAGE ](https://github.com/Umwe/Hospital-Management-System-SpringBoot/blob/master/photos/listpat.png)






























