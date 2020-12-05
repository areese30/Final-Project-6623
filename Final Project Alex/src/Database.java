import java.util.*;

public class Database<E>{
        public Node head, tail;

        //constructor method to create a list of object with head, tail, and size.
        public Database()
        {
            head = null;
            tail = null;
        }

        //method add node to end of list
        public void addLastNode(E e)
        {
            if (tail == null)
                head = tail = new Node(e); //empty list
            else
            {
                tail.next = new Node(e); //link new node as last node
                tail = tail.next; //make tail pointer points to last node
            }
        }

        //method #1: add first node
        public void addFirstNode(E e)
        {

            Node newNode = new Node(e); //Creates new node    //complete this method
            newNode.next = head; // link new node to first node
            head = newNode;
            if (tail == null) //if empty list
                tail = head;

        }

        //method #2: add node at index
        public void addAtIndex(int index,E e)
        {
            if (index == 0) //add as first node
                addFirstNode(e);  //complete this method
            else if (index >= countNodes())// add as last node
                addLastNode(e);
            else
            {
                // move pointer current to the correct position
                Node current = head;
                Node temp = head.next; // temp is one step ahead of current
                for (int i = 1; i < index; i++){
                    current = current.next; // advance pointer current one node
                    temp = temp.next; // advance  pointer temp one node
                }
                // link the new node to the list
                current.next = new Node(e); // create new node with data object
                (current.next).next=temp;

            }

        }

        //method #3: remove first node
        public void removeFirstNode()
        {
            if (countNodes() == 0) // if list is empty
                System.out.print("List is empty");
                //complete this method

            else {
                Node temp = head; // temp points to head node
                head = head.next; // head points to second node
                if (head == null)
                    tail = null;
            }
        }

        //method #4: remove last node
        public void removeLastNode()
        {
            if (countNodes() == 0) // if list is empty
                removeFirstNode();

            else if (countNodes() == 1){ // one node list
                Node temp = head;
                head = tail = null;


            }else{
                Node current = head; // current points to head   //complete this method
                for (int i = 0; i < countNodes() - 2; i++){
                    current = current.next; // moves current to second last node
                }
                Node temp = tail; // temp point to tail
                tail = current;   // tail point to current node
                tail.next = null; // set tail.next to null
            }
        }

        //method #5: remove node at index
        public void removeAtIndex(int index)
        {

            if (index < 0 || index  >= countNodes()) // invalid index
                System.out.print("Not available index");
            else if (index == 0) // if first node
                removeFirstNode();
            else if (index == countNodes() -1) // if last node
                removeLastNode();


            else{
                // create and set pointer previous
                Node previous = head;    //complete this method
                for (int i = 1; i < index; i++){
                    previous = previous.next; // move previous to node index-1
                }
                Node current = previous.next; // create  and set pointer current
                previous.next = current.next; // update the links

            }
        }

        //method #6: countNodes
        public int countNodes()
        {
            int listSize= 0;

            Node current = head;// creates node head

            while(current != null) {//complete this method
                //this methods returns the list size
                listSize++; // when it points to a node, listSize goes up
                current = current.next; // moves the pointer to the next node
            }

            return listSize;

        }

        //method #7: printInReverse  (Recursive method)
        public void printInReverse(Node L)
        {
            if (L == null) // sets the list in reverse  //complete this method as recursive methods
                return;

            printInReverse(L.next); // method repeats itself making it recursive

            System.out.print(L.element + "   "  ); // prints the list in reverse order

        }

        //method to print out the list
        public void printList()
        {
            Node temp;
            temp = head;
            while (temp != null)
            {
                System.out.print(temp.element + "   ");
                temp = temp.next;
            }
        }

        public void removeFromCart(E target){
            if (target.equals(head.element)) {
                removeFirstNode();
            } else if (target.equals(tail.element)) {
                removeLastNode();
            } else {
                Node point = head;
                int count = 0;
                while (!target.equals(point)) {
                    point = point.next;
                    count++;
                }
                removeAtIndex(count);
            }
        }

        //class to create nodes as objects
        private class Node
        {
            private E element;  //data field
            private Node next; //link field

            public Node(E e) //constructor method
            {
                element = e;
                next = null;
            }
        }
    }