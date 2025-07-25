## at-project

#### Java Project for automated testing (UI and API)

### 1. Getting Started

The project can be copied by running the git command:

> **git clone https://github.com/PracticeEugene/at-project**

### 2. Environment requirements

Successful run requires:

Java Development Kit 17 (JDK 17+)

Maven 3+ version should be present on environment in order to develop and/or run the tests

Lombok plugin

* Lombok is used to simplify creating/editing Java POJOs (data models).
* In order to compile Project from IDE Lombok plugin should be installed

### 3. Running tests

   The tests can be simply executed by maven command from at-project project folder:

> mvn clean test

* mvn clean cleans the target folders before test run. It's very important to include this command,
as Allure report tool may include some results from previous runs into the report.

* mvn test is a command for actual test execution. It should usually contain additional parameters,
like type, suite.

 To choose test profile use:

> -Dtype=[test_profile] parameter

The type could be:

* ui [default]
* api

As example, your command may look like:

> mvn clean test -Dsuite='ui-suite.xml'

> mvn clean test -Dsuite='api-suite.xml'

> mvn clean test -Dtype='ui'

> mvn clean test -Dtype='api'

You can run full test suite by the command:

> mvn clean test

### 4. Allure report

   Once automated scripts were executed, module will contain target\allure-results directory

   Content of that directory is used for Allure report generating.

   In order to generate report after run use the next maven command:
   
> mvn allure:report

   For both report generating and opening it in your default web browser use:
   
> mvn allure:serve