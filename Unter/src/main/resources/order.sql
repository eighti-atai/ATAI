CREATE TABLE `sales_part_tab` (
  `sales_part_id` 			VARCHAR(10) NOT NULL,
  `description` 			VARCHAR(20) NOT NULL,
  `inv_part_id` 			VARCHAR(10) NOT NULL,
  `inv_conversion_factor` 	INT(11) DEFAULT NULL,
  `uom` 					VARCHAR(10) DEFAULT NULL,
  `price_category` 			VARCHAR(10) DEFAULT NULL,
  `general_category` 		VARCHAR(10) DEFAULT NULL,
  
  PRIMARY KEY (`sales_part_id`),
  KEY `inventory_to_sales_part` (`inv_part_id`),
  
  CONSTRAINT `inventory_to_sales_part` FOREIGN KEY (`inv_part_id`) REFERENCES `inventory_part_tab` (`inv_part_no`) ON UPDATE NO ACTION
) ENGINE=InnoDB 


CREATE TABLE `sales_part_price_tab` (
  `sales_part_id` varchar(10) NOT NULL,
  `sales_part_price_no` int(11) NOT NULL,
  `inv_part_id` varchar(10) NOT NULL,
  `inv_part_cost_no` int(11) NOT NULL,
  PRIMARY KEY (`sales_part_id`,`sales_part_price_no`),
  KEY `sales_part_to_sales_part_price` (`sales_part_id`),
  KEY `inventory_to_sales_part_price` (`inv_part_id`),
  CONSTRAINT `inventory_to_sales_part_price` FOREIGN KEY (`inv_part_id`) REFERENCES `inventory_part_tab` (`inv_part_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sales_part_to_sales_part_price` FOREIGN KEY (`sales_part_id`) REFERENCES `sales_part_tab` (`sales_part_id`) ON UPDATE NO ACTION,
  CONSTRAINT `inv_cost_to_sales_part_price` FOREIGN KEY (`inv_part_id`,`inv_part_cost_no`) REFERENCES `inventory_part_cost_tab` (`inv_part_no`,`inv_part_cost_no`) ON UPDATE NO ACTION
  ) ENGINE=InnoDB 



