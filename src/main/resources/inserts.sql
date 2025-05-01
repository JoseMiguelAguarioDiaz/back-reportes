-- Artistas
INSERT INTO artists (name, profile_pic) VALUES 
('Bad Bunny', 'bad_bunny.jpg'),
('Taylor Swift', 'taylor_swift.jpg'),
('Ed Sheeran', 'ed_sheeran.jpg'),
('Karol G', 'karol_g.jpg'),
('The Weeknd', 'weeknd.jpg'),
('Billie Eilish', 'billie_eilish.jpg'),
('J Balvin', 'j_balvin.jpg'),
('Dua Lipa', 'dua_lipa.jpg'),
('Harry Styles', 'harry_styles.jpg'),
('Shakira', 'shakira.jpg');

-- Álbumes
INSERT INTO albums (title, price, release_date, artist_id, image) VALUES 
-- Bad Bunny albums
('Un Verano Sin Ti', 29.99, '2022-05-06', 1, 'verano_sin_ti.jpg'),
('El Último Tour Del Mundo', 24.99, '2020-11-27', 1, 'ultimo_tour.jpg'),

-- Taylor Swift albums
('Midnights', 27.99, '2022-10-21', 2, 'midnights.jpg'),
('Folklore', 25.99, '2020-07-24', 2, 'folklore.jpg'),

-- Ed Sheeran albums
('=', 26.99, '2021-10-29', 3, 'equals.jpg'),
('÷', 24.99, '2017-03-03', 3, 'divide.jpg'),

-- Karol G albums
('Mañana Será Bonito', 28.99, '2023-02-24', 4, 'manana.jpg'),
('KG0516', 25.99, '2021-03-25', 4, 'kg0516.jpg'),

-- The Weeknd albums
('Dawn FM', 29.99, '2022-01-07', 5, 'dawn_fm.jpg'),
('After Hours', 26.99, '2020-03-20', 5, 'after_hours.jpg'),

-- Billie Eilish albums
('Happier Than Ever', 27.99, '2021-07-30', 6, 'happier.jpg'),
('When We All Fall Asleep', 25.99, '2019-03-29', 6, 'fall_asleep.jpg'),

-- J Balvin albums
('Jose', 26.99, '2021-09-10', 7, 'jose.jpg'),
('Colores', 24.99, '2020-03-19', 7, 'colores.jpg'),

-- Dua Lipa albums
('Future Nostalgia', 28.99, '2020-03-27', 8, 'future_nostalgia.jpg'),
('Dua Lipa', 23.99, '2017-06-02', 8, 'dua_lipa.jpg'),

-- Harry Styles albums
('Harrys House', 29.99, '2022-05-20', 9, 'harrys_house.jpg'),
('Fine Line', 26.99, '2019-12-13', 9, 'fine_line.jpg'),

-- Shakira albums
('El Dorado', 25.99, '2017-05-26', 10, 'el_dorado.jpg'),
('Sale el Sol', 23.99, '2010-10-19', 10, 'sale_el_sol.jpg');

-- Canciones
INSERT INTO songs (title, duracion, album_id) VALUES 
-- Un Verano Sin Ti songs
('Moscow Mule', 244, 1),
('Después de la Playa', 231, 1),
('Me Porto Bonito', 178, 1),
('Tití Me Preguntó', 244, 1),
('Ojitos Lindos', 258, 1),

-- El Último Tour Del Mundo songs
('Te Mudaste', 213, 2),
('Hoy Cobré', 156, 2),
('Maldita Pobreza', 178, 2),
('Te Deseo Lo Mejor', 187, 2),
('Dakiti', 205, 2),

-- Midnights songs
('Lavender Haze', 202, 3),
('Snow On The Beach', 256, 3),
('Anti-Hero', 200, 3),
('Midnight Rain', 178, 3),
('Karma', 204, 3),

-- Folklore songs
('The 1', 210, 4),
('Cardigan', 232, 4),
('The Last Great American Dynasty', 231, 4),
('Exile', 285, 4),
('My Tears Ricochet', 254, 4);

-- Continuando con más canciones para los demás álbumes...
-- = (Ed Sheeran) songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Tides', 195, 5),
('Shivers', 207, 5),
('First Times', 185, 5),
('Bad Habits', 230, 5),
('Overpass Graffiti', 236, 5);

-- Mañana Será Bonito songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Mientras Me Curo del Cora', 176, 7),
('X Si Volvemos', 182, 7),
('Mamiii', 225, 7),
('Provenza', 194, 7),
('Gatúbela', 198, 7);

-- Dawn FM songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Dawn FM', 195, 9),
('Gasoline', 212, 9),
('How Do I Make You Love Me?', 221, 9),
('Take My Breath', 339, 9),
('Sacrifice', 189, 9);

-- Happier Than Ever songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Getting Older', 245, 11),
('I Didnt Change My Number', 194, 11),
('Billie Bossa Nova', 199, 11),
('My Future', 209, 11),
('Oxytocin', 198, 11);

-- Future Nostalgia songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Future Nostalgia', 203, 15),
('Dont Start Now', 183, 15),
('Cool', 197, 15),
('Physical', 193, 15),
('Levitating', 203, 15);

-- Harrys House songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Music For a Sushi Restaurant', 192, 17),
('Late Night Talking', 178, 17),
('As It Was', 167, 17),
('Daylight', 165, 17),
('Little Freak', 203, 17);

-- El Dorado songs
INSERT INTO songs (title, duracion, album_id) VALUES 
('Me Enamoré', 225, 19),
('Nada', 212, 19),
('Chantaje', 195, 19),
('La Bicicleta', 216, 19),
('Amarillo', 187, 19);
