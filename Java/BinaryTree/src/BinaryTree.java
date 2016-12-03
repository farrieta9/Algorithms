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

    public boolean removeNode(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(focusNode.key != key) {
            parent = focusNode;
            if(key < focusNode.key) {
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

        }

        if(focusNode == null) {
            return false;
        }

        // to delete node
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if(focusNode == root) {
                root = null;
            } else if(isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {

            if(focusNode == root) {
                root = focusNode.leftChild;
            } else if (focusNode.rightChild == null) {
                if (focusNode == root) {
                    root = focusNode.leftChild;
                } else if(isItALeftChild){
                        parent.leftChild = focusNode.leftChild;
                } else {
                    parent.rightChild = focusNode.leftChild;
                }
            }
        } else if (focusNode.leftChild == null) {
            if(focusNode == root) {
                root = focusNode.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else {
            // two children are evolved
            Node replacement = getReplacementNode(focusNode);
            if(focusNode == root) {
                root = replacement;
            } else if (isItALeftChild)
                parent.leftChild = replacement;
            else
                parent.rightChild = replacement;
            replacement.leftChild = focusNode.leftChild;
        }

        return true;
    }

    public Node getReplacementNode(Node replaceNode) {

        Node replacementParent = replaceNode;
        Node replacement = replaceNode;

        Node focusNode = replaceNode.rightChild;

        while(focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replaceNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }

        return replacement;

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