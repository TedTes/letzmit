INSERT INTO Profile (birthdate, nickname, manelength, gender, attracted_to_gender, description, lastseen) VALUES 
(DATE '1980-08-16', 'FillmoreFat', 3, 1, 2, 'Damn, Eskel... you got an hourglass figure', TIMESTAMP '2021-07-03 22:57:55'),
(DATE '1980-08-01', 'CandyKane', 20, 1, 1, 'Check out my Super Breath;)', TIMESTAMP '2021-08-27 01:57:56'),
(DATE '1991-09-16', 'DuaneDeVane', 10, 1, 2, 'I like playing Violin', TIMESTAMP '2021-09-08 19:57:56'),
(DATE '1993-12-22', 'AliGaither', 10, 2, 1, 'Why fall in love when you can fall asleep?', TIMESTAMP '2021-07-19 16:57:56'),
(DATE '1984-12-17', 'PennyWise', 26, 1, 2, 'Check out my Audiokinesis;)', TIMESTAMP '2021-07-14 09:57:56'),
(DATE '1987-05-06', 'DanSing', 27, 2, 1, 'Does this profile make me look single?', TIMESTAMP '2021-06-22 15:57:56'),
(DATE '1979-07-17', 'AdamZapel', 0, 1, 2, 'I''m just here to avoid friends on Facebook', TIMESTAMP '2021-08-26 09:57:56'),
(DATE '1994-11-10', 'DesPratt', 13, 1, 2, 'I promise I''ll be more interesting than this headline', TIMESTAMP '2021-06-17 06:57:57'),
(DATE '1996-08-02', 'DinahMite', 25, 2, 1, 'I believe in unicorn magic, and I make a mean spaghetti carbonara', TIMESTAMP '2021-10-18 18:57:57'),
(DATE '1994-07-10', 'WoodyForrest', 17, 2, 1, 'Swipe right if you don''t have any underwear on.', TIMESTAMP '2021-05-17 15:57:57'),
(DATE '1989-01-11', 'AmyStake', 27, 1, 2, 'Will fill this out after I find my glasses', TIMESTAMP '2021-05-22 21:57:57'),
(DATE '1974-09-12', 'RockyRhoades', 17, 2, 1, 'Ready for a cosmic adventure?', TIMESTAMP '2021-07-02 03:57:57'),
(DATE '1989-05-22', 'ChrisCross', 24, 1, NULL, 'I have the power to move objects with sound. Intrigued?', TIMESTAMP '2021-09-14 14:57:57'),
(DATE '1971-07-17', 'CariMysack', 28, 1, 2, 'Lets travel to Milky Way together <3', TIMESTAMP '2021-11-03 16:57:57'),
(DATE '1987-08-31', 'SkipStone', 13, 1, 2, 'I still believe in dragons, good men, and other fantasy creatures.', TIMESTAMP '2021-09-30 13:57:57'),
(DATE '1975-04-05', 'EstelleHertz', 16, 2, 1, 'Did u know that Chuck Norris doesn''t need garbage collection because he doesn''t call .Dispose(), he calls .DropKick().', TIMESTAMP '2021-10-01 20:57:58'),
(DATE '1996-02-21', 'ConnieLingus', 23, 2, NULL, 'If you like beverages and good conversation, we will get along just fine', TIMESTAMP '2021-08-23 04:57:58'),
(DATE '1993-09-27', 'DarkBrandon', 0, 1, NULL, 'I am a fun-loving, cute unicorn looking for someone to add a little extra magic to my life', TIMESTAMP '2021-09-05 07:57:58'),
(DATE '1971-07-31', 'EddieBull', 28, 1, 1, 'I produce more than just good products. I produce good times', TIMESTAMP '2021-09-11 01:57:58'),
(DATE '1974-09-27', 'JimShu', 1, 2, 1, 'I want that Mulan McNugget sauce, Morty!', TIMESTAMP '2021-08-17 23:57:58');

