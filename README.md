# Secure Note CI/CD Project

## Project Description

Secure Note is a simple Java Spring Boot REST API created as part of a DevSecOps and CI/CD project.

The application allows users to create, retrieve, and delete notes while demonstrating secure input handling and automated delivery pipeline.

---

## Application Features

The application provides the following REST API endpoints:

* Create a note → `POST /notes`
* Get all notes → `GET /notes`
* Get note by ID → `GET /notes/{id}`
* Delete note → `DELETE /notes/{id}`

---

## Technologies Used

* Java 17
* Spring Boot
* Maven
* JUnit
* GitHub Actions
* Semgrep (SAST)
* OWASP Dependency Check

---

## Input Handling and Security

The application accepts user input via JSON requests.

Example:

```json
{
  "title": "First note",
  "content": "This is my first secure note"
}
```

Security measures implemented:

* Validation using annotations (`@NotBlank`, `@Size`)
* Protection against empty input
* Input length restriction
* Basic sanitization of HTML characters to prevent XSS
* Dependency vulnerability scanning
* Static code analysis

---

## CI/CD Pipeline Architecture

```
Developer → GitHub Repository → GitHub Actions Pipeline
          → Build → Test → Lint → Security Scan
          → Artifact Upload → Deploy Staging → Deploy Production
```

---

## Pipeline Stages

### Plan

Define project requirements and architecture.

### Code

Develop REST API using Spring Boot.

### Build

Maven compiles the project and packages it into a JAR file.

### Test

JUnit tests verify application functionality.

### Lint

Checkstyle ensures code quality and consistency.

### Security

* SAST: Semgrep scans source code for vulnerabilities
* Dependency Scan: OWASP checks libraries for known CVEs

Pipeline fails if vulnerabilities are detected.

### Release

Build artifact (`.jar`) is generated.

### Deploy

Deployment is simulated in two environments:

* Staging
* Production

### Operate

Application generates logs stored locally.

### Monitor

In a real system:

* Prometheus collects metrics
* Grafana visualizes performance and health

---

## Artifact Management

The pipeline generates a JAR file:

```
target/secure-note-0.0.1-SNAPSHOT.jar
```

It is:

* Uploaded as a build artifact
* Downloaded in deployment stage

---

## Security Risks and Mitigation

| Risk                    | Solution               |
| ----------------------- | ---------------------- |
| Empty input             | Validation annotations |
| Long input              | Size limits            |
| XSS                     | Input sanitization     |
| Vulnerable dependencies | OWASP Dependency Check |
| Unsafe code patterns    | Semgrep                |

---

## Deployment

Deployment is simulated using GitHub Actions:

* Staging deployment prints logs and downloads artifact
* Production deployment prints success message

---

## Logging and Monitoring

Application logs are stored in:

```
logs/application.log
```

Monitoring concept:

* Prometheus → collects metrics
* Grafana → visualizes data

---

## Screenshots

The following screenshots are included in the `screenshots` folder:

1. Successful pipeline execution
2. Failed security test
3. Successful deployment

---

## Conclusion

This project demonstrates a full DevSecOps lifecycle:

* Secure application development
* Automated CI/CD pipeline
* Integrated security testing
* Artifact management
* Simulated deployment and monitoring
