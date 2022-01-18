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
  `is_high_value` bit(1) DEFAULT NULL,
  `is_new` bit(1) DEFAULT NULL,
  `no_parking_space` int DEFAULT NULL,
  `no_storage` int DEFAULT NULL,
  `storage_type` varchar(255) DEFAULT NULL,
  `unit_number` int DEFAULT NULL,
  `is_multi_gen` bit(1) DEFAULT NULL,
  `floors` int DEFAULT NULL,
  `family_type` varchar(255) DEFAULT NULL,
  `ownership` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES ('Land',1,'land318',1000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',2,'zab918',100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',3,'coooperativehome462',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',4,'zab155',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('MobileHome',5,'mobilehome276',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'single'),('MobileHome',6,'zab858',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'shared'),('FarmHouse',7,'framhouse693',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('FarmHouse',8,'zab961',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('MultiLex',9,'multilex555',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('MultiLex',10,'zab958',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('DetachedHome',11,'detachedhome589',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('DetachedHome',12,'zab22',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('VacationHome',13,'vacationhome366',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('VacationHome',14,'zab936',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TownHouse',15,'townhouse858',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('TownHouse',16,'zab260',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('SemiDetached',17,'semidetached598',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('SemiDetached',18,'zab722',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TripleDeckers',19,'tripledeckers173',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('TripleDeckers',20,'zab11',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('Condo',21,'condo800',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('Condo',22,'zab357',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('StackedTownHouse',23,'stackedtownhouse127',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('StackedTownHouse',24,'zab926',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('Land',25,'land564',1000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',26,'zab396',100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',27,'coooperativehome793',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',28,'zab231',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('MobileHome',29,'mobilehome265',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'single'),('MobileHome',30,'zab131',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'shared'),('FarmHouse',31,'framhouse450',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('FarmHouse',32,'zab929',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('MultiLex',33,'multilex309',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('MultiLex',34,'zab0',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('DetachedHome',35,'detachedhome930',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('DetachedHome',36,'zab391',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('VacationHome',37,'vacationhome29',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('VacationHome',38,'zab284',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TownHouse',39,'townhouse430',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('TownHouse',40,'zab543',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('SemiDetached',41,'semidetached580',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('SemiDetached',42,'zab930',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TripleDeckers',43,'tripledeckers638',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('TripleDeckers',44,'zab967',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('Condo',45,'condo792',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('Condo',46,'zab768',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('StackedTownHouse',47,'stackedtownhouse594',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('StackedTownHouse',48,'zab604',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('Land',49,'land493',1000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Land',50,'zab574',100000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',51,'coooperativehome135',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CooperativeHome',52,'zab835',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('MobileHome',53,'mobilehome931',1000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'single'),('MobileHome',54,'zab464',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'shared'),('FarmHouse',55,'framhouse666',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('FarmHouse',56,'zab500',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('MultiLex',57,'multilex297',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('MultiLex',58,'zab934',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('DetachedHome',59,'detachedhome382',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('DetachedHome',60,'zab86',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('VacationHome',61,'vacationhome294',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('VacationHome',62,'zab866',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TownHouse',63,'townhouse117',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('TownHouse',64,'zab136',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('SemiDetached',65,'semidetached79',1000,'2019-01-01','2022-01-18',_binary '\0',_binary '',0,NULL,'above',NULL,_binary '',3,NULL,NULL),('SemiDetached',66,'zab85',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'above',NULL,_binary '\0',NULL,'recommended',NULL),('TripleDeckers',67,'tripledeckers556',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('TripleDeckers',68,'zab37',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('Condo',69,'condo301',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('Condo',70,'zab279',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL),('StackedTownHouse',71,'stackedtownhouse522',1000,'2009-01-01','2022-01-18',_binary '\0',_binary '\0',0,NULL,'under',4,NULL,NULL,NULL,NULL),('StackedTownHouse',72,'zab621',100000,'1900-01-01','2022-01-18',_binary '\0',_binary '\0',2,1,'under',3,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-01-18 11:18:01
