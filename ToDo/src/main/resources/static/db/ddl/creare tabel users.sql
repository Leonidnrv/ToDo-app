--Cream incrementarea
CREATE SEQUENCE users_id_seq START WITH 1;
--Cream tabelul
CREATE TABLE users (
	id BIGINT PRIMARY key default nextval('users_id_seq'), --PK care se auto-incrementeaza
	nume VARCHAR(50) NOT NULL UNIQUE, --numele utilizatorilor NOT NULL unic
	parola varchar(50) NOT NULL, --parola
	creat_la TIMESTAMP DEFAULT current_timestamp 
)


insert into users (nume, parola) values ('Leonid', 'parola1')