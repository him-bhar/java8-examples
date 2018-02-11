package com.himanshu.sample.datastructures;

import java.util.Stack;

public class DepthFirstSearch<V> {

  //Root - Left - Right
  public void preOrder(Node<V> rootNode) {
    Stack<Node<V>> nodeStack = new Stack<>();
    nodeStack.push(rootNode);
    while(!nodeStack.isEmpty()) {
      Node<V> current = nodeStack.pop();
      System.out.println(current.getData());
      if(current.hasChild()) {
        //Stack follows LIFO, so to pick left node first we should iterate childs backwards.
        for(int i = current.getChilds().size()-1; i>=0 ;i--) {
          nodeStack.push(current.getChilds().get(i));
        }
      }
    }
  }

  //Left - Root - Right
  public void inOrder(Node<V> rootNode) {
    Stack<Node<V>> nodeStack = new Stack<>();
    Node<V> current = rootNode;

    while(true) {
      while (current != null) {
        nodeStack.push(current);
        current = current.hasChild() ? current.getChilds().get(0) : null;
      }
      if (nodeStack.isEmpty()) {
        return;
      }
      if(current == null && !nodeStack.isEmpty()) {
        Node<V> top = nodeStack.pop();
        System.out.println(top.getData());
        current = top.hasChild() && top.getChilds().size() >= 2 ? top.getChilds().get(1) : null;
      }

    }

  }

  //Left - Right - Root
  public void postOrder(Node<V> rootNode) {
    Stack<Node<V>> nodeStack = new Stack<>();
    Stack<Node<V>> resultStack = new Stack<>();
    nodeStack.push(rootNode);
    while(!nodeStack.isEmpty()) {
      Node<V> current = nodeStack.pop();
      if(current.hasChild()) {
        //Stack follows LIFO, so to pick left node first we should iterate childs backwards.
        /*for(int i = current.getChilds().size()-1; i>=0 ;i--) {
          nodeStack.push(current.getChilds().get(i));
        }*/
        for(Node<V> node : current.getChilds()) {
          nodeStack.push(node);
        }
      }
      resultStack.push(current);
    }
    while (!resultStack.isEmpty()) {
      System.out.println(resultStack.pop().getData());
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

    DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
    //dfs.preOrder(rootNode);
    //dfs.postOrder(rootNode);
    dfs.inOrder(rootNode);
  }
}
