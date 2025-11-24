-- FORNECEDORES
INSERT INTO fornecedor (cod, nome, data_fundacao, area) VALUES
(1, 'Stark Industries', '2000-03-01', 'TI'),
(2, 'Wayne Enterprises', '1998-10-10', 'EMERGENTE'),
(3, 'Umbrella Corporation', '2010-05-05', 'ALIMENTOS'),
(4, 'Cyberdyne Systems', '1995-07-16', 'ANDROIDES');

-- TECNOLOGIAS
INSERT INTO tecnologia (id, modelo, descricao, valor_base, peso, temperatura, fornecedor_cod) VALUES
(1, 'ARC-01', 'Reator Arc 1.0', 10000.00, 150.0, 250.0, 1),
(2, 'ARC-02', 'Reator Arc miniaturizado', 20000.00, 80.0, 200.0, 1),
(3, 'BATMOBILE', 'Veículo tático de alta performance', 50000.00, 2000.0, 50.0, 2),
(4, 'BATSUIT', 'Traje de combate reforçado', 15000.00, 50.0, 35.0, 2),
(5, 'T-VIRUS', 'Agente biológico experimental', 12000.00, 10.0, -10.0, 3),
(6, 'T-800', 'Modelo de androide autônomo', 80000.00, 400.0, 100.0, 4);

-- COMPRADORES
INSERT INTO comprador (cod, nome, email, pais) VALUES
(1, 'Batman', 'batman@email.com', 'Brasil'),
(2, 'Superman', 'superman@email.com', 'Estados Unidos'),
(3, 'Coringa', 'coringa@email.com' ,'Australia');

-- VENDAS
INSERT INTO venda (num, tecnologia_id, comprador_cod, removida) VALUES
(1, 1, 1, false),
(2, 2, 1, false),
(3, 5, 1, false),
(4, 3, 2, false),
(5, 4, 2, false),
(6, 6, 3, false);