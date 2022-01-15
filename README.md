# (Group Project) Mulitiple Listing System Documentation
This is a web application for CRUD operations developed with Java and Spring Boot. There are totally 16 entities in the domain directory(server folder). The backend server("server_property") provides RESTful APIs to the frontend("front_client"). Attention: only backend ("server_property" folder) is currently finished.

# Quick Start
Reload pom.xml with maven, and run ServerPropertyApplication.java under "server_property/src/main/java/mls/server_property/" directory. Assigned port is localhost:8090. There is an example database file exampleData.sql under "/server_property/docs/" directory. You can import it in MySQL workbench as an example.

# APIs
The backend controller provides following APIs:
1. Get method (read): 
    1. **/api/property**  -> return all properties' JSON data in the database
    2. **/api/property/{Long id}** -> return the specified id property's JSON data in the database
    3. **/api/property/ids** -> return the specified ids properties' JSON data in the database
    4. **/api/property/type** -> return sepcified type properties' JSON data in the database. There are 16 types in total, corresponding to 16 entity classes under domain directory. The domain hierarchy is as follows: ![hierarchy](/server_property/docs/domain.jpg)
2. Put method (update): **api/property/{id}** -> update the specified id property's records
3. Post method (create): **api/property/post-record** -> create and add new property to the database
4. Delete method (delete): **api/property/{id}** -> remove the specified id property from the database   

# Demonstration
![showcase](/server_property/docs/demonstration_get3.jpg)

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
