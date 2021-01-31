create table if not exists role (
	role_type varchar(100) primary key,
	description varchar(200)
);

create table if not exists rules (
	rule_type varchar(100) primary key,
	description varchar(200)
);

create table if not exists categories (
	category varchar(100) primary key,
	description varchar(200)
);

create table if not exists state (
	status varchar(100) primary key,
	description varchar(200)
);

create table if not exists role_rules (
role_type varchar(100) references role(role_type),
rule_type varchar(100) references rules(rule_type)
);

create table if not exists users (
    id serial primary key,
    name varchar(100),
    phone varchar(20),
    role_type varchar references role(role_type)
);

create table if not exists items (
    id serial primary key,
    name varchar(500),
    createtime timestamp without time zone DEFAULT now(),
    closetime timestamp without time zone,
    userid int references users(id),
    category varchar references categories(category),
    status varchar references state(status)
);

create table if not exists attachs (
   id serial primary key,
   file varchar(500),
   item_id int references items(id)
);

create table if not exists comments (
   id serial primary key,
   comment text,
   item_id int references items(id)
);
