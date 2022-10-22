public class Node<T> implements Comparable<T>{
    private Node<T> right;
    private Node<T> left;
    private Node<T> parent;
    private T value;
    private int height;

    public Node(T value, int height){
        this.value=value;
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }
    public Node<T> getRight() {
        return right;
    }
    public T getValue() {
        return value;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public void setValue(T value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value +"";
    }

    @Override
    public int compareTo(T o) {
        return this.compareTo(o);
    }
    
    public Node<T> getParent() {
        return parent;
    }
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateHeight(){
        int hl = 0, hr = 0; 
        if((hl = left!=null?left.calculateHeight():0)>(hr = right!=null?right.calculateHeight():0)){
            height = hl+1;         
        }
        else{
            height = hr+1;
        }
        return height;
    }
}
