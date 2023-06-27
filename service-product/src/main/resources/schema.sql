DROP TABLE IF EXISTS tbl_categories;

CREATE TABLE tbl_categories (
                                -- id BIGINT AUTO_INCREMENT not null,
                                -- id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                id BIGINT AUTO_INCREMENT primary key, -- not null,
                                name varchar(50)
);

DROP TABLE IF EXISTS tbl_products;

CREATE TABLE tbl_products (
                              -- id BIGINT AUTO_INCREMENT not null,
                              -- id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              -- id BIGINT PRIMARY KEY, -- exception
                              id BIGINT AUTO_INCREMENT primary key, -- not null, -- generate duplicated
                              name varchar(125),
                              description varchar(255),
                              stock integer,
                              price double,
                              status varchar(25),
                              created_at DATE,
                              category_id BIGINT
);
