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
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


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
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce_cart`.`cart_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce_cart`.`cart_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `status` INT NOT NULL COMMENT '0 means the  CartList is not ordered yet\\\\n1 means the cart_list has been ordered',
  PRIMARY KEY (`id`),
  INDEX `cart_list_ibfk_1` (`user_id` ASC) VISIBLE,
  INDEX `cart_list_ibfk_2` (`product_id` ASC) VISIBLE,
  CONSTRAINT `cart_list_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce_cart`.`users` (`id`),
  CONSTRAINT `cart_list_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce_cart`.`products` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ecommerce_cart`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce_cart`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `order_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `total_cost` DECIMAL(10,2) NULL DEFAULT NULL,
  `quantity` INT NOT NULL DEFAULT '0',
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce_cart`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 115
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
