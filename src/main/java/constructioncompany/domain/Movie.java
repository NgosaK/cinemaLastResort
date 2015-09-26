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
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String duration;
    private String genre;
    private String title;
    private String price;
    private String type;

    private Movie() {}

    public  String getType()
    {
        return type;
    }
    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }


    public Movie(Builder build)
    {
        this.type= build.type;
        this.id = build.id;
        this.title = build.title;
        this.genre = build.genre;
        this.duration = build.duration;
        this.price = build.price;
    }

    public static class Builder
    {
        private String duration;
        private String genre;
        private String title;
        private String price;
        private  String type;
        private long id;



        public Builder (long idValue)
        {
            this.id=idValue;
        }

        public Builder duration(String durationValue)
        {
            this.duration= durationValue;
            return this;
        }

        public Builder genre (String genreValue)
        {
            this.genre= genreValue;
            return this;
        }

        public Builder title (String titleValue)
        {
            this.title= titleValue;
            return this;
        }

        public Builder price(String priceValue)
        {
            this.price=priceValue;
            return this;
        }

        public Builder copy(Movie value)
        {
            this.duration= duration;
            this.genre= genre;
            this.title= title;
            this.price= price;
            this.type= type;
            return this;
        }

        public Builder type(String typeValue)
        {
            this.type=typeValue;
            return this;
        }

        public Movie build()
        {
            return new Movie(this);
        }


    }


}
