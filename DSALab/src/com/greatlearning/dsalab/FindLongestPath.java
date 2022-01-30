package com.greatlearning.dsalab;

import java.util.ArrayList;

public class FindLongestPath {
	
	static class Node{
		int nodeData;
		Node rightNode;
		Node leftNode;
	};
	
	static Node newNode(int data) {
		Node tempNode = new Node();
		tempNode.nodeData = data;
		tempNode.leftNode = null;
		tempNode.rightNode = null;
		return tempNode;
	};

	public static ArrayList<Integer>findLongestPath(Node node){
		if(node == null)
		{
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
		}
		
		//recursive call on node.rightNode
		ArrayList<Integer> right = findLongestPath(node.rightNode);
		//recursive call on node.leftNode
		ArrayList<Integer> left = findLongestPath(node.leftNode);
		
		if(right.size() < left.size())
		{
			left.add(node.nodeData);
		}
		else
		{
			right.add(node.nodeData);
		}
		return (left.size() > right.size() ? left:right);
	}
	
	public static void main(String[] args) {
	Node rootNode = newNode(100);
	rootNode.leftNode = newNode(20);
	rootNode.rightNode = newNode(130);
	rootNode.leftNode.rightNode = newNode(50);
	rootNode.leftNode.leftNode = newNode(10);
	rootNode.rightNode.leftNode = newNode(110);
	rootNode.rightNode.rightNode = newNode(140);
	rootNode.leftNode.leftNode.leftNode = newNode(5);
	
	ArrayList<Integer> output = findLongestPath(rootNode);
	int n = output.size();
	
	System.out.print("Longest path "+output.get(n - 1));
	for(int i = n - 2; i >= 0; i--) {
		System.out.print(" -> "+output.get(i));
		}
	}
}