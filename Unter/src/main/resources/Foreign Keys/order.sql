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

CALL PROC_DROP_FOREIGN_KEY('customer_order_tab', 'fk_customer');
 
ALTER TABLE customer_order_tab
ADD CONSTRAINT fk_customer
FOREIGN KEY (customer_id)
REFERENCES customer_tab(customer_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE customer_order_tab
ADD CONSTRAINT fk_user
FOREIGN KEY(user_id)
REFERENCES user_tab(user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
