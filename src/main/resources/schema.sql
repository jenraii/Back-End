SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS application_user;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE category
(
    categoryid INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL
);

CREATE TABLE book
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    author           VARCHAR(255),
    publication_year INT,
    isbn             VARCHAR(255) NOT NULL,
    price            DECIMAL(10, 2),
    categoryid       INT,
    status           VARCHAR(255) DEFAULT 'AVAILABLE',
    FOREIGN KEY (categoryid) REFERENCES category (categoryid)
);

CREATE TABLE application_user
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL
);

INSERT INTO category (name)
VALUES ('Category 1');
INSERT INTO category (name)
VALUES ('Category 2');
INSERT INTO category (name)
VALUES ('Category 3');

INSERT INTO book (title, author, publication_year, isbn, price, categoryid)
VALUES ('Book 1', 'Author 1', 2000, 'ISBN-1111', 10.99, 1);

INSERT INTO book (title, author, publication_year, isbn, price, categoryid)
VALUES ('Book 2', 'Author 2', 2010, 'ISBN-2222', 15.99, 2);

INSERT INTO application_user (username, password, role)
VALUES ('admin', '$2b$10$o0liCdP9lzTgCHarj9JCdeoyWICDjRpQCYS4TP97jSnRc5tlriKPS', 'ADMIN');
INSERT INTO application_user (username, password, role)
VALUES ('admin2', '$2b$10$o0liCdP9lzTgCHarj9JCdeoyWICDjRpQCYS4TP97jSnRc5tlriKPS', 'ADMIN');


