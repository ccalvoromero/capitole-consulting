CREATE TABLE IF NOT EXISTS PRICES(
    ID INT AUTO_INCREMENT NOT NULL,
    BRAND_ID INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DOUBLE NOT NULL,
    PRICE_LIST INT NULL,
    START_DATE DATETIME NULL,
    END_DATE DATETIME NOT NULL,
    CURRENCY VARCHAR (3) NOT NULL,
    PRIMARY KEY (ID)
);