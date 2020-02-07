package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.CoupleByCriteriaFinder;
import algorithm.Person;

import static org.junit.Assert.*;

public class CoupleByCriteriaFinderTests {

    Person sue = new Person("Sue", new Date(50, 0, 1));
    Person greg = new Person("Greg", new Date(52, 5, 1));
    Person sarah = new Person("Sarah", new Date(82, 0, 1));
    Person mike = new Person("Mike", new Date(79, 0, 1));

    @Test
    public void Returns_Empty_Couple_When_Given_Empty_List() {
        List<Person> list = new ArrayList<Person>();
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closed);
        assertFalse(couple.isPresent());
    }

    @Test
    public void Returns_Empty_Couple_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closed);

        assertFalse(couple.isPresent());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closed);

        assertTrue(couple.isPresent());
        assertEquals(sue, couple.get().youngest);
        assertEquals(greg, couple.get().oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Farthest);

        assertTrue(couple.isPresent());
        assertEquals(greg, couple.get().youngest);
        assertEquals(mike, couple.get().oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Farthest);

        assertTrue(couple.isPresent());
        assertEquals(sue, couple.get().youngest);
        assertEquals(sarah, couple.get().oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closed);

        assertTrue(couple.isPresent());
        assertEquals(sue, couple.get().youngest);
        assertEquals(greg, couple.get().oldest);
    }

}
