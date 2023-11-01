package com.ccz.service.impl;

import com.ccz.mapper.ScheduleMapper;
import com.ccz.pojo.Schedule;
import com.ccz.service.ScheduleService;
import com.ccz.utils.PageBean;
import com.ccz.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleServiceImpl(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }


    @Override
    public R page(int pageSize, int currentPage) {

        //分页
        PageHelper.startPage(currentPage,pageSize);

        //查询
        List<Schedule> schedules = scheduleMapper.queryList();

        //分页数据装配
        PageInfo<Schedule> info = new PageInfo<>(schedules);

        //装配PageBean
        PageBean<Schedule> pageBean= new PageBean<>(pageSize,currentPage,info.getTotal(),info.getList());

        R r = R.ok(pageBean);

        return r;
    }

    @Override
    public R remove(Integer id) {
        int rows = scheduleMapper.deleteById(id);
        if(rows>0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R save(Schedule schedule) {

        int rows =scheduleMapper.insert(schedule);

        if(rows>0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        int rows =scheduleMapper.update(schedule);

        if(rows>0){
            return R.ok(null);
        }
        return R.fail(null);
    }
}
