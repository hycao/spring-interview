package com.vrv.interview.web;

import com.vrv.interview.domain.Approval;
import com.vrv.interview.dto.ApprovalDTO;
import com.vrv.interview.enums.ApprovalStatusEnum;
import com.vrv.interview.exception.GeneralException;
import com.vrv.interview.service.ApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 审批单资源接口
 *
 * @author hycao
 */
@Slf4j
@RestController
@RequestMapping("/api/approvals")
public class ApprovalResource {

    private final ApprovalService approvalService;

    public ApprovalResource(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    /**
     * 按条件查找
     *
     * @param startTime 审批时间 查询起始时间
     * @param endTime   审批时间 查询结束时间
     */
    @GetMapping("")
    public ResponseEntity<List<Approval>> getApprovalList(@RequestParam(value = "startTime", required = false) LocalDateTime startTime,
                                                          @RequestParam(value = "endTime", required = false) LocalDateTime endTime) {
        List<Approval> approval = approvalService.lambdaQuery()
                // 根据起始时间和结束时间进行查询，不考虑分页
                .ge(startTime != null, Approval::getApprovalTime, startTime)
                .le(endTime != null, Approval::getApprovalTime, endTime)
                .orderByDesc(Approval::getCreateTime)
                .list();
        return ResponseEntity.ok(approval);
    }

    /**
     * 根据 id 查找审批单
     *
     * @param id 审批单号
     */
    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApproval(@PathVariable String id) {
        Optional<Approval> approval = approvalService.lambdaQuery().eq(Approval::getId, id).oneOpt();
        if (!approval.isPresent()) {
            log.info("Approval not found, id={}", id);
            throw new GeneralException("Approval not found");
        }
        return ResponseEntity.ok(approval.get());
    }

    /**
     * 根据 id 删除审批单
     *
     * @param id 审批单号
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeApproval(@PathVariable String id) {
        approvalService.lambdaUpdate().eq(Approval::getId, id).remove();
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

    /**
     * 新增审批单
     *
     * @param approval 审批单类
     */
    @PostMapping()
    public ResponseEntity<?> createApproval(@RequestBody ApprovalDTO approval) {
        approvalService.save(approval.convertApproval());
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    /**
     * 修改审批单
     *
     * @param id       审批单号
     * @param approval 审批单类
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateApproval(@PathVariable String id, @RequestBody ApprovalDTO approval) {
        approvalService.lambdaUpdate().set(Approval::getId, id).update(approval.convertApproval());
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

    /**
     * 根据 id 查找审批单， 设置审批通过
     *
     * @param id 审批单号
     */
    @GetMapping("/{id}/approve")
    public ResponseEntity<?> dealApproval(@PathVariable String id) {
        boolean isUpdated = approvalService.lambdaUpdate().set(Approval::getStatus, ApprovalStatusEnum.APPROVED)
                .eq(Approval::getId, id).update();
        return ResponseEntity.ok(isUpdated);
    }
}
