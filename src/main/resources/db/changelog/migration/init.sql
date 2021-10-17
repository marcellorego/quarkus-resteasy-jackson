--liquibase formatted sql

--changeset initial:1.1
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(1) from pg_class where relname = 'product_id_seq';
create sequence product_id_seq start 1 increment 1;

--changeset initial:1.2
create table if not exists product (
        id int8 not null,
        code varchar(20) not null,
        name varchar(255) not null,
        created_at timestamp not null,
        updated_at timestamp not null,
        value float8 not null not null,
        primary key (id)
    );

--changeset initial:1.3
alter table if exists product add constraint uk_product_code unique (code);