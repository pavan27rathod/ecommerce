CREATE TABLE category (

    id BINARY(16) PRIMARY KEY,

    name VARCHAR(150) NOT NULL,

    slug VARCHAR(150) NOT NULL UNIQUE,

    description VARCHAR(1000),

    parent_id BINARY(16),

    level INT NOT NULL,

    product_count INT NOT NULL DEFAULT 0,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    display_order INT NOT NULL DEFAULT 0,

    icon_url VARCHAR(500),

    seo_title VARCHAR(255),

    seo_description VARCHAR(1000),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_category_parent
        FOREIGN KEY (parent_id)
        REFERENCES category(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_category_parent ON category(parent_id);
CREATE INDEX idx_category_slug ON category(slug);
CREATE INDEX idx_category_active ON category(is_active);
CREATE INDEX idx_category_level ON category(level);
