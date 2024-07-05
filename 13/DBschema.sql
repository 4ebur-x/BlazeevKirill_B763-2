CREATE DATABASE videoteca01;

USE videoteca01;

CREATE TABLE actors (
                        actor_id INT AUTO_INCREMENT PRIMARY KEY,
                        full_name VARCHAR(100) NOT NULL,
                        birth_date DATE NOT NULL
);

CREATE TABLE directors (
                           director_id INT AUTO_INCREMENT PRIMARY KEY,
                           full_name VARCHAR(100) NOT NULL,
                           birth_date DATE NOT NULL
);

CREATE TABLE movies (
                        movie_id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(100) NOT NULL,
                        release_date DATE NOT NULL,
                        country VARCHAR(50) NOT NULL
);

CREATE TABLE movie_actors (
                              movie_id INT,
                              actor_id INT,
                              FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
                              FOREIGN KEY (actor_id) REFERENCES actors(actor_id),
                              PRIMARY KEY (movie_id, actor_id)
);

CREATE TABLE movie_directors (
                                 movie_id INT,
                                 director_id INT,
                                 FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
                                 FOREIGN KEY (director_id) REFERENCES directors(director_id),
                                 PRIMARY KEY (movie_id, director_id)
);
INSERT INTO actors (full_name, birth_date) VALUES
                                               ('Leonardo DiCaprio', '1974-11-11'),
                                               ('Joseph Gordon-Levitt', '1981-02-17'),
                                               ('Ellen Page', '1987-02-21'),
                                               ('Christian Bale', '1974-01-30'),
                                               ('Heath Ledger', '1979-04-04'),
                                               ('Aaron Eckhart', '1968-03-12'),
                                               ('Margot Robbie', '1990-07-02'),
                                               ('Tom Cruise', '1962-07-03'),
                                               ('Emily Blunt', '1983-02-23'),
                                               ('Cillian Murphy', '1976-05-25'),
                                               ('Florence Pugh', '1996-01-03'),
                                               ('Timothée Chalamet', '1995-12-27'),
                                               ('Zendaya', '1996-09-01'),
                                               ('Chris Pratt', '1979-06-21'),
                                               ('Zoe Saldana', '1978-06-19');
INSERT INTO directors (full_name, birth_date) VALUES
                                                  ('Christopher Nolan', '1970-07-30'),
                                                  ('Quentin Tarantino', '1963-03-27'),
                                                  ('Martin Scorsese', '1942-11-17'),
                                                  ('Steven Spielberg', '1946-12-18'),
                                                  ('James Cameron', '1954-08-16'),
                                                  ('Matt Reeves', '1966-04-27'),
                                                  ('Joseph Kosinski', '1974-05-03'),
                                                  ('Denis Villeneuve', '1967-10-03');
INSERT INTO movies (title, release_date, country) VALUES
-- Фильмы, вышедшие в 2022 году
('Avatar: The Way of Water', '2022-12-16', 'USA'),
('The Batman', '2022-03-04', 'USA'),
('Top Gun: Maverick', '2022-05-27', 'USA'),
-- Фильмы, вышедшие в 2023 году
('Oppenheimer', '2023-07-21', 'USA'),
('Dune: Part Two', '2023-10-20', 'USA'),
('Guardians of the Galaxy Vol. 3', '2023-05-05', 'USA');
INSERT INTO movie_actors (movie_id, actor_id) VALUES
-- Avatar: The Way of Water
(1, 14), -- Zoe Saldana
-- The Batman
(2, 4), -- Christian Bale
-- Top Gun: Maverick
(3, 8), -- Tom Cruise
(3, 9), -- Emily Blunt
-- Оppenheimer
(4, 10), -- Cillian Murphy
(4, 11), -- Florence Pugh
-- Dune: Part Two
(5, 12), -- Timothée Chalamet
(5, 13), -- Zendaya
-- Guardians of the Galaxy Vol. 3
(6, 14), -- Zoe Saldana
(6, 15); -- Chris Pratt
INSERT INTO movie_directors (movie_id, director_id) VALUES
                                                        (1, 5), -- James Cameron
                                                        (2, 6), -- Matt Reeves
                                                        (3, 7), -- Joseph Kosinski
                                                        (4, 1), -- Christopher Nolan
                                                        (5, 8), -- Denis Villeneuve
                                                        (6, 1); -- Christopher Nolan (допустим, он режиссер этого фильма)
