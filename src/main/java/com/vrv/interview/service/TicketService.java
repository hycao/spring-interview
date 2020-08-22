package com.vrv.interview.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrv.interview.domain.Ticket;
import com.vrv.interview.mapper.TicketMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 门票 Service 实现类
 *
 * @author hycao
 */
@Slf4j
@Service
public class TicketService extends ServiceImpl<TicketMapper, Ticket> {

}
