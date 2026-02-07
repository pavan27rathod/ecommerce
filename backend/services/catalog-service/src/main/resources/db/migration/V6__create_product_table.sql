CREATE TABLE IF NOT EXISTS product (
    id BINARY(16) PRIMARY KEY,

    name VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(2000),

    category_id BINARY(16) NOT NULL,

    manufacturer VARCHAR(255),
    manufacturer_part_number VARCHAR(255),
    order_code VARCHAR(255),

    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,

    image_url VARCHAR(500),

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
        REFERENCES category(id)
);
