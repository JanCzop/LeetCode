class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode currentNode = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            int currentSum = 0;
            currentSum += (l1 != null) ? l1.val : 0; 
            currentSum += (l2 != null) ? l2.val : 0;
            currentSum += carry;

            carry = currentSum / 10;
            currentNode.next = new ListNode(currentSum % 10);

            currentNode = currentNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next; 
        }
        return dummy.next;

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
