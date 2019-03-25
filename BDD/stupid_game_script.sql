-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema stupid_game
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stupid_game
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stupid_game` DEFAULT CHARACTER SET utf8 ;
USE `stupid_game` ;

-- -----------------------------------------------------
-- Table `stupid_game`.`joueurs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stupid_game`.`joueurs` (
  `idjoueurs` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(25) NOT NULL,
  `sexe` CHAR(1) NOT NULL,
  `birthday` DATE NOT NULL,
  `pseudo` VARCHAR(25) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idjoueurs`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stupid_game`.`jeux`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stupid_game`.`jeux` (
  `idjeux` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `regles` LONGTEXT NOT NULL,
  `joueurs_min` TINYINT(1) NOT NULL,
  `joueurs_max` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idjeux`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stupid_game`.`parties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stupid_game`.`parties` (
  `idparties` INT NOT NULL AUTO_INCREMENT,
  `createur` VARCHAR(45) NOT NULL,
  `date_debut` DATETIME NOT NULL,
  `statut` CHAR(1) NOT NULL,
  `nbre_joueurs` TINYINT(1) NOT NULL,
  `jeux_id` INT NOT NULL,
  PRIMARY KEY (`idparties`),
  INDEX `fk_parties_jeux1_idx` (`jeux_id` ASC),
  CONSTRAINT `fk_parties_jeux1`
    FOREIGN KEY (`jeux_id`)
    REFERENCES `stupid_game`.`jeux` (`idjeux`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stupid_game`.`parties_joueurs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stupid_game`.`parties_joueurs` (
  `joueurs_id` INT NOT NULL,
  `parties_id` INT NOT NULL,
  INDEX `fk_parties_joueurs_joueurs_idx` (`joueurs_id` ASC),
  INDEX `fk_parties_joueurs_parties1_idx` (`parties_id` ASC),
  CONSTRAINT `fk_parties_joueurs_joueurs`
    FOREIGN KEY (`joueurs_id`)
    REFERENCES `stupid_game`.`joueurs` (`idjoueurs`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parties_joueurs_parties1`
    FOREIGN KEY (`parties_id`)
    REFERENCES `stupid_game`.`parties` (`idparties`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stupid_game`.`coups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stupid_game`.`coups` (
  `idcoups` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `x` TINYINT(2) NOT NULL,
  `y` TINYINT(2) NOT NULL,
  `parties_id` INT NOT NULL,
  `joueurs_id` INT NOT NULL,
  PRIMARY KEY (`idcoups`),
  INDEX `fk_coups_parties1_idx` (`parties_id` ASC),
  INDEX `fk_coups_joueurs1_idx` (`joueurs_id` ASC),
  CONSTRAINT `fk_coups_parties1`
    FOREIGN KEY (`parties_id`)
    REFERENCES `stupid_game`.`parties` (`idparties`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coups_joueurs1`
    FOREIGN KEY (`joueurs_id`)
    REFERENCES `stupid_game`.`joueurs` (`idjoueurs`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
