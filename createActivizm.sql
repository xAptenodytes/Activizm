-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.0.17-MariaDB - mariadb.org binary distribution
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных activizm
CREATE DATABASE IF NOT EXISTS `activizm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `activizm`;


-- Дамп структуры для таблица activizm.areaofresponsibility
CREATE TABLE IF NOT EXISTS `areaofresponsibility` (
  `areaId` int(11) NOT NULL AUTO_INCREMENT,
  `userroleId` int(11) DEFAULT NULL,
  `mapPointX` double DEFAULT NULL,
  `mapPointY` double DEFAULT NULL,
  `radius` double DEFAULT NULL,
  PRIMARY KEY (`areaId`),
  UNIQUE KEY `UK_areaofresponsibility_userro` (`userroleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='îòâåòñòâåííîñòü êîîðäèíàòîðîâ';

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.cities
CREATE TABLE IF NOT EXISTS `cities` (
  `CityId` int(11) NOT NULL AUTO_INCREMENT,
  `CityName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CityId`),
  CONSTRAINT `FK_cities_activists_cityId` FOREIGN KEY (`CityId`) REFERENCES `users` (`cityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cities_events_cityId` FOREIGN KEY (`CityId`) REFERENCES `events` (`cityId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cities_subcommunities_CityId` FOREIGN KEY (`CityId`) REFERENCES `subcommunities` (`CityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.communities
CREATE TABLE IF NOT EXISTS `communities` (
  `comunityId` int(11) NOT NULL AUTO_INCREMENT,
  `comunityName` varchar(150) NOT NULL,
  PRIMARY KEY (`comunityId`),
  CONSTRAINT `FK_communities_subcommunities_subcomunityId` FOREIGN KEY (`comunityId`) REFERENCES `subcommunities` (`ComunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.events
CREATE TABLE IF NOT EXISTS `events` (
  `eventId` int(4) NOT NULL AUTO_INCREMENT,
  `eventStartDate` datetime NOT NULL,
  `departurePointX` double NOT NULL,
  `departurePointY` double NOT NULL,
  `arrivalPointX` double DEFAULT NULL,
  `arrivalPointY` double DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `STATUS1` bit(1) DEFAULT NULL,
  `eventEndDate` datetime DEFAULT NULL,
  `commentEnd` varchar(500) DEFAULT NULL,
  `cityId` int(4) DEFAULT NULL,
  `EventTypeId` int(4) DEFAULT NULL,
  PRIMARY KEY (`eventId`),
  UNIQUE KEY `UK_events_cityId` (`cityId`),
  KEY `FK_events_eventtype_EventTypeId` (`EventTypeId`),
  CONSTRAINT `FK_events_eventtype_EventTypeId` FOREIGN KEY (`EventTypeId`) REFERENCES `eventtype` (`EventTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.eventtype
CREATE TABLE IF NOT EXISTS `eventtype` (
  `EventTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`EventTypeId`),
  CONSTRAINT `FK_eventtype_organisationeventtype_EventTypeId` FOREIGN KEY (`EventTypeId`) REFERENCES `organisationeventtype` (`EventTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.organisationeventtype
CREATE TABLE IF NOT EXISTS `organisationeventtype` (
  `ComunityId` int(4) NOT NULL,
  `EventTypeId` int(4) NOT NULL,
  `connectionId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`connectionId`),
  UNIQUE KEY `UK_organisationeventtype_Event` (`EventTypeId`),
  KEY `FK_organisationeventtype_communities_comunityId` (`ComunityId`),
  CONSTRAINT `FK_organisationeventtype_communities_comunityId` FOREIGN KEY (`ComunityId`) REFERENCES `communities` (`comunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.phones
CREATE TABLE IF NOT EXISTS `phones` (
  `phoneId` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(50) NOT NULL,
  `userId` int(8) NOT NULL,
  PRIMARY KEY (`phoneId`),
  UNIQUE KEY `UK_phones_activistId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  CONSTRAINT `FK_roles_userroles_roleId` FOREIGN KEY (`roleId`) REFERENCES `userroles` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.schedulewithdate
CREATE TABLE IF NOT EXISTS `schedulewithdate` (
  `userId` int(11) NOT NULL,
  `MapPointX` double DEFAULT NULL,
  `MapPointY` double DEFAULT NULL,
  `Radius` int(4) DEFAULT NULL,
  `beginDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `sheldueWithDateId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sheldueWithDateId`),
  UNIQUE KEY `UK_schedulewithdate_ActivistId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.schedulewithweekdays
CREATE TABLE IF NOT EXISTS `schedulewithweekdays` (
  `userId` int(11) NOT NULL,
  `MapPointX` double DEFAULT NULL,
  `MapPointY` double DEFAULT NULL,
  `Radius` int(4) DEFAULT NULL,
  `Weekday` int(4) DEFAULT NULL,
  `beginTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `sheldueWithWeekdaysId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sheldueWithWeekdaysId`),
  UNIQUE KEY `UK_schedulewithweekdays_Activi` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.subcommunities
CREATE TABLE IF NOT EXISTS `subcommunities` (
  `subcomunityId` int(11) NOT NULL AUTO_INCREMENT,
  `ComunityId` int(4) NOT NULL,
  `SubcomunityName` varchar(150) NOT NULL,
  `CityId` int(4) DEFAULT NULL,
  PRIMARY KEY (`subcomunityId`),
  UNIQUE KEY `UK_subcommunities_ComunityId` (`ComunityId`),
  UNIQUE KEY `UK_subcommunities_CityId` (`CityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.userroleevents
CREATE TABLE IF NOT EXISTS `userroleevents` (
  `userroleeventId` int(11) NOT NULL AUTO_INCREMENT,
  `userroleId` int(11) NOT NULL,
  `eventId` int(11) NOT NULL,
  `eventSignDate` datetime NOT NULL,
  PRIMARY KEY (`userroleeventId`),
  UNIQUE KEY `UK_userroleevents_userroleId` (`userroleId`),
  KEY `FK_userroleevents_events_eventId` (`eventId`),
  CONSTRAINT `FK_userroleevents_events_eventId` FOREIGN KEY (`eventId`) REFERENCES `events` (`eventId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.userroles
CREATE TABLE IF NOT EXISTS `userroles` (
  `userroleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userroleId`),
  UNIQUE KEY `UK_userroles_roleId` (`roleId`),
  KEY `FK_userroles_users_userID` (`userId`),
  CONSTRAINT `FK_userroles_areaofresponsibility_userroleId` FOREIGN KEY (`userroleId`) REFERENCES `areaofresponsibility` (`userroleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_userroles_userroleevents_userroleId` FOREIGN KEY (`userroleId`) REFERENCES `userroleevents` (`userroleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_userroles_users_userID` FOREIGN KEY (`userId`) REFERENCES `users` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.users
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  `passwdHash` varchar(255) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `name1` varchar(50) NOT NULL,
  `name2` varchar(50) DEFAULT NULL,
  `registrDate` datetime NOT NULL,
  `activateDate` datetime DEFAULT NULL,
  `desactivateDate` datetime DEFAULT NULL,
  `coordinatorId` int(11) NOT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  `districtId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `UK_activists_coordinatorId` (`coordinatorId`),
  UNIQUE KEY `UK_activists_userID` (`userID`),
  UNIQUE KEY `UK_activists_cityId` (`cityId`),
  CONSTRAINT `FK_activists_usersubcommunity_userId` FOREIGN KEY (`userID`) REFERENCES `usersubcommunity` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_users_phones_userId` FOREIGN KEY (`userID`) REFERENCES `phones` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_users_schedulewithdate_userId` FOREIGN KEY (`userID`) REFERENCES `schedulewithdate` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_users_schedulewithweekdays_userId` FOREIGN KEY (`userID`) REFERENCES `schedulewithweekdays` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица activizm.usersubcommunity
CREATE TABLE IF NOT EXISTS `usersubcommunity` (
  `usersubcommunityId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `subcommunityId` int(11) NOT NULL,
  PRIMARY KEY (`usersubcommunityId`),
  UNIQUE KEY `UK_usersubcommunity_userId` (`userId`),
  KEY `FK_usersubcommunity_subcommunities_subcomunityId` (`subcommunityId`),
  CONSTRAINT `FK_usersubcommunity_subcommunities_subcomunityId` FOREIGN KEY (`subcommunityId`) REFERENCES `subcommunities` (`subcomunityId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
