create database if not exists onlinechat;
use onlinechat;
drop table if exists user;
create table if not exists user(
	userid int not null auto_increment,
	username varchar(20) not null,
	password varchar(20) not null,
    email varchar(50) not null,
    phone varchar(20) not null,
	primary key(userid)
);

insert into user values(null,'anmory','lmjnb666','anmory@qq.com','19395205012');