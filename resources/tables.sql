CREATE TABLE city (
id INT NOT NULL AUTO_INCREMENT,
city_name VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE route (
city_id INT NOT NULL,
route_id INT NOT NULL,
PRIMARY KEY (city_id, route_id),
FOREIGN KEY (city_id) REFERENCES city (id),
FOREIGN KEY (route_id) REFERENCES city (id)
);
