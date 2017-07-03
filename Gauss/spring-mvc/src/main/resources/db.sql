-- oracle
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