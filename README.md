# spring-interview

spring interview for java
面试后端 **Java 开发** 的编程题目

## 要求

* 时间 < 1.5小时
* 题目考察范围 Java、Spring  Boot 和单元测试
* 有难易程度分级

## 项目配置

本项目采用 Spring Boot + Mysql + Mybatis-plus , 集成 Lombok, 依赖管理采用 Gradle.

全项目接口采用RESTful 开发风格， 代码规范遵循 阿里巴巴Java代码规范

初始化 sql  位置: `src/main/resources/db/init.sql`


## 题目描述

该项目中包含三个分支，分别为 `quartz`、`timezone` 和`ticket`

对应题目如下：

* quartz: 定时器题目
* timezone： 时区问题 
* ticket： 模拟抢票

其中，`quartz(定时器题目)`、`timezone(时区问题)` 为可以联网查询题目，`ticket(模拟抢票)`为不可联网查询问题
