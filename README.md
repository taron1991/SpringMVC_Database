# project name - SpringMVC_Database

Полноценный веб проект соблюдающий клиент-серверную архитектуру.
В проекте использовались следующие стеки:

 database SQL(PostgreSQl);
 Spring framework(Spring MVC);
 Spring core;
 SpringORM - Hibernate;
 Tag library - JSTL;
 Tag library - Springframework;
 DataBaseConnection - DBCP;

класс - personController,controller обрабатывающий запросы 
класс - Person,model хранящий бизнес логику
класс - PersonService,прослойка между контролером и репозиторием
класс - PersonRepository,взаимодействие с БД
пакет - configs,хранит конфигурационные данные

Проект конфигурирован с применением Spring annotations
