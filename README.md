# Event Registration Application

This is a Spring Boot web application for managing college events. Users can create, update, view, and delete events through a user-friendly web interface.

## Features

- View list of all events with details (name, location, date)
- Create new events using a form
- Update existing events
- Delete events with confirmation prompt
- Responsive and styled UI using HTML and CSS

## Technologies Used

- Spring Boot (version 3.5.5)
- Spring Data JPA (with Hibernate)
- Thymeleaf (templating engine)
- H2 Database (in-memory for easy setup)
- Maven (build tool)

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone <your-repo-url>
   cd eventregistration

2. **Build the project:**
   ```bash
   mvn clean install

3. **Run The Application:**
    ```bash
   mvn spring-boot:run

4. **Open your Browser and goto:**
    ```bash
   http://localhost:8080/events

