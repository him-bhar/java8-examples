package com.himanshu.java8.threading;

import java.util.PriorityQueue;
import java.util.Queue;

import org.hamcrest.Matchers;
import org.junit.Assert;

public class PriorityQueueExample {
  
  public static void main(String[] args) {
    Person p1 = new Person("xyz", 30);  // should be first to be polled from queue
    Person p2 = new Person("abc", 10);  // should be last to be polled from queue
    Person p3 = new Person("pqr", 20);  // should be the second to be polled from queue
    
    Queue<Person> queue = new PriorityQueue<>(PriorityQueueExample::comparePerson);
    Assert.assertThat(queue.offer(p1), Matchers.equalTo(true));
    Assert.assertThat(queue.offer(p2), Matchers.equalTo(true));
    Assert.assertThat(queue.offer(p3), Matchers.equalTo(true));
    
    Assert.assertThat(queue.poll(), Matchers.equalTo(p1));
    Assert.assertThat(queue.poll(), Matchers.equalTo(p3));
    Assert.assertThat(queue.poll(), Matchers.equalTo(p2));
  }
  
  //Reverse comparator created
  private static int comparePerson(Person p1, Person p2) {
    return -1*(p1.age - p2.age);
  }
  
  private static class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
    
    public int getAge() {
      return age;
    }
    
    public String getName() {
      return name;
    }
  }

}
