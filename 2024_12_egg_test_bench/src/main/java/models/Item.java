package models;

import java.math.BigInteger;

import io.ebean.annotation.*;
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @Identity
    private Long id;
    private String name;
    private BigInteger itemNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(BigInteger itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return "item [id : " + id + ", name : " + name + ", itemNumber : " + itemNumber + "]";
    }

}
