import java.util.ArrayList;

public interface AVL<T> {
    
    public int getHeight();

    public void add(T value);

    public Node<T> search(T value);

    public ArrayList<T> inOrderSave(Node<T> node);

    public boolean delete(T value);

    public int balanceStatus(Node<T> node);

    public void leftRotate(Node<T> node);

    public void rightRotate(Node<T> node);

    public void balance(Node<T> node);
}
