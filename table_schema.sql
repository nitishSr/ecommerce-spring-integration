CREATE DATABASE ecommerce;

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO product (name, price) VALUES
('Samsung S22', 80000.00),
('Apple Iphone 15', 890000.00),
('Realme Neo 3T', 30000.00);


CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO user (name, email) VALUES
('Tim Laker', 'tim@example.com'),
('Devald Bravis', 'devald@example.com'),
('Luke Wright', 'luke@example.com');

CREATE TABLE IF NOT EXISTS onlineorder (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO onlineorder (user_id, product_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 3);