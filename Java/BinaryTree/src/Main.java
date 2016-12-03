/**
 * Created by lil9porkchop on 12/3/16.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

//        theTree.inOrderTraversal(theTree.root);
//        theTree.preOrderTraversal(theTree.root);
//        theTree.postOrderTraversal(theTree.root);

        System.out.println(theTree.findNodeInteratively(30));
        System.out.println(theTree.searchTree(theTree.root, 85));


    }
}
