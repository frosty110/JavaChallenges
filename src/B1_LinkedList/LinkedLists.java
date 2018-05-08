package B1_LinkedList;

import org.junit.jupiter.api.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

class PrintLinkedListElements {

}

class NodeTest{

    @Test
    void insertAtTailTest(){
        Node node = new Node(9);

        node = node.InsertAtTail(node, 10);
        assertEquals(Arrays.asList(9,10), Node.print(node));

        node = node.InsertAtTail(null, 10);
        assertEquals(Collections.singletonList(10), Node.print(node));

    }


    @Test
    void insertAtHeadTest(){

        Node node = Node.initNodes(new int[]{5});

        node = node.InsertAtHead(node, 10);
        assertEquals(Arrays.asList(10,5), Node.print(node));

        node = node.InsertAtHead(null, 10);
        assertEquals(Collections.singletonList(10), Node.print(node));

    }

    @Test
    void insertAtPositionTest(){
        Node node = Node.initNodes(new int[]{1,3,7,9});
        assertEquals(Arrays.asList(1, 3, 7, 9), Node.print(node));

        node = node.InsertAtPosition(node, 5, 2);
        assertEquals(Arrays.asList(1, 3, 5, 7, 9), Node.print(node));

        node = node.InsertAtPosition(node, 0, 0);
        assertEquals(Arrays.asList(0, 1, 3, 5, 7, 9), Node.print(node));
    }

    @Test
    void printNullTest(){
        Node.print(null);
    }

    @Test
    void deleteOutOfBounds(){

        Node node = Node.initNodes(new int[]{5, 7, 9});
        assertEquals(Arrays.asList(5, 7, 9), Node.print(node));


        node = node.DeleteAtPosition(node, 5);
        assertEquals(Arrays.asList(5, 7, 9), Node.print(node));

    }


    @Test
    void initNodesTest(){
        Node node = Node.initNodes(new int[]{1,2,3,4,5});
        assertEquals(Arrays.asList(1,2,3,4,5), Node.print(node));
    }

    @Test
    void reverseNodeTest() {
        Node node = Node.initNodes(new int[]{1, 2, 3, 4, 5});

        node.Reverse(node);
        assertEquals(Arrays.asList(5,4,3,2,1), Node.print(node));

    }

    @Test
    void reversePrintTest(){
        Node node = Node.initNodes(new int[]{1,2,3,4,5});
        assertEquals(Arrays.asList(1,2,3,4,5), Node.print(node));
        node.ReversePrint(node);

        node = Node.initNodes(new int[]{1,2});
        assertEquals(Arrays.asList(1,2), Node.print(node));
        node.ReversePrint(node);

        node = Node.initNodes(new int[]{89});
        assertEquals(Arrays.asList(89), Node.print(node));
        node.ReversePrint(node);

        /* testing stack method */

        node = Node.initNodes(new int[]{1,2,3,4,5});
        assertEquals(Arrays.asList(1,2,3,4,5), Node.print(node));
        node.ReversePrintUsingStack(node);

        node = Node.initNodes(new int[]{1,2});
        assertEquals(Arrays.asList(1,2), Node.print(node));
        node.ReversePrintUsingStack(node);

        node = Node.initNodes(new int[]{89});
        assertEquals(Arrays.asList(89), Node.print(node));
        node.ReversePrintUsingStack(node);
    }

    @Test
    void deleteAtPositionTest(){
        Node node = Node.initNodes(new int[]{1, 2, 3, 4, 5, 7, 9});
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7, 9), Node.print(node));

        node = node.DeleteAtPosition(node, 0);
        assertEquals(Arrays.asList(2, 3, 4, 5, 7, 9), Node.print(node));

        node = node.DeleteAtPosition(node, 5);
        assertEquals(Arrays.asList(2, 3, 4, 5, 7), Node.print(node));

        node = node.DeleteAtPosition(node, 2);
        assertEquals(Arrays.asList(2, 3, 5, 7), Node.print(node));

        node = node.DeleteAtPosition(node, 0);
        assertEquals(Arrays.asList(3, 5, 7), Node.print(node));
        node = node.DeleteAtPosition(node, 1);
        assertEquals(Arrays.asList(3, 7), Node.print(node));
        node = node.DeleteAtPosition(node, 0);

        assertEquals(Collections.singletonList(7), Node.print(node));
        node = node.DeleteAtPosition(node, 0);
        assertEquals(Collections.emptyList(), Node.print(node));
    }
}

