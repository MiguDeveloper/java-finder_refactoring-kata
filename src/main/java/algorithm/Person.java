package algorithm;

import java.util.Date;

public class Person {
    public String name;
    public Date birthDate;

    public static Person create(String name, Date birthDate){
        Person person = new Person();
        person.name = name;
        person.birthDate = birthDate;

        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

