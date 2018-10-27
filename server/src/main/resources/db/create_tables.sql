DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
  id SERIAL UNIQUE,
  name varchar(100) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS wishlists;
CREATE TABLE wishlists (
  id SERIAL UNIQUE,
  user_id bigint,
  movie_ids bigint[] DEFAULT array[]::bigint[]
);