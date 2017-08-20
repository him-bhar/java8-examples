package com.himanshu.sample.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstTraversal<V> {
  public void traverse(Node<V> rootNode) {
    Queue<Node<V>> nodeQueue = new ArrayDeque<>();
    nodeQueue.offer(rootNode);
    while(!nodeQueue.isEmpty()) {
      Node<V> current = nodeQueue.poll();
      System.out.println(current.getData());
      if (current.hasChild()) {
        for(Node<V> node : current.getChilds()) {
          nodeQueue.offer(node);
        }
      }
    }
  }

  public static void main(String[] args) {
    Node<Integer> rootNode = new Node<>(1);
    Node<Integer> childLevel_1_1 = new Node<>(2);

    Node<Integer> childLevel_1_2_1 = new Node<>(4);
    Node<Integer> childLevel_1_2_2 = new Node<>(5);
    childLevel_1_1.addChildNode(childLevel_1_2_1);
    childLevel_1_1.addChildNode(childLevel_1_2_2);

    Node<Integer> childLevel_1_2 = new Node<>(3);
    rootNode.addChildNode(childLevel_1_1);
    rootNode.addChildNode(childLevel_1_2);

    BreadthFirstTraversal<Integer> bfs = new BreadthFirstTraversal<>();
    bfs.traverse(rootNode);
  }

}
