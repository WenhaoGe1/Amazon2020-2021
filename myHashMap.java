// different key may have same hashCode, which means different <key, value> can be placed into same bucket(same index).
// the jave way to solve this collision is separate chaining. which means every element in nodes array is a single linkedlist
// and different <key, value> chaining in one bucket.

// 1st step: find the index of the key, 
// 2st step: find the right place to insert <key, value> by finding the previous node of available space.
// put(): 
//      if prev is the last node, then inset new node. 
//      if prev.next is existing with same key. then modify the value into value
// get(): 
//      if prev is the last node, then input key is not exist
//      else prev.next is our solution
// remove():
//      if prev.next exists, then we point prev.next into prev.next.next (remove the <key, value> we want)
//      else ignore(<key, value> not exist)


class MyHashMap {
    final ListNode[] nodes; 
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int findIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = findIndex(key);
        
        ListNode prev = find(i, key);
        if (prev.next == null) {
            prev.next = new ListNode(key,value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = findIndex(key);
        if (nodes[i] == null) {
            return -1;
        }
        ListNode prev = find(i, key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = findIndex(key);
        ListNode prev = find(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private ListNode find(int index, int key) {
        if (nodes[index] == null) {
            return nodes[index] = new ListNode(-1, -1);
        }
        ListNode prev = nodes[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */