# SMS_Challenge_App

## This Application contains Two parts Server and Client with Docker compose file to Run
1]SMS-RestApi-Server (Backend)- Implemented using spring boot with MySql and docker.

2]SMS-App-Client (Frontend)-Implemented using Angular version 8 to consume rest APi hosted by above Application.

# Below are Steps to Run application:
## Run SMS RestAPi- Server :

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Go to 'SMS-Challeng-App-RestApi-server' dir and open command terminal or bash terminal
- Make sure you have installed Docker
-use following command to check docker version:
    ```
    docker --version
    
    ```
### Run Below commands to launch server App using docker :
-1->To Build Jar File from docker: ``` mvn clean install -DskipTests ```

-2 ->To Run Docker compose file: ``` docker-compose up  ```

 This will launch your application on http://localhost:8082  port 
 
 -3-> To Launch Swagger UI -> http://localhost:8082/swagger-ui/index.html
 
 ### Use Following REST Api points:
    a.http://localhost:8082/sms/1         # (GET)here 1 is id no to get data by id
    b.http://localhost:8082/sms/getAll       # (GET)to get all records from db
    c.http://localhost:8082/sms/create    # (POST)post record in db data 
    d.http://localhost:8082/sms/update    # (PUT) update record in db
    e.http://localhost:8082/sms/22    # (DELETE) delete record from db by id
    
  
 -4->To Dump Data into MySql Container: ``` docker exec -i 25cab1fd  mysql -usmsuser -psmspassword mysql < backup.sql  ```
 
        -Where:
               `25cab1fd ` is container id
               ` -usmsuser` databse user
               `-psmspassword` databse password 
                `backup.sql`  is sql file path     
        ( In our case this contains in same working dir)
        
         ```Note: This step is failing intermitantly.if you done with your data import on mySql container just point server url in client application inside sms-service.ts file.
                currenly client application is pointed to inMemory data url bcz of step 4.
                ```
           
              
 ## Steps To Run SMS Angular App-Client : 
 
- From Above Downloaded  zip or cloneed repository.
- Go to "SMS-Challange-App-Client" dir and open command terminal or bash terminal
### Run Below commands to launch Angular Client App using docker :
-1->To Build angular project in docker:   ```   docker build -t dockerdev .   ```

-2->To Run Angular project:   ```  docker run -p 8000:4200 dockerdev   ```

This will launch your application on http://localhost:8000  port 


Following tasks are covered in this app:

    a.consumed `http://localhost:8080/sms/getAll` or  in memory url 'api/data' api to get all records.
    b.records shown in tabular form.
    c.custom sorting ( ascending and descending ) of records based on column
    d.added simple date pickers to filter data based on start_date and end_date


 
 
