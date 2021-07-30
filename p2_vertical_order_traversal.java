import java.util.*;

public class p2_vertical_order_traversal {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class Qobject {
    int hd;
    Node node;

    Qobject(int hd, Node node) {
      this.hd = hd;
      this.node = node;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    root.right.right.right = new Node(9);

    System.out.println(Vertical_order_traversal(root));
  }

  public static ArrayList<Integer> Vertical_order_traversal(Node root) {
    ArrayList<Integer> res = new ArrayList<>();

    TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
    int hd = 0;

    Queue<Qobject> Q = new LinkedList<>();
    Q.add(new Qobject(0, root));

    while (!Q.isEmpty()) {
      Qobject temp = Q.poll();
      hd = temp.hd;
      Node node = temp.node;

      if (m.containsKey(hd)) {

        ArrayList<Integer> al = m.get(hd);
        al.add(node.data);
        m.put(hd, al);
      }

      else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(node.data);
        m.put(hd, al);
      }
      if (node.left != null)
        Q.add(new Qobject(hd - 1, node.left));
      if (node.right != null)
        Q.add(new Qobject(hd + 1, node.right));
    }

    for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
      ArrayList<Integer> al = entry.getValue();
      for (Integer i : al) {
        res.add(i);
      }
    }

    return res;
  }
}
