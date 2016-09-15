CREATE TABLE address_tab (
address_id INT(12) SIGNED AUTO_INCREMENT PRIMARY KEY,
street VARCHAR(100) NOT NULL,
city 	VARCHAR(100) NOT NULL,
country VARCHAR(100)
);

CREATE TABLE user_tab (
user_id INT(12) SIGNED AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(60) NOT NULL,
address_id 	INT SIGNED,
phone_number VARCHAR(15),
FOREIGN KEY (address_id) REFERENCES address_tab(address_id));