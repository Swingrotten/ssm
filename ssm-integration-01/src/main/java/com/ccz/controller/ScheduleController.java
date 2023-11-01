package com.ccz.controller;


import com.ccz.pojo.Schedule;
import com.ccz.service.ScheduleService;
import com.ccz.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * TODO:允许跨域访问
 */
@CrossOrigin
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage){
        R r = scheduleService.page(pageSize, currentPage);
        log.info("查询结果为:{}",r);
        return r;
    }
    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r=scheduleService.remove(id);
        return null;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){

        if(result.hasErrors()){
            return R.fail("参数为NULL,不能保存!");
        }
        R r = scheduleService.save(schedule);
        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){

        if(result.hasErrors()){
            return R.fail("参数为NULL,不能保存!");
        }
        R r = scheduleService.update(schedule);
        return r;
    }
}
