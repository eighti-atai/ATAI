DROP PROCEDURE IF EXISTS PROC_DROP_FOREIGN_KEY;
DELIMITER $$
CREATE PROCEDURE PROC_DROP_FOREIGN_KEY(IN tableName VARCHAR(64), IN constraintName VARCHAR(64))
BEGIN
	IF EXISTS(
		SELECT * FROM information_schema.table_constraints
		WHERE 
			table_schema    = DATABASE()     AND
			table_name      = tableName      AND
			constraint_name = constraintName AND
			constraint_type = 'FOREIGN KEY')
	THEN
		SET @query = CONCAT('ALTER TABLE ', tableName, ' DROP FOREIGN KEY ', constraintName, ';');
		PREPARE stmt FROM @query; 
		EXECUTE stmt; 
		DEALLOCATE PREPARE stmt; 
	END IF; 
END$$
DELIMITER ;

CALL PROC_DROP_FOREIGN_KEY('inventory_part_tab', 'site_fk');
CALL PROC_DROP_FOREIGN_KEY('site_tab', 'site_tab_ibfk_1');
CALL PROC_DROP_FOREIGN_KEY('inventory_location_tab', 'inventory_location_fk');
CALL PROC_DROP_FOREIGN_KEY('inventory_part_cost_tab', 'inv_part_fk');
CALL PROC_DROP_FOREIGN_KEY('inv_part_in_stock_tab', 'inv_part_cost_pk');
CALL PROC_DROP_FOREIGN_KEY('inv_part_in_stock_tab', 'inventory_location_pk');
 
ALTER TABLE inventory_part_tab
ADD CONSTRAINT site_fk
FOREIGN KEY (site_id)
REFERENCES site_tab(site_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE site_tab
ADD CONSTRAINT site_tab_ibfk_1
FOREIGN KEY (address_id)
REFERENCES address_tab(address_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
 
ALTER TABLE inventory_location_tab
ADD CONSTRAINT inventory_location_fk
FOREIGN KEY (site_id)
REFERENCES site_tab(site_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
 
ALTER TABLE inventory_part_cost_tab
ADD CONSTRAINT inv_part_fk
FOREIGN KEY (site_id, inv_part_no)
REFERENCES inventory_part_tab(site_id, inv_part_no)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
 
ALTER TABLE inv_part_in_stock_tab
ADD CONSTRAINT inv_part_cost_pk
FOREIGN KEY (site_id, inv_part_no, inv_part_cost_no)
REFERENCES inventory_part_cost_tab(site_id, inv_part_no, inv_part_cost_no),
ADD CONSTRAINT inventory_location_pk
FOREIGN KEY (site_id, inv_location_id)
REFERENCES inventory_location_tab(site_id, inv_location_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
