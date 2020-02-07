package algorithm;

import java.util.Date;

public class Person {
    public String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Date birthDate() {
        return birthDate;
    }

}

