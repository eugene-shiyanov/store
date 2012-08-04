-- clear db

drop table if exists Items;

-- create tables
create table if not exists Items (
	item_id bigint auto_increment primary key,
	name char(255) not null,
	price double
);

-- insert data
insert into Items(name, price) values('CPU', 50.5);
insert into Items(name, price) values('VGA', 60.6);
insert into Items(name, price) values('HDD', 70.7);
