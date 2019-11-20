# ucsb-courses-search

A project to:
* first build a clone of the page <https://my.sa.ucsb.edu/public/curriculum/coursesearch.aspx>
* then build many additional features using the same data.


| Type this | to get this result |
|-----------|------------|
| `mvn package` | to make a jar file|
| `mvn -P localhost spring-boot:run` | to run the web app on localhost using H2 in memory database, with seed data |

The `-P localhost` flag uses the `localhost` *profile` defined in the `pom.xml`

This means that you will NOT get the extra `postgres` and `jdbc` dependencies, and as a result, SQL operations will use an
in-memory H2 database.

The property files are divided as follows:

| Property File | Properties defined |
|--|--|
| `/src/main/resources/application.properties` | Always |
| `/src/main/config/localhost/localhost.properties` | Only when `-P localhost` is passed to `mvn` |
| `/src/main/config/localhost/heroku.properties` | Only when `-P heroku` is passed to `mvn` |

To ensure that you get a build that uses the `heroku` profile when running on Heroku, you need to specify this in the `Procfile`.

# Using Curl to force CRUD opeations, when running on localhost

The following operations can be used to insert data into the application when running locally.   This does a `POST` request directly
to the endpoint, putting the needed data into the fields.

To add user to tutor list:
`curl -d "id=1&fname=phil&lname=conrad&email=pconrad@example.org" -X POST http://localhost:8080/tutors`

To add user to Course Offerings List
`curl -d "id=1&course=CS56&quarter=W19&instructor=pConrad" -X POST http://localhost:8080/courseOfferings/add`

To add time slot to Time Slot List
`curl -d "id=1&startTime=04:00PM&endTime=06:00PM" -X POST http://localhost:8080/timeSlots/add`