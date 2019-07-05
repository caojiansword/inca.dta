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

insert  into `pub_user`(`id`,`userName`,`password`,`userCode`,`phone`,`createTime`,`updateTime`,`createUserId`) values (1,'admin','123456','admin','13111705684','2019-07-05',NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
