--liquibase formatted sql

--changeset ai:1 labels:products
CREATE TABLE products (
                          id          BIGSERIAL PRIMARY KEY,
                          name        VARCHAR(255) NOT NULL,
                          sku         VARCHAR(100) NOT NULL UNIQUE,
                          description VARCHAR(1024),
                          price       NUMERIC(10,2) NOT NULL,
                          created_at  TIMESTAMP,
                          updated_at  TIMESTAMP
);

CREATE INDEX idx_products_sku ON products(sku);
CREATE INDEX idx_products_name ON products(name);

--rollback DROP TABLE products;

--changeset ai:2 labels:products
INSERT INTO products (name, sku, description, price, created_at, updated_at)
VALUES
    ('Sample Laptop', 'LAPTOP-001', 'High-performance laptop for developers', 1299.99, NOW(), NOW()),
    ('Wireless Mouse', 'MOUSE-001', 'Ergonomic wireless mouse', 29.99, NOW(), NOW()),
    ('Mechanical Keyboard', 'KEYBOARD-001', 'RGB mechanical keyboard', 149.99, NOW(), NOW());

--rollback DELETE FROM products WHERE sku IN ('LAPTOP-001', 'MOUSE-001', 'KEYBOARD-001');
