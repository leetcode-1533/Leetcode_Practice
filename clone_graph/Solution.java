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
import java.util.Queue;
import java.util.ArrayDeque;

public class Solution {
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null)
//            return null;
//
//        HashMap<Integer, ArrayList<Integer>> labelMap = new HashMap<>();
//        dfs(node, labelMap);
//
//        HashMap<Integer, UndirectedGraphNode> newNodeMap = new HashMap<>();
//        for (int item : labelMap.keySet()) {
//            newNodeMap.put(item, new UndirectedGraphNode(item));
//        }
//
//        for (int item : labelMap.keySet()) {
//            UndirectedGraphNode newNode = newNodeMap.get(item);
//            for (int newNode_nei_label : labelMap.get(item)) {
//                newNode.neighbors.add(newNodeMap.get(newNode_nei_label));
//            }
//        }
//        return newNodeMap.get(node.label);
//    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> set = new HashMap<>();
        return dfs2(node, set);
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

    private UndirectedGraphNode dfs2(UndirectedGraphNode Node, HashMap<UndirectedGraphNode, UndirectedGraphNode> set) {
        if (!set.containsKey(Node)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(Node.label);
            set.put(Node, newNode);

            for (UndirectedGraphNode neigh : Node.neighbors) {
                UndirectedGraphNode new_neigh = dfs2(neigh, set);
                newNode.neighbors.add(new_neigh);
            }

            return newNode;
        } else {
            return set.get(Node);
        }
    }

    /*
    BFS Version
     */
    public UndirectedGraphNode bfscloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Queue<UndirectedGraphNode> bfsqueue = new ArrayDeque<>();
        bfsqueue.add(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        map.put(node, ans);

        while (!bfsqueue.isEmpty()) {
            UndirectedGraphNode queue_node = bfsqueue.poll();

//            UndirectedGraphNode clone_node = new UndirectedGraphNode(queue_node.label);
//            map.put(queue_node, clone_node);
            UndirectedGraphNode clone_node = map.get(queue_node);

            for (UndirectedGraphNode nei_node : queue_node.neighbors) {
                if (map.containsKey(nei_node))
                    clone_node.neighbors.add(map.get(nei_node));
                else {
                    bfsqueue.add(nei_node);

                    UndirectedGraphNode clone_neigh = new UndirectedGraphNode(nei_node.label);
                    map.put(nei_node, clone_neigh);

                    clone_node.neighbors.add(clone_neigh);
                }
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        UndirectedGraphNode nei0 = new UndirectedGraphNode(0);
        UndirectedGraphNode nei1 = new UndirectedGraphNode(1);
        UndirectedGraphNode nei2 = new UndirectedGraphNode(2);


        nei0.neighbors.add(nei1);
        nei1.neighbors.add(nei0);

        nei1.neighbors.add(nei2);
        nei2.neighbors.add(nei1);

        nei2.neighbors.add(nei2);


        UndirectedGraphNode res = sol.bfscloneGraph(nei0);

        StdOut.println(UndirectedGraphNode.isSameGraph(nei0, res));


    }
}
