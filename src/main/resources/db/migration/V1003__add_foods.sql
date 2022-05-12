insert into foods (name, image, price, description, place_id)
values ('Кофе', 'image/steak.png', 350, '111',(SELECT id FROM places where name='Coffee with love')),
       ('Стейк', 'image/steaks.png', 2240, '123',(SELECT id FROM places where name='GrillBar')),
       ('Бургер', 'image/burgers.png', 1150,'111',(SELECT id FROM places where name='FastFood')),
       ('Капкейк', 'image/bakery.png', 420, '111',(SELECT id FROM places where name='Coffee with love')),
       ('Чизкейк', 'image/dessert.png',600, '123',(SELECT id FROM places where name='Coffee with love')),
       ('Sushi', 'image/sushi.png', 1800, '111',(SELECT id FROM places where name='FishBar')),
       ('Морской окунь', 'image/sea_food.png',2500,'111', (SELECT id FROM places where name='FishBar')),
       ('Паста с морепродуктами', 'image/pasta.png', 2800,'111', (SELECT id FROM places where name='FishBar')),
       ('Молочный коктейль', 'image/cocktail.png', 800, '111',(SELECT id FROM places where name='Coffee with love')),
       ('Пицца с колбасками гриль', 'image/pizza.png', 2900, '111',(SELECT id FROM places where name='GrillBar')),
       ('Fast food', 'image/fast_food.png', 950, '111',(SELECT id FROM places where name='FastFood')),
       ('Салат', 'image/salad.png', 1180, '111',(SELECT id FROM places where name='FishBar'));