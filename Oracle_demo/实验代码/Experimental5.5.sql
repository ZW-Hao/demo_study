-- create view v1 as 
-- select student.sno,sname,course.cno,cname,tname,grade
-- from student,course,teacher,grade
-- where student.sno=grade.sno and grade.cno=course.cno and teacher.tname=course.cteacher;

-- select avg(grade) 
-- from v1,student
-- where ssex='woman' and v1.sno=student.sno;

select count(cname)
from v1
where grade<60
group by cno;