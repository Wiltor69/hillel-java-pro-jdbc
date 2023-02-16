 create database Hillelhomeworks;
use Hillelhomeworks;
create table Homework(
id int primary key auto_increment,
name varchar (50),
 description varchar(150)
);
create table Lesson(
id int primary key auto_increment,
 name varchar (50),
updatedAt varchar(150),
homework_id int unique,  foreign key (homework_id) references Homework(id)  
 );
show tables;
use Hillelhomeworks;
select * from Lesson;
INSERT INTO Homework (name, description) VALUES('OOP', 'Think');
select * from Homework;
select * from Lesson;
INSERT INTO Homework (name, description) VALUES('Jdbc', 'I always think');
select * from Homework;
select * from Lesson;
