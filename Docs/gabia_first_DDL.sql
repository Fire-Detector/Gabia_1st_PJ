-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gabia_first
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gabia_first
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gabia_first` DEFAULT CHARACTER SET utf8mb3 ;
-- -----------------------------------------------------
-- Schema gabia_first
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gabia_first
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gabia_first` DEFAULT CHARACTER SET utf8mb3 ;
USE `gabia_first` ;
USE `gabia_first` ;

-- -----------------------------------------------------
-- Table `gabia_first`.`costumor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gabia_first`.`costumor` ;

CREATE TABLE IF NOT EXISTS `gabia_first`.`costumor` (
  `costumor_id` INT NOT NULL COMMENT '동일 명의 다계정 ID Unique로 방지',
  `costumor_password` VARCHAR(20) NOT NULL,
  `costumor_phone` VARCHAR(14) NOT NULL COMMENT '신규개통 등 \\n동일 번호 고객 존재 가능\\n동일 명의 다계정 ID Unique로 방지',
  `costumor_gender` VARCHAR(45) NULL,
  `costumor_email` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`costumor_id`),
  UNIQUE INDEX `costumor_id_UNIQUE` (`costumor_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `gabia_first`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gabia_first`.`cart` ;

CREATE TABLE IF NOT EXISTS `gabia_first`.`cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT COMMENT 'user_cart(또는 cart_items)에 \\n값이 있으면 카트가 있다고 \\n판별하는 방식은 \\n단기적, 단순한 상황에만 \\n적합합니다.',
  `create_date` VARCHAR(45) NOT NULL,
  `costumor_costumor_id` INT NOT NULL,
  PRIMARY KEY (`cart_id`, `create_date`),
  UNIQUE INDEX `cart_id_UNIQUE` (`cart_id` ASC) VISIBLE,
  UNIQUE INDEX `cartcol_UNIQUE` (`create_date` ASC) VISIBLE,
  INDEX `fk_cart_costumor1_idx` (`costumor_costumor_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_costumor1`
    FOREIGN KEY (`costumor_costumor_id`)
    REFERENCES `gabia_first`.`costumor` (`costumor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `gabia_first`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gabia_first`.`category` ;

CREATE TABLE IF NOT EXISTS `gabia_first`.`category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `gabia_first`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gabia_first`.`product` ;

CREATE TABLE IF NOT EXISTS `gabia_first`.`product` (
  `product_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NULL DEFAULT NULL,
  `manufacturer` VARCHAR(45) NULL DEFAULT NULL,
  `spec` VARCHAR(45) NULL DEFAULT NULL,
  `release_date` VARCHAR(10) NULL DEFAULT NULL,
  `price` INT UNSIGNED NULL DEFAULT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
  INDEX `fk_product_category_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `gabia_first`.`category` (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `gabia_first`.`cart_has_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gabia_first`.`cart_has_product` ;

CREATE TABLE IF NOT EXISTS `gabia_first`.`cart_has_product` (
  `cart_cart_id` INT NOT NULL,
  `cart_create_date` VARCHAR(45) NOT NULL,
  `product_product_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`cart_cart_id`, `cart_create_date`, `product_product_id`),
  INDEX `fk_cart_has_product_product1_idx` (`product_product_id` ASC) VISIBLE,
  INDEX `fk_cart_has_product_cart1_idx` (`cart_cart_id` ASC, `cart_create_date` ASC) VISIBLE,
  CONSTRAINT `fk_cart_has_product_cart1`
    FOREIGN KEY (`cart_cart_id` , `cart_create_date`)
    REFERENCES `gabia_first`.`cart` (`cart_id` , `create_date`),
  CONSTRAINT `fk_cart_has_product_product1`
    FOREIGN KEY (`product_product_id`)
    REFERENCES `gabia_first`.`product` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
