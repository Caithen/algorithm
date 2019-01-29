package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/16.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {label = x; neighbors = new ArrayList<UndirectedGraphNode>();}
}