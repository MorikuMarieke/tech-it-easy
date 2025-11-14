INSERT INTO remote_controller (id, compatible_with, battery_type, name, brand, price, original_stock)
VALUES
    (1, 'Universal', 'AA', 'RC Basic', 'TechBrand', 19.99, 50),
    (2, 'Television-X', 'AAA', 'RC Premium', 'SuperBrand', 29.99, 80);

INSERT INTO ci_module (id, name, type, price)
VALUES
    (1, 'CI Module Basic', 'Type-A', 49.99),
    (2, 'CI Module Pro', 'Type-B', 79.99),
    (3, 'CI Module Gaming', 'Type-C', 99.99);

INSERT INTO wall_bracket (id, size, adjustable, name, price)
VALUES
    (1, '32-55 inch', TRUE,  'Bracket Slim',   39.99),
    (2, '42-70 inch', FALSE, 'Bracket Fixed',  29.99),
    (3, '55-85 inch', TRUE,  'Bracket Pro XL', 69.99);

INSERT INTO televisions
(name, type, brand, price, available_size, refresh_rate, screen_type, screen_quality,
 smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
VALUES
    ('Bravia XR','55X90J','Sony',899.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,15,5),
    ('Neo QLED','QN90B','Samsung',1199.00,55.0,120,'Mini-LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,20,7),
    ('C2','OLED55C26LA','LG',1099.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,18,6),
    ('The One','55PUS7908/12','Philips',649.00,55.0,60,'LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,25,9),
    ('C845','55C845','TCL',799.00,55.0,144,'Mini-LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,22,4),
    ('LZ1500','TX-55LZ1500','Panasonic',1299.00,55.0,120,'OLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,12,3),
    ('U7KQ','55U7KQ','Hisense',749.00,55.0,120,'ULED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,28,11),
    ('M-Series Q7','M55Q7-J01','Vizio',579.00,55.0,60,'QLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,16,2),
    ('Mi TV P1','L55M6-6AEU','Xiaomi',499.00,55.0,60,'LED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,30,10),
    ('EQ3','55EQ3EA','Sharp',699.00,55.0,120,'QLED','4K HDR',TRUE,TRUE,TRUE,TRUE,TRUE,FALSE,14,5);