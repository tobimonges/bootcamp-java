CREATE DATABASE social;
CREATE TABLE usuarios (
  id SERIAL PRIMARY KEY,
  username VARCHAR(100),
  email VARCHAR(100),
  role VARCHAR(50),
  created_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE posts (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(255),
  mensaje TEXT,
  user_id INTEGER REFERENCES usuarios(id),
  estado VARCHAR(50),
  created_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE comentarios (
  id SERIAL PRIMARY KEY,
  comentario TEXT,
  user_id INTEGER REFERENCES usuarios(id),
  post_id INTEGER REFERENCES posts(id),
  estado VARCHAR(50),
  created_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE seguidores (
  seguidor_user_id INTEGER REFERENCES usuarios(id),
  seguido_user_id INTEGER REFERENCES usuarios(id),
  created_at TIMESTAMP WITH TIME ZONE
);