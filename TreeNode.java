public class TreeNode<T> {
    private T data;  // Data stored in the node
    private TreeNode<T> leftChild;  // Reference to the left child node
    private TreeNode<T> rightChild;  // Reference to the right child node

    /**
     * Constructor to initialize a new TreeNode with given data.
     * @param data The data to be stored in the node.
     */
    public TreeNode(T data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Get the data stored in the node.
     * @return The data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data stored in the node.
     * @param data The data to be stored in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get the left child node.
     * @return The left child node.
     */
    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Set the left child node.
     * @param leftChild The left child node to be set.
     */
    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Get the right child node.
     * @return The right child node.
     */
    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * Set the right child node.
     * @param rightChild The right child node to be set.
     */
    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
