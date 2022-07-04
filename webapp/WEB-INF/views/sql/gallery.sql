--gallery 테이블 삭제
drop table gallery;
--gallery 시퀀스 삭제
drop sequence seq_gallery_no;

--gallery 출력
select *
from gallery;

select no
        ,user_no
        ,content
        ,filePath
        ,orgName
        ,saveName
        ,fileSize
from gallery;


--gallery 테이블 생성
create table gallery (
  no    number,
  user_no   number,
  content   varchar2(1000),
  filePath  varchar2(500),
  orgName   varchar2(200),
  saveName  varchar2(500),
  fileSize  number,
  PRIMARY KEY (no),
  constraint gallery_fk foreign key (user_no)
  references users(no)
);

--gallery 시퀀스 생성
create sequence seq_gallery_no
increment by 1
start with 1
nocache;

commit;

