original project location :
https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/

maven commands :
mvn tomcat7:redeploy
mvn tomcat7:deploy
mvn tomcat7:undeploy

db orcale :

create table role5 (
role_id int primary key,
name varchar(50) default null
);

insert into role5 values (1, 'ROLE_USER');

create table user5 (
user_id int primary key,
username varchar(255) default null,
password varchar(255) default null
);

create table user_role (
user_id int not null,
role_id int not null,
primary key(user_id, role_id)
)

-- mysql
create table role5 (
id int primary key,
name varchar(50) default null);
insert into role values (1, 'ROLE_USER');

create table User (
id int primary key,
username varchar(255) default null,
password varchar(255) default null);

create table user_role (
user_id int not null,
role_id int not null,
primary key(user_id, role_id)
)