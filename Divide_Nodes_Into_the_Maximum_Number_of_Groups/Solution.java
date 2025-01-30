// source: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/?envType=daily-question&envId=2025-01-30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // Main function to calculate the maximum number of magnificent sets
    public static int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            // Transition to 0-index
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }
        // 1 -> 2,4,5
        // 2 -> 1,3,6
        // 3 -> 2
        // 4 -> 6
        // 5 -> 1
        // 6 -> 2,4

        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        // -1,-1,-1,-1,-1,-1
        for (int node = 0; node < n; node++) {
            if (colors[node] != -1)
                continue;
            // Start coloring from uncolored nodes
            colors[node] = 0;
            // 0,-1,-1,-1,-1,-1
            // If the graph is not bipartite, return -1
            if (!isBipartite(adjList, node, colors))
                return -1;
        }
        // 0,1,0,1,1,0
        // Calculate the longest shortest path for each node
        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestShortestPath(adjList, node, n);
        }
        // 3,3,4,4,4,4

        // Calculate the total maximum number of groups across all components
        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (visited[node])
                continue;
            // Add the number of groups for this component to the total
            maxNumberOfGroups += getNumberOfGroupsForComponent(
                    adjList,
                    node,
                    distances,
                    visited);
        }

        return maxNumberOfGroups;
    }

    // Checks if the graph is bipartite starting from the given node
    private static boolean isBipartite(
            ArrayList<ArrayList<Integer>> adjList,
            int node,
            int[] colors) {
        for (int neighbor : adjList.get(node)) {
            // If a neighbor has the same color as the current node, the graph is not
            // bipartite
            if (colors[neighbor] == colors[node])
                return false;

            // If the neighbor is already colored, skip it
            if (colors[neighbor] != -1)
                continue;

            // Assign the opposite color to the neighbor
            colors[neighbor] = (colors[node] + 1) % 2;
            // Recursively check bipartiteness for the neighbor; return false if it fails
            if (!isBipartite(adjList, neighbor, colors))
                return false;
        }
        // 0,1,0,1,1,0
        // If all neighbors are properly colored, return true
        return true;
    }

    // Computes the longest shortest path (height) in the graph starting from the
    // source node
    private static int getLongestShortestPath(
            ArrayList<ArrayList<Integer>> adjList,
            int srcNode,
            int n) {
        // Initialize a queue for BFS and a visited array
        Queue<Integer> nodesQueue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];

        nodesQueue.add(srcNode);
        visited[srcNode] = true;
        int distance = 0;
        // Perform BFS layer by layer
        while (!nodesQueue.isEmpty()) {
            // Process all nodes in the current layer
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();

                // Visit all unvisited neighbors of the current node
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor])
                        continue;
                    visited[neighbor] = true;
                    nodesQueue.add(neighbor);
                }
            }
            // Increment the distance for each layer
            distance++;
            // 3,3,4,4,4,4
        }
        // Return the total distance (longest shortest path)
        return distance;
    }

    // Calculates the maximum number of groups for a connected component
    private static int getNumberOfGroupsForComponent(
            ArrayList<ArrayList<Integer>> adjList,
            int node,
            int[] distances,
            boolean[] visited) {
        // Start with the distance of the current node as the maximum
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        // Recursively calculate the maximum for all unvisited neighbors
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor])
                continue;
            maxNumberOfGroups = Math.max(
                    maxNumberOfGroups,
                    getNumberOfGroupsForComponent(
                            adjList,
                            neighbor,
                            distances,
                            visited));
        }
        return maxNumberOfGroups;
    }

    public static void main(String[] args) {
        int result = magnificentSets(6, new int[][] { { 1, 2 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 3 }, { 4, 6 } });
        System.out.println(result);
    }
}