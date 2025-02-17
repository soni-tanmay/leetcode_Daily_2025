import java.util.ArrayList;

class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Interleave nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate lists
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}

/*
 * // Definition for a Node.
 * class Node {
 * int val;
 * Node next;
 * Node random;
 * 
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 */

// class Solution {
// public Node copyRandomList(Node head) {
// if (head == null) {
// return null;
// }
// Map<Node, Node> map = new HashMap<>();
// Node current = head;
// while (current != null) {
// map.put(current, new Node(current.val));
// current = current.next;
// }
// current = head;
// while (current != null) {
// Node copy = map.get(current);
// if (current.next != null) {
// copy.next = map.get(current.next);
// } else {
// copy.next = null;
// }

// if (current.random != null) {
// copy.random = map.get(current.random);
// } else {
// copy.random = null;
// }
// current = current.next;
// }
// return map.get(head);

// }
// }