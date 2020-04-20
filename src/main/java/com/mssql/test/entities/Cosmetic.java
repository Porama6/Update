package com.mssql.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Cosmetic")
public class Cosmetic {

        @Id
        @NotNull(message = "Product id cannot be null") 
        @ApiModelProperty(notes = "The database generated product ID")
        @Column(name = "ID")
        private String id;
        @Column(name = "Name")
        @ApiModelProperty(notes = "The Name of the Customer", required = true)
        @NotNull(message = "First Name cannot be null") 
        private String name;
        @Column(name = "amount")
        @ApiModelProperty(notes = "The unit of the product", required = true)
        @Min(value = 1, message = "Please select Amount more than 1")
        @Max(value = 99, message = "Limited selection per person is 99")
        private int amount;

    public Cosmetic(){

    }    

    public Cosmetic(String id, String name, int amount){
        this.id=id;
        this.name=name;
        this.amount=amount;
    }

    public Cosmetic(String id, String name){
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cosmetic [amount=" + amount + ", id=" + id + ", name=" + name + "]";
    }
    


}   