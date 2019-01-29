package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2019/1/16.
 */
public class CloneGraph133 {
    public static void main(String[] args) {

    }
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap();
        return helper(node, map);
    }
    private static UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode nod : node.neighbors) {
            if (map.containsKey(nod.label)) newNode.neighbors.add(map.get(nod.label));
            else newNode.neighbors.add(helper(nod, map));
        }
        return newNode;
    }
}
