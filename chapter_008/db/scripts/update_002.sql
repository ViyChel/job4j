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

INSERT INTO items (name, userid, category, status) values ('Please arrange access to the roof', 1, 'access', 'awaiting');
INSERT INTO items (name, userid, category, status) values ('Please arrange access to the roof', 1, 'error', 'awaiting');
INSERT INTO items (name, userid, category, status) values ('All workers are not working next week due to coronavirus!', 2, 'info', 'awaiting');

INSERT INTO attachs (file) values ('/project/readme.txt');
