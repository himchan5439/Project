package jdbc;

import msg.jop;

public class DbSetting {

	public DbSetting() {
		int set = 0;
	 	set = DbManager.db.setData("\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Schema 2023지방_2\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "DROP SCHEMA IF EXISTS `2023지방_2` ;\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Schema 2023지방_2\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE SCHEMA IF NOT EXISTS `2023지방_2` DEFAULT CHARACTER SET utf8 ;\r\n"
				+ "USE `2023지방_2` ;\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Table `2023지방_2`.`user`\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE TABLE IF NOT EXISTS `2023지방_2`.`user` (\r\n"
				+ "  `u_no` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_name` VARCHAR(5) NULL,\r\n"
				+ "  `u_id` VARCHAR(10) NULL,\r\n"
				+ "  `u_pw` VARCHAR(10) NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`))\r\n"
				+ "ENGINE = InnoDB;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Table `2023지방_2`.`division`\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE TABLE IF NOT EXISTS `2023지방_2`.`division` (\r\n"
				+ "  `d_no` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_name` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`))\r\n"
				+ "ENGINE = InnoDB;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Table `2023지방_2`.`book`\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE TABLE IF NOT EXISTS `2023지방_2`.`book` (\r\n"
				+ "  `b_no` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `b_name` VARCHAR(50) NULL,\r\n"
				+ "  `d_no` INT(11) NULL,\r\n"
				+ "  `b_author` VARCHAR(50) NULL,\r\n"
				+ "  `b_cunt` INT(11) NULL,\r\n"
				+ "  `b_page` INT(11) NULL,\r\n"
				+ "  `b_exp` VARCHAR(500) NULL,\r\n"
				+ "  `b_img` LONGBLOB NULL,\r\n"
				+ "  PRIMARY KEY (`b_no`),\r\n"
				+ "  INDEX `fk_book_division1_idx` (`d_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_book_division1`\r\n"
				+ "    FOREIGN KEY (`d_no`)\r\n"
				+ "    REFERENCES `2023지방_2`.`division` (`d_no`)\r\n"
				+ "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION)\r\n"
				+ "ENGINE = InnoDB;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Table `2023지방_2`.`rental`\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE TABLE IF NOT EXISTS `2023지방_2`.`rental` (\r\n"
				+ "  `r_no` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT(11) NULL,\r\n"
				+ "  `b_no` INT(11) NULL,\r\n"
				+ "  `r_date` DATE NULL,\r\n"
				+ "  `r_count` INT(11) NULL,\r\n"
				+ "  `r_reading` INT(11) NULL,\r\n"
				+ "  `r_returnday` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`r_no`),\r\n"
				+ "  INDEX `fk_rental_book1_idx` (`b_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_rental_user1_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_rental_book1`\r\n"
				+ "    FOREIGN KEY (`b_no`)\r\n"
				+ "    REFERENCES `2023지방_2`.`book` (`b_no`)\r\n"
				+ "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION,\r\n"
				+ "  CONSTRAINT `fk_rental_user1`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023지방_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION)\r\n"
				+ "ENGINE = InnoDB;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "-- Table `2023지방_2`.`likebook`\r\n"
				+ "-- -----------------------------------------------------\r\n"
				+ "CREATE TABLE IF NOT EXISTS `2023지방_2`.`likebook` (\r\n"
				+ "  `l_no` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `u_no` INT(11) NULL,\r\n"
				+ "  `b_no` INT(11) NULL,\r\n"
				+ "  PRIMARY KEY (`l_no`),\r\n"
				+ "  INDEX `fk_likebook_user_idx` (`u_no` ASC) VISIBLE,\r\n"
				+ "  INDEX `fk_likebook_book1_idx` (`b_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_likebook_user`\r\n"
				+ "    FOREIGN KEY (`u_no`)\r\n"
				+ "    REFERENCES `2023지방_2`.`user` (`u_no`)\r\n"
				+ "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION,\r\n"
				+ "  CONSTRAINT `fk_likebook_book1`\r\n"
				+ "    FOREIGN KEY (`b_no`)\r\n"
				+ "    REFERENCES `2023지방_2`.`book` (`b_no`)\r\n"
				+ "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION)\r\n"
				+ "ENGINE = InnoDB;\r\n"
				+ ""
				+ "set global local_infile = true;\r\n"
				+ "load data local infile './datafiles/user.txt' into table 2023지방_2.user ignore 1 lines;\r\n"
				+ "load data local infile './datafiles/division.txt' into table 2023지방_2.division ignore 1 lines;\r\n"
				+ "load data local infile './datafiles/book.txt' into table 2023지방_2.book ignore 1 lines;\r\n"
				+ "load data local infile './datafiles/likebook.txt' into table 2023지방_2.likebook ignore 1 lines;\r\n"
				+ "load data local infile './datafiles/rental.txt' into table 2023지방_2.rental ignore 1 lines;"
				+ ""
				+ ""
				+ "drop user IF EXISTS 'user'@'localhost';\n"
				+ "\n"
				+ "create user 'user'@'localhost' identified by '1234';\n"
				+ "grant insert, select, delete, update on 2023지방_2.* to 'user'@'localhost';"
				+ "");
		
		if(set == -1) {
			jop.error("셋팅 실패");
			return;
		}
		
		jop.info("셋팅 성공");
	}

}
