--Cream incrementarea
CREATE SEQUENCE tasks_id_seq START WITH 1;

CREATE TABLE tasks (
	id BIGINT PRIMARY key default nextval('taskuri_id_seq'), --PK care se auto-incrementeaza
	titlu VARCHAR(50) NOT NULL, --numele taskului
	descriere TEXT, --parola (TEXT = fara limita de caractere)
	status varchar(50) CHECK (status IN ('In asteptare', 'In lucru', 'Finalizat')),
	due_date timestamp,
	prioritate varchar(1) CHECK (prioritate IN ('0', '1', '2', '3', '4')),
	user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
)


	

