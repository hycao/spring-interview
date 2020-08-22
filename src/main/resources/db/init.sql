# 初始化 sql 脚本

drop table if exists ticket;
create table ticket (
    `id` bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(255) NOT NULL COMMENT '门票名称',
    `nums` int DEFAULT 20 NOT NULL COMMENT '剩余数量',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;