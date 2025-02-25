CREATE TABLE phar_employees
(
    id               BIGSERIAL PRIMARY KEY,
    hiring_date      DATE         NOT NULL,
    resignation_date DATE,
    position         VARCHAR(255) NOT NULL,
    salary           DECIMAL      NOT NULL,
    pharmacy_id      BIGINT       NOT NULL,
    CONSTRAINT fk_employees_pharmacy FOREIGN KEY (pharmacy_id) REFERENCES phar_pharmacies (id) ON DELETE CASCADE,
    CONSTRAINT fk_employees_user FOREIGN KEY (id) REFERENCES phar_users (id) ON DELETE CASCADE
);