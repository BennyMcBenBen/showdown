SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `showdown` ;
CREATE SCHEMA IF NOT EXISTS `showdown` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `showdown` ;

-- -----------------------------------------------------
-- Table `showdown`.`show`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`show` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`show` (
  `show_id` INT NOT NULL AUTO_INCREMENT ,
  `show_title` VARCHAR(255) NOT NULL ,
  `show_description` VARCHAR(1023) NULL ,
  `show_image` VARCHAR(45) NULL ,
  `start_year` YEAR NULL ,
  `end_year` YEAR NULL ,
  PRIMARY KEY (`show_id`) ,
  UNIQUE INDEX `title` (`show_title` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`episode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`episode` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`episode` (
  `episode_id` INT NOT NULL AUTO_INCREMENT ,
  `show_id` INT NOT NULL ,
  `season` TINYINT UNSIGNED NOT NULL ,
  `episode` TINYINT UNSIGNED NOT NULL ,
  `ep_title` VARCHAR(255) NULL ,
  `ep_description` VARCHAR(1023) NULL ,
  `ep_image` VARCHAR(45) NULL ,
  `hulu_embed` VARCHAR(31) NULL ,
  `airdate` DATE NULL ,
  PRIMARY KEY (`episode_id`) ,
  INDEX `fk_episode_show` (`show_id` ASC) ,
  CONSTRAINT `fk_episode_show`
    FOREIGN KEY (`show_id` )
    REFERENCES `showdown`.`show` (`show_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`dvd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`dvd` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`dvd` (
  `dvd_id` INT NOT NULL AUTO_INCREMENT ,
  `dvd_title` VARCHAR(255) NOT NULL ,
  `dvd_description` VARCHAR(1023) NULL ,
  `dvd_image` VARCHAR(45) NULL ,
  `price` DECIMAL(10,2) NOT NULL ,
  PRIMARY KEY (`dvd_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`user` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`user` (
  `email` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `nickname` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`email`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`episode_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`episode_rating` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`episode_rating` (
  `episode_id` INT NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `rating` TINYINT NOT NULL ,
  PRIMARY KEY (`episode_id`, `email`) ,
  INDEX `fk_episode_rating_episode1` (`episode_id` ASC) ,
  INDEX `fk_episode_rating_user1` (`email` ASC) ,
  CONSTRAINT `fk_episode_rating_episode1`
    FOREIGN KEY (`episode_id` )
    REFERENCES `showdown`.`episode` (`episode_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_episode_rating_user1`
    FOREIGN KEY (`email` )
    REFERENCES `showdown`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`episode_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`episode_review` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`episode_review` (
  `episode_id` INT NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `review` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`episode_id`, `email`) ,
  INDEX `fk_episode_review_episode1` (`episode_id` ASC) ,
  INDEX `fk_episode_review_user1` (`email` ASC) ,
  CONSTRAINT `fk_episode_review_episode1`
    FOREIGN KEY (`episode_id` )
    REFERENCES `showdown`.`episode` (`episode_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_episode_review_user1`
    FOREIGN KEY (`email` )
    REFERENCES `showdown`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`shopping_cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`shopping_cart` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`shopping_cart` (
  `dvd_id` INT NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`dvd_id`, `email`) ,
  INDEX `fk_shopping_cart_dvd1` (`dvd_id` ASC) ,
  INDEX `fk_shopping_cart_user1` (`email` ASC) ,
  CONSTRAINT `fk_shopping_cart_dvd1`
    FOREIGN KEY (`dvd_id` )
    REFERENCES `showdown`.`dvd` (`dvd_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shopping_cart_user1`
    FOREIGN KEY (`email` )
    REFERENCES `showdown`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`dvd_episodes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`dvd_episodes` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`dvd_episodes` (
  `episode_id` INT NOT NULL ,
  `dvd_id` INT NOT NULL ,
  PRIMARY KEY (`episode_id`, `dvd_id`) ,
  INDEX `fk_dvd_episodes_episode1` (`episode_id` ASC) ,
  INDEX `fk_dvd_episodes_dvd1` (`dvd_id` ASC) ,
  CONSTRAINT `fk_dvd_episodes_episode1`
    FOREIGN KEY (`episode_id` )
    REFERENCES `showdown`.`episode` (`episode_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dvd_episodes_dvd1`
    FOREIGN KEY (`dvd_id` )
    REFERENCES `showdown`.`dvd` (`dvd_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `showdown`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `showdown`.`user_role` ;

CREATE  TABLE IF NOT EXISTS `showdown`.`user_role` (
  `email` VARCHAR(45) NOT NULL ,
  `role` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`email`, `role`) ,
  INDEX `fk_user_role_user1` (`email` ASC) ,
  CONSTRAINT `fk_user_role_user1`
    FOREIGN KEY (`email` )
    REFERENCES `showdown`.`user` (`email` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
