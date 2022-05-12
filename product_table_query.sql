CREATE DATABASE products;

USE products;

CREATE TABLE product (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  amount DOUBLE UNSIGNED NOT NULL,
  currency VARCHAR(3) NOT NULL
);

INSERT INTO `product` (`id`, `name`, `amount`, `currency`) VALUES
	(1, 'yellowBeard', 9.99, 'EUR'),
	(2, 'redBeard', 9.99, 'EUR'),
	(3, 'greenBeard', 10.99, 'EUR'),
	(4, 'blueBeard', 10.99, 'EUR'),
	(5, 'silverBeard', 12.99, 'EUR'),
	(6, 'goldBeard', 14.99, 'EUR');