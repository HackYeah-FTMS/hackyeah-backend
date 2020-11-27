INSERT INTO USERS (id, username, password) VALUES
    (1, 'mslowiak', 'password'),
    (2, 'fturek', 'password'),
    (3, 'test', 'password'),
    (4, 'somefancyguy', 'password'),
    (5, 'health_balance', 'password');

INSERT INTO PROJECTS (id, user_id, title, idea_image, solution_image, description, points, creation_timestamp) VALUES
    (1, 1, 'Mój pomysł na liście', 'https://n-22-5.dcs.redcdn.pl/file/o2/redefine/cp/xj/xj1gx9v9k1kzz4x37wcagdhi6r4ckrwo.jpg', 'https://www.glebokaswiadomosc.pl/wp-content/uploads/2019/10/ekologiczne-konfetti.jpg', 'Idzie jesień więc o liście bardzo łatwo...', 4, 1605045954709),
    (2, 1, 'Reużyj rolki!', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/paper-roll-on-orange-background-royalty-free-image-1584641876.jpg', 'https://i.pinimg.com/564x/54/d5/27/54d52748c025cc5c11aff93e9136ba31.jpg', 'Zamiast wyrzucac rolki po papierze można stworzyć ładną doniczkę na sadzonki.', 12, 1605909954709),
    (3, 2, 'Plecaczek', 'https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19419-1555009752-1.jpg', 'https://img.buzzfeed.com/buzzfeed-static/static/2019-04/11/15/asset/buzzfeed-prod-web-01/sub-buzz-19661-1555009856-1.jpg', 'Bardzo prosty sposób na stworzenie swojego plecaka', 31, 1606514754709);

INSERT INTO TAGS (id, name) VALUES
    (1, 'liść'),
    (2, 'rolka'),
    (3, 'papier'),
    (4, 'plecak'),
    (5, 'włóczka');

INSERT INTO PROJECTS_TAGS (projects_id, tags_id) VALUES
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 4),
    (3, 5);