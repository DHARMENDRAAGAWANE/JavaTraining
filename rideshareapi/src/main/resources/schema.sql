-- MySQL Script generated by MySQL Workbench
-- Thu Oct 17 00:03:44 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering`PRIMARY``PRIMARY`owneridcreated_byupdated_by

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ridesharedb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ridesharedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ridesharedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `ridesharedb` ;

-- -----------------------------------------------------
-- Table `ridesharedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ridesharedb`.`user` (
  `user_id` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `phone_no` VARCHAR(20) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `user_type` VARCHAR(45) NULL,
  `mode_of_contact` VARCHAR(45) NULL,
  `created_by` VARCHAR(45) NULL,
  `updated_by` VARCHAR(45) NULL,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) );


-- -----------------------------------------------------
-- Table `ridesharedb`.`vehicalinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ridesharedb`.`vehicalinfo` (
  `license_plate` VARCHAR(16) NOT NULL,
  `ownerid` VARCHAR(16) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `passenger_capacity` INT NOT NULL,
  `luggage_capacity` INT NOT NULL,
  `color` VARCHAR(16) NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'A',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `created_by` VARCHAR(16) NULL,
  `updated_by` VARCHAR(16) NULL,
  PRIMARY KEY (`license_plate` ),
  INDEX  (`ownerid` ASC, `created_by` ASC,`updated_by` ASC) );

alter table `ridesharedb`.`vehicalinfo` add FOREIGN KEY (ownerid)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
      alter table `ridesharedb`.`vehicalinfo` add FOREIGN KEY (created_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
      
      
          alter table `ridesharedb`.`vehicalinfo` add FOREIGN KEY (updated_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
     


-- -----------------------------------------------------
-- Table `ridesharedb`.`provider_ride_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ridesharedb`.`provider_ride_info` (
  `provider_id` VARCHAR(16) NOT NULL,
  `id` int(10) not null AUTO_INCREMENT,
  `trip_time` DATETIME NOT NULL,
  `vehical_id` varchar(16) NOT NULL,
  `from_loc` VARCHAR(45) NULL,
  `to_loc` VARCHAR(45) NULL,
  `from_pickup_point` VARCHAR(255) NULL,
  `to_pickup_point` VARCHAR(255) NULL,
  `trip_type` VARCHAR(2) NULL,
  `creation_time` VARCHAR(45) NULL,
  `update_time` VARCHAR(45) NULL,
  `created_by` VARCHAR(16) NULL,
  `updated_by` VARCHAR(16) NULL,
   `avaialble_seats` INT NULL,
  `availale_luggage_space` INT NULL,
  `trip_status` VARCHAR(45) NULL,
  `trip_comments` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `provider_id_UNIQUE` (`provider_id` ASC, `trip_time` ASC,`vehical_id` ASC) ,
  INDEX  (`provider_id` ASC, `created_by` ASC, `updated_by` ASC,`vehical_id` ASC,id asc) )
ENGINE = InnoDB;

alter table `ridesharedb`.`provider_ride_info` add FOREIGN KEY (`vehical_id`)
      REFERENCES `ridesharedb`.`vehicalinfo`(`license_plate`)
      ON DELETE CASCADE;
alter table `ridesharedb`.`provider_ride_info` add FOREIGN KEY (provider_id)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
      alter table `ridesharedb`.`provider_ride_info` add FOREIGN KEY (created_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
      
      
          alter table `ridesharedb`.`provider_ride_info` add FOREIGN KEY (updated_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;

#unique_indexunique_indexALTER TABLE `ridesharedb`.`provider_ride_info` drop  index trip_time_UNIQUE;
ALTER TABLE `ridesharedb`.`provider_ride_info` ADD UNIQUE `unique_index` (`provider_id` ASC, `trip_time` ASC,`vehical_id` ASC);
-- -----------------------------------------------------
-- Table `ridesharedb`.`ride_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ridesharedb`.`ride_info` (
  `provider_ride_id` int(10) Not NULL,
  `consumer_id` VARCHAR(16) NOT NULL,
  `status` VARCHAR(45) NULL,
  `distance` DOUBLE NULL,
  `created_by` VARCHAR(16) NULL,
  `updated_by` VARCHAR(16) NULL,
  `create_time` DATETIME NULL,
  `comments` VARCHAR(255) NULL,
  `updated_time` DATETIME NULL,
  PRIMARY KEY (`provider_ride_id`, `consumer_id`),
  UNIQUE INDEX `provider_ride_id_UNIQUE` (`provider_ride_id` ASC) ,
  UNIQUE INDEX `consumer_id_UNIQUE` (`consumer_id` ASC) ,
  INDEX  (`consumer_id` ASC, `created_by` ASC, `updated_by` ASC,`provider_ride_id` ASC) )
ENGINE = InnoDB;

alter table `ridesharedb`.`ride_info` add FOREIGN KEY (consumer_id)
      REFERENCES `ridesharedb`.`user`(user_id)
     ON DELETE CASCADE;
alter table `ridesharedb`.`ride_info` add FOREIGN KEY (provider_ride_id)
      REFERENCES `ridesharedb`.`provider_ride_info`(id)
      ON DELETE CASCADE;
      alter table `ridesharedb`.`ride_info` add FOREIGN KEY (created_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;
      
      
          alter table `ridesharedb`.`ride_info` add FOREIGN KEY (updated_by)
      REFERENCES `ridesharedb`.`user`(user_id)
      ON DELETE CASCADE;Indexes

`ridesharedb`.`ride_info`
ALTER TABLE `ridesharedb`.`ride_info` drop index consumer_id_UNIQUE
ALTER TABLE `ridesharedb`.`ride_info` ADD UNIQUE `unique_index` (`provider_id` ASC, `trip_time` ASC,`vehical_id` ASC);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
