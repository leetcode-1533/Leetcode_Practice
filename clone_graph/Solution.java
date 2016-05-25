package clone_graph;

/**
 * Created by y1275963 on 5/25/16.

 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import edu.princeton.cs.algs4.StdOut;
import utility.UndirectedGraphNode;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<Integer, ArrayList<Integer>> labelMap = new HashMap<>();
        dfs(node, labelMap);

        HashMap<Integer, UndirectedGraphNode> newNodeMap = new HashMap<>();
        for (int item : labelMap.keySet()) {
            newNodeMap.put(item, new UndirectedGraphNode(item));
        }

        for (int item : labelMap.keySet()) {
            UndirectedGraphNode newNode = newNodeMap.get(item);
            for (int newNode_nei_label : labelMap.get(item)) {
                newNode.neighbors.add(newNodeMap.get(newNode_nei_label));
            }
        }
        return newNodeMap.get(node.label);
    }

    private void dfs(UndirectedGraphNode Node, HashMap<Integer, ArrayList<Integer>> set) {
        if (!set.containsKey(Node.label)) {
            ArrayList<Integer> nei_labels = new ArrayList<>();
            set.put(Node.label, nei_labels);

            for (UndirectedGraphNode nei : Node.neighbors) {
                nei_labels.add(nei.label);
                dfs(nei, set);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        UndirectedGraphNode test = new UndirectedGraphNode(0);
        test.neighbors.add(test);
        test.neighbors.add(test);


        UndirectedGraphNode res = sol.cloneGraph(test);

        StdOut.println(UndirectedGraphNode.isSameGraph(test, res));


    }
}
