# 初始化 sql 脚本

drop table if exists schedule_task;
create table schedule_task (
    `id` bigint(20) NOT NULL COMMENT '主键',
    `jobName` varchar(64) NOT NULL COMMENT '任务名称',
    `description` varchar(255) NOT NULL COMMENT '任务描述',
    `cronExpression` varchar(64) DEFAULT NULL COMMENT '定时表达式',
    `jobClassName` varchar(255) DEFAULT NULL COMMENT '任务对应类全路径',
    `jobStatus` varchar(64) DEFAULT NULL COMMENT '任务状态，启动、暂停或者停止',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;