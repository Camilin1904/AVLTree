import junit.framework.TestCase;

public class TestAVL extends TestCase{
    
    private AVLTree<Integer> tree1;

    private void setUp1(){
        tree1 = new AVLTree<>();
        tree1.add(1);
        tree1.add(3);
        tree1.add(4);
        tree1.add(6);
        tree1.add(7);
        tree1.add(10);
        tree1.add(7);
        tree1.add(0);
        tree1.add(2);
    }

    public void testAdd1(){
        setUp1();
        tree1.add(-1);
        assertNotNull(tree1.search(-1));
        tree1.add(-2);
        assertNotNull(tree1.search(-2));
        tree1.add(-4);
        assertNotNull(tree1.search(-4));
        tree1.add(-3);
        assertNotNull(tree1.search(-3));
        assertEquals(tree1.getHeight(), 4);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 6);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), -1);
        assertEquals(tree1.inOrderSave(tree1.getRoot()).toString(), "[-4, -3, -2, -1, 0, 1, 2, 3, 4, 6, 7, 7, 10]");
    }
    
    public void testAdd1_2(){
        tree1 = new AVLTree<>();
        tree1.add(1);
        assertNotNull(tree1.search(1));
        tree1.add(2);
        assertNotNull(tree1.search(2));
        tree1.add(5);
        assertNotNull(tree1.search(5));
        tree1.add(20);
        assertNotNull(tree1.search(20));
        tree1.add(30);
        assertNotNull(tree1.search(30));
        tree1.add(-20);
        assertNotNull(tree1.search(-20));
        tree1.add(9);
        assertNotNull(tree1.search(9));
        tree1.add(8);
        assertNotNull(tree1.search(8));
        assertEquals(tree1.inOrderSave(tree1.getRoot()).toString(), "[-20, 1, 2, 5, 8, 9, 20, 30]");
        assertEquals(tree1.getHeight(), 4);
    }

    public void testDelete1(){
        setUp1();
        tree1.delete(3);
        assertNull(tree1.search(3));
        assertEquals(tree1.getHeight(), 4);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 7);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 1);
        tree1.delete(1);
        assertNull(tree1.search(1));
        assertEquals(tree1.getHeight(), 3);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 7);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 2);
        tree1.delete(7);
        assertEquals(tree1.getHeight(), 3);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 10);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 2);
    }

    public void testDelete1_2(){
        setUp1();
        tree1.delete(4);
        assertNull(tree1.search(4));
        assertEquals(tree1.getHeight(), 4);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 1);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 7);
        tree1.delete(6);
        assertNull(tree1.search(6));
        assertEquals(tree1.getHeight(), 4);
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 1);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 10);
        tree1.delete(10);
        assertNull(tree1.search(10));
        assertEquals(tree1.getHeight(), 3);//Ni siquiera se como llega a la respuesta correcta pero lo hace entonces estoy feliz :)
        assertEquals(tree1.getRoot().getLeft().getValue().intValue(), 1);
        assertEquals(tree1.getRoot().getRight().getValue().intValue(), 7);

    }
}
