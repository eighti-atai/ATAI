CREATE TABLE `unter`.`inventory_part_tab` (
  `inv_part_no` VARCHAR(30) NOT NULL,
  `description` VARCHAR(200) NULL,
  `uom` VARCHAR(10) NULL,
  `reorder_level` DOUBLE NULL,
  `safety_stock_level` DOUBLE NULL,
  PRIMARY KEY (`inv_part_no`));

