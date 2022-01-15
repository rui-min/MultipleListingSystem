CREATE DATABASE  IF NOT EXISTS `realproperty` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `realproperty`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: realproperty
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `p_type` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `build_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `no_parking_space` int DEFAULT NULL,
  `no_storage` int DEFAULT NULL,
  `storage_type` varchar(255) DEFAULT NULL,
  `unit_number` int DEFAULT NULL,
  `is_multi_gen` bit(1) DEFAULT NULL,
  `floors` int DEFAULT NULL,
  `family_type` varchar(255) DEFAULT NULL,
  `ownership` varchar(255) DEFAULT NULL,
  `n_of_units` int DEFAULT NULL,
  `is_high_value` bit(1) DEFAULT NULL,
  `is_new` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES ('VacationHome',1,'a',1111111,NULL,'2022-01-10',0,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,NULL,NULL),('Land',2,'b',1100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',3,'c',1100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',4,'d',1100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',5,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',6,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',7,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',8,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',9,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',10,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',11,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',12,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',13,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',14,'az',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',15,'az',1000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',16,'az',1000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',17,'a',1111111,NULL,'2022-01-10',0,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,NULL,NULL),('VacationHome',18,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',19,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',20,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',21,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',22,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',23,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',24,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',25,'a',1111111,'1900-01-01','2022-01-10',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',26,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',27,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',28,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',29,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',30,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',31,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',32,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',33,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',34,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',35,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',36,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',37,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',38,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',39,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',40,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',41,'a',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('Land',42,'a',1000000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',43,'ezza',10000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',44,'b',110000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('VacationHome',45,'bza',1111111,'1900-01-01','2022-01-15',1,0,NULL,NULL,_binary '\0',0,NULL,NULL,NULL,_binary '',_binary '\0'),('VacationHome',46,'edf',1111,'1900-01-01','2022-01-15',1,1,'small',NULL,_binary '',3,NULL,NULL,NULL,_binary '\0',_binary '\0'),('StackedTownHouse',47,'zef',221111,'1900-01-01','2022-01-15',1,2,NULL,4,NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0'),('StackedTownHouse',48,'abc',321111,'1900-01-01','2022-01-15',1,2,NULL,4,NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0'),('StackedTownHouse',49,'zef',221111,'1900-01-01','2022-01-15',1,2,NULL,4,NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0'),('StackedTownHouse',50,'abc',321111,'1900-01-01','2022-01-15',1,2,NULL,7,NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0'),('StackedTownHouse',51,'ezez',821111,'1900-01-01','2022-01-15',1,2,NULL,4,NULL,NULL,NULL,NULL,NULL,_binary '',_binary '\0'),('MultiLex',52,'bza',111111,'1900-01-01','2022-01-15',1,1,'small',NULL,_binary '',3,NULL,NULL,NULL,_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-15 18:31:03
