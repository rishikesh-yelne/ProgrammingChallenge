## Machado Lab Programming Challenge
Challenge Link : (https://github.com/machado-lab/programming-challenge)

Hi! This is a single-page Web Application developed to view the population and movement of animal species via Ag-Grid tables.

**Technologies Used :** Java Springboot, PostgreSQL, Angular, HTML, CSS, Typescript, Bootstrap.

**Author :** Rishikesh Pravin Yelne

## About the Application
The Application is a single-page web application and all activities are asynchronously performed, ie. the whole page is not refreshed/reloaded. Following are the main activities:
1. Population
- List of all premises is loaded in an Ag-Grid which shows all details about the Premise.
- Details include: Name, Address, City, State, Postal Code, Latitude & Longitude.
- The grid also contains the current total count of animals present at the premise.
2. Movement
- List of all movement records is loaded in an Ag-Grid which shows all movement related details.
- Details include: Company Name, Species, Reason, Moved Count, Start Date, Origin Premise Id & Destination Premise Id.
- A provision to add a movement record is provided within the component, which adds a row within the grid (without reloading the webpage or the whole grid).

## Pre-Requisites
1. **Java**:
- For the backend, Java is required to be installed on the system.
- Installation link is available [here](#resources-used) in **Backend/Java Springboot** section. <br />
- Ensure that the ```JAVA_HOME``` environment variable is configured. <br />
- To check if Java has been installed correctly on the system, run the following command on cmd. <br />
    ```console
    java -version
    ```
2. **Maven**:
- Maven needs to be installed to run the command which would publish the web application on localhost. <br />
- Installation link is available [here](#resources-used) in **Backend/Java Springboot** section. <br />
- You can download the zip file, unzip it and paste it in the Program Files folder. <br />
- Additionally, add the path of bin folder to the ```PATH``` environment variable. <br />
- To check if Maven has been installed correctly on the system, run the following command on cmd. <br />
    ```console
    mvn -v
    ```    
3. **Node.js**:
- Node.js needs to be installed to run the Angular application on the system. <br />
- Installation link is available [here](#resources-used) in **Frontend/Node.js** section. <br />
- To check if Node.js has been installed correctly on the system, run the following command on cmd. <br />
    ```console
    node -v
    npm -v
    ```
- Along with Node.js, Angular CLI needs to be installed as well. <br />
- To install Angular CLI, run the following command in cmd (After installation of Node and NPM). <br />
    ```console
    npm install -g @angular/cli
    ```
- To check if CLI has been installed correctly on the system, run the following command on cmd. <br />
    ```console
    ng v
    ```
4. **PostgreSQL**:
- PostgreSQL needs to be installed on the system to run the script file provided [here](https://github.com/rishikesh-yelne/ProgrammingChallenge/blob/master/db-scripts.psql). <br />
- Installation link is available [here](#resources-used) in **Backend/PostgreSQL** section. <br />
- Additionally, add the path of bin folder to the ```PATH``` environment variable. <br />
- To check if PostgreSQL has been installed correctly on the system, run the following command on cmd. <br />
    ```console
    psql --version
    ```
- After successful installation of PostgreSQL, execute the following script in cmd. <br />
    ```console
    psql -h localhost -d postgres -U postgres -p 5432 -a -q -f <Local_Repo_Location>/ProgrammingChallenge/db-scripts.psql
    ```
> **Please note**: You might be prompted to provide the password for postgres user in cmd to execute the script.

> **Please note**: Replace <Local_Repo_Location> with the file path at which this GitHub repository has been cloned.
- Before running the application, modify the [application.properties](https://github.com/rishikesh-yelne/ProgrammingChallenge/blob/master/prog-challenge-backend-java/src/main/resources/application.properties) file with the password configured for ```postgres``` username
```.properties
...
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres //modify the password here
...
```   

## Run the application
To run the application, following commands are required to be executed
```console
cd <Local_Repo_Location>/ProgrammingChallenge/prog-challenge-backend-java
mvnw spring-boot:run
```
After the backend is up and running
```console
cd <Local_Repo_Location>/ProgrammingChallenge/prog-challege-frontend-angular
npm install
ng serve --open
```
> **Please note**: Replace <Local_Repo_Location> with the file path at which this GitHub repository has been cloned.

## Resources Used
- **Backend**
    - **Java Springboot**
        - [Java Installation](https://www.oracle.com/java/technologies/downloads/#jdk18-windows)
        - [Initialize Springboot application](https://start.spring.io/) 
        - [Maven Download](https://maven.apache.org/download.cgi)
        - [Maven Installation Steps](https://maven.apache.org/install.html)
        - [Eclipse IDE](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers)
    - **PostgreSQL**
        - [Download Setup](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
        - [pgAdmin Download](https://www.pgadmin.org/download/pgadmin-4-windows/)
        - [Documentation](https://www.postgresql.org/docs/14/index.html)
    - **Postman** - [Download Setup](https://www.postman.com/downloads/)
- **Frontend**
    - **Node.js** 
        - [Download Setup](https://nodejs.org/en/download/)
        - [Documentation](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
    - **Angular** - [Documentation](https://angular.io/docs)
    - **Ag Grid - Angular** - [Documentation](https://www.ag-grid.com/angular-data-grid/getting-started/)
    - **Bootstrap** - [Documentation](https://getbootstrap.com/docs/4.0/getting-started/introduction/)
    - **Icons** 
        - [NCSU Icons](https://brand.ncsu.edu/downloads/)
        - [Standard Icons](https://github.com/simple-icons/simple-icons)

## Application Demo
The [Demo](https://github.com/rishikesh-yelne/ProgrammingChallenge/tree/master/demo) folder contains the screen recording of the application to demonstrate the various features of the application.
