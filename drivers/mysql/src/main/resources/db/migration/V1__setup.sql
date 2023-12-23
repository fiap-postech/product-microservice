create table product(
    id bigint auto_increment not null primary key,
    uuid varchar(36) not null unique,
    name varchar(200) not null,
    description text,
    price numeric(12,2) not null,
    image text not null,
    category enum('COMBO', 'SANDWICH', 'BEVERAGE', 'DESSERT', 'SIDE_DISH') not null,
    enabled boolean not null default true,
    created datetime not null,
    last_updated datetime not null,
    version integer not null
);

create table combo(
    id bigint not null primary key,
    sandwich_id bigint not null,
    beverage_id bigint not null,
    side_dish_id  bigint not null,
    constraint uk_combo_items unique (sandwich_id, beverage_id, side_dish_id),
    constraint fk_combo_id foreign key (id) references product(id),
    constraint fk_sandwich_id foreign key (sandwich_id) references product(id),
    constraint fk_beverage_id foreign key (beverage_id) references product(id),
    constraint fk_side_dish_id foreign key (side_dish_id) references product(id)
);