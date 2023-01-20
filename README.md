# Проект "Работа мечты"
## Веб-приложение на Spring Boot

## О проекте:
- Приложение работает через интернет-браузер
- Система имеет две модели: вакансии и резюме
- Кандидаты могут публиковать резюме
- HR опубликует вакансии.
- Кандидаты могут подать заявку на работу. 
- Отдел кадров может пригласить кандидата на вакансию.
- Авторизация и аутентификация пользователя.

### Сборка и монтаж:
Создать базу данных "работа мечты"
Измените имя пользователя и пароль вашей базы данных PostgreSQL в 'src/main/resources/app.properties' 
и 'db/liquibase.properties', используя Spring Boot CLI

```shell
mvn spring-boot:run -Dspring-boot.run.arguments=--db=your_database,--user=your_user,--password=your_password,--port=your_port
```
ИЛИ используя свойства по умолчанию(db=dreamjob, user=postgres, password=пароль, порт=8080)

```shell
mvn spring-boot:run
```
3. Go to http://localhost:8080/index

### TODO list
Программа может:
1. Создавайте, читайте, обновляйте вакансиях
2. Создавайте, читайте, обновляйте резюме
3. Создавайте, читайте, обновляйте города
4. Добавлять фотографию кандидату
5. Регистрировать на веб-сайте
6. Авторизоваться на веб-сайте

### Used technologies:
![](https://img.shields.io/badge/Postgresql-42.4.2-green)
![](https://img.shields.io/badge/SpringBoot-2.7.2-important)
![](https://img.shields.io/badge/Servlet-API-brightgreen)
![](https://img.shields.io/badge/Thymeleaf-blue)
![](https://img.shields.io/badge/Java-18.0-blueviolet)
![](https://img.shields.io/badge/H2database-2.1-inactive)
![](https://img.shields.io/badge/JDBC-API-yellow)
![](https://img.shields.io/badge/Junit-4-success)
![](https://img.shields.io/badge/Liquibase-4.15-critical)

### Screenshots
![](src/main/resources/images/registration.png)
![](src/main/resources/images/list_vacancies.png)
![](src/main/resources/images/candidates.png)
![](src/main/resources/images/add_vacancy.png)
![](src/main/resources/images/add_cabdidate.png)