INSERT INTO Unicorn (email, password, profile_fk) VALUES
('fillmore.fat@wyman.co', '{noop}u87szdzwr6j', 1),
('candy.kane@mills.info', '{noop}mk8suwi4kq', 2),
('duane.devane@brekke.org', '{noop}7ahntn148svszh', 3),
('ali.gaither@littel.io', '{noop}rxp4we85xphdm', 4),
('penny.wise@berge.co', '{noop}9bk8h3vn27h5', 5),
('theresa.green@willms.name', '{noop}ltn0zt643qey38', 6),
('adam.zapel@borer.info', '{noop}sapzpabmrqh', 7),
('rip.torn@schneider.io', '{noop}bychc9sq', 8),
('dwayne.pipe@konopelski.info', '{noop}stfxniv5', 9),
('woody.forrest@medhurst.io', '{noop}fkp72pnt', 10),
('frank.n.sense@deckow.org', '{noop}wl9us0k6', 11),
('rocky.rhoades@keeling.co', '{noop}xekg4mbupocc4', 12),
('chris.cross@howe.com', '{noop}vq0ucpklfuylfef', 13),
('neil.b.formy@kuphal.co', '{noop}8ihx7kpe4s4a', 14),
('skip.stone@anderson.io', '{noop}6eflvyn44oxrb', 15),
('estelle.hertz@yundt.name', '{noop}lp6reyj1vsb', 16),
('m.balmer@schultz.net', '{noop}oz3lzvbvwjjgx', 17),
('d.brandon@murray.biz', '{noop}53jvjlpe', 18),
('eddie.bull@johnston.io', '{noop}lbcd0nyiiheb7', 19),
('jim.shu@bernier.com', '{noop}k1f66ug3q', 20);

