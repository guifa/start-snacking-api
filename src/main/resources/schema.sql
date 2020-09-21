create table ingredient
(
   id integer not null auto_increment,
   name varchar(255) not null,
   price double not null,
   primary key(id)
);

create table snack
(
   id integer not null auto_increment,
   name varchar(255) not null,
   primary key(id)
);

create table snack_ingredient
(
   id integer not null auto_increment,
   id_snack integer not null,
   id_ingredient integer not null,
   quantity integer not null,
   primary key(id),
   foreign key(id_ingredient) references ingredient(id),
   foreign key(id_snack) references snack(id)
);