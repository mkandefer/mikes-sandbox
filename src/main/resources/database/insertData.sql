insert into store(name) values ('Pet Store');

insert into product_category(name, parent, store_id) values ('Dog', null, (select top 1 id from store));
insert into product_category(name, parent, store_id) values ('Cat', null, (select top 1 id from store));

insert into product_category(name, parent, store_id) values ('Shiba', (select top 1 id from product_category where name = 'Dog'), null);
insert into product_category(name, parent, store_id) values ('Husky', (select top 1 id from product_category where name = 'Dog'), null);