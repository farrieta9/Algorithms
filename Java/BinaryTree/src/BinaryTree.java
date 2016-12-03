/**
 * Created by lil9porkchop on 12/3/16.
 */
public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
            return;
        }

        Node focusNode = root;
        Node parent;
        while(true) {
            parent = focusNode;
            if(key < focusNode.key) {
                focusNode = focusNode.leftChild;

                if (focusNode == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                focusNode = focusNode.rightChild;
                if (focusNode == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode) {
        // Roots get read first
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode) {
        // Root get read last
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNodeIteratively(int key) {
        // Time complexity: O(logn)
        Node focusNode = root;
        while(focusNode.key != key) {
            if(key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }

        }
        return focusNode;
    }

    public Node findNodeRecursively(Node node, int key) {
        // Time complexity for this is: nlogn
        if (node == null) return null;

        if (node.key == key) return node;

        Node left = findNodeRecursively(node.leftChild, key);
        Node right = findNodeRecursively(node.rightChild, key);

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public Node searchTree(Node node, int key) {
        // Time complexity: O(logn)
        if(node == null)
            return null;

        if (node.key == key)
            return node;

        if (key < node.key) {
            return searchTree(node.leftChild, key);
        } else {
            return searchTree(node.rightChild, key);
        }
    }
}

class Node {
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key: " + key;
    }
}