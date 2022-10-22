import java.util.*;

public class AVLTree<T extends Comparable<T>>{
    private Node<T> root;
    private ArrayList<T> list = new ArrayList<>();



    public void add(T value){
        list.clear();
        Node<T> n = add(value, root);
        root.calculateHeight();
        balance(n);
    }



    public int getHeight(){
        return root.getHeight();
    }



    public Node<T> add(T value, Node<T> node){
        if(root==null){
           root = new Node<>(value, 1);
           root.setParent(root);
           return root;
        }
        else if (value.compareTo(node.getValue())<0){
            if (node.getLeft()==null){
                node.setLeft(new Node<>(value, 1));
                node.getLeft().setParent(node);
                return node.getParent();
            }
            else return add(value, node.getLeft());
        }
        else if (value.compareTo(node.getValue())>0){
            if (node.getRight()==null){
                node.setRight(new Node<>(value, 1));
                node.getRight().setParent(node);
                return node.getParent();
            }
            else return add(value, node.getRight());
        }
        else if (value.equals(node.getValue())){
            if(node.getRight()==null){
                Node<T> holder = new Node<>(value, node.getHeight()+1);
                holder.setRight(node.getRight());
                node.setRight(holder);
                node.getRight().setParent(node);
                return node.getParent();
            }
            else return add(value, node.getRight());
        }
        else return null;
    }



    public Node<T> search(T value){
        return search(value, root);
    }



    public Node<T> search(T value, Node<T> node){
        if (node==null) return node;
        else if (value==node.getValue()) return node;
        else if (value.compareTo(node.getValue())<0) return search(value, node.getLeft());
        else if (value.compareTo(node.getValue())>0) return search(value, node.getRight());
        else return null;
    }



    public Node<T> getRoot() {
        return root;
    }



    public void deleteList(){
        list = new ArrayList<>();
    }



    public ArrayList<T> inOrderSave(Node<T> node){
        if (node.getLeft()!=null)inOrderSave(node.getLeft());
        list.add(node.getValue());
        if (node.getRight()!=null)inOrderSave(node.getRight());
        return list;
    } 



    public Node<T> findMin(Node<T> tracker){
        if(tracker.getLeft()==null) return tracker;
        else return findMin(tracker.getLeft());
    }


    
    public Node<T> findSuccessor(Node<T> node){
        if(node.getRight()!=null) return findMin(node.getRight());
        if(node.getRight()==null&&node.getLeft()==null) return node.getParent();
        Node<T> parent = node.getParent();
        while(parent!=null&&node.equals(parent.getRight())){
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }




    public boolean delete(T value){
        list.clear();
        Node<T> n = findSuccessor(search(value));
        n = n==null?search(value).getParent():n;
        delete(value, root);
        root.calculateHeight();
        n = search(n.getValue());
        balance(n);
        return true;
    }



    private Node<T> delete(T goal, Node<T> current){
        if(current == null){
            return null;
        }
        if(current.getValue() == goal){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                Node<T> min = findMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.setValue(min.getValue());
                //Hacer eliminación a partir de la derecha
                Node<T> subarbolDER = delete(min.getValue(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(goal.compareTo(current.getValue())<0){
            Node<T> subArbolIzquierdo = delete(goal, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            Node<T> subArbolDerecho = delete(goal, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }




    public int balanceStatus(Node<T> node){
        int r = node.getRight()!=null?node.getRight().getHeight():0;
        int l = node.getLeft()!=null?node.getLeft().getHeight():0;
       return r-l;
    }


    
    public void modH(Node<T> node, Node<T> son){
        if(son!=null&&son.getHeight()>=node.getHeight()) node.setHeight(node.getHeight()+1);
        if(node.getParent()!=node) modH(node.getParent(), node);
    }



    public void leftRotate(Node<T> node){
        Node<T> n = node.getRight();
       if(node.getRight()!=null){
            if(node.getParent().getRight()==node){
                n.setParent(node.getParent());
                node.getParent().setRight(node.getRight());
            }
            else if(node.getParent()==node){
                root = n;
                n.setParent(n);
            }
            else {
                node.getParent().setLeft(node.getRight());
                n.setParent(node.getParent());
            }
            node.setRight(n.getLeft());
            if(node.getRight()!=null) node.getRight().setParent(node);
            node.setParent(n);
            n.setLeft(node);
            node.getParent().setLeft(node);
            root.calculateHeight();
       }
    }



    public void rightRotate(Node<T> node){
        Node<T> n = node.getLeft();
        if(node.getLeft()!=null){
            if(node.getParent().getRight()==node){
                n.setParent(node.getParent());
                node.getParent().setRight(n);
            }
            else if (node.getParent()==node){
                root = n;
                n.setParent(n);
            }
            else  {
                n.setParent(node.getParent());
                node.getParent().setLeft(n);
            }
            node.setLeft(n.getRight());
            if(node.getLeft()!=null) node.getLeft().setParent(node);
            node.setParent(n);
            n.setRight(node);
            node.getParent().setRight(node);
            root.calculateHeight();
        }
     }



    public void balance(Node<T> node){
        int timesDone = 0, timesDone2 = 0;
        do{
            int balance = balanceStatus(node);
            while(balance>=2||balance<=-2){
                if (balance>=2) {
                    if(balanceStatus(node.getRight())<0)rightRotate(node.getRight());
                    leftRotate(node);
                }
                else if(balance<=-2) {
                    if(balanceStatus(node.getLeft())>0)leftRotate(node.getLeft());
                    rightRotate(node);
                }
                node = node.getParent();
                balance = balanceStatus(node);
            }
            node = node.getParent();
            timesDone++;
            if(timesDone>2){
                timesDone=0;
                timesDone2=0;
                node = node.getParent();
            }
            timesDone2++;
        }while(node!=root||timesDone2<3);


    }
}