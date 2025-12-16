-- *** 1. Remote Controllers ***
INSERT INTO "remote-controllers" (compatible_with, battery_type, name, brand, price, original_stock)
VALUES
    ('Universal', 'AA', 'RC Basic', 'TechBrand', 19.99, 50),
    ('Television-X', 'AAA', 'RC Premium', 'SuperBrand', 29.99, 80);

-- *** 3. Wall Brackets (wall-brackets) ***
INSERT INTO "wall-brackets" (size, adjustable, name, price)
VALUES
    ('32-55 inch', TRUE,  'Bracket Slim',   39.99),
    ('42-70 inch', FALSE, 'Bracket Fixed',  29.99),
    ('55-85 inch', TRUE,  'Bracket Pro XL', 69.99);

-- *** 4. Televisions (Relaties One-to-One en Many-to-One) ***
INSERT INTO televisions
(name, type, brand, price, available_size, refresh_rate, screen_type, screen_quality,
 smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold,
 remote_controller_id)
VALUES
    ('Bravia XR','55X90J','Sony',899.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,15,5, NULL),
    ('Neo QLED','QN90B','Samsung',1199.00,55.0,120,'Mini-LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,20,7, 1),
    ('C2','OLED55C26LA','LG',1099.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,18,6, NULL),
    ('The One','55PUS7908/12','Philips',649.00,55.0,60,'LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,25,9, 2),
    ('C845','55C845','TCL',799.00,55.0,144,'Mini-LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,22,4, NULL),
    ('LZ1500','TX-55LZ1500','Panasonic',1299.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,12,3, NULL),
    ('U7KQ','55U7KQ','Hisense',749.00,55.0,120,'ULED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,28,11, NULL),
    ('M-Series Q7','M55Q7-J01','Vizio',579.00,55.0,60,'QLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,16,2, NULL),
    ('Mi TV P1','L55M6-6AEU','Xiaomi',499.00,55.0,60,'LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,30,10, NULL),
    ('EQ3','55EQ3EA','Sharp',699.00,55.0,120,'QLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,14,5, NULL);

-- select * from televisions as tv join ci-modules as cim on cim.television_id=tv.id

-- *** 2. CI Modules (ci-modules) ***
INSERT INTO "ci-modules" (brand, name, type, price, television_id)
VALUES
    ('Alpha', 'CI Module Basic', 'Type-A', 49.99, 1),
    ('Beta', 'CI Module Pro', 'Type-B', 79.99, 2),
    ('Gamma', 'CI Module Gaming', 'Type-C', 99.99, 3),
    ('Delta', 'CI Module Luxe', 'Type-D', 99.99, 1);


-- *** 5. Wall Brackets Koppeltabel (Many-to-Many) ***

-- Hier koppelen we de TV ID's aan de Wall Bracket ID's.
-- Dit is de data die de relatie vult die je hebt gedefinieerd met @ManyToMany en @JoinTable.
INSERT INTO televisions_wall_brackets (television_id, wall_bracket_id)
VALUES
    (1, 1), -- TV 1 gebruikt Bracket 1
    (2, 2), -- TV 2 gebruikt Bracket 2
    (3, 1), -- TV 3 gebruikt Bracket 1
    (3, 3), -- TV 3 gebruikt ook Bracket 3
    (4, 3), -- TV 4 gebruikt Bracket 3
    (5, 1), -- TV 5 gebruikt Bracket 1
    (5, 2), -- TV 5 gebruikt ook Bracket 2
    (6, 2), -- TV 6 gebruikt Bracket 2
    (7, 1), -- TV 7 gebruikt Bracket 1
    (10, 1),-- TV 10 gebruikt Bracket 1
    (10, 2),-- TV 10 gebruikt Bracket 2
    (10, 3);-- TV 10 gebruikt Bracket 3

-- USERS
INSERT INTO users (username, password, email, enabled)
VALUES
    ('mali', '$2a$10$Dow1uN6pN0Z3Ud8UfJmReecFQ4rpKu0qvHj8pYJr6VSa3aP/qjG2G', 'mali@example.com', true),
    ('admin', '$2a$10$z6lyakT9VQ0f2daxbHSG1uU0Q3xS8H5j8JM0ip0z6R5z2w0y2JjVa', 'admin@example.com', true);

-- AUTHORITIES
INSERT INTO authorities (user_id, authority)
VALUES
    ((SELECT id FROM users WHERE username = 'mali'), 'ROLE_USER'),
    ((SELECT id FROM users WHERE username = 'admin'), 'ROLE_ADMIN'),
    ((SELECT id FROM users WHERE username = 'admin'), 'ROLE_USER');