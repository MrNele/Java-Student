/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.3.15-MariaDB : Database - studentapp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentapp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studentapp`;

/*Table structure for table `predmet` */

DROP TABLE IF EXISTS `predmet`;

CREATE TABLE `predmet` (
  `sifra` varchar(20) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `brojESPB` int(3) DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `predmet` */

insert  into `predmet`(`sifra`,`naziv`,`brojESPB`) values 
('111EKO','Ekonomija',6),
('111MAT','Matematika',8),
('111STA','Statistika',7);

/*Table structure for table `prijava` */

DROP TABLE IF EXISTS `prijava`;

CREATE TABLE `prijava` (
  `brojIndeksa` varchar(20) NOT NULL,
  `sifraPredmeta` varchar(20) NOT NULL,
  `datum` date NOT NULL,
  `ocena` int(2) DEFAULT NULL,
  PRIMARY KEY (`brojIndeksa`,`sifraPredmeta`,`datum`),
  KEY `sifraPredmeta` (`sifraPredmeta`),
  KEY `brojIndeksa` (`brojIndeksa`),
  CONSTRAINT `prijava_ibfk_1` FOREIGN KEY (`brojIndeksa`) REFERENCES `student` (`brojIndeksa`) ON UPDATE CASCADE,
  CONSTRAINT `prijava_ibfk_2` FOREIGN KEY (`sifraPredmeta`) REFERENCES `predmet` (`sifra`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `prijava` */

insert  into `prijava`(`brojIndeksa`,`sifraPredmeta`,`datum`,`ocena`) values 
('0001/2019','111EKO','2019-12-28',8),
('0001/2019','111MAT','2019-12-29',9),
('0002/2019','111EKO','2019-12-28',9),
('0002/2019','111STA','2019-12-28',10),
('0003/2019','111MAT','2019-12-27',10),
('0003/2019','111STA','2019-12-29',9);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `brojIndeksa` varchar(20) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`brojIndeksa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`brojIndeksa`,`ime`,`prezime`) values 
('0001/2019','Ana','Anic'),
('0002/2019','Sanja','Sanjic'),
('0003/2019','Marko','Markovic');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
