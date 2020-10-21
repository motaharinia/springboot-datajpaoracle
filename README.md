## Spring Boot Data with JPA-Hibernate ORM and Oracle Database

### Spring Data JPA:
Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.

### JPA (Java Persistence API):
JPA is not a tool or framework; rather, it defines a set of concepts that can be implemented by any tool or framework. While JPA's object-relational mapping (ORM) model was originally based on Hibernate, it has since evolved. Likewise, while JPA was originally intended for use with relational/SQL databases, some JPA implementations have been extended for use with NoSQL datastores. A popular framework that supports JPA with NoSQL is EclipseLink,

### Hibernate ORM:
Hibernate ORM is an object-relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database

### Oracle Database:
Oracle Database is a multi-model database management system produced and marketed by Oracle Corporation. It is a database commonly used for running online transaction processing, data warehousing and mixed database workloads

further references:     
- https://spring.io/projects/spring-data-jpa
- https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
- https://en.wikipedia.org/wiki/Oracle_Database

### Project Descriptions :
please see application.properties files in resources folder and select a active profile "dev" or "com" to run project. you can check test methods too.  
oracle configuration steps:
- download oracle 18 express from : https://drive.google.com/file/d/1sdMKUH9eXfYFyRRYMcYG2-rDc2Nav5Yz/view
- install oracle and in the setup wizard set password:"123456" for "sys" and "system" users
- in windows environment add these variables:
    - ORACLE_HOME = C:\app\MyUser\product\18.0.0\dbhomeXE
    - ORACLE_SID = XE
- execute "C:\app\MyUser\product\18.0.0\dbhomeXE\bin\sqlplus.exe" and enter with "system" and "123456" and run these commands to create motaharinia schema with 123456 password:
    - ALTER SESSION SET CONTAINER = XEPDB1;
    - CREATE BIGFILE TABLESPACE tbsmot_perm_01 DATAFILE 'tbsmot_perm_01.dat' SIZE 20M AUTOEXTEND ON;
    - CREATE TEMPORARY TABLESPACE tbsmot_temp_01 TEMPFILE 'tbsmot_temp_01.dbf' SIZE 20M AUTOEXTEND ON;
    - CREATE USER motaharinia IDENTIFIED BY 123456 DEFAULT TABLESPACE tbsmot_perm_01 TEMPORARY TABLESPACE tbsmot_temp_01 QUOTA 20M on tbsmot_perm_01;
    - GRANT create session TO motaharinia;
    - GRANT create table TO motaharinia;
    - GRANT create view TO motaharinia;
    - GRANT create any trigger TO motaharinia;
    - GRANT create any procedure TO motaharinia;
    - GRANT create sequence TO motaharinia;
    - GRANT create synonym TO motaharinia;
    - GRANT connect TO motaharinia;
    - alter user motaharinia default role all;
    
### IntellliJ IDEA Configurations :
- IntelijIDEA: Help -> Edit Custom Vm Options -> add these two line:
    - -Dfile.encoding=UTF-8
    - -Dconsole.encoding=UTF-8
- IntelijIDEA: File -> Settings -> Editor -> File Encodings-> Project Encoding: form "System default" to UTF-8. May be it affected somehow.
- IntelijIDEA: File -> Settings -> Editor -> General -> Code Completion -> check "show the documentation popup in 500 ms"
- IntelijIDEA: File -> Settings -> Editor -> General -> Auto Import -> check "Optimize imports on the fly (for current project)"
- IntelijIDEA: File -> Settings -> Editor -> Color Scheme -> Color Scheme Font -> Scheme: Default -> uncheck "Show only monospaced fonts" and set font to "Tahoma"
- IntelijIDEA: Run -> Edit Configuration -> Spring Boot -> XXXApplication -> Environment -> VM Options: -Dspring.profiles.active=dev

<hr/>
<a href="mailto:eng.motahari@gmail.com?"><img src="https://img.shields.io/badge/gmail-%23DD0031.svg?&style=for-the-badge&logo=gmail&logoColor=white"/></a>


