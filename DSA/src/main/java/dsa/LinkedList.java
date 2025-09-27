package dsa;

public class LinkedList {
    private Node head;
    private Node tail;
    int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length =1;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println("Conatains:" + temp.value);
            temp= temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            tail.next = newNode; // you have to consider assigning value of pointer also
            this.tail = newNode;
        }
        length ++ ;
    }

    public void getHead(){
        System.out.println("Head :" + head.value);
    }

    public void getTail(){
        System.out.println("Tail:" + tail.value);
    }

    public void getLength(){
        System.out.println("Length :" + length);
    }


}
