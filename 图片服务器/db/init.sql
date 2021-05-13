drop database if exists image_system;
create database image_system character set utf8mb4;
use image_system;

drop table if exists `image_table`;
create table `image_table`(image_id int not null primary key auto_increment,
                          image_name varchar(50),
                          size bigint,
                          upload_time varchar(50),
                          md5 varchar(128),
                          content_type varchar(50) comment '图片类型',
                          path varchar(1024) comment '图片所在路径')