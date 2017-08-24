drop database if exists world;

create database world;

use world;

create table Country (
CountryId bigint primary key not null identity(1,1),
NationalId varchar(30),
Name varchar(25) not null,
Capital varchar(25) not null,
CreatedDate datetime2(7) default GETDATE(),
Currency varchar(30),
isDeveloped char(1),
Population FLOAT(10),
CallingCode varchar(5)
);

create table CountryReligion (
CountryId bigint,
ReligionId varchar(20),
percentage numeric(7,4),
primary key(CountryId, ReligionId)
);

create table Religion (
ReligionId varchar(20) primary Key,
God varchar(20) not null,
HolyBook varchar(20),
CreatedDate DateTime2(7),
Name varchar(20) not null,
WorshipPlace varchar(20),
SuperReligion varchar(20),
Type bigint,
Followers varchar(20),
GlobalPopulation varchar(20),
rank int
);