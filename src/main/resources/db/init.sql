# 初始化 sql 脚本

drop table if exists book;
create table book (
    `id` bigint(20) NOT NULL COMMENT '主键',
    `name` varchar(255) NOT NULL COMMENT '图书名称',
    `author` varchar(255) NOT NULL COMMENT '作者',
    `publish_company` varchar(255) DEFAULT NULL COMMENT '出版社名称',
    `status` tinyint DEFAULT true NOT NULL COMMENT '图书状态，true 可用，false 不可用',
    `charge` double(12,4) DEFAULT NULL COMMENT '图书价格',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;