# ucsb-courses-search

A project to:
* first build a clone of the page <https://my.sa.ucsb.edu/public/curriculum/coursesearch.aspx>
* then build many additional features using the same data.


| Type this | to get this result |
|-----------|------------|
| `mvn package` | to make a jar file|
| `mvn spring-boot:run` | to run the web app|
| in browser: `http://localhost:8080/greeting/` | to see "Hello, World!" |
| in browser: `http://localhost:8080/greeting?name=Gauchos` | to see "Hello, Gauchos!"

# Using Curl for database
* Reqirements: Postgres Installed and running on your machine
* Details for specific machine can be fonud [here](https://www.postgresql.org/download/)


To add user to tutor list:
`curl -d "id=1&fname=phil&lname=conrad&email=pconrad@example.org" -X POST http://localhost:8080/tutors`


To add user to Course Offerings List
`curl -d "id=1&course=CS56&quarter=W19&instructor=pConrad" -X POST http://localhost:8080/courseOfferings/add`