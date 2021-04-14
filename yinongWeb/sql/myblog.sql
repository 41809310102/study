-- 创建数据库
drop database if exists java18blog;
create database java18blog;

-- 注意：不能省略
use java18blog;

-- 创建用户表
drop table if exists userinfo;
create table userinfo(
    id int primary key auto_increment,
    createtime datetime default now(),
    updatetime datetime default now(),
    username varchar(50) not null,
    password varchar(32) not null,
    state int default 1
);

-- 创建文章表
drop table if exists articleinfo;
create table articleinfo(
    id int primary key auto_increment,
    createtime datetime default now(),
    updatetime datetime default now(),
    title varchar(100) not null,
    content text not null,
    rcount int default 1,
    state int default 1,
    uid int not null
);


-- 插入测试数据
insert into userinfo(id,username,password) values(1,'admin','123');

insert into articleinfo(title,content,uid)
    values('喜迎西安十四运1','内容：喜迎西安十四运1',1),
    ('喜迎西安十四运2','内容：喜迎西安十四运2',1);