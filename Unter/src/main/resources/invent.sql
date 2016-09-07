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
