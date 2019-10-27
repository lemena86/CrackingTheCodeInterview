package Chapter4;

import java.util.Objects;

public class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    private boolean visited;

    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Node[adjacentLength];
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addAdjacent(Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(vertex, node.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }
}