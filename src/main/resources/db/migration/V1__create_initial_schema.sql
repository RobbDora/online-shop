create table if not exists customer_table (customer_id varchar(255) not null, address_id bigint, company_name varchar(255), primary key (customer_id));
create table if not exists employee_table (employee_id bigint generated by default as identity, first_name varchar(255), home_phone varchar(255), last_name varchar(255), photo varchar(255), title varchar(255), primary key (employee_id));
create table if not exists location_table (location_id bigint generated by default as identity, street_name varchar(255), address_id bigint, primary key (location_id));
create table if not exists order_details_table (order_details_id bigint generated by default as identity, discount double, quantity smallint, unit_price double, order_id bigint, product_product_id bigint, primary key (order_details_id));
create table if not exists order_table (order_id bigint generated by default as identity, freight double, order_date timestamp, required_date timestamp, ship_address varchar(255), ship_city varchar(255), ship_country varchar(255), ship_name varchar(255), ship_postal_code varchar(255), ship_region varchar(255), ship_via smallint, shipped_date timestamp, customer_customer_id varchar(255), employee_employee_id bigint, primary key (order_id));
create table if not exists product_category_table (id bigint generated by default as identity, category varchar(255) not null, category_name varchar(255), number_of_products smallint, parent_id bigint, primary key (id));
create table if not exists product_table (product_id bigint generated by default as identity, name varchar(255), currency_code varchar(255), dimension_depth double, dimension_height double, dimension_width double, picture_url varchar(255), price double, short_description varchar(255), unit integer, weight double, weight_unit integer, status integer, supplier_name varchar(255), category_id bigint, primary key (product_id));
create table if not exists product_location_relationship (location_id bigint not null, product_id bigint not null, stock smallint not null, primary key (location_id, product_id));
alter table customer_table add constraint UK_ktbf402lr8ofn04q0av4qw92p unique (company_name);
alter table product_category_table add constraint UK_jcvnptamhmx0yfohldf5me22x unique (category);
alter table product_category_table add constraint UK_c9e1vhdm0boxhfl65bh64nda6 unique (category_name);
alter table order_details_table add constraint FKdoxxms1g90sssh286yv8fb7im foreign key (order_id) references order_table;
alter table order_details_table add constraint FKsg45ee2fvyv001a8lu8ef5hdr foreign key (product_product_id) references product_table;
alter table order_table add constraint FKk1a2bkw4od41uswkmwssnoecs foreign key (customer_customer_id) references customer_table;
alter table order_table add constraint FKgbqkeqq3bihuuisisktt8luv1 foreign key (employee_employee_id) references employee_table;
alter table product_category_table add constraint FKlofqh546914klcl60blpkrsok foreign key (parent_id) references product_category_table;
alter table product_table add constraint FKjq3skao9c1jxyw4e73fj32r1v foreign key (category_id) references product_category_table;
alter table product_location_relationship add constraint FK7i8hk95ps3lj6rs6yesrgl61l foreign key (location_id) references location_table;
