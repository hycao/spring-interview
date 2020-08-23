package com.vrv.interview.web;

import com.vrv.interview.domain.ScheduleTask;
import com.vrv.interview.exception.GeneralException;
import com.vrv.interview.service.ScheduleTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 定时任务
 *
 * @author hycao
 */
@Slf4j
@RestController
@RequestMapping("/api/schedule-tasks")
public class ScheduleTaskResource {

    private final ScheduleTaskService scheduleTaskService;

    public ScheduleTaskResource(ScheduleTaskService scheduleTaskService) {
        this.scheduleTaskService = scheduleTaskService;
    }

    /**
     * 按条件查找
     */
    @GetMapping("")
    public ResponseEntity<List<ScheduleTask>> getScheduleTaskList() {
        List<ScheduleTask> scheduleTasks = scheduleTaskService.lambdaQuery()
                // 查询所有任务，不考虑分页
                .orderByDesc(ScheduleTask::getId)
                .list();
        return ResponseEntity.ok(scheduleTasks);
    }

    /**
     * 根据 id 查找任务
     *
     * @param id 任务编号
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleTask> getScheduleTask(@PathVariable String id) {
        Optional<ScheduleTask> scheduleTask = scheduleTaskService.lambdaQuery().eq(ScheduleTask::getId, id).oneOpt();
        if (!scheduleTask.isPresent()) {
            log.info("ScheduleTask not found, id={}", id);
            throw new GeneralException("ScheduleTask not found");
        }
        return ResponseEntity.ok(scheduleTask.get());
    }

    /**
     * 根据 id 删除任务
     *
     * @param id 任务编号
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeScheduleTask(@PathVariable String id) {
        scheduleTaskService.lambdaUpdate().eq(ScheduleTask::getId, id).remove();
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

    /**
     * 新增任务
     *
     * @param scheduleTask 任务类
     */
    @PostMapping()
    public ResponseEntity<?> createScheduleTask(@RequestBody ScheduleTask scheduleTask) {
        scheduleTaskService.save(scheduleTask);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    /**
     * 修改任务
     *
     * @param id           任务编号
     * @param scheduleTask 任务类
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateScheduleTask(@PathVariable String id, @RequestBody ScheduleTask scheduleTask) {
        scheduleTaskService.lambdaUpdate().set(ScheduleTask::getId, id).update(scheduleTask);
        return ResponseEntity.ok(ResponseEntity.accepted());
    }

}
