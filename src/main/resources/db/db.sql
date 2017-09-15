/*
SQLyog v10.2 
MySQL - 5.5.23 : Database - recivedemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`recivedemo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

 USE `recivedemo`;
 
 DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `elevator_type`;
CREATE TABLE `elevator_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `elevator_type` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `elevator_model`;
CREATE TABLE `elevator_model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `elevator_model` varchar(255) NOT NULL,
  PRIMARY KEY (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orgnization`;
CREATE TABLE `orgnization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_type` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `organization_name` varchar(255) NOT NULL,
   `phone` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into orgnization values(1,'Mantainer','organizaiton1','email@email.com','12345678','address1');

DROP TABLE IF EXISTS `alarm_type`;
CREATE TABLE `alarm_type` (
  `alarm_id` int(11) NOT NULL AUTO_INCREMENT,
  `alarm_type` varchar(255) NOT NULL,
  PRIMARY KEY (`alarm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `maintenance_type`;
CREATE TABLE `maintenance_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `maintenance_type` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into maintenance_type values(1,'CHECK1');

DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE `manufacturer` (
  `manufacturer_id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer_name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL ,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into manufacturer values(1,'manufacturerA',11111111,'AddressA','DescrptionA');


DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `deviceid` int(11) NOT NULL AUTO_INCREMENT,
  `device_name` varchar(255) NOT NULL,
  PRIMARY KEY (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into device values(12345678,'Elevator1');

/*Table structure for table `tb_elevatorstatus` */

DROP TABLE IF EXISTS `tb_elevatorstatus`;

CREATE TABLE `tb_elevatorstatus` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rtuid` varchar(8) DEFAULT NULL,
  `datatime` varchar(30) DEFAULT NULL COMMENT '�ɼ�ʱ��',
  `sendtime` varchar(30) DEFAULT NULL COMMENT '����ʱ��',
  `floor` varchar(10) DEFAULT NULL COMMENT '¥��',
  `rundirection` varchar(10) DEFAULT NULL COMMENT '�������з���',
  `doorstatus` varchar(10) DEFAULT NULL COMMENT '������״̬',
  `bodystatus` varchar(10) DEFAULT NULL COMMENT '�������Ƿ�����',
  `sensorstatus` varchar(10) DEFAULT NULL COMMENT '������״̬',
  `elevatorspeed` varchar(10) DEFAULT NULL COMMENT '�����ٶ�״̬',
  `midstop` varchar(10) DEFAULT NULL COMMENT '���ݷ�ƽ��ֹͣ',
  `trap` varchar(10) DEFAULT NULL COMMENT '��������',
  `Illegalopen` varchar(10) DEFAULT NULL COMMENT '���ݷ�ƽ�㿪��',
  `elevatorOverup` varchar(10) DEFAULT NULL COMMENT '���ݳ嶥',
  `elevatorOverdown` varchar(10) DEFAULT NULL COMMENT '���ݶ׵�',
  `mp` double(10,3) DEFAULT NULL COMMENT '����Դ��ѹ',
  `bp` double(10,3) DEFAULT NULL COMMENT '���õ�Դ��ѹ',
  `recordid` int(10) NOT NULL COMMENT '��¼id',
  `elevator_overup` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hkj` (`recordid`),
  CONSTRAINT `FK4y07watnqbh99vxyvv66s0ttv` FOREIGN KEY (`recordid`) REFERENCES `tb_record` (`recordId`),
  CONSTRAINT `hkj` FOREIGN KEY (`recordid`) REFERENCES `tb_record` (`recordId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_elevatorstatus` */

insert  into `tb_elevatorstatus`(`id`,`rtuid`,`datatime`,`sendtime`,`floor`,`rundirection`,`doorstatus`,`bodystatus`,`sensorstatus`,`elevatorspeed`,`midstop`,`trap`,`Illegalopen`,`elevatorOverup`,`elevatorOverdown`,`mp`,`bp`,`recordid`,`elevator_overup`) values (1,NULL,NULL,NULL,'Level1','up1','open1','no1',NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,212,NULL),(8,NULL,NULL,NULL,'123','123','123','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,213,NULL);
