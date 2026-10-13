# SmartTask – Personal Task Management System

Beginner-friendly full-stack Java project using Java 17, Spring Boot, HTML, CSS, JavaScript and a local H2 database.

## Run it
1. Install JDK 17+ and Maven.
2. Extract this ZIP and open a terminal in `SmartTask-FullStack-Java`.
3. Run `mvn spring-boot:run`.
4. Open **http://localhost:8080** in your browser.
5. Keep the terminal open while using the app. Stop with Ctrl+C.

The first run needs internet access to download Maven dependencies. Tasks are stored in a local database under `./data/`.

## Features
- Add, view, edit and delete tasks
- Set Low, Medium or High priority
- Optional description and due date
- Mark tasks complete / incomplete
- Filter by all, to-do or completed
- Dashboard counters and persistent database storage

## API
- `GET /api/tasks` – list tasks
- `GET /api/tasks/{id}` – retrieve one task
- `POST /api/tasks` – create a task
- `PUT /api/tasks/{id}` – update a task
- `PATCH /api/tasks/{id}/toggle` – toggle completion
- `DELETE /api/tasks/{id}` – delete a task

Example POST body:
```json
{"title":"Finish Java assignment","description":"Complete lab work","priority":"HIGH","dueDate":"2026-10-20","completed":false}
```

## Structure
- `src/main/java/com/smarttask/` – Java application
- `src/main/java/com/smarttask/task/` – entity, repository and REST controller
- `src/main/resources/static/` – frontend HTML, CSS and JavaScript
- `src/main/resources/application.properties` – database and server settings

This starter project does not include user accounts or authentication; it is a single-user learning project.
