
CREATE TABLE TBL_PERSON(
    ID_PERSON NUMBER(22) NOT NULL PRIMARY KEY,
    NAME_PERSON VARCHAR2(255) NOT NULL,
    GENDER_PERSON CHAR(1) NULL,
    AGE_PERSON NUMBER(3) NULL,
    IDENTITY_DOCUMENT_PERSON VARCHAR2(20) NULL,
    ADDRESS_PERSON VARCHAR2(400) NOT NULL,
    PHONE_PERSON VARCHAR2(12) NOT NULL
);

CREATE TABLE TBL_CLIENT(
    ID_PERSON NUMBER(22) NOT NULL PRIMARY KEY,
    PASSWORD_CLIENT VARCHAR2(20) NOT NULL,
    STATUS_CLIENT NUMBER(1) NOT NULL,
    FOREIGN KEY (ID_PERSON) REFERENCES TBL_PERSON(ID_PERSON) ON DELETE CASCADE
);


CREATE TABLE TBL_ACCOUNT(
    ID_ACCOUNT NUMBER(22) NOT NULL PRIMARY KEY,
    CLIENT_ID_ACCOUNT NUMBER(22) NOT NULL,
    NUMBER_ACCOUNT VARCHAR2(6) NOT NULL,
    TYPE_ACCOUNT VARCHAR2(12) NOT NULL,
    INITIAL_BALANCE_ACCOUNT NUMBER(10,2) NOT NULL,
    CURRENT_BALANCE_ACCOUNT NUMBER(10,2) NOT NULL,
    STATUS_ACCOUNT NUMBER(1) NOT NULL
);
CREATE TABLE TBL_MOVEMENT(
    ID_MOVEMENT NUMBER(22) NOT NULL PRIMARY KEY,
    DATE_MOVEMENT DATE NOT NULL,
    TYPE_MOVEMENT VARCHAR2(10)  NOT NULL,
    VALUE_MOVEMENT NUMBER(10,2) NOT NULL,
    CURRENT_BALANCE_MOVEMENT NUMBER(10,2) NULL,
    STATUS_MOVEMENT NUMBER(1) NOT NULL,
    ACCOUNT_ID_MOVEMENT NUMBER(22) NOT NULL,
    FOREIGN KEY (ACCOUNT_ID_MOVEMENT) REFERENCES TBL_ACCOUNT(ID_ACCOUNT) ON DELETE CASCADE
);


CREATE OR REPLACE VIEW REPORT_MOVEMENTS_ACCOUNT
AS
SELECT
    MOV.ID_MOVEMENT,
    TO_CHAR(MOV.DATE_MOVEMENT,'DD/MM/YYYY') DATE_MOVEMENT,
    CL.NAME_PERSON AS CLIENT,
    CL.ID_PERSON CLIENT_ID,
    ACC.NUMBER_ACCOUNT AS ACCOUNT_NUMBER,
    ACC.TYPE_ACCOUNT,
    ACC.INITIAL_BALANCE_ACCOUNT,
    MOV.STATUS_MOVEMENT,
-- MOV.TYPE_MOVEMENT,
    (CASE WHEN MOV.TYPE_MOVEMENT = 'RETIRO' THEN MOV.VALUE_MOVEMENT*-1 ELSE MOV.VALUE_MOVEMENT END) MOVEMENT,
    ACC.CURRENT_BALANCE_ACCOUNT
FROM TBL_MOVEMENT MOV
    JOIN TBL_ACCOUNT ACC ON ACC.ID_ACCOUNT = MOV.ACCOUNT_ID_MOVEMENT
    JOIN TBL_PERSON CL ON CL.ID_PERSON = ACC.CLIENT_ID_ACCOUNT
ORDER BY DATE_MOVEMENT;

CREATE SEQUENCE SEQ_PERSON START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_ACCOUNT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_MOVEMENT START WITH 1 INCREMENT BY 1;