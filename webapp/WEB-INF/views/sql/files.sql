--files 테이블 삭제
drop table files;
--file 시퀀스 삭제
drop sequence seq_file_no;

-- 출력
select *
FROM files;

-- ver2
select no
        ,org_name
        ,save_name
        ,path
        ,file_size
from files;

--테이블 생성
create table files (
    no  			number,
    org_name 		varchar2(1000) not null,
    save_name		varchar2(1000) not null,
    path 			varchar2(1000) not null,
    file_size long not null,
    primary key(no)
);

-- 시퀀스 생성
create sequence seq_file_no
increment by 1
start with 1
nocache;

commit;

rollback;