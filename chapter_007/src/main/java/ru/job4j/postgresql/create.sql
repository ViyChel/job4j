CREATE DATABASE tracker;

\c tracker;

CREATE TABLE role (
	role_type varchar(100) PRIMARY KEY,
	description varchar(200)
);

CREATE TABLE rules (
	rule_type varchar(100) PRIMARY KEY,
	description varchar(200)
);

CREATE TABLE categories (
	category varchar(100) PRIMARY KEY,
	description varchar(200)
);

CREATE TABLE state (
	status varchar(100) PRIMARY KEY,
	description varchar(200)
);

CREATE TABLE role_rules (
role_type varchar(100) REFERENCES role(role_type),
rule_type varchar(100) REFERENCES rules(rule_type)
);

CREATE TABLE users (
    id serial PRIMARY KEY,
    name varchar(100),
    phone varchar(20),
    role_type varchar REFERENCES role(role_type)
);

CREATE TABLE item (
    id serial PRIMARY KEY,
    name varchar(500),
    create_time TIMESTAMP NOT NULL DEFAULT now(),
    close_time TIMESTAMP,
    users_id int REFERENCES users(id),
    categories_category varchar REFERENCES categories(category),
    state_status varchar REFERENCES state(status)
);

CREATE TABLE attachs (
   id serial PRIMARY KEY,
   file varchar(500),
   item_id int REFERENCES item(id)
);

CREATE TABLE comments (
   id serial PRIMARY KEY,
   comment text,
   item_id int REFERENCES item(id)
);


INSERT INTO role VALUES ('user','User has regular rights');
INSERT INTO role VALUES ('admin','User has administrative rights.');

INSERT INTO rules VALUES ('admin_rules','Create, update, read, delete items');
INSERT INTO rules VALUES ('user_rules', 'Update, read items');

INSERT INTO categories VALUES ('error', 'Problems with errors');
INSERT INTO categories VALUES ('access', 'Organization of access');
INSERT INTO categories VALUES ('info', 'Information');

INSERT INTO state (status) VALUES ('processing');
INSERT INTO state (status) VALUES ('awaiting');
INSERT INTO state (status) VALUES ('accepted');

INSERT INTO role_rules VALUES ('user', 'user_rules');
INSERT INTO role_rules VALUES ('admin', 'admin_rules');

INSERT INTO users (name, phone, role_type) VALUES ('Ivan Ivanov', '+79049999999','user');
INSERT INTO users (name, phone, role_type) VALUES ('Petrov Petr', '+79057777777','admin');

INSERT INTO item (name, users_id, categories_category, state_status) VALUES ('Please arrange access to the roof', 1, 'access', 'awaiting');
INSERT INTO item (name, users_id, categories_category, state_status) VALUES ('Please arrange access to the roof', 1, 'error', 'awaiting');
INSERT INTO item (name, users_id, categories_category, state_status) VALUES ('All workers are not working next week due to coronavirus!', 2, 'info', 'awaiting');

INSERT INTO attachs (file) VALUES ('/project/readme.txt');

INSERT INTO comments (comment, item_id) VALUES ('Thank you :)', 3);