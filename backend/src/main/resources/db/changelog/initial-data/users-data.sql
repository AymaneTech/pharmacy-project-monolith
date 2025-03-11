-- Insert roles
INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_ORGANIZER');

-- Insert permissions
INSERT INTO permissions (name)
VALUES ('MANAGE_USERS'),
       ('VIEW_USERS'),
       ('DISPENSE_MEDICATION'),
       ('MANAGE_INVENTORY'),
       ('VIEW_INVENTORY'),
       ('PROCESS_SALES'),
       ('VIEW_SALES'),
       ('MANAGE_PRESCRIPTIONS'),
       ('VIEW_PRESCRIPTIONS'),
       ('MANAGE_REPORTS'),
       ('VIEW_REPORTS');

-- Associate permissions with roles
-- Admin has all permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT 1, id
FROM permissions;

-- Pharmacist permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT 2, id
FROM permissions
WHERE name IN ('VIEW_USERS', 'DISPENSE_MEDICATION', 'VIEW_INVENTORY', 'MANAGE_PRESCRIPTIONS',
               'VIEW_PRESCRIPTIONS', 'VIEW_REPORTS');

-- in a real system you would use proper password hashing)
-- INSERT INTO users (first_name, last_name, email, password, role_id, dtype)
-- VALUES ('John', 'Smith', 'john.smith@pharmacy.com', '$2a$10$yTST5iA.EMsH1x5geNV5eOUViGn.w6GgFKw.w.3r3wKV7V5JVQlIq', 1,
--         'Admin'),
--        ('Sarah', 'Johnson', 'sarah.johnson@pharmacy.com',
--         '$2a$10$Nm93DtCe3TIzXLBE.Rt.3.2R3r8qzUUEYsDMc9MvK0J77m0s8XCiy', 2, 'Pharmacist'),
--        ('Michael', 'Davis', 'michael.davis@pharmacy.com',
--         '$2a$10$H8G8Y7K6vXzFwuGt5wl3g.ioNuLIJoMqfA0GKBodRTzRCDR6O5.o2', 2, 'Pharmacist'),
--        ('Emily', 'Wilson', 'emily.wilson@pharmacy.com', '$2a$10$9eEeOa5bE46nAKh6D3qSqewMbHUvx7aM3wEQ5/kqMYK6S.iRHuM5K',
--         3, 'Pharmacy Technician'),
--        ('David', 'Brown', 'david.brown@pharmacy.com', '$2a$10$eSIQ4c5LVVyUZh6EEZiEuOnkzQRvpC8RSlOA6vxZt8dJ.MBCNDA1C', 3,
--         'Pharmacy Technician'),
--        ('Jessica', 'Moore', 'jessica.moore@pharmacy.com',
--         '$2a$10$oQdkPaJrJMm4AX7qLyC.Y.gUTdmO9Uyd6fmN1sR3SozI.jUUEcNPO', 4, 'Cashier'),
--        ('Robert', 'Taylor', 'robert.taylor@pharmacy.com',
--         '$2a$10$FJl.P8y4lN7ySxpR52tz4eCr0Bz1qBQ3DCjnY9BcYA0pPBqC0iKLu', 4, 'Cashier'),
--        ('Jennifer', 'Anderson', 'jennifer.anderson@pharmacy.com',
--         '$2a$10$KA6vUbx2o3Io4Mpp8Rt8seBIV.xbDLg6e2e0cQ7PsCJ3H29lMd48m', 5, 'Inventory Manager'),
--        ('Christopher', 'Thomas', 'christopher.thomas@pharmacy.com',
--         '$2a$10$uC1K98JoxOwVRPH8eTu6Q.zf.SHpZ7AeMVgFw9VLYINcE04ULsFuW', 5, 'Inventory Manager'),
--        ('Lisa', 'Martinez', 'lisa.martinez@pharmacy.com',
--         '$2a$10$mPQvV/W12P3yCXeKn7RTJeeNJRLnPnDEqeKm0txRiiUmA/6CL6Ykm', 2, 'Pharmacist');
