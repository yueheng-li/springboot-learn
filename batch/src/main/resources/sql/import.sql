create database batch;
use batch;
 
DROP TABLE people IF EXISTS;

CREATE TABLE people  (
	person_id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
	PRIMARY KEY (`person_id`)
);