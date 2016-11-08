-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-11-08 21:03:42.872

-- tables
-- Table: Account
CREATE TABLE IF NOT EXISTS Account (
    Id int NOT NULL,
    Pasword int NULL,
    Active bool NULL,
    Salt int NOT NULL,
    CONSTRAINT Account_pk PRIMARY KEY (Id)
) ENGINE = InnoDB;

-- Table: Agreement
CREATE TABLE IF NOT EXISTS Agreement (
    Id int NOT NULL,
    Start_Date date NULL,
    Name varchar(200) COLLATE utf8_unicode_ci NOT NULL,
    End_Date date NOT NULL,
    CONSTRAINT Agreement_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: AgreementBenefit
CREATE TABLE IF NOT EXISTS AgreementBenefit (
    Agreement_Id int NOT NULL,
    Benefit_Id int NOT NULL,
    CONSTRAINT AgreementBenefit_pk PRIMARY KEY (Agreement_Id, Benefit_Id)
) ENGINE = InnoDB;

-- Table: Benefit
CREATE TABLE IF NOT EXISTS Benefit (
    Id int NOT NULL,
    Description varchar(1000) COLLATE utf8_unicode_ci NULL,
    CONSTRAINT Benefit_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: Graduate
CREATE TABLE IF NOT EXISTS Graduate (
    Id int NOT NULL,
    Charge varchar(200) COLLATE utf8_unicode_ci NOT NULL,
    Employer varchar(500) COLLATE utf8_unicode_ci NOT NULL,
    Office_Adress varchar(200) COLLATE utf8_unicode_ci NOT NULL,
    Office_Phone int NOT NULL,
    User_id int NOT NULL,
    CONSTRAINT Graduate_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: Membership
CREATE TABLE IF NOT EXISTS Membership (
    Id int NOT NULL,
    Start_Dat timestamp NULL,
    Receipt blob NOT NULL,
    PaymentNumber int NOT NULL,
    Account_Id int NOT NULL,
    Rate_id int NOT NULL,
    End_Date timestamp NULL,
    CONSTRAINT Membership_pk PRIMARY KEY (Id)
) ENGINE = InnoDB;

-- Table: Program
CREATE TABLE IF NOT EXISTS Program (
    Id int NOT NULL,
    Name varchar(50) COLLATE utf8_unicode_ci NOT NULL,
    Duration int NULL DEFAULT 10 COMMENT 'En semestres',
    CONSTRAINT Program_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: Rate
CREATE TABLE IF NOT EXISTS Rate (
    Id int NOT NULL,
    Year date NULL,
    Value int NULL,
    CONSTRAINT Rate_pk PRIMARY KEY (Id)
) ENGINE = InnoDB;

-- Table: Request
CREATE TABLE IF NOT EXISTS Request (
    User_Id int NOT NULL,
    Id int NOT NULL AUTO_INCREMENT,
    Date timestamp NULL,
    Comentary varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
    State char(1) NULL DEFAULT "E" COMMENT 'Tipos: Aprobado - "A"; En espera - "E"; Rechazado - "R"',
    CONSTRAINT Request_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: Student
CREATE TABLE IF NOT EXISTS Student (
    Id int NOT NULL,
    User_id int NOT NULL,
    Semester int NULL COMMENT 'Last 3 semesters.',
    CONSTRAINT Student_pk PRIMARY KEY (Id)
) ENGINE = InnoDB;

-- Table: User
CREATE TABLE IF NOT EXISTS User (
    Id int NOT NULL,
    FirstName varchar(200) COLLATE utf8_unicode_ci NULL,
    LastName varchar(200) COLLATE utf8_unicode_ci NULL,
    Email varchar(200) COLLATE utf8_unicode_ci NULL,
    Phone varchar(20) COLLATE utf8_unicode_ci NOT NULL,
    Cellphone varchar(20) COLLATE utf8_unicode_ci NULL,
    Progam_Id int NOT NULL,
    YearGraduate int NOT NULL,
    BirthDate timestamp NOT NULL,
    Period int NOT NULL,
    UNIQUE INDEX Email (Email),
    UNIQUE INDEX Celphone (Cellphone),
    CONSTRAINT User_pk PRIMARY KEY (Id)
) ENGINE = InnoDB COLLATE utf8_unicode_ci;

-- Table: Uses
CREATE TABLE IF NOT EXISTS Uses (
    Account_Id int NOT NULL,
    Agreement_Id int NOT NULL,
    CONSTRAINT Uses_pk PRIMARY KEY (Account_Id, Agreement_Id)
) ENGINE = InnoDB;

-- foreign keys
-- Reference: Account_Uses (table: Uses)
ALTER TABLE Uses ADD CONSTRAINT Account_Uses FOREIGN KEY Account_Uses (Account_Id)
    REFERENCES Account (Id);

-- Reference: Afiliacion_Cuenta (table: Membership)
ALTER TABLE Membership ADD CONSTRAINT Afiliacion_Cuenta FOREIGN KEY Afiliacion_Cuenta (Account_Id)
    REFERENCES Account (Id);

-- Reference: AgreementBenefit_Agreement (table: AgreementBenefit)
ALTER TABLE AgreementBenefit ADD CONSTRAINT AgreementBenefit_Agreement FOREIGN KEY AgreementBenefit_Agreement (Agreement_Id)
    REFERENCES Agreement (Id);

-- Reference: Agreement_Uses (table: Uses)
ALTER TABLE Uses ADD CONSTRAINT Agreement_Uses FOREIGN KEY Agreement_Uses (Agreement_Id)
    REFERENCES Agreement (Id);

-- Reference: Benefit_AgreementBenefit (table: AgreementBenefit)
ALTER TABLE AgreementBenefit ADD CONSTRAINT Benefit_AgreementBenefit FOREIGN KEY Benefit_AgreementBenefit (Benefit_Id)
    REFERENCES Benefit (Id);

-- Reference: Cuenta_User (table: Account)
ALTER TABLE Account ADD CONSTRAINT Cuenta_User FOREIGN KEY Cuenta_User (Id)
    REFERENCES User (Id);

-- Reference: Program_User (table: User)
ALTER TABLE User ADD CONSTRAINT Program_User FOREIGN KEY Program_User (Progam_Id)
    REFERENCES Program (Id);

-- Reference: Request_User (table: Request)
ALTER TABLE Request ADD CONSTRAINT Request_User FOREIGN KEY Request_User (User_Id)
    REFERENCES User (Id);

-- Reference: Tarifa_Afiliacion (table: Membership)
ALTER TABLE Membership ADD CONSTRAINT Tarifa_Afiliacion FOREIGN KEY Tarifa_Afiliacion (Rate_id)
    REFERENCES Rate (Id);

-- Reference: User_Graduate (table: Graduate)
ALTER TABLE Graduate ADD CONSTRAINT User_Graduate FOREIGN KEY User_Graduate (User_id)
    REFERENCES User (Id);

-- Reference: User_Student (table: Student)
ALTER TABLE Student ADD CONSTRAINT User_Student FOREIGN KEY User_Student (User_id)
    REFERENCES User (Id);

-- End of file.

