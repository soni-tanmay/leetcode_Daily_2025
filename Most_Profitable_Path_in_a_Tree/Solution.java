import java.util.*;

class Solution {
    int mx = Integer.MIN_VALUE; // Stores the maximum profit possible

    /**
     * Depth First Search (DFS) to calculate the profit from the root (0) to all
     * leaf nodes.
     * It takes into account Bob's distance and adjusts the profit accordingly.
     *
     * @param adj    Adjacency list representation of the tree.
     * @param src    Current node in DFS traversal.
     * @param parent Parent node to prevent backtracking.
     * @param pre    Profit from the parent node.
     * @param dis    Array storing the total profit from the root to each node.
     * @param disB   Array storing Bob's distance from each node.
     * @param amount Array storing the profit amount for each node.
     * @param dd     Distance from the root node (Alice's path).
     */
    public void dfs2(ArrayList<Integer> adj[], int src, int parent, int pre, int dis[], int disB[], int amount[],
            int dd) {
        // Adjust the profit at each node based on Bob's presence:
        if (disB[src] < dd) {
            dis[src] = pre; // If Bob reaches earlier, Alice gets no profit
        } else if (disB[src] == dd) {
            dis[src] = pre + amount[src] / 2; // If Bob and Alice reach at the same time, split profit
        } else {
            dis[src] = pre + amount[src]; // If Alice reaches first, take full profit
        }

        // Recursively traverse child nodes
        for (int i = 0; i < adj[src].size(); i++) {
            if (adj[src].get(i) == parent) // Avoid traversing back to parent
                continue;
            dfs2(adj, adj[src].get(i), src, dis[src], dis, disB, amount, dd + 1);
        }

        // If the node is a leaf (except root), update the max profit
        if (adj[src].size() == 1 && src != 0) {
            mx = Math.max(mx, dis[src]);
        }
    }

    /**
     * DFS to determine Bob's distance from each node in the tree.
     *
     * @param adj    Adjacency list representation of the tree.
     * @param src    Current node being visited.
     * @param parent Parent node to avoid revisiting.
     * @param disB   Array storing Bob's distance from each node.
     * @param pre    Distance from Bob’s starting node.
     * @param d      Target node (Bob’s starting position).
     * @return True if Bob’s path to the root is found.
     */
    boolean dfs(ArrayList<Integer> adj[], int src, int parent, int disB[], int pre, int d) {
        if (src == d) { // If Bob’s start node is found, set the distance
            disB[src] = pre;
            return true;
        }

        // Traverse child nodes
        for (int i = 0; i < adj[src].size(); i++) {
            if (adj[src].get(i) == parent) // Avoid backtracking
                continue;

            if (dfs(adj, adj[src].get(i), src, disB, pre + 1, d)) { // Recursive DFS call
                disB[src] = pre; // Set distance from Bob’s position
                return true;
            }
        }
        return false; // Bob’s path not found
    }

    /**
     * Computes the most profitable path Alice can take from the root (0) to a leaf.
     *
     * @param edges  Tree edges in [node1, node2] format.
     * @param bob    Bob’s starting position.
     * @param amount Array representing profit at each node.
     * @return Maximum profit possible for Alice.
     */
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        mx = Integer.MIN_VALUE; // Reset max profit for each function call
        int n = amount.length;
        ArrayList<Integer>[] adj = new ArrayList[n]; // Create adjacency list representation of tree

        // Initialize adjacency list
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        // Build tree graph from edges
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        int disB[] = new int[n]; // Stores Bob’s distance from each node
        Arrays.fill(disB, Integer.MAX_VALUE); // Initialize Bob’s distances to max value

        int dis[] = new int[n]; // Stores Alice’s profit at each node

        // Find Bob’s distance from the root (0) using DFS
        dfs(adj, bob, -1, disB, 1, 0);

        // Calculate the max profit path for Alice
        dfs2(adj, 0, -1, 0, dis, disB, amount, 1);

        return mx; // Return maximum profit Alice can get
    }
}