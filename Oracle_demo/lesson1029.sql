set serveroutput on
/*

���dept���ݱ����һ����������Ҫ�󵱶�dept��ִ�и��²���ʱ�����deptno�����˱仯����Ҫ��ʱ����emp���е�deptno��



CREATE OR REPLACE TRIGGER tr
AFTER UPDATE 
ON dept
FOR EACH ROW
BEGIN
	IF :NEW.deptno != :OLD.deptno THEN
		UPDATE emp SET deptno = :NEW.deptno WHERE deptno = :OLD.deptno;
	EDN IF;
END;
/
����dept��
����ֻ��������20��Ա��Ϣ��emp��
����һ������emp���empno, ename, deptno�ֶεĿձ�

--CREATE TABLE emp1 AS SELECT * FROM emp;
--CREATE TABLE emp2 AS SELECT * FROM emp WHERE deptno = 20;
--CREATE TABLE emp3 AS SELECT empno,ename,deptno FROM emp WHERE 2>10;

CREATE TABLE stu
(
	id	NUMBER(30)		PRIMARY KEY,
	name	VARCHAR2(20) 	NOT NULL,
	email	VARCHAR2(50)	UNIQUE,
	sex	VARCHAR2(10)	CHECK(sex IN('M','F'))
);

CREATE TABLE stu
(
	id	NUMBER(30)		PRIMARY KEY,
	name	VARCHAR2(20) 	NOT NULL,
	email	VARCHAR2(50),
	sex	VARCHAR2(10),
	CONSTRAINT email_uq UNIQUE(email),
	CONSTRAINT sex_check CHECK(sex IN('M','F'))
);
CREATE TABLE teacher
(
	tid	Number(20)	Primary Key,
   	tname 	Varchar2(40) 	NOT NULL
);
CREATE TABLE course
(
	cid	Number(20)	Primary Key,
   	cname 	Varchar2(40) 	UNIQUE,
	tid	 Number(20),
	CONSTRAINT tid_cst FOREIGN KEY(tid) REFERENCES teacher(tid) ON DELETE SET NULL
);

CREATE SEQUENCE seq
MINVALUE -1
START WITH 0
INCREMENT BY 10;
�˶�Ա����š��������Ա�ѧԺ��
*/
CREATE TABLE sTab
(
	id	NUMBER(3) PRIMARY KEY,
	name VARCHAR2(20) NOT NULL,
	sex VARCHAR2(10) CHECK(sex IN('M','F')),
	sch VARCHAR2(20),
	CONSTRAINT sch_nn NOT NULL(sch)
);

�ɼ���score���ļ��Լ����check��,
CONSTRAINT score_ck CHECK(score BETWEEN 0 AND 10)
