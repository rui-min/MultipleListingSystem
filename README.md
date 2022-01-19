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
**You can copy & paste the bold links below to Postman url section. Remember to switch to correct method section in the dropdown menu. Also make sure to replace all url portions wrapped with "{}" with values in proper types. The italic parts in some urls are optional.** 

The backend controller provides following APIs:
1. Get method (read): 
    1. **localhost:8090/api/property/get**  -> return all properties' JSON data from the database
    2. **localhost:8090/api/property/get/id/{Long id}** -> return the specified id property's JSON data in the database
    3. **localhost:8090/api/property/get/type/{String type}_?address={String address}&minPrice={int minPirce}&maxPrice={int maxPrice}_** -> return sepcified type properties' JSON data from the database. There are 16 types in total, corresponding to 16 entity classes under domain directory. {String type} must be one of: Property, Land, Residential, Freehold, CooperativeHome, Condominium, MobileHome, SemiDetached, VacationHome, DetachedHome, FarmHouse, MultiLex, TownHouse, TripleDeckers, Condo, StackedTownHouse 
    4. **localhost:8090/api/property/get/minPrice/{int minPrice}** -> return properties with prices larger than "minPrice"
    5. **localhost:8090/api/property/get/maxPrice/{int maxPrice}** -> return properties with prices smaller than "maxPrice"
    6. **localhost:8090/api/property/get/address/{String address}** -> return properties containing "address" (fuzzy match)

2. Post method (create): **localhost:8090/api/property/post** -> create and add new property to the database and return it. 

3. Put method (update): 
    1. **localhost:8090/api/property/put/id/{Long id}_?address={String address}&price={int price}_** -> update the specified id property's records
    2. **localhost:8090/api/property/put/address/{String address}_?price={int price}_** -> update the specified address property's records(exact match)

5. Delete method (delete): 
    1. **localhost:8090/api/property/delete/id/{Long id}** -> remove the specified id property from the database and return a message if successful
    2. **localhost:8090/api/property/delete/address/{String address}** -> remove properties containing the address from the database and return a message if successful(fuzzy match for the address string)

# About BootStrapData.java
File BootStrapData.java under "/server_property/src/main/java/mls/server_property/bookstrap/" is used for constructing sample database data. You can uncomment the whole file and rerun the project if more data are needed.

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
