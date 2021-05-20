package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import org.insa.graphs.model.Graph;

import org.insa.graphs.algorithm.utils.*;


public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        
        // On récupère le graphe afin d'en extraire les informations
        Graph graph = data.getGraph();
        
        // On récupère le nombre de sommets du graphe afin d'initiliaser le tableau de Label
        int nbLabels = graph.size();
        
        // On va créer un tableau avec tous les labels
        Label tableauLabels[] = new Label [nbLabels];
        
        // Tas de Labels - file de priorité - structure pour obtenir le sommet de plus petit cout 
        BinaryHeap<Label> tasLabels = new BinaryHeap<Label>();
        
        // On associe un label à chaque sommet avec une boucle for
        for(int i = 0; i< nbLabels; i++) {
        	tableauLabels[i].marque = false;
        	tableauLabels[i].cout = Float.POSITIVE_INFINITY;
        	tableauLabels[i].pere = null;
        }
        
        // Initialisation avec le sommet de départ
        Label debut;
        debut.cout = 
        
        
        // TODO:
        return solution;
    }

}
