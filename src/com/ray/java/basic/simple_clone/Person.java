package com.ray.java.basic.simple_clone;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dangdang on 6/22/16.
 */
public class Person implements Serializable {

    private String name;

    private Person parent;

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        if (obj instanceof Person) {
            if (this.name.equals(((Person) obj).name)
                    && this.parent.name.equals(((Person) obj).parent.name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        Person person = new Person("大儿子");
//        person.setParent(new Person("父亲"));
//
//        Person person1 = CloneUtils.clone(person);
//        person1.setName("小儿子");
//        person.parent.name = "干爹";
//        System.out.println("person:" + person.name + " parent:" + person.parent.name);
//        System.out.println("person1:" + person1.name + " parent:" + person1.parent.name);

        Map<String, Person> maps = new HashMap<>();
        Person person1  = new Person("张三");
        maps.put("person1",person1);

        System.out.println("person: "+maps.toString());

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
