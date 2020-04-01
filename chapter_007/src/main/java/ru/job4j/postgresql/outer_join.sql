create database car_factory;

\c car_factory

create table transmission (
    id serial primary key,
    name varchar(100)
);

create table carbody (
    id serial primary key,
    name varchar(100)
);

create table engine (
    id serial primary key,
    name varchar(100)
);

create table car (
id serial primary key,
name varchar(100),
transmission_id int references transmission(id),
carbody_id int references carbody(id),
engine_id int references engine(id)
);

INSERT INTO transmission (name) VALUES ('МКПП');
INSERT INTO transmission (name) VALUES ('АКПП');
INSERT INTO transmission (name) VALUES ('РКПП');

INSERT INTO carbody (name) VALUES ('Седан');
INSERT INTO carbody (name) VALUES ('Хэтчбек');
INSERT INTO carbody (name) VALUES ('Универсал');
INSERT INTO carbody (name) VALUES ('Купе');
INSERT INTO carbody (name) VALUES ('Кабриолет');

INSERT INTO engine (name) VALUES ('Бензиновый');
INSERT INTO engine (name) VALUES ('Газовый');
INSERT INTO engine (name) VALUES ('Дизельный');
INSERT INTO engine (name) VALUES ('Инжектор');

INSERT INTO car (name, transmission_id, carbody_id, engine_id) VALUES ('Лада', 1, 1, 1);
INSERT INTO car (name, transmission_id, carbody_id, engine_id) VALUES ('Мерседес', 2, 5, 4);


-- 1. Вывести список всех машин и все привязанные к ним детали.

SELECT c.id, c.name, cb.name, tr.name, en.name
FROM car AS c
	INNER JOIN carbody AS cb ON c.carbody_id = cb.id 	
	INNER JOIN transmission AS tr ON c.transmission_id = tr.id 	
	INNER JOIN engine AS en ON c.engine_id = en.id;

--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

SELECT cb.name 
FROM car AS c RIGHT OUTER JOIN carbody AS cb ON c.carbody_id = cb.id 
WHERE c.name is NULL;

SELECT t.name 
FROM car AS c RIGHT OUTER JOIN transmission AS t ON c.transmission_id = t.id 
WHERE c.name is NULL;

SELECT e.name 
FROM car AS c RIGHT OUTER JOIN engine AS e ON c.engine_id = e.id 
WHERE c.name is NULL;

