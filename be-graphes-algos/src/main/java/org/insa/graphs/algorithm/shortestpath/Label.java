package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Node;

public class Label implements Comparable<Label> {
	public Node sommetCourant;
	public boolean marque;
	public float cout;
	public Node pere;
	
	public Label(Node noeud){
		this.sommetCourant = noeud;
		this.marque = false;
		this.cout = Float.POSITIVE_INFINITY;
		this.pere = null; 
	}
	
	public float getCost() {
		return this.cout;
	}
	
	public boolean getMarque() {
		return this.marque;
	}
	
	public Node getNode() {
		return this.sommetCourant;
	}
	
	public Node getPere() {
		return this.pere;
	}
	
	
	
}

