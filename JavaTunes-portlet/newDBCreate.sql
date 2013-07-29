DROP database CapstoneLab;
create database CapstoneLab  character set utf8;
use CapstoneLab;

DROP TABLE Inventory;
DROP TABLE Item_BandMembers;
DROP TABLE Item;
DROP TABLE PurchaseItem;
DROP TABLE PurchaseOrder;

CREATE TABLE Item
(
   ItemId     BIGINT NOT NULL AUTO_INCREMENT,
   Num         VARCHAR(10) NOT NULL,
   Title       VARCHAR(40),
   Artist      VARCHAR(40),
   ReleaseDate DATE,
   ListPrice   DECIMAL(5,2),
   Price       DECIMAL(5,2),
   Version     INTEGER,
   CONSTRAINT  PK_Item  PRIMARY KEY(ItemId)
);

CREATE TABLE Item_BandMembers
(
   ItemBandMemberId  BIGINT NOT NULL AUTO_INCREMENT,
   ItemId     BIGINT NOT NULL,
   Member      VARCHAR(40) NOT NULL,
   CONSTRAINT  PK_ItemBandMembers  PRIMARY KEY(ItemBandMemberId),
   CONSTRAINT  FK_BM_to_Item    FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
);


CREATE TABLE Inventory
(
   InvId      BIGINT NOT NULL AUTO_INCREMENT,
   ItemId     BIGINT NOT NULL,
   URL    VARCHAR(50) NOT NULL,
   NoOfLicence    INTEGER       NOT NULL,
   FileType VARCHAR(50),
   CONSTRAINT  PK_Inventory  PRIMARY KEY(InvId),
   CONSTRAINT  FK_IV_to_Item    FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
);

CREATE TABLE PurchaseOrder
(
   PoId       BIGINT            NOT NULL AUTO_INCREMENT,
   Status      INTEGER           NOT NULL,
   OrderDate   DATE              NOT NULL,
   UserId      CHAR(8)           NOT NULL,
   CONSTRAINT  PK_PurchaseOrder  PRIMARY KEY(PoId)
);

CREATE TABLE PurchaseItem
(
   PurchaseItemId   BIGINT NOT NULL AUTO_INCREMENT,
   PoId             BIGINT               NOT NULL,
   ItemId           BIGINT               NOT NULL,
   Quantity         INTEGER              NOT NULL,
   UnitPrice        DECIMAL(5,2)         NOT NULL,
   
   CONSTRAINT  PK_PurchaseItem  PRIMARY KEY(PurchaseItemId),
   CONSTRAINT       FK_to_PO  FOREIGN KEY(PoId) REFERENCES PurchaseOrder(PoId),
   CONSTRAINT       FK_to_Item  FOREIGN KEY(ItemId) REFERENCES Item(ItemId)
);


INSERT INTO Item VALUES (DEFAULT, 'CD501', 'Diva', 'Annie Lennox', '1992-01-04', 17.97, 13.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD502', 'Dream of the Blue Turtles', 'Sting', '1985-02-05', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD503', 'Trouble is...', 'Kenny Wayne Shepherd Band', '1997-08-08', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD504', 'Lie to Me', 'Jonny Lang', '1997-08-26', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD505', 'Little Earthquakes', 'Tori Amos', '1992-01-18', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD506', 'Seal', 'Seal', '1991-08-18', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD507', 'Ian Moore', 'Ian Moore', '1993-12-05', 9.97, 9.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD508', 'So Much for the Afterglow', 'Everclear', '1997-01-19', 16.97, 13.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD509', 'Surfacing', 'Sarah McLachlan', '1997-12-04', 17.97, 13.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD510', 'Hysteria', 'Def Leppard', '1987-06-20', 17.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD511', 'A Life of Saturdays', 'Dexter Freebish', '2000-12-06', 16.97, 12.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD512', 'Human Clay', 'Creed', '1999-10-21', 18.97, 13.28,1);
INSERT INTO Item VALUES (DEFAULT, 'CD513', 'My, I''m Large', 'Bobs', '1987-02-20', 11.97, 11.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD514', 'So', 'Peter Gabriel', '1986-10-03', 17.97, 13.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD515', 'Big Ones', 'Aerosmith', '1994-05-08', 18.97, 14.99,1);
INSERT INTO Item VALUES (DEFAULT, 'CD516', '90125', 'Yes', '1983-10-16', 11.97, 11.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD517', '1984', 'Van Halen', '1984-08-19', 11.97, 11.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD518', 'Escape', 'Journey', '1981-02-25', 11.97, 11.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD519', 'Greatest Hits', 'Jay and the Americans', '1966-12-05', 13.99, 9.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD520', 'Ray of Light', 'Madonna', '2000-12-15', 14.99, 10.97,1);
INSERT INTO Item VALUES (DEFAULT, 'CD521', 'Music', 'Madonna', '2002-02-27', 14.99, 11.97,1);


INSERT INTO Item_BandMembers VALUES (DEFAULT, 1, 'Annie Lennox');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 2, 'Sting');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 3, 'Kenny Wayne Shepherd');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 3, 'Jimmy Wallace');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 3, 'Shaun Hague');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 3, 'Michael Devin');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 3, 'Bogie Bowles');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 4, 'Jonny Lang');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 5, 'Tori Amos');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 6, 'Seal');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 7, 'Ian Moore');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 9, 'Sarah McLachlan');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 10, 'Joe Elliot');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 10, 'Rick Savage');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 10, 'Phil Cohen');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 10, 'Rick Allen');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 10, 'Steve Clark');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 11, 'Dexter Freebish');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 14, 'Peter Gabriel');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 20, 'Madonna');
INSERT INTO Item_BandMembers VALUES (DEFAULT, 21, 'Madonna');


INSERT INTO Inventory VALUES (DEFAULT, 1, 'http://localhost:8080/', 1, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 1, 'http://localhost:8080/', 2, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 1, 'http://localhost:8080/', 3, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 1, 'http://localhost:8080/', 4, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 1, 'http://localhost:8080/', 5, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 7, 'http://localhost:8080/', 6, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 8, 'http://localhost:8080/', 7, 'MP3');
INSERT INTO Inventory VALUES (DEFAULT, 9, 'http://localhost:8080/', 8, 'MP3');

COMMIT;
