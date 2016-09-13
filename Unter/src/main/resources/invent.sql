CREATE TABLE `unter`.`inventory_part_tab` (
  `inv_part_no` VARCHAR(30) NOT NULL,
  `description` VARCHAR(200) NULL,
  `uom` VARCHAR(10) NULL,
  `reorder_level` DOUBLE NULL,
  `safety_stock_level` DOUBLE NULL,
  PRIMARY KEY (`inv_part_no`));
  
CREATE TABLE site_tab (
site_id VARCHAR(5) PRIMARY KEY,
address_id 	INT SIGNED,
phone_no_1  INT SIGNED,
phone_no_2  INT SIGNED,
FOREIGN KEY (address_id) REFERENCES address_tab(address_id));


CREATE TABLE IF NOT EXISTS `unter`.`inventory_location_tab` (
  `site_id` VARCHAR(5) NOT NULL,
  `inv_location_id` VARCHAR(5) NOT NULL,
  `inv_location_type` VARCHAR(10) NULL,
  PRIMARY KEY (`site_id`, `inv_location_id`),
  CONSTRAINT `site_id`
    FOREIGN KEY (`site_id`)
    REFERENCES `unter`.`site_tab` (`site_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `unter`.`inventory_part_cost_tab` (   
`inv_part_no` VARCHAR(10) NOT NULL,   
`inv_part_cost_no` INT NOT NULL,   
`cost` NUMERIC(20,2) NULL,   
PRIMARY KEY (`inv_part_no`, `inv_part_cost_no`),   
CONSTRAINT `inv_part_no`     FOREIGN KEY (`inv_part_no`)     
REFERENCES `unter`.`inventory_part_tab` (`inv_part_no`)     
ON DELETE NO ACTION     ON UPDATE NO ACTION) ENGINE = InnoDB;
