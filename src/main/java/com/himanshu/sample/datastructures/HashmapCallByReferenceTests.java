package com.himanshu.sample.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashmapCallByReferenceTests {
  private static Map<Person, Person> map = new HashMap<>();

  private class Person {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Person{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }
  }

  public static void main(String[] args) {
    Person p = new HashmapCallByReferenceTests().new Person();
    p.setId(10);
    p.setName("Himanshu");


    map.put(p, p);
    System.out.println(map);

    p.setName("Changed");

    Person resultP = map.get(p);
    System.out.println(resultP);

    System.out.println(map);

    Person newP = new HashmapCallByReferenceTests().new Person();
    newP.setId(10);
    newP.setName(null);

    resultP = map.get(newP);
    System.out.println(resultP);

    Map<Person, Person> treeMap = new TreeMap<>();
    treeMap.put(p, p);
  }

}
