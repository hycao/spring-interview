package com.vrv.interview.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 图书类
 *
 * @author hycao
 */
@Data
@TableName(value = "book")
public class Book {

    /**
     * 图书编号
     */
    @TableId
    private String id;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社名称
     */
    private String publishCompany;

    /**
     * 图书状态，true 可用，false 不可用
     */
    private Boolean status;

    /**
     * 图书价格
     */
    private Double charge;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
