--guestbook 삭제
drop table guestbook;
drop sequence seq_guestbook_no;


--guestbook 테이블 생성
create table guestbook (
    no          number,
    name        varchar2(80),
    password    varchar2(20),
    content     varchar2(2000),
    reg_date    date,
    primary key (no)
);

--시퀀스 생성
create sequence seq_guestbook_no
increment by 1
start with 1
nocache;

--guestbook 전체 출력
select no
        ,name
        ,password
        ,content
        ,to_char(reg_date, 'YYYY-MM-DD HH:MI:SS') "reg_date"
from guestbook;

select *
from guestbook;

insert into guestbook
values (seq_guestbook_no.nextval, 'June', '1234', '우히히', to_date('2022-06-09 00:12:12','YYYY-MM-DD HH:MI:SS'));

-- 커밋 --
commit;

--롤백--
rollback;