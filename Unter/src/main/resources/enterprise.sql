CREATE TABLE address_tab (
address_id INT(12) SIGNED AUTO_INCREMENT PRIMARY KEY,
street VARCHAR(100) NOT NULL,
city 	VARCHAR(100) NOT NULL,
country VARCHAR(100)
);

--create user login related table

CREATE TABLE `role_tab` (
  `role_id` BIGINT NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE (`role_name`));

CREATE TABLE `user_tab` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `state` VARCHAR(30) NOT NULL,  
  PRIMARY KEY (`user_id`),
  UNIQUE (`user_name`));

CREATE TABLE `user_role_tab` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role_tab` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user_tab` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE);