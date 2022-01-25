**Assigned Date:2022/01/25** &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; **Due Date:2022/01/26**
# Assignment 10

## JDBC

The Java Database Connectivity (JDBC) API is the industry standard for database-independent connectivity between the Java programming language and a wide range of databases SQL databases and other tabular data sources, such as spreadsheets or flat files. 

### Connection(Interface)
A connection (session) with a specificdatabase. SQL statements are executed and results are returnedwithin the context of a connection. 
### DriverManager
The basic service for managing a set of JDBC drivers. 
`DriverManager.getConnection(url)`Attempts to establish a connection to the given database URL.The DriverManager attempts to select an appropriate driver fromthe set of registered JDBC drivers. 
### Statement
The object used for executing a static SQL statementand returning the results it produces. 

## MYSQL
<table>
<tr>
<td>Task</td>
<td>Syntax</td>
</tr>
<tr>
<td>Create a Database</td>
<td>CREATE DATABASE database_name;</td>
</tr>
<tr>
<td>Select Database</td>
<td>USE database_name;</td>
</tr>
<tr>
<td>Create Table</td>
<td>CREATE TABLE students (column datatype,column2 datatype,<br/>column3 datatype,column4 datatype,column5 datatype);</td>
</tr>
<tr>
<td>Create Record</td>
<td>INSERT INTO students (`column1`,`column2`,`column3`,`column4`)<br/> VALUES('value1','value2','value3','value4');</td>
</tr>
<tr>
<td>Read Data</td>
<td>SELECT * FROM table_name;</td>
</tr>
<tr>
<td>Update Table</td>
<td>UPDATE table_name SET column = 'value' where column='value';</td>
</tr>
<tr>
<td>Delete Data</td>
<td>DELETE FROM table_name WHERE column = 'value';</td>
</tr>
</table>

## Set Classpath
### Temporary Method
set classpath=path\mysql-connector-java-8.0.24.jar;.;
