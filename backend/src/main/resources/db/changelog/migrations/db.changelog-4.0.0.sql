CREATE TYPE dosage_unit AS ENUM ('KG', 'L');
CREATE TYPE packaging_type AS ENUM ('JAR', 'WAR', 'POM');

CREATE TABLE phar_reference_medicines
(
    id                 BIGSERIAL PRIMARY KEY,
    code               VARCHAR(255)   NOT NULL,
    commercial_name    VARCHAR(255)   NOT NULL,
    generic_name       VARCHAR(255)   NOT NULL,
    dosage             VARCHAR(255)   NOT NULL,
    dosage_unit        dosage_unit    NOT NULL,
    form               VARCHAR(255)   NOT NULL,
    packaging          packaging_type NOT NULL,
    public_price       DECIMAL        NOT NULL,
    hospital_price     DECIMAL        NOT NULL,
    base_price         DECIMAL        NOT NULL,
    category           VARCHAR(255)   NOT NULL,
    reimbursement_rate VARCHAR(255)   NOT NULL
)