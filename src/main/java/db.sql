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

drop table if exists message_session;
create table message_session(
    sessionid int primary key auto_increment,
    lasttime datetime
);

drop table if exists message_session_user;
create table message_session_user(
    sessionid int,
    userid int
);

select sessionid from message_session
where sessionid in
      (select sessionid from message_session_user where userid = 6
       order by lasttime desc);