# ExpenseApi
* This project is used to allows users to track their expenses.
## Framwork and Language use in this Project
* Springboot 
* java
* Hibernate
## Dependencies
* Spring Web
* MySql Database
* lombok
* jpa 
* Spring dev tools 
* validation
## Flow of project
## Create four layers model , service , controller, repository.
### In model layer create user class:-
* In this class used @Entity,@Id,@GenratedValue hibbernate annotation used to create table.
* In controller layer to performe CRUD operatiom by http request.
* In service layer write a business logic of CRUD operation.
* In repository layer exteds jpsRepositor of user class.
### In model layer create another expense class:-
* In this class used @Entity,@Id,@GenratedValue hibbernate annotation used to create table.
* In controller layer to performe CRUD operatiom by http request.
* In service layer write a business logic of CRUD operation.
* In repository layer exteds jpsRepositor of user class.
### validation 
* It will be validate the user model attributes like password, email and username.
* In validation the annotation used @notNull, @valid annotation used to valid @requestBody.
## Constraints:
### User model will have-
* Id
* userName
* email, password.
### Expense model will have-
* Id
* title, discription
* date
* expanse model will mapping with user @ManyToOne relation and @joinColoum is used to join userId is primeryKey.
## Endpoints to provided :-
### User endpoint are:-
* Adduser by @postMapping.
* update userId by @putMapping
* delete user by Id by used of @deleteMapping.
* Get all user by @getMapping
* Get user by Id.
### Expense endpoints are:-
* add expense By @postMapping.
* Update expense by @putMapping.
* delete expense by @ deleteMapping.
* get expense by id @ getMapping.
* fetch all product By date.
