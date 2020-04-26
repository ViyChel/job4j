create table role (
	role_type varchar(100) primary key,
	description varchar(200)
);

create table rules (
	rule_type varchar(100) primary key,
	description varchar(200)
);

create table categories (
	category varchar(100) primary key,
	description varchar(200)
);

create table state (
	status varchar(100) primary key,
	description varchar(200)
);

create table role_rules (
role_type varchar(100) references role(role_type),
rule_type varchar(100) references rules(rule_type)
);

create table users (
    id serial primary key,
    name varchar(100),
    phone varchar(20),
    role_type varchar references role(role_type)
);

create table items (
    id serial primary key,
    name varchar(500),
    create_time timestamp default now(),
    close_time timestamp,
    users_id int references users(id),
    categories_category varchar references categories(category),
    state_status varchar references state(status)
);

create table attachs (
   id serial primary key,
   file varchar(500),
   items_id int references items(id)
);

create table comments (
   id serial primary key,
   comment text,
   items_id int references items(id)
);


INSERT INTO role values ('user','User has regular rights');
INSERT INTO role values ('admin','User has administrative rights.');

INSERT INTO rules values ('admin_rules','Create, update, read, delete items');
INSERT INTO rules values ('user_rules', 'Update, read items');

INSERT INTO categories values ('error', 'Problems with errors');
INSERT INTO categories values ('access', 'Organization of access');
INSERT INTO categories values ('info', 'Information');

INSERT INTO state (status) values ('processing');
INSERT INTO state (status) values ('awaiting');
INSERT INTO state (status) values ('accepted');

INSERT INTO role_rules values ('user', 'user_rules');
INSERT INTO role_rules values ('admin', 'admin_rules');

INSERT INTO users (name, phone, role_type) values ('Ivan Ivanov', '+79049999999','user');
INSERT INTO users (name, phone, role_type) values ('Petrov Petr', '+79057777777','admin');

INSERT INTO items (name, users_id, categories_category, state_status) values ('Please arrange access to the roof', 1, 'access', 'awaiting');
INSERT INTO items (name, users_id, categories_category, state_status) values ('Please arrange access to the roof', 1, 'error', 'awaiting');
INSERT INTO items (name, users_id, categories_category, state_status) values ('All workers are not working next week due to coronavirus!', 2, 'info', 'awaiting');

INSERT INTO attachs (file) values ('/project/readme.txt');
