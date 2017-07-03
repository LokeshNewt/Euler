drop database company if exists;
create database company;
use company;
create table Employee (
   employeeId BIGINT primary key,
   firstName varchar(20),
   lastName varchar(20),
   product varchar(50),
   messageSid BIGINT,
   exclusionFlag char(1) ,
   createdDTTM DateTime,
   updatedDTTM datetime
 );

 insert into Employee values (101, 'kate', 'perry', 'Prism', 1, 'N', '2016-10-12 10:34:45', '2016-10-12 10:34:45');
 insert into Employee values (102, 'kate', 'perry', 'Prism', 1, 'N', '2016-10-12 10:34:45', '2016-10-12 10:34:45');
 insert into Employee values (103, 'kate', 'perry', 'Prism', 1, 'N', '2016-10-12 10:34:45', '2016-10-12 10:34:45');
 insert into Employee values (104, 'kate', 'perry', 'Prism', 1, 'N', '2016-10-12 10:34:45', '2016-10-12 10:34:45');
 insert into Employee values (105, 'kate', 'perry', 'Prism', 1, 'N', '2016-10-12 10:34:45', '2016-10-12 10:34:45');

 create table Message (
   messageSid bigint primary key,
   dataSource varchar(99)
 );

 insert into Message values (1, 'news');

 create table EmpAddress (
   addressId bigint primary key,
   empId bigint not null,
   street varchar(50),
   city varchar(50),
   state varchar(50),
   country varchar(50),
   createdDate datetime
 );

insert into EmpAddress values (34, 101, 'Jal vayu', 'LA', 'Nevada', 'US', '2016-10-12 10:34:45');
insert into EmpAddress values (35, 102, 'Jal vayu', 'LA', 'Nevada', 'US', '2016-10-12 10:34:45');
insert into EmpAddress values (36, 103, 'Jal vayu', 'LA', 'Nevada', 'US', '2016-10-12 10:34:45');

CREATE TABLE Product (
    productId BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    primaryClient VARCHAR(50),
    clientCount NUMERIC,
    lastRelease VARCHAR(50)
);

insert into Product values (51, 'Prism', null, '4', '2.0');

 create table EmployeeProduct (
    productId bigint not null,
    employeeId bigint not null,
    createdDTTM datetime,
    primary key (productId, employeeId)
 );

 insert into EmployeeProduct values (51, 102, '2016-10-10 12:34:45');