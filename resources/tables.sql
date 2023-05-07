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
id INT PRIMARY KEY,
color ENUM('YELLOW','GREEN','RED','BLACK','WHITE','GRAY','ORANGE','BLUE','PINK') NOT NULL
);

CREATE TABLE route_card_color (
route_departure_city INT NOT NULL,
route_arrival_city INT NOT NULL,
card_color_id INT NOT NULL,
FOREIGN KEY (route_departure_city, route_arrival_city) REFERENCES route (departure_city, arrival_city),
FOREIGN KEY (card_color_id) REFERENCES card_color (id),
PRIMARY KEY (route_departure_city, route_arrival_city, card_color_id)
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

INSERT INTO route (departure_city, arrival_city, cards_needed) VALUES
(1, 2, 2), --
(5, 4, 2), --
(4, 3, 3), --
(3, 1, 3),--
(2, 3, 2),--
(1, 6, 2),--
(5, 6, 2),--
(6, 7, 2),--
(5, 7, 2),--
(7, 8, 2),--
(8, 9, 4),--
(7, 10, 2),--
(10, 8, 2),--
(9, 10, 5),--
(10, 12, 1),--
(12, 7, 3),--
(12, 5, 4),--
(3, 15, 5),--
(4, 15, 2),--
(4, 16, 6),--
(4, 14, 4),--
(5, 14, 3),--
(5, 13, 5),--
(9, 11, 6),--
(10, 11, 4),--
(12, 13, 2),--
(13, 14, 2),--
(12, 36, 3),--
(11, 21, 2),--
(11, 36, 3),--
(36, 13, 2),--
(21, 20, 1),--
(20, 36, 2),--
(20, 19, 2),--
(19, 18, 2),--
(19, 36, 2),--
(18, 13, 2),--
(18, 17, 1),--
(17, 14, 4),--
(16, 14, 3),--
(16, 15, 3),--
(17, 16, 2),--
(29, 28, 1),--
(29, 30, 1),--
(30, 31, 6),--
(31, 32, 3),--
(32, 33, 2),--
(25, 31, 3),--
(25, 16, 3),--
(33, 34, 3),--
(34, 24, 5),--
(34, 23, 3),--
(34, 22, 3),--
(23, 24, 2),--
(26, 27, 6),--
(26, 16, 4),--
(27, 28, 3),--
(15, 26, 6);--

INSERT INTO route_card_color (route_departure_city, route_arrival_city, card_color_id)
VALUES
    (1,2,'RED'),
    (1,2,'YELLOW'),
    (5, 4, 'GRAY'),
    (4, 3, 'GRAY'),
    (3, 1, 'BLUE'),
    (2, 3, 'GRAY'),
    (3, 2, 'GRAY'),
    (1, 6, 'BLACK'),
    (1, 6, 'ORANGE'),
    (5, 6, 'GRAY'),
    (6, 7, 'GRAY'),
    (7, 6, 'GRAY'),
    (5, 7, 'GRAY'),
    (7, 8, 'GRAY'),
    (8, 9, 'PINK'),
    (7, 10, 'GRAY'),
    (10, 7, 'GRAY'),
    (10, 8, 'GRAY'),
    (9, 10, 'BLUE'),
    (10, 12, 'GRAY'),
    (12, 7, 'BLACK'),
    (12, 5, 'YELLOW'),
    (3, 15, 'BLACK'),
    (4, 15, 'GRAY'),
    (4, 16, 'PINK'),
    (4, 14, 'WHITE'),
    (5, 14, 'ORANGE'),
    (14, 5, 'BLACK'),
    (5, 13, 'GREEN'),
    (9, 11, 'RED'),
    (10, 11, 'YELLOW'),
    (11, 10, 'ORANGE'),
    (12, 13, 'GRAY'),
    (13, 14, 'WHITE'),
    (14, 13, 'GREEN'),
    (12, 36, 'GRAY'),
    (11, 21, 'GRAY'),
    (11, 36, 'GREEN'),
    (36, 13, 'GRAY'),
    (21, 20, 'GRAY'),
    (20, 36, 'GRAY'),
    (20, 19, 'GRAY'),
    (19, 20, 'GRAY'),
    (19, 18, 'GRAY'),
    (18, 19, 'GRAY'),
    (19, 36, 'GRAY'),
    (18, 13, 'BLUE'),
    (13, 18, 'PINK'),
    (18, 17, 'GRAY'),
    (17, 18, 'GRAY'),
    (17, 14, 'BLUE'),
    (16, 14, 'RED'),
    (16, 15, 'GRAY'),
    (17, 16, 'GRAY'),
    (29, 28, 'GRAY'),
    (28, 29, 'GRAY'),
    (29, 30, 'GRAY'),
    (30, 29, 'GRAY'),
    (30, 31, 'BLUE'),
    (31, 32, 'ORANGE'),
    (32, 33, 'GRAY'),
    (25, 31, 'PINK'),
    (25, 16, 'ORANGE'),
    (33, 34, 'GRAY'),
    (34, 24, 'WHITE'),
    (34, 23, 'GRAY'),
    (34, 22, 'GRAY'),
    (23, 24, 'GRAY'),
    (26, 27, 'WHITE'),
    (26, 16, 'BLACK'),
    (27, 28, 'GRAY'),
    (15, 26, 'GRAY');


















