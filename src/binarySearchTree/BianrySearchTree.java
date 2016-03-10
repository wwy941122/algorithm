package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BianrySearchTree {
	
	private TreeNode root = null;
	
	//private List<TreeNode> nodelist = new ArrayList<TreeNode>();
	private class TreeNode{
		private int key;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		public TreeNode(int key, TreeNode leftChild, TreeNode rightChild, TreeNode parent){
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
			
		}
		public int getKey(){
			return this.key;
		}
		public String toString(){
			return "("+ leftChild.toString() + ","+key+","+rightChild.toString()+")";
		}
		
	}
	
	/**
	  *isEmpty: 判断树是否为空
          
 
   */  
	public boolean isEmpty(){
		if (root == null){
			return true;
		} 
		else {
			return false;
		}
		}
	 /**
      *search: 在二叉查找树中查询给定关键字 
            
   
     */  
	 public TreeNode search (TreeNode pNode, int key){
		 
		 while(pNode != null && pNode.key != key){
			 if (key < pNode.key){
				 pNode = pNode.leftChild;
			 } else 
			 {
				 pNode = pNode.rightChild;
			 }
		 }
		 return pNode;
	 }//迭代版本，效率高

/*	 public TreeNode search1 (TreeNode pNode, int key){
		 if(pNode.key == key && pNode != null){
			 return pNode;}
		 else if(pNode.key >= key){
			 return search1(pNode.leftChild,key);}
			 else{
			return  search1(pNode.rightChild,key);
		 }
		 
		
	 }*///递归版本
	 
	 /**
	  * minNode返回树的最小节点
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode minNode(TreeNode node) throws Exception{
		 if(node == null){
			 throw new Exception("树为空");
		 }
		 TreeNode pNode = node;
		 while(pNode.leftChild !=null){
			 pNode = pNode.leftChild;
		 }
		 return pNode;
	 }
	 
	 /**
	  * minNode返回树的最大节点
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode maxNode(TreeNode node) throws Exception{
		 if(node == null) {
			 throw new Exception("树为空");
		 }
		 TreeNode pNode = node;
		 while(pNode.rightChild != null){
			 pNode = pNode.rightChild;
		 }
		 return pNode;
	 }
	 
	 /**
	  * inOrderTraverse 对给定树中序遍历
	  * 
	  * **/
	 public void inOrderTraverse(TreeNode node){
		 TreeNode pNode = node;
		 if (pNode != null) {
			 inOrderTraverse(pNode.leftChild);
			 System.out.println(pNode);
			 inOrderTraverse(pNode.rightChild);
		 }
	 }

}
 