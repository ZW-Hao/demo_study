set pagesize 50
set linesize 200
set serveroutput on
/*
输入一个部门编号，如果不存在这个部门，则输出‘您要查找的部门不存在’，否则输出部门的人数和所有员工的姓名。
DECLARE
	CURSOR c1(no NUMBER) IS SELECT (SELECT COUNT(*) FROM emp WHERE deptno = no) c,ename FROM emp WHERE deptno = no;
	v_m emp.deptno%TYPE;
BEGIN
	FOR v_x IN c1(&x) LOOP
		dbms_output.put_line(v_x.c || '--'||v_x.ename);
	END LOOP;
END;
/
输入用户名，设计一个存储过程，根据输入的员工姓名（ename），输出员工的工号，姓名，工资和所在部门的平均工资。
CREATE OR REPLACE PROCEDURE p1(name IN VARCHAR2)
AS
	v_c NUMBER(5);
	v_i emp%ROWTYPE;
BEGIN
	SELECT AVG(sal) INTO v_c FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename = name);
	SELECT * INTO v_i FROM emp WHERE ename = name;
	dbms_output.put_line(v_i.empno||'--'||v_c);
END;
/
设计一个存储过程，该过程接收两个参数：第一个参数是员工编号，第二个数字，功能是将该员工的工资增加（或减少）输入的数字。
CREATE OR REPLACE PROCEDURE p2(no IN NUMBER, value IN NUMBER)
AS
BEGIN
	UPDATE emp SET sal = sal + value WHERE empno = no;
END;
/
设计一个存储过程，根据输入的城市名称，输出所有在该城市工作的员工姓名
CREATE OR REPLACE PROCEDURE p3(name IN VARCHAR2)
AS
	CURSOR c IS SELECT ename FROM emp WHERE deptno IN (SELECT deptno FROM dept WHERE loc = name);
BEGIN
	FOR v_x IN c LOOP
		dbms_output.put_line(v_x.ename);
	END LOOP;
END;
/
用户输入一个员工编号，查询并计算该员工的部门有多少人
CREATE OR REPLACE FUNCTION f1(no IN NUMBER)
RETURN NUMBER
AS
	v_c NUMBER(2);
BEGIN
	SELECT COUNT(*) INTO v_c FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE empno = no);
	RETURN v_c;
END;
/
BEGIN
	dbms_output.put_line(f1(&x));
END;
/
设计一个触发器程序，对dept表的操作执行日志记录，要求如下：
设计一个日志记录的数据库表log，该表记录对dept表执行操作时的信息
当dept表执行插入、删除、修改操作后，在log表中添加一行记录，记录操作类型以及操作时间（SYSDATE）。
CREATE TABLE log
(
	no NUMBER(4) PRIMARY KEY,
	tbl VARCHAR2(100) NOT NULL,
	dtype VARCHAR2(10) NOT NULL,
	dtime DATE NOT NULL
);
*/
CREATE OR REPLACE TRIGGER tr
AFTER INSERT OR DELETE OR UPDATE
ON dept
BEGIN
	IF INSERTING THEN
		INSERT INTO log VALUES((SELECT COUNT(*) FROM log)+1,'dept','INSERT',SYSDATE);
	END IF;
END;
/