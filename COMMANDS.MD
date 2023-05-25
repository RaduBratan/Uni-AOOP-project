### Commands for setting up and testing the MySQL database

Tutorials:<br />
https://www.vogella.com/tutorials/MySQLJava/article.html
https://www.youtube.com/watch?v=s2EGAzcdK1c

Code:
```
create database uniaoopproject;

use uniaoopproject;

create table developers (
devId int not null auto_increment,
name varchar(50),
email varchar(20),
password varchar(20),
cnp int,
phone int,
birthDate date,
state varchar(10),
county varchar(15),
city varchar(15),
street varchar(30),
postalCode int,
primary key (devId)
);

create table users (
userId int not null auto_increment,
name varchar(50),
email varchar(20),
password varchar(20),
cnp int,
phone int,
birthDate date,
primary key (userId)
);

create table games (
gameId int not null auto_increment,
devId int not null,
name varchar(50),
genre varchar(15),
price int,
downloads int,
averageCompletionTime int,
description varchar(100),
primary key (gameId)
);

create table reviews (
reviewId int not null auto_increment,
userId int not null,
gameId int not null,
text varchar(100),
primary key (reviewId)
);

desc developers;

select * from developers;
```