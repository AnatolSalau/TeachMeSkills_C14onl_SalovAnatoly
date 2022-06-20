select current_database();

/*
date
1999-01-08	ISO 8601; 8 января в любом режиме (рекомендуемый формат)
*/
/*
 Создать таблицу для хранения данных о человеке:
- Имя
- Пол
- Дата рождения
 */
create table Humans (
    name varchar,
    gender bool,
    DateOfBirth date
);
/*добавить колонку id primary key*/
alter table humans
add column id_user int
    constraint pk_user_id primary key;
/*
 Создать вторую таблицу для хранения данных о хобби:
- Название хобби
- Тип хобби
 */
 create table hobbies (
     id_hobby int,
     hobby_name varchar,
     type_hobby varchar,
     constraint pk_id_hobby primary key (id_hobby)
 );
/*
 Создать третью таблицу для хранения типа хобби
Имя типа
 */
create table hobby_types (
    id_hobby_types int,
    name_type_hobby varchar,
    constraint pk_hobby_types primary key (id_hobby_types)
);
/* удаляем ограничение*/
alter table hobby_types
    drop constraint pk_hobby_types;
/* удаляем колонку*/
alter table hobby_types
  drop column id_hobby_types;
/*добавляем новое */
alter table hobby_types
    add constraint pk_hobby_type primary key(name_type_hobby);
/**/
alter table hobby_types
    drop constraint pk_hobby_type;
/*
 делаем колонку name_type_hobby внешним ключом - для таблицы hobbies
 */
 alter table hobbies
    add constraint fk_type_hobby foreign key (type_hobby) references hobby_types (id_hobby_types);

/*
 Удаляем зависимость
 */
 alter table hobbies
drop constraint fk_type_hobby;


