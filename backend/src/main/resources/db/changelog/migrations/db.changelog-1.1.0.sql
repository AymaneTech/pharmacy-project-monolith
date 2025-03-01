CREATE TABLE phar_users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) UNIQUE NOT NULL,
    last_name  VARCHAR(255) UNIQUE NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    role_id    BIGINT              NOT NULL,
    dtype      VARCHAR(31)         NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES phar_roles (id) ON DELETE CASCADE
);

CREATE SEQUENCE phar_users_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 999999999
    NO CYCLE
    CACHE 20;
