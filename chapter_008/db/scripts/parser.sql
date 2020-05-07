CREATE DATABASE parser;
\c parser;

CREATE TABLE post (
	id serial primary key,
	name varchar (200),
	text text,
	link varchar (200) UNIQUE,
	created date
);
