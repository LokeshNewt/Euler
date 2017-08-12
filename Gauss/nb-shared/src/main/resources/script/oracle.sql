create table Country (
CountryId varchar(10) primary key,
NationalId varchar(10),
Name2 varchar(25) not null,
Capital varchar(25) not null,
CreatedDate timestamp,
Currency varchar(30),
isDeveloped char(1),
Population varchar(15),
CallingCode varchar(5)
);