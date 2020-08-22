package com.vrv.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vrv.interview.domain.Approval;
import com.vrv.interview.mapper.ApprovalMapper;
import com.vrv.interview.service.ApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 审批单 Service 实现类
 *
 * @author hycao
 */
@Slf4j
@Service
public class ApprovalServiceImpl extends ServiceImpl<ApprovalMapper, Approval> implements ApprovalService {

}
