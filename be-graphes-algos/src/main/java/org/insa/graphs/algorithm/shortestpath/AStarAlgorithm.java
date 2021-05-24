package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.*;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    
    // On redéfinit la méthode nouveau label
    
    public Label nouveauLab(Node noeud) {
    	ShortestPathData data = this.getInputData() ;
    	return new LabelStar(noeud, data, this.data.getMaximumSpeed());
    }
    
    
}
