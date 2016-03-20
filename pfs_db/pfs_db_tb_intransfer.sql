-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: pfs_db
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `tb_intransfer`
--

DROP TABLE IF EXISTS `tb_intransfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_intransfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountFrom` bigint(20) DEFAULT NULL,
  `accountTo` bigint(20) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_intransfer`
--

LOCK TABLES `tb_intransfer` WRITE;
/*!40000 ALTER TABLE `tb_intransfer` DISABLE KEYS */;
INSERT INTO `tb_intransfer` VALUES (1,1,2,100.00,'2015-11-03',NULL),(2,1,2,100.00,'2015-11-03',NULL),(3,1,2,512.26,'2015-11-04',NULL),(4,2,1,50.00,'2015-11-05',NULL),(5,1,2,87.00,'2015-11-05',NULL),(6,1,2,23.00,'2015-11-04',NULL),(7,1,2,23.00,'2015-11-10',NULL),(8,1,2,2.00,'2015-11-10',NULL),(9,1,2,2.00,'2015-11-10',NULL),(10,1,2,5222.00,'2015-11-12',NULL),(11,1,2,87.00,'2015-11-12',NULL),(12,2,2,87.00,'2015-11-12',NULL),(13,1,2,23.00,'2015-11-16',NULL),(14,2,1,23.00,'2015-11-16',NULL),(15,1,4,10.00,'2015-11-13',NULL),(16,4,1,20.00,'2015-11-04',NULL),(17,1,4,10.00,'2015-11-04',NULL),(18,1,2,10.00,'2015-11-16',NULL),(19,4,2,10.00,'2015-11-16',NULL),(20,2,1,80.00,'2015-11-17',NULL),(21,1,3,10.00,'2015-11-07',NULL),(22,1,3,10.00,'2015-11-07',NULL),(23,1,3,10.00,'2015-11-07',NULL),(24,1,3,10.00,'2015-11-07',NULL),(25,1,3,10.00,'2015-11-07',NULL),(26,1,3,10.00,'2015-11-07',NULL),(27,1,3,10.00,'2015-11-07',NULL),(28,1,3,10.00,'2015-11-07',NULL),(29,1,3,10.00,'2015-11-07',NULL),(30,1,3,10.00,'2015-11-07',NULL),(31,1,3,10.00,'2015-11-07',NULL),(32,1,3,10.00,'2015-11-17',NULL),(33,1,3,10.00,'2015-11-10',NULL),(34,2,1,10.00,'2015-11-17',NULL),(35,1,3,1000.00,'2015-11-18',NULL),(36,3,1,1000.00,'2015-11-18',NULL),(37,1,3,87.00,'2015-11-18',NULL),(38,1,2,87.00,'2015-11-12',NULL),(39,2,1,1.00,'2015-11-18',NULL);
/*!40000 ALTER TABLE `tb_intransfer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-29 11:50:52