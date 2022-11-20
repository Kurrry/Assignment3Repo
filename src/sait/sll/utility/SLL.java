package sait.sll.utility;

import java.io.Serializable;
import java.util.Objects;

public class SLL implements LinkedListADT, Serializable {
    Node head;
    Node tail;
    private int size;

    public SLL() {

    }

    /**
     * Checks if the list is empty.
     *
     * @return True if it is empty.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds to the end of the list.
     *
     * @param data Data to append.
     */
    @Override
    public void append(Object data) {
        if (head == null) {
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Prepends (adds to beginning) data to the list.
     *
     * @param data Data to store inside element.
     */
    @Override
    public void prepend(Object data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
        if (tail == null) {
            tail = n;
        }
        size++;
    }

    /**
     * Adds a new element at a specific position.
     *
     * @param data  Data that element is to contain.
     * @param index Index to add new element at.
     * @throws IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
     */
    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node current = head;
        Node previous;

        if(index == 0) {
            prepend(data);
            return;
        }

        if(index == this.size() - 1) {
            append(data);
            return;
        }

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
            if (i == index - 1) {
                previous.next = new Node(data, current);
                size++;
            }
        }
    }

    /**
     * Replaces the data  at index.
     *
     * @param data  Data to replace.
     * @param index Index of element to replace.
     * @throws IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
     */
    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        Node current = head;

        if (index == 0) {
            current.element = data;
            return;
        }

        if (index == this.size() - 1) {
            tail.element = data;
            return;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current != null) {
            current.element = data;
        }
    }

    /**
     * Gets the number of elements in the list.
     *
     * @return Size of list (0 meaning empty)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes element at index from list, reducing the size.
     *
     * @param index Index of element to remove.
     * @throws IndexOutOfBoundsException Thrown if index is negative or past the size - 1.
     */
    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        Node current = head;
        Node previous;

        if (index == 0) {
            head = current.next;
            current.next = null;
            size--;
            return;
        }

        for (int i = 0; i <= index; i++) {
            previous = current;
            current = current.next;
            if (i == index - 1) {
                previous.next = current.next;
            }
        }
        size--;
    }

    /**
     * Gets the data at the specified index.
     *
     * @param index Index of element to get.
     * @return Data in element or null if it was not found.
     * @throws IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of the list.
     */
    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        checkIndex(index);

        Node current = head;
        Node previous = null;

        if (index == 0) {
            return current.element;
        }

        if (index == this.size() - 1) {
            return tail.element;
        }

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        if (current.element == null) {
            return Objects.requireNonNull(previous).element;
        }

        return current.element;
    }

    /**
     * Gets the first index of element containing data.
     *
     * @param data Data object to find the first index of.
     * @return First of index of element with matching data or -1 if not found.
     */
    @Override
    public int indexOf(Object data) {
        Node current = head;

        for (int i = 0; i < this.size() - 1; i++) {
            if (data.equals(current.element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Go through elements and check if we have one with data.
     *
     * @param data Data object to search for.
     * @return True if element exists with value.
     */
    @Override
    public boolean contains(Object data) {
        int index = indexOf(data);

        return index >= 0;
    }

    /**
     * Method to simplify exception throwing
     * @param index index being checked
     * @throws IndexOutOfBoundsException if the index is less than 1 or greater than the size of the list - 1
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

     class Node implements Serializable {
        private Object element;
        private Node next;

        /**
         * construct a node with given Object element and next Node
         * @param o Object being used as the element
         * @param next the next logical Node in the list
         */
        public Node(Object o, Node next) {
            element = o;
            this.next = next;
        }

        /**
         * construct a node with the Object element
         * @param o Object being used as the element
         */
        public Node(Object o) {
            element = o;
        }

    }
}
