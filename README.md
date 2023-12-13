## Cloud Manager: A Java Spring Boot API for File Management

Cloud Manager is a Java Spring Boot API designed managing files

### Features

* **File Upload:** `POST /file/upload`
* **File Download:**  `GET /file/download/{name}`
* **File View:** `GET /file/show/{name}`
* **Ping Endpoint:** `GET /ping`

### Technologies Used

* Java 17
* Spring boot 3.2.0
* Postgresql


### Getting Started

1. **Clone the repository:**

```bash
  git clone https://github.com/hei-school/cc-hei-hub-_-uwu-_.git
  cd cc-hei-hub-_-uwu-_
  git checkout origin/feature/java
```

2. **Set up the postgresql database:**

- go to src/main/resources/application.properties
- change the value of 

```
spring.datasource.password=your password
spring.datasource.username=your username
```

3. **Build the project:**

- Linux / MacOS:

```bash
  ./mvnw clean install 
```

- Linux / MacOS:

```bash
  ./mvnw.cmd clean install
```

4. **Run the application:**

```bash
  java -jar target/uploader-0.0.1-SNAPSHOT.jar
```

### API Endpoints

| Method | Endpoint                | Description                                                                                                                                                              |
|--------|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | `/ping`                 | Checks if the API is running and healthy. Returns "pong" if successful.                                                                                                  |
| GET    | `/file`                 | List of existing files                                                                                                                                                   |
| POST   | `/file/upload`          | Uploads a file. Requires a multipart form data request with a file field named "file". Returns information about the uploaded file.                                      |
| GET    | `/file/show/{name}`     | Displays the file with the name specified in the path variable                                                                                                           |
| GET    | `/file/download/{name}` | Download the file with the name specified in the path variable (`download only works with the browser, it won't download if you're in another http client like postman`) |

### Exceptions handled

| Code | Status          | Action                                                                                                                                                                  |
|------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 404  | FILE_NOT_FOUND  | if you try to retrieve a non-existent file                                                                                                                              |
| 423  | FILE_TOO_LARGE  | if you try to upload a file with a size that exceeds the maximum allowed The maximum size is defined in the application.properties file, which is currently set to 1GB. |
| 501  | NOT_IMPLEMENTED | if you are trying to access an endpoint that is not yet finished (/file/uploads)                                                                                        |
| 100  | DUPLICATE_FILE  | if you upload a file with a name that already exists                                                                                                                    |
| 408  | REQUEST_TIMEOUT | if the server takes too long to reply (we have explicitly defined a timeout of `20 seconds` on the `/file` endpoint)                                                    |                                                    

### Team

- Mickaël Jerry
- Fifaliana Loica
- Bryan Lakara
- Onjaniaina