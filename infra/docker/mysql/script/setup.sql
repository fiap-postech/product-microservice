create database if not exists product character set utf8mb4 collate utf8mb4_0900_ai_ci;

create user if not exists 'sys_tech_challenge'@'%' identified with mysql_native_password by '6#233zJMNTjkQb#sgps#';

grant all privileges on product.* to 'sys_tech_challenge'@'%';

flush privileges;
