INSERT INTO USERS (username, password, email, first_name, last_name, age) VALUES
    ('admin','admin','admin@gmail.com','admin','admin',66),
    ('register1','reg123','reg@gmail.com','Kristina','Pavardene',45),
    ('Petras1985','petriukas','mech@gmail.com','Petras','Petraitis',37),
    ('Jonasmech','mechanikas','mech2@gmail.com','Jonas','Jonaitis',26),
    ('register2','123reg123','reg2@gmail.com','Tadas','Zukauskas',30);

INSERT INTO CLIENTS (id, name, surname, email, phone_nr, city, address) VALUES
    ('474d759c-133d-4ef3-b621-c271804da7b1','Petras','Petraitis','admin@gmail.com','8765842135','Kaunas','Rytu 5'),
    ('474d759c-133d-4ef3-b621-c271804da7b2','Kristina','Pavardene','reg@gmail.com','8765842134','Vilnius','Savanoriu 125'),
    ('474d759c-133d-4ef3-b621-c271804da7b3','Jonas','Jonaitis','mech@gmail.com','8765842138','Kaunas','Taikos 55'),
    ('474d759c-133d-4ef3-b621-c271804da7b4','Simas','Simaitis','reg2@gmail.com','8765842130','Karmelava','Liepu 23'),
    ('474d759c-133d-4ef3-b621-c271104da8b3','Tadas','Zukauskas','mefghch22a@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271204da8b3','Tadas','Zukauskas','me7cmh21w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271304da8b3','Tadas','Zukauskas','me4xch24w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271404da8b3','Tadas','Zukauskas','me4chh2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271504da8b3','Tadas','Zukauskas','me3chg12w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271604da8b3','Tadas','Zukauskas','m5echx24w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271704da8b3','Tadas','Zukauskas','me6c1kh2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271904da8b3','Tadas','Zukauskas','me4cjh2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271814da8b3','Tadas','Zukauskas','mecnh26w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271824da8b3','Tadas','Zukauskas','mecxhgh2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271823da8b3','Tadas','Zukauskas','maesfg2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271844da8b3','Tadas','Zukauskas','mewch212w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271834da8b3','Tadas','Zukauskas','mech3aa2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271854da8b3','Tadas','Zukauskas','mec4j2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271864da8b3','Tadas','Zukauskas','me3425w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271874da8b3','Tadas','Zukauskas','me26ch2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271884da8b3','Tadas','Zukauskas','me475ch2w@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271894da8b3','Tadas','Zukauskas','mec8h2s@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271805da8b3','Tadas','Zukauskas','mec5h2d@gmail.com','8765842139','Jonava','Kauno 2'),
    ('474d759c-133d-4ef3-b621-c271804da8b3','Tadas','Zukauskas','mech12f@gmail.com','8765842139','Jonava','Kauno 2');

INSERT INTO Autos (plate_nr, registration_time, brand, model, year, issue, fixed, costs, client_id) VALUES
    ('afs456', '2022-07-21 22:11', 'audi','a6','2005','sugedes variklis',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b1'),
    ('gfd123','2022-08-02 10:11', 'vw','golf','2012','skiles stiklas',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b1'),
    ('gfd555','2022-04-15 12:11', 'toyota','raw4','2016','vaziuokle',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b2'),
    ('uyt666','2022-07-02 21:11', 'opel','corsa','2002','pakeist alyva',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b3'),
    ('qwe845','2022-07-08 08:11', 'audi','q7','2015','sumontuot ratus',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b4'),
    ('tre333','2022-07-25 10:11', 'bmw','x5','2009','pakeist filtrus',false,0.0,'474d759c-133d-4ef3-b621-c271804da8b3');

INSERT INTO History (id, plate_nr, registration_time, brand, model, year, issue, fixed, costs, client_id) VALUES
    (91, 'afs456', '2022-07-21 22:11', 'audi','a6','2005','sugedes variklis',true,69.0,'474d759c-133d-4ef3-b621-c271804da7b1'),
    (92, 'gfd123','2022-08-02 10:11', 'vw','golf','2012','skiles stiklas',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b1'),
    (93, 'gfd555','2022-04-15 12:11', 'toyota','raw4','2016','vaziuokle',true,20.0,'474d759c-133d-4ef3-b621-c271804da7b2'),
    (94, 'uyt666','2022-07-02 21:11', 'opel','corsa','2002','pakeist alyva',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b3'),
    (95, 'qwe845','2022-07-08 08:11', 'audi','q7','2015','sumontuot ratus',false,0.0,'474d759c-133d-4ef3-b621-c271804da7b4'),
    (96, 'tre333','2022-07-25 10:11', 'bmw','x5','2009','pakeist filtrus',false,0.0,'474d759c-133d-4ef3-b621-c271804da8b3');
