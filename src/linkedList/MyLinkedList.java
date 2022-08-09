package linkedList;

class MyLinkedList {
    SinglyLinkedList head; 
    int length = 0; 
    class SinglyLinkedList {
        int val; 
        SinglyLinkedList next; 
        public SinglyLinkedList (int x) { val = x; }
    }
    
    public MyLinkedList() {}
    
    public int get(int index) {
        if (index >= length) {
            return -1; 
        }
        SinglyLinkedList temp = head; 
        int i = 0;
        while (i < index && temp.next != null) {
            temp = temp.next; 
            i++; 
        }
        return temp.val; 
    }
    
    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyLinkedList (val); 
        }
        else {
            SinglyLinkedList curr = new SinglyLinkedList(val); 
            curr.next = head; 
            head = curr; 
        }
        length++; 
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyLinkedList (val); 
        }
        else {
            SinglyLinkedList curr = new SinglyLinkedList(val); 
            SinglyLinkedList temp = head; 
            int i = 0; 
            while (i < length && temp.next != null) {
                temp = temp.next; 
                i++; 
            }
            temp.next = curr; 
            length++; 
        }
    }
    
    public void addAtIndex(int index, int val) {
        if (index == length) {
            addAtTail(val); 
        }
        if (index == 0) {
            addAtHead(val);
        }
        if (index > length) { return; }
        SinglyLinkedList temp = head; 
        int i = 0; 
        while (i < index - 1) {
            temp = temp.next; 
            i++;
        }
        SinglyLinkedList newNode = new SinglyLinkedList(val); 
        newNode.next = temp.next; 
        temp.next = newNode; 
        length++; 
    }
    
    public void deleteAtIndex(int index) {
        if (index >= length || head == null) {return; }
        if (index == 0) {
            head = head.next; 
            return; 

        }
        int i = 0;
        index -= 1;
        SinglyLinkedList temp = head; 
        while (i != index && temp.next != null) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next != null ? temp.next.next : null;
        length--; 
    }
    
    public void printLinkedList(SinglyLinkedList head){
        SinglyLinkedList temp = head;
        while(temp != null) {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
    }
}
