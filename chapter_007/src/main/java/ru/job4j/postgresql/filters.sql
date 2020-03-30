--В системе заданы таблицы
--product(id, name, type_id, expired_date, price)
--type(id, name)

--Задание.

--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT *
FROM product AS p
	INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT *
FROM product AS p
WHERE p.name LIKE '%Мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT *
FROM product AS p
WHERE p.expired_date between '2020-04-01' and '2020-04-30';

--4. Написать запрос, который выводит самый дорогой продукт.
SELECT *
FROM product
WHERE price = (SELECT MAX(price) FROM product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT count(p.id)
FROM product AS p
	INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'Молоко';

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

SELECT *
FROM product AS p
	INNER JOIN type AS t ON p.type_id = t.id
WHERE t.name = 'Молоко' OR t.name = 'Сыр';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.

SELECT t.name
FROM type AS t
	INNER JOIN product AS p ON t.id = p.type_id
GROUP BY t.name HAVING count(t.name) < 10;

--8. Вывести все продукты и их тип.

SELECT p.name, t.name
FROM product AS p
	INNER JOIN type AS t ON p.type_id = t.id;