-- MySQL Script generated by MySQL Workbench
-- Sat Jul 25 00:07:55 2015
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`employee` ;

CREATE TABLE IF NOT EXISTS `mydb`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `department_id` INT NOT NULL,
  `salary` INT NOT NULL,
  `designation` INT NOT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orgs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`orgs` ;

CREATE TABLE IF NOT EXISTS `mydb`.`orgs` (
  `org_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `manager_id` INT NULL,
  PRIMARY KEY (`org_id`),
  INDEX `employee_id_idx` (`manager_id` ASC),
  CONSTRAINT `employee_id`
    FOREIGN KEY (`manager_id`)
    REFERENCES `mydb`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`projects` ;

CREATE TABLE IF NOT EXISTS `mydb`.`projects` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `org_id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `startdate` DATETIME NULL,
  `enddate` DATETIME NULL,
  `revenue` BIGINT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `org_id_idx` (`org_id` ASC),
  CONSTRAINT `org_id`
    FOREIGN KEY (`org_id`)
    REFERENCES `mydb`.`orgs` (`org_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`teams` ;

CREATE TABLE IF NOT EXISTS `mydb`.`teams` (
  `employee_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  INDEX `employee_id_idx` (`employee_id` ASC),
  INDEX `project_id_idx` (`project_id` ASC),
  CONSTRAINT `employee_id_fk`
    FOREIGN KEY (`employee_id`)
    REFERENCES `mydb`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_id_fk`
    FOREIGN KEY (`project_id`)
    REFERENCES `mydb`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
