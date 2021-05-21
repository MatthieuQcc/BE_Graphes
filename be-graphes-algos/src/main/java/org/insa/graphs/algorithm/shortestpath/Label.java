package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;


public class Label implements Comparable<Label> {
	private Node sommetCourant;
	private float cout;
	public Node pere;
	private boolean marque;
	private boolean in_tas;
	
	public Label(Node noeud){
		this.sommetCourant = noeud;
		this.cout = Float.POSITIVE_INFINITY;
		this.pere = null;
		this.marque = false;
		this.in_tas = false;
	}
	
	// Méthodes permettant d'obtenir des infos sur le Label
	public float getCost() {
		return this.cout;
	}
	
	public Node getNode() {
		return this.sommetCourant;
	}
	
	public Node getPere() {
		return this.pere;
	}
	
	public boolean getMarque() {
		return this.marque;
	}
	
	public boolean getDansTas() {
		return this.in_tas;
	}
	
	// Méthode modifiant le label
	
	public void setCost(float arg_cout) {
		this.cout = arg_cout;
	}
	
	public void setNode(Node arg_noeud) {
		this.sommetCourant = arg_noeud;
	}

	public void setPere(Node arg_pere) {
		this.pere = arg_pere;
	}

	public void setMarque(boolean arg_mark) {
		this.marque = arg_mark;
	}
	
	public void setDansTas(boolean arg_tas) {
		this.in_tas = arg_tas;
	}

	
	@Override
	public int compareTo(Label lb) {
		int resultat;
		if(this.getCost()<lb.getCost()) {
			resultat = -1;
		}
				
		else if (this.getCost() == lb.getCost()) {
			resultat = 0;
		}
		
		else {
			resultat = 1;
		}
		return resultat;
	}
	
}