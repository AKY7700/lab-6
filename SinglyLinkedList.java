package Lap6_DS_HomeWork.src;

public class SinglyLinkedList<E>{
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int size()
    {
        return size;
    }
    public E first()
    {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last()
    {
        if (isEmpty())
            return null;
        return tail.getElement();
    }
    public void addFirst(E e)
    {
        Node<E> newset = new Node<>(e,head);
        head = newset;
        if (isEmpty())
            tail = newset;
        size++;
    }
    public void addLast(E e)
    {
        Node<E> newset = new Node<>(e,null);
        if (isEmpty())
            head = newset;
        else
        tail.setNext(newset);
        tail = newset;
        size++;
    }
    public E removeFirst()
    {
        if (isEmpty())return null;
        E del = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return del;
    }


    public int size2()              // R-3.9
    {
        Node<E> n = head;
        int c =0;
        while (n!=null)
        {
            c++;
            n = n.getNext();
        }
        return c;
    }


    public void rotate()                            // R-3.12
    {
        addLast(removeFirst());
    }


    public E find()                                 // R-3.6
    {
        if (isEmpty())
            return null;
        else if (size == 1 )
            return head.getElement();
        Node<E> n = head;
        while (n.getNext().getNext() != null)
        {
            n = n.getNext();
        }
        return n.getElement();
    }


    public static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
