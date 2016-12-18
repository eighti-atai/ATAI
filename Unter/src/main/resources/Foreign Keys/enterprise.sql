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

CALL PROC_DROP_FOREIGN_KEY('user_role_tab', 'fk_user_role_roleid');
CALL PROC_DROP_FOREIGN_KEY('user_role_tab', 'fk_user_role_userid');
CALL PROC_DROP_FOREIGN_KEY('customer_tab', 'fk_address');
 
ALTER TABLE user_role_tab
ADD CONSTRAINT fk_user_role_roleid
FOREIGN KEY (role_id)
REFERENCES role_tab(role_id)
ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT fk_user_role_userid
FOREIGN KEY (user_id)
REFERENCES user_tab(user_id)
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE customer_tab
ADD CONSTRAINT fk_address
FOREIGN KEY (address_id)
REFERENCES address_tab(address_id)
ON DELETE NO ACTION;
