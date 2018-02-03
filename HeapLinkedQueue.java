import java.util.*;
// Name : Mayank Chander
// ID : 300384272
/**
 * Write a description of class HeapLinkedQueue here.
 * 
 * @author (Mayank Chander) 
 * @version (a version number or a date)
 */
public class HeapLinkedQueue <E extends Comparable<? super E> > extends AbstractQueue <E>
{
    // instance variables - replace the example below with your own
    private LinkedNode<E> root;
    private LinkedNode<E>tail;
    private int count = 0; //da

    public int size(){
        return count;
    }

    public boolean isEmpty() {

        return (root == null);

    }

    public E peek() {
        /*# YOUR CODE HERE */

        if(root == null) return null;

        return root.getData();

    }

    public boolean offer(E element) {
        /*# YOUR CODE HERE */

        if(element == null) {
            return false;
        }else 
        if(root == null) {
            tail = root = new LinkedNode<E>(element, null, null, null);
            count++;
            return true;
        }else {// add it as a leaf node
            LinkedNode<E> temp = tail;
            while(temp.getParent() != null && temp == temp.getParent().getRight()){ // proceed upwards if parent exists and parent has a right child
                temp = temp.getParent();
            }

            if(temp.getParent() != null){  // if there is no parent, then there are two cases
                if(temp.getParent().getRight() != null){ 

                    temp = temp.getParent().getRight();
                    while(temp.getLeft() != null){
                        temp = temp.getLeft();
                    }
                    // we now know the parent has a right child, then have to as a left leaf node

                }else { // there is no right child so have to insert at the left
                    temp = temp.getParent();
                }
            }else {
                while(temp.getLeft() != null){
                    temp = temp.getLeft();
                }
            }

            LinkedNode<E> newNode = new LinkedNode<E>(element);

            if(temp.getLeft() == null){ // insert left, from the parent
                temp.setLeft(newNode);
            }else { // insert right , from the parent
                temp.setRight(newNode);
            }
            count++;
            tail = newNode;
            tail.setParent(temp);
            bubbleUpFromIndex(tail);
        }        

        return true;
    }

    public E poll() {
        /*# YOUR CODE HERE */

        if(root == null) return null;

        E element = root.getData();

        if(count == 1) { // There is only 1 element in the collection       
            root = tail = null;
        }else {
            LinkedNode<E> newTail = newTail(tail); // this will be the new tail, we moving in a breadth first style , in order preserve the heap property. Balanced or almost balanced
            LinkedNode<E> temp = tail;
            if(tail.getParent().getLeft() == tail){ // item to be moved to root
                tail.getParent().setLeft(null); // set parent right to null
            }else {
                tail.getParent().setRight(null); // else parent left to null
            }
            root.setData(temp.getData()); //  storing the element, not the pointer
            tail = newTail;
            sinkDownFromIndex(root);
        }
        count--;
        return element;
    }

    public LinkedNode<E> newTail(LinkedNode<E> tail) {

        LinkedNode<E> temp = tail;
        while(temp.getParent() != null && temp.getParent().getLeft() == temp){ // check the parent lefts equals to the temp
            temp = temp.getParent();
        }

        if(temp.getParent() != null){   // if parent not null, change to the next subtree
            temp = temp.getParent().getLeft();
        }

        while(temp.getRight() != null){
            temp = temp.getRight();
        }

        return temp;

    }

    private void sinkDownFromIndex(LinkedNode<E> root) {

        LinkedNode<E> node; // variable to hold the higherpriorty out of the left or right child
        if(root == null || root.getLeft() == null && root.getRight() == null){
            return;
        }else if(root.getLeft() != null && root.getRight() != null){
            
            node = root.getLeft().getData().compareTo(root.getRight().getData()) < 0 ? root.getLeft() : root.getRight();
            
        }else if (root.getLeft() == null) {
            node = root.getRight();

        }else {
            node = root.getLeft();
        }

        if(root.getData().compareTo(node.getData()) > 0){ // if children node has higher priority , then simply swap the data
            E data = root.getData();
            root.setData(node.getData());
            node.setData(data);
            sinkDownFromIndex(node);
        }

    }

    private void bubbleUpFromIndex(LinkedNode<E> tail) {
        LinkedNode<E> node = tail;
        while(node.getParent() != null){
            E data = node.getParent().getData();
            int comparison = data.compareTo(node.getData());
            if(comparison > 0){
                E temp = node.getData();
                node.setData(node.getParent().getData());
                node.getParent().setData(temp);
                node = node.getParent();
            }else {
                break;
            }
        }

    }

    public Iterator<E> iterator() { 
        return null; 
    }
}

