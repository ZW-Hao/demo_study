CREATE TABLE student
(
    sno NUMBER(10) ,
	sname VARCHAR2(10) ,
	ssex VARCHAR2(10) ,
    sage NUMBER ,
    class VARCHAR2(10) 
);
CREATE TABLE course
(
    cno NUMBER(10) ,
	cname VARCHAR2(10) ,
	cteacher VARCHAR2(10) 
);
CREATE TABLE teacher
(
    tno NUMBER(10) ,
	tname VARCHAR2(10) ,
	tsex VARCHAR2(10) ,
    tage NUMBER 
);
CREATE TABLE grade
(
    cno NUMBER ,
    sno NUMBER ,
    grade NUMBER 
);
