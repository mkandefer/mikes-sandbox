insert into store(name) values ('Pet Store');

insert into product_category(name, parent, store_id) values ('Bird', null, (select top 1 id from store));
insert into product_category(name, parent, store_id) values ('Mammal', null, (select top 1 id from store));

insert into product_category(name, parent, store_id) values ('Dog', (select top 1 id from product_category where name = 'Mammal'), null);
insert into product_category(name, parent, store_id) values ('Cat', (select top 1 id from product_category where name = 'Mammal'), null);

insert into product_category(name, parent, store_id) values ('Shiba', (select top 1 id from product_category where name = 'Dog'), null);
insert into product_category(name, parent, store_id) values ('Husky', (select top 1 id from product_category where name = 'Dog'), null);

insert into product_category(name, parent, store_id) values ('Red Shiba', (select top 1 id from product_category where name = 'Shiba'), null);
insert into product_category(name, parent, store_id) values ('Black and Tan Shiba', (select top 1 id from product_category where name = 'Shiba'), null);