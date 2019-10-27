package Chapter4.ListOfDepths;

import util.AssortedMethods;
import util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Q_04_03 {
    static List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        postOrder(1, map, root);
        map.keySet().stream().forEach(key -> System.out.println(key + " " + map.get(key)));
        return null;
    }

    static void postOrder(int depth, Map<Integer, List<TreeNode>> map, TreeNode node) {
        if (node != null) {
            postOrder(depth + 1, map, node.left);
            postOrder(depth + 1, map, node.right);
            addToMap(depth, map, node);
        }
    }

    static void addToMap(int depth, Map<Integer, List<TreeNode>> map, TreeNode node) {
        List<TreeNode> nodes = map.get(depth);
        if (nodes == null) {
            nodes = new LinkedList<>();
        }
        nodes.add(node);
        map.put(depth, nodes);
    }

    public static void main(String... args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        root.print();
        createLevelLinkedList(root);
        // ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        // printResult(list);
    }
}
