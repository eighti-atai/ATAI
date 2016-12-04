CREATE TABLE payment_tab(
payment_no INT(20) PRIMARY KEY,
payment_type VARCHAR(10) NOT NULL,
payment_method VARCHAR(10) NOT NULL,
cheque_no VARCHAR(20),
cheque_exp_date DATE,
cheque_bank VARCHAR(20),
objid VARCHAR(1000) NOT NULL);