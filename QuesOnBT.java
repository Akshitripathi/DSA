package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class QuesOnBT {

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
        if(root==null) return 0;
        int lh= depth(root.left);
        int rh= depth(root.right);
        return 1+Math.max(lh,rh);
    }

    static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize= q.size();
            for(int i=0;i<levelSize;i++){
                Node currentNode= q.poll();
                System.out.print(currentNode.data+" ");
                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
            System.out.println();
        }
    }

    static void oddLevelNode(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){

            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                Node currentData= q.poll();
                if(level%2==0){
                    System.out.print(currentData.data+" ");
                }

                if(currentData.left!=null){
                    q.add(currentData.left);
                }
                if(currentData.right!=null){
                    q.add(currentData.right);
                }
            }
            level++;
        }
    }

    static void leafNode(Node root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.data+" ");
        }else{
            leafNode(root.left);
            leafNode(root.right);
        }
    }

    static void nonLeafNode(Node root){
        if(root==null){
            return;
        }
        if(root.left!=null || root.right!=null){
            System.out.println(root.data+" ");
            nonLeafNode(root.left);
            nonLeafNode(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        for(int i:arr){
            insert(i);
        }
        System.out.println("Depth of Tree: "+depth(root));
        System.out.println("Level Order Traversal: ");
        levelOrder(root);
        System.out.println("Odd Level Nodes: ");
        oddLevelNode(root);
        System.out.println();
        System.out.println("Leaf Node: ");
        leafNode(root);
        System.out.println("Non-Leaf Node : ");
        nonLeafNode(root);
    }
}
