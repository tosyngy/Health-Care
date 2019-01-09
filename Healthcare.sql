-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.13-rc-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema healthcare
--

CREATE DATABASE IF NOT EXISTS healthcare;
USE healthcare;

--
-- Definition of table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `specilization` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `doctor`
--

/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`,`specilization`) VALUES 
 (1,'vikky0106','5334631234','vikky','sonagiri','3299692396','vikky0506@gmail.com','heart'),
 (2,'mujahid','12345','Mujahid','Chhatrapur','7489462985','islam02@rediffmail.com','Cancer Specialist'),
 (3,'reena','123','Reena','indore','9977016926','reena123@gmail.com','Heart'),
 (4,'rakesh','123','Rakesh','delhi','9977016926','rakesh123@gmail.com','Dentist'),
 (5,'mahesh','123','Mahesh Patidar','neemuch','9977016926','mahesh123@gmail.com','eye'),
 (6,'dinesh','123','Dinesh patidar','mumbai','9977016926','dinesh123@gmail.com','neurolgist'),
 (7,'sanjay','123','sanjay gupta','udaipur','9977016926','sanjay123@gmail.com','neurosurjan'),
 (8,'jyoti','123','jyoti patidar','pune','9977016926','jyoti123@gmail.com','child'),
 (9,'rachana','123','rachana Sharma','indore','9907929235','rachana123@gmail.com','child'),
 (10,'nisha','123','nisha','bhopal','9907929235','nisha123@gmail.com','Cancer'),
 (11,'ravina','123','ravina gupta','bhopal','9907929235','ravina123@gmail.com','cancer'),
 (12,'rahul','123','rahul sharma','inodre','997792923','rahul123@gmail.com','eye'),
 (13,'sunil','123','sunil patel','bhopal','9977019335','sunil008@gmail.com','dentist'),
 (14,'anil','123','anil patidar','udaipur','9977019293','anil123@gmail.com','neurologist'),
 (15,'reema','123','reema mishra','indore','9977010234','reema123@gmail.com','child'),
 (16,'kavita','123','kavita gupta','bhopal','9977041234','kavita123@gmail.com','neurosurjan');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


--
-- Definition of table `lab`
--

DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `lid` int(10) unsigned NOT NULL auto_increment,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `phone no` varchar(45) NOT NULL,
  PRIMARY KEY  (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lab`
--

/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;


--
-- Definition of table `labadmin`
--

DROP TABLE IF EXISTS `labadmin`;
CREATE TABLE `labadmin` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pid` int(10) unsigned NOT NULL,
  `did` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `labadmin`
--

/*!40000 ALTER TABLE `labadmin` DISABLE KEYS */;
INSERT INTO `labadmin` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`,`pid`,`did`) VALUES 
 (1,'vikky010615','76348365','vikas pati','sonagiri','99079','vikky0106@gmail.com',1,2),
 (2,'vikky0601','5334631234','vikky','sonagiri','3299692396','vikky0506@gmail.com',2,1),
 (3,'v','v','v','v','34567898765','vikky0106@gmail.com',0,0),
 (4,'mj','mj','mj','kam','99999999999','mj@gmail.com',0,0),
 (5,'reena','reena','Reena','Indore','9977016926','vikky0106@gmail.com',0,0);
/*!40000 ALTER TABLE `labadmin` ENABLE KEYS */;


--
-- Definition of table `pappointment`
--

DROP TABLE IF EXISTS `pappointment`;
CREATE TABLE `pappointment` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `doctor` varchar(45) NOT NULL,
  `symtoms` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `did` int(10) unsigned NOT NULL,
  `image` varchar(55) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `pappointment`
--

/*!40000 ALTER TABLE `pappointment` DISABLE KEYS */;
INSERT INTO `pappointment` (`id`,`name`,`age`,`sex`,`address`,`mobile`,`email`,`doctor`,`symtoms`,`date`,`did`,`image`) VALUES 
 (9,'Raj','19','male','sonagiri','3299692396','mj0506@gmail.com','Raj','Maleria','2013-12-11',0,'a.jpg'),
 (10,'Racvj','19','male','sonagiri','3299692396','mj0506@gmail.com','Raj','Maleria','2013-12-11',0,'a.jpg'),
 (13,'tit2','32','male','anandnagar','9977016926','ancd2@gmail.com','1','fwve\r\n','04-06-13',1,'a3.png'),
 (14,'vp','21','male','sonagiri','9977016926','vp123@gmail.com','1','fever\r\n','06-05-13',1,'a2.png');
