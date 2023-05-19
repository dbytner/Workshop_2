--tworzenie bazy danych
CREATE
DATABASE new_db_name
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

--tworzenie tabeli
CREATE TABLE users
(
    id         INT AUTO_INCREMENT,
    user_name  VARCHAR(255),
    user_email VARCHAR(255) UNIQUE,
    PRIMARY KEY (id)
);

--dodanie nowej kolumny
ALTER TABLE table_name
    ADD col_name datatype;

--usunięcie kolumny
ALTER TABLE table_name DROP COLUMN col_name;

--zmiana danych w kolumnie
ALTER TABLE table_name MODIFY COLUMN col_name new_datatype;

--usunięcie tabeli
DROP TABLE table_name;

--usunięie DB
DROP
DATABASE d_base;

--pobieranie danych z tabeli
SELECT col_name_1, col_name_2
FROM table_name;

SELECT *
FROM table_name;

--klauzula WHERE
SELECT col_name_1, col_name_2
FROM table_name
WHERE col_name_1 = < searching_value >;

SELECT *
FROM users
WHERE user_name LIKE "Jan%";

--klauzula AS
SELECT col_name AS col_alias
FROM table_name;

--klauzula ORDER BY
SELECT col_name_1, col_name_2
FROM table_name
ORDER BY col_name_1[ASC/DESC],
col_name_2 [ASC/DESC];

--klauzula DISTINCT
SELECT DISTINCT user_name
FROM `users`;

--funkcje agregujące
SELECT SUM(col_name_1)
FROM table_name;

SELECT AVG(balance)
FROM users
WHERE user_name = "Marek";

SELECT user_group, COUNT(*)
FROM users
GROUP BY user_group;

--klauzula HAVING
SELECT user_group, COUNT(*) AS size
FROM users
GROUP BY user_group
HAVING size > 1;

--klauzula LIMIT i OFFSET
SELECT *
FROM users LIMIT 5
OFFSET 2;

--relacja ONE TO ONE
CREATE TABLE customers
(
    customer_id int          NOT NULL AUTO_INCREMENT,
    name        varchar(255) NOT NULL,
    PRIMARY KEY (customer_id)
);
CREATE TABLE addresses
(
    customer_id int NOT NULL,
    street      varchar(255),
    PRIMARY KEY (customer_id),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
        ON DELETE CASCADE
);

--relacja ONE TO MANY
CREATE TABLE orders
(
    order_id      int NOT NULL AUTO_INCREMENT,
    customer_id   int NOT NULL,
    order_details varchar(255),
    PRIMARY KEY (order_id),
    FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
);

INSERT INTO orders(customer_id, order_details)
VALUES (3, "Order1"),
       (3, "Order2"),
       (3, "Order3");
SELECT *
FROM customers
         JOIN orders ON customers.customer_id = orders.customer_id
WHERE customers.customer_id = 3;

--relacja MANY TO MANY
CREATE TABLE items_orders
(
    id       int AUTO_INCREMENT,
    item_id  int NOT NULL,
    order_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    FOREIGN KEY (item_id) REFERENCES items (item_id)
);

--łaczenie tabel w zapytaniu
SELECT column_name
FROM table1 AS one JOIN table2 AS two ON one.column_name = two.column_name;

SELECT * FROM customers JOIN addresses ON customers.customer_id=addresses.customer_id;

SELECT * FROM customers LEFT JOIN addresses ON customers.customer_id=addresses.customer_id;

SELECT * FROM customers RIGHT JOIN addresses ON customers.customer_id=addresses.customer_id;