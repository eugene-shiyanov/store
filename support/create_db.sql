-- delete database
DROP DATABASE IF EXISTS store;

-- delete user
-- DROP USER 'javauser'@'localhost';

-- create user
GRANT ALL PRIVILEGES ON *.* TO 'javauser'@'localhost' IDENTIFIED BY 'javadude' WITH GRANT OPTION;

-- create database
CREATE DATABASE IF NOT EXISTS store;

USE store;

-- create tables
CREATE TABLE IF NOT EXISTS items (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name CHAR(255) NOT NULL,
	price DOUBLE
);

CREATE TABLE IF NOT EXISTS stores (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name CHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS usergroups (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name CHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT PRIMARY KEY,
    login CHAR(255) NOT NULL UNIQUE,
    email CHAR(255) NOT NULL UNIQUE,
    first_name CHAR(255) NOT NULL,
    last_name CHAR(255) NOT NULL,
    patronymic_name CHAR(255) NOT NULL,
    usergroup_id INT NOT NULL,
    password CHAR(255) NOT NULL,
    CONSTRAINT usergroups_id_fk
    FOREIGN KEY (usergroup_id)
    REFERENCES usergroups (id)
);

-- insert data
INSERT INTO items(name, price) VALUES('CPU', 50.5);
INSERT INTO items(name, price) VALUES('VGA', 60.6);
INSERT INTO items(name, price) VALUES('HDD', 70.7);

INSERT INTO stores (name) VALUES ('Podval');

INSERT INTO usergroups(name) VALUES('ADMINISTRATORS');
INSERT INTO usergroups(name) VALUES('USERS');

INSERT INTO users(login, email, first_name, last_name, patronymic_name, usergroup_id, password)
VALUES('admin', '', '', '', '', 1, 'yjc');
