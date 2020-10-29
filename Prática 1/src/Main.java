
/**
 * Exercício 1
 */

import searchalgorithm.*;
import searchproblem.*;
import undirectedgraph.*;

public class Main {

    public static void main(String[] args) {

        Graph graph = Romenia.defineGraph();
        graph.showLinks();
        graph.showSets();
        Node n;

        Algorithms[] algorithms = { Algorithms.BreadthFirstSearch, Algorithms.AStarSearch, Algorithms.DepthFirstSearch,
                Algorithms.GreedySearch, Algorithms.UniformCostSearch };

        System.out.println("\n\n\n\n\nOrigem: " + "Arad" + " Destino: " + "Bucharest");
        for (int j = 0; j < 5; j++) {
            n = graph.searchSolution("Zerind", "Hirsova", algorithms[j]);
            graph.showSolution(n);
            // graph.reset();
            graph = Romenia.defineGraph();

        }

    }

}
