CREATE TABLE baskets
(
    id          serial PRIMARY KEY,
    user_id int NOT NULL,
    food_id     int NOT NULL,
    count       int NOT NULL,
    sum         int not null,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    CONSTRAINT fk_food
        FOREIGN KEY (food_id)
            REFERENCES foods (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);
alter table places
    add column basket_id INT,
    add CONSTRAINT fk_place_basket
        FOREIGN KEY (basket_id)
            REFERENCES baskets(id);