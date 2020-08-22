# 初始化 sql 脚本

drop table if exists approval;
create table approval (
    `id` bigint(20) NOT NULL COMMENT '主键，审批单号',
    `name` varchar(255) NOT NULL COMMENT '审批项目名称',
    `approvalTime` datetime DEFAULT NULL COMMENT '审批时间',
    `status` varchar(16) NOT NULL COMMENT '审批状态 PENDING：待处理， APPROVED：审批通过',
    `approval_time` datetime DEFAULT NULL COMMENT '审批时间',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;