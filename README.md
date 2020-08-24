# spring-interview

spring interview for java
面试后端 **Java 开发** 的编程题目

## 要求

* 时间 < 1 小时
* 题目考察范围 Java、Spring  Boot 和单元测试
* 有难易程度分级

## 项目配置

本项目采用 Spring Boot + Mysql + Mybatis-plus , 集成 Lombok, 依赖管理采用 Gradle.

全项目接口采用RESTful 开发风格， 代码规范遵循 阿里巴巴Java代码规范

初始化 sql  位置: `src/main/resources/db/init.sql`

### 模拟抢票 -允许联网

#### 问题描述：

请根据已有的增删改查接口和数据库表，模拟一个抢票过程，支持多线程抢票和查询剩余票数

支持退票，退票后其他用户 可以继续进行抢票

**要求**： 

1. 需要考虑多线程和并发问题
2. 模拟100个用户，总票数20，为模拟网络延时后端请设置500ms处理延时
3. 所有人抢到票，就停止抢票，且都有50%概率进行退票，退票后停止抢票  
4. 使用单元测试，来模拟处理情况，进行代码验证
