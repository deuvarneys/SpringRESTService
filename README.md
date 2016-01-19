# SpringRESTService
Back-end Rest Service for various front-end applications


This is a funtioniong backend RESTful service which returns data in the form of json and html to any service that calls it. Currently, it connects to mongo and mysql databases(In the future, it will support transporting data from cms)

Road Map:

- Implement support for having long running/restarting dropped db sessions (Not opening a new session with each transaction)
- [MONGODB] Research and implement transactions/phase two commits for more than one create/update/delete call
- [MYSQL] Implement transactions for operations requiring more than one create/update/delete
- Implement better error handling when returning data from mongodb service
- Implement unit testing
- [CMS] Research and Implement a CMS

Far Down the Road:
- [MYSQL] Convert from xml based to annotation based design
