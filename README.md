# (Group Project) Mulitiple Listing System Documentation
* This is a web application simulating a property listing system with CRUD operations. A good business example is https://www.realtor.ca/. 
* There are totally 16 entities under /server_property/src/main/java/mls/server_property/domain directory, forming a single inheritance tree(see below graph). The backend server("server_property") provides RESTful APIs to the frontend("front_client"). 

![hierarchy](/server_property/docs/domain.jpg)
* Attention: only the server (backend in "server_property" folder) is currently finished.

# Preparation before running
* Get an IDE: Any IDE that can code Java, obtain Maven and Spring Framework plugins is accpetable. I use IntelliJ Ultimate: https://www.jetbrains.com/idea/download/
* Get and Configure MySQL database: application.properties & pom.xml are configured with MySQL. Download MySQL server and workbench from: https://dev.mysql.com/downloads/. **Attention**: open the application.properties file under "/server_property/src/main/resources/" and make sure lines 3-5 conform with your local MySQL's configuration (localhost port, username, password). You can change the lines or change your local MySQL settings (do NOT change the "/realproperty" part in line 3 if you want to follow below step).
* Import sample MySQL database file: for testing purpose, a sample .sql file "server_property/docs/exampleData.sql" can be imported with MySQL workbench. Note the file's schema name is "realproperty", which is configured in line 3 of application.properties.
* Get Postman for testing APIs: download Postman from https://www.postman.com/downloads/. Need to create an account or login.

# Quick Start
* Ensure the whole repo is cloned or downloaded and unzipped. Open as a project in your IDE and reload Maven file pom.xml. Then run _ServerPropertyApplication.java_ under "server_property/src/main/java/mls/server_property/" directory.
* Open MySQL server and MySQL workbench. Ensure MySQL database is running and sample data is imported (see above "preparation" section). If you want to create data from scratch, see applicatoin.properties file configuration. Assigned schema name is "realproperty".
* Assigned API port is localhost:8090, which can be changed in application.properties. Now open postman, and you can test all APIs shown in below section.
* Below is my demonstration:

![showcase](/server_property/docs/demonstration_get3.jpg)

# APIs
The backend controller provides following APIs:
1. Get method (read): 
    1. **/api/property**  -> return all properties' JSON data in the database
    2. **/api/property/{Long id}** -> return the specified id property's JSON data in the database
    3. **/api/property/ids** -> return the specified ids properties' JSON data in the database
    4. **/api/property/type** -> return sepcified type properties' JSON data in the database. There are 16 types in total, corresponding to 16 entity classes under domain directory. The domain hierarchy is as follows: 
2. Put method (update): **api/property/{id}** -> update the specified id property's records
3. Post method (create): **api/property/post-record** -> create and add new property to the database
4. Delete method (delete): **api/property/{id}** -> remove the specified id property from the database   

# Special Thanks
A special thanks to a wonderful senior: @constantlyTiTi. Without her help, this project would definitely become much more difficult.

# References
1. Spring Documentation
*https://spring.io/projects*
2. Stackoverflow Answers(one example)
*https://stackoverflow.com/questions/1958621/whats-an-aggregate-root*
3. Youtube Videos(one example)
*https://www.youtube.com/watch?v=35EQXmHKZYs*
4. Wikipedia(one example)
*https://en.wikipedia.org/wiki/Hibernate_(framework)*
5. Other websites(one example)
*https://medium.com/analytics-vidhya/jpa-hibernate-entity-inheritance-1f6aa7ea2eea*
