-- 삭제 --
drop table board;
drop sequence seq_board_no;


-- 테이블 생성 my ver --
create table board (
    no      number,
    title   varchar2(500) not null,
    content varchar2(4000),
    hit     number,
    reg_date date not null,
    user_no number not null,
    primary key(no),
    CONSTRAINT fk_user_no foreign key(user_no) 
    references users(no)
    );

    
    
    -- 가은 ver --
        create table board(
        no number
        , title varchar2 (500) not null
        , content varchar2 (4000)
        , hit number
        , reg_date date not null
        , user_no number not null
        , primary key (no)
        , CONSTRAINT board_fk
        FOREIGN KEY (user_no)
        REFERENCES users (no)
    
        
-- 시퀀스 생성 --
create sequence seq_board_no
increment by 1
start with 1
nocache;


-- 인서트 --
insert into board
values(seq_board_no.nextval, '제목', '~ 글 ~', 1, sysdate, 1);


-- 조회 --
select  board.no,
        title,
        content,
        hit,
        to_char(reg_date,'YY-MM-DD HH24:MI') "reg_date",
        user_no,
        users.name
from board, users
where board.user_no = users.no
order by no desc;

SELECT * 
FROM users;

SELECT * 
FROM board;


-- 커밋 --
commit;

-- 롤백 --
rollback;