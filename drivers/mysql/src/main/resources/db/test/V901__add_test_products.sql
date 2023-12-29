insert into product (id, uuid, name, description, price, image, category, enabled, created, last_updated, version)
values (id, '69874a3f-b76e-4ac5-ba18-a19b979504cb', 'Teste Lanche', 'Um belo X Tudão', 23.50, 'http://localhost:8888/lanche.png', 'SANDWICH', 1, now(), now(), 0),
       (id, 'cee8d311-198d-4244-8386-d8d8fa20825c', 'Teste Lanche 2', 'Um belo X Tudão', 23.50, 'http://localhost:8888/lanche.png', 'SANDWICH', 1, now(), now(), 0),
       (id, '96a8f8ef-be0e-445d-9e60-257a5b5edcc9', 'Teste Sobremesa', 'Um bolo irresitível', 8.50, 'http://localhost:8888/sobremesa.png', 'DESSERT', 1, now(), now(), 0),
       (id, 'ade7f71c-5642-4fff-9385-4b983a0f9a7d', 'Teste Acompanhamento', 'Uma bela porção de batata sequinha', 6.00, 'http://localhost:8888/fritas.png', 'SIDE_DISH', 1, now(), now(), 0),
       (id, '20769aae-f070-405d-9ea2-48e438b7c212', 'Teste Acompanhamento 2', 'Uma bela porção de batata sequinha', 6.00, 'http://localhost:8888/fritas.png', 'SIDE_DISH', 1, now(), now(), 0),
       (id, 'e122debc-28ed-4475-a4e3-e1ad14468381', 'Teste Bebida', 'Delícia', 7.50, 'http://localhost:8888/refrigerante.png', 'BEVERAGE', 1, now(), now(), 0),
       (id, '4735f106-d902-4639-922f-deb9c537b2cc', 'Teste Bebida 2', 'Delícia', 7.50, 'http://localhost:8888/refrigerante.png', 'BEVERAGE', 1, now(), now(), 0),
       (id, '2a8aa47d-8516-43c9-8297-e16121d8192d', 'Teste Combo', 'Lanche + Batata + Refri', 31.50, 'http://localhost:8888/combo.png', 'COMBO', 1, now(), now(), 0);

insert into combo(id, sandwich_id, beverage_id, side_dish_id)
select (select id from product where uuid = '2a8aa47d-8516-43c9-8297-e16121d8192d') as id,
       (select id from product where uuid = 'cee8d311-198d-4244-8386-d8d8fa20825c') as sandwich_id,
       (select id from product where uuid = '4735f106-d902-4639-922f-deb9c537b2cc') as beverage_id,
       (select id from product where uuid = '20769aae-f070-405d-9ea2-48e438b7c212') as side_dish_id;


