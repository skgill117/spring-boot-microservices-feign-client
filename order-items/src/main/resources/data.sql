DROP TABLE IF EXISTS order_items;
 
CREATE TABLE order_items (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code VARCHAR(25) NOT NULL,
  product_name VARCHAR(100) NOT NULL,
  quantity INT(100) DEFAULT NULL,
  order_id INT(11) NOT NULL
);




 
