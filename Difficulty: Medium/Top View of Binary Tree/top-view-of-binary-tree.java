//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    
    static class Info{
        
        Node n;
        int hd;
        public Info(Node n, int hd){
            this.n=n;
            this.hd = hd;
        }
    }
    
    public static List<Integer> topv(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> mpp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int min = 0, max = 0;
        q.add(new Info(root,0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null ){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!mpp.containsKey(curr.hd)){
                    mpp.put(curr.hd,curr.n);
                }
                if(curr.n.left!=null){
                    q.add(new Info(curr.n.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.n.right!=null){
                    q.add(new Info(curr.n.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
                
            }
        }
        for(int i =min; i<=max; i++){
            arr.add(mpp.get(i).data);
        }
        return arr;
        
    }
    
    static ArrayList<Integer> topView(Node root) {
        // code here
        return new ArrayList<>(topv(root));
        
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends