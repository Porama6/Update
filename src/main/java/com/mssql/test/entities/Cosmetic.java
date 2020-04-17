package com.mssql.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Cosmetic")
public class Cosmetic {

        @Id 
        @Column(name = "ID")
        private String id;
        @Column(name = "Name")
        private String name;
        @Column(name = "amount")
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