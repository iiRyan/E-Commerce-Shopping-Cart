-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ecommerce_cart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecommerce_cart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce_cart` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ecommerce_cart` ;

-- -----------------------------------------------------
-- Table `ecommerce_cart`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce_cart`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(450) NOT NULL,
  `category` VARCHAR(450) NOT NULL,
  `price` DOUBLE NOT NULL,
  `image` VARCHAR(450) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce_cart`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce_cart`.`orders` (
  `o_id` INT NOT NULL AUTO_INCREMENT,
  `p_id` INT NOT NULL,
  `u_id` INT NOT NULL,
  `o_quantity` INT NOT NULL,
  `o_date` VARCHAR(450) NOT NULL,
  PRIMARY KEY (`o_id`),
  INDEX `id_idx` (`p_id` ASC) VISIBLE,
  CONSTRAINT `p_id`
    FOREIGN KEY (`p_id`)
    REFERENCES `ecommerce_cart`.`products` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce_cart`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce_cart`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `password` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
