-- Add index on name if not exists
SET @index_exists = (
    SELECT COUNT(1)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'product'
      AND index_name = 'idx_product_name'
);

SET @sql = IF(@index_exists = 0,
    'CREATE INDEX idx_product_name ON product(name)',
    'SELECT "idx_product_name already exists"');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;


-- manufacturer index
SET @index_exists = (
    SELECT COUNT(1)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'product'
      AND index_name = 'idx_product_manufacturer'
);

SET @sql = IF(@index_exists = 0,
    'CREATE INDEX idx_product_manufacturer ON product(manufacturer)',
    'SELECT "idx_product_manufacturer already exists"');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;


-- mpn index
SET @index_exists = (
    SELECT COUNT(1)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'product'
      AND index_name = 'idx_product_mpn'
);

SET @sql = IF(@index_exists = 0,
    'CREATE INDEX idx_product_mpn ON product(manufacturer_part_number)',
    'SELECT "idx_product_mpn already exists"');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;


-- slug index
SET @index_exists = (
    SELECT COUNT(1)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'product'
      AND index_name = 'idx_product_slug'
);

SET @sql = IF(@index_exists = 0,
    'CREATE INDEX idx_product_slug ON product(slug)',
    'SELECT "idx_product_slug already exists"');

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
