In this demo, you demonstrate the how to define a JDBC connection pool and
a JDBC resource (data source), and create a web application that uses a JDBC
resource.

The DatabaseDemo project contains the working soccer league project. However,
before deploying and running the application, you must create the following
resources:

1. A JDBC connection pool with the following properties:

Pool Name: leaguePool
Resource Type: javax.sql.DataSource
Vendor: Derby
DataSource Classname: org.apache.derby.jdbc.ClientDataSource
ServerName: localhost
Port Number: 1527
DatabaseName: league
user: public
Password: public

2. A JDBC resource with the following properties:

JNDI Name: jdbc/leagueDB
Connection Pool Name: leaguePool
Enabled: True

Once you have configured the resources on the Application Server, you can
open the Database project.

First, you can open the sl314.model.LeagueService and sl314.model.LeagueDAO
classes to demonstrate how the DAO object is implemented to work with a
data source. You should point out the JNDI lookup code used in the DAO.

Next, you can open the web.xml descriptor to demonstrate how the web
application knows about the JDBC resource through a resource reference.

You should also open the sun-web.xml to point out the mapping between the
resource reference in web.xml and the physical JNDI name of the JDBC resource.

Once you have deployed the application, you can access the web application by
opening a browser and accessing the following URL:

http://localhost:8080/soccer

