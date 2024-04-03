CREATE DATABASE ecommerce;

USE ecommerce;
CREATE TABLE product_recommendations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    recommendation_count INT NOT NULL
);
INSERT INTO product_recommendations (product_name, recommendation_count) VALUES
    ('Product 1', 10),
    ('Product 2', 5),
    ('Product 3', 8),
    ('Product 4', 3),
    ('Product 5', 12);