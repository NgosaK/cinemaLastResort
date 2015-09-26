package constructioncompany.services;

import constructioncompany.domain.Schedule;

import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
public interface ScheduleService  {
    List<Schedule> getSchedules();

    Schedule getSchedule(long id);
    Schedule addSchedule(Schedule schedule);
    void removeSchedule(Schedule schedule);
    Schedule updateSchedule(Schedule schedule);
}