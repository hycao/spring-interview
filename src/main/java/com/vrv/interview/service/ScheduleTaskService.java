package com.vrv.interview.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrv.interview.domain.ScheduleTask;
import com.vrv.interview.mapper.ScheduleTaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 定时任务 Service 类
 *
 * @author hycao
 */
@Slf4j
@Service
public class ScheduleTaskService extends ServiceImpl<ScheduleTaskMapper, ScheduleTask> {

}
