DROP TABLE IF EXISTS ODONTOLOGO;
CREATE TABLE ODONTOLOGO(
ID INT AUTO_INCREMENT PRIMARY KEY,
NUMERO_MATRICULA INT NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
APELLIDO VARCHAR(50) NOT NULL
);

INSERT INTO ODONTOLOGO
VALUES (DEFAULT, 123, 'PEPITO','PEREZ');