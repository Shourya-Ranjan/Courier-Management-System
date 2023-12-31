CREATE DATABASE  IF NOT EXISTS `courier` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `courier`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: courier
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `courier`
--

DROP TABLE IF EXISTS `courier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courier` (
  `CourierId` int NOT NULL AUTO_INCREMENT,
  `SenderName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  `SenderAddress` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ReceiverName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ReceiverAddress` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Weight` decimal(5,2) DEFAULT NULL,
  `Status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TrackingNumber` int DEFAULT NULL,
  `DeliveryDate` date DEFAULT NULL,
  `empId` int DEFAULT NULL,
  PRIMARY KEY (`CourierId`),
  UNIQUE KEY `TrackingNumber_UNIQUE` (`TrackingNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courier`
--

LOCK TABLES `courier` WRITE;
/*!40000 ALTER TABLE `courier` DISABLE KEYS */;
INSERT INTO `courier` VALUES (1,'John Doe',NULL,'123 Main St, Cityville','Jane Smith','456 Oak St, Townsville',2.50,'In-Transit',123456,'2023-01-15',NULL),(2,'Alice Johnson',NULL,'789 Pine St, Villageton','Bob Brown','567 Elm St, Hamletville',3.70,'Delivered',789012,'2023-02-05',NULL),(3,'Eva Davis',NULL,'890 Cedar St, Countryside','Michael White','678 Maple St, Suburbia',1.80,'Pending',345678,NULL,NULL),(4,'Olivia Green',NULL,'901 Birch St, Outskirts','Daniel Black','234 Pine St, Farmland',4.20,'In Transit',901234,NULL,NULL),(5,'Sophia Grey',NULL,'567 Oak St, Riverside','William Taylor','890 Cedar St, Mountainside',5.50,'Delivered',567890,'2023-03-20',NULL),(6,'David Johnson',NULL,'234 Birch St, Lakeside','Emily White','789 Maple St, Hilltop',2.00,'Pending',234567,NULL,NULL),(7,'Isabella Brown',NULL,'890 Oak St, Valleyview','Matthew Davis','345 Pine St, Lakeside',3.30,'In Transit',890123,NULL,NULL),(12,'Shourya',2,'Delhi','Ankit','Dehradun',9.00,'Pending',1003828,'2023-12-29',1),(14,'Dinesh',2,'Chennai','XYZ','Delhi',78.00,'In-Transit',893653,'2023-12-29',1),(15,'Himanshu',2,'Saharanpur','Narendra Modi','PMO Delhi',0.10,'Pending',762817,'2023-12-29',1),(16,'Raj Patel',2,'567, Brigade Road, Bangalore','Neha Gupta','890, MG Road, Pune',5.00,'Pending',961338,'2023-12-29',10),(17,'Rahul Sharma',3,'321, Civil Lines, Lucknow','Himanshu','Saharanpur',1.80,'Pending',961339,'2023-12-29',11),(18,'Himanshu',4,'Saharanpur','Shourya','Delhi',8.00,'Pending',961340,'2023-12-29',11),(19,'Dinesh',2,'Chittoor','Amit Shah','Home Minister office',5.00,'Pending',961341,'2023-12-29',7);
/*!40000 ALTER TABLE `courier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courierservices`
--

DROP TABLE IF EXISTS `courierservices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courierservices` (
  `ServiceId` int NOT NULL,
  `ServiceName` varchar(100) DEFAULT NULL,
  `Cost` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`ServiceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courierservices`
--

LOCK TABLES `courierservices` WRITE;
/*!40000 ALTER TABLE `courierservices` DISABLE KEYS */;
INSERT INTO `courierservices` VALUES (1,'Standard Delivery',10.99),(2,'Express Delivery',25.99),(3,'Next-Day Delivery',19.99),(4,'International Shipping',45.99),(5,'Same-Day Delivery',35.99);
/*!40000 ALTER TABLE `courierservices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EmployeeId` int NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `ContactNumber` varchar(20) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'John Smith','john.smith@example.com','123-456-7890','Manager',75000.00),(2,'Alice Johnson','alice.johnson@example.com','987-654-3210','Developer',60000.00),(3,'Bob Brown','bob.brown@example.com','234-567-8901','Sales Representative',50000.00),(4,'Eva Davis','eva.davis@example.com','345-678-9012','HR Specialist',55000.00),(5,'Michael White','michael.white@example.com','456-789-0123','Designer',65000.00),(6,'Olivia Green','olivia.green@example.com','567-890-1234','Accountant',60000.00),(7,'Daniel Black','daniel.black@example.com','678-901-2345','Project Manager',80000.00),(8,'Sophia Grey','sophia.grey@example.com','789-012-3456','Data Analyst',55000.00),(9,'William Taylor','william.taylor@example.com','890-123-4567','IT Support',48000.00),(10,'Emma Davis','emma.davis@example.com','901-234-5678','Marketing Specialist',60000.00),(11,'Priya Sharma','priya.sharma@example.com','87654-32109','Developer',60000.00);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `LocationId` int NOT NULL,
  `LocationName` varchar(100) DEFAULT NULL,
  `Address` text,
  PRIMARY KEY (`LocationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Headquarters','123 Main St, Cityville'),(2,'Branch A','456 Oak St, Townsville'),(3,'Branch B','789 Pine St, Villageton'),(4,'Warehouse 1','567 Elm St, Hamletville'),(5,'Warehouse 2','890 Cedar St, Countryside'),(6,'Office 1','678 Maple St, Suburbia'),(7,'Office 2','901 Birch St, Outskirts'),(8,'Distribution Center','234 Pine St, Farmland'),(9,'Regional Office','567 Oak St, Riverside'),(10,'Service Center','890 Cedar St, Mountainside');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `PaymentId` int NOT NULL,
  `CourierId` int DEFAULT NULL,
  `LocationId` int DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL,
  PRIMARY KEY (`PaymentId`),
  KEY `LocationId` (`LocationId`),
  KEY `payments_ibfk_1_idx` (`CourierId`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`CourierId`) REFERENCES `courier` (`CourierId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`LocationId`) REFERENCES `location` (`LocationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,1,1,20.50,'2023-01-20'),(2,2,2,35.75,'2023-02-25'),(3,3,3,15.20,'2023-03-15'),(4,4,4,50.00,'2023-04-10'),(5,5,5,30.80,'2023-05-05');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserId` int NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Contact_number` varchar(255) DEFAULT NULL,
  `address` text,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John Doe','john.doe@example.com','password123','1234567890','123 Main St, Cityville'),(2,'Jane Smith','jane.smith@example.com','pass456','9876543210','456 Oak St, Townsville'),(3,'Alice Johnson','alice.johnson@example.com','securepass','5551234567','789 Pine St, Villageton'),(4,'Bob Brown','bob.brown@example.com','brownbob','7890123456','567 Elm St, Hamletville'),(5,'Eva Davis','eva.davis@example.com','evapass','2345678901','890 Cedar St, Countryside'),(6,'Michael White','michael.white@example.com','mikepass','6789012345','678 Maple St, Suburbia'),(7,'Olivia Green','olivia.green@example.com','oliviapass','3456789012','901 Birch St, Outskirts'),(8,'Daniel Black','daniel.black@example.com','danpass','7890123456','234 Pine St, Farmland'),(9,'Sophia Grey','sophia.grey@example.com','sophiapass','1234567890','567 Oak St, Riverside'),(10,'William Taylor','william.taylor@example.com','willpass','2345678901','890 Cedar St, Mountainside');
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

-- Dump completed on 2023-12-29 11:14:04
