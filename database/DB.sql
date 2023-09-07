use gestionbibliothèque;

create table Auteur(
                       id int primary key auto_increment,
                       nom varchar(255),
                       prenom varchar(255),
                       datanaissance DATE
);
create table Book(
                     isbn varchar(255) primary key,
                     titre varchar(255),
                     status varchar(255),
                     auteurid int,
                     foreign key (auteurid) references Auteur(id)
);
create table borrower(
                         nombreid int primary key  auto_increment,
                         name varchar(255)
);
create table borrow(
                       id int primary key auto_increment,
                       bookid int,
                       foreign key (bookid) references Book(isbn),
                       borrowerid int,
                       foreign key (borrowerid) references borrower(nombreid),
                       datelaivraisan date,
                       datereturn date
);

INSERT INTO  Auteur (id, nom, prenom, datanaissance) VALUE (2,'Ahmed','Sefrioui','1915-01-01');
INSERT INTO  Book(isbn, titre, status, auteurid) VALUE (2,'Boite a merveilles','Disponible','1');
UPDATE Book SET isbn=1 WHERE isbn=2;
/*DELETE FROM Book WHERE isbn=1;*/

CREATE TRIGGER SetBookStatus
        BEFORE INSERT ON Book
        FOR EACH ROW
    BEGIN
        SET NEW.status = 'Disponible';
    END;