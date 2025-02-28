-- Insert roles
INSERT INTO phar_roles (name)
VALUES ('Admin'),
       ('Pharmacist'),
       ('Pharmacy Technician'),
       ('Cashier'),
       ('Inventory Manager');

-- Insert permissions
INSERT INTO phar_permissions (name)
VALUES ('manage_users'),
       ('view_users'),
       ('dispense_medication'),
       ('manage_inventory'),
       ('view_inventory'),
       ('process_sales'),
       ('view_sales'),
       ('manage_prescriptions'),
       ('view_prescriptions'),
       ('manage_reports'),
       ('view_reports');

-- Associate permissions with roles
-- Admin has all permissions
INSERT INTO phar_role_permissions (role_id, permission_id)
SELECT 1, id
FROM phar_permissions;

-- Pharmacist permissions
INSERT INTO phar_role_permissions (role_id, permission_id)
SELECT 2, id
FROM phar_permissions
WHERE name IN ('view_users', 'dispense_medication', 'view_inventory', 'manage_prescriptions',
               'view_prescriptions', 'view_reports');

-- Pharmacy Technician permissions
INSERT INTO phar_role_permissions (role_id, permission_id)
SELECT 3, id
FROM phar_permissions
WHERE name IN ('view_inventory', 'view_prescriptions', 'process_sales', 'view_sales');

-- Cashier permissions
INSERT INTO phar_role_permissions (role_id, permission_id)
SELECT 4, id
FROM phar_permissions
WHERE name IN ('process_sales', 'view_sales');

-- Inventory Manager permissions
INSERT INTO phar_role_permissions (role_id, permission_id)
SELECT 5, id
FROM phar_permissions
WHERE name IN ('manage_inventory', 'view_inventory', 'view_reports');

-- Insert users (with hashed passwords - these are just placeholders,
-- in a real system you would use proper password hashing)
INSERT INTO phar_users (first_name, last_name, email, password, role_id, dtype)
VALUES ('John', 'Smith', 'john.smith@pharmacy.com', '$2a$10$yTST5iA.EMsH1x5geNV5eOUViGn.w6GgFKw.w.3r3wKV7V5JVQlIq', 1,
        'Admin'),
       ('Sarah', 'Johnson', 'sarah.johnson@pharmacy.com',
        '$2a$10$Nm93DtCe3TIzXLBE.Rt.3.2R3r8qzUUEYsDMc9MvK0J77m0s8XCiy', 2, 'Pharmacist'),
       ('Michael', 'Davis', 'michael.davis@pharmacy.com',
        '$2a$10$H8G8Y7K6vXzFwuGt5wl3g.ioNuLIJoMqfA0GKBodRTzRCDR6O5.o2', 2, 'Pharmacist'),
       ('Emily', 'Wilson', 'emily.wilson@pharmacy.com', '$2a$10$9eEeOa5bE46nAKh6D3qSqewMbHUvx7aM3wEQ5/kqMYK6S.iRHuM5K',
        3, 'Pharmacy Technician'),
       ('David', 'Brown', 'david.brown@pharmacy.com', '$2a$10$eSIQ4c5LVVyUZh6EEZiEuOnkzQRvpC8RSlOA6vxZt8dJ.MBCNDA1C', 3,
        'Pharmacy Technician'),
       ('Jessica', 'Moore', 'jessica.moore@pharmacy.com',
        '$2a$10$oQdkPaJrJMm4AX7qLyC.Y.gUTdmO9Uyd6fmN1sR3SozI.jUUEcNPO', 4, 'Cashier'),
       ('Robert', 'Taylor', 'robert.taylor@pharmacy.com',
        '$2a$10$FJl.P8y4lN7ySxpR52tz4eCr0Bz1qBQ3DCjnY9BcYA0pPBqC0iKLu', 4, 'Cashier'),
       ('Jennifer', 'Anderson', 'jennifer.anderson@pharmacy.com',
        '$2a$10$KA6vUbx2o3Io4Mpp8Rt8seBIV.xbDLg6e2e0cQ7PsCJ3H29lMd48m', 5, 'Inventory Manager'),
       ('Christopher', 'Thomas', 'christopher.thomas@pharmacy.com',
        '$2a$10$uC1K98JoxOwVRPH8eTu6Q.zf.SHpZ7AeMVgFw9VLYINcE04ULsFuW', 5, 'Inventory Manager'),
       ('Lisa', 'Martinez', 'lisa.martinez@pharmacy.com',
        '$2a$10$mPQvV/W12P3yCXeKn7RTJeeNJRLnPnDEqeKm0txRiiUmA/6CL6Ykm', 2, 'Pharmacist');

UPDATE phar_users
SET dtype = 'Employee';
