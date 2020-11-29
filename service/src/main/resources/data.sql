INSERT INTO USERS (id, username, password) VALUES
    (10000, 'Ania', 'password'),
    (20000, 'Filip', 'password'),
    (30000, 'John', 'password'),
    (40000, 'Marek', 'password'),
    (50000, 'Asia', 'password');

INSERT INTO PROJECTS (id, user_id, title, idea_image, solution_image, description, points, creation_timestamp) VALUES
    (10000, 10000, 'Mój pomysł na liście', 'https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg', 'https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg', 'Idzie jesień więc o liście bardzo łatwo...', 4, 1605045954709),
    (20000, 10000, 'Reużyj rolki!', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/paper-roll-on-orange-background-royalty-free-image-1584641876.jpg', 'https://i.pinimg.com/564x/54/d5/27/54d52748c025cc5c11aff93e9136ba31.jpg', 'Zamiast wyrzucac rolki po papierze można stworzyć ładną doniczkę na sadzonki.', 12, 1605909954709),
    (30000, 20000, 'Plecaczek', 'https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19419-1555009752-1.jpg', 'https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19661-1555009856-1.jpg', 'Bardzo prosty sposób na stworzenie swojego plecaka', 31, 1606514754709),
    (40000, 20000, 'CD talerz', 'https://upload.wikimedia.org/wikipedia/commons/c/cf/CD-RW_bottom.jpg', 'https://static.boredpanda.com/blog/wp-content/uploads/2014/12/recycled-diy-old-cd-crafts-1-3.jpg', 'Miałem bardzo dużo płyt CD więc postanowiłem je wykozystać. Talerz wygląda świetnie!', 103, 1601514754709),
    (50000, 20000, 'Gazeta torbą może być', 'https://image.made-in-china.com/202f0j00PjEQtZvIOkbr/New-Fashion-Newspaper-Paper-Bags.jpg', 'https://images.theconversation.com/files/168390/original/file-20170508-5468-15e9j0c.jpg', 'Dużo czytam i odkładam wiele gazet. Szkoda wyrzucać tyle makulatury - mam fancy torebeczki', 12, 1602514754709);

INSERT INTO IDEAS (id, user_id, image, additional_info, points, creation_timestamp) VALUES
    (10000, 10000, 'https://dekorhome.pl/userdata/public/gfx/145563/KUBALA-Gabka-glazurnicza-porowa-twarda-1689.jpg', 'Co mógłbym zrobić z zużytymi gąbkami?', 0, 1605045954709),
    (20000, 20000, 'https://www.swiatdrozdzy.pl/3340-thickbox_default/butelka-na-wino-075-l-oliwkowa.jpg', 'Jak można wykorzystac butelki po winie?', 0, 1605034954709),
    (30000, 30000, 'https://images-na.ssl-images-amazon.com/images/I/919vcC7opZL._AC_SL1500_.jpg', 'Co zrobić z korków od wina?', 0, 1605234954709),
    (40000, 40000, 'https://wigglywisdom.com/wp-content/uploads/2019/09/Egg-Carton.jpg', 'Karton po jajkach', 0, 1605434954709),
    (50000, 50000, 'https://photos6.spartoo.pl/photos/165/16539545/16539545_350_A.jpg', 'Zużyta koszula męska', 0, 1605434954709);

INSERT INTO COMMENTS (id, image, content, user_id) VALUES
    (10000, 'https://i.pinimg.com/564x/1a/8a/31/1a8a31eaf6b481c46990e512df5f3021.jpg', 'Mogłbyś zrobić taki osuszacz', 20000),
    (20000, 'https://i.pinimg.com/564x/1b/0e/8b/1b0e8b695d1891707a4c22905a42e6bb.jpg', 'Da się zrobić ładnie świecącą lampkę :)', 10000),
    (30000, 'https://i.pinimg.com/564x/3c/05/d4/3c05d44be46cd88f825e22976eccdf30.jpg', 'Ja polecam stworzenie żyrandola - tylko trzeba mieć więcej butelek', 30000),
    (40000, 'https://i.pinimg.com/564x/70/08/c2/7008c222fb3e3f41ed1caf863b67e378.jpg', 'Można też zrobić stelaż na świeczki', 40000),
    (50000, 'https://v1.nitrocdn.com/REKEJBDFALhYdwnFCrTqhUyceLpwEOJa/assets/static/optimized/rev-f4a0442/wp-content/uploads/2020/05/wine-cork-wreath.jpg', 'Można zrobić wianek', 40000),
    (60000, 'https://v1.nitrocdn.com/REKEJBDFALhYdwnFCrTqhUyceLpwEOJa/assets/static/optimized/rev-f4a0442/wp-content/uploads/2020/05/keychain9.jpg', 'Albo breloczki do kluczy', 50000),
    (70000, 'https://cdn.vox-cdn.com/thumbor/B3d9EqS05WPD-Y9fI_Nz3mu3-Ks=/0x0:2070x1656/920x613/filters:focal(870x663:1200x993):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/66555147/2007_09_TOH_ATH_525_2001.0.jpg', 'Przechowalnik na śróbki', 50000);

INSERT INTO IDEAS_COMMENTS (ideas_id, comments_id) VALUES
    (10000, 10000),
    (20000, 20000),
    (20000, 30000),
    (20000, 40000),
    (30000, 50000),
    (30000, 60000),
    (40000, 70000);

INSERT INTO TAGS (id, name) VALUES
    (10000, 'liść'),
    (20000, 'rolka'),
    (30000, 'papier'),
    (40000, 'plecak'),
    (50000, 'włóczka');

INSERT INTO PROJECTS_TAGS (projects_id, tags_id) VALUES
    (10000, 10000),
    (20000, 20000),
    (20000, 30000),
    (30000, 40000),
    (30000, 50000);