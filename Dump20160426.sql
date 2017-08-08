-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: projectdb
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personId` int(11) NOT NULL AUTO_INCREMENT,
  `emailId` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  UNIQUE KEY `personId` (`personId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'vidya.viswakumar@gmail.com','Vidya','Viswakumar'),(2,'s','s','s'),(3,'d','d','d'),(4,'q','q','q'),(5,'p','p','p'),(6,'viy@ggh.com','i','i'),(15,'vidya.viswakumar@gmail.com','y','y');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleId` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Scrum-Master'),(3,'Developer'),(4,'QA');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprint`
--

DROP TABLE IF EXISTS `sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sprint` (
  `sprintId` int(11) NOT NULL AUTO_INCREMENT,
  `sprintName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sprintId`),
  UNIQUE KEY `sprintId` (`sprintId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint`
--

LOCK TABLES `sprint` WRITE;
/*!40000 ALTER TABLE `sprint` DISABLE KEYS */;
INSERT INTO `sprint` VALUES (1,'January'),(2,'February'),(3,'March'),(4,'April'),(5,'May');
/*!40000 ALTER TABLE `sprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `statusId` int(11) NOT NULL AUTO_INCREMENT,
  `statusName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`statusId`),
  UNIQUE KEY `statusId` (`statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Open'),(2,'In-Progress'),(3,'Resolved'),(4,'Reopened'),(5,'Completed'),(6,'In QA'),(7,'Ready for QA');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story` (
  `storyId` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `storyDescription` varchar(255) DEFAULT NULL,
  `storyTitle` varchar(255) DEFAULT NULL,
  `username` int(11) DEFAULT NULL,
  `personId` int(11) DEFAULT NULL,
  `sprintId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`storyId`),
  UNIQUE KEY `storyId` (`storyId`),
  KEY `FK68AF8F54C6A0855` (`username`),
  KEY `FK68AF8F576AAA6AF` (`personId`),
  KEY `FK68AF8F5E1F56983` (`sprintId`),
  KEY `FK68AF8F5995AEF33` (`statusId`),
  CONSTRAINT `FK68AF8F54C6A0855` FOREIGN KEY (`username`) REFERENCES `user` (`personId`),
  CONSTRAINT `FK68AF8F576AAA6AF` FOREIGN KEY (`personId`) REFERENCES `user` (`personId`),
  CONSTRAINT `FK68AF8F5995AEF33` FOREIGN KEY (`statusId`) REFERENCES `status` (`statusId`),
  CONSTRAINT `FK68AF8F5E1F56983` FOREIGN KEY (`sprintId`) REFERENCES `sprint` (`sprintId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (4,'u','u',6,'u','u',1,2,1,1),(5,'p','p',9,'p','p',1,2,1,1),(6,'uyyuiiu','8778',5,'uyuyuyi','yyuuy',1,2,1,1),(7,'DescriptionDescriptionDescription','2016-04-26',3,'Story Description 1','Story Title 1',3,2,2,1),(8,'DescriptionDescriptionDescriptionDescriptionDescription','2016-04-28',3,'Story Description 2','Story Title 2',1,2,2,1),(11,'Story Title 3','2016-04-05',2,'Story Title 3','Story Title 3',2,2,1,4),(13,'Story Title 3','2016-04-12',2,'Story Title 3','Story Title 3',2,2,4,5),(14,'jkhkjhkj','2016-04-04',2,'hkjh','kgjkhk',1,2,5,1);
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtask`
--

DROP TABLE IF EXISTS `subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subtask` (
  `subtaskId` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `createdDate` varchar(255) DEFAULT NULL,
  `isDefect` varchar(255) DEFAULT NULL,
  `subtaskDescription` varchar(255) DEFAULT NULL,
  `subtaskTitle` varchar(255) DEFAULT NULL,
  `username` int(11) DEFAULT NULL,
  `personId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `storyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`subtaskId`),
  UNIQUE KEY `subtaskId` (`subtaskId`),
  KEY `FK90AED3C54C6A0855` (`username`),
  KEY `FK90AED3C576AAA6AF` (`personId`),
  KEY `FK90AED3C5995AEF33` (`statusId`),
  KEY `FK90AED3C5BB647891` (`storyId`),
  KEY `FK90AED3C54BFCDF61` (`subtaskId`),
  CONSTRAINT `FK90AED3C54BFCDF61` FOREIGN KEY (`subtaskId`) REFERENCES `story` (`storyId`),
  CONSTRAINT `FK90AED3C54C6A0855` FOREIGN KEY (`username`) REFERENCES `user` (`personId`),
  CONSTRAINT `FK90AED3C576AAA6AF` FOREIGN KEY (`personId`) REFERENCES `user` (`personId`),
  CONSTRAINT `FK90AED3C5995AEF33` FOREIGN KEY (`statusId`) REFERENCES `status` (`statusId`),
  CONSTRAINT `FK90AED3C5BB647891` FOREIGN KEY (`storyId`) REFERENCES `story` (`storyId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtask`
--

LOCK TABLES `subtask` WRITE;
/*!40000 ALTER TABLE `subtask` DISABLE KEYS */;
INSERT INTO `subtask` VALUES (4,'kuhku','khj','Yes','jghjh','jygjhy',1,4,1,4),(5,'hkk','kjhkj','No','kjhkh','jh',1,1,1,4),(6,'Subtask1','2016-04-12','No','Subtask1','Subtask1',1,1,1,7),(7,'jhgjhg','2016-04-28','No','Subtask1','Subtask1',1,1,1,7),(8,'bmn','2016-04-07','No','Subtask2','Subtask2',1,1,1,7),(11,'Story Title 3','2016-04-13','No','Subtask1','Subtask1',3,2,3,13),(13,'kjhkj','mjhgbjh','No','hkjhkjh','jkhjkhkj',1,2,1,13);
/*!40000 ALTER TABLE `subtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `isAuthorized` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `personId` int(11) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `FK285FEB25165C3B` (`roleId`),
  KEY `FK285FEB5F413939` (`personId`),
  CONSTRAINT `FK285FEB25165C3B` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`),
  CONSTRAINT `FK285FEB5F413939` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('true','admin','admin',1,1),('true','s','s',2,2),('true','d','d',3,3),('true','q','q',4,4),('true','t','t',5,2),('true','i','i',6,2),('true','y','y',15,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  8:26:14
