package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.insa.graphs.model.*;
import org.insa.graphs.algorithm.AbstractSolution.Status;
import org.insa.graphs.algorithm.utils.*;


public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    
    // Cette méthode va nous être utile pour A*. En effet, elle sera redéfinit dans A*Algorithm
    public Label nouveauLab (Node noeud) {
    	return new Label (noeud) ;
    }   
    
       

    @Override
    protected ShortestPathSolution doRun() {
        
    	// On récupère le graphe afin d'en extraire les informations
    	final ShortestPathData data = getInputData();
        Graph graph = data.getGraph();
        int nbNode = graph.size();
        
        //initialisation de la solution
        ShortestPathSolution solution = null;
        
        // On va créer un tableau avec tous les labels pour chaque noeud
        Label tableauLabels[] = new Label [nbNode];
        
        // Tas de Labels - file de priorité - structure pour obtenir le sommet de plus petit cout 
        BinaryHeap<Label> tasLabels = new BinaryHeap<Label>();
        
        // On crée un tableau des prédécesseurs du noeud
        Arc[] arc_preced = new Arc[nbNode];
        
        
        // Initialisation avec le sommet d'origine
        Label lb_debut = nouveauLab(data.getOrigin());
        tableauLabels[lb_debut.getNode().getId()] = lb_debut;
        tasLabels.insert(lb_debut);
        lb_debut.setCost(0);
        lb_debut.setDansTas(true);
               
       		
        // On notifie qu'on a introduit le premier élement 
        notifyOriginProcessed(data.getOrigin());
        
        // Variable qui reste à true tant qu'on est pas arrivé à destination
        boolean cheminEnCours = true;
        
        
        // Iterations
        while(tasLabels.isEmpty() == false && cheminEnCours) {
        	Label lb_courant = tasLabels.deleteMin();
        	lb_courant.setDansTas(false);
        	lb_courant.setMarque(true);
        	
        	// On notifie qu'on a marqué le label courant
        	notifyNodeMarked(lb_courant.getNode());
        	
        	// est-ce qu'on est à la fin du parcours?
        	if(lb_courant.getNode() == data.getDestination()) {
        		cheminEnCours = false;
        	}
        	
        	
        	// Affiche les couts des Label. Permet de tester l'algo - Les couts sont bien croissants
			lb_courant.afficherCout();       	
        	
        	
        	// On parcourt tous les successeurs de lb_courant :
        	for(Arc arc: lb_courant.getNode().getSuccessors()) {
        		
        		// On récupère le noeud suivant et le label si il existe
        		Node nd_successeur = arc.getDestination();
        		Label lb_successeur = tableauLabels[nd_successeur.getId()];
        		
        		// Si le label n'existe pas alors on va le créer
        		if(lb_successeur == null) {
        			// On notifie qu'on arrive à un noeud pas encore marqué
        			notifyNodeReached(arc.getDestination());
        			lb_successeur = nouveauLab(nd_successeur);
        			// On le met dans le tableau
        	        tableauLabels[lb_successeur.getNode().getId()] = lb_successeur;
        		}
        		
        		
        		// On regarde si le noeud est marqué
        		if(lb_successeur.getMarque() == false) {
        			
        			// Si on a un meilleur cout alors on le met à jour
        			if(lb_successeur.getCost() > (lb_courant.getCost()+data.getCost(arc))) {
        				
        				lb_successeur.setPere(lb_courant.getNode());
        				lb_successeur.setCost(lb_courant.getCost() + (float)data.getCost(arc));
        			
        				// Si le label est déjà dans le tas, on modifie sa position, sinon on l'ajoute
        				if(lb_successeur.getMarque()) {
        					tasLabels.remove(lb_successeur);
        				}
        				else {
        					lb_successeur.setDansTas(true);
        				}
        				tasLabels.insert(lb_successeur);
        				arc_preced[arc.getDestination().getId()] = arc;
        				        			
        			}
        		
        		}
        		        		
        	}
        	
        }

        // On se base sur la fin de l'algo de Bellman Ford pour trouver la solution
        // Si la destination n'a pas de prédécesseur, la solution est impossible
        
        if(arc_preced[data.getDestination().getId()] == null) {
        	solution = new ShortestPathSolution(data, Status.INFEASIBLE);        	
        }
        
        else {
        	// On notifie qu'on a atteint la destination
        	notifyDestinationReached(data.getDestination());
        	
        	// Création du chemin à partir du tableau de prédécesseur
        	ArrayList<Arc> list_arcs = new ArrayList<>();
            Arc arc = arc_preced[data.getDestination().getId()];
            while (arc != null) {
                list_arcs.add(arc);
                arc = arc_preced[arc.getOrigin().getId()];
            }
            
            // On inverse pour avoir le chemin dans le bon sens : du départ jusqu'à l'arrivé
            Collections.reverse(list_arcs);
            
            // Create the final solution.
            solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, list_arcs));
        }    		
        		
        return solution;
    }

}
