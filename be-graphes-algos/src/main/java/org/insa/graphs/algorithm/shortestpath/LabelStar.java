package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.model.*;


public class LabelStar extends Label{
	
	private double cost_estimation;
	
	public LabelStar(Node noeud_actuel, ShortestPathData data, double Vitesse_Max){
		
		super(noeud_actuel); //LabelStar hérite de Label
		
		// Plus court chemin en temps
		if(data.getMode() == Mode.TIME) {
			this.cost_estimation = (noeud_actuel.getPoint().distanceTo(data.getDestination().getPoint())) / Vitesse_Max;		
		}
		
		// Plus court chemin en longueur
		else if(data.getMode() == Mode.LENGTH) {
			this.cost_estimation = noeud_actuel.getPoint().distanceTo(data.getDestination().getPoint());	
		}	
	
	
	}
	
	// Méthodes permettant d'obtenir des infos sur le Label
	
	public double getCostEstimation() {
		return this.cost_estimation;
	}
	
	
	// On redéfinit getTotalCost qui est utilisé dans compareTo de Label
	
	public float getTotalCost() {
		return this.getCost() + (float)this.cost_estimation;
	}
	
	
	
}