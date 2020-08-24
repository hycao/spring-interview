package com.vrv.interview.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 门票类
 *
 * @author hycao
 */
@Data
@TableName(value = "ticket")
public class Ticket {

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 门票名称
     */
    private String name;

    /**
     * 剩余数量
     */
    private Integer nums;

}
