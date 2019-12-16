/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.2.29-MariaDB : Database - aliotosale_app
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aliotosale_app` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aliotosale_app`;

/*Table structure for table `merk` */

DROP TABLE IF EXISTS `merk`;

CREATE TABLE `merk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `merk` */

insert  into `merk`(`id`,`brand`,`created_at`,`updated_at`) values 
(1,'YAMAHA','2019-12-15 15:03:30','2019-12-15 15:03:32'),
(2,'HONDA','2019-12-15 15:03:30','2019-12-15 15:03:32'),
(5,'FERARI','2019-12-15 15:03:30','2019-12-15 08:40:25');

/*Table structure for table `mobil` */

DROP TABLE IF EXISTS `mobil`;

CREATE TABLE `mobil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `merk_id` bigint(20) DEFAULT NULL,
  `nomor` int(11) DEFAULT NULL,
  `nomor_kerangka` bigint(20) DEFAULT NULL,
  `seri` varchar(255) DEFAULT NULL,
  `seri_wilayah` varchar(255) DEFAULT NULL,
  `tahun` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `mobil` */

insert  into `mobil`(`id`,`created_at`,`merk_id`,`nomor`,`nomor_kerangka`,`seri`,`seri_wilayah`,`tahun`,`type_id`,`updated_at`) values 
(14,'2019-12-16 11:59:24',1,123,12323323423534,'jk','b','2014',1,'2019-12-16 11:59:24'),
(16,'2019-12-16 12:10:22',2,8989,12342324232222,'kk','b','2011',2,'2019-12-16 12:25:34'),
(17,'2019-12-16 12:10:54',5,8765,12323323421231,'ky','bk','2019',3,'2019-12-16 12:10:54');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`created_at`,`nama`,`updated_at`) values 
(1,'2019-12-15 18:11:29','scorpio','2019-12-15 18:11:33'),
(2,'2019-12-15 18:11:29','Civic','2019-12-15 18:11:33'),
(3,'2019-12-15 18:11:29','Enzo','2019-12-15 18:11:33');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
