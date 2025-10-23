INSERT INTO warehouses (name, location) VALUES ('Armazém Central', 'São Paulo');
INSERT INTO warehouses (name, location) VALUES ('Armazém Filial', 'Rio de Janeiro');

INSERT INTO products (name, description) VALUES ('Notebook Dell', '16GB RAM');
INSERT INTO products (name, description) VALUES ('Mouse Logitech', 'Sem fio');

-- Estoque inicial
INSERT INTO stocks (warehouse_id, product_id, quantity, version) VALUES (1, 1, 50, 0);
INSERT INTO stocks (warehouse_id, product_id, quantity, version) VALUES (2, 1, 10, 0);
