package ds;

public class LinkedList {
	public ListNode head;
	public LinkedList () {
		head = null;
	}
	/*
	 * Implement the LIST-SEARCH(L, k) function
	 */
	public ListNode search (int k) {
		ListNode start = head;
		if(this.head == null)
			return this.head;
		while (start != null) {
			if(start.key == k) {
			return start;
			}
		start = start.next;
		}
		return null;
	}
	
	/*
	 * Implement the LIST-INSERT(L, x) function
	 * Note that x is a integer value, not a ListNode
	 */
	public void insert (int x) {
		ListNode tempNode = new ListNode(x);
		tempNode.next = this.head;
		tempNode.prev = null;
		if(this.head != null)
			this.head.prev = tempNode;
		this.head = tempNode;
	}
	/*
	 * Implement the LIST-DELETE(L, x) function
	 */
	public void delete (ListNode x) {
		ListNode start = head;
		if(this.head == null) {
			System.out.println("Linked list is empty");
		}
		else {
			while(start != null && start != x) {
				start = start.next;
			}
				if (start == x) {
					ListNode prevNode = x.prev;
					ListNode nextNode = x.next;
					prevNode.next = nextNode;
					nextNode.prev = prevNode;
				}
		}
	}
	
	/*
	 * Convert a LinkedList to a string in the format of [#elements]
	 */
	public String toString () {
		String str;
		ListNode x;
		
		str = "[";
		x = this.head;
		while (x != null) {
			str += x.key + ",";
			x = x.next;
		}
		
		str += "]";
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l;
		
		l = new LinkedList();
		for (int i = 0; i < 5; i++)
			l.insert(i);
		System.out.println(l.toString());
		for (int i = 0; i < 2; i++) 
			l.delete(l.head.next);
		System.out.println(l.toString());
	}

}
