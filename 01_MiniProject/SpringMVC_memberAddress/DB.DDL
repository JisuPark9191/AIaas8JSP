
관리자 ID: admin PW: 0000 
주소록테스트 ID: test PW: 0000

CREATE TABLE client (
id VARCHAR2(20) PRIMARY KEY,
pw VARCHAR2(20),
name VARCHAR2(20),
phone VARCHAR2(20),
eMail VARCHAR2(20),
address VARCHAR2(50),
rDate date,
memo VARCHAR2(100));

INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('admin', '0000', 'ADMIN', 'admin', 'admin','admin', SYSDATE,'admin');

INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test', '0000', 'TEST', 'test', 'test','test', SYSDATE,'test');

INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test224', '0000', 'TEST1', 'test', 'test','test', '2024/04/08','test');
INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test441', '0000', 'TEST1', 'test', 'test','test', '2024/05/08','test');
INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test444', '0000', 'TEST1', 'test', 'test','test', '2024/02/08','test');

INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test215', '0000', 'TEST432', 'test', 'test','test', '2024/09/08','test');
INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test677', '0000', 'TEST521', 'test', 'test','test', '2023/04/08','test');
INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test087', '0000', 'TEST90', 'test', 'test','test', '2022/04/08','test');
INSERT INTO CLIENT (ID, PW, NAME, PHONE, EMAIL, ADDRESS, RDATE, MEMO) VALUES ('test708', '0000', 'TEST128', 'test', 'test','test', '2024/07/10','test');

CREATE TABLE address (
id VARCHAR2(20),
name VARCHAR2(20),
phone VARCHAR2(20) PRIMARY KEY,
email VARCHAR2(30),
address VARCHAR2(50),
addrGroup VARCHAR2(20),
CONSTRAINT ClientId_fk FOREIGN KEY(id) REFERENCES client(id)
ON DELETE CASCADE);

 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test1','1234','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test1','12345','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test1','12347','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test1','12348','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test1','12349','test@test','testAddress','test');

 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test48','1894','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test165','8934','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test494','894534','test@test','testAddress','test');
 INSERT INTO ADDRESS (ID, NAME, PHONE, EMAIL, ADDRESS, ADDRGROUP) VALUES ('test','test155','523134','test@test','testAddress','test');
