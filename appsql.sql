/*
SQLyog v10.2 
MySQL - 5.0.27-community-nt : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `demo`;

/*Table structure for table `alarm_type` */

DROP TABLE IF EXISTS `alarm_type`;

CREATE TABLE `alarm_type` (
  `alarm_id` int(11) NOT NULL auto_increment,
  `alarm_code` varchar(255) collate utf8_bin default NULL,
  `alarm_type` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`alarm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `alarm_type` */

/*Table structure for table `camera` */

DROP TABLE IF EXISTS `camera`;

CREATE TABLE `camera` (
  `cameraid` int(11) NOT NULL,
  `camera_name` varchar(255) collate utf8_bin NOT NULL,
  `manufacturer` varchar(255) collate utf8_bin NOT NULL,
  `model` varchar(255) collate utf8_bin NOT NULL,
  `serial_number` varchar(255) collate utf8_bin NOT NULL,
  `url` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`cameraid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `camera` */

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `deviceid` bigint(20) NOT NULL,
  `address` varchar(255) collate utf8_bin NOT NULL,
  `country` varchar(255) collate utf8_bin default NULL,
  `device_name` varchar(255) collate utf8_bin NOT NULL,
  `postcode` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device` */

insert  into `device`(`deviceid`,`address`,`country`,`device_name`,`postcode`) values (1,'1',NULL,'1','1'),(2,'2',NULL,'4','4'),(3,'3',NULL,'4','4'),(4,'1',NULL,'1','1'),(5,'1',NULL,'1','1'),(6,'1',NULL,'1','1'),(7,'1',NULL,'1','1'),(8,'1',NULL,'1','1'),(9,'1',NULL,'1','1'),(10,'1',NULL,'1','1'),(11,'china beijing','SG','device11','123');

/*Table structure for table `device_camera` */

DROP TABLE IF EXISTS `device_camera`;

CREATE TABLE `device_camera` (
  `cameraid` int(11) default NULL,
  `deviceid` bigint(20) NOT NULL,
  PRIMARY KEY  (`deviceid`),
  KEY `FKox52qo5eld1krkuwdojdg7vk8` (`cameraid`),
  CONSTRAINT `FK9kml7e3o4qrkfsvhgpsitaqpa` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FKox52qo5eld1krkuwdojdg7vk8` FOREIGN KEY (`cameraid`) REFERENCES `camera` (`cameraid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_camera` */

/*Table structure for table `device_manufacturer` */

DROP TABLE IF EXISTS `device_manufacturer`;

CREATE TABLE `device_manufacturer` (
  `manufacturer_id` int(11) default NULL,
  `deviceid` bigint(20) NOT NULL,
  PRIMARY KEY  (`deviceid`),
  KEY `FKkr4guledrbsqkg5ys9wnm89r7` (`manufacturer_id`),
  CONSTRAINT `FKbp43dq63jo5kfxd2c9b1j8u2m` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FKkr4guledrbsqkg5ys9wnm89r7` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_manufacturer` */

insert  into `device_manufacturer`(`manufacturer_id`,`deviceid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11);

/*Table structure for table `device_model` */

DROP TABLE IF EXISTS `device_model`;

CREATE TABLE `device_model` (
  `model_id` int(11) default NULL,
  `deviceid` bigint(20) NOT NULL,
  PRIMARY KEY  (`deviceid`),
  KEY `FK8qo108vlxdgdhrk0ryv8rp7nx` (`model_id`),
  CONSTRAINT `FK2ab0dyvhbhetxlvopewdafok4` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FK8qo108vlxdgdhrk0ryv8rp7nx` FOREIGN KEY (`model_id`) REFERENCES `elevator_model` (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_model` */

insert  into `device_model`(`model_id`,`deviceid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11);

/*Table structure for table `device_organization` */

DROP TABLE IF EXISTS `device_organization`;

CREATE TABLE `device_organization` (
  `organization_id` int(11) default NULL,
  `deviceid` bigint(20) NOT NULL,
  PRIMARY KEY  (`deviceid`),
  KEY `FK4m1mjfixw4f2ca997eii783pe` (`organization_id`),
  CONSTRAINT `FKhm69vjq1k6l0crmj3610rtott` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FK4m1mjfixw4f2ca997eii783pe` FOREIGN KEY (`organization_id`) REFERENCES `orgnization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_organization` */

insert  into `device_organization`(`organization_id`,`deviceid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11);

/*Table structure for table `device_task` */

DROP TABLE IF EXISTS `device_task`;

CREATE TABLE `device_task` (
  `deviceid` bigint(20) default NULL,
  `taskid` int(11) NOT NULL,
  PRIMARY KEY  (`taskid`),
  KEY `FKlci4c36qxe0c84saqw2nhj6th` (`deviceid`),
  CONSTRAINT `FKhx07fg0v7k1v6swuk90ol8vea` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`),
  CONSTRAINT `FKlci4c36qxe0c84saqw2nhj6th` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_task` */

insert  into `device_task`(`deviceid`,`taskid`) values (1,1),(11,11);

/*Table structure for table `device_type` */

DROP TABLE IF EXISTS `device_type`;

CREATE TABLE `device_type` (
  `type_id` int(11) default NULL,
  `deviceid` bigint(20) NOT NULL,
  PRIMARY KEY  (`deviceid`),
  KEY `FK8qtr7sg13cno4cd64m94h80iy` (`type_id`),
  CONSTRAINT `FKlauefm0ac5qi7743a999adwul` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FK8qtr7sg13cno4cd64m94h80iy` FOREIGN KEY (`type_id`) REFERENCES `elevator_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `device_type` */

insert  into `device_type`(`type_id`,`deviceid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11);

/*Table structure for table `elevator_model` */

DROP TABLE IF EXISTS `elevator_model`;

CREATE TABLE `elevator_model` (
  `model_id` int(11) NOT NULL auto_increment,
  `elevator_model` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `elevator_model` */

insert  into `elevator_model`(`model_id`,`elevator_model`) values (1,'1'),(2,'2');

/*Table structure for table `elevator_type` */

DROP TABLE IF EXISTS `elevator_type`;

CREATE TABLE `elevator_type` (
  `type_id` int(11) NOT NULL auto_increment,
  `elevator_type` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `elevator_type` */

insert  into `elevator_type`(`type_id`,`elevator_type`) values (1,'1'),(2,'2');

/*Table structure for table `elevatorprofile` */

DROP TABLE IF EXISTS `elevatorprofile`;

CREATE TABLE `elevatorprofile` (
  `id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `elevatorprofile` */

insert  into `elevatorprofile`(`id`) values (1),(2);

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `jobid` int(11) NOT NULL auto_increment,
  `entrance1_comment` varchar(255) collate utf8_bin default NULL,
  `entrance1_img_url` varchar(255) collate utf8_bin default NULL,
  `entrance2_comment` varchar(255) collate utf8_bin default NULL,
  `entrance2_img_url` varchar(255) collate utf8_bin default NULL,
  `entrance3_comment` varchar(255) collate utf8_bin default NULL,
  `entrance3_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway1_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway1_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway2_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway2_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway3_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway3_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway4_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway4_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway5_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway5_img_url` varchar(255) collate utf8_bin default NULL,
  `hoistway6_comment` varchar(255) collate utf8_bin default NULL,
  `hoistway6_img_url` varchar(255) collate utf8_bin default NULL,
  `liftcar1_comment` varchar(255) collate utf8_bin default NULL,
  `liftcar1_img_url` varchar(255) collate utf8_bin default NULL,
  `liftcar2_comment` varchar(255) collate utf8_bin default NULL,
  `liftcar2_img_url` varchar(255) collate utf8_bin default NULL,
  `liftcar3_comment` varchar(255) collate utf8_bin default NULL,
  `liftcar3_img_url` varchar(255) collate utf8_bin default NULL,
  `liftpit1_comment` varchar(255) collate utf8_bin default NULL,
  `liftpit1_img_url` varchar(255) collate utf8_bin default NULL,
  `liftpit2_comment` varchar(255) collate utf8_bin default NULL,
  `liftpit2_img_url` varchar(255) collate utf8_bin default NULL,
  `liftpit3_comment` varchar(255) collate utf8_bin default NULL,
  `liftpit3_img_url` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`jobid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `job` */

insert  into `job`(`jobid`,`entrance1_comment`,`entrance1_img_url`,`entrance2_comment`,`entrance2_img_url`,`entrance3_comment`,`entrance3_img_url`,`hoistway1_comment`,`hoistway1_img_url`,`hoistway2_comment`,`hoistway2_img_url`,`hoistway3_comment`,`hoistway3_img_url`,`hoistway4_comment`,`hoistway4_img_url`,`hoistway5_comment`,`hoistway5_img_url`,`hoistway6_comment`,`hoistway6_img_url`,`liftcar1_comment`,`liftcar1_img_url`,`liftcar2_comment`,`liftcar2_img_url`,`liftcar3_comment`,`liftcar3_img_url`,`liftpit1_comment`,`liftpit1_img_url`,`liftpit2_comment`,`liftpit2_img_url`,`liftpit3_comment`,`liftpit3_img_url`) values (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `maintenance_type` */

DROP TABLE IF EXISTS `maintenance_type`;

CREATE TABLE `maintenance_type` (
  `type_id` int(11) NOT NULL auto_increment,
  `maintenance_type` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `maintenance_type` */

insert  into `maintenance_type`(`type_id`,`maintenance_type`) values (1,'1'),(2,'2');

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `manufacturer_id` int(11) NOT NULL auto_increment,
  `address` varchar(255) collate utf8_bin default NULL,
  `description` varchar(255) collate utf8_bin default NULL,
  `manufacturer_name` varchar(255) collate utf8_bin NOT NULL,
  `phone` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `manufacturer` */

insert  into `manufacturer`(`manufacturer_id`,`address`,`description`,`manufacturer_name`,`phone`) values (1,'1',NULL,'1',NULL),(2,'2',NULL,'2',NULL);

/*Table structure for table `orgnization` */

DROP TABLE IF EXISTS `orgnization`;

CREATE TABLE `orgnization` (
  `organization_id` int(11) NOT NULL auto_increment,
  `address` varchar(255) collate utf8_bin NOT NULL,
  `email` varchar(255) collate utf8_bin default NULL,
  `organization_name` varchar(255) collate utf8_bin NOT NULL,
  `organization_type` varchar(255) collate utf8_bin default NULL,
  `phone` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orgnization` */

insert  into `orgnization`(`organization_id`,`address`,`email`,`organization_name`,`organization_type`,`phone`) values (1,'','1','1',NULL,''),(2,'','2','2',NULL,'');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role`) values (1,'admin'),(2,'org'),(3,'user');

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `scheduleid` int(11) NOT NULL,
  `last_mtc_ipt_time` varchar(255) collate utf8_bin default NULL,
  `notice_period` int(11) default NULL,
  `schedule_period` int(11) default NULL,
  `schedule_type` int(11) default NULL,
  `status` int(11) default NULL,
  `task_inperiod` tinyint(1) default NULL,
  PRIMARY KEY  (`scheduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `schedule` */

insert  into `schedule`(`scheduleid`,`last_mtc_ipt_time`,`notice_period`,`schedule_period`,`schedule_type`,`status`,`task_inperiod`) values (1,'2017-08-29 10:10:10',10,30,1,0,1),(2,'2017-08-29 10:10:10',10,30,2,0,1),(3,'2017-08-18 10:10:10',10,30,1,1,1);

/*Table structure for table `schedule_device` */

DROP TABLE IF EXISTS `schedule_device`;

CREATE TABLE `schedule_device` (
  `deviceid` bigint(20) default NULL,
  `scheduleid` int(11) NOT NULL,
  PRIMARY KEY  (`scheduleid`),
  KEY `FKktmmo3fdtcm4da39xe9vgtywl` (`deviceid`),
  CONSTRAINT `FKh44n3peghewyt3597gjm9j3yv` FOREIGN KEY (`scheduleid`) REFERENCES `schedule` (`scheduleid`),
  CONSTRAINT `FKktmmo3fdtcm4da39xe9vgtywl` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `schedule_device` */

insert  into `schedule_device`(`deviceid`,`scheduleid`) values (1,1),(1,2),(11,3);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `taskid` int(11) NOT NULL auto_increment,
  `status` int(11) default NULL,
  `task_type` int(11) default NULL,
  `time` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `task` */

insert  into `task`(`taskid`,`status`,`task_type`,`time`) values (1,1,1,'2017-08-29 10:10:10'),(2,1,2,'2017-08-29 10:10:10'),(3,1,1,'2017-08-29 10:10:10'),(4,1,1,'2017-08-29 10:10:10'),(5,1,1,'2017-08-29 10:10:10'),(6,1,1,'2017-08-29 10:10:10'),(7,1,1,'2017-08-29 10:10:10'),(8,1,1,'2017-08-29 10:10:10'),(9,1,1,'2017-08-29 10:10:10'),(10,1,1,'2017-08-29 10:10:10'),(11,1,1,NULL);

/*Table structure for table `task_job` */

DROP TABLE IF EXISTS `task_job`;

CREATE TABLE `task_job` (
  `taskid` int(11) NOT NULL,
  `jobid` int(11) NOT NULL,
  PRIMARY KEY  (`taskid`),
  KEY `FKr5hl3o6hcn8aiyome4tmcs5kg` (`jobid`),
  CONSTRAINT `FKr5hl3o6hcn8aiyome4tmcs5kg` FOREIGN KEY (`jobid`) REFERENCES `job` (`jobid`),
  CONSTRAINT `FKpn4b3mllbacj4nyncori5yuxf` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `task_job` */

insert  into `task_job`(`taskid`,`jobid`) values (11,1);

/*Table structure for table `task_user` */

DROP TABLE IF EXISTS `task_user`;

CREATE TABLE `task_user` (
  `userid` int(11) default NULL,
  `taskid` int(11) NOT NULL,
  PRIMARY KEY  (`taskid`),
  KEY `FKg98xuy9w0d8kfauor93spl9h1` (`userid`),
  CONSTRAINT `FK5dofs2jks4y3r9h9q16bu5for` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`),
  CONSTRAINT `FKg98xuy9w0d8kfauor93spl9h1` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `task_user` */

/*Table structure for table `tb_elevatorstatus` */

DROP TABLE IF EXISTS `tb_elevatorstatus`;

CREATE TABLE `tb_elevatorstatus` (
  `recordid` int(11) NOT NULL auto_increment,
  `illegalopen` varchar(255) collate utf8_bin default NULL,
  `bodystatus` varchar(255) collate utf8_bin default NULL,
  `bp` varchar(255) collate utf8_bin default NULL,
  `datatime` varchar(255) collate utf8_bin default NULL,
  `doorstatus` varchar(255) collate utf8_bin default NULL,
  `elevator_overup` varchar(255) collate utf8_bin default NULL,
  `elevatorspeed` varchar(255) collate utf8_bin default NULL,
  `floor` varchar(255) collate utf8_bin default NULL,
  `midstop` varchar(255) collate utf8_bin default NULL,
  `mp` varchar(255) collate utf8_bin default NULL,
  `rtuid` varchar(255) collate utf8_bin default NULL,
  `rundirection` varchar(255) collate utf8_bin default NULL,
  `sendtime` varchar(255) collate utf8_bin default NULL,
  `sensorstatus` varchar(255) collate utf8_bin default NULL,
  `trap` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_elevatorstatus` */

/*Table structure for table `tb_record` */

DROP TABLE IF EXISTS `tb_record`;

CREATE TABLE `tb_record` (
  `recordid` int(11) NOT NULL auto_increment,
  `createtime` varchar(255) collate utf8_bin default NULL,
  `deviceid` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`recordid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_record` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `active` int(11) default NULL,
  `email` varchar(255) collate utf8_bin NOT NULL,
  `last_name` varchar(255) collate utf8_bin NOT NULL,
  `name` varchar(255) collate utf8_bin NOT NULL,
  `password` varchar(255) collate utf8_bin default NULL,
  `phone` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`user_id`,`active`,`email`,`last_name`,`name`,`password`,`phone`) values (1,1,'a@c','a','a','$2a$10$60dOyTtM8bYIN5./v0FQlexh2eapeuNR1va.Libw8B9SZTBsH6Knm','a@c'),(2,1,'a@b','1','1','$2a$10$q//DVh6x5lcTiHuluGO2yOxEnCPBCAq.Kw.woh9VIicFZkLhJeZ/W','a@b');

/*Table structure for table `user_organization` */

DROP TABLE IF EXISTS `user_organization`;

CREATE TABLE `user_organization` (
  `organization_id` int(11) default NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FKocgosy74k3hjxmanbhbswuub6` (`organization_id`),
  CONSTRAINT `FK9nwktb5dduncsh5rx4fstyoho` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKocgosy74k3hjxmanbhbswuub6` FOREIGN KEY (`organization_id`) REFERENCES `orgnization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_organization` */

insert  into `user_organization`(`organization_id`,`user_id`) values (1,1),(1,2);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` int(11) default NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user_role` */

insert  into `user_role`(`role_id`,`user_id`) values (1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
