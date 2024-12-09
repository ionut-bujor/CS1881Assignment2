import java.util.Stack;
public class LinkedList {
    private Node head;


    class Node {
        private ProposedSequence payload;
        private Node next;

        private Node(ProposedSequence payload, Node next) {
            this.payload = payload;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
        public ProposedSequence getPayload(){
            return this.payload;
        }
    }


    public LinkedList(){
        head = null;
    }
    public Node getHead(){
        return this.head;
    }
    public void addNode(ProposedSequence payload) {
        Node newNode = new Node(payload, null);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }


    }

    public int getNumCorrect(){
        return 0;
    }
    public int getNumWrongPosition(){
        return 0;
    }
    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        Node current = head;
        Stack<ProposedSequence> stack = new Stack<>();
        while (current != null) {
            stack.push(current.getPayload());
            current = current.getNext();
        }
        while (!stack.isEmpty()) {
            ProposedSequence data = stack.pop();
            LaunchSequence data2 = data.getSequence2();
            stringRepresentation.append(data2 + " (" + "Correct " + data.getNumCorrect() + ", " + "Wrong position " + data.getNumWrongPosition() + ")");
            stringRepresentation.append("\n");
        }

        return stringRepresentation.toString();
    }

}
