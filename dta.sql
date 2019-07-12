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
  `stopDate` date DEFAULT NULL,
  `onLineDate` date DEFAULT NULL,
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUserId` int(12) DEFAULT NULL COMMENT '创建人',
  `updateTime` date DEFAULT NULL COMMENT '更新时间',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `pub_customer` */

insert  into `pub_customer`(`id`,`customerCode`,`customerName`,`domain`,`type`,`orgCode`,`status`,`phoneNo`,`stopDate`,`onLineDate`,`createTime`,`createUserId`,`updateTime`,`memo`) values (1,'CS0001','京东科创大药房','dev.yydtls.incayun.com',1,'00123242342',1,'18867890987','2019-12-20','2019-01-01','2019-01-01',1,NULL,NULL),(7,'CS002378','45','45',2,'45',2,'45','2019-07-12',NULL,NULL,NULL,NULL,NULL),(11,'CS0002','北京英克科技有限公司','1',2,'1',1,'1832286475',NULL,'2019-07-12',NULL,NULL,NULL,NULL),(12,'454699','676799','67699',2,'67699',0,'676799',NULL,NULL,NULL,NULL,NULL,NULL),(17,'CS0004','yuyu','yuy',3,'yuyu',0,'18317723465',NULL,NULL,NULL,NULL,NULL,NULL),(19,'CS0003','北京英克科技有限公司','dev.yydtls.incayun',3,'ibs3457',0,'1832387435',NULL,NULL,NULL,NULL,NULL,NULL),(20,'CS00396','北京客户','weret',2,'werert',2,'wetrt','2019-07-12','2019-07-12',NULL,NULL,NULL,NULL),(22,'455666','6666','666',2,'666',2,'666','2019-07-12',NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `sys_weblog` */

insert  into `sys_weblog`(`id`,`accessTime`,`ip`,`webType`,`methodPath`,`methodName`,`args`,`result`,`msg`,`url`,`createTime`) values (58,'2019-07-12 18:04:24','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@23c4147a',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:04:24'),(59,'2019-07-12 18:07:11','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@1bfc0c27',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:07:11'),(60,'2019-07-12 18:11:37','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@20c43e38',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:11:37'),(61,'2019-07-12 18:12:43','0:0:0:0:0:0:0:1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3906196b',1,'调用成功','http://localhost:8088/submitlogin','2019-07-12 18:12:43'),(62,'2019-07-12 18:19:06','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@3038460a',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:19:06'),(63,'2019-07-12 18:25:28','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@4d332092',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:25:28'),(64,'2019-07-12 18:30:51','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@22ccf33a',1,'调用成功','http://youhaoshiye.cn.segmentfault.com/submitlogin','2019-07-12 18:30:51'),(65,'2019-07-12 18:39:43','127.0.0.1',1,'com.inca.controller.login.LoginController','submitlogin','[Ljava.lang.Object;@7a60a5fc',1,'调用成功','http://dta.incayun.com/submitlogin','2019-07-12 18:39:43');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
