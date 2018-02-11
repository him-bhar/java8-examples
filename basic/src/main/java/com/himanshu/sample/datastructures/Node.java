package com.himanshu.sample.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Node<V> {
  private V data;
  private List<Node<V>> nodes;

  public Node(V v) {
    this.data = v;
  }

  public V getData() {
    return data;
  }

  public void setData(V data) {
    this.data = data;
  }

  public void addChildNode(Node<V> node) {
    if (nodes == null) {
      nodes = new ArrayList<>();
    }
    nodes.add(node);
  }

  public List<Node<V>> getChilds() {
    return this.nodes;
  }

  public boolean hasChild() {
    return this.nodes != null && !this.nodes.isEmpty();
  }

}
