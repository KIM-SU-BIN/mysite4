-- 삭제 --
drop table users;
drop sequence seq_users_no;

-- 테이블 생성 --
create table users (
    no 				number,
    id 				varchar2(20) unique not null,
    password 		varchar2(20) not null,
    name 			varchar2(20),
    gender 			varchar2(10),
    primary key(no)
);

-- 시퀀스 생성 --
create sequence seq_users_no
increment by 1
start with 1
nocache;

-- 인서트 --
insert into users
values(seq_users_no.nextval,'hijava','1234','황일영','male');

-- 조회 --
select * from users;

-- 커밋 --
commit;

-- 롤백 --
rollback;