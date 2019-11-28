import java.util.*;

public class Queue<Item> extends Assignment2 implements Iterable<Item>  {
    public Node<Item> first;
    public Node<Item> last;
    public static int count;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public Item peek() {
        if (isEmpty()) {}
        return first.item;
    }
    
    public Item poll() {
        if (first == null) {
            return null;
        }

        Item output = first.item;
        first = first.next;

        return output;
    }
    
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
        	first = last;
        else
        	oldlast.next = last;
        count++;
    }
    
    public Item dequeue() {
        if (isEmpty()) {}
        Item item = first.item;
        first = first.next;
        count--;
        if (isEmpty())
        	last = null;
        return item;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
        	return current != null;
        }
        
        public void remove() { 
        	throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
            	throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
