package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    // Deux types de Vitesse max. On prend le max des 2
    private double Vraie_Vitesse_Max() {
    	return Math.max( (double)this.data.getMaximumSpeed(), this.data.getGraph().getGraphInformation().getMaximumSpeed() );
    }
    
    
       
    
    // On redéfinit la méthode nouveau label
    
    public Label nouveauLab(Node noeud) {
    	ShortestPathData data = this.getInputData() ;
    	return new LabelStar(noeud, data, this.Vraie_Vitesse_Max());
    }
    
    
    
    
}
