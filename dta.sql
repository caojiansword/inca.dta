/*
SQLyog Ultimate v8.32 
MySQL - 8.0.16 : Database - dta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dta` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `dta`;

/*Table structure for table `pub_customer` */

DROP TABLE IF EXISTS `pub_customer`;

CREATE TABLE `pub_customer` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `customerCode` varchar(20) NOT NULL COMMENT '客户编码',
  `customerName` varchar(50) NOT NULL COMMENT '客户名称',
  `domain` varchar(100) NOT NULL COMMENT '域名',
  `type` int(10) DEFAULT NULL,
  `orgCode` varchar(30) DEFAULT NULL COMMENT '组织机构代码',
  `status` int(2) DEFAULT NULL,
  `phoneNo` varchar(20) DEFAULT NULL,
  `stopDate` datetime DEFAULT NULL,
  `onLineDate` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUserId` int(12) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `pub_customer` */

insert  into `pub_customer`(`id`,`customerCode`,`customerName`,`domain`,`type`,`orgCode`,`status`,`phoneNo`,`stopDate`,`onLineDate`,`createTime`,`createUserId`,`updateTime`,`memo`) values (1,'CS0001','京东科创大药房','dev.yydtls.incayun.com',1,'00123242342',1,'18867890987',NULL,'2019-07-15 10:15:11','2019-01-01 00:00:00',1,NULL,NULL),(7,'CS002378','45','45',2,'45',2,'45','2019-07-12 00:00:00',NULL,NULL,NULL,NULL,NULL),(11,'CS0002','北京英克科技有限公司','1',2,'1',1,'1832286475',NULL,'2019-07-12 00:00:00',NULL,NULL,NULL,NULL),(12,'KH0002','676799','67699',2,'67699',0,'676799',NULL,NULL,NULL,NULL,NULL,NULL),(17,'CS0004','yuyu','yuy',3,'yuyu',0,'18317723465',NULL,NULL,NULL,NULL,NULL,NULL),(19,'CS0003','北京英克科技有限公司','dev.yydtls.incayun',3,'ibs3457',0,'1832387435',NULL,NULL,NULL,NULL,NULL,NULL),(20,'CS00396','北京客户','weret',2,'werert',1,'wetrt',NULL,'2019-07-15 10:15:11',NULL,NULL,NULL,NULL),(22,'455666','6666','666',2,'666',1,'666',NULL,'2019-07-15 10:15:11',NULL,NULL,NULL,NULL),(24,'KH0001','1','1',2,'1',1,'1',NULL,'2019-07-15 10:15:11','2019-07-15 09:41:08',NULL,NULL,NULL),(30,'KH0003','2','2',2,'2',2,'2','2019-07-15 10:00:15','2019-07-15 10:00:11','2019-07-15 09:58:57',NULL,NULL,NULL),(31,'KH0004','测试客户1','dev.yydtls.incayun.com',2,'',1,'',NULL,'2019-07-15 10:07:45','2019-07-15 09:59:34',NULL,NULL,NULL),(32,'cs0005','1','1',2,'1',0,'1',NULL,NULL,'2019-07-15 11:26:05',NULL,NULL,NULL);

/*Table structure for table `pub_user` */

DROP TABLE IF EXISTS `pub_user`;

CREATE TABLE `pub_user` (
  `id` int(12) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userCode` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `createTime` date NOT NULL,
  `updateTime` date DEFAULT NULL,
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pub_user` */

insert  into `pub_user`(`id`,`userName`,`password`,`userCode`,`phone`,`createTime`,`updateTime`,`createUserId`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','admin','13111705684','2019-07-05',NULL,1);

/*Table structure for table `sys_weblog` */

DROP TABLE IF EXISTS `sys_weblog`;

CREATE TABLE `sys_weblog` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `accessTime` datetime NOT NULL,
  `ip` varchar(100) NOT NULL,
  `webType` int(2) NOT NULL,
  `methodPath` varchar(100) NOT NULL,
  `methodName` varchar(50) NOT NULL,
  `args` varchar(20000) NOT NULL,
  `result` tinyint(1) NOT NULL,
  `msg` varchar(1000) NOT NULL,
  `url` varchar(100) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Data for the table `sys_weblog` */

insert  into `sys_weblog`(`id`,`accessTime`,`ip`,`webType`,`methodPath`,`methodName`,`args`,`result`,`msg`,`url`,`createTime`) values (58,'2019-07-12 18:04:24','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@23c4147a',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:04:24'),(59,'2019-07-12 18:07:11','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@1bfc0c27',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:07:11'),(60,'2019-07-12 18:11:37','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@20c43e38',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:11:37'),(61,'2019-07-12 18:12:43','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3906196b',1,'调用成功','http://localhost:8088/submitlogin','2019-07-12 18:12:43'),(62,'2019-07-12 18:19:06','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3038460a',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:19:06'),(63,'2019-07-12 18:25:28','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@4d332092',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:25:28'),(64,'2019-07-12 18:30:51','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@22ccf33a',1,'调用成功','http://youhaoshiye.cn.segmentfault.com/submitlogin','2019-07-12 18:30:51'),(65,'2019-07-12 18:39:43','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@7a60a5fc',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:39:43'),(66,'2019-07-12 18:46:15','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@2b5f14bb',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:46:15'),(67,'2019-07-12 18:49:36','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@27ec2f7b',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:49:36'),(68,'2019-07-12 18:48:32','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@791238a9',1,'调用成功','http://localhost:8088/submitlogin','2019-07-12 18:48:32'),(69,'2019-07-12 18:53:23','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@449c4a0e',1,'调用成功','http://localhost:8088/submitlogin','2019-07-12 18:53:23'),(70,'2019-07-12 18:57:26','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@52a2468b',1,'调用成功','http://localhost:8088/submitlogin','2019-07-12 18:57:26'),(71,'2019-07-13 08:29:47','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@616af1e7',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-13 08:29:47'),(72,'2019-07-13 08:32:02','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@7f5a7a4a',1,'调用成功','http://localhost:8088/submitlogin','2019-07-13 08:32:02'),(73,'2019-07-15 08:58:15','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@6d46d794',1,'调用成功','http://localhost:8088/submitlogin','2019-07-15 08:58:15'),(74,'2019-07-15 10:07:05','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@2d68eaf',1,'调用成功','http://localhost:8088/submitlogin','2019-07-15 10:07:05'),(75,'2019-07-15 10:37:50','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@5b5df04a',1,'调用成功','http://localhost:8088/submitlogin','2019-07-15 10:37:50'),(76,'2019-07-15 11:12:10','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@48afb5db',1,'调用成功','http://localhost:8088/submitlogin','2019-07-15 11:12:10'),(77,'2019-07-15 14:27:23','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@64d29b65',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 14:27:23'),(78,'2019-07-15 14:39:06','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3ef00ab9',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 14:39:06'),(79,'2019-07-15 14:48:55','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@69e5b68b',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 14:48:55'),(80,'2019-07-15 14:56:39','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@755eb771',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 14:56:39'),(81,'2019-07-15 15:53:51','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@2fc36245',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 15:53:51'),(82,'2019-07-15 16:02:52','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@48f81d90',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:02:52'),(83,'2019-07-15 16:16:35','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@5ea4dac',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:16:35'),(84,'2019-07-15 16:20:42','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@5e155aed',1,'调用成功','http://localhost:8088/submitlogin','2019-07-15 16:20:42'),(85,'2019-07-15 16:34:58','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@55ac3fba',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:34:58'),(86,'2019-07-15 16:36:39','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@730ba437',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:36:39'),(87,'2019-07-15 16:39:56','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@6a55628b',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:39:56'),(88,'2019-07-15 16:44:44','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@54473778',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:44:44'),(89,'2019-07-15 16:51:23','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@63456a6c',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:51:23'),(90,'2019-07-15 16:56:40','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@6f0388bd',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 16:56:40'),(91,'2019-07-15 17:04:40','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@4648b658',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 17:04:40'),(92,'2019-07-15 17:14:52','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@5521989e',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 17:14:52'),(93,'2019-07-15 17:30:25','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@4729ef38',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 17:30:25'),(94,'2019-07-15 17:52:28','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@77003421',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-15 17:52:28'),(95,'2019-07-17 15:44:17','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@55a46c8e',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 15:44:17'),(96,'2019-07-17 17:55:05','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@2e073575',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 17:55:05'),(97,'2019-07-17 18:32:59','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@753a0915',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 18:32:59'),(98,'2019-07-17 18:34:51','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3535b5bf',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 18:34:51'),(99,'2019-07-17 18:59:30','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@77ac9f4f',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 18:59:30'),(100,'2019-07-17 19:07:49','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@652ef5e9',1,'调用成功','http://127.0.0.1/submitlogin','2019-07-17 19:07:49');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
