My Environment:
===============================================

1. Maven
2. JDK 1.8
3. STS
4. Tomcat 1.7


Major Dependencies of Project:
===============================================

1. Spring 4.0.7.RELEASE
2. Spring Security 3.2.5.RELEASE
3. Spring Security Oauth2 1.0.5.RELEASE
4. Spring JDBC 4.1.6
5. mysql-connector-java 5.1.18


Database Configuration
===============================================
### Import SQL file into MySQL
	$ create database oauthDB ; 
	
	$ sudo mysql -uroot -p oauthDB  < oauthDB.sql



### Setting  spring-database.xml
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/oauthDB" />
		<property name="username" value="root" />
		<property name="password" value="P@ssw0rd" />
	</bean>

Changing password of mysql.
Replacing P@ssw0rd with yours.


### Setting spring-security.xml
	<jdbc-user-service data-source-ref="dataSource" 
	 users-by-username-query="select username,password, enabled from users where username=?"
	 authorities-by-username-query="select username,role from users where username=?  "/> 
				 
If you modify the structure of oauthDB, remember to modify this.


Cannot Access Resource without Access Token
===============================================================
<http://localhost:8080/spring4mvc-oauth2.0-server-db/api/users/>

Let's get access_token for accessing resource.

Get Access Token
===============================================================
<http://localhost:8080/spring4mvc-oauth2.0-server-db/oauth/token?grant_type=password&username=lucasko&password=luc@s1234&client_id=abcd-clientid-lucasko-12345&client_secret=1234-secret-test>

{"access_token":"714fe7e2-a746-44f1-921b-26e964bfa8d0","token_type":"bearer","refresh_token":"5a78534e-599b-4045-a759-41d93ca57f78","expires_in":114}


Access Resource with Access Token (Replace acces_token with new one):
===============================================================
<http://localhost:8080/spring4mvc-oauth2.0-server-db/api/users?access_token=714fe7e2-a746-44f1-921b-26e964bfa8d0>

[{"id":1,"name":"user001","email":"user001@example.com","phone":"0123456789"},{"id":2,"name":"user002","email":"user002@example.com","phone":"9876543210"},{"id":3,"name":"user003","email":"user003@example.com","phone":"0000000000"}]

