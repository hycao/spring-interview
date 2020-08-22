package com.vrv.interview.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 审批状态枚举类
 *
 * @author hycao
 */
public enum ApprovalStatusEnum implements IEnum<String> {

    /**
     * PENDING：待处理
     * APPROVED：审批通过
     */
    PENDING, APPROVED;

    @Override
    public String getValue() {
        return this.name();
    }
}
