
-- Insercao de ROLES
INSERT INTO roles (id, authority)
VALUES ('b82bc6cc-a78b-40ae-86cb-9f3533c6609c', 'ROLE_ADMIN');

-- Inserção USERS
INSERT INTO users (id, created_date, updated_date, first_name, last_name, birth_date, phone, email, password)
VALUES (
    'dfe2672e-dc25-4c4f-b34d-3583dd4ef52f',
    '2024-08-24 12:00:00',
    '2024-08-24 12:00:00',
    'Bruno',
    'Dias',
    '1995-01-26',
    '14991781010',
    'bruno@admin.com',
    '$2a$10$wT7zWv5A1X3IzGcD27L82uR5YmCBN51LTsW8G5.HaODZmYaHTl8Xy',
);
INSERT INTO user_role (user_id, role_is) VALUES ('dfe2672e-dc25-4c4f-b34d-3583dd4ef52f', 'b82bc6cc-a78b-40ae-86cb-9f3533c6609c')


-- Inserção CATEGORIES
INSERT INTO categories (id, created_date, updated_date, name)
VALUES
	('123e4567-e89b-12d3-a456-426614174000', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'Computadores'),
	('855a6047-6257-4d7f-ad96-c166890942ad', '2024-08-20 12:00:00', '2024-08-20 12:00:00', 'Celulares'),
  ('1d78e9e4-bd41-4f16-8d63-7d6a5cfb6baf', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'Fones'),
  ('2a57f10b-4906-4c77-8e39-5d5b96e2d8d1', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'Teclados'),
  ('4c56c84e-2b95-4f62-84f6-0b86a0b65f1c', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'Mouses'),
  ('7f8e79cf-75d8-4a5d-bd48-9b154d6c0b9b', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'Monitores'),
  ('9d2d5e4b-d6b4-4cf6-8f39-8f9ae5d6f4e3', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'iPhones');




-- Insercao de Products
INSERT INTO products (id, created_date, updated_date, name, price, description, img_url)
VALUES
('e1140a65-1d2a-471d-ad10-b4e50be58abd', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'iphone 15 pro max', 8299.0, 'O iPhone 15 Pro Max deverá ter uma tela OLED Super Retina XDR de 6,7 polegadas com taxa de atualização de 120 Hz. Provavelmente contará com um design refinado em titânio, sistema de câmeras avançado com melhor zoom óptico, e será alimentado pelo chip A17 Bionic. É esperado que traga maior duração de bateria, conectividade USB-C, suporte a 5G, Wi-Fi 6E e rodará o iOS 17 com novos recursos de personalização e segurança.', 'https://m.media-amazon.com/images/I/81YSmKnlijL._AC_SL1500_.jpg'),
('e2150b76-2e3b-482e-bf21-c5f60cf69cde', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'iPhone 15 Pro', 7499.0, 'O iPhone 15 Pro traz uma tela OLED Super Retina XDR de 6,1 polegadas com taxa de atualização de 120 Hz. Com design em titânio, câmeras avançadas e o poderoso chip A17 Bionic, o dispositivo entrega desempenho premium e conectividade USB-C, 5G e Wi-Fi 6E. Vem equipado com o iOS 17 e recursos otimizados para segurança e privacidade.', 'https://m.media-amazon.com/images/I/71uuDYxn3XL._AC_SL1500_.jpg'),
('e3161c87-3f4c-493f-ad32-d6f70df7addf', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'iPhone 15 Plus', 6799.0, 'O iPhone 15 Plus possui uma tela OLED de 6,7 polegadas e o novo chip A16 Bionic, oferecendo desempenho rápido e eficiente. Com design elegante em vidro e alumínio, câmeras aprimoradas e conectividade 5G e USB-C, ele é ideal para quem busca uma experiência premium em um dispositivo maior.', 'https://m.media-amazon.com/images/I/71GLMJ7TQiL._AC_SL1500_.jpg'),
('f5273ea9-3e4b-471f-bd21-a8f50cd7beaa', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'iPhone 15', 6199.0, 'O iPhone 15 possui uma tela OLED de 6,1 polegadas e o eficiente chip A16 Bionic. Com um design moderno em vidro e alumínio, câmeras aprimoradas para fotos e vídeos incríveis, além de suporte a 5G e USB-C, este modelo é ideal para quem busca desempenho em um formato compacto.', 'https://m.media-amazon.com/images/I/71xb2xkN5qL._AC_SL1500_.jpg');

