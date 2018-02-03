
/**
 * Write a description of class LinkedNode here.
 * 
 * @author (Mayank Chander) 
 * @version (a version number or a date)
 */
public class LinkedNode <E extends Comparable<? super E>>  
{
    // instance variables - replace the example below with your own
    private E data;
    private LinkedNode<E> parent;
    private LinkedNode<E> left;
    private LinkedNode<E> right; //da

    /**
     * Constructor for objects of class LinkedNode
     */
    public LinkedNode(E item,LinkedNode<E>nextNode)
    {
        data = item;
        right = nextNode;
    }

    public LinkedNode(E item)
    {
        data = item;
    }

    public LinkedNode(E item,LinkedNode<E>nextNode, LinkedNode<E>previousNode, LinkedNode<E> parentNode)
    {
        data = item;
        right = nextNode;
        left = previousNode;
        parent = parentNode;
    }    

    public E getData() {
        return data;
    }

    public LinkedNode<E> getRight(){

        return right;
    }

    public LinkedNode<E> getLeft() {

        return left;
    }

    public LinkedNode<E> setRight(LinkedNode<E> node){

        right= node;
        return right;

    }

    public LinkedNode<E> setLeft(LinkedNode<E>node){
        //previous = node;
        left = node;
        return left;
    }

    public LinkedNode<E> getParent(){

        return parent;
    }

    public void setData(E data){

        this.data = data;

    }

    public void setParent(LinkedNode<E> node){
        
        parent = node;

    }
        
}
