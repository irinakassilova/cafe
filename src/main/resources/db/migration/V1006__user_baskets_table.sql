create table users_baskets
(
    user_id int not null,
    CONSTRAINT fk_user_baskets_user FOREIGN KEY (user_id) REFERENCES users (id),
    baskets_id int not null,
    constraint fk_user_baskets_basket foreign key (baskets_id) references baskets(id)
);