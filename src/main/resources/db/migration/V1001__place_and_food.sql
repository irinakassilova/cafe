CREATE TABLE places
(
    id serial primary key NOT NULL,
    name    varchar(128)       NOT NULL,
    description varchar(128)       NOT NULL,
    image   varchar(128)       NOT NULL
);

create table foods
(
    id  serial primary key NOT NULL,
    name     varchar(128)       NOT NULL,
    image    varchar(450)       NOT NULL,
    price    int             not null,
    description varchar(450) ,
    place_id int                not null,
    CONSTRAINT fk_food_place FOREIGN KEY (place_id) REFERENCES places (id)
);