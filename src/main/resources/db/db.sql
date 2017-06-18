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