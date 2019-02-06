-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: programming_school
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.17.10.1

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
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'costam','costam costam'),(2,'Stuff','Doing it'),(3,'Stuff 2','Has to do it'),(4,'Hmm Improved','It\'s funky'),(5,'Hmmm Hmmm','Will never do it'),(6,'New Better','Same old'),(7,'Seven','Seven is my name');
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solution`
--

DROP TABLE IF EXISTS `solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `exercise_id` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exercise_id` (`exercise_id`),
  KEY `users_id` (`users_id`),
  CONSTRAINT `solution_ibfk_1` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`id`),
  CONSTRAINT `solution_ibfk_2` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solution`
--

LOCK TABLES `solution` WRITE;
/*!40000 ALTER TABLE `solution` DISABLE KEYS */;
INSERT INTO `solution` VALUES (1,'2018-12-16 16:44:27','2018-12-16 16:44:31','Now it\'s fine',1,1),(2,'2018-12-16 16:45:12','2018-12-16 16:45:15','It will never work',2,4),(3,'2018-12-16 16:45:53','2018-12-16 16:45:56','It\'s gone',3,3),(4,'2018-12-20 14:30:00','2018-12-21 13:02:21','It works',5,6),(5,'2018-12-16 16:36:55','2018-12-16 16:36:58','Hi',5,2),(6,'2018-12-16 16:46:15','2018-12-16 16:46:19','Ho',1,7),(7,'2018-12-26 08:51:38','2018-12-26 08:51:56','Trying',2,5),(8,'2018-12-26 08:52:17','2018-12-26 08:52:18','Doing it',3,1),(10,'2018-12-26 21:23:58',NULL,NULL,1,1),(11,'2018-12-26 21:48:30',NULL,NULL,5,5),(12,'2018-12-26 22:57:04',NULL,'I have no idea',3,1),(13,'2018-12-27 10:38:01',NULL,'Now it\'s working',2,1),(14,'2019-02-06 09:51:17',NULL,'aaaa',4,1);
/*!40000 ALTER TABLE `solution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group`
--

DROP TABLE IF EXISTS `user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group`
--

LOCK TABLES `user_group` WRITE;
/*!40000 ALTER TABLE `user_group` DISABLE KEYS */;
INSERT INTO `user_group` VALUES (5,'above standard'),(1,'Admin'),(10,'Dream Team'),(3,'Geeks'),(6,'Hell Riders'),(7,'I Know Now'),(8,'inna nazwa'),(12,'new'),(4,'new guys'),(11,'Newborns'),(9,'old guys'),(2,'User');
/*!40000 ALTER TABLE `user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `user_group_id` (`user_group_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'First','first@mail.com','12345',1),(2,'Kub','kub@mail.com','$2a$10$mZsL.4r7XPLo7zLSQOPV.eCKOXkk.aE6GMSw4qEp2m.PYyO64G/BO',5),(3,'Joe','joe@joe.com','$2a$10$pONzP7i.6yWi37aYDt/dDumU37yB2a46CIdPjsnsXmOmVCfuEp96C',1),(4,'Henryk','h@hhh.com','0987766',1),(5,'Boryna','bor@tutu.com','1',4),(6,'Bub','kub2@mail.com','$2a$10$TK3xPQG9XJhJjyKPwvyph.1yavremtVWxaR3cL8Uh5co7Ka5U.qVy',9),(7,'Seven','sev@ttt.com','7777777777',7),(8,'Jan','12121','$2a$10$QoG0yn4F2p2FhReVnTm4Yez.0ttDYQyfJru2QKEZfItwg3VqmrEHy',2),(10,'Cos','nnn@qqq','$2a$10$BwehB9Z6JWBJ.LHxH96nr.fIuyom/wrjtw4zspkXKX8Lg2y8/70Vy',8),(11,'George','george@georgetown.net','$2a$10$YU9lD4wDWz0a3rjvL7qFD.e7IaVBhqhW5a8p/YFLQJEBuHwX3XrMS',11),(12,'John Doe','kkk@kkk.com','$2a$10$NrrxGDCHYJOjFmpk/oAsAODQtEDBVJokM4sdT9dXqmYI7Ki7iuP6u',5),(13,'Michael Jackson','mj@bad.com','$2a$10$Z4L148mgm4/KypQTQ9NBbufI3rGpcfL73RcBD8G8V4P6cVyjak2Wi',2),(14,'Kub2','kub2@mail.com','$2a$10$BnChce6KQ2xd5purR82VyOMYSYjGM5N.C2unBWxBqKmHsuUvU2GSm',12);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 10:41:35
