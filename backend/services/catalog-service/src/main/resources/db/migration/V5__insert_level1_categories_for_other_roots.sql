INSERT INTO category (
    id, name, slug, description,
    parent_id, level,
    product_count, is_active, display_order,
    created_at, updated_at
)

SELECT UUID_TO_BIN(UUID()), 'Resistors', 'resistors',
'Electronic resistors',
c.id, 1, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='passive-components'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Capacitors', 'capacitors',
'Electronic capacitors',
c.id, 1, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='passive-components'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Inductors', 'inductors',
'Electronic inductors',
c.id, 1, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='passive-components'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'USB Connectors', 'usb-connectors',
'USB connectors',
c.id, 1, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='connectors'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'RF Connectors', 'rf-connectors',
'RF connectors',
c.id, 1, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='connectors'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Board-to-Board Connectors', 'board-connectors',
'Board connectors',
c.id, 1, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='connectors'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Power Supplies', 'power-supplies',
'Power supply units',
c.id, 1, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='power'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Batteries', 'batteries',
'Electronic batteries',
c.id, 1, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='power'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Voltage Regulators', 'voltage-regulators',
'Voltage regulators',
c.id, 1, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='power'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Arduino Boards', 'arduino-boards',
'Arduino development boards',
c.id, 1, 0, TRUE, 1, NOW(), NOW()
FROM category c WHERE c.slug='development-boards'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'Raspberry Pi', 'raspberry-pi',
'Raspberry Pi boards',
c.id, 1, 0, TRUE, 2, NOW(), NOW()
FROM category c WHERE c.slug='development-boards'

UNION ALL

SELECT UUID_TO_BIN(UUID()), 'ESP32 Boards', 'esp32-boards',
'ESP32 development boards',
c.id, 1, 0, TRUE, 3, NOW(), NOW()
FROM category c WHERE c.slug='development-boards';
