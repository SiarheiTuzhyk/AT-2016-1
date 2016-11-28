/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 07-Oct-2015 11:17:07 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */
CREATE DATABASE  IF NOT EXISTS `phonebook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phonebook`;

SET FOREIGN_KEY_CHECKS=0 ;

/* Drop Tables */

DROP TABLE IF EXISTS `phone` CASCADE
;

DROP TABLE IF EXISTS `person` CASCADE
;

/* Create Tables */

CREATE TABLE `phone`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`owner` INT UNSIGNED NOT NULL,
	`number` VARCHAR(50) NOT NULL,
	CONSTRAINT `PK_phone` PRIMARY KEY (`id`)
)

;

CREATE TABLE `person`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`surname` VARCHAR(150) NOT NULL,
	`name` VARCHAR(150) NOT NULL,
	`middlename` VARCHAR(150) 	 NULL,
	CONSTRAINT `PK_phonebook` PRIMARY KEY (`id`)
)

;

/* Create Foreign Key Constraints */

ALTER TABLE `phone` 
 ADD CONSTRAINT `FK_phone_person`
	FOREIGN KEY (`owner`) REFERENCES `person` (`id`) ON DELETE Cascade ON UPDATE Cascade
;

SET FOREIGN_KEY_CHECKS=1 ;