INSERT INTO products (id, created_date, updated_date, name, price, description, img_url)
VALUES
('a0eeb5a8-8f7d-4bfa-9b56-2b3e8c1b4a0e', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'MacBook Air M3', 9999.0, 'O MacBook Air com chip M3 traz desempenho poderoso em um design fino e leve. Conta com uma tela Retina de 13,3 polegadas, bateria com duração de até 18 horas, e conectividade avançada, como USB-C e Wi-Fi 6. Ideal para produtividade e tarefas diárias com eficiência energética aprimorada.', 'https://m.media-amazon.com/images/I/61QRQH5WkL._AC_SL1500_.jpg'),
('b6e6f0d9-3e7c-4bda-a1e4-d2c342a8f57c', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'MacBook Pro 14 M3', 14999.0, 'O MacBook Pro de 14 polegadas com chip M3 oferece performance de alto nível para profissionais exigentes. Equipado com tela Retina XDR, bateria de longa duração, e conectividade avançada, incluindo Thunderbolt 4 e Wi-Fi 6E. Ideal para edição de vídeo, design gráfico e desenvolvimento.', 'https://m.media-amazon.com/images/I/71L2iBSyyOL._AC_SL1500_.jpg'),
('c4f19b20-0b5c-4c6b-b83e-fbe4ef7681d3', '2024-08-24 12:00:00', '2024-08-24 12:00:00', 'MacBook Pro 16 M3', 19999.0, 'O MacBook Pro de 16 polegadas com chip M3 oferece o melhor desempenho da linha, com gráficos de última geração, tela Retina XDR, e bateria de longa duração. Perfeito para profissionais que precisam de potência máxima para renderização, simulações 3D, e grandes projetos criativos.', 'https://m.media-amazon.com/images/I/81b6fWQDIfL._AC_SL1500_.jpg');


-- Insert ORDERS
INSERT INTO orders (id, created_date, updated_date, moment, status, client_id)
VALUES (
  'b6b64a8f-40bc-4d94-ad24-f1d34b941811',
  '2024-08-24 12:00:00',
  '2024-08-24 12:00:00',
  '2024-08-24 12:00:00',
 	0,
  'dfe2672e-dc25-4c4f-b34d-3583dd4ef52f'
);

--INSERT ORDER_ITEMS
INSERT INTO order_item (order_id, product_id, quantity, price)
VALUES ('b6b64a8f-40bc-4d94-ad24-f1d34b941811', 'e1140a65-1d2a-471d-ad10-b4e50be58abd', 1, 8299.0);

-- Consulta para verificar dados inseridos
SELECT * FROM categories;
SELECT * FROM users;
SELECT * FROM products;
SELECT * FROM orders;
SELECT * FROM order_item;










INSERT INTO tb_category(name) VALUES ('Livros');
INSERT INTO tb_category(name) VALUES ('Eletrônicos');
INSERT INTO tb_category(name) VALUES ('Computadores');

INSERT INTO tb_product (name, price, description, img_url) VALUES ('The Lord of the Rings', 90.5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('Smart TV', 2190.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('Macbook Pro', 1250.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer', 1200.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('Rails for Dummies', 100.99, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Ex', 1350.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer X', 1350.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/7-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Alfa', 1850.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/8-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Tera', 1950.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/9-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Y', 1700.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/10-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Nitro', 1450.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/11-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Card', 1850.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/12-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Plus', 1350.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/13-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Hera', 2250.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/14-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Weed', 2200.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/15-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Max', 2340.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/16-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Turbo', 1280.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/17-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Hot', 1450.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/18-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Ez', 1750.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/19-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Tr', 1650.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/20-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Tx', 1680.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/21-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Er', 1850.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/22-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Min', 2250.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/23-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Boo', 2350.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/24-big.jpg');
INSERT INTO tb_product (name, price, description, img_url) VALUES ('PC Gamer Foo', 4170.0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/25-big.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (16, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (17, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (18, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (19, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (20, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (21, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (22, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (23, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (24, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (25, 3);

INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '2001-07-25');
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '1987-12-13');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_order (moment, status, client_id) VALUES ('2022-07-25T13:00:00', 1, 1);
INSERT INTO tb_order (moment, status, client_id) VALUES ('2022-07-29T15:50:00', 3, 2);
INSERT INTO tb_order (moment, status, client_id) VALUES ('2022-08-03T14:20:00', 0, 1);

INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 1, 2, 90.5);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 3, 1, 1250.0);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (2, 3, 1, 1250.0);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (3, 1, 1, 90.5);

INSERT INTO tb_payment (order_id, moment) VALUES (1, '2022-07-25T15:00:00');
INSERT INTO tb_payment (order_id, moment) VALUES (2, '2022-07-30T11:00:00');
