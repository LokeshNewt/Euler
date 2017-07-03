
create table Employee (employeeId BIGINT auto_increment primary key, firstName varchar, lastName varchar, product varchar, messageSid BIGINT,
exclusionFlag boolean , createdDTTM datetime, updatedDTTM datetime );

create table Message (MessageSid integer PRIMARY KEY not null , dataSource varchar);

-- for sql
-- create database company
-- use company
--
-- create table Employee (
--   employeeId BIGINT primary key Identity(1,1),
--   firstName varchar(20),
--   lastName varchar(20),
--   product varchar(50),
--   messageSid BIGINT,
--   exclusionFlag char(1) ,
--   createdDTTM datetime2(7),
--   updatedDTTM datetime2(7)
-- )
--
-- create table Message (
--   messageSid bigint primary key,
--   dataSource varchar(99)
-- )

-- create table EmpAddress (
--   addressId bigint primary key identity(1,1),
--   empId bigint not null,
--   street varchar(50),
--   city varchar(50),
--   state varchar(50),
--   country varchar(50),
--   createdDate varchar(50)
-- )

-- for mysql
-- create database company
-- use company
--
-- create table Employee (
--   employeeId BIGINT primary key auto_increment,
--   firstName varchar(20),
--   lastName varchar(20),
--   product varchar(50),
--   messageSid BIGINT,
--   exclusionFlag char(1) ,
--   createdDTTM Date,
--   updatedDTTM Date
-- )
--
-- create table Message (
--   messageSid bigint primary key,
--   dataSource varchar(99)
-- )

 create table EmpAddress (
   addressId bigint primary key,
   empId bigint not null,
   street varchar(50),
   city varchar(50),
   state varchar(50),
   country varchar(50),
   createdDate varchar(50)
 );

create table Product (
   productId bigint primary key,
   name bigint not null,
   primaryClient varchar(50),
   clientCount numeric,
   lastRelease varchar(50)
 );

 create table EmployeeProduct (
     productId bigint not null,
     employeeId bigint not null,
     createdDTTM datetime,
     primary key (productId, employeeId)
  );