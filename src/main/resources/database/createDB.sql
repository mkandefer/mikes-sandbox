create table store (
    id bigint IDENTITY PRIMARY KEY,
    name varchar(100)
);

create table product_category (
    id bigint IDENTITY PRIMARY KEY,
    name varchar(100),
    parent bigint,
    store_id bigint
);

alter table product_category  add foreign key (parent) references product_category(id);
alter table product_category add foreign key (store_id) references store(id);