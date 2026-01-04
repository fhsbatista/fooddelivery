insert into cuisines (name, id) values ('Japanese', 1);
insert into cuisines (name, id) values ('Chinese', 2);
insert into cuisines (name, id) values ('Italian', 3);
insert into states (id, name) values (1, 'São Paulo');
insert into states (id, name) values (2, 'Rio de Janeiro');
insert into states (id, name) values (3, 'Minas Gerais');
insert into cities (id, name, state_id) values (1, 'São Paulo', 1);
insert into cities (id, name, state_id) values (2, 'Rio de Janeiro', 2);
insert into cities (id, name, state_id) values (3, 'Belo Horizonte', 3);
insert into restaurants (
    id,
    name,
    delivery_tax,
    cuisine_id,
    zip_code,
    address,
    neighborhood,
    number,
    complement,
    city_id
) values (
    1,
    'Hitaka food',
    1.5,
    1,
    '01310-100',
    'Avenida Paulista',
    'Bela Vista',
    '1000',
    'Apto 123',
    1
);
insert into restaurants (
    id,
    name,
    delivery_tax,
    cuisine_id,
    zip_code,
    address,
    neighborhood,
    number,
    complement,
    city_id
) values (
    2,
    'Aikiko',
    2.5,
    1,
    '22020-001',
    'Avenida Atlântica',
    'Copacabana',
    '1500',
    'Loja 45',
    2
);
insert into restaurants (
    id,
    name,
    delivery_tax,
    cuisine_id,
    zip_code,
    address,
    neighborhood,
    number,
    complement,
    city_id
) values (
    3,
    'Lee food',
    2.5,
    2,
    '30130-010',
    'Rua da Bahia',
    'Centro',
    '2500',
    null,
    3
);
insert into restaurants (
    id,
    name,
    delivery_tax,
    cuisine_id,
    zip_code,
    address,
    neighborhood,
    number,
    complement,
    city_id
) values (
    4,
    'Mamma mia',
    2.5,
    3,
    '01452-001',
    'Rua Oscar Freire',
    'Jardins',
    '500',
    'Sobrado',
    1
);
insert into payment_types (id, description) values (1, 'CARD_DEBIT');
insert into payment_types (id, description) values (2, 'CARD_CREDIT');
insert into payment_types (id, description) values (3, 'PIX');
insert into payment_types (id, description) values (4, 'CASH');
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (1, 1);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (1, 2);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (1, 3);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (1, 4);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (2, 4);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (3, 4);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (4, 3);
insert into restaurant_payment_types (restaurant_id, payment_type_id) values (4, 4);
