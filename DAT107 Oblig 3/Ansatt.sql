DROP SCHEMA IF EXISTS Ansatt CASCADE;
CREATE SCHEMA Ansatt;
SET search_path TO Ansatt;

CREATE TABLE Ansatt
(
  Id          SERIAL,
  Brukernavn  CHAR(4) UNIQUE,
  Fornavn     VARCHAR(30),
  Etternavn   VARCHAR(30),
  AnsDato     DATE,
  Stilling    VARCHAR(30),
  MndLonn     NUMERIC(10,2),
  Avdeling    VARCHAR(30) NOT NULL,
  Prosjekt    VARCHAR(30),

  CONSTRAINT Ansatt_PK PRIMARY KEY (Id)
);

CREATE TABLE Avdeling
(
  AvdId       SERIAL,
  Navn        VARCHAR(30),
  Sjef        INT NOT NULL,

  CONSTRAINT Avdeling_PK PRIMARY KEY (AvdId),
  CONSTRAINT Ansatt_FK FOREIGN KEY (Sjef) REFERENCES Ansatt(Id)
);

CREATE TABLE Prosjekt
(
  ProsjektId  SERIAL,
  Navn        VARCHAR(30),
  Besrkivelse VARCHAR(100),

  CONSTRAINT ProsjektId_PK PRIMARY KEY (ProsjektId)
);

CREATE TABLE ProsjektDeltaker
(
  ProsjektDelId SERIAL,
  AnsattId      INT,
  Prosjektid    INT,
  rolle         VARCHAR(30),
  timer         INT,

  CONSTRAINT ProsjektDelId_PK PRIMARY KEY (ProsjektDelId),
  CONSTRAINT ProsjektId_FK FOREIGN KEY (Prosjektid) REFERENCES Prosjekt(ProsjektId),
  CONSTRAINT Ansatt_FK FOREIGN KEY (AnsattId) REFERENCES Ansatt(Id)
);

INSERT INTO Ansatt(Brukernavn, Fornavn, Etternavn, AnsDato, Stilling, MndLonn, Avdeling)
VALUES
    ('HK1', 'Hokon', 'Kimsen', '20.01.2022', 'Assistent', 350000, 1),
    ('HK2', 'Hans', 'Kims', '20.01.2022', 'Bilman', 350000, 2),
    ('KF1', 'Kim', 'Fimsen', '10.02.2022', 'Strikkhopper', 320000, 3),
    ('FJ1', 'Finn', 'Johnson', '20.01.2022', 'Assistent', 300000, 1),
    ('JJ1', 'John', 'Johnson', '20.03.2022', 'Bilman', 350000, 2),
    ('SS1', 'Sander', 'Strikkmann', '12.02.2022', 'Strikkhopper', 300000, 3),
    ('HT1', 'Harald', 'Timmsen', '18.01.2022', 'Assistent', 350000, 1),
    ('FT1', 'Frode', 'Timmsen', '15.01.2022', 'Bilman', 290000, 2),
    ('JT1', 'Jon', 'Tare', '20.04.2022', 'Strikkhopper', 350000, 3);

INSERT INTO Prosjekt(Navn, Besrkivelse)
VALUES
    ('Prosjekt1', 'Veldig kule folk'),
    ('Prosjekt2', 'Litt kule folk'),
    ('Prosjekt3', 'Nokso kule folk');

INSERT INTO ProsjektDeltaker(AnsattId, ProsjektId, rolle, timer)
VALUES
    (1,1, 'Skriver paa papir', 2),
    (2,1, 'Sjaafor', 10),
    (3,1, 'Hopper strikk', 20),
    (1,2, 'Skriver paa papir', 2),
    (2,2, 'Sjaafor', 10),
    (3,2, 'Hopper strikk', 20),
    (1,3, 'Skriver paa papir', 2),
    (2,3, 'Sjaafor', 10),
    (3,3, 'Hopper strikk', 20);

INSERT INTO Avdeling(Navn, Sjef)
VALUES
    ('Avdeling1', 1),
    ('Avdeling2', 2),
    ('Avdeling3', 3);

ALTER TABLE Avdeling
ADD FOREIGN KEY(Sjef) REFERENCES Ansatt(Id);
