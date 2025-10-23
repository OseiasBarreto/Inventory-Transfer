CREATE TABLE IF NOT EXISTS warehouses (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS products (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS stocks (
  id IDENTITY PRIMARY KEY,
  warehouse_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL,
  version INT,
  CONSTRAINT fk_stocks_warehouse FOREIGN KEY (warehouse_id) REFERENCES warehouses(id),
  CONSTRAINT fk_stocks_product FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT uq_stock UNIQUE (warehouse_id, product_id)
);
