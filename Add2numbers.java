import utils.ListNode;

class Add2numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result_head = new ListNode(0);
        int carry = 0;
        ListNode curr = result_head;

        while (l1 != null || l2 != null) {
            int first = (l1 != null) ? l1.val : 0;
            int second = (l2 != null) ? l2.val : 0;

            int sum = first + second + carry;
            carry = (sum > 9) ? 1 : 0;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0)
            curr.next = new ListNode(carry);
        return result_head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}