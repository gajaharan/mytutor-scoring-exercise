# mytutor-scoring-exercise

## Technologies
* Java 17
* Gradle 7.4

## Build and Run

### How to run tests at root project:
`./gradlew clean test`

### Assumptions:
* The frond end app will call the back end service to get all questionnaire options with the questions and scoring values.
* The front end app will send only the selected "checked/selected" values as a key value pair.
* Scalable and flexible solution that allows to add different types of questions e.g. scoring, free text and different types of questionnaires e.g. single choice, multiple choice.