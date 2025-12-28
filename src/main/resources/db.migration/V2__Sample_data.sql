-- 1. Insert users
INSERT INTO users (username, email, password_hash, role) VALUES
('admin', 'admin@delivery.com', '123456', 'admin'),
('courier1', 'courier1@gmail.com', '123456', 'courier'),
('courier2', 'courier2@yandex.ru', '222222', 'courier'),
('customer1', 'customer1@mail.ru', '333333', 'customer'),
('customer2', 'customer2@gmail.com', '444444', 'customer'),
('owner1', 'owner1@restaurant.ru', '555555', 'owner'),
('owner2', 'owner2@restaurant.ru', '666666', 'owner');

-- 2. Insert customers (user_id 4,5)
INSERT INTO customers (user_id, phone, address, full_name) VALUES
(4, '+77773456123', 'Алматы, пр. АльФараби, 34', 'Усатая Ольга'),
(5, '+77789876543', 'Алматы, пр. АльФараби, 36', 'Мырзаханов Еркебулан');

-- 3. Insert couriers (user_id 2,3)
INSERT INTO couriers (user_id, phone, vehicle_type, status) VALUES
(2, '+77019999999', 'car', 'available'),
(3, '+77478888888', 'bike', 'available');

-- 4. Insert restaurant owners (user_id 6,7)
INSERT INTO restaurant_owners (user_id, phone) VALUES
(6, '+77001111111'),
(7, '+77772222222');

-- 5. Insert restaurants
INSERT INTO restaurants (name, owner_id, address, phone, rating) VALUES
('Пицца ЛаВиста', 1, 'Алматы, ул. Гоголя, 72', '+77717686950', 4.5),
('Ginger', 2, 'Алматы, пр. Абая, 170', '+77471324354', 4.2);

-- 6. Insert dishes
INSERT INTO dishes (restaurant_id, name, description, price, category, is_available) VALUES
(1, 'Маргарита', 'Классическая пицца с томатами, моцареллой и базиликом', 2000.00, 'pizza', true),
(1, 'Пепперони', 'Пицца с острой салями и сыром', 3000.00, 'pizza', true),
(1, 'Чизбургер', 'Говядина, сыр чеддер, овощи', 1500.00, 'burger', true),
(2, 'Филадельфия ролл', 'Лосось, сливочный сыр, авокадо', 1890.00, 'sushi', true),
(2, 'Калифорния ролл', 'Крабовые палочки, авокадо, огурец', 2300.00, 'sushi', true);

-- 7. Insert orders
INSERT INTO orders (customer_id, restaurant_id, courier_id, order_status, total_amount, delivery_address) VALUES
(1, 1, 1, 'delivered', 5600.00, 'Алматы, пр. Достык, 70, кв. 5'),
(2, 2, 2, 'ready', 2700.00, 'Алматы, пр. АльФараби 40, кв. 12'),
(1, 1, NULL, 'pending', 11000.00, 'Алматы, ул. Гагарина 35, кв. 5');

-- 8. Insert order_dishes
INSERT INTO order_dishes (order_id, dish_id, quantity, price_at_order) VALUES
(1, 1, 1, 2000.00),  -- Маргарита
(1, 2, 1, 3000.00),  -- Пепперони
(2, 4, 1, 1890.00),  -- Филадельфия
(2, 5, 1, 2300.00),  -- Калифорния
(3, 1, 1, 2000.00);  -- Маргарита

-- 9. Insert reviews
INSERT INTO reviews (order_id, rating, comment) VALUES
(1, 5, 'Отличная пицца! Быстрая доставка.'),
(2, 4, 'Суши вкусные, но порции маленькие.');

-- Verify data insertion
SELECT 'Users count: ' || COUNT(*) as users FROM users;
SELECT 'Orders count: ' || COUNT(*) as orders FROM orders;
SELECT 'Dishes count: ' || COUNT(*) as dishes FROM dishes;