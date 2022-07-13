package com.rodtech.javaalgteststips.javaalgteststips.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Person relative;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
