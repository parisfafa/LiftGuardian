/*
SQLyog v10.2 
MySQL - 5.5.23 : Database - demo
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
  `alarm_id` int(11) NOT NULL AUTO_INCREMENT,
  `alarm_type` varchar(255) NOT NULL,
  `alarm_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`alarm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alarm_type` */

/*Table structure for table `camera` */

DROP TABLE IF EXISTS `camera`;

CREATE TABLE `camera` (
  `cameraid` int(11) NOT NULL COMMENT 'id',
  `manufacturer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '厂商',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '链接',
  `model` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '型号',
  `serial_number` varchar(255) COLLATE utf8_bin NOT NULL,
  `camera_name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cameraid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `camera` */

insert  into `camera`(`cameraid`,`manufacturer`,`url`,`model`,`serial_number`,`camera_name`) values (1,'12345','http://as.hiddnsservice.com/sg677008453','123456','1234','123'),(2,'2','2','22','2','2'),(11,'sd','http://as.hiddnsservice.com/sg677008453','12','12','11'),(1111,'22','22','22','22','22'),(1122,'sd','http://as.hiddnsservice.com/sg677008453','12','12','11'),(11221,'dd','http://as.hiddnsservice.com/sg677008453','sd','122','21122');

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `deviceid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) NOT NULL,
  PRIMARY KEY (`deviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=12345679 DEFAULT CHARSET=latin1;

/*Data for the table `device` */

insert  into `device`(`deviceid`,`address`,`device_name`,`country`,`postcode`) values (4,'2','2','SG','2'),(12,'12','212','SG','122'),(1001,'1','devicetest',NULL,''),(1234,'d','demo','SG','d'),(12345,'d','demo','SG','d'),(12345678,'1','device1',NULL,'');

/*Table structure for table `device_camera` */

DROP TABLE IF EXISTS `device_camera`;

CREATE TABLE `device_camera` (
  `deviceid` int(11) NOT NULL,
  `cameraid` int(11) DEFAULT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FKox52qo5eld1krkuwdojdg7vk8` (`cameraid`),
  CONSTRAINT `device_camera_ibfk_4` FOREIGN KEY (`cameraid`) REFERENCES `camera` (`cameraid`),
  CONSTRAINT `device_camera_ibfk_5` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FK9kml7e3o4qrkfsvhgpsitaqpa` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FKox52qo5eld1krkuwdojdg7vk8` FOREIGN KEY (`cameraid`) REFERENCES `camera` (`cameraid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `device_camera` */

insert  into `device_camera`(`deviceid`,`cameraid`) values (4,1),(12,1),(1001,1);

/*Table structure for table `device_manufacturer` */

DROP TABLE IF EXISTS `device_manufacturer`;

CREATE TABLE `device_manufacturer` (
  `manufacturer_id` int(11) DEFAULT NULL,
  `deviceid` int(11) NOT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FKkr4guledrbsqkg5ys9wnm89r7` (`manufacturer_id`),
  CONSTRAINT `FKbp43dq63jo5kfxd2c9b1j8u2m` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FKkr4guledrbsqkg5ys9wnm89r7` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `device_manufacturer` */

insert  into `device_manufacturer`(`manufacturer_id`,`deviceid`) values (1,1),(1,4),(1,12),(1,122),(1,1001),(1,1234),(1,12345),(1,12345677),(1,12345678);

/*Table structure for table `device_model` */

DROP TABLE IF EXISTS `device_model`;

CREATE TABLE `device_model` (
  `model_id` int(11) DEFAULT NULL,
  `deviceid` int(11) NOT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FK8qo108vlxdgdhrk0ryv8rp7nx` (`model_id`),
  CONSTRAINT `FK2ab0dyvhbhetxlvopewdafok4` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`),
  CONSTRAINT `FK8qo108vlxdgdhrk0ryv8rp7nx` FOREIGN KEY (`model_id`) REFERENCES `elevator_model` (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `device_model` */

insert  into `device_model`(`model_id`,`deviceid`) values (1,4),(1,12),(1,1234),(1,12345),(1,12345677),(1,12345678),(2,1001);

/*Table structure for table `device_organization` */

DROP TABLE IF EXISTS `device_organization`;

CREATE TABLE `device_organization` (
  `organization_id` int(11) DEFAULT NULL,
  `deviceid` int(11) NOT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FK4m1mjfixw4f2ca997eii783pe` (`organization_id`),
  CONSTRAINT `FK4m1mjfixw4f2ca997eii783pe` FOREIGN KEY (`organization_id`) REFERENCES `orgnization` (`organization_id`),
  CONSTRAINT `FKhm69vjq1k6l0crmj3610rtott` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `device_organization` */

insert  into `device_organization`(`organization_id`,`deviceid`) values (1,1),(1,4),(1,12),(1,122),(1,1234),(1,12345),(1,12345677),(1,12345678),(2,1001);

/*Table structure for table `device_type` */

DROP TABLE IF EXISTS `device_type`;

CREATE TABLE `device_type` (
  `type_id` int(11) DEFAULT NULL,
  `deviceid` int(11) NOT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `FK8qtr7sg13cno4cd64m94h80iy` (`type_id`),
  CONSTRAINT `FK8qtr7sg13cno4cd64m94h80iy` FOREIGN KEY (`type_id`) REFERENCES `elevator_type` (`type_id`),
  CONSTRAINT `FKlauefm0ac5qi7743a999adwul` FOREIGN KEY (`deviceid`) REFERENCES `device` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `device_type` */

insert  into `device_type`(`type_id`,`deviceid`) values (1,4),(1,12),(1,122),(1,1234),(1,12345),(1,12345677),(1,12345678),(4,1001);

/*Table structure for table `elevator_model` */

DROP TABLE IF EXISTS `elevator_model`;

CREATE TABLE `elevator_model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `elevator_model` varchar(255) NOT NULL,
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `elevator_model` */

insert  into `elevator_model`(`model_id`,`elevator_model`) values (1,'MODEL1'),(2,'MODEL2');

/*Table structure for table `elevator_type` */

DROP TABLE IF EXISTS `elevator_type`;

CREATE TABLE `elevator_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `elevator_type` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `elevator_type` */

insert  into `elevator_type`(`type_id`,`elevator_type`) values (1,'TYPE2'),(3,'TYPE1'),(4,'TYPE3');

/*Table structure for table `elevatorprofile` */

DROP TABLE IF EXISTS `elevatorprofile`;

CREATE TABLE `elevatorprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `elevatorprofile` */

/*Table structure for table `maintenance_type` */

DROP TABLE IF EXISTS `maintenance_type`;

CREATE TABLE `maintenance_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintenance_type` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `maintenance_type` */

insert  into `maintenance_type`(`type_id`,`maintenance_type`) values (1,'CHECK1');

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `manufacturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer_name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `manufacturer` */

insert  into `manufacturer`(`manufacturer_id`,`manufacturer_name`,`phone`,`address`,`description`) values (1,'manufacturerA',11111111,'AddressA','DescrptionA');

/*Table structure for table `orgnization` */

DROP TABLE IF EXISTS `orgnization`;

CREATE TABLE `orgnization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_type` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `organization_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `orgnization` */

insert  into `orgnization`(`organization_id`,`organization_type`,`email`,`organization_name`,`phone`,`address`) values (1,'Mantainer','organizaiton1','email@email.com','12345678','address1'),(2,'Mantainer','a@a','OrgA','1234567','address1');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role`) values (1,'ADMIN'),(2,'TESTER');

/*Table structure for table `tb_alarm` */

DROP TABLE IF EXISTS `tb_alarm`;

CREATE TABLE `tb_alarm` (
  `id` int(10) NOT NULL,
  `deviceId` int(10) NOT NULL COMMENT '设备id',
  `alarmType` varchar(20) NOT NULL COMMENT '警报类型',
  `alarmNumber` int(10) DEFAULT NULL COMMENT '警报次数',
  `alarmContent` varchar(50) DEFAULT NULL COMMENT '报警内容',
  `alarmStatus` varchar(10) NOT NULL COMMENT '警报打开或关闭状态',
  `alarmStartTime` varchar(50) DEFAULT NULL COMMENT '报警开始时间',
  `alarmEndTime` varchar(50) DEFAULT NULL COMMENT '报警结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_alarm` */

/*Table structure for table `tb_device` */

DROP TABLE IF EXISTS `tb_device`;

CREATE TABLE `tb_device` (
  `deviceId` varchar(20) NOT NULL,
  `mp` double(10,0) DEFAULT NULL COMMENT 'RTU主电源电压值',
  `bp` double(10,0) DEFAULT NULL COMMENT 'RTU备用电源电压值',
  PRIMARY KEY (`deviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_device` */

insert  into `tb_device`(`deviceId`,`mp`,`bp`) values ('08582852',NULL,NULL),('08582853',NULL,NULL),('1001',NULL,NULL);

/*Table structure for table `tb_devicetype` */

DROP TABLE IF EXISTS `tb_devicetype`;

CREATE TABLE `tb_devicetype` (
  `deviceTypeId` int(10) NOT NULL COMMENT '设备类型id',
  `deviceName` varchar(30) DEFAULT NULL COMMENT '设备名称',
  `deviceSummary` varchar(100) DEFAULT NULL COMMENT '设备简介',
  PRIMARY KEY (`deviceTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_devicetype` */

/*Table structure for table `tb_elevatorstatus` */

DROP TABLE IF EXISTS `tb_elevatorstatus`;

CREATE TABLE `tb_elevatorstatus` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rtuid` varchar(8) DEFAULT NULL,
  `datatime` varchar(30) DEFAULT NULL COMMENT '采集时间',
  `sendtime` varchar(30) DEFAULT NULL COMMENT '发送时间',
  `floor` varchar(10) DEFAULT NULL COMMENT '楼层',
  `rundirection` varchar(10) DEFAULT NULL COMMENT '电梯运行方向',
  `doorstatus` varchar(10) DEFAULT NULL COMMENT '电梯门状态',
  `bodystatus` varchar(10) DEFAULT NULL COMMENT '电梯内是否有人',
  `sensorstatus` varchar(10) DEFAULT NULL COMMENT '传感器状态',
  `elevatorspeed` varchar(10) DEFAULT NULL COMMENT '电梯速度状态',
  `midstop` varchar(10) DEFAULT NULL COMMENT '电梯非平层停止',
  `trap` varchar(10) DEFAULT NULL COMMENT '电梯困人',
  `Illegalopen` varchar(10) DEFAULT NULL COMMENT '电梯非平层开门',
  `elevatorOverup` varchar(10) DEFAULT NULL COMMENT '电梯冲顶',
  `elevatorOverdown` varchar(10) DEFAULT NULL COMMENT '电梯蹲底',
  `mp` double(10,3) DEFAULT NULL COMMENT '主电源电压',
  `bp` double(10,3) DEFAULT NULL COMMENT '备用电源电压',
  `recordid` int(10) NOT NULL COMMENT '记录id',
  `elevator_overup` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hkj` (`recordid`),
  CONSTRAINT `FK4y07watnqbh99vxyvv66s0ttv` FOREIGN KEY (`recordid`) REFERENCES `tb_record` (`recordId`),
  CONSTRAINT `hkj` FOREIGN KEY (`recordid`) REFERENCES `tb_record` (`recordId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_elevatorstatus` */

insert  into `tb_elevatorstatus`(`id`,`rtuid`,`datatime`,`sendtime`,`floor`,`rundirection`,`doorstatus`,`bodystatus`,`sensorstatus`,`elevatorspeed`,`midstop`,`trap`,`Illegalopen`,`elevatorOverup`,`elevatorOverdown`,`mp`,`bp`,`recordid`,`elevator_overup`) values (1,NULL,NULL,NULL,'Level1','up1','open1','no1',NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,212,NULL),(8,NULL,NULL,NULL,'123','123','123','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,213,NULL);

/*Table structure for table `tb_futian_monitoring_ai` */

DROP TABLE IF EXISTS `tb_futian_monitoring_ai`;

CREATE TABLE `tb_futian_monitoring_ai` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `phasevo_a` varchar(10) DEFAULT NULL COMMENT '相电压0分别代表A相电压',
  `phasevo_b` varchar(10) DEFAULT NULL COMMENT '相电压1分别代表b相电压',
  `phasevo_c` varchar(10) DEFAULT NULL COMMENT '相电压2分别代表C相电压',
  `phasecur_a` varchar(10) DEFAULT NULL COMMENT '相电流0分别代表A相电压',
  `phasecur_b` varchar(10) DEFAULT NULL COMMENT '相电流1分别代表B相电压',
  `phasecur_c` varchar(10) DEFAULT NULL COMMENT '相电流3分别代表C相电压',
  `temp` varchar(10) DEFAULT '温度值',
  `tst` varchar(10) DEFAULT NULL COMMENT '温度报警状态 （0-不报警 1-报警）',
  `humi` varchar(10) DEFAULT NULL COMMENT '湿度值',
  `hst` varchar(10) DEFAULT NULL COMMENT '湿度报警状态 （0-不报警 1-报警）',
  `recordid` int(10) NOT NULL COMMENT '记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

/*Data for the table `tb_futian_monitoring_ai` */

insert  into `tb_futian_monitoring_ai`(`id`,`phasevo_a`,`phasevo_b`,`phasevo_c`,`phasecur_a`,`phasecur_b`,`phasecur_c`,`temp`,`tst`,`humi`,`hst`,`recordid`) values (1,'0','1','2','0','0','0','0.0','0','0.0','0',65),(2,'0','1','2','0','0','0','0.0','0','0.0','0',66),(3,'0','1','2','0','0','0','0.0','0','0.0','0',67),(4,'0','1','2','0','0','0','0.0','0','0.0','0',68),(5,'0','1','2','0','0','0','0.0','0','0.0','0',69),(6,'0','1','2','0','0','0','0.0','0','0.0','0',70),(7,'0','1','2','0','0','0','0.0','0','0.0','0',71),(8,'0','1','2','0','0','0','0.0','0','0.0','0',72),(9,'0','1','2','0','0','0','0.0','0','0.0','0',78),(10,'0','1','2','0','0','0','0.0','0','0.0','0',79),(11,'0','1','2','0','0','0','0.0','0','0.0','0',80),(12,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',83),(13,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',84),(14,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',85),(15,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',86),(16,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',87),(17,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',88),(18,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',89),(19,'0','1','2','0','0','0','0.0','0','0.0','0',92),(20,'0','1','2','0','0','0','0.0','0','0.0','0',93),(21,'0','1','2','0','0','0','0.0','0','0.0','0',102),(22,'0','1','2','0','0','0','0.0','0','0.0','0',103),(23,'0','1','2','0','0','0','0.0','0','0.0','0',104),(24,'0','1','2','0','0','0','0.0','0','0.0','0',105),(25,'0','1','2','0','0','0','0.0','0','0.0','0',106),(26,'0','1','2','0','0','0','0.0','0','0.0','0',107),(27,'0','1','2','0','0','0','0.0','0','0.0','0',108),(28,'0','1','2','0','0','0','0.0','0','0.0','0',109),(29,'0','1','2','0','0','0','0.0','0','0.0','0',110),(30,'0','1','2','0','0','0','0.0','0','0.0','0',111),(31,'0','1','2','0','0','0','0.0','0','0.0','0',112),(32,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',113),(33,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',114),(34,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',115),(35,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',116),(36,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',117),(37,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',118),(38,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',119),(39,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',120),(40,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',121),(41,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',122),(42,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',123),(43,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',124),(44,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',125),(45,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',126),(46,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',127),(47,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',128),(48,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',129),(49,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',130),(50,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',131),(51,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',132),(52,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',133),(53,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',134),(54,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',135),(55,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',136),(56,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',137),(57,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',138),(58,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',139),(59,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',140),(60,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',141),(61,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',142),(62,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',143),(63,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',144),(64,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',145),(65,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',146),(66,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',147),(67,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',148),(68,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',149),(69,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',150),(70,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',151),(71,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',152),(72,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',153),(73,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',154),(74,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',155),(75,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',156),(76,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',157),(77,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',158),(78,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',159),(79,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',160),(80,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',161),(81,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',162),(82,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',163),(83,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',164),(84,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',165),(85,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',166),(86,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',167),(87,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',168),(88,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',169),(89,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',170),(90,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',171),(91,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',172),(92,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',173),(93,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',174),(94,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',175),(95,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',176),(96,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',178),(97,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',179),(98,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',180),(99,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',181),(100,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',182),(101,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',183),(102,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',184),(103,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',185),(104,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',186),(105,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',187),(106,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',188),(107,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',189),(108,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',190),(109,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',191),(110,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',192),(111,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',193),(112,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',194),(113,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',195),(114,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',196),(115,'0.0','0.0','0.0','0.0','0.0','0.0','0.0','0','0.0','0',197),(116,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',199),(117,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',200),(118,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',204),(119,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',205),(120,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',206),(121,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',207),(122,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',208),(123,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',209),(124,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',210),(125,'234.9','34.9','4.9','12.0','25.0','5.0','20.5','0','80.0','1',211);

/*Table structure for table `tb_futian_monitoring_di` */

DROP TABLE IF EXISTS `tb_futian_monitoring_di`;

CREATE TABLE `tb_futian_monitoring_di` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datatime` varchar(30) DEFAULT NULL COMMENT '采集时间',
  `sendtime` varchar(30) DEFAULT NULL COMMENT '发送时间',
  `ls` varchar(10) DEFAULT NULL COMMENT '漏水，0-不报警，1-报警',
  `yw` varchar(10) DEFAULT NULL COMMENT '烟雾，0-不报警，1-报警',
  `fh` varchar(10) DEFAULT NULL COMMENT '复合火警，0-不报警，1-报警',
  `dy` varchar(10) DEFAULT NULL COMMENT '单一火警，0-不报警，1-报警',
  `gz` varchar(10) DEFAULT NULL COMMENT '故障，0-不报警，1-报警',
  `recordid` varchar(10) NOT NULL COMMENT '记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_futian_monitoring_di` */

insert  into `tb_futian_monitoring_di`(`id`,`datatime`,`sendtime`,`ls`,`yw`,`fh`,`dy`,`gz`,`recordid`) values (1,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','204'),(2,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','205'),(3,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','206'),(4,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','207'),(5,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','208'),(6,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','209'),(7,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','210'),(8,'2017-02-20 15:04:30','2017-02-20 15:04:30','1','1','1','1','1','211');

/*Table structure for table `tb_futian_monitoring_rs232_upsdata` */

DROP TABLE IF EXISTS `tb_futian_monitoring_rs232_upsdata`;

CREATE TABLE `tb_futian_monitoring_rs232_upsdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `upsconnectstate` varchar(10) DEFAULT NULL COMMENT 'UPS通信状态，0-通信成功，1-通信失败',
  `valinput` varchar(10) DEFAULT NULL COMMENT '输入电压',
  `valoutput` varchar(10) DEFAULT NULL COMMENT '输出电压',
  `percentageoutput` varchar(10) DEFAULT NULL COMMENT '输出电流最大百分比',
  `freqinput` varchar(10) DEFAULT NULL COMMENT '输入频率',
  `batteryvol` varchar(10) DEFAULT NULL COMMENT '电池电压',
  `temp` varchar(10) DEFAULT NULL COMMENT '温度',
  `electricstate` varchar(10) DEFAULT NULL COMMENT '市电状态，0-市电正常，1市电故障',
  `batterystate` varchar(10) DEFAULT NULL COMMENT '电池状态，0-电池正常，1电池电压低',
  `bypassstate` varchar(10) DEFAULT NULL COMMENT '旁路逆变状态，0-逆变状态，1-旁路状态',
  `faultstate` varchar(10) DEFAULT NULL COMMENT 'UPS故障，0-正常，1-UPS内部故障',
  `upstype` varchar(10) DEFAULT NULL COMMENT 'UPS类型，0-在线机，1-后备机',
  `upstestmode` varchar(10) DEFAULT NULL COMMENT '系统测试中，1-测试中',
  `powermode` varchar(10) DEFAULT NULL COMMENT '系统关机，1关机激活状态',
  `warningsound` varchar(10) DEFAULT NULL COMMENT '告警音，1-告警音开',
  `recordid` int(10) NOT NULL COMMENT '记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

/*Data for the table `tb_futian_monitoring_rs232_upsdata` */

insert  into `tb_futian_monitoring_rs232_upsdata`(`id`,`upsconnectstate`,`valinput`,`valoutput`,`percentageoutput`,`freqinput`,`batteryvol`,`temp`,`electricstate`,`batterystate`,`bypassstate`,`faultstate`,`upstype`,`upstestmode`,`powermode`,`warningsound`,`recordid`) values (1,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',66),(2,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',67),(3,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',68),(4,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',69),(5,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',70),(6,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',71),(7,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',72),(8,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',78),(9,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',79),(10,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',80),(11,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',83),(12,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',84),(13,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',85),(14,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',86),(15,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',87),(16,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',88),(17,'1','208.4','208.4','34','59.9','2.04','35.0','1','1','1','1','0','0','0','0',89),(18,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',92),(19,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',93),(20,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',102),(21,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',103),(22,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',104),(23,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',105),(24,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',106),(25,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',107),(26,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',108),(27,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',109),(28,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',110),(29,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',111),(30,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',112),(31,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',113),(32,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',114),(33,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',115),(34,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',116),(35,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',117),(36,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',118),(37,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',119),(38,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',120),(39,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',121),(40,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',122),(41,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',123),(42,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',124),(43,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',125),(44,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',126),(45,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',127),(46,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',128),(47,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',129),(48,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',130),(49,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',131),(50,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',132),(51,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',133),(52,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',134),(53,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',135),(54,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',136),(55,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',137),(56,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',138),(57,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',139),(58,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',140),(59,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',141),(60,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',142),(61,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',143),(62,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',144),(63,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',145),(64,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',146),(65,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',147),(66,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',148),(67,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',149),(68,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',150),(69,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',151),(70,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',152),(71,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',153),(72,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',154),(73,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',155),(74,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',156),(75,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',157),(76,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',158),(77,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',159),(78,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',160),(79,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',161),(80,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',162),(81,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',163),(82,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',164),(83,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',165),(84,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',166),(85,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',167),(86,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',168),(87,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',169),(88,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',170),(89,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',171),(90,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',172),(91,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',173),(92,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',174),(93,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',175),(94,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',176),(95,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',178),(96,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',179),(97,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',180),(98,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',181),(99,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',182),(100,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',183),(101,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',184),(102,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',185),(103,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',186),(104,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',187),(105,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',188),(106,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',189),(107,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',190),(108,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',191),(109,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',192),(110,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',193),(111,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',194),(112,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',195),(113,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',196),(114,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',199),(115,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',200),(116,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',204),(117,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',205),(118,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',206),(119,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',207),(120,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',208),(121,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',209),(122,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',210),(123,'1','0.0','0.0','0','0.0','0.0','0.0','0','0','0','0','0','0','0','0',211);

/*Table structure for table `tb_futian_monitoring_rs485_airdata` */

DROP TABLE IF EXISTS `tb_futian_monitoring_rs485_airdata`;

CREATE TABLE `tb_futian_monitoring_rs485_airdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `airconnectstate` varchar(10) DEFAULT NULL COMMENT '空调通信状态，0-通信成功，1-通信失败',
  `sitetemp` varchar(10) DEFAULT NULL COMMENT '现场温度',
  `sitehumi` varchar(10) DEFAULT NULL COMMENT '现场湿度',
  `compout` varchar(10) DEFAULT NULL COMMENT '压缩机输出，输出的是百分比',
  `heaterout` varchar(10) DEFAULT NULL COMMENT '加热器输出，输出的是百分比',
  `humiout` varchar(10) DEFAULT NULL COMMENT '加湿器输出，输出的是百分比',
  `fanruntim` varchar(10) DEFAULT NULL COMMENT '风机运行时间',
  `CompRuntime` varchar(10) DEFAULT NULL COMMENT '压缩机运行时间',
  `HeaterRuntime` varchar(10) DEFAULT NULL COMMENT '加热器运行时间',
  `HumiRuntime` varchar(10) DEFAULT NULL COMMENT '加湿器运行时间',
  `FanAlarm` varchar(10) DEFAULT NULL COMMENT '风机过载，0-无报警，1-报警，2-报警确认',
  `CompHAlarn` varchar(10) DEFAULT NULL COMMENT '压缩机高压，0-无报警，1-报警，2-报警确认',
  `CompLAlarm` varchar(10) DEFAULT NULL COMMENT '压缩机低压，0-无报警，1-报警，2-报警确认',
  `HeaterAlarm` varchar(10) DEFAULT NULL COMMENT '加热器过载，0-无报警，1-报警，2-报警确认',
  `HumiAlarm` varchar(10) DEFAULT NULL COMMENT '加湿器淤塞，0-无报警，1-报警，2-报警确认',
  `FireAlarm` varchar(10) DEFAULT NULL COMMENT '火警，0-无报警，1-报警，2-报警确认',
  `FloodAlarm` varchar(10) DEFAULT NULL COMMENT '溢水报警，0-无报警，1-报警，2-报警确认',
  `PhaseAlarm` varchar(10) DEFAULT NULL COMMENT '相位错误，0-无报警，1-报警，2-报警确认',
  `TempHAlarm` varchar(10) DEFAULT NULL COMMENT '温度上限，0-无报警，1-报警，2-报警确认',
  `TempLAlarm` varchar(10) DEFAULT NULL COMMENT '温度下限，0-无报警，1-报警，2-报警确认',
  `HumiHAlarm` varchar(10) DEFAULT NULL COMMENT '湿度上限，0-无报警，1-报警，2-报警确认',
  `HumiLAlarm` varchar(10) DEFAULT NULL COMMENT '湿度下限，0-无报警，1-报警，2-报警确认',
  `SensorAlarm` varchar(10) DEFAULT NULL COMMENT '温度传感器坏，0-无报警，1-报警，2-报警确认',
  `GeneralAlarm` varchar(10) DEFAULT NULL COMMENT '通用警报,0-无警报，1-有警报',
  `FanState` varchar(10) DEFAULT NULL COMMENT '风机，0-关，1开',
  `CompState` varchar(10) DEFAULT NULL COMMENT '压缩机，0-关，1开',
  `HeaterState` varchar(10) DEFAULT NULL COMMENT '加热器，0-关，1开',
  `HumiState` varchar(10) DEFAULT NULL COMMENT '加湿器，0-关，1开',
  `HumiMode` varchar(10) DEFAULT NULL COMMENT '除湿，0-非除湿，1-除湿',
  `DeHumiMode` varchar(10) DEFAULT NULL COMMENT '加湿，0-非加湿，1-加湿',
  `CoolingMode` varchar(10) CHARACTER SET ujis DEFAULT NULL COMMENT '制冷，0-非制冷，1-制冷',
  `recordid` int(10) NOT NULL COMMENT '记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

/*Data for the table `tb_futian_monitoring_rs485_airdata` */

insert  into `tb_futian_monitoring_rs485_airdata`(`id`,`airconnectstate`,`sitetemp`,`sitehumi`,`compout`,`heaterout`,`humiout`,`fanruntim`,`CompRuntime`,`HeaterRuntime`,`HumiRuntime`,`FanAlarm`,`CompHAlarn`,`CompLAlarm`,`HeaterAlarm`,`HumiAlarm`,`FireAlarm`,`FloodAlarm`,`PhaseAlarm`,`TempHAlarm`,`TempLAlarm`,`HumiHAlarm`,`HumiLAlarm`,`SensorAlarm`,`GeneralAlarm`,`FanState`,`CompState`,`HeaterState`,`HumiState`,`HumiMode`,`DeHumiMode`,`CoolingMode`,`recordid`) values (1,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',66),(2,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',67),(3,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',68),(4,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',69),(5,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',70),(6,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',71),(7,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',72),(8,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',78),(9,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',79),(10,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',80),(11,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',83),(12,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',84),(13,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',85),(14,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',86),(15,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',87),(16,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',88),(17,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',89),(18,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',92),(19,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',93),(20,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',102),(21,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',103),(22,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',104),(23,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',105),(24,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',106),(25,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',107),(26,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',108),(27,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',109),(28,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',110),(29,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',111),(30,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',112),(31,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1',113),(32,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1',114),(33,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1',115),(34,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',116),(35,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',117),(36,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',118),(37,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',119),(38,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',120),(39,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',121),(40,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',122),(41,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',123),(42,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',124),(43,'0','25.6','11.2','56','36','96','90','11110','53690','123450','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',125),(44,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',126),(45,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',127),(46,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',128),(47,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',129),(48,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',130),(49,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',131),(50,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',132),(51,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',133),(52,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',134),(53,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',135),(54,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',136),(55,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',137),(56,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',138),(57,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',139),(58,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',140),(59,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',141),(60,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',142),(61,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',143),(62,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',144),(63,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',145),(64,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',146),(65,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',147),(66,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',148),(67,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',149),(68,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',150),(69,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',151),(70,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',152),(71,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',153),(72,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',154),(73,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',155),(74,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',156),(75,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',157),(76,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',158),(77,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',159),(78,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',160),(79,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',161),(80,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',162),(81,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',163),(82,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',164),(83,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',165),(84,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',166),(85,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',167),(86,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',168),(87,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',169),(88,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',170),(89,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',171),(90,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',172),(91,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',173),(92,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',174),(93,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',175),(94,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',176),(95,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',178),(96,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',179),(97,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',180),(98,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',181),(99,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',182),(100,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',183),(101,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',184),(102,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',185),(103,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',186),(104,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',187),(105,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',188),(106,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',189),(107,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',190),(108,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',191),(109,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',192),(110,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',193),(111,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',194),(112,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',195),(113,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',196),(114,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',199),(115,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',200),(116,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',204),(117,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',205),(118,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',206),(119,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',207),(120,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',208),(121,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',209),(122,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',210),(123,'1','0.0','0.0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',211);

/*Table structure for table `tb_record` */

DROP TABLE IF EXISTS `tb_record`;

CREATE TABLE `tb_record` (
  `recordId` int(10) NOT NULL AUTO_INCREMENT,
  `deviceId` varchar(10) NOT NULL COMMENT '上传该记录的设备id',
  `createTime` varchar(30) NOT NULL COMMENT '上传时间',
  `record_id` int(11) NOT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `elevator_status_id` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordId`),
  KEY `FKmvvuxe7t721dryaum8pswe31x` (`elevator_status_id`),
  KEY `FKcjk1wj06ie3el1d5jvsdbkebf` (`id`),
  CONSTRAINT `FKcjk1wj06ie3el1d5jvsdbkebf` FOREIGN KEY (`id`) REFERENCES `tb_elevatorstatus` (`id`),
  CONSTRAINT `FKmvvuxe7t721dryaum8pswe31x` FOREIGN KEY (`elevator_status_id`) REFERENCES `tb_elevatorstatus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

/*Data for the table `tb_record` */

insert  into `tb_record`(`recordId`,`deviceId`,`createTime`,`record_id`,`create_time`,`device_id`,`elevator_status_id`,`id`) values (212,'12345678','2017-02-20 15:04:30',0,NULL,NULL,NULL,NULL),(213,'1001','2017-02-20 15:04:30',0,NULL,NULL,NULL,NULL);

/*Table structure for table `tb_rtu_standard_data` */

DROP TABLE IF EXISTS `tb_rtu_standard_data`;

CREATE TABLE `tb_rtu_standard_data` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rtuid` varchar(20) DEFAULT '' COMMENT '设备id',
  `datatime` varchar(30) DEFAULT NULL,
  `projecttype` varchar(100) DEFAULT NULL COMMENT '项目类型',
  `datatype` varchar(255) DEFAULT NULL COMMENT '数据类型',
  `rtudi` varchar(512) DEFAULT NULL COMMENT 'di数据',
  `rtudo` varchar(512) DEFAULT NULL COMMENT 'do数据',
  `rtuai` varchar(512) DEFAULT NULL COMMENT 'ai数据',
  `rtupu` varchar(512) DEFAULT NULL COMMENT 'pu数据',
  `rtupower` varchar(512) DEFAULT NULL COMMENT 'power数据',
  `recordid` varchar(30) DEFAULT NULL COMMENT 'ai数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `tb_rtu_standard_data` */

insert  into `tb_rtu_standard_data`(`id`,`rtuid`,`datatime`,`projecttype`,`datatype`,`rtudi`,`rtudo`,`rtuai`,`rtupu`,`rtupower`,`recordid`) values (7,'08582852','2017-04-28 04:13:15',NULL,'standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','433'),(8,'08582852','2017-04-28 04:13:15',NULL,'standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','434'),(9,'08582852','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','437'),(10,'08582852','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','438'),(11,'08582852','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','439'),(12,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','440'),(13,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','441'),(14,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','442'),(15,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','443'),(16,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','444'),(17,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','445'),(18,'08582853','2017-04-28 04:13:15','Singapore_project','standard_data','[{\"st\":0,\"ch\":0,\"va\":1},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":0},{\"ch\":1,\"va\":0}]','[{\"st\":0,\"ch\":0,\"va\":0},{\"st\":0,\"ch\":1,\"va\":0}]','[{\"ch\":0,\"va\":7},{\"ch\":1,\"va\":32}]','[{\"mp\":11.875}]','446');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `Password` varchar(20) NOT NULL COMMENT '密码',
  `APN` varchar(20) NOT NULL COMMENT '手机接入点',
  `phoneNumber` varchar(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`userName`,`Password`,`APN`,`phoneNumber`) values (1,'name1','d440a3ca-1dab-4b74-8','CMNET','12345678996'),(3,'name3','d440a3ca-1dab-4b74-8','jerry@163.com','12345685236'),(6,'name3','6354','cmnet','12345685236'),(7,'name3','6354','cmnet','12345685236'),(8,'name3','6354','cmnet','12345685236');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`active`,`email`,`last_name`,`name`,`password`,`phone`) values (1,1,'shi.yuan.8866@hotmail.com','shi','paris','$2a$10$UW8lBj0ydyiwD2y7p3U9DOaslBxATPkLiYUmqeCfYnF3BtWPmokw2',''),(4,1,'abc@abc.com','abc','abc','$2a$10$bKQT7ZxuSXNrfF5IHOIioea/k4yGNqdR2GZhHrNzqDq5QUOR/FZ8i','12345678'),(8,1,'a@a.a','a','a','$2a$10$8K4qkFaPyh9T93YXPxFHPukijvN0czL3shc6etFH8hkHK1WKZ0Yhi','1234'),(10,1,'z@z','z','z','$2a$10$9j/We3Le9p990rE.ETtV4OGSyfkzLrUs3WCn9x/l.KYJ8LUaKyeLK','12345678'),(11,1,'1@1','1','1','$2a$10$bFye0eRUnwNugq7Cw/W0o.UQUAEz8A0aSDynM0I2E/R3qppqX/mRK','1'),(12,1,'2@2','2','2','$2a$10$4mS.0V.SLZ1.FJSYOKwi9.2Ee0p9zyBTmjxuEZt0wGJsLMQSxmMRS','2'),(13,1,'3@3','3','3','4df45a45-6c92-4afe-93fb-67b5369c78af','3'),(14,1,'4@4','4','4','$2a$10$R3mp.WeImBMuawT3EHIvIOBuUK/Zx2HWNrDOAcrAsDX6fpoEAstL2','4'),(15,1,'5@5','5','5','$2a$10$CzM8nnliT3FxHet88goz.ef4AnORGpS3LNEb/.T/Y3hES1UyUoLxu','5'),(16,1,'6@6','6','6','$2a$10$uMap.kUd8j/wMzalsE3Qz.aphsIncY90T010DfHYAdDVx06n.0sUS','6'),(17,1,'7@7','7','7','$2a$10$w8Wq6Z.B7NsHthxJKS8fb.VfCGedd8DBkBcOJ/fCZq8PFljaWX0Hq','7'),(18,1,'a@a','a','a','$2a$10$rFHJXTwlMuCYaPnARjEM1.SlMJcegJGy36lBIei8Nk3gxRk8/YhlO','12345'),(19,1,'x@x','x','x','$2a$10$5WcM3SAtEdWV2V20guIg/O4cFzmhBR7R21N/SYF0fWvD0YO18tci2','123'),(20,1,'paris@paris','fa','paris','$2a$10$pVizn89SlIlAGHQnxdSjmOhXPe3gSEuV2AjWIBXwsOLrdAK2Rvdqq','12345678'),(21,1,'5@1','5','5','$2a$10$HRJsEQPDRRJATWQ5vxc.XO8OyEMRsbkbzseWj94Orq6nWAJbY1OdO','1234'),(22,1,'d@1','d','d','$2a$10$LpWmrjSf3siGZn4m.Xu5kuSM9NSo8DSkuSPWUWJ8AQyZdHaGTEElm','1234'),(23,1,'1@s','b','a','$2a$10$R/y4SDfrjl6At4EuJkMSc.e62zBDeZRxhK89fAWbR4OxDL2J.vFJe','1234567'),(24,1,'a@z','z','z','$2a$10$kOUsuZOFuScja8056nn1RuIDBsVKTzmyHBrb.m5NXJMNP66pN2C22','123'),(25,1,'sumtre@163.com','jie','wang','$2a$10$hZs3zk5.XW3pZtpc2hEJWunG37Ycjnm3IiX8tj4yhMGK.Aw3xHEgK','13188883333');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(23,1),(24,1),(25,1),(20,2),(21,2),(22,2);

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_user_id` int(11) NOT NULL,
  `roles_role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_id`,`roles_role_id`),
  UNIQUE KEY `UK_k842jdphuagyv3uaybx7kyjhb` (`roles_role_id`),
  CONSTRAINT `FKhxmmg8j4h4qpwbvf39cnujlkf` FOREIGN KEY (`roles_role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKkv46dn3qakjvsk7ra33nd5sns` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_roles` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
