drop databases if exists Myblog;

create database Myblog;

use Myblog;
drop databases if exists userinfo;
create  table  userinfo(
     id int primary key auto_increment,
     createtime datetime default now(),
     updatetime datetime default now(),
     username varchar(50)  not null,
     password varchar(32) not null,
     state int default 1
);
