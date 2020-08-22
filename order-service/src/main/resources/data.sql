DROP TABLE IF EXISTS order_details;
 
CREATE TABLE order_details (
  order_id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(100) NOT NULL,
  order_date DATE NOT NULL,
  shipping_address VARCHAR(1000) DEFAULT NULL,
  total DECIMAL(10,2) NOT NULL
);



 
