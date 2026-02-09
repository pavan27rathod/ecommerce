CREATE INDEX idx_product_name ON product(name);

CREATE INDEX idx_product_manufacturer ON product(manufacturer);

CREATE INDEX idx_product_mpn ON product(manufacturer_part_number);

CREATE INDEX idx_product_slug ON product(slug);
