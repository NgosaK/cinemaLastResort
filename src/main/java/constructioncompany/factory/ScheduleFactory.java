package constructioncompany.factory;

import constructioncompany.domain.Schedule;

import java.util.Map;

/**
 * Created by User on 2015/09/24.
 */
public class ScheduleFactory {

    public static Schedule createSchedule(
            Map<String,String> values, long code)
    {
        Schedule schedule= new Schedule
                .Builder(code)
                .title(values.get("title"))
                .duration(values.get("duration"))
                .startTime(values.get("startTime"))
                .endTime()
                .build();

        return schedule;
    }
}
