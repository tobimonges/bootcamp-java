CREATE TABLE fases (
	id_fase SERIAL PRIMARY KEY,
	nombre_fase VARCHAR
);

CREATE TABLE grupos (
	id_grupo SERIAL PRIMARY KEY,
	nombre_grupo VARCHAR,
	id_fase INTEGER REFERENCES fases(id_fase)
);

CREATE TABLE equipos (
	id_equipo SERIAL PRIMARY KEY,
	nombre_equipo VARCHAR,
	pais VARCHAR,
	id_grupo INTEGER REFERENCES grupos(id_grupo)
);

CREATE TABLE jugadores (
	id_jugadores SERIAL PRIMARY KEY,
	nombre_jugador VARCHAR,
	nacionalidad VARCHAR,
	id_equipo INTEGER REFERENCES equipos(id_equipo)
);

CREATE TABLE partidos (
	id_partido SERIAL PRIMARY KEY,
	id_fase INTEGER REFERENCES fases(id_fase)
);

CREATE TABLE partido_equipo (
	id_partido INTEGER REFERENCES partidos(id_partido),
	id_equipo INTEGER REFERENCES equipos(id_equipo),
	resultado VARCHAR,
	PRIMARY KEY (id_partido, id_equipo)
)