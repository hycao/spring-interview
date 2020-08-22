package com.vrv.interview.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.vrv.interview.enums.ApprovalStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 审批类
 *
 * @author hycao
 */
@Data
@Accessors(chain = true)
@TableName(value = "approval")
public class Approval {

    /**
     * 审批单号
     */
    @TableId
    private String id;

    /**
     * 审批项目名称
     */
    private String name;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     * 审批状态
     * @see ApprovalStatusEnum
     */
    private ApprovalStatusEnum status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
