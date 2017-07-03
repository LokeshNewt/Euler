create database world;

use world;

create table Country (
CountryId varchar(10) primary key,
NationalId varchar(10),
Name varchar(25) not null,
Capital varchar(25) not null,
CreatedDate datetime,
Currency varchar(30),
isDeveloped boolean,
Population varchar(15),
CallingCode varchar(5)
);

insert into Country values('AUS01', '', 'Australia', 'Canberra', '2017-04-21 11:09:21', 'Australian dollar (AUD)'
, null, '24,429,200', '+61');

create table CountryReligion (
CountryId varchar(20),
ReligionId varchar(20),
percentage float(7,4),
primary key(CountryId, ReligionId)
);

insert into CountryReligion values ('AUS01', 'Christian', 61.1);
insert into CountryReligion values ('AUS01', 'Buddhist', 2.5);

create table Religion (
ReligionId varchar(20) primary Key,
God varchar(20) not null,
HolyBook varchar(20),
CreatedDate DateTime,
Name varchar(20) not null,
WorshipPlace varchar(20),
SuperReligion varchar(20),
Type bigint,
Followers varchar(20),
GlobalPopulation varchar(20),
rank int
);

insert into Religion values ('Christian', 'Jesus Christ', 'Bible', '2017-04-22 11:09:21',
'Christianity', 'Church', null, null, '2.3 billion', null, 1);
insert into Religion values ('Buddhist', 'Buddha', '', '2017-04-22 11:09:21',
'Buddhism', '', null, null, '500 million', '7%', 4);