package com.vrv.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrv.interview.domain.Book;
import com.vrv.interview.mapper.BookMapper;
import com.vrv.interview.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 图书 Service 实现类
 *
 * @author hycao
 */
@Slf4j
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
