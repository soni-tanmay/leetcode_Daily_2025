// source: https://leetcode.com/problems/redundant-connection/description/?envType=daily-question&envId=2025-01-29
class Solution {

    static class DSU {
        private int[] size;
        private int[] representative;

        // Initialize DSU class, size of each component will be one and each node
        // will be representative of it's own.
        public DSU(int N) {
            size = new int[N];
            representative = new int[N];

            for (int node = 0; node < N; node++) {
                size[node] = 1;
                representative[node] = node;
            }
        }

        // Returns the ultimate representative of the node.
        public int find(int node) {
            if (representative[node] == node) {
                return node;
            }

            return representative[node] = find(representative[node]);
        }

        // Returns true if node nodeOne and nodeTwo belong to different component and
        // update the
        // representatives accordingly, otherwise returns false.
        public boolean doUnion(int nodeOne, int nodeTwo) {
            nodeOne = find(nodeOne);
            nodeTwo = find(nodeTwo);

            if (nodeOne == nodeTwo) {
                return false;
            } else {
                if (size[nodeOne] > size[nodeTwo]) {
                    representative[nodeTwo] = nodeOne;
                    size[nodeOne] += size[nodeTwo];
                } else {
                    representative[nodeOne] = nodeTwo;
                    size[nodeTwo] += size[nodeOne];
                }
                return true;
            }
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;

        DSU dsu = new DSU(N);
        for (int[] edge : edges) {
            // If union returns false, we know the nodes are already connected
            // and hence we can return this edge.
            if (!dsu.doUnion(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[] {}; // This line should theoretically never be reached
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] res = findRedundantConnection(edges);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
