DROP DATABASE IF EXISTS TASK3;
CREATE DATABASE TASK3;
USE TASK3;
SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';

CREATE TABLE postings
(
	Mat_Doc bigint not null,
    item int,
    Doc_Date varchar(11),
    Posting_Date varchar(11),
    Material_Description varchar(100),
    Quantity int,
    BUn varchar(5),
    Amount_LC float,
    Crcy varchar(5),
    User_Name varchar(20),
    Auth_post tinyint
);

SELECT * FROM postings;

insert into  (Mat_Doc, item, Doc_Date, Posting_Date, Material_Description, Quantity, BUn,  Amount_LC, Crcy, User_Name, Auth_post) values (4977637122, 1, "21.08.2020", "21.08.2020", "DatacablePrimeLineUSB-microUSB1,2мb", -1, "pc", 0.0, "BYN", "PTOPHUNUVICH", 0);



CREATE TABLE logins(
	Application varchar(5),
    AppAccountName varchar(20) not null primary key,
    IsActive tinyint,
    JobTitle varchar(40),
    Department varchar(40));