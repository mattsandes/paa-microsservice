CREATE TABLE book (
  id BIGSERIAL PRIMARY KEY,
  author TEXT NOT NULL,
  launch_date date NOT NULL,
  price decimal(65,2) NOT NULL,
  title TEXT
);