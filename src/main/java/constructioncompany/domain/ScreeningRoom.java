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
public class ScreeningRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numberID;
    private String size;
    private String type;


    public String getSize() {
        return size;
    }

    public long getNumberID() {
        return numberID;
    }

    public String getType() {
        return type;
    }

    private ScreeningRoom()
    {

    }

    public ScreeningRoom(Builder build)
    {
        this.size= build.size;
        this.type= build.type;
        this.numberID=build.numberID;
    }

    public static class Builder
    {
        private String size;
        private String type;
        private long numberID;

        public Builder size(String sizeValue)
        {
            this.size= sizeValue;
            return this;
        }

        public Builder type(String typeValue)
        {
            this.type= typeValue;
            return this;
        }

        public Builder (long numberIDValue)
        {
            this.numberID=numberIDValue;

        }

        public Builder copy(ScreeningRoom value)
        {
            this.size= value.size;
            this.type= value.type;
            this.numberID= value.numberID;
            return this;
        }

        public ScreeningRoom build()
        {
            return new ScreeningRoom(this);
        }

    }
}
