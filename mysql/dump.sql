-- MySQL dump 10.13  Distrib 5.7.10, for Linux (x86_64)
--
-- Host: localhost    Database: accounts
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Current Database: `accounts`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `accounts` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `accounts`;

--
-- Table structure for table `ACCOUNT`
--

DROP TABLE IF EXISTS `ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACCOUNT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(50) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `emailAddress` (`emailAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCOUNT`
--

LOCK TABLES `ACCOUNT` WRITE;
/*!40000 ALTER TABLE `ACCOUNT` DISABLE KEYS */;
INSERT INTO `ACCOUNT` VALUES (19,'Davon','Sanders','2016-01-16 09:36:52','2016-01-16 09:36:52','deuvarneys2','deuvarney1@aol.com'),(21,'Deuvarney','Sanderson','2016-01-16 21:49:22','2016-01-16 21:49:22','deuvarneys','deuvarney@gmail.com'),(23,'Deuvarney','Sanderson','2016-01-16 21:56:12','2016-01-16 21:56:12','deuvarney3','deuvarney3@aol.com'),(24,'Deuvarney','Sanderson','2016-01-16 21:57:20','2016-01-16 21:57:20','deuvarney4','deuvarney4@yahoo.com'),(25,'Davon','Sanders','2016-01-16 22:04:56','2016-01-16 22:04:56','deuvarney5','deuvarney5@aol.co'),(26,'Deuvarney','Sanderson','2016-01-16 22:05:50','2016-01-16 22:05:50','deuvarney7','deuvarney7@aol.co'),(27,'Deuvarney','Sanderson','2016-01-16 22:08:18','2016-01-16 22:08:18','deuvarney8','deuvarne8@aol.com'),(28,'Deuvarney','Sanderson','2016-01-16 22:11:24','2016-01-16 22:11:24','deuvarney9','deuvarney9@aol.com'),(29,'Deuvarney','Sanderson','2016-01-16 22:17:57','2016-01-16 22:17:57','deuvarney10','deuvarney10@aol.com'),(30,'Deuvarney','Sanderson','2016-01-17 01:09:20','2016-01-17 01:09:20','deuvarney11','deuvarney11@aol.com'),(31,'Deuvarney','Sanderson','2016-01-17 01:12:17','2016-01-17 01:12:17','deuvarney12','deuvarney12@gmail.com'),(32,'Deuvarney','Sanderson','2016-01-17 02:00:25','2016-01-17 02:00:25','deuvarney13','deuvarney13@aol.com'),(33,'Deuvarney','Sanderson','2016-01-17 02:57:56','2016-01-17 02:57:56','deuvarney14','deuvarney14@aol.com'),(34,'Deuvarney','Sanderson','2016-01-17 03:47:04','2016-01-17 03:47:04','deuvarney15','deuvarney15@aol.com'),(35,'Deuvarney','Sanderson','2016-01-19 06:58:17','2016-01-19 06:58:17','deuvarney16','deuvarney16@aol.com');
/*!40000 ALTER TABLE `ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACCOUNTPASS`
--

DROP TABLE IF EXISTS `ACCOUNTPASS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACCOUNTPASS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `isCurrentPass` tinyint(1) NOT NULL DEFAULT '0',
  `passHash` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accountId` (`accountId`),
  CONSTRAINT `ACCOUNTPASS_ibfk_1` FOREIGN KEY (`accountId`) REFERENCES `ACCOUNT` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACCOUNTPASS`
--

LOCK TABLES `ACCOUNTPASS` WRITE;
/*!40000 ALTER TABLE `ACCOUNTPASS` DISABLE KEYS */;
INSERT INTO `ACCOUNTPASS` VALUES (1,19,1,'12345'),(3,21,1,'12345'),(5,23,1,'12345'),(6,24,1,'123456'),(7,25,1,'123456'),(8,26,1,'123456'),(9,27,1,'123456'),(10,28,1,'123456'),(11,29,1,'123456'),(12,30,1,'123456'),(13,31,1,'123456'),(14,32,1,'12345'),(15,33,1,'12345'),(16,34,1,'123456'),(17,35,1,'123456');
/*!40000 ALTER TABLE `ACCOUNTPASS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-31  3:05:30
