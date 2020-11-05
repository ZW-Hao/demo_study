create sequence student_seq
increment by 1
start with 2001;

create sequence teacher_seq
increment by 10
start with 10;

create sequence course_seq
start with 0
increment by 1
maxvalue 100
minvalue 0;