DROP DATABASE IF EXISTS ttr;
CREATE DATABASE ttr;
USE ttr;

CREATE TABLE city (
id INT NOT NULL AUTO_INCREMENT,
city_name VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE route (
departure_city INT NOT NULL,
arrival_city INT NOT NULL,
cards_needed INT NOT NULL,
card_color ENUM('YELLOW','GREEN','RED','BLACK','WHITE','GRAY','ORANGE') NOT NULL,
PRIMARY KEY (departure_city, arrival_city),
FOREIGN KEY (departure_city) REFERENCES city (id),
FOREIGN KEY (arrival_city) REFERENCES city (id)
);

INSERT INTO city (id, city_name) VALUES
                                     (1, 'New York'),
                                     (2, 'Boston'),
                                     (3, 'Montreal'),
                                     (4, 'Toronto'),
                                     (5, 'Pittsburgh'),
                                     (6, 'Washington'),
                                     (7, 'Raleigh'),
                                     (8, 'Charleston'),
                                     (9, 'Miami'),
                                     (10, 'Atlanta'),
                                     (11, 'New Orleans'),
                                     (12, 'Nashville'),
                                     (13, 'Saint Louis'),
                                     (14, 'Chicago'),
                                     (15, 'Sault St. Marie'),
                                     (16, 'Duluth'),
                                     (17, 'Omaha'),
                                     (18, 'Kansas City'),
                                     (19, 'Oklahoma City'),
                                     (20, 'Dallas'),
                                     (21, 'Houston'),
                                     (22, 'El Paso'),
                                     (23, 'Santa Fe'),
                                     (24, 'Denver'),
                                     (25, 'Helena'),
                                     (26, 'Winnipeg'),
                                     (27, 'Calgary'),
                                     (28, 'Vancouver'),
                                     (29, 'Seattle'),
                                     (30, 'Portland'),
                                     (31, 'Salt Lake City'),
                                     (32, 'Las Vegas'),
                                     (33, 'Los Angeles'),
                                     (34, 'Phoenix'),
                                     (35, 'San Francisco'),
                                     (36, 'Little Rock');

INSERT INTO route (departure_city, arrival_city, cards_needed,card_color) VALUES
(1, 2, 2,'GRAY');


