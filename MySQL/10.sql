CREATE TABLE animal_pack AS
SELECT name, birth_date, id_pack FROM horses
UNION
SELECT name, birth_date, id_pack FROM donkeys;

SELECT * FROM animal_pack;