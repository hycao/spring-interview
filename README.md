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

### 定时器 -允许联网

#### 问题描述：

可通过接口，创建、修改、暂停和恢复的定时任务，允许调整定时器定时周期，支持每5秒，每日9点，每周日晚上九点的定时时间修改

默认创建一个循环定时任务：`每一秒打印一次当前时间`

**要求**： 

请根据现有数据库基本查询和示例接口，使用`Quartz` 进行定时器配置管理

并将任务基本信息和状态存储在数据库表`schedule_task`中 

项目启动时需要默认启动当前数据库中存在的任务

**加分要求**：数据库表数量不允许超过五个

**提示**： 
1. 定时时间设定，可以使用 cron表达式实现
2. 不确定的定时器配置参数，按照默认参数进行配置即可
3. 无需额外考虑定时器分组，使用默认组名即可
4. 无需额外考虑定时任务恢复策略
5. 创建定时任务，不支持自定义任务，只支持创建当前默认打印时间任务，即，允许同时出现多个定时任务，执行相同的功能
