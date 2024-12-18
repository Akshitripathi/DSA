package BinaryTree;
import java.util.*;
public class BasicsOfBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            left=right=null;
        }
    }
    static class Pair{
        int current;
        Node curr;
        Pair(Node curr,int current){
            this.curr=curr;
            this.current=current;
        }
    }
    static int dia;
    static Node root;
    static Node insert(int[] arr, int index ){
        if(index<arr.length && arr[index]!=-1){
            Node temp= new Node(arr[index]);
            temp.left= insert(arr,2*index+1);
            temp.right= insert(arr,2*index+2);
            return temp;
        }
        return null;
    }
    static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void postorder(Node root){
        if(root==null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    static void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelsize= q.size();
            for(int i=0;i<levelsize;i++){
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
    static int  height(Node root){
        if(root==null){
            return 0;
        }
        int lh= height(root.left);
        int rh= height(root.right);
        return 1+Math.max(lh,rh);
    }
    static int diameterHelper(Node root){
        if(root==null){
            return 0;
        }
        int lh=diameterHelper(root.left);
        int rh=diameterHelper(root.right);
        dia= Math.max(dia,lh+rh);
        return Math.max(lh,rh)+1;
    }
    static int diameter(Node root){
        diameterHelper(root);
        return dia;
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
    static boolean balanced(Node root){
        return checkHeight(root)!=-1;
    }
    static void nonleafNodes(Node root){
        if(root==null){
            return ;
        }
        if(root.left!=null || root.right!=null){
            System.out.print(root.data+" ");
            nonleafNodes(root.left);
            nonleafNodes(root.right);
        }
    }
    static void leafNodes(Node root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null ){
            System.out.print(root.data+" ");
        }else{
            leafNodes(root.left);
            leafNodes(root.right);
        }
    }

    static int maxlevel=0;
    static void leftview(Node root,int level){
        if(root==null){
            return;
        }
        if(maxlevel<level){
            System.out.print(root.data+" ");
            maxlevel=level;
        }
        leftview(root.left,level+1);
        leftview(root.right,level+1);
    }

    static int maxlevel1=0;
    static void rightview(Node root, int level){
        if(root==null){
            return ;
        }
        if(maxlevel1<level){
            System.out.print(root.data+" ");
            maxlevel1=level;
        }
        rightview(root.right,level+1);
        rightview(root.left,level+1);
    }

    static void topview(Node root){
        if(root==null) return;
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer,Integer> tm= new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp= q.poll();
            Node curr= temp.curr;
            int hd= temp.current;
            if(!tm.containsKey(hd)){
                tm.put(hd,curr.data);
            }
            if(curr.left!=null){ q.add(new Pair(curr.left,hd-1));}
            if(curr.right!=null){ q.add(new Pair(curr.right,hd+1));}
        }
        for(Map.Entry<Integer,Integer> x: tm.entrySet()){
            System.out.print(x.getValue()+" ");
        }
    }
    static void bottomview(Node root){
        Queue<Pair> q= new LinkedList<>();
        Map<Integer, Integer> tm= new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp= q.poll();
            Node curr= temp.curr;
            int hd=temp.current;
            tm.put(hd,curr.data);
            if(curr.left!=null) q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null) q.add(new Pair(curr.right,hd+1));
        }
        for(Integer nums: tm.values()){
            System.out.print(nums+" ");
        }
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
    static int totalsum=0;
    static int sumOfRootToLeafHelper(Node root, int currSum){
        if(root==null){
            return 0;
        }
        currSum= currSum*10+root.data;
        if(root.left==null && root.right==null){
            return currSum;
        }
        return sumOfRootToLeafHelper(root.left,currSum)+sumOfRootToLeafHelper(root.right,currSum);
    }
    static int sumOfRootToLeaf(Node root){
        return sumOfRootToLeafHelper(root,0);

    }

    static boolean isSumTree(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        int lsum= sum(root.left);
        int rsum= sum(root.right);
        if (root.data== lsum+rsum){
            return isSumTree(root.left)&& isSumTree(root.right);
        }else{
            return false;
        }
    }
    static int sum(Node root){
        if(root==null){
            return 0;
        }
        return root.data+ sum(root.left)+sum(root.right);
    }

    static int lowestCommonAncestor(Node root,int k1, int k2){
        if(root==null){
            return 0;
        }
        if(root.data<k1 && root.data<k2){
            lowestCommonAncestor(root.right,k1,k2);
        }
        if(root.data>k1 && root.data>k2){
            lowestCommonAncestor(root.left,k1,k2);
        }
        return root.data;
    }




    public static void main(String[] args) {
        int[] arr={ 26,10,3,4,6,3};
        Node root= insert(arr,0);
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        levelorder(root);
        System.out.println();
        System.out.println("Depth: "+ height(root));
        System.out.println("Diameter: "+ diameter(root));
        System.out.println("Is Balanced: "+balanced(root));
        System.out.println("Non Leaf Nodes: ");
        nonleafNodes(root);
        System.out.println();
        System.out.println("Leaf Nodes: ");
        leafNodes(root);
        System.out.println();
        System.out.println("Top view:");
        topview(root);
        System.out.println();
        System.out.println("Bottom view:");
        bottomview(root);
        System.out.println();
        System.out.println("Right view:");
        rightview(root,1);
        System.out.println();
        System.out.println("Left view:");
        leftview(root,1);
        System.out.println();
        System.out.println("Sum of Leaf nodes: "+ sumOfLeafNodes(root));
        System.out.println("Sum of root to leaf: "+ sumOfRootToLeaf(root));
        System.out.println("Is sum tree or not : ");
        System.out.println(isSumTree(root)? "yes" : "no");



    }
}
