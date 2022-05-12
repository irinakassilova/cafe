CREATE TABLE users (
                       id serial primary key  NOT NULL,
                       email varchar(128) NOT NULL,
                       password varchar(128) NOT NULL,
                       enabled boolean NOT NULL default true,
                       role varchar(128),
                       UNIQUE (email)
);

-- alter table if exists user_role
-- add constraint user_role_user_fk
-- foreign key (user_id) references users;
--
insert into users(email, password, enabled, role)
values ('admin@mail.com', '$2a$12$Vb8RRJHpUhf4nLeeiIJYQet4.//zUK2ZLFeumFrO1Q6oWpuuoSYha', true, 'ADMIN'),
       ('manager@mail.com','$2a$12$Vb8RRJHpUhf4nLeeiIJYQet4.//zUK2ZLFeumFrO1Q6oWpuuoSYha', true, 'MANAGER');

