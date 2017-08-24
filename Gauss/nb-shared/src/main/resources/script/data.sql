insert into Country(NationalId, Name, Capital, Currency, isDeveloped, Population, CallingCode)
values('CommonWealth of Australia', 'Australia', 'Canberra', 'Australian dollar (AUD)'
, null, 24.429, '+61');
insert into Country values(null, 'Russian Federation', 'Russia', 'Moscow', '2017-04-21 11:09:21', 'Russian ruble (RUB)'
, null, 144.463, '+7');
insert into Country values(null, 'PRC', 'China', 'Beijing', '2017-04-21 11:09:21', 'Renminbi (CNY)'
, null, 1373.541, '+86');
insert into Country values(null, 'FRB', 'Brazil', 'Brasilia', '2017-04-21 11:09:21', 'Real (R$) (BRL)'
, null, 207.350, '+55');
insert into Country values(null, 'RSA', 'South Africa', 'Pretoria,Bloemfontein,Cape Town', '2017-04-21 11:09:21', 'South African rand (ZAR)'
, null, 54.956, '+55');

insert into CountryReligion values ('AUS01', 'Christian', 61.1);
insert into CountryReligion values ('AUS01', 'Buddhist', 2.5);

insert into Religion values ('Christian', 'Jesus Christ', 'Bible', '2017-04-22 11:09:21',
'Christianity', 'Church', null, null, '2.3 billion', null, 1);
insert into Religion values ('Buddhist', 'Buddha', '', '2017-04-22 11:09:21',
'Buddhism', '', null, null, '500 million', '7%', 4);