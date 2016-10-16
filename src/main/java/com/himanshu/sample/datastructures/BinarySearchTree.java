package com.himanshu.sample.datastructures;

import java.util.Scanner;

public class BinarySearchTree {
  private static class Node<T extends Comparable> {
    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;
    public Node(T value) {
      this.value = value;
    }
  }
  
  private Node<Integer> root;
  
  public BinarySearchTree() {
    root = null;
  }
  
  public void addNode(Integer value) {
    if (root == null) {
      root = new  Node<>(value);
    } else {
      addNode(root, value);
    }
  }

  private void addNode(Node<Integer> node, Integer value) {
    if (value < node.value) {
      if (node.leftNode == null) {
        node.leftNode = new Node<>(value);
      } else {
        addNode(node.leftNode, value);
      }
    } else if (value > node.value) {
      if (node.rightNode == null) {
        node.rightNode = new Node<>(value);
      } else {
        addNode(node.rightNode, value);
      }
    }
  }
  
  public Node<Integer> deleteNode(Integer value) {
    if (root == null) {
      throw new RuntimeException("Tree is empty!");
    } else {
      root = deleteNode(root, value);
    }
    return root;
  }

  private Node<Integer> deleteNode(Node<Integer> node, Integer value) {
    Node<Integer> p, n;
    Node<Integer> lt = node.leftNode;
    Node<Integer> rt = node.rightNode;
    if (node.value == value) {
      if (lt == null && rt == null) {
        return null;
      }
      if (lt == null && rt != null) {
        return rt;
      }
      if (lt != null && rt == null) {
        return lt;
      }
      if (lt != null && rt != null) {
        p = rt;
        //From the right subtree find the left most element.
        while (p.leftNode != null) {
          p = p.leftNode;
        }
        //The node that has to be deleted, replace its data with the node it was supposed to be replaced with.
        node.value = p.value;
        //Delete the replaced with node from the right subtree
        node.rightNode = deleteNode(node.rightNode, p.value);
      }
    } else if (value < node.value) {
      n = deleteNode(node.leftNode, value);
      node.leftNode = n;
    } else if (value > node.value) {
      n = deleteNode(node.rightNode, value);
      node.rightNode = n;
    }
    return node;
  }
  
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    int choice = -1;
    try (Scanner scanner = new Scanner(System.in)) {
      while (choice != 0) {
        System.out.println("~~~~~~~~~~~~  MENU  ~~~~~~~~~~~~");
        System.out.println("1.  Add node");
        System.out.println("2.  Delete node");
        System.out.println("0.  Exit Program");
        System.out.println("~~~~~~~~~~  END MENU  ~~~~~~~~~~");
        choice = scanner.nextInt(); // This won't consume newline character
        scanner.nextLine(); // Dummy call to bypass the previously left-out new
                            // line character
        switch (choice) {
          case 1:
            bst.addNode(scanner.nextInt());
            break;
          case 2:
            bst.deleteNode(scanner.nextInt());
            break;
          case 0:
            break;
          default:
            System.out.println("Not a valid choice! Please retry.");
            continue;
        }
      }
    } finally {
      System.out.println("Ending program.");
    }
  }

}
