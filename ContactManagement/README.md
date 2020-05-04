# ContactManagement

## How to Run 

This application is packaged as a jar which has Tomcat embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8
* You can build the project by running ```gradlew bootJar```
* Once successfully built, you can run the service by running below command:
```
        java -jar  build/libs/ContactManagement-0.0.1-SNAPSHOT.jar
```
        
## About the Service

The service is just a simple contact management REST service. It uses an in-memory database (H2) to store the data.You can call REST endpoints through swagger by going through link <http://localhost:8080/swagger-ui.html>

## REST APIs Endpoints
### Create a Contact resource
```
POST /contacts
Accept: application/json
Content-Type: application/json

{
    "emailId": "test1@evolent.com",
    "firstName": "string",
    "lastName": "string",
    "phoneNo": "9898989898",
    "status": true
}

```

### Update a Contact resource
```
PUT /contacts/{contactId}
Accept: application/json
Content-Type: application/json

{
    "emailId": "test1@evolent.com",
    "firstName": "string",
    "lastName": "string",
    "phoneNo": "9898989898",
    "status": true
}

```

### Retrieve all Contacts
```
Get /contacts
Accept: application/json
Content-Type: application/json

```

### Delete a Contact Resource
```
DELETE /contacts/{contactId}
Accept: application/json
Content-Type: application/json
```

### Activate/Deactivate a Contact Resource
```
PATCH /contacts/{contactId}
Accept: application/json
Content-Type: application/json

{
    "status": true
}
```

## Validations
1. EmailId and PhoneNo should be unique.
2. PhoneNo should match regex "^\\+{0,1}(?:[0-9-#()] ?){6,22}[0-9-#()]$"
3. EmailId should match regex "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"
