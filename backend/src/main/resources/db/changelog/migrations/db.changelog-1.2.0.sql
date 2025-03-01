CREATE TABLE phar_permissions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE phar_role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    CONSTRAINT fk_role_permissions_roles FOREIGN KEY (role_id) REFERENCES phar_roles(id) ON DELETE CASCADE,
    CONSTRAINT fk_role_permissions_permissions FOREIGN KEY (permission_id) REFERENCES phar_permissions(id) ON DELETE CASCADE
);

CREATE SEQUENCE phar_permissions_seq
    START WITH 1
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 999999999
    NO CYCLE
    CACHE 20;
