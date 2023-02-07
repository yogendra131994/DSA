class LL {
    private int size;
    private Node head;
    private Node tail;



    private class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;

    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        node.prev = temp;
        temp.next.next.prev = node;
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "<>");
            temp = temp.next;
        }
    }

    public int deleteFirst() {
        if (head == tail) {
            head = null;
            tail = null;
            return 0;
        }
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        head.prev = null;
        size--;
        return val;
    }

    public int deleteLast() {
            if (head == tail) {
                head = null;
                tail = null;
                return 0;
            }
            int val = tail.value;
            tail = tail.prev;
            if (tail == null) {
                head = null;
            }
            tail.next = null;
            size--;
            return val;

        }

    public void reverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + "<>");
            temp = temp.prev;
        }
    }
}
    class DLL {
        public static void main(String[] args) {
            LL list = new LL();
            list.insertFirst(3);
            list.insertFirst(2);
            list.insertLast(4);
            list.insertLast(5);
            list.insert(1, 0);
            list.insert(6, 5);
            list.insert(7, 4);
            list.display();
            System.out.println();
            list.reverse();
        }
    }
