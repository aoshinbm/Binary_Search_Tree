public class CreateBinaryTree {
        class Node {
            int data;
            Node left, right;

            public Node(int item) {
                data = item;
                left = right = null;
            }
        }
    // Root of BST
    Node root;

    public CreateBinaryTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int data) {
        root = insertRec(root, data);
    }

    /*
        * A recursive function to insert a new key in BST
    */
    Node insertRec(Node root, int data)
    {

        /*
        * If the tree is empty, return a new node
         */
        if (root == null)
        {
            root = new Node(data);
            return root;
        }
        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }
    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root) {

        if (root == null) {
            return;
        }
        inorderRec(root.left);
        System.out.println("["+root.data+"]");
        inorderRec(root.right);
    }


    static boolean ifNodeExists( Node root, int input)
    {
        if (root == null)
            return false;

        if (root.data == input)
            return true;

        // then recur on left subtree /
        boolean res1 = ifNodeExists(root.left, input);

        // node found, no need to look further
        if(res1==true) return true;

        // node is not found in left,
        // so recur on right subtree /
        boolean res2 = ifNodeExists(root.right, input);

        return res2;
    }



    public static void main(String[] args) {
        CreateBinaryTree tree=new CreateBinaryTree();
        tree.insert(56);
        tree.insert(30);
        tree.insert(70);
        tree.inorder();
        }
    }
