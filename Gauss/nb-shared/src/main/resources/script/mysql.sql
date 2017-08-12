drop database if exists world;

create database world;

use world;

create table Country (
CountryId mediumInt primary key auto_increment,
NationalId varchar(100),
Name varchar(25) not null,
Capital varchar(50) not null,
CreatedDate datetime,
Currency varchar(30),
isDeveloped boolean,
Population float(10,5),
CallingCode varchar(5)
);

create table CountryReligion (
CountryId mediumInt,
ReligionId varchar(20),
percentage float(7,4),
primary key(CountryId, ReligionId)
);

insert into CountryReligion values (1, 'Christian', 61.1);
insert into CountryReligion values (1, 'Buddhist', 2.5);

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