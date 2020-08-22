package com.vrv.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vrv.interview.domain.Book;
import org.springframework.stereotype.Repository;

/**
 * 图书 mapper
 *
 * @author hycao
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {
}
