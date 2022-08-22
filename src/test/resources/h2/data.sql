insert into issue_category(name, modified_date, created_date)
values
('시금치', now(), now()),
('토마토', now(), now()),
('수박', now(), now()),
('상추', now(), now()),
('배추', now(), now()),
('감자', now(), now()),
('깻잎', now(), now()),
('참외', now(), now()),
('파프리카', now(), now()),
('새송이버섯', now(), now());

insert into product(created_date, modified_date, name, contents, issue_category_id)
values
(now(), now(), '시금치 큰 것', '맛있어요', 1),
(now(), now(), '시금치 작은 것', '맛있어요', 1),
(now(), now(), '토마토 큰 것', '맛있어요', 2),
(now(), now(), '토마토 작은 것', '맛있어요', 2),
(now(), now(), '수박 작은 것', '맛있어요', 3),
(now(), now(), '수박 큰 것', '맛있어요', 3),
(now(), now(), '상추 작은 것', '맛있어요', 4),
(now(), now(), '상추 큰 것', '맛있어요', 4),
(now(), now(), '배추 작은 것', '맛있어요', 5),
(now(), now(), '배추 큰 것', '맛있어요', 5),
(now(), now(), '감자 작은 것', '맛있어요', 6),
(now(), now(), '감자 중간 것', '맛있어요', 6),
(now(), now(), '감자 큰 것', '맛있어요', 6),
(now(), now(), '깻잎 큰 것', '맛있어요', 7),
(now(), now(), '참외 큰 것', '맛있어요', 8),
(now(), now(), '파프리카 큰 것', '맛있어요', 9),
(now(), now(), '새송이버섯 큰 것', '맛있어요', 10);


insert into product_detail(created_date, modified_date, name, stock_quantity, product_id, price)
values
(now(), now(), '시금치 큰 것', 1, 1, 100),
(now(), now(), '시금치 작은 것', 1, 2, 200),
(now(), now(), '토마토 큰 것', 2, 3, 500),
(now(), now(), '토마토 작은 것', 2, 4, 500),
(now(), now(), '수박 작은 것', 3, 5, 600),
(now(), now(), '수박 큰 것', 3, 6, 700),
(now(), now(), '상추 작은 것', 4, 7, 800),
(now(), now(), '상추 큰 것', 4, 8, 900),
(now(), now(), '배추 작은 것', 5, 9, 500),
(now(), now(), '배추 큰 것', 5, 10, 700),
(now(), now(), '감자 작은 것', 6, 11, 300),
(now(), now(), '감자 중간 것', 6, 12, 700),
(now(), now(), '감자 큰 것', 6, 13, 900),
(now(), now(), '깻잎 큰 것', 7, 14, 500),
(now(), now(), '참외 큰 것', 8, 15, 600),
(now(), now(), '파프리카 큰 것', 9, 16, 400),
(now(), now(), '새송이버섯 큰 것', 10, 17, 300);

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

insert into category_price_code(issue_category_id, code)
values (1, 213),
       (2, 225),
       (3, 221),
       (4, 214),
       (5, 211),
       (6, 152),
       (7, 253),
       (8, 222),
       (9, 256),
       (10, 317);


insert into file_info(created_date, modified_date, name)
values
(now(), now(), '/img/1.jpg'),
(now(), now(), '/img/2.jpg'),
(now(), now(), '/img/3.jpg'),
(now(), now(), '/img/4.jpg'),
(now(), now(), '/img/5.jpg'),
(now(), now(), '/img/6.jpg'),
(now(), now(), '/img/7.jpg'),
(now(), now(), '/img/8.jpg'),
(now(), now(), '/img/9.jpg'),
(now(), now(), '/img/10.jpg'),
(now(), now(), '/img/11.jpg'),
(now(), now(), '/img/12.jpg'),
(now(), now(), '/img/13.jpg'),
(now(), now(), '/img/14.jpg'),
(now(), now(), '/img/15.jpg'),
(now(), now(), '/img/16.jpg'),
(now(), now(), '/img/17.jpg');

insert into product_image(file_info_id, product_id)
values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17);