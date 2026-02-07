INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
VALUES

(UUID_TO_BIN(UUID()), 'Semiconductors', 'semiconductors',
 'Semiconductor components',
 NULL, 0, 0, TRUE, 1, NOW(), NOW()),

(UUID_TO_BIN(UUID()), 'Passive Components', 'passive-components',
 'Resistors, capacitors, inductors',
 NULL, 0, 0, TRUE, 2, NOW(), NOW()),

(UUID_TO_BIN(UUID()), 'Connectors', 'connectors',
 'All types of connectors',
 NULL, 0, 0, TRUE, 3, NOW(), NOW()),

(UUID_TO_BIN(UUID()), 'Power', 'power',
 'Power management products',
 NULL, 0, 0, TRUE, 4, NOW(), NOW()),

(UUID_TO_BIN(UUID()), 'Development Boards', 'development-boards',
 'Embedded and dev boards',
 NULL, 0, 0, TRUE, 5, NOW(), NOW());
