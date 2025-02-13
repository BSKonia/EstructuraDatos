package ArbolRojoNegro;

public class RedBlackTree {
    private RedBlackNode root;
    private final RedBlackNode NIL; // Nodo NIL para hojas negras

    public RedBlackTree() {
        NIL = new RedBlackNode(0);
        NIL.isRed = false;
        root = NIL;
    }

    public void insert(int data) {
        RedBlackNode newNode = new RedBlackNode(data);
        newNode.left = newNode.right = NIL;

        RedBlackNode parent = null;
        RedBlackNode current = root;

        while (current != NIL) {
            parent = current;
            if (data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        newNode.parent = parent;

        if (parent == null) {
            root = newNode;
        } else if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        newNode.isRed = true;
        fixInsert(newNode);
    }

    private void fixInsert(RedBlackNode node) {
        while (node.parent != null && node.parent.isRed) {
            RedBlackNode grandparent = node.parent.parent;
            if (node.parent == grandparent.left) {
                RedBlackNode uncle = grandparent.right;
                if (uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    node = grandparent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.isRed = false;
                    grandparent.isRed = true;
                    rotateRight(grandparent);
                }
            } else {
                RedBlackNode uncle = grandparent.left;
                if (uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    node = grandparent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.isRed = false;
                    grandparent.isRed = true;
                    rotateLeft(grandparent);
                }
            }
        }
        root.isRed = false;
    }

    private void rotateLeft(RedBlackNode node) {
        RedBlackNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != NIL)
            rightChild.left.parent = node;
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(RedBlackNode node) {
        RedBlackNode leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != NIL)
            leftChild.right.parent = node;
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(RedBlackNode node) {
        if (node != NIL) {
            inOrderHelper(node.left);
            System.out.print(node.data + (node.isRed ? "🔴 " : "⚫ ") + " ");
            inOrderHelper(node.right);
        }
    }
    public void delete(int data) {
        RedBlackNode nodeToDelete = search(root, data);
        if (nodeToDelete == NIL) return; // No encontrado

        RedBlackNode y = nodeToDelete, x;
        boolean yOriginalColor = y.isRed;

        if (nodeToDelete.left == NIL) {
            x = nodeToDelete.right;
            transplant(nodeToDelete, nodeToDelete.right);
        } else if (nodeToDelete.right == NIL) {
            x = nodeToDelete.left;
            transplant(nodeToDelete, nodeToDelete.left);
        } else {
            y = minimum(nodeToDelete.right);
            yOriginalColor = y.isRed;
            x = y.right;

            if (y.parent == nodeToDelete) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = nodeToDelete.right;
                y.right.parent = y;
            }

            transplant(nodeToDelete, y);
            y.left = nodeToDelete.left;
            y.left.parent = y;
            y.isRed = nodeToDelete.isRed;
        }

        if (!yOriginalColor)
            fixDelete(x);
    }

    private void fixDelete(RedBlackNode x) {
        while (x != root && !x.isRed) {
            if (x == x.parent.left) {
                RedBlackNode sibling = x.parent.right;
                if (sibling.isRed) {
                    sibling.isRed = false;
                    x.parent.isRed = true;
                    rotateLeft(x.parent);
                    sibling = x.parent.right;
                }
                if (!sibling.left.isRed && !sibling.right.isRed) {
                    sibling.isRed = true;
                    x = x.parent;
                } else {
                    if (!sibling.right.isRed) {
                        sibling.left.isRed = false;
                        sibling.isRed = true;
                        rotateRight(sibling);
                        sibling = x.parent.right;
                    }
                    sibling.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    sibling.right.isRed = false;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                RedBlackNode sibling = x.parent.left;
                if (sibling.isRed) {
                    sibling.isRed = false;
                    x.parent.isRed = true;
                    rotateRight(x.parent);
                    sibling = x.parent.left;
                }
                if (!sibling.left.isRed && !sibling.right.isRed) {
                    sibling.isRed = true;
                    x = x.parent;
                } else {
                    if (!sibling.left.isRed) {
                        sibling.right.isRed = false;
                        sibling.isRed = true;
                        rotateLeft(sibling);
                        sibling = x.parent.left;
                    }
                    sibling.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    sibling.left.isRed = false;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.isRed = false;
    }

    private void transplant(RedBlackNode target, RedBlackNode replacement) {
        if (target.parent == null) {
            root = replacement;
        } else if (target == target.parent.left) {
            target.parent.left = replacement;
        } else {
            target.parent.right = replacement;
        }
        replacement.parent = target.parent;
    }

    private RedBlackNode search(RedBlackNode node, int data) {
        if (node == NIL || node.data == data) return node;
        return (data < node.data) ? search(node.left, data) : search(node.right, data);
    }

    private RedBlackNode minimum(RedBlackNode node) {
        while (node.left != NIL) node = node.left;
        return node;
    }
}