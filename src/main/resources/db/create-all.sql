CREATE SCHEMA book_storage;

CREATE TABLE book_storage.genre (
  id BIGSERIAL PRIMARY KEY ,
  name CHARACTER VARYING(128) UNIQUE NOT NULL
);

CREATE TABLE book_storage.author (
  id BIGSERIAL PRIMARY KEY ,
  name CHARACTER VARYING(128) UNIQUE NOT NULL ,
  date_of_birth DATE NOT NULL
);

CREATE TABLE book_storage.book (
  id BIGSERIAL PRIMARY KEY ,
  name CHARACTER VARYING(256) NOT NULL ,
  creation_year INTEGER NOT NULL ,
  genre_id BIGINT REFERENCES book_storage.genre(id) NOT NULL ,
  author_id BIGINT REFERENCES book_storage.author(id) NOT NULL
);

INSERT INTO book_storage.genre(name) VALUES
  ('Роман'),
  ('Поэма'),
  ('Художественная литература'),
  ('Фантастика'),
  ('Ужасы'),
  ('Драма'),
  ('Боевик');

INSERT INTO book_storage.author (name, date_of_birth) VALUES
  ('Пушкин', '06.06.1799'),
  ('Лермонтов', '15.10.1814'),
  ('Толстой', '09.09.1828');

INSERT INTO book_storage.book (name, creation_year, genre_id, author_id) VALUES
  (
    'Анна Каренин',
    1877,
    (SELECT id FROM book_storage.genre WHERE name = 'Художественная литература'),
    (SELECT id FROM book_storage.author WHERE name = 'Толстой')
  ),
  (
    'Война и мир',
    1869,
    (SELECT id FROM book_storage.genre WHERE name = 'Художественная литература'),
    (SELECT id FROM book_storage.author WHERE name = 'Толстой')
  ),
  (
    'Семейное счастье',
    1859,
    (SELECT id FROM book_storage.genre WHERE name = 'Художественная литература'),
    (SELECT id FROM book_storage.author WHERE name = 'Толстой')
  ),
  (
    'Декабристы',
    1859,
    (SELECT id FROM book_storage.genre WHERE name = 'Художественная литература'),
    (SELECT id FROM book_storage.author WHERE name = 'Толстой')
  ),
  (
    'Воскресение',
    1899,
    (SELECT id FROM book_storage.genre WHERE name = 'Художественная литература'),
    (SELECT id FROM book_storage.author WHERE name = 'Толстой')
  ),
  (
    'Руслан и Людмила',
    1820,
    (SELECT id FROM book_storage.genre WHERE name = 'Поэма'),
    (SELECT id FROM book_storage.author WHERE name = 'Пушкин')
  ),
  (
    'Евгений Онегин',
    1832,
    (SELECT id FROM book_storage.genre WHERE name = 'Роман'),
    (SELECT id FROM book_storage.author WHERE name = 'Пушкин')
  ),
  (
    'Борис Годунов',
    1825,
    (SELECT id FROM book_storage.genre WHERE name = 'Драма'),
    (SELECT id FROM book_storage.author WHERE name = 'Пушкин')
  ),
  (
    'Цыганы',
    1828,
    (SELECT id FROM book_storage.genre WHERE name = 'Драма'),
    (SELECT id FROM book_storage.author WHERE name = 'Лермонтов')
  ),
  (
    'Корсар',
    1828,
    (SELECT id FROM book_storage.genre WHERE name = 'Поэма'),
    (SELECT id FROM book_storage.author WHERE name = 'Лермонтов')
  ),
  (
    'Демон',
    1839,
    (SELECT id FROM book_storage.genre WHERE name = 'Поэма'),
    (SELECT id FROM book_storage.author WHERE name = 'Лермонтов')
  );
