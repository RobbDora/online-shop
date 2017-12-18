insert into ORDER_DETAILS_TABLE (discount, quantity, unit_price, order_id, product_product_id) values (2.5, 50, 16.5, 53, 2);
insert into ORDER_DETAILS_TABLE (discount, quantity, unit_price, order_id, product_product_id) values (1.5, 100, 17.5, 52, 1);

insert into LOCATION_TABLE (street_name, address_id) values ('Salciei', 1);
insert into LOCATION_TABLE (street_name, address_id) values ('Babes', 2);
insert into LOCATION_TABLE (street_name, address_id) values ('Cantemir', 3);

insert into PRODUCT_LOCATION_RELATIONSHIP (STOCK, LOCATION_ID, PRODUCT_ID) values (800, 2, 1);
insert into PRODUCT_LOCATION_RELATIONSHIP (STOCK, LOCATION_ID, PRODUCT_ID) values (1000, 3, 2);



