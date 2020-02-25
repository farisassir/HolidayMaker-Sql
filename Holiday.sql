-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.29-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for holidaymaker
CREATE DATABASE IF NOT EXISTS `holidaymaker` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `holidaymaker`;

-- Dumping structure for table holidaymaker.bookings
CREATE TABLE IF NOT EXISTS `bookings` (
  `booking_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `guest_guest_id` int(11) unsigned NOT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_bookings_customes1_idx` (`guest_guest_id`),
  CONSTRAINT `FK_bookings_customes` FOREIGN KEY (`guest_guest_id`) REFERENCES `guests` (`guest_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.bookings: ~0 rows (approximately)
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.bookings_has_rooms
CREATE TABLE IF NOT EXISTS `bookings_has_rooms` (
  `bookings_booking_id` int(11) unsigned NOT NULL,
  `rooms_room_id` int(11) unsigned NOT NULL,
  `meals` tinyint(4) DEFAULT NULL,
  `extra_bed` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`bookings_booking_id`,`rooms_room_id`),
  KEY `fk_bookings_has_rooms_rooms1_idx` (`rooms_room_id`),
  KEY `fk_bookings_has_rooms_bookings1_idx` (`bookings_booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.bookings_has_rooms: ~0 rows (approximately)
/*!40000 ALTER TABLE `bookings_has_rooms` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings_has_rooms` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.facilities
CREATE TABLE IF NOT EXISTS `facilities` (
  `facility_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pool` tinyint(4) DEFAULT NULL,
  `night_activity` tinyint(4) DEFAULT NULL,
  `child_activity` tinyint(4) DEFAULT NULL,
  `restaurant` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`facility_id`),
  CONSTRAINT `FK_facility_hotels` FOREIGN KEY (`facility_id`) REFERENCES `hotels` (`facility_facility_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.facilities: ~8 rows (approximately)
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` (`facility_id`, `pool`, `night_activity`, `child_activity`, `restaurant`) VALUES
	(15, 1, 1, 1, 1),
	(16, 1, 0, 0, 0),
	(17, 0, 1, 0, 0),
	(18, 0, 0, 1, 0),
	(19, 1, 1, 0, 0),
	(20, 1, 0, 1, 0),
	(21, 1, 0, 0, 1),
	(22, 0, 1, 1, 0);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.guests
CREATE TABLE IF NOT EXISTS `guests` (
  `guest_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(45) DEFAULT NULL,
  `guest_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`guest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.guests: ~3 rows (approximately)
/*!40000 ALTER TABLE `guests` DISABLE KEYS */;
INSERT INTO `guests` (`guest_id`, `guest_name`, `guest_phone`) VALUES
	(1, 'Faris', NULL),
	(2, 'Johan', NULL),
	(3, 'Ahmed', NULL);
/*!40000 ALTER TABLE `guests` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.hotels
CREATE TABLE IF NOT EXISTS `hotels` (
  `hotel_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(45),
  `hotel_address` varchar(45) DEFAULT NULL,
  `distance_centre` double DEFAULT NULL,
  `distance_beach` double NOT NULL DEFAULT '0',
  `facility_facility_id` int(11) unsigned NOT NULL,
  `half-board_price` double,
  `full-board_price` double,
  `extra_bed_price` double,
  PRIMARY KEY (`hotel_id`),
  KEY `fk_hotels_facility1_idx` (`facility_facility_id`),
  CONSTRAINT `FK_hotels_facility` FOREIGN KEY (`facility_facility_id`) REFERENCES `facilities` (`facility_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.hotels: ~5 rows (approximately)
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` (`hotel_id`, `hotel_name`, `hotel_address`, `distance_centre`, `distance_beach`, `facility_facility_id`, `half-board_price`, `full-board_price`, `extra_bed_price`) VALUES
	(13, 'Riu Plaza', 'Street9, Madrid', 1000, 1200, 17, 700, 1200, 350),
	(14, 'Madird hotel', 'Street 10,Madrid', 800, 1000, 18, 800, 1000, 400),
	(15, 'Shosho Plaza', 'Street 108, Madrid', 1200, 800, 18, 1000, 800, 350),
	(16, 'Spain Hotel', 'Stree 404,Madrid', 700, 500, 15, 500, 1000, 500),
	(17, 'VP Plaza', 'Street 101, Madrid', 500, 300, 16, 1200, 2000, 700);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.rooms
CREATE TABLE IF NOT EXISTS `rooms` (
  `room_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Hotels_hotel_id` int(11) unsigned NOT NULL,
  `room_type_type_id` int(11) unsigned NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `fk_rooms_Hotels1_idx` (`Hotels_hotel_id`),
  KEY `fk_rooms_room_type1_idx` (`room_type_type_id`),
  CONSTRAINT `FK_rooms_hotels` FOREIGN KEY (`Hotels_hotel_id`) REFERENCES `hotels` (`hotel_id`),
  CONSTRAINT `FK_rooms_room_type` FOREIGN KEY (`room_type_type_id`) REFERENCES `room_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.rooms: ~20 rows (approximately)
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`room_id`, `Hotels_hotel_id`, `room_type_type_id`, `price`) VALUES
	(1, 14, 1, 3000),
	(2, 14, 2, 5000),
	(3, 14, 3, 7000),
	(4, 13, 1, 8000),
	(5, 13, 2, 5900),
	(6, 13, 3, 7000),
	(7, 15, 1, 9000),
	(8, 15, 2, 6800),
	(9, 15, 3, 5700),
	(10, 16, 1, 6000),
	(11, 16, 2, 4900),
	(12, 16, 3, 9000),
	(13, 17, 1, 8700),
	(14, 17, 2, 4900),
	(15, 17, 3, 6700),
	(16, 14, 1, 7900),
	(17, 13, 2, 8500),
	(18, 15, 1, 4900),
	(19, 16, 3, 5660),
	(20, 17, 1, 7850);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

-- Dumping structure for table holidaymaker.room_type
CREATE TABLE IF NOT EXISTS `room_type` (
  `type_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `room_type` varchar(45) DEFAULT NULL,
  `room_price` double DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  CONSTRAINT `FK_room_type_rooms` FOREIGN KEY (`type_id`) REFERENCES `rooms` (`room_type_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table holidaymaker.room_type: ~3 rows (approximately)
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` (`type_id`, `room_type`, `room_price`) VALUES
	(1, 'Single', 5000),
	(2, 'Double', 1000),
	(3, 'Suite', 2000);
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
