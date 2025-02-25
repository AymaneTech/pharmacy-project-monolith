CREATE TABLE phar_pharmacies
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    city          VARCHAR(255) NOT NULL,
    country       VARCHAR(255) NOT NULL,
    zip           VARCHAR(50),
    extra_address TEXT
);
