
public class Main {
    public static void main(String[] args) {
        Main mn = new Main();
        mn.treeThings();
    }

    public void treeThings(){
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        System.out.println(tree.getRoot());
        tree.add(3);
        System.out.println(tree.getRoot());
        tree.add(4);
        System.out.println(tree.getRoot());
        tree.add(6);
        System.out.println(tree.getRoot());
        tree.add(7);
        System.out.println(tree.getRoot());
        tree.add(10);
        System.out.println(tree.getRoot());
        tree.add(7);
        System.out.println(tree.getRoot());
        tree.add(0);
        System.out.println(tree.getRoot());
        tree.add(2);
        System.out.println(tree.getRoot());
        tree.add(-1);
        System.out.println(tree.getRoot());
        tree.add(-2);
        System.out.println(tree.getRoot());
        tree.add(-4);
        System.out.println(tree.getRoot());
        tree.add(-3);
        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.inOrderSave(tree.getRoot()));
        System.out.println(tree.getRoot().getParent().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getHeight());

        tree.delete(3);
        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.inOrderSave(tree.getRoot()));
        System.out.println(tree.getRoot().getParent().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getHeight());
        tree.delete(6);
        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.inOrderSave(tree.getRoot()));
        System.out.println(tree.getRoot().getParent().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getHeight());
        tree.delete(7);
        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.inOrderSave(tree.getRoot()));
        System.out.println(tree.getRoot().getParent().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getHeight());
    }
}
