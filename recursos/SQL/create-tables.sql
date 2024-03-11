DROP TABLE multa  CASCADE CONSTRAINTS;
DROP TABLE veiculo  CASCADE CONSTRAINTS;
DROP TABLE automovel  CASCADE CONSTRAINTS;

CREATE TABLE automovel (
	id 				INT PRIMARY KEY,
	anoFabricacao	INT, 
	anoModelo	INT, 
	marca	VARCHAR(30), 
	modelo	VARCHAR(30), 
	valor NUMERIC(10,2)
);

CREATE TABLE veiculo(
  	id 	INT PRIMARY KEY,
   	proprietario VARCHAR(60),
   	automovel INT REFERENCES automovel(id),   
    placa  VARCHAR(10),
    data_compra  DATE,
    atual_proprietario BOOLEAN  DEFAULT TRUE
);

CREATE TABLE multa (
   id 	INT PRIMARY KEY,
   data_multa DATE,
   veiculo INT REFERENCES veiculo(id),
   valor  NUMERIC(10,2)
 );
