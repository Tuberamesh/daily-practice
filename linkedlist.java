// /*
// // Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }
// */

// class Solution {

//  public  Node copyRandomList(Node head) {
//     if (head == null) return null;

//     Node curr = head; // Create new list w/ same values
//     while (curr != null) {
//       Node newNode = new Node(curr.val);
//       newNode.next = curr.next;
//       curr.next = newNode;
//       curr = newNode.next;
//     }

//     curr = head; // Copy the random pointers
//     while (curr != null) {
//       if (curr.random != null)
//         curr.next.random = curr.random.next;
//       curr = curr.next.next;
//     }

//     curr = head; // Separate the two lists
//     Node newHead = head.next;
//     Node newCurr = newHead;
//     while (curr != null) {
//       curr.next = newCurr.next;
//       curr = curr.next;
//       if (curr != null) {
//         newCurr.next = curr.next;
//         newCurr = newCurr.next;
//       }
//     }

//     return newHead;
//   }

// }

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // 1. Create copies of each node
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // 2. Assign next and random pointers
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
// 138 question leetcode
