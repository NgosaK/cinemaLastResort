package constructioncompany.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2015/09/24.
 */
@Entity
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String duration ;
    private String title;
    private String startTime;
    private String endTime;

    private Schedule() {}

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public Schedule(Builder build)
    {
        this.duration= build.duration;
        this.title= build.title;
        this.startTime= build.startTime;
        this.endTime= build.endTime;
        this.id=build.id;
    }

    public static class Builder
    {
        private String duration ;
        private String title;
        private String startTime;
        private String endTime;
        private long id;

        public Builder copy(Schedule value)
        {
            this.duration= value.getDuration();
            this.title= value.getTitle();
            this.id= value.getId();
            this.startTime= value.getStartTime();
            this.endTime= value.getEndTime();
            return this;
        }

        public Builder(long idValue)
        {
            this.id=idValue;
        }

        public Builder duration(String durationValue)
        {
            this.duration= durationValue;
            return this;
        }

        public Builder title(String titleValue)
        {
            this.title= titleValue;
            return this;
        }

        public Builder startTime(String startTimeValue)
        {

            this.startTime= startTimeValue;
            return this;
        }

        public Builder endTime()
        {
            this.endTime= startTime + duration;
            return this;
        }

        public Schedule build()
        {
            return new Schedule(this);
        }

    }

}
