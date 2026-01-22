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
    city_id,
    created_at,
    updated_at
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
    1,
    utc_timestamp(),
    utc_timestamp()
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
    city_id,
    created_at,
    updated_at
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
    2,
    utc_timestamp(),
    utc_timestamp()
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
    city_id,
    created_at,
    updated_at
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
    3,
    utc_timestamp(),
    utc_timestamp()
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
    city_id,
    created_at,
    updated_at
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
    1,
    utc_timestamp(),
    utc_timestamp()
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
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (1, 'Sushi Combo', 'Combo com 20 peças de sushi variado', true, 1, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (2, 'Temaki Salmão', 'Temaki recheado com salmão fresco e cream cheese', true, 1, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (3, 'Yakisoba', 'Macarrão frito com legumes e carne', true, 1, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (4, 'Sashimi Premium', 'Seleção de sashimi de salmão, atum e peixe branco', true, 2, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (5, 'Hot Roll', 'Rolinho empanado e frito com salmão e cream cheese', true, 2, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (6, 'Missoshiro', 'Sopa tradicional japonesa de pasta de soja', true, 2, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (7, 'Frango Xadrez', 'Frango em cubos com legumes e molho agridoce', true, 3, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (8, 'Yakisoba Especial', 'Yakisoba com camarão, frango e legumes', true, 3, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (9, 'Rolinho Primavera', 'Rolinho frito recheado com legumes e carne', true, 3, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (10, 'Pizza Margherita', 'Pizza tradicional com molho de tomate, mussarela e manjericão', true, 4, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (11, 'Lasanha à Bolonhesa', 'Lasanha com molho de carne e queijo', true, 4, utc_timestamp(), utc_timestamp());
insert into products (id, name, description, active, restaurant_id, created_at, updated_at) values (12, 'Espaguete Carbonara', 'Espaguete com molho cremoso, bacon e parmesão', true, 4, utc_timestamp(), utc_timestamp());
