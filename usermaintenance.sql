-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: usermaintenance
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `useractivitymaster`
--
drop  database if  exists usermaintenance   ;
	create database usermaintenance;
	use usermaintenance;

DROP TABLE IF EXISTS `useractivitymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useractivitymaster` (
  `userid` int(11) DEFAULT NULL,
  `activityid` int(11) NOT NULL AUTO_INCREMENT,
  `logintime` varchar(50) DEFAULT NULL,
  `logouttime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`activityid`),
  KEY `userid` (`userid`),
  CONSTRAINT `useractivitymaster_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `usermaster` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useractivitymaster`
--

LOCK TABLES `useractivitymaster` WRITE;
/*!40000 ALTER TABLE `useractivitymaster` DISABLE KEYS */;
INSERT INTO `useractivitymaster` VALUES (1,1,'2018-09-22 05:18:56',NULL),(1,2,'2018-09-22 05:34:57',NULL),(1,3,'2018-09-22 05:35:27',NULL),(1,4,'2018-09-22 05:38:07',NULL),(1,5,'2018-09-22 05:40:21',NULL),(1,6,'2018-09-22 07:53:14','2018-09-22 07:53:22'),(1,7,'2018-09-22 07:53:37','2018-09-22 07:54:01');
/*!40000 ALTER TABLE `useractivitymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `userid` int(11) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `usertype` varchar(20) DEFAULT NULL,
  `userstatus` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `contactno` varchar(20) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'admin','admin','administrator',1,'Naughty','9417576294','naughty111198@gmail.com','11-11-1998','pathankot'),(2,'1234','sanju','Administrator',1,'sanju','9867451245','sanju11@gmail.com','12-11-2000','punjab'),(3,'1234','navi','Administrator',1,'navi','9876512346','navi@gmail.com','15-09-1999','chd');
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-22  7:59:46
