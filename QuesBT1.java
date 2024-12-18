package BinaryTree;
import java.util.*;

public class QuesBT1 {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left=right=null;
        }
    }
    static Node root;
    static Node temp=root;
    static void insert(int data){
        Node temp= root;
        if(root==null){
            root= new Node(data);
            return;
        }
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp1= q.poll();
            if(temp1.left==null){
                temp1.left=new Node(data);
                break;
            }else{
                q.add(temp1.left);
            }

            if(temp1.right==null){
                temp1.right= new Node(data);
                break;
            }else{
                q.add(temp1.right);
            }
        }
    }
    static int depth(Node root){
        if(root== null){
            return 0;
        }
        int lh= depth(root.left);
        int rh= depth(root.right);
        return 1+Math.max(lh,rh);
    }
    static int sumOfLeafNodes(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.data;
        }
        return sumOfLeafNodes(root.left)+sumOfLeafNodes(root.right);
    }

    static int checkHeight(Node root){
        if(root==null){
            return 0;
        }
        int lh= checkHeight(root.left);
        if(lh==-1) return -1;
        int rh= checkHeight(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh)>1) return -1;

        return Math.max(lh,rh)+1;
    }
    static boolean isBalanaced(Node root){
        return checkHeight(root)!=-1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        for(int i:arr){
            insert(i);
        }
        System.out.println("Depth: "+depth(root));
        System.out.println("Sum of leaf nodes: "+sumOfLeafNodes(root));
        if(isBalanaced(root)){
            System.out.println("Yes balanced");
        }else{
            System.out.println("Not balanced");
        }
    }
}
