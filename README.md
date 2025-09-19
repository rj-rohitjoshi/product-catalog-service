# Product Catalog Service

Standalone Spring Boot microservice for managing products in the e-commerce platform.

## Build and Run

## Liquibase Migration

- Migrations are auto-applied from `src/main/resources/db/changelog`.
- Edit master and add new migration files for schema changes.

## API

- `POST /products` - create product
- `GET /products` - list all products
- `GET /products/sku/{sku}` - get product by SKU
