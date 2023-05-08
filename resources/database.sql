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
PRIMARY KEY (departure_city, arrival_city),
FOREIGN KEY (departure_city) REFERENCES city (id),
FOREIGN KEY (arrival_city) REFERENCES city (id)
);

CREATE TABLE card_color (
id INT NOT NULL AUTO_INCREMENT,
color ENUM('YELLOW','GREEN','RED','BLACK','WHITE','GRAY','ORANGE','MULTICOLOR','BLUE','PINK') NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE route_card_color (
route_departure_city INT NOT NULL,
route_arrival_city INT NOT NULL,
card_color_id INT NOT NULL,
FOREIGN KEY (route_departure_city, route_arrival_city) REFERENCES route (departure_city, arrival_city),
FOREIGN KEY (card_color_id) REFERENCES card_color (id),
PRIMARY KEY (route_departure_city, route_arrival_city, card_color_id)
);

INSERT INTO card_color(id,color)VALUES
(1,'YELLOW'),
(2,'GREEN'),
(3,'RED'),
(4,'BLACK'),
(5,'WHITE'),
(6,'GRAY'),
(7,'ORANGE'),
(8,'BLUE'),
(9,'PINK'),
(10,'MULTICOLOR');

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
(18, 'Kansas POJOs.City'),
(19, 'Oklahoma POJOs.City'),
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
(31, 'Salt Lake POJOs.City'),
(32, 'Las Vegas'),
(33, 'Los Angeles'),
(34, 'Phoenix'),
(35, 'San Francisco'),
(36, 'Little Rock');

INSERT INTO route (departure_city, arrival_city, cards_needed) VALUES
(1, 2, 2),
(5, 4, 2),
(4, 3, 3),
(3, 1, 3),
(2, 3, 2),
(1, 6, 2),
(5, 6, 2),
(6, 7, 2),
(5, 7, 2),
(7, 8, 2),
(8, 9, 4),
(7, 10, 2),
(10, 8, 2),
(9, 10, 5),
(10, 12, 1),
(12, 7, 3),
(12, 5, 4),
(3, 15, 5),
(4, 15, 2),
(4, 16, 6),
(4, 14, 4),
(5, 14, 3),
(5, 13, 5),
(9, 11, 6),
(10, 11, 4),
(12, 13, 2),
(13, 14, 2),
(12, 36, 3),
(11, 21, 2),
(11, 36, 3),
(36, 13, 2),
(21, 20, 1),
(20, 36, 2),
(20, 19, 2),
(19, 18, 2),
(19, 36, 2),
(18, 13, 2),
(18, 17, 1),
(17, 14, 4),
(16, 14, 3),
(16, 15, 3),
(17, 16, 2),
(29, 28, 1),
(29, 30, 1),
(30, 31, 6),
(31, 32, 3),
(32, 33, 2),
(25, 31, 3),
(25, 16, 3),
(33, 34, 3),
(34, 24, 5),
(34, 23, 3),
(34, 22, 3),
(23, 24, 2),
(26, 27, 6),
(26, 16, 4),
(27, 28, 3),
(15, 26, 6),
(17,25,5),
(17,24,4),
(18,24,4),
(19,24,4),
(19,23,3),
(19,22,5),
(22,20,4),
(22,21,6),
(23,22,2),
(24,25,4),
(25,27,4),
(26,25,4),
(27,29,4),
(25,29,6),
(24,31,3),
(31,35,5),
(35,33,3),
(22,33,6);



INSERT INTO route_card_color (route_departure_city, route_arrival_city, card_color_id)
VALUES
    (1,2,3),
    (5, 4, 6),
    (4, 3, 6),
    (3, 1, 8),
    (2, 3, 6),
    (1, 6, 4),
    (5, 6, 6),
    (6, 7, 6),
    (5, 7, 6),
    (7, 8, 6),
    (8, 9, 9),
    (7, 10, 6),
    (10, 8, 6),
    (9, 10, 8),
    (10, 12, 6),
    (12, 7, 4),
    (12, 5, 1),
    (3, 15, 4),
    (4, 15, 6),
    (4, 16, 9),
    (4, 14, 5),
    (5, 14, 7),
    (5, 13, 2),
    (9, 11, 3),
    (10, 11, 1),
    (12, 13, 6),
    (13, 14, 5),
    (12, 36, 6),
    (11, 21, 6),
    (11, 36, 2),
    (36, 13, 6),
    (21, 20, 6),
    (20, 36, 6),
    (20, 19, 6),
    (19, 18, 6),
    (19, 36, 6),
    (18, 13, 8),
    (18, 17, 6),
    (17, 14, 8),
    (16, 14, 3),
    (16, 15, 6),
    (17, 16, 6),
    (29, 28, 6),
    (29, 30, 6),
    (30, 31, 8),
    (31, 32, 7),
    (32, 33, 6),
    (25, 31, 9),
    (25, 16, 7),
    (33, 34, 6),
    (34, 24, 5),
    (34, 23, 6),
    (34, 22, 6),
    (23, 24, 6),
    (26, 27, 5),
    (26, 16, 4),
    (27, 28, 6),
    (15, 26, 6),
    (17,25,3),
    (17,24,9),
    (18,24,4),
    (19,24,3),
    (19,23,8),
    (19,22,1),
    (22,20,3),
    (22,21,2),
    (23,22,6),
    (24,25,2),
    (25,27,6),
    (26,25,8),
    (27,29,6),
    (25,29,1),
    (24,31,1),
    (31,35,5),
    (35,33,1),
    (22,33,4);





















