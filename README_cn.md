
# ktorm-example-spring-boot

:cn: 简体中文 | :us: [English](README.md)

这是一个把 [Ktorm](https://www.ktorm.org/) 集成到 Spring Boot 中的简单的 demo 项目。

运行这个项目，需要你的电脑上安装了 MySQL 的服务，并先把表结构建好。

建表 SQL 文件在这里：[init-data.sql](init-data.sql)

* 当mysql:mysql-connector-java依赖大于8版本的时候，需要在spring-boot配置文件datasource选项中加入时区配置，否则spring-boot会无法连接上mysql服务器
例如

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ktorm-example&serverTimezone=your_timezone
    username: root
    password: 
```