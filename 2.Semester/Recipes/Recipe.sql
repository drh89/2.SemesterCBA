-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Recipes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Recipes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Recipes` DEFAULT CHARACTER SET utf8 ;
USE `Recipes` ;

-- -----------------------------------------------------
-- Table `Recipes`.`Recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recipes`.`Recipe` ;

CREATE TABLE IF NOT EXISTS `Recipes`.`Recipe` (
  `recipe_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `rating` INT NULL,
  `image` VARCHAR(100) NULL,
  PRIMARY KEY (`recipe_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Ingredients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recipes`.`Ingredients` ;

CREATE TABLE IF NOT EXISTS `Recipes`.`Ingredients` (
  `ingredients_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ingredients_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recipes`.`Recipe_has_ingredients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recipes`.`Recipe_has_ingredients` ;

CREATE TABLE IF NOT EXISTS `Recipes`.`Recipe_has_ingredients` (
  `recipe_id` INT NOT NULL,
  `ingredients_id` INT NOT NULL,
  `units` DOUBLE NULL,
  `scale` VARCHAR(45) NULL,
  INDEX `Recipe_to_recipe_has_ingredients_fk_idx` (`recipe_id` ASC) VISIBLE,
  INDEX `Ingredients_to_recipe_has_ingredient_fk_idx` (`ingredients_id` ASC) VISIBLE,
  CONSTRAINT `Recipe_to_recipe_has_ingredients_fk`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `Recipes`.`Recipe` (`recipe_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Ingredients_to_recipe_has_ingredient_fk`
    FOREIGN KEY (`ingredients_id`)
    REFERENCES `Recipes`.`Ingredients` (`ingredients_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
