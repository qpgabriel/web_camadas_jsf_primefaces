CREATE DATABASE `mantemarquivos` /*!40100 DEFAULT CHARACTER SET utf8 */;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoa` (
  `idpessoa` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `nascimento` VARCHAR(45) NULL,
  PRIMARY KEY (`idpessoa`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`),
  CONSTRAINT `idpessoa`
    FOREIGN KEY ()
    REFERENCES `mydb`.`pessoa` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idendereco`),
  CONSTRAINT `idpessoa`
    FOREIGN KEY ()
    REFERENCES `mydb`.`pessoa` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`arquivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`arquivo` (
  `idarquivo` INT NOT NULL AUTO_INCREMENT,
  `titulo` DATETIME NULL,
  `arquivo` BLOB NULL,
  `dataUpload` DATETIME NULL,
  PRIMARY KEY (`idarquivo`),
  CONSTRAINT `iduser`
    FOREIGN KEY ()
    REFERENCES `mydb`.`user` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`infoArquivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`infoArquivo` (
  `idinfoArquivo` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `autor` VARCHAR(45) NULL,
  `dataPubli` DATETIME NULL,
  PRIMARY KEY (`idinfoArquivo`),
  CONSTRAINT `idarquivo`
    FOREIGN KEY ()
    REFERENCES `mydb`.`arquivo` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;