import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> terminal = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                map.put(i, true);
                count++;
            } else {
                map.put(i, false);
            }
        }
        int newCount = count;
        do {
            count = newCount;
            for (int i = 0; i < graph.length; i++) {
                if (!map.get(i)) {
                    boolean isSafe = true;
                    for (int j = 0; j < graph[i].length; j++) {
                        if (!map.get(graph[i][j])) {
                            isSafe = false;
                            break;
                        }
                    }
                    if (isSafe) {
                        map.put(i, true);
                        newCount++;
                    }
                }
            }
            System.out.println(newCount);
        } while (newCount > count);
        for (Map.Entry<Integer, Boolean> e : map.entrySet()) {
            if (e.getValue())
                terminal.add(e.getKey());
        }
        return terminal;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        List<Integer> res = eventualSafeNodes(graph);
        for (int r : res) {
            System.out.println(r);
        }
    }
}

// Optimized
// class Solution {

// public boolean dfs(
// int node,
// int[][] adj,
// boolean[] visit,
// boolean[] inStack
// ) {
// // If the node is already in the stack, we have a cycle.
// if (inStack[node]) {
// return true;
// }
// if (visit[node]) {
// return false;
// }
// // Mark the current node as visited and part of current recursion stack.
// visit[node] = true;
// inStack[node] = true;
// for (int neighbor : adj[node]) {
// if (dfs(neighbor, adj, visit, inStack)) {
// return true;
// }
// }
// // Remove the node from the stack.
// inStack[node] = false;
// return false;
// }

// public List<Integer> eventualSafeNodes(int[][] graph) {
// int n = graph.length;
// boolean[] visit = new boolean[n];
// boolean[] inStack = new boolean[n];

// for (int i = 0; i < n; i++) {
// dfs(i, graph, visit, inStack);
// }

// List<Integer> safeNodes = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// if (!inStack[i]) {
// safeNodes.add(i);
// }
// }

// return safeNodes;
// }
// }
