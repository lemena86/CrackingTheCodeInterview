package Chapter4.Q4_01_Route_Between_Nodes;

import Chapter4.Graph;
import Chapter4.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Question_1_4 {

    public static void main(String a[]) {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        //temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    static boolean search(Graph g, Node from, Node to) {
        if (from == null || to == null) {
            return false;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(from);
        Node r;
        while (!q.isEmpty()) {
            r = q.remove();
            if (r.equals(to)) return true;
            r.setVisited(true);
            Arrays.stream(r.getAdjacent()).filter(i -> i != null && !i.isVisited()).forEach(q::add);
        }
        return false;
    }
}
