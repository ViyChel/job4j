create table items (
    id serial primary key,
    name varchar(500),
    create_time timestamp default now(),
    close_time timestamp,
    users_id int references users(id),
    categories_category varchar references categories(category),
    state_status varchar references state(status)
)