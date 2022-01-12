# Personal-Java-Database
Functional database created from scratch using Java. This database uses the SQL syntax to create and insert values into a table, implementing a web connection using socket programming, a simple query parsing mechanism, and a simple pager to store the data with associated meta-data

This program to house data in a database similar to MySQL or SQLLite was tested using JUnit testing in the file DBTest.java.
Type in the ip address in Connection.java that corresponds to where you are running the database-server.

To run program install the files and run the Controller.java 

Type javac ./Controller.java followed by ./java Controller

This will run the database-server connection side of the program. 

To test out querying, run Connection.java

Type javac ./Connection.java followed by ./java Connection

After the client has connected to the server the client can query by creating a table or inserting information, for example
"CREATE TABLE chat ( INTEGER id DOUBLE people STRING data )" or "INSERT INTO TABLE chat ( people d data s ) VALUES ( 100 TestingOut )"
