package com.ccz.service;

import com.ccz.pojo.Schedule;
import com.ccz.utils.R;

public interface ScheduleService {
    R page(int pageSize, int currentPage);

    R remove(Integer id);

    R save(Schedule schedule);

    R update(Schedule schedule);
}
