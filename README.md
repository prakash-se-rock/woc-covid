# woc-covid
1. Download woc-covid project in your local
2. Open the project in eclipse or any Java IDE
3. Execute woc-covid/sql-patch/database.sql and then woc-covid/sql-patch/data.sql in mysql db
4. Update the application.properties for db steps 
server.port=8321 // you can add any free port defaul would be 8080
#mysql database configuration
#spring.jpa.hibernate.ddl-auto=validate
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/woc_covid
spring.datasource.username=root
spring.datasource.password=mani@mysql

#spring.profiles.active=qa

spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
5. woc-covid/src/main/com/woc/bms/WOCCovidApplication.java -> run as java application
6. open browser and run - http://localhost:8321/
