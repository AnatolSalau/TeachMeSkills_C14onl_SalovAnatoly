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
                             name_type_hobby varchar
);
alter  table hobby_types
    add constraint pf_id_hobby_types primary key (id_hobby_types);
/*
 Изменяем колонку hobbies type_hobby тип данных с varchar на int
 */
ALTER TABLE hobbies
    ALTER COLUMN type_hobby TYPE integer USING (type_hobby::integer);
/*
 делаем колонку name_type_hobby внешним ключом - для таблицы hobbies
 */
alter table hobbies
    add constraint fk_type_hobby foreign key (type_hobby) references hobby_types (id_hobby_types);
/*
 удаляем зависимость
 */
alter table hobbies
drop constraint fk_type_hobby;

/*
 Заполняем таблицу hobby_types
 */
insert into hobby_types(id_hobby_types, name_type_hobby) values
(0,'Type hobby 0'),
(1,'Type hobby 1'),
(2,'Type hobby 2'),
(3,'Type hobby 3');

/*
 Заполняем таблицу hobbies
 */
 insert into hobbies (id_hobby, hobby_name, type_hobby) values
(0,'Hobby name 1',0);
/*
 попробуем вставить хобби с типом которого нету в хобби тайпс
 выдаст ошибку Ключ (type_hobby)=(10) отсутствует в таблице "hobby_types".
 */
 /*
  Создать четвертую таблицу для хранения данных о человеке
  и его хобби
Id человека
Id чобби
  */
create table data_human_hobby (
    id_human int,
    id_hobby int
);
/*
 Добавим внешние ключи из таблицы data_human_hobby в таблицу humans, hobbies
 */
alter table data_human_hobby
add constraint fk_human_id foreign key (id_human) references humans (id_user);

alter table data_human_hobby
add constraint fk_hobby_id foreign key (id_hobby) references hobbies (id_hobby);
/*
 delete all rows
 */
delete from hobbies;
delete from hobby_types;

/*Создать 10 записей в таблице для хранения людей.*/
insert into humans (name, gender, DateOfBirth,id_user) values ('Man 01', true, '1950-01-01',0),
                                                      ('Man 02', true, '1960-02-02',1),
                                                      ('Woman 01', false, '1970-03-03',2),
                                                      ('Woman 02', false, '1980-04-04',3),
                                                      ('Woman 03', false, '1990-05-05',4),
                                                      ('Man 03', true, '1990-06-06',5);

/*Создать 2 вида хобби (активное, спокойное)*/
insert into hobby_types (id_hobby_types, name_type_hobby) values (0,'активное'),
                                                                 (1, 'спокойное');

/*Создать несколько хобби (футбол, хоккей, чтение и т.д)*/
insert into hobbies (id_hobby, hobby_name, type_hobby) values (0,'футбол',0),
                                                              (1,'хоккей',0),
                                                              (2,'чтение',1);

/*Создать записи для хранения данных о хобби для каждого человека со следующими условиями

Есть как минимум один человек с несколькими хобби*/
--Man 03
insert into data_human_hobby (id_human, id_hobby) values (5,0),
                                                         (5,1),
                                                         (5,2);
/*Есть хобби которым увлекаются сразу несколько человек*/
--Хоккей увлекает всех женщин Woman 01 Woman 02 Woman 03
insert into data_human_hobby (id_human, id_hobby) values (3,1),
                                                         (3,1),
                                                         (3,1);
/*2 Человека только с пассивным хобби*/
-- Man 01, Man 02
insert into data_human_hobby (id_human, id_hobby) values (0,2),
                                                         (1,2);
/*Вывести всех людей старше какого-либо возраста*/
/*Выведем всех людей родившихся после 1970-03-03
  и до 1990-05-05 */
select name from humans
where DateOfBirth > '1970-03-03' and DateOfBirth < '1990-05-05';
/*Вывести имена всех мужчин*/
select name  from humans where gender is true;
/*Вывести сколько людей каждого пола есть в бд*/
select
       sum(case when gender is true then 1 else 0 end) as man,
       sum(case when gender is true then 1 else 0 end) as woman
       from humans;
/*Вывести информацию о людях и их хобби*/
select Humans.name, hobbies.hobby_name
from data_human_hobby,humans, hobbies
where data_human_hobby.id_hobby =  hobbies.id_hobby
group by Humans.name, hobbies.hobby_name order by name ;

/*Вывести список людей у которых более одного хобби*/
select Humans.name,sum(
    case when data_human_hobby.id_human = Humans.id_user then 1 else 0 end
    ) as quantity
from data_human_hobby,humans, hobbies
where  data_human_hobby.id_human = Humans.id_user
group by hobbies.hobby_name, Humans.name order by name;
/*Вывести список людеby, count(
    case when hobby_types.name_type_hobby ='спокойное' then 1 else 0 end
    )
from hobby_types,hobbй у которых только пассивные хобби (*)*/
select humans.name, hobby_types.name_type_hobby
from data_human_hobby,humans,hobbies,hobby_types
where data_human_hobby.id_human = hobbies.id_hobby and hobby_types.name_type_hobby ='спокойное'
group by hobby_types.name_type_hobby, humans.name order by name;
/*Вывести какое количество активных хобби и пассивных хобби есть в бд*/
select name_type_hobies
where hobbies.type_hobby = hobby_types.id_hobby_types
group by name_type_hobby
order by name_type_hobby;
/*Вывести информацию какое хобби активное а какое пассивное*/
select hobbies.hobby_name, hobby_types.name_type_hobby
from hobbies, hobby_types
where hobbies.type_hobby = hobby_types.id_hobby_types
group by hobbies.hobby_name, hobby_types.name_type_hobby;


