Coverage: 89.2%
# Fundamental Project: To-Do List Web Application (TDL)

To create an OOP-based web application, with utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during training .Specifically, I created a full-stack web application following the Enterprise Architecture Model, using:
•	an application back-end developed using the language from my Programming Fundamentals module (e.g. Java)
•	a managed database hosted locally or within the Cloud Provider examined during my Cloud Fundamentals module (e.g. MySQL in GCP)
•	a front-end developed using the language from my Front-End Web Technologies module (e.g. JavaScript)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Prerequisites

What things you need to install the software and how to install them

[Git download.](https://git-scm.com/downloads)

[Eclipse download.](https://www.eclipse.org/downloads/)

[Visual Studio Code download.](https://code.visualstudio.com/Download)


### Installing

A step by step series of examples that tell you how to get a development env running

Copy this project url: https://github.com/simonwhiteQA/TDL-PROJECT.git
* Open Git bash
* Git clone the project url to your workspace.
* Open Eclipse IDE
* The maven project should now be available for development and testing 

* Run the executable .jar file 
* Open visual studio code
* Open folder "TDL-PROJECT"
* Open live server from index.html file
* Interact with front end of web application


## Running the tests

Running automated tests:

*Unit Tests*: Right click TDL-PROJECT/src/test/java/com.qa.spring.service in Eclipse -> coverage as -> junit test
This will return all the unit tests and the coverage the tests cover for the system.

*Integration tests*: Right click TDL-PROJECT/src/test/java/com.qa.spring.rest in Eclipse -> run as -> junit test
This will return all the integration tests and the coverage the tests cover for the system.

*Selenium tests*: Right click TDL-Selenium/src/selenium.tests in Eclipse -> run as -> junit test
This will return all the front end tests for selenium to run.
It has been included in a seperate project folder as it is not dependent on the TDL-PROJECT folder.


## Deployment

After *cloning* the repository to Git you will be able to run the TDL application on command line via the jar file:
* Eclipse -> right click project file -> properties -> location (show in system explorer) -> right click -> git bash here
-> cd target -> java -jar jar[FileNameIncludingDependencies].jar 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Simon White** -  [simonwhite](https://github.com/simonwhiteQA)
* Jira [TDL](https://simonwhite.atlassian.net/jira/software/projects/TDL/boards/5/backlog)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

I would like to thank Jordan Benbelaid and Savannah Vaithilingam for their continued help throughout the process of developing this web application. Also, thanks to all the trainers involved in the training weeks upcoming to this project to ensure I was prepared to tackle the task efficiently.

I would like to further my thanks to Niall Duggan and Megan Crouch for their support as part of Team 4 to give assistance when blockers occured.
