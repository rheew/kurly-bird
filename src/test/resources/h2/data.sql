insert into issue_category(name, modified_date, created_date)
values ('포도', now(), now()),
       ('토마토', now(), now()),
       ('키위', now(), now()),
       ('상추', now(), now()),
       ('배추', now(), now()),
       ('김치', now(), now());


insert into product(created_date, modified_date, name, issue_category_id)
values (now(), now(), '포도 큰 것', 1),
       (now(), now(), '포도 작은 것', 1),
       (now(), now(), '토마토 큰 것', 2),
       (now(), now(), '토마토 작은 것', 2),
       (now(), now(), '키위 작은 것', 3),
       (now(), now(), '키위 큰 것', 3),
       (now(), now(), '상추 작은 것', 4),
       (now(), now(), '상추 큰 것', 4),
       (now(), now(), '배추 작은 것', 5),
       (now(), now(), '배추 큰 것', 5),
       (now(), now(), '김치 작은 것', 6),
       (now(), now(), '김치 중간 것', 6),
       (now(), now(), '김치 큰 것', 6);

insert into product_detail(created_date, modified_date, name, contents, stock_quantity, product_id, price)
values (now(), now(), '포도 큰 것', '맛있어요', 1, 1, 100),
       (now(), now(), '포도 작은 것', '맛있어요', 1, 2, 200),
       (now(), now(), '토마토 큰 것', '맛있어요', 2, 3, 500),
       (now(), now(), '토마토 작은 것', '맛있어요', 2, 4, 500),
       (now(), now(), '키위 작은 것', '맛있어요', 3, 5, 600),
       (now(), now(), '키위 큰 것', '맛있어요', 3, 6, 700),
       (now(), now(), '상추 작은 것', '맛있어요',4, 7, 800),
       (now(), now(), '상추 큰 것', '맛있어요', 4, 8, 900),
       (now(), now(), '배추 작은 것', '맛있어요', 5, 9, 500),
       (now(), now(), '배추 큰 것', '맛있어요', 5, 10, 700),
       (now(), now(), '김치 작은 것', '맛있어요', 6, 11, 300),
       (now(), now(), '김치 중간 것', '맛있어요', 6, 12, 700),
       (now(), now(), '김치 큰 것', '맛있어요', 6, 13, 900);


insert into news(description, pub_date, title, url)
values ('내용입니다.1', now(), '제목입니다.1', 'test'),
       ('내용입니다.2', now(), '제목입니다.2', 'test'),
       ('내용입니다.3', now(), '제목입니다.3', 'test'),
       ('내용입니다.4', now(), '제목입니다.4', 'test');

insert into issue(created_date, modified_date, issue_category_id, news_id)
values (now(), now(), 1, 1),
       (now(), now(), 1, 2),
       (now(), now(), 2, 3),
       (now(), now(), 3, 4);