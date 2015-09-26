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
public class Beverage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private String price;
    private String category;
    private String name;
    private String volume;


    public String getVolume() {
        return volume;
    }
    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    private Beverage()
    {

    }

    public Beverage(Builder build)
    {
        this.volume=build.volume;
        this.price = build.price;
        this.code = build.code;
        this.category = build.category;
        this.name = build.name;
    }

    public static class Builder
    {
        private long code;
        private String volume;
        private String price;
        private String category;
        private String name;

        public Builder volume(String volumeValue)
        {
            this.volume= volumeValue;
            return  this;
        }

        public Builder category(String cateValue)
        {
            this.category= cateValue;
            return this;
        }

        public Builder (long codeValue)
        {
            this.code=codeValue;
        }

        public Builder price(String priceValue)
        {
            this.price=priceValue;
            return this;
        }

        public Builder copy(Beverage value)
        {
            this.category= value.category;
            this.code= value.code;
            this.name= value.name;
            this.volume= value.volume;
            this.price= value.price;
            return this;
        }


        public Builder name(String nameValue)
        {
            this.name=nameValue;
            return this;
        }

        public Beverage build()
        {
            return new Beverage(this);
        }

    }


}
