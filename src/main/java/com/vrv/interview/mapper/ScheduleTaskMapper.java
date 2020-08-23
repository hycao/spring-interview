package com.vrv.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vrv.interview.domain.ScheduleTask;
import org.springframework.stereotype.Repository;

/**
 * 定时任务 mapper
 *
 * @author hycao
 */
@Repository
public interface ScheduleTaskMapper extends BaseMapper<ScheduleTask> {
}
