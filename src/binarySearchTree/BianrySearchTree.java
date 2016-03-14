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
	  *isEmpty: �ж����Ƿ�Ϊ��
          
 
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
      *search: �ڶ���������в�ѯ�����ؼ��� 
            
   
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
	 }//�����汾��Ч�ʸ�

/*	 public TreeNode search1 (TreeNode pNode, int key){
		 if(pNode.key == key && pNode != null){
			 return pNode;}
		 else if(pNode.key >= key){
			 return search1(pNode.leftChild,key);}
			 else{
			return  search1(pNode.rightChild,key);
		 }
		 
		
	 }*///�ݹ�汾
	 
	 /**
	  * minNode����������С���
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode minNode(TreeNode node) throws Exception{
		 if(node == null){
			 throw new Exception("��Ϊ��");
		 }
		 TreeNode pNode = node;
		 while(pNode.leftChild !=null){
			 pNode = pNode.leftChild;
		 }
		 return pNode;
	 }
	 
	 /**
	  * minNode�������������
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode maxNode(TreeNode node) throws Exception{
		 if(node == null) {
			 throw new Exception("��Ϊ��");
		 }
		 TreeNode pNode = node;
		 while(pNode.rightChild != null){
			 pNode = pNode.rightChild;
		 }
		 return pNode;
	 }
	 
	 /**
	  * successor����һ�����ĺ�̽��
	 * @throws Exception 
	  * 
	  * **/
	 public TreeNode successor(TreeNode node) throws Exception{
		 if(node == null){
			 return null;
		 }
		 
		 if(node.rightChild != null){			//���������������Ϊ�գ����̽������������������
			 return minNode(node.rightChild);
		 }
		 TreeNode parentNode = node.parent;
		 while(parentNode != null && node == parentNode.rightChild){//������������Ϊ�գ���̽����x����ײ�����
			 node = parentNode;
			 parentNode = parentNode.parent;
		 }
		 return parentNode;
	 }
	 
	 /**
	  * inOrderTraverse �Ը������������
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
	  * insert ����Ԫ��
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
				 return;//�����ظ�����ֱ�ӷ���
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
	  * transplant ��һ�����changeNode������һ�����originNode��λ��
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
	  * deleteNode ɾ��һ����㣬���㷨���ۡ����õ�����transplant
	  * 
	  * **/
	 public void deleteNode (TreeNode dNode) throws Exception{
		 if(dNode.leftChild == null){
			 transplant(dNode,dNode.rightChild);//��������Ϊ�գ����Һ��Ӵ���
		 }
		 else if(dNode.rightChild == null){
			 transplant(dNode, dNode.leftChild);//��������Ϊ�գ������Ӵ���
		 }
		 else{													//�����Ҿ����ڣ�������������С�ڵ�rightMinNode	 															
			 TreeNode rightMinNode = minNode(dNode.rightChild);//�����Һ��ӣ����� rightMinNode�����Һ��ӽ�����
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
 