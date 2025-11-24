-- PARTICIPANTES
INSERT INTO participante (cod, nome) VALUES
(1, 'Stark Industries'),
(2, 'Wayne Enterprises'),
(3, 'Umbrella Corporation'),
(4, 'Cyberdyne Systems'),
(10, 'Batman'),
(20, 'Superman'),
(30, 'Coringa');

-- FORNECEDORES (referenciam participante.cod)
INSERT INTO fornecedor (cod, data_fundacao, area) VALUES
(1, '2000-03-01', 'TI'),
(2, '1998-10-10', 'EMERGENTE'),
(3, '2010-05-05', 'ALIMENTOS'),
(4, '1995-07-16', 'ANDROIDES');

-- COMPRADORES (referenciam participante.cod)
INSERT INTO comprador (cod) VALUES
(10),
(20),
(30);

-- TECNOLOGIAS
INSERT INTO tecnologia (id, modelo, descricao, valor_base, peso, temperatura, fornecedor_cod) VALUES
(1, 'ARC-01', 'Reator Arc 1.0', 10000.00, 150.0, 250.0, 1),
(2, 'ARC-02', 'Reator Arc miniaturizado', 20000.00, 80.0, 200.0, 1),
(3, 'BATMOBILE', 'Veículo tático de alta performance', 50000.00, 2000.0, 50.0, 2),
(4, 'BATSUIT', 'Traje de combate reforçado', 15000.00, 50.0, 35.0, 2),
(5, 'T-VIRUS', 'Agente biológico experimental', 12000.00, 10.0, -10.0, 3),
(6, 'T-800', 'Modelo de androide autônomo', 80000.00, 400.0, 100.0, 4);

-- VENDAS
INSERT INTO venda (num, tecnologia_id, comprador_cod, removida) VALUES
(1, 1, 10, false),
(2, 2, 10, false),
(3, 5, 10, false),
(4, 3, 20, false),
(5, 4, 20, false),
(6, 6, 30, false);
