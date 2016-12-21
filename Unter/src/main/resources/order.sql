CREATE TABLE IF NOT EXISTS `sales_part_tab` (
  `sales_part_id` 			VARCHAR(10) NOT NULL,
  `description` 			VARCHAR(20) NOT NULL,
  `inv_part_id` 			VARCHAR(10) NOT NULL,
  `inv_conversion_factor` 	INT(11) DEFAULT NULL,
  `uom` 					VARCHAR(10) DEFAULT NULL,
  `price_category` 			VARCHAR(10) DEFAULT NULL,
  `general_category` 		VARCHAR(10) DEFAULT NULL,
  `objid`					VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`sales_part_id`),
  KEY `inventory_to_sales_part` (`inv_part_id`),
  
  CONSTRAINT `inventory_to_sales_part` FOREIGN KEY (`inv_part_id`) REFERENCES `inventory_part_tab` (`inv_part_no`) ON UPDATE NO ACTION
) ENGINE=InnoDB ;


CREATE TABLE IF NOT EXISTS `sales_part_price_tab` (
  `sales_part_id` 			VARCHAR(10) NOT NULL,
  `sales_part_price_no` 	INT(11) NOT NULL,
  `inv_part_id` 			VARCHAR(10) NOT NULL,
  `inv_part_cost_no` 		INT(11) NOT NULL,
  `objid`					VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`sales_part_id`,`sales_part_price_no`),
  
  KEY `sales_part_to_sales_part_price` (`sales_part_id`),
  KEY `inventory_to_sales_part_price` (`inv_part_id`),
  CONSTRAINT `inventory_to_sales_part_price`  FOREIGN KEY (`inv_part_id`) REFERENCES `inventory_part_tab` (`inv_part_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sales_part_to_sales_part_price` FOREIGN KEY (`sales_part_id`) REFERENCES `sales_part_tab` (`sales_part_id`) ON UPDATE NO ACTION,
  CONSTRAINT `inv_cost_to_sales_part_price`   FOREIGN KEY (`inv_part_id`,`inv_part_cost_no`) REFERENCES `inventory_part_cost_tab` (`inv_part_no`,`inv_part_cost_no`) ON UPDATE NO ACTION
  ) ENGINE=InnoDB ;

  
  CREATE TABLE IF NOT EXISTS customer_order_tab(
  customer_order_id VARCHAR(20) PRIMARY KEY,
  order_date DATETIME NOT NULL,
  status VARCHAR(10) NOT NULL,
  note VARCHAR(50),
  payment_no INT(10),
  customer_id VARCHAR(5),
  user_id bigint(20),
  objid VARCHAR(1000) NOT NULL);
  
  
  CREATE TABLE IF NOT EXISTS customer_order_line_tab(
  customer_order_id VARCHAR(20) NOT NULL,
  co_line_no INT(5) NOT NULL,
  sales_qty INT(10) NOT NULL,
  discount DECIMAL(2,2),
  amount DECIMAL(10,2) NOT NULL,
  sales_part_id VARCHAR(10),
  sales_part_price_no INT(11),
  objid VARCHAR(1000) NOT NULL,
  PRIMARY KEY(customer_order_id, co_line_no));

