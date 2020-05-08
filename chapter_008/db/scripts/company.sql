--1) Retrieve in a single query:
-- names of all persons that are NOT in the company with id = 5
-- company name for each person

SELECT p.name, c.name AS company_name
FROM person AS p
	INNER JOIN company AS c ON p.company_id = c.id
WHERE p.company_id != 5
;


--2) Select the name of the company with the maximum number of persons + number of persons in this company

SELECT c.name, COUNT(*)
	FROM company AS c
	INNER JOIN person AS p ON c.id = p.company_id
WHERE c.id IN (
			SELECT company_id
			FROM person
			GROUP BY 1
			HAVING COUNT(*) = (
								SELECT MAX(counter) AS count
								FROM (
										SELECT company_id, COUNT(*) AS counter
										FROM person
										GROUP BY 1
									) AS table_1
								)
			)
GROUP BY 1
;