INSERT INTO "public"."admin_centre" ("created_at", "email", "nom", "password", "prenom", "telephone", "updated_at", "username", "centre_id", "ville_id")
VALUES
-- Realistic-looking data example
(NOW(), 'admin.johnson@example.com', 'Johnson', 'hashedpassword1', 'John', '555-1234', NOW(), 'johnson_admin', 1, 3),
(NOW(), 'admin.smith@example.com', 'Smith', 'hashedpassword2', 'Jane', '555-5678', NOW(), 'smith_admin', 2, 5),
(NOW(), 'admin.doe@example.com', 'Doe', 'hashedpassword3', 'Richard', '555-9101', NOW(), 'doe_admin', 3, 2),
(NOW(), 'admin.white@example.com', 'White', 'hashedpassword4', 'Emily', '555-1122', NOW(), 'white_admin', 4, 4),
(NOW(), 'admin.brown@example.com', 'Brown', 'hashedpassword5', 'Michael', '555-3344', NOW(), 'brown_admin', 5, 1),
(NOW(), 'admin.miller@example.com', 'Miller', 'hashedpassword6', 'Olivia', '555-5566', NOW(), 'miller_admin', 6, 3),
(NOW(), 'admin.wilson@example.com', 'Wilson', 'hashedpassword7', 'Sophia', '555-7788', NOW(), 'wilson_admin', 7, 2),
(NOW(), 'admin.anderson@example.com', 'Anderson', 'hashedpassword8', 'Adam', '555-9900', NOW(), 'anderson_admin', 8, 4),
(NOW(), 'admin.taylor@example.com', 'Taylor', 'hashedpassword9', 'Emma', '555-2233', NOW(), 'taylor_admin', 9, 5),
(NOW(), 'admin.thomas@example.com', 'Thomas', 'hashedpassword10', 'James', '555-4455', NOW(), 'thomas_admin', 10, 1);
