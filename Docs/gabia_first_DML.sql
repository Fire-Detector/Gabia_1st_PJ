use gabia_first;
show tables;

INSERT INTO user (user_id, user_password, user_phone, user_gender) VALUES
('kys', '1234', '010-1234-5678', 'M'),
('kdh', '1234', '010-1234-5678', 'M'),
('kjy', '1234', '010-1234-5678', 'M'),
('nsj', '1234', '010-1234-5678', 'M'),
('ljj', '1234', '010-1234-5678', 'M'),
('hjy', '1234', '010-1234-5678', 'F');

insert into category values (1, 'CPU');
insert into category values (2, 'GPU');
insert into category values (3, 'RAM');
insert into category values (4, 'Disk');
insert into category values (5, 'MainBoard');
insert into category values (6, 'Power');

-- CPU (category_id = 1)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('Intel Core i9-14900K', 'Intel', '24 cores, 32 threads, 6.0GHz', '2023-10-01', 900000, 1),
('Intel Core i7-14700K', 'Intel', '20 cores, 28 threads, 5.6GHz', '2023-10-01', 650000, 1),
('AMD Ryzen 9 7950X', 'AMD', '16 cores, 32 threads, 5.7GHz', '2022-09-01', 850000, 1),
('AMD Ryzen 7 7800X3D', 'AMD', '8 cores, 16 threads, 5.0GHz', '2023-04-01', 600000, 1),
('Intel Core i5-14600K', 'Intel', '14 cores, 20 threads, 5.3GHz', '2023-10-01', 450000, 1),
('AMD Ryzen 5 7600X', 'AMD', '6 cores, 12 threads, 5.3GHz', '2022-09-01', 350000, 1);

-- GPU (category_id = 2)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('NVIDIA GeForce RTX 5090', 'NVIDIA', '24GB GDDR7', '2025-04-01', 2700000, 2),
('NVIDIA GeForce RTX 4090', 'NVIDIA', '24GB GDDR6X', '2022-10-01', 2200000, 2),
('NVIDIA GeForce RTX 5080', 'NVIDIA', '16GB GDDR7', '2025-03-01', 1400000, 2),
('AMD Radeon RX 9070 XT', 'AMD', '16GB GDDR6', '2024-12-01', 900000, 2),
('NVIDIA GeForce RTX 4070', 'NVIDIA', '12GB GDDR6X', '2023-04-01', 800000, 2),
('Intel Arc A770', 'Intel', '16GB GDDR6', '2023-01-01', 500000, 2);

-- RAM (category_id = 3)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('Corsair Vengeance DDR5-6000 32GB', 'Corsair', 'DDR5-6000, CL36', '2023-05-01', 200000, 3),
('G.SKILL Trident Z5 DDR5-6400 32GB', 'G.SKILL', 'DDR5-6400, CL32', '2024-03-01', 250000, 3),
('Samsung DDR5-5600 32GB', 'Samsung', 'DDR5-5600, CL40', '2023-10-01', 180000, 3),
('Kingston Fury Beast DDR5-6000 32GB', 'Kingston', 'DDR5-6000, CL36', '2023-08-01', 210000, 3),
('TeamGroup T-Force Delta RGB DDR5-6000 32GB', 'TeamGroup', 'DDR5-6000, CL38', '2023-12-01', 220000, 3),
('Micron Crucial DDR5-5600 32GB', 'Micron', 'DDR5-5600, CL46', '2023-11-01', 170000, 3);

-- Disk (category_id = 4)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('Samsung 990 PRO 2TB', 'Samsung', 'PCIe 4.0, 7,450MB/s', '2023-01-01', 200000, 4),
('WD Black SN850X 2TB', 'Western Digital', 'PCIe 4.0, 7,300MB/s', '2023-04-01', 190000, 4),
('SK hynix Platinum P41 2TB', 'SK hynix', 'PCIe 4.0, 7,000MB/s', '2023-06-01', 180000, 4),
('Crucial T700 2TB', 'Micron', 'PCIe 5.0, 12,400MB/s', '2024-01-01', 350000, 4),
('Kingston KC3000 2TB', 'Kingston', 'PCIe 4.0, 7,000MB/s', '2023-08-01', 170000, 4),
('Seagate FireCuda 530 2TB', 'Seagate', 'PCIe 4.0, 7,300MB/s', '2023-03-01', 190000, 4);

-- Mainboard (category_id = 5)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('ASUS ROG Maximus Z790 Hero', 'ASUS', 'Intel Z790, DDR5, WiFi 6E', '2023-01-01', 800000, 5),
('MSI MEG X670E ACE', 'MSI', 'AMD X670E, DDR5, WiFi 6E', '2023-02-01', 900000, 5),
('GIGABYTE Z790 AORUS MASTER', 'GIGABYTE', 'Intel Z790, DDR5, WiFi 6E', '2023-03-01', 750000, 5),
('ASRock B650E Steel Legend', 'ASRock', 'AMD B650E, DDR5, WiFi 6E', '2023-04-01', 400000, 5),
('ASUS TUF Gaming B760-PLUS', 'ASUS', 'Intel B760, DDR5, WiFi 6', '2023-05-01', 300000, 5),
('Intel DH55TC', 'Intel', 'Intel H55, DDR3, uATX', '2020-01-01', 100000, 5);

-- Power (category_id = 6)
INSERT INTO product (product_name, manufacturer, spec, release_date, price, category_id) VALUES
('Corsair RM1000x SHIFT ATX 3.0', 'Corsair', '1000W, 80PLUS Gold', '2024-01-01', 250000, 6),
('Seasonic PRIME TX-1000', 'Seasonic', '1000W, 80PLUS Titanium', '2023-10-01', 400000, 6),
('SuperFlower Leadex Platinum 1000W', 'SuperFlower', '1000W, 80PLUS Platinum', '2024-03-01', 350000, 6),
('FSP HYDRO PTM PRO 850W', 'FSP', '850W, 80PLUS Platinum', '2023-11-01', 230000, 6),
('ASUS ROG THOR 1200W Platinum II', 'ASUS', '1200W, 80PLUS Platinum', '2024-02-01', 500000, 6),
('Micronics Classic II 700W', 'Micronics', '700W, 80PLUS Bronze', '2023-05-01', 90000, 6);

insert into cart (create_date, user_id) values(CURDATE(), 'kys');
insert into cart_has_product values (1,55);

desc product;

select * from product;
select * from cart;
select * from cart_has_product;

SELECT 
    p.product_id,
    p.product_name,
    p.manufacturer,
    p.spec,
    p.release_date,
    p.price,
    p.category_id
FROM 
    cart c
JOIN 
    cart_has_product chp ON c.cart_id = chp.cart_id
JOIN 
    product p ON chp.product_id = p.product_id
WHERE 
    c.user_id = ?;  -- 여기서 ?는 사용자의 user_id 값
