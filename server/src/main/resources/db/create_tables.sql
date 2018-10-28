DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
  id SERIAL UNIQUE,
  name varchar(100) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id SERIAL UNIQUE,
  username varchar(100) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS wishlists;
CREATE TABLE wishlists (
  id SERIAL UNIQUE,
  user_id bigint NOT NULL,
  movie_ids bigint[] DEFAULT array[]::bigint[]
);