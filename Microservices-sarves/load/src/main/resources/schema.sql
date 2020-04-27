DROP TABLE IF EXISTS Load;
CREATE TABLE Load (
  load_id INT AUTO_INCREMENT  PRIMARY KEY,
  age VARCHAR(100) DEFAULT NULL,
  origin VARCHAR(250) DEFAULT NULL,
  destination VARCHAR(250) DEFAULT NULL,
  pickup_date Date DEFAULT NULL,
  delivery_date Date DEFAULT NULL,
  customer_id INT DEFAULT NULL,
  carrier_id INT DEFAULT NULL
);


DROP TABLE IF EXISTS Commodity;
CREATE TABLE Commodity (
  commodity_id INT AUTO_INCREMENT  PRIMARY KEY,
  commodity_name VARCHAR(100) DEFAULT NULL,
  commodity_width INT DEFAULT NULL,
  commodity_length INT DEFAULT NULL,
  load_id INT DEFAULT NULL,
  FOREIGN KEY (load_id) REFERENCES load (load_id)

);


