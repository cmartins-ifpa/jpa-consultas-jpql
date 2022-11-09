-- INSERE "automoveis"
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(1, 2020, 2020, 'VW', 'POLO', 78000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(2, 1965, 1966, 'VW', 'FUSCA', 8000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(3, 2020, 2020, 'GM', 'CORSA', 78000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(4, 2021, 2021, 'FORD', 'TAURUS', 127000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(5, 2021, 2022, 'KIA', 'SPORTAGE', 87000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(6, 2022, 2022, 'VW', 'T-CROSS', 99000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(7, 2022, 2023, 'TOYOTA', 'PICAPE HILUX SRX', 323000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(8, 2020, 2020, 'TOYOTA', 'PICAPE HILUX SRV', 243000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(9, 2020, 2021, 'FORD', 'PICAPE RANGER', 290000);
INSERT INTO public.automovel (id, anofabricacao, anomodelo, marca, modelo, valor) VALUES(10, 2020, 2021, 'GM', 'PICAPE S10', 234000);

-- INSERE "veiculos/proprietários"
INSERT INTO veiculo(id, proprietario, automovel, placa, data_compra,atual_proprietario) 
     VALUES (1, 'JOÃO SANTOS', 1, 'ABC1A20', '2022-01-22', true);
INSERT INTO veiculo(id, proprietario, automovel, placa, data_compra,atual_proprietario) 
     VALUES (2, 'MARIA JOSÉ', 1, 'ABC1A20', '2021-11-12', FALSE);     
INSERT INTO veiculo(id, proprietario, automovel, placa, data_compra,atual_proprietario) 
     VALUES (3, 'ANTONIO MATEUS', 2, 'XBC9B99', '2021-12-01', TRUE);     
INSERT INTO veiculo(id, proprietario, automovel, placa, data_compra,atual_proprietario) 
     VALUES (4, 'PEDRO SILVA', 3, 'BGR1A44', '2021-10-10', FALSE);     
INSERT INTO veiculo(id, proprietario, automovel, placa, data_compra,atual_proprietario) 
     VALUES (5, 'ANA SOUZA', 4, 'HUX9B92', '2022-02-01', TRUE);   

-- MULTAS
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (1, '2022-01-03', 1, 120.50);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (2, '2022-02-01', 1, 140.50);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (3, '2022-02-13', 1, 122.00);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (4, '2022-03-11', 2, 230.80);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (5, '2022-01-03', 3, 120.50);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (6, '2022-02-01', 3, 140.50);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (7, '2021-12-13', 4, 122.00);    
INSERT INTO multa (id, data_multa, veiculo, valor) VALUES (8, '2022-03-11', 5, 230.80);   



-- SELECT * FROM Automovel order by anofabricacao