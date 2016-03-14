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
			 String leftkey = (leftChild == null ? "null" : String.valueOf(leftChild.key));  
	            String rightkey = (rightChild == null ? "null" : String.valueOf(rightChild.key));  
	            return "(" + leftkey + " , " + key + " , " + rightkey + ")";  
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
	  * minNode返回树的最小结点
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
	  * minNode返回树的最大结点
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
	  * successor返回一个结点的后继结点
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode successor(TreeNode node) throws Exception{
		 if(node == null){
			 return null;
		 }
		 
		 if(node.rightChild != null){			//如果结点的右字数不为空，则后继结点是右子树的最左结点
			 return minNode(node.rightChild);
		 }
		 TreeNode parentNode = node.parent;
		 while(parentNode != null && node == parentNode.rightChild){//若结点的右子树为空，后继结点是x的最底层祖先
			 node = parentNode;
			 parentNode = parentNode.parent;
		 }
		 return parentNode;
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
	 
	 /**
	  * insert 插入元素
	  * 
	  * **/
	 public void insert( int key){
		 TreeNode parentNode = null;
		 TreeNode newNode = new TreeNode(key,null,null,null);
		 TreeNode pNode = root;
		 if(root == null){
			 root = newNode;
			 return;
		 }
		 while(pNode != null){
			 parentNode = pNode;
			 if(key < pNode.key)
			 {
				 pNode = pNode.leftChild;
			 }
			 else if (key > pNode.key){
				 pNode = pNode.rightChild;
			 }
			 else {
				 return;//若有重复，则直接返回
			 }
		 }
		 newNode.parent = parentNode;
		 if(newNode.key < parentNode.key){
			 parentNode.leftChild = newNode;
		 }
		 else{
			 parentNode.rightChild = newNode;
		 }
		 
		 
	 }
	 
	 /**
	  * transplant 用一个结点changeNode代替另一个结点originNode的位置
	  * 
	  * **/
	 public void transplant(TreeNode originNode, TreeNode changeNode){
		 if(originNode.parent == null){
			 this.root = changeNode;
		 }
		 else if (originNode == originNode.parent.leftChild){
			 originNode.parent.leftChild = changeNode;
		 }
		 else {
			 originNode.parent.rightChild = changeNode;
		 }
		 if(changeNode != null){
			 changeNode.parent = originNode.parent;
		 }
	 }
	 
	 /**
	  * deleteNode 删除一个结点，《算法导论》，用到辅助transplant
	  * 
	  * **/
	 public void deleteNode (TreeNode dNode) throws Exception{
		 if(dNode.leftChild == null){
			 transplant(dNode,dNode.rightChild);//若左子树为空，用右孩子代替
		 }
		 else if(dNode.rightChild == null){
			 transplant(dNode, dNode.leftChild);//若右子树为空，用左孩子代替
		 }
		 else{													//若左右均存在，用右子树的最小节点rightMinNode	 															
			 TreeNode rightMinNode = minNode(dNode.rightChild);//代替右孩子（先让 rightMinNode与其右孩子交换）
			 if(rightMinNode.parent != dNode){
				 transplant(rightMinNode,rightMinNode.rightChild);
				 rightMinNode.rightChild = dNode.rightChild;
				 dNode.rightChild.parent = rightMinNode;
				 
			 }
			transplant(dNode,rightMinNode);
			rightMinNode.leftChild = dNode.leftChild;
			rightMinNode.leftChild.parent = rightMinNode;
			 }
		 }
	 public void deleteKey(int key) throws Exception{
		 deleteNode(search(root, key));
	 }
		 
	 

	 public static void main (String[] args) throws Exception{
		 BianrySearchTree bst = new BianrySearchTree();
		 int[] keys = new int []{15, 6, 18, 3, 7, 13, 20, 2, 9, 4};
		 for (int key: keys) {
			 
			bst.insert(key);
		}
		 bst.inOrderTraverse(bst.root);
		 bst.deleteKey(18);
		 bst.inOrderTraverse(bst.root);
		 
		 
	
	
}
}
 