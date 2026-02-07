INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'ARM Microcontrollers',
'arm-microcontrollers',
'ARM based MCUs',
c.id,
2, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='microcontrollers';


INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'AVR Microcontrollers',
'avr-microcontrollers',
'AVR based MCUs',
c.id,
2, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='microcontrollers';


INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)
SELECT
UUID_TO_BIN(UUID()),
'PIC Microcontrollers',
'pic-microcontrollers',
'PIC based MCUs',
c.id,
2, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='microcontrollers';
