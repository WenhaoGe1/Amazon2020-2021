// dicussion
public class LinkedlistNodeSwapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
	}
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	ListNode swap(ListNode node){
        int count = 0;
        ListNode dummy = node;
        while(dummy != null && dummy.next != null){
            count++;
            dummy = dummy.next.next;
        }
        if(dummy != null) {
            //not even length
            return helper(node, count);
        }
        
        return helper(node, -2);
        
    }
    ListNode helper(ListNode node, int mid){
        if(node == null) return null;
        ListNode dummy = node;
        while(dummy != null && dummy.next != null){
            int temp = dummy.val;
            dummy.val = dummy.next.val;
            dummy.next.val = temp;
            dummy = dummy.next.next;
            mid -= 2;
            if(mid == -1){
                dummy = dummy.next;
            }
        }
        
        return reverse(node);
    }
    ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
	/*
		private int count = 0;
		
		public Node swap(Node root) 
		{
			//first reverse the linked list
			//also record node count as part of this
			Node newRoot = reverse(root);
			
			//remember is even number of nodes and the mid
			boolean evenCount = (count%2==0);
			int mid = count/2-1;
			
			int i=0;		
			Node dummy = new Node(-99);
			dummy.next = newRoot;
			Node curr = dummy;
			//start swapping node pairs
			while(curr != null && curr.next != null)
			{
				//based on the qn, do not touch the mid node if odd number of nodes
				if(!evenCount && i==mid) {
					i += 1;
					curr = curr.next;
					continue;
				}
				
	            //swap pairs of nodes
				Node first = curr.next;
				Node second = first != null ? first.next : null;
				Node third = second != null ? second.next : null;
				if(second != null) {
					curr.next = second;
					second.next = first;
				}
				first.next = third;
				curr = first;
				i += 2;
			}
			return dummy.next;
		}
		
		private Node reverse(Node root) 
		{
			Node curr = root;
			Node prev = null;
			while(curr != null) {
				count++;
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			return prev;
		}
		
		static class Node
		{
			int val;
			Node next;
			
			public Node(int v) {
				val = v;
			}
		}
		*/
	
	

}
