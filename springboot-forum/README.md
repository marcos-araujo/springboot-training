# Spring Boot Forum
Create, edit, delete and visualize forum threads.

## General info
Sample project created for studying Spring Boot technology.

## Design Patterns
<ul>	
	<li>Form Objects</li>
	<li>DTO Objects</li>
	<li>Repository</li>
</ul>

## Technologies 
<ul>	
	<li>Rest Verbs: GET, PUT, POST and DELETE</li>
	<li>H2 Database Engine</li>
	<li>Spring Data JPA</li>
	<li>Bean Validation</li>
	<li>RestControllerAdvice</li>
	<li>Spring Data Pagination and Ordering</li>
	<li>Spring Cache</li>
	<li>JWT Token Authentication</li>
	<li>Spring Security</li>
	<li>Spring Profiles</li>
	<li>Spring Boot Admin Client</li>
	<li>Spring Boot Unit Tests</li>
	<li>SpringFox Swagger</li>
	<li>data.sql for initialization inserts</li>
	<li>DevTools</li>
</ul>

---

## All Threads

**`GET`** /threads

**Response**

```
{
    "content": [
        {
            "id": 3,
            "title": "Dúvida 3",
            "message": "Tag HTML",
            "creationDate": "2019-05-05T20:00:00"
        },
        {
            "id": 2,
            "title": "Dúvida 2",
            "message": "Projeto não compila",
            "creationDate": "2019-05-05T19:00:00"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageSize": 10,
        "pageNumber": 0,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 3,
    "last": true,
    "first": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 3,
    "size": 10,
    "number": 0,
    "empty": false
}

```

## Thread 

**`GET`** /threads/:id

**Response**

```
{
    "id": 1,
    "title": "Dúvida",
    "message": "Erro ao criar projeto",
    "criation": "2019-05-05T18:00:00",
    "autorsName": "Aluno",
    "status": "NOT_ANSWERED",
    "answers": []
}
```

## Create

**`POST`** /threads

```
{
    "title": "New Thread",
    "message": "Message about thread",
    "courseName": "Course Name"
}
```
  
**Response**

```
{
    "id": 4,
    "title": "New Thread",
    "message": "Message about thread",
    "creationDate": "2019-08-19T23:10:48.408"
}
```

## Delete

**`DELETE`** /threads/:id

**Response** Code: 200 
 
## Edit

**`PUT`** /threads/:id

```
{
    "title": "New thread",
    "message": "Message about the thread",
    "courseName": "Course Name"
}
```
  
**Response**

```
{
    "id": 2,
    "title": "New thread",
    "message": "Message about the thread",
    "creationDate": "2019-05-05T19:00:00"
}
```

## Get Authorization Token

**`POST`** /auth

```
{
    "email" : "email@email.com",
    "password": "password"
}
```
  
**Response**

```
{
    "token": "token",
    "type": "Bearer"
}
```

## Docker Run

```
docker run
    -p 8080:8080
    -e FORUM_DATABASE_URL='jdbc:h2:mem:springboot-forum'
    -e FORUM_DATABASE_USERNAME=sa
    -e FORUM_DATABASE_PASSWORD=''
    -e FORUM_DATABASE_SECRET=''
    -e SPRING_PROFILES_ACTIVE='prod'
    marcosaraujo/spring-boot-forum
```

## Docker Compose with Spring Boot Admin

```
PORT=8080 
PORT_ADMIN=8081 
FORUM_DATABASE_URL='jdbc:h2:mem:springboot-forum' 
FORUM_DATABASE_USERNAME=sa 
FORUM_DATABASE_PASSWORD='' 
FORUM_DATABASE_SECRET='' 
SPRING_PROFILES_ACTIVE='prod' 
ADMIN_HOST='admin' 
docker-compose up
```
