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
public class Manager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String jobTitle;
    private String phoneNumber;
    private String department;
    private String numberOfEmployees;

    private Manager(){}

    public String getDepartment()
    {
        return department;
    }

    public String getNumOfEmployees()
    {
        return numberOfEmployees;
    }
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Manager(Builder build)
    {
        this.numberOfEmployees=build.numberOfEmployees;
        this.department=build.department;
        this.id = build.id;
        this.name = build.name;
        this.jobTitle = build.jobTitle;
        this.phoneNumber = build.phoneNumber;
    }

    public static class Builder
    {
        private String department;
        private String numberOfEmployees;
        private long id;
        private String name;
        private String jobTitle;
        private String phoneNumber;

        public Builder copy(Manager value)
        {
            this.department= value.department;
            this.numberOfEmployees= value.numberOfEmployees;
            this.name= value.name;
            this.id= value.id;
            this.jobTitle= value.jobTitle;
            this.phoneNumber= value.phoneNumber;
            return this;
        }

        public Builder (long idValue)
        {
            this.id=idValue;
        }

        public Builder name(String nameValue)
        {
            this.name=nameValue;
            return this;
        }

        public Builder jobTitle(String jobTitleValue)
        {
            this.jobTitle=jobTitleValue;
            return this;
        }

        public Builder phoneNumber(String value)
        {
            this.phoneNumber=value;
            return this;
        }

        public Builder department(String departmentValue)
        {
            this.department= departmentValue;
            return this;
        }

        public Builder numberOfEmployees(String numEmployees)
        {
            this.numberOfEmployees=numEmployees;
            return this;
        }

        public Manager build()
        {
            return new Manager(this);
        }
    }

}
