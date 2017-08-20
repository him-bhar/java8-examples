package com.himanshu.sample.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ArraylistCallByReferenceTests {
  private static List<Person> list = new ArrayList<>();

  private static class Person {
    private int id;
    private String name;

    @Override
    public String toString() {
      return "Person{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }
  }

  public static void main(String[] args) {
    Person p = new Person();
    p.id = 10;
    p.name = "Himanshu";
    list.add(p);
    System.out.println(list);

    List<Person> list2 = new ArrayList<>(list);
    p.name = "changed";
    p = new Person();
    p.id = 11;
    p.name = "Mama mia";
    list.add(p);

    System.out.println(list);
    System.out.println(list2);
  }

}
