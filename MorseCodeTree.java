import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    public MorseCodeTree() {
        root = null;
        buildTree(); // Build the initial tree
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public void insert(String code, String result) {
        addNode(root, code, result);
    }

    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.isEmpty()) {
            // If the code is empty, just set the current node's data to the given letter
            root.setData(letter);
            return;
        }

        char direction = code.charAt(0); // Get the first character of the code (. or -)
        String remainingCode = code.substring(1); // Get the remaining part of the code

        if (direction == '.') {
            // If the current direction is a dot (.)
            // If the left child is null, create a new node with an empty string data
            if (root.getLeftChild() == null) {
                root.setLeftChild(new TreeNode<>(""));
            }
            // Recursively add the node with the remaining code
            addNode(root.getLeftChild(), remainingCode, letter);
        } else if (direction == '-') {
            // If the current direction is a dash (-)
            // If the right child is null, create a new node with an empty string data
            if (root.getRightChild() == null) {
                root.setRightChild(new TreeNode<>(""));
            }
            // Recursively add the node with the remaining code
            addNode(root.getRightChild(), remainingCode, letter);
        }
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (root == null) {
            return null;
        }

        if (code.isEmpty()) {
            return root.getData(); // If the code is empty, return the data of the current node
        }

        char direction = code.charAt(0); // Get the first character of the code (. or -)
        String remainingCode = code.substring(1); // Get the remaining part of the code

        if (direction == '.') {
            return fetchNode(root.getLeftChild(), remainingCode); // Recursively fetch from the left child
        } else if (direction == '-') {
            return fetchNode(root.getRightChild(), remainingCode); // Recursively fetch from the right child
        } else {
            return null; // Invalid code, return null
        }
    }

    // Delete and update operations are not supported
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported");
    }

    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported");
    }

    @Override
    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list); // Perform in-order traversal and add nodes to the list
        return list;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root == null) {
            return;
        }

        LNRoutputTraversal(root.getLeftChild(), list); // Traverse left subtree
        list.add(root.getData()); // Add current node's data to the list
        LNRoutputTraversal(root.getRightChild(), list); // Traverse right subtree
    }
}