/*!40000 ALTER TABLE `pappointment` ENABLE KEYS */;


--
-- Definition of table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `patient`
--

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`) VALUES 
 (1,'vikkxcy010615','76348365','vikas pati','sonagiri','99079','vikky0106@gmail.com'),
 (3,'vikky','5334631234','vikky','sonagiri','3299692396','vikky0506@gmail.com'),
 (4,'mujahid','1234','Mujahid','sonagiri','9907929235','vikky001@gmail.com'),
 (5,'mujahid','123456','MUJAHID','waidhan','97438423423','RAJ@DD10.gmail.com'),
 (6,'tit','tit','Tit Main cs','anand nagar','9907929235','vikky0106@gmail.com'),
 (7,'vikas','vikass','vikas patidar','sonagiri','9907929235','vikky0106@gmail.com'),
 (8,'mujahid','mujahi','mujahid islam','nmh','7489462985','mujahid143@gmail.com'),
 (9,'m','m','mm','dsvlm','324563','vikky0106@gmail.com'),
 (10,'vikky2607','vikas','vikash patidar','Sonagiri bhopal','9977016926','vikky0106@gmail.com'),
 (11,'praveen','p','praveen','sonagig','8602066602','vfiegdfig@gmail.com'),
 (12,'ammy','983512','amit','bhopal','9770556471','ammy.kumar99@gmail.com'),
 (13,'rahul','123456','cool','bpl','9584515823','rahul_verycool@yahoo.com');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


--
-- Definition of table `phar`
--

DROP TABLE IF EXISTS `phar`;
CREATE TABLE `phar` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `did` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phar`
--

/*!40000 ALTER TABLE `phar` DISABLE KEYS */;
INSERT INTO `phar` (`id`,`username`,`password`,`name`,`address`,`mobile`,`email`,`did`) VALUES 
 (1,'vikky','5334631234','vikky','sonagiri','3299692396','vikky0506@gmail.com',1),
 (2,'mjh','1','mjhd','bhopal','75534853483','mjh@gmail.com',0),
 (3,'vkki','vikki','vikas kumar','sonagiri','23848238429','vikas@gmail.com',0),
 (4,'vikas','vikas','vikas','soonagiri','9907929235','vikky0106@gmail.com',0),
 (5,'reena','reena','','','','',0),
 (6,'reena','reena','Reena','indore','9977016926','reena010322@gmail.com',0);
/*!40000 ALTER TABLE `phar` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `pname` varchar(45) NOT NULL,
  `p_price` varchar(45) NOT NULL,
  `stockinhand` varchar(45) NOT NULL,
  `dangerlevel` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pid`,`pname`,`p_price`,`stockinhand`,`dangerlevel`) VALUES 
 (3,'medicine2','244.0','41','10'),
 (4,'medicine3','100.0','35','20');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `pid` int(10) unsigned NOT NULL,
  `did` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(45) NOT NULL,
  `test` varchar(45) NOT NULL,
  `report` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `remark` varchar(45) NOT NULL,
  `aid` int(10) unsigned NOT NULL,
  `doctor` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `record`
--

/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` (`id`,`pid`,`did`,`name`,`age`,`sex`,`test`,`report`,`date`,`remark`,`aid`,`doctor`,`mobile`) VALUES 
 (27,4,1,'Mujahid',25,'male','x-ray','chest-x-ray.jpg','06-05-13','fine',3,'vikky','9977016926'),
 (28,3,1,'vikky',25,'male','blood','2009 CAE report.jpg','08-05-13','B+',3,'vikky','9977016926'),
 (29,6,1,'Tit Main cs',25,'male','x-ray','ml_x-ray-hip.jpg','15-05-13','fine',3,'vikky','9977016926'),
 (30,7,1,'vikas patidar',21,'male','x-ray','X-Ray1.jpg','16-05-13','fine',3,'vikky','9977016926'),
 (32,11,1,'praveen',25,'male','x-ray','d.jpg','17-05-13','fine',3,'vikky','9977016926'),
 (33,9,1,'mm',21,'male','chest','chest-x-ray.jpg','16-05-13','Fine',5,'vikky','9977016926'),
 (34,10,7,'vikash patidar',25,'male','x-ray','normal-x-ray-chest11.jpg','15-05-13','fine',5,'sanjay gupta','9977016926'),
 (35,12,15,'amit',31,'male','x-ray','X-Ray1.jpg','16-05-13','fine',5,'reema mishra','9770556471'),
 (36,13,3,'cool',21,'male','x-ray','d.jpg','15-05-13','fine',5,'Reena','8602820943');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
