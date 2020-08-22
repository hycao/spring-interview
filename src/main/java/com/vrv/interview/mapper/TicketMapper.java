package com.vrv.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vrv.interview.domain.Ticket;
import org.springframework.stereotype.Repository;

/**
 * 门票 mapper
 *
 * @author hycao
 */
@Repository
public interface TicketMapper extends BaseMapper<Ticket> {
}
