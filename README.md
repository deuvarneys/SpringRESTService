# SpringRESTService
Back-end Rest Service for various front-end applications

This project is can be ran using either Docker or Docker-Compose

To start this project, run:
$ docker-compose build && docker-compose up

This is a funtioniong backend RESTful service which returns data in the form of json and html to any service that calls it. Currently, it connects to mongo and mysql databases(In the future, it will support transporting data from cms)

Road Map:
- (IMPLEMENTED) Create jar file for easy springboot deployment
- Implement support for having long running/restarting dropped db sessions (Not opening a new connection with each transaction)
- [MONGODB] Research and implement transactions/phase two commits for more than one create/update/delete call
- (STARTED) [MYSQL] Implement transactions for operations requiring more than one create/update/delete
- Implement better error handling when returning data from mongodb service
- (STARTED) Implement unit testing
- [CMS] Research and Implement a CMS
- Switch from Maven to Gradle project build

Far Down the Road:
- [MYSQL] Convert from xml based to annotation based design
