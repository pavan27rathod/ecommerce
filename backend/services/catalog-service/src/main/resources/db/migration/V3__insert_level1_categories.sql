INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'Microcontrollers',
'microcontrollers',
'Embedded microcontrollers',
c.id,
1, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='semiconductors';


INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'Analog ICs',
'analog-ics',
'Analog integrated circuits',
c.id,
1, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='semiconductors';


INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'Transistors',
'transistors',
'Discrete transistors',
c.id,
1, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='semiconductors';
