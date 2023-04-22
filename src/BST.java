import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Calls the recursive function to search
        return searchTree(val, root);
    }

    public boolean searchTree(int val, BSTNode cur){
        // if the value is in the tree return the base case
        if (cur.getVal() == val){
            return true;
        }
        // If the tree ends and we are at a leaf then false
        if (cur.getRight() == null && cur.getLeft() == null){
            return false;
        }
        // And depending on what the value is compared to the current node go left or right
        if (cur.getVal() > val){
            return searchTree(val, cur.getLeft());
        }
        else{
            return searchTree(val, cur.getRight());
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Calls the recursive function to get the order
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return inOrder(arr, root);
    }

    public ArrayList<BSTNode> inOrder(ArrayList<BSTNode> arr, BSTNode a){
        // First go down the left all the way you can and then add them
        if (a.getLeft() != null){
            inOrder(arr, a.getLeft());
        }

        arr.add(a);
        // After the left go it adds the right going all the way down and then returns the array
        if (a.getRight() != null){
            inOrder(arr, a.getRight());
        }

        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Calls the recursive function to get the order
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return preOrder(arr, root);
    }

    public ArrayList<BSTNode>  preOrder(ArrayList<BSTNode> arr, BSTNode a){

        // Similar to the inorder this is just the order switched around with the root being added first
        arr.add(a);

        // Then we go down the left recursing and adding
        if (a.getLeft() != null){
            preOrder(arr, a.getLeft());
        }

        // And finally the right going down and adding
        if (a.getRight() != null){
            preOrder(arr, a.getRight());
        }

        return arr;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Calls the recursive function to get the order
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        return postOrder(arr, root);
    }

    public ArrayList<BSTNode> postOrder(ArrayList<BSTNode> arr, BSTNode a){
        // And finally we do the other order where we add the left
        if (a.getLeft() != null){
            postOrder(arr, a.getLeft());
        }
        // Then add all the right elements
        if (a.getRight() != null){
            postOrder(arr, a.getRight());
        }
        // And finally add the root return the array
        arr.add(a);
        return arr;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // Calls the recursive method to insert
        insertrec(val, root);
    }

    public void insertrec(int val, BSTNode a){
        // Two different options for whether to add it to the right or left depending on value
        if (a.getVal() > val){
            // If the left is null we just insert their otherwise we call the method again
            if (a.getLeft() == null){
                a.setLeft(new BSTNode(val));
                return;
            }
            insertrec(val, a.getLeft());
        }
        if (a.getVal() < val){
            // Similarly if the right is null we just insert their otherwise we call the method again
            if (a.getRight() == null){
                a.setRight(new BSTNode(val));
                return;
            }
            insertrec(val, a.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
