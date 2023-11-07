CREATE DATABASE IF NOT EXISTS `company` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION = 'N' */;
USE `company`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee`
(
    `ID`             bigint NOT NULL AUTO_INCREMENT,
    `DATEEMPLOYMENT` date         DEFAULT NULL,
    `JOBTITLE`       varchar(255) DEFAULT NULL,
    `NAME`           varchar(255) DEFAULT NULL,
    `SALARY`         double       DEFAULT NULL,
    `SURNAME`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee`
    DISABLE KEYS */;
INSERT INTO `employee`
VALUES (1, '2013-11-12', 'Administrativo', 'María', 1245.15, 'Gracía García'),
       (2, '2022-12-12', 'Programador junior', 'Francisco Matías', 1452.12, 'Molina Jurado'),
       (3, '2010-12-25', 'Programador senior', 'Carlos', 2450.45, 'Jimenez García'),
       (4, '2020-05-26', 'Analista', 'Hugo', 2002.45, 'Molina Rienda'),
       (5, '2021-08-24', 'Contabilidad', 'Noemi', 1564.23, 'Rienda Rodriguez'),
       (6, '2015-02-18', 'Contabilidad', 'Óscar', 2120.12, 'García Hernández'),
       (7, '2005-01-19', 'Analista', 'Julio', 2300.5, 'Molina Jimenez'),
       (8, '2001-03-28', 'Administrativo', 'Lucía', 2451.25, 'Pérez Garbañosa'),
       (9, '2006-04-29', 'Programador senior', 'Alejandro', 2614.45, 'García Gracia'),
       (10, '2017-09-26', 'Programador senior', 'Maria del Carmen', 2310.45, 'Fernandez Fernandez'),
       (11, '2011-08-05', 'Administrativo', 'Noelia', 1561.12, 'Guzmán Guzmán'),
       (12, '2021-08-05', 'Analista', 'Julian', 1452.14, 'Torres Torres'),
       (13, '2018-06-02', 'Contabilidad', 'Agustín', 1452.12, 'Berlanga García'),
       (14, '2022-12-05', 'Programador junior', 'Alicia', 1241.14, 'García Molina'),
       (15, '2023-01-12', 'Programador junior', 'Verónica', 1452.25, 'Pérez Aragón'),
       (16, '2023-03-12', 'Programador senior', 'Lourdes', 2478.45, 'Chacón Vigo');
/*!40000 ALTER TABLE `employee`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'company'
--

--
-- Dumping routines for database 'company'
--
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2023-11-07  0:42:33
