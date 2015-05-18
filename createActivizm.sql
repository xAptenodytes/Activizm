-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.0.17-MariaDB - mariadb.org binary distribution
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных activizm
CREATE DATABASE IF NOT EXISTS `activizm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `activizm`;


-- Дамп структуры для таблица activizm.activists
CREATE TABLE IF NOT EXISTS `activists` (
  `activistId` int(8) NOT NULL AUTO_INCREMENT,
  `vkID` int(11) DEFAULT NULL,
  `fbId` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `passwdHash` varchar(100) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `name1` varchar(50) NOT NULL,
  `name2` varchar(50) DEFAULT NULL,
  `registrDate` datetime NOT NULL,
  `activateDate` datetime DEFAULT NULL,
  `desactivateDate` datetime DEFAULT NULL,
  `coordinatorId` int(4) NOT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  `cityId` int(4) DEFAULT NULL,
  `districtId` int(4) DEFAULT NULL,
  PRIMARY KEY (`activistId`),
  UNIQUE KEY `UK_activists_coordinatorId` (`coordinatorId`),
  UNIQUE KEY `UK_activists_cityId` (`cityId`),
  CONSTRAINT `FK_activists_events_activistId` FOREIGN KEY (`activistId`) REFERENCES `events` (`activistId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_activists_phones_activistId` FOREIGN KEY (`activistId`) REFERENCES `phones` (`activistId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_activists_schedulewithdate_ActivistId` FOREIGN KEY (`activistId`) REFERENCES `schedulewithdate` (`ActivistId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_activists_schedulewithweekdays_ActivistId` FOREIGN KEY (`activistId`) REFERENCES `schedulewithweekdays` (`ActivistId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.cities
