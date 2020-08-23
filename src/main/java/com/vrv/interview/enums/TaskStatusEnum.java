package com.vrv.interview.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 定时任务状态枚举类
 *
 * @author hycao
 */
public enum TaskStatusEnum implements IEnum<String> {

    /**
     * 启动、暂停和停止
     */
    START, PAUSE, STOP;

    @Override
    public String getValue() {
        return this.name();
    }
}
