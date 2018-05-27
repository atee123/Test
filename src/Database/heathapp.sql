CREATE TABLE `healthdb`.`userdata` (
  `user_id` INT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `useremail` VARCHAR(45) NOT NULL,
  `userpass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;