CREATE TABLE IF NOT EXISTS `cities` (
  `CityId` int(8) NOT NULL AUTO_INCREMENT,
  `CityName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CityId`),
  CONSTRAINT `FK_cities_activists_cityId` FOREIGN KEY (`CityId`) REFERENCES `activists` (`cityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cities_coordinators_cityId` FOREIGN KEY (`CityId`) REFERENCES `coordinators` (`cityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cities_events_cityId` FOREIGN KEY (`CityId`) REFERENCES `events` (`cityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cities_subcommunities_CityId` FOREIGN KEY (`CityId`) REFERENCES `subcommunities` (`CityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.communities
CREATE TABLE IF NOT EXISTS `communities` (
  `comunityId` int(4) NOT NULL AUTO_INCREMENT,
  `comunityName` varchar(150) NOT NULL,
  PRIMARY KEY (`comunityId`),
  CONSTRAINT `FK_communities_subcommunities_subcomunityId` FOREIGN KEY (`comunityId`) REFERENCES `subcommunities` (`ComunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.coordinators
CREATE TABLE IF NOT EXISTS `coordinators` (
  `coordinatorId` int(4) NOT NULL AUTO_INCREMENT,
  `subcomunityId` int(4) NOT NULL,
  `vkID` int(11) DEFAULT NULL,
  `fbId` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `passwdHash` varchar(100) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `name1` varchar(50) NOT NULL,
  `name2` varchar(50) DEFAULT NULL,
  `registrDate` datetime NOT NULL,
  `activateDate` datetime DEFAULT NULL,
  `desactivateDate` datetime DEFAULT NULL,
  `cityId` int(8) DEFAULT NULL,
  PRIMARY KEY (`coordinatorId`),
  UNIQUE KEY `UK_coordinators_cityId` (`cityId`),
  KEY `FK_coordinators_subcommunities_subcomunityId` (`subcomunityId`),
  CONSTRAINT `FK_coordinators_activists_coordinatorId` FOREIGN KEY (`coordinatorId`) REFERENCES `activists` (`coordinatorId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_coordinators_subcommunities_subcomunityId` FOREIGN KEY (`subcomunityId`) REFERENCES `subcommunities` (`subcomunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.events
CREATE TABLE IF NOT EXISTS `events` (
  `eventId` int(4) NOT NULL AUTO_INCREMENT,
  `requersterId` int(8) NOT NULL,
  `activistId` int(8) DEFAULT NULL,
  `eventStartDate` datetime NOT NULL,
  `departurePointX` double NOT NULL,
  `departurePointY` double NOT NULL,
  `arrivalPointX` double DEFAULT NULL,
  `arrivalPointY` double DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `STATUS1` bit(1) DEFAULT NULL,
  `coordinatorId` int(11) DEFAULT NULL,
  `eventEndDate` datetime DEFAULT NULL,
  `commentEnd` varchar(500) DEFAULT NULL,
  `cityId` int(4) DEFAULT NULL,
  `EventTypeId` int(4) DEFAULT NULL,
  PRIMARY KEY (`eventId`),
  UNIQUE KEY `UK_events_requersterId` (`requersterId`),
  UNIQUE KEY `UK_events_activistId` (`activistId`),
  UNIQUE KEY `UK_events_cityId` (`cityId`),
  KEY `FK_events_coordinators_coordinatorId` (`coordinatorId`),
  KEY `FK_events_eventtype_EventTypeId` (`EventTypeId`),
  CONSTRAINT `FK_events_coordinators_coordinatorId` FOREIGN KEY (`coordinatorId`) REFERENCES `coordinators` (`coordinatorId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_events_eventtype_EventTypeId` FOREIGN KEY (`EventTypeId`) REFERENCES `eventtype` (`EventTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.eventtype
CREATE TABLE IF NOT EXISTS `eventtype` (
  `EventTypeId` int(4) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`EventTypeId`),
  CONSTRAINT `FK_eventtype_organisationeventtype_EventTypeId` FOREIGN KEY (`EventTypeId`) REFERENCES `organisationeventtype` (`EventTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.organisationeventtype
CREATE TABLE IF NOT EXISTS `organisationeventtype` (
  `ComunityId` int(4) NOT NULL,
  `EventTypeId` int(4) NOT NULL,
  UNIQUE KEY `UK_organisationeventtype_Event` (`EventTypeId`),
  KEY `FK_organisationeventtype_communities_comunityId` (`ComunityId`),
  CONSTRAINT `FK_organisationeventtype_communities_comunityId` FOREIGN KEY (`ComunityId`) REFERENCES `communities` (`comunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.phones
CREATE TABLE IF NOT EXISTS `phones` (
  `phoneId` int(4) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(50) NOT NULL,
  `activistId` int(8) NOT NULL,
  PRIMARY KEY (`phoneId`),
  UNIQUE KEY `UK_phones_activistId` (`activistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.requester
CREATE TABLE IF NOT EXISTS `requester` (
  `requesterId` int(8) NOT NULL AUTO_INCREMENT,
  `vkID` int(11) DEFAULT NULL,
  `fbId` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `hashPasswd` varchar(100) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `registrDate` datetime NOT NULL,
  PRIMARY KEY (`requesterId`),
  CONSTRAINT `FK_requester_events_requersterId` FOREIGN KEY (`requesterId`) REFERENCES `events` (`requersterId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.schedulewithdate
CREATE TABLE IF NOT EXISTS `schedulewithdate` (
  `ActivistId` int(8) NOT NULL,
  `MapPointX` double DEFAULT NULL,
  `MapPointY` double DEFAULT NULL,
  `Radius` int(4) DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  UNIQUE KEY `UK_schedulewithdate_ActivistId` (`ActivistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.schedulewithweekdays
CREATE TABLE IF NOT EXISTS `schedulewithweekdays` (
  `ActivistId` int(8) NOT NULL,
  `MapPointX` double DEFAULT NULL,
  `MapPointY` double DEFAULT NULL,
  `Radius` int(4) DEFAULT NULL,
  `Weekday` int(4) DEFAULT NULL,
  `beginTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  UNIQUE KEY `UK_schedulewithweekdays_Activi` (`ActivistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.subcommunities
CREATE TABLE IF NOT EXISTS `subcommunities` (
  `subcomunityId` int(4) NOT NULL AUTO_INCREMENT,
  `ComunityId` int(4) NOT NULL,
  `SubcomunityName` varchar(150) NOT NULL,
  `CityId` int(4) DEFAULT NULL,
  PRIMARY KEY (`subcomunityId`),
  UNIQUE KEY `UK_subcommunities_ComunityId` (`ComunityId`),
  UNIQUE KEY `UK_subcommunities_CityId` (`CityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
