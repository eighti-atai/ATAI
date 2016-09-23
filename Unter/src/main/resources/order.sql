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
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$