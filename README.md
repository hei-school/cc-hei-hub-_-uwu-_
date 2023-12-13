## Cloud Manager: A Java Spring Boot API for File Management

Cloud Manager is a Java Spring Boot API designed managing files

### Features

* **File Upload:** Upload files via `POST /file/upload`
* **File Download:** Download files with URL generation from `GET /file/download/{name}`
* **File Information:** Fetch detailed information about a file from `GET /file/show/{name}`
* **Ping Endpoint:** Verify API health with `GET /ping`

### Technologies Used

* Java 17
* Spring boot 3.2.0
* Postgresql


### Getting Started

1. **Clone the repository:**

```
git clone https://github.com/hei-school/cc-hei-hub-_-uwu-_.git
```

2. **Set up the postgresql database:**

- go to src/main/resources/application.properties
- change the value of 

```
spring.datasource.password=your password
spring.datasource.username=your username
```

3. **Build the project:**

```
./mvnw clean install 
```

4. **Run the application:**

```
java -jar target/uploader-0.0.1-SNAPSHOT.jar
```

### API Endpoints

| Endpoint | Description |
|---|---|
| `/ping` (GET) | Checks if the API is running and healthy. Returns "pong" if successful. |
| `/file/upload` (POST) | Uploads a file. Requires a multipart form data request with a file field named "file". Returns information about the uploaded file. |
| `/file/show/{name}` (GET) | Retrieves information about a file, including name, size, and creation date. Requires a valid file name as a path parameter. |
| `/file/download/{name}` (GET) | Generates a temporary URL for downloading a file. Requires a valid file name as a path parameter. The URL expires after a fixed time. |

### Team

- Mickaël Jerry
- Fifaliana Loica
- Bryan Lakara
- Onjaniaina