INSERT INTO Photo (profile_fk, name, is_profile_photo, created) VALUES
(20, 'unicorn001', TRUE, TIMESTAMP '1999-08-17 00:00:00'),
(17, 'unicorn002', FALSE, TIMESTAMP '2006-11-25 00:00:00'),
(4, 'unicorn003', FALSE, TIMESTAMP '2017-10-18 00:00:00'),
(11, 'unicorn004', FALSE, TIMESTAMP '2008-08-19 00:00:00'),
(5, 'unicorn005', FALSE, TIMESTAMP '2007-07-26 00:00:00'),
(4, 'unicorn006', FALSE, TIMESTAMP '2017-06-21 00:00:00'),
(8, 'unicorn007', FALSE, TIMESTAMP '2005-03-25 00:00:00'),
(8, 'unicorn008', FALSE, TIMESTAMP '2004-04-27 00:00:00'),
(18, 'unicorn009', FALSE, TIMESTAMP '2021-11-22 00:00:00'),
(1, 'unicorn010', FALSE, TIMESTAMP '2006-12-06 00:00:00'),
(2, 'unicorn011', FALSE, TIMESTAMP '2006-04-02 00:00:00'),
(3, 'unicorn012', FALSE, TIMESTAMP '2009-10-09 00:00:00'),
(2, 'unicorn013', FALSE, TIMESTAMP '2007-12-06 00:00:00'),
(17, 'unicorn014', FALSE, TIMESTAMP '2006-04-15 00:00:00'),
(18, 'unicorn015', FALSE, TIMESTAMP '1999-02-25 00:00:00'),
(14, 'unicorn016', FALSE, TIMESTAMP '2010-06-16 00:00:00'),
(14, 'unicorn017', FALSE, TIMESTAMP '2015-09-09 00:00:00'),
(10, 'unicorn018', FALSE, TIMESTAMP '2014-10-09 00:00:00'),
(6, 'unicorn019', TRUE, TIMESTAMP '2007-10-01 00:00:00'),
(2, 'unicorn020', FALSE, TIMESTAMP '2003-05-04 00:00:00'),
(8, 'unicorn021', FALSE, TIMESTAMP '2003-07-30 00:00:00'),
(14, 'unicorn022', FALSE, TIMESTAMP '2014-04-22 00:00:00'),
(1, 'unicorn023', FALSE, TIMESTAMP '1998-09-29 00:00:00'),
(2, 'unicorn024', TRUE, TIMESTAMP '2006-08-06 00:00:00'),
(4, 'unicorn025', FALSE, TIMESTAMP '2015-02-10 00:00:00'),
(9, 'unicorn026', TRUE, TIMESTAMP '2020-05-03 00:00:00'),
(19, 'unicorn027', FALSE, TIMESTAMP '2019-01-26 00:00:00'),
(19, 'unicorn028', FALSE, TIMESTAMP '1999-08-05 00:00:00'),
(5, 'unicorn029', FALSE, TIMESTAMP '2009-02-14 00:00:00'),
(1, 'unicorn030', FALSE, TIMESTAMP '2003-11-14 00:00:00'),
(5, 'unicorn031', FALSE, TIMESTAMP '2006-02-07 00:00:00'),
(5, 'unicorn032', FALSE, TIMESTAMP '2005-08-06 00:00:00'),
(17, 'unicorn033', FALSE, TIMESTAMP '2001-06-15 00:00:00'),
(6, 'unicorn034', FALSE, TIMESTAMP '2002-09-16 00:00:00'),
(13, 'unicorn035', FALSE, TIMESTAMP '2004-11-25 00:00:00'),
(11, 'unicorn036', FALSE, TIMESTAMP '2006-09-02 00:00:00'),
(13, 'unicorn037', FALSE, TIMESTAMP '2002-09-19 00:00:00'),
(1, 'unicorn038', FALSE, TIMESTAMP '2007-08-30 00:00:00'),
(10, 'unicorn039', FALSE, TIMESTAMP '2011-02-26 00:00:00'),
(13, 'unicorn040', TRUE, TIMESTAMP '2013-11-01 00:00:00'),
(5, 'unicorn041', FALSE, TIMESTAMP '2001-08-01 00:00:00'),
(6, 'unicorn042', FALSE, TIMESTAMP '2004-12-29 00:00:00'),
(17, 'unicorn043', FALSE, TIMESTAMP '2000-03-09 00:00:00'),
(3, 'unicorn044', TRUE, TIMESTAMP '2014-09-17 00:00:00'),
(11, 'unicorn045', TRUE, TIMESTAMP '2018-10-28 00:00:00'),
(8, 'unicorn046', FALSE, TIMESTAMP '1997-11-18 00:00:00'),
(16, 'unicorn047', FALSE, TIMESTAMP '1998-02-16 00:00:00'),
(16, 'unicorn048', FALSE, TIMESTAMP '2013-10-29 00:00:00'),
(14, 'unicorn049', FALSE, TIMESTAMP '2006-04-24 00:00:00'),
(10, 'unicorn050', FALSE, TIMESTAMP '1997-06-19 00:00:00'),
(13, 'unicorn051', FALSE, TIMESTAMP '2012-04-27 00:00:00'),
(1, 'unicorn052', TRUE, TIMESTAMP '2012-08-27 00:00:00'),
(11, 'unicorn053', FALSE, TIMESTAMP '2007-06-26 00:00:00'),
(17, 'unicorn054', FALSE, TIMESTAMP '2009-12-11 00:00:00'),
(5, 'unicorn055', FALSE, TIMESTAMP '2010-03-04 00:00:00'),
(7, 'unicorn056', FALSE, TIMESTAMP '2010-11-25 00:00:00'),
(4, 'unicorn057', FALSE, TIMESTAMP '2005-03-16 00:00:00'),
(12, 'unicorn058', TRUE, TIMESTAMP '2010-11-20 00:00:00'),
(15, 'unicorn059', TRUE, TIMESTAMP '2014-01-01 00:00:00'),
(8, 'unicorn060', TRUE, TIMESTAMP '2015-02-14 00:00:00'),
(4, 'unicorn061', FALSE, TIMESTAMP '2020-11-17 00:00:00'),
(10, 'unicorn062', TRUE, TIMESTAMP '2016-08-13 00:00:00'),
(13, 'unicorn063', FALSE, TIMESTAMP '2008-02-24 00:00:00'),
(5, 'unicorn064', FALSE, TIMESTAMP '2010-07-05 00:00:00'),
(10, 'unicorn065', FALSE, TIMESTAMP '2016-02-29 00:00:00'),
(2, 'unicorn066', FALSE, TIMESTAMP '1997-06-13 00:00:00'),
(4, 'unicorn067', FALSE, TIMESTAMP '1999-01-18 00:00:00'),
(17, 'unicorn068', FALSE, TIMESTAMP '2009-05-02 00:00:00'),
(1, 'unicorn069', FALSE, TIMESTAMP '1998-11-15 00:00:00'),
(18, 'unicorn070', TRUE, TIMESTAMP '2016-02-12 00:00:00'),
(3, 'unicorn071', FALSE, TIMESTAMP '2013-02-20 00:00:00'),
(20, 'unicorn072', FALSE, TIMESTAMP '2008-12-15 00:00:00'),
(9, 'unicorn073', FALSE, TIMESTAMP '2009-04-07 00:00:00'),
(12, 'unicorn074', FALSE, TIMESTAMP '2004-04-18 00:00:00'),
(2, 'unicorn075', FALSE, TIMESTAMP '1998-03-17 00:00:00'),
(6, 'unicorn076', FALSE, TIMESTAMP '2019-05-16 00:00:00'),
(3, 'unicorn077', FALSE, TIMESTAMP '2006-09-03 00:00:00'),
(5, 'unicorn078', FALSE, TIMESTAMP '2010-08-28 00:00:00'),
(17, 'unicorn079', FALSE, TIMESTAMP '2011-09-07 00:00:00'),
(11, 'unicorn080', FALSE, TIMESTAMP '2016-12-21 00:00:00'),
(8, 'unicorn081', FALSE, TIMESTAMP '2002-06-27 00:00:00'),
(11, 'unicorn082', FALSE, TIMESTAMP '2013-07-16 00:00:00'),
(16, 'unicorn083', FALSE, TIMESTAMP '2020-11-21 00:00:00'),
(14, 'unicorn084', FALSE, TIMESTAMP '2005-07-27 00:00:00'),
(2, 'unicorn085', FALSE, TIMESTAMP '2019-08-21 00:00:00'),
(9, 'unicorn086', FALSE, TIMESTAMP '2017-05-29 00:00:00'),
(11, 'unicorn087', FALSE, TIMESTAMP '2001-03-15 00:00:00'),
(17, 'unicorn088', FALSE, TIMESTAMP '2010-05-17 00:00:00'),
(8, 'unicorn089', FALSE, TIMESTAMP '2005-12-27 00:00:00'),
(15, 'unicorn090', FALSE, TIMESTAMP '2013-02-05 00:00:00'),
(17, 'unicorn091', FALSE, TIMESTAMP '2002-04-05 00:00:00'),
(4, 'unicorn092', FALSE, TIMESTAMP '2004-05-17 00:00:00'),
(11, 'unicorn093', FALSE, TIMESTAMP '2012-06-23 00:00:00'),
(7, 'unicorn094', TRUE, TIMESTAMP '2018-07-02 00:00:00'),
(2, 'unicorn095', FALSE, TIMESTAMP '2021-03-02 00:00:00'),
(10, 'unicorn096', FALSE, TIMESTAMP '2004-12-12 00:00:00'),
(6, 'unicorn097', FALSE, TIMESTAMP '2009-01-14 00:00:00'),
(19, 'unicorn098', TRUE, TIMESTAMP '1998-03-15 00:00:00'),
(14, 'unicorn099', TRUE, TIMESTAMP '2018-06-04 00:00:00'),
(20, 'unicorn100', FALSE, TIMESTAMP '2019-11-05 00:00:00'),
(1, 'unicorn101', FALSE, TIMESTAMP '2011-05-10 00:00:00'),
(11, 'unicorn102', FALSE, TIMESTAMP '2017-08-13 00:00:00'),
(16, 'unicorn103', TRUE, TIMESTAMP '2009-05-13 00:00:00'),
(11, 'unicorn104', FALSE, TIMESTAMP '2005-03-16 00:00:00'),
(4, 'unicorn105', TRUE, TIMESTAMP '2004-01-27 00:00:00'),
(5, 'unicorn106', FALSE, TIMESTAMP '1997-07-06 00:00:00'),
(7, 'unicorn107', FALSE, TIMESTAMP '2001-06-24 00:00:00'),
(17, 'unicorn108', TRUE, TIMESTAMP '2019-05-03 00:00:00'),
(15, 'unicorn109', FALSE, TIMESTAMP '2017-08-29 00:00:00'),
(8, 'unicorn110', FALSE, TIMESTAMP '2021-08-23 00:00:00'),
(5, 'unicorn111', FALSE, TIMESTAMP '2003-03-25 00:00:00'),
(9, 'unicorn112', FALSE, TIMESTAMP '2008-03-31 00:00:00'),
(4, 'unicorn113', FALSE, TIMESTAMP '2005-10-06 00:00:00'),
(5, 'unicorn114', TRUE, TIMESTAMP '2014-05-06 00:00:00'),
(17, 'unicorn115', FALSE, TIMESTAMP '2009-02-21 00:00:00'),
(11, 'unicorn116', FALSE, TIMESTAMP '2018-01-13 00:00:00'),
(18, 'unicorn117', FALSE, TIMESTAMP '2012-10-08 00:00:00'),
(16, 'unicorn118', FALSE, TIMESTAMP '2011-01-09 00:00:00'),
(3, 'unicorn119', FALSE, TIMESTAMP '2003-09-11 00:00:00'),
(13, 'unicorn120', FALSE, TIMESTAMP '2008-04-30 00:00:00');

