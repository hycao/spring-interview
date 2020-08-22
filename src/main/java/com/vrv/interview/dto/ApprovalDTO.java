package com.vrv.interview.dto;

import com.vrv.interview.domain.Approval;
import com.vrv.interview.enums.ApprovalStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 审批单入参接收类
 *
 * @author hycao
 */
@Data
public class ApprovalDTO {

    /**
     * 审批项目名称
     */
    private String name;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     * 转换 Domain
     */
    public Approval convertApproval() {
        Approval approval = new Approval();
        approval.setName(name)
                .setApprovalTime(approvalTime)
                .setStatus(ApprovalStatusEnum.PENDING);
        return approval;
    }
}
