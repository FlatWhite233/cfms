/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/6/16 15:32:27                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists clazz;

drop table if exists clazzfee;

drop table if exists student;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   admin_id             int not null auto_increment,
   admin_name           char(10) not null,
   admin_account        char(20) not null,
   admin_passwd         varchar(50) not null,
   primary key (admin_id)
);

/*==============================================================*/
/* Table: clazz                                                 */
/*==============================================================*/
create table clazz
(
   clazz_id             int not null auto_increment,
   clazz_name           char(10) not null,
   clazz_fee            float not null,
   primary key (clazz_id)
);

/*==============================================================*/
/* Table: clazzfee                                              */
/*==============================================================*/
create table clazzfee
(
   clazzfee_id          int not null auto_increment,
   stu_id               int,
   clazz_id             int,
   clazzfee_time        datetime not null,
   clazzfee_use         varchar(100) not null,
   clazzfee_change      float not null,
   clazzfee_status      int not null,
   primary key (clazzfee_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   stu_id               int not null auto_increment,
   clazz_id             int,
   stu_name             char(10) not null,
   stu_is_manager       int not null,
   primary key (stu_id)
);

alter table clazzfee add constraint FK_Relationship_2 foreign key (stu_id)
      references student (stu_id) on delete restrict on update restrict;

alter table clazzfee add constraint FK_Relationship_3 foreign key (clazz_id)
      references clazz (clazz_id) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_1 foreign key (clazz_id)
      references clazz (clazz_id) on delete restrict on update restrict;

