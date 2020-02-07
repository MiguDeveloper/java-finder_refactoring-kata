package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.CoupleByCriteriaFinder;
import algorithm.Person;

public class CoupleByCriteriaFinderTests {

    Person sue = Person.create("Sue", new Date(50, 0, 1));
    Person greg = Person.create("Greg", new Date(52, 5, 1));
    Person sarah = Person.create("Sarah", new Date(82, 0, 1));
    Person mike = Person.create("Mike", new Date(79, 0, 1));

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<Person>();
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Closed);
        assertEquals(null, result.youngest);

        assertEquals(null, result.oldest);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Closed);

        assertEquals(null, result.youngest);
        assertEquals(null, result.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Closed);

        assertEquals(sue, result.youngest);
        assertEquals(greg, result.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Farthest);

        assertEquals(greg, result.youngest);
        assertEquals(mike, result.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Farthest);

        assertEquals(sue, result.youngest);
        assertEquals(sarah, result.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple result = finder.Find(Criteria.Closed);

        assertEquals(sue, result.youngest);
        assertEquals(greg, result.oldest);
    }

}
