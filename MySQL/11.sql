CREATE TABLE young_animal AS
SELECT name, birth_date, (YEAR(NOW())-YEAR(birth_date))*12+(MONTH(NOW())-MONTH(birth_date)) AS age FROM dogs
WHERE YEAR(NOW())-YEAR(birth_date)>1 AND YEAR(NOW())-YEAR(birth_date)<3
UNION
SELECT name, birth_date, (YEAR(NOW())-YEAR(birth_date))*12+(MONTH(NOW())-MONTH(birth_date)) AS age FROM cats
WHERE YEAR(NOW())-YEAR(birth_date)>1 AND YEAR(NOW())-YEAR(birth_date)<3
UNION
SELECT name, birth_date, (YEAR(NOW())-YEAR(birth_date))*12+(MONTH(NOW())-MONTH(birth_date)) AS age FROM humsters
WHERE YEAR(NOW())-YEAR(birth_date)>1 AND YEAR(NOW())-YEAR(birth_date)<3
UNION
SELECT name, birth_date, (YEAR(NOW())-YEAR(birth_date))*12+(MONTH(NOW())-MONTH(birth_date)) AS age FROM horses
WHERE YEAR(NOW())-YEAR(birth_date)>1 AND YEAR(NOW())-YEAR(birth_date)<3
UNION
SELECT name, birth_date, (YEAR(NOW())-YEAR(birth_date))*12+(MONTH(NOW())-MONTH(birth_date)) AS age FROM donkeys
WHERE YEAR(NOW())-YEAR(birth_date)>1 AND YEAR(NOW())-YEAR(birth_date)<3
