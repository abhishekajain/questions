class MyLinkedList {

    public static class SingleNode{
        int value;
        SingleNode next;
    }

    public static class Node{
        int value;
        Node next;
        Node previous;
    }

    int size = 0;
    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>=this.size){
            return -1;
        }
        int i = 0;
        Node current = this.head;
        while(i<index){
            current = current.next;
            i++;
        }

        return current.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node();
        node.value = val;
        if(this.head != null){
            node.next = head;
            head.previous = node;
        }
        this.head = node;
        if(this.tail == null){
            this.tail = this.head;
        }
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node();
        node.value = val;
        if(this.tail != null){
            node.previous = tail;
            tail.next = node;
        }
        this.tail = node;
        if(this.head == null){
            this.head = this.tail;
        }
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>this.size){
            return;
        }
        if(index == 0){
            this.addAtHead(val);
            return;
        }
        if(index == this.size){
            this.addAtTail(val);
            return;
        }
        int i = 0;
        Node current = this.head;
        while(i<index){
            current = current.next;
            i++;
        }
        Node node = new Node();
        node.value = val;

        node.next = current;
        node.previous = current.previous;
        node.previous.next = node;
        current.previous = node;

        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=this.size){
            return;
        }
        if(index == 0){
            if(this.size == 1){
                this.head = null;
                this.tail = null;
            }else {
                this.head = this.head.next;
                this.head.previous = null;
            }
            this.size--;
            return;
        }

        if(index == this.size-1){
            this.tail = this.tail.previous;
            this.tail.next = null;
            this.size--;
            return;
        }
        int i = 0;
        Node current = this.head;
        while(i<index){
            current = current.next;
            i++;
        }

        Node temp = current.previous;
        temp.next = current.next;
        temp.next.previous = temp;

        this.size--;
    }

    public static SingleNode reverseList(SingleNode head) {
        SingleNode currentNode = head;
        SingleNode previousNode = null;

        while(currentNode!=null){
            SingleNode temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }
        return previousNode;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */