CREATE TABLE product_price_break (

    id BINARY(16) PRIMARY KEY,

    product_id BINARY(16) NOT NULL,

    min_quantity INT NOT NULL,

    price DECIMAL(12,2) NOT NULL,

    CONSTRAINT fk_price_break_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
        ON DELETE CASCADE
);
