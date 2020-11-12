set pagesize 50
set linesize 200
set serveroutput on
/*
����һ�����ű�ţ����������������ţ����������Ҫ���ҵĲ��Ų����ڡ�������������ŵ�����������Ա����������
DECLARE
	CURSOR c1(no NUMBER) IS SELECT (SELECT COUNT(*) FROM emp WHERE deptno = no) c,ename FROM emp WHERE deptno = no;
	v_m emp.deptno%TYPE;
BEGIN
	FOR v_x IN c1(&x) LOOP
		dbms_output.put_line(v_x.c || '--'||v_x.ename);
	END LOOP;
END;
/
�����û��������һ���洢���̣����������Ա��������ename�������Ա���Ĺ��ţ����������ʺ����ڲ��ŵ�ƽ�����ʡ�
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
���һ���洢���̣��ù��̽���������������һ��������Ա����ţ��ڶ������֣������ǽ���Ա���Ĺ������ӣ�����٣���������֡�
CREATE OR REPLACE PROCEDURE p2(no IN NUMBER, value IN NUMBER)
AS
BEGIN
	UPDATE emp SET sal = sal + value WHERE empno = no;
END;
/
���һ���洢���̣���������ĳ������ƣ���������ڸó��й�����Ա������
CREATE OR REPLACE PROCEDURE p3(name IN VARCHAR2)
AS
	CURSOR c IS SELECT ename FROM emp WHERE deptno IN (SELECT deptno FROM dept WHERE loc = name);
BEGIN
	FOR v_x IN c LOOP
		dbms_output.put_line(v_x.ename);
	END LOOP;
END;
/
�û�����һ��Ա����ţ���ѯ�������Ա���Ĳ����ж�����
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
���һ�����������򣬶�dept��Ĳ���ִ����־��¼��Ҫ�����£�
���һ����־��¼�����ݿ��log���ñ��¼��dept��ִ�в���ʱ����Ϣ
��dept��ִ�в��롢ɾ�����޸Ĳ�������log�������һ�м�¼����¼���������Լ�����ʱ�䣨SYSDATE����
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