class Node {
    private int data;
    private Node next;

    private Node(){}
    Node(int data){
        this.data = data;
    }


    static Node initNodes(int[] data){
        Node head = new Node();
        head.data = data[0];

        Node tmpNode = head;
        for (int i = 1; i<data.length; i++){
            Node newNode = new Node();
            newNode.data = data[i];
            tmpNode.next = newNode;
            tmpNode = newNode;
        }

        return head;
    }

    void ReversePrintUsingStack(Node head){
        if (head != null){
            Node temp = head;
            Stack s = new Stack();
            while(temp != null){
                s.push(temp.data);
                temp = temp.next;
            }
            while(!s.empty()){
                System.out.println(s.pop());
            }
        }
    }

    Node Reverse(Node head){
        if (head == null){
            return head;
        } else {
            List<Node> tmpList = new ArrayList<>();
            while (head.next != null){
                System.out.println("head.data = " + head.data);
                tmpList.add(head);
                head = head.next;
            }
            tmpList.add(head);

            Node tmpNode = head;
            for (int i = tmpList.size() -1; i >= 0 ; i --){


                if (i > 0) {
                    System.out.println(  tmpList.get(i).data + " next " + tmpList.get(i - 1).data);
                    head.next = tmpList.get(i - 1);
                }
                head = head.next;
            }
            head.next = null;

            System.out.println("tmpNode.data = " + tmpNode.data);
            System.out.println("tmpNode.next.data = " + tmpNode.next.data);
            return tmpNode;
        }

    }
    void ReversePrint(Node head) {
        if (head == null){
            System.out.println("Null");
        } else {
            List<Integer> tmpList = new ArrayList<>();
            while (head.next != null){
                tmpList.add(head.data);
                head = head.next;
            }
            tmpList.add(head.data);

            for (int i = tmpList.size() -1; i >= 0 ; i --){
                System.out.println(tmpList.get(i));
            }
        }
    }

    Node DeleteAtPosition(Node head, int position){

        if (head == null){
            return null;
        }
        else if (position == 0){
            return head.next;
        }
        else {
            Node tmpNode = head;
            int curPosition = 0;
            while (tmpNode.next != null && curPosition < position-1){
                tmpNode = tmpNode.next;
                curPosition ++;
            }

            // in case the position to delete is greater than the length of the nodes. Don't delete anything.
            if (tmpNode.next != null) {
                tmpNode.next = tmpNode.next.next;
            }
        }

        return head;
    }

    Node InsertAtPosition(Node head, int data, int position){
        Node newNode = new Node();
        newNode.data = data;

        if (position == 0){
            newNode.next = head;
            return newNode;
        }
        else if (head == null) {
            newNode.next = null;
            return newNode;
        }
        else {
            int positionCounter = 0;

            Node tmpNode = head;
            // stop one node before the position
            while (tmpNode.next != null && positionCounter < position-1){

                tmpNode = tmpNode.next;
                positionCounter +=1;
            }

            newNode.next = tmpNode.next;
            tmpNode.next = newNode;
        }

        return head;
    }

    Node InsertAtHead(Node head, int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;


        return newNode;
    }

    Node InsertAtTail(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null){
            head = newNode;
        }
        else {
            Node node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = newNode;
        }
        return head;
    }

    static List<Integer> print(Node head) {
        List<Integer> retList = new ArrayList<>();
        String retPrint = "";
        if (head != null){
            while (head.next != null){
                System.out.println("head.data = " + head.data);
                retPrint += head.data + " -> ";
                retList.add(head.data);
                head = head.next;
            }

            retPrint += head.data + " -> NULL";
            retList.add(head.data);

            System.out.println(retPrint);
        } else {
            System.out.println("NULL");
        }

        return retList;
    }
}
