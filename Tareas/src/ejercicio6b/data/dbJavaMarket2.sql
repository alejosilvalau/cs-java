create database if not exists javaMarket2;

use javaMarket2;

drop table if exists product;

create table product (
  id int auto_increment primary key,
  name varchar(50) not null,
  description varchar(255) not null,
  price decimal(10, 2) not null,
  stock int not null,
  shippingIncluded tinyint (1) not null,
  disabledOn datetime null
);

LOCK TABLES `product` WRITE;

INSERT INTO
  `product` (
    `id`,
    `name`,
    `description`,
    `price`,
    `stock`,
    `shippingIncluded`
  )
VALUES
  (
    1,
    'Teclado Mecánico RGB',
    'Teclado switch blue con retroiluminación personalizada.',
    79.99,
    100,
    1
  ),
  (
    2,
    'Monitor 24" Full HD',
    'Panel IPS con tasa de refresco de 144Hz y bordes finos.',
    199.99,
    200,
    0
  ),
  (
    3,
    'Mouse Gamer Pro',
    'Sensor óptico de 16000 DPI y 6 botones programables.',
    45.00,
    50,
    1
  );

unlock tables;
