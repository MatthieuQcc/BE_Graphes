package org.insa.graphs.algorithm.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.insa.graphs.model.*;
import org.insa.graphs.model.RoadInformation.RoadType;
import org.insa.graphs.algorithm.*;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


public class DijkstraTest {

	// On s'inspire de PathTest.java
	
	// Small graph use for tests
    private static Graph graph;

    // List of nodes
    private static Node[] nodes;

    // List of arcs in the graph, a2b is the arc from node A (0) to B (1).
    @SuppressWarnings("unused")
    private static Arc a2b, a2c, a2e, b2c, c2d_1, c2d_2, c2d_3, c2a, d2a, d2e, e2d;
	
    @BeforeClass
    public static void initAll() throws IOException {
    	
    	// 10 and 20 meters per seconds
        RoadInformation speed10 = new RoadInformation(RoadType.MOTORWAY, null, true, 36, "");
        RoadInformation speed20 = new RoadInformation(RoadType.MOTORWAY, null, true, 72, "");
    	
        // Create nodes
        nodes = new Node[6];
        nodes[0]=new Node(0,new Point(0,20));
        nodes[1]=new Node(1,new Point(20,0));
        nodes[2]=new Node(2,new Point(15,43));
        nodes[3]=new Node(3,new Point(12,16));
        nodes[4]=new Node(4,new Point(17,89));
        nodes[5]=new Node(5,new Point(43,45));
        
        // Add arcs...
        a2b = Node.linkNodes(nodes[0], nodes[1], 1, speed10, null);
        a2c = Node.linkNodes(nodes[0], nodes[2], 3, speed20, null);
        a2e = Node.linkNodes(nodes[0], nodes[4], 3, speed10, null);
        b2c = Node.linkNodes(nodes[1], nodes[2], 5, speed10, null);
        c2d_1 = Node.linkNodes(nodes[2], nodes[3], 7, speed20, null);
        c2d_2 = Node.linkNodes(nodes[2], nodes[3], 9, speed10, null);
        c2d_3 = Node.linkNodes(nodes[2], nodes[3], 4, speed20, null);
        d2a = Node.linkNodes(nodes[3], nodes[0], 4, speed20, null);
        d2e = Node.linkNodes(nodes[3], nodes[4], 9, speed10, null);
        e2d = Node.linkNodes(nodes[4], nodes[3], 10, speed20, null);
    	
    	graph = new Graph("ID", "", Arrays.asList(nodes), new GraphStatistics(null,9,1,72,1));     
    	
    }
    
    
    
    
	
    
}
