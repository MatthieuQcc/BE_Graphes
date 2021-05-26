package org.insa.graphs.algorithm.utils;

import org.insa.graphs.algorithm.shortestpath.AStarAlgorithm;
import org.insa.graphs.algorithm.shortestpath.ShortestPathAlgorithm;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;

public class AStarTest extends DijkstraTest{
	
	// On redéfinit juste doAlgo qu'on a définit dans DijkstraTest
	protected ShortestPathAlgorithm doAlgo(ShortestPathData data) {
    	return new AStarAlgorithm(data);
    }
}