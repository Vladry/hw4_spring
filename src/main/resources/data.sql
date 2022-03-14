SET FOREIGN_KEY_CHECKS=0;

INSERT INTO customers (name, email, age, password)
VALUES ('Vlad',
        'rvy@ukr.net',
        40,
        'pwVlad'
        ),
       ('Sergey',
        'sergo@ukr.net',
        42,
        'pwSergey'
        ),
       ('Max',
        'Max@ukr.net',
        38,
        'pwMax'
        ),
       ('Evgeny',
        'evgen-20@ukr.net',
        20,
        'pwEvgeny'
        ),
       ('Petro',
        'petya@ukr.net',
        30,
        'pwPetro'
        );


INSERT INTO employers (name, address, street)
VALUES ('RogaIKopyta', 'Kiev', 'Bratislavska 9A'),
       ('KievInvestStroy', 'gorod Kiev', 'Zhukova'),
       ('IT - world', 'Odessa', 'Privoz'),
       ('Venture IT Creations', 'New-York', 'Brooklyn'),
       ('Self-Employed', 'Kiev city', 'Gaydara');


INSERT INTO accounts (number, currency, balance, customer_id)
VALUES ('1', 1, 15.05, 1),
       ('2', 2, 13.05, 1),
       ('3', 3, 25.05, 1),
       ('4', 1, 35.05, 2),
       ('5', 2, 15.05, 2),
       ('6', 3, 55.05, 3),
       ('7', 1, 44.05, 4),
       ('8', 2, 43.05, 5),
       ('9', 3, 33.05, 5);