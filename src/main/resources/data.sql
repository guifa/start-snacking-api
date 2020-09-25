insert into ingredient(name,price)
values('Alface', 0.4);
insert into ingredient(name,price)
values('Bacon', 2.0);
insert into ingredient(name,price)
values('Carne', 3.0);
insert into ingredient(name,price)
values('Ovo', 0.8);
insert into ingredient(name,price)
values('Queijo', 1.5);

insert into snack(name)
values('X-Bacon');
insert into snack(name)
values('X-Burger');
insert into snack(name)
values('X-Egg');
insert into snack(name)
values('X-Egg Bacon');

insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(1,2,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(1,3,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(1,5,1);

insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(2,3,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(2,5,1);

insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(3,3,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(3,4,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(3,5,1);

insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(4,2,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(4,3,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(4,4,1);
insert into snack_ingredient(id_snack, id_ingredient, quantity)
values(4,5,1);

insert into sale(name,description)
values('Light', 'Se o lanche tem alface e não tem bacon, ganha 10% de desconto.');
insert into sale(name,description)
values('Muita carne', 'A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...');
insert into sale(name,description)
values('Muito queijo', 'A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...');

