-- The create_database.sql script creates a database, adds some tables to it and prepopulates some of the tables.

-- To run the script from the command line:

-- 1. Set the DERBY_HOME environment variable to point to the JavaDB installation included with GlassFish.
--    The value of this variable should be [glassfish installation directory]/javadb, for example,
--    /home/username/glassfish-v3-b71/javadb, the exact value will vary depending on the exact version of
--    GlassFish installed and the exact location where GlassFish was installed.
-- 2. run [glassfish installation directory]/bin/asadmin start-database 
-- 3. Change directory to [glassfish installation directory]/javadb/bin
-- 4. Execute the following command:
--    ./ij

--    You should now be executing ij, a command line sql interpreter included with JavaDB.

-- 5. Type the following in ij:
--    run '/path/to/script/create_database.sql';
-- 6. type quit; at the ij prompt.

--    The database and tables should have been created.

-- Note: Before creating the connection pool and datasource the domain should be running.
-- This can be accomplished by entering the following command:
--    "./asadmin start-domain domain1" at the [glassfish installation directory]/glassfish/bin directory
-- (assuming we are using the default domain called domain1).
    
-- To create the connection pool:

-- The connection pool can be created by executing the following steps:

-- 1. Change directory to [glassfish installation directory]/bin.
-- 2. Execute the following command (without the quotes):
--    "./asadmin create-jdbc-connection-pool --datasourceclassname org.apache.derby.jdbc.ClientDataSource --restype javax.sql.DataSource --property DatabaseName=customerdb:User=dev:password=dev CustomerDBPool"

-- To create the datasource:

-- The datasource can be created graphically like explained in chapter 1 or by executing the following steps:

-- 1. Change directory to [glassfish installation directory]/glassfish/bin.
-- 2. Execute the following command (without the quotes):
--    "./asadmin create-jdbc-resource --connectionpoolid CustomerDBPool jdbc/__CustomerDBPool"
   
-- After following all of the above steps. Examples using database connectivity should deploy and execute properly.

-- Create the database and connect to it.
connect 'jdbc:derby://localhost:1527/simplewebdb;create=true';

-- Add a user to the database, username simple, password simple
call syscs_util.syscs_set_database_property('derby.user.simple','simple');

-- Grant all privileges to user simple
call syscs_util.syscs_set_database_property('derby.database.fullAccessUsers','simple');

-- Disconnect from the newly created database
disconnect;

-- Reconnect to the newly created database as user simple
connect 'jdbc:derby://localhost:1527/simplewebdb;user=simple;password=simple';

-- Create tables
create table USERS (USER_ID int primary key, FIRST_NAME varchar(60), LAST_NAME varchar(60), EMAIL varchar(60));

-- Create sequence for the USERS table
create sequence SEQ_USERS minvalue 1 maxvalue 99999999 start with 1 increment by 1;