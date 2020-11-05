alter table student
add constraint sno_pk
primary key(sno);

alter table course
add constraint cno_pk
primary key(cno);

alter table teacher
add constraint tno_pk
primary key(tno);


alter table student modify sname not null;
alter table course modify cname not null;
alter table teacher modify tname not null;

alter table student add constraint ssex_ck check(ssex in ('man','woman'));
alter table teacher add constraint tsex_ck check(tsex in ('man','woman'));
alter table student add constraint sage_ck check(sage between 0 and 100);
alter table teacher add constraint tage_ck check(tage between 0 and 100);
alter table grade add constraint grade_ck check(grade between 0 and 100);

alter table grade add constraint fk_gradeone foreign key (cno) references course(cno);
alter table grade add constraint fk_gradetwo foreign key (sno) references student(sno);