INSERT INTO Likes VALUES
(16,1), (7,13), (3,13), (6,1), (8,5), (17,3), (1,15), (3,15), (20,15),
(5,18), (10,20), (8,13), (13,9), (4,6), (12,15), (16,11), (19,10), (17,18),
(11,8), (16,2), (12,14), (9,16), (14,10), (20,3), (14,16), (10,2), (3,1),
(4,10), (2,4), (10,7), (14,8), (10,17), (9,1), (9,8), (11,10), (8,16),
(6,19), (8,2), (14,12), (6,8), (14,13), (17,7), (10,5), (3,8), (2,9),
(7,19), (14,18), (6,17), (3,10), (12,8), (5,10), (8,20), (19,7), (9,3),
(7,15), (13,16), (10,14), (10,9), (16,20), (17,4), (15,9), (4,8), (16,17),
(5,12), (8,10), (10,4), (14,11), (16,18), (17,6), (3,5), (7,6), (14,7),
(6,9), (18,2), (15,16), (1,14), (10,16), (2,8), (15,1), (12,10), (19,2),
(18,13), (4,20), (19,17), (8,3), (9,10), (1,3), (18,19), (8,9), (3,20),
(2,7), (14,2), (12,11), (6,11), (12,5), (18,7), (14,3), (5,13), (6,15), (20,11);