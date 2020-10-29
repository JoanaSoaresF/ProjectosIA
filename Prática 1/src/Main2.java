
/**
 * Exercício 2
 */

import searchalgorithm.*;
import searchproblem.*;
import undirectedgraph.*;

public class Main2 {

    public static void main(String[] args) {

        String[] origem = { "Arad", "Bucharest", "Oradea", "Timisoara" };
        String[] destino = { "Bucharest", "Oradea", "Bucharest", "Neamt" };
        Algorithms[] algorithms = { Algorithms.BreadthFirstSearch, Algorithms.AStarSearch, Algorithms.DepthFirstSearch,
                Algorithms.GreedySearch, Algorithms.UniformCostSearch };
        Graph graph = Romenia.defineGraph();
        graph.showLinks();
        graph.showSets();
        Node n;

        for (int i = 1; i <= 4; i++) {

            System.out.println("\n\n\n\n\nOrigem: " + origem[i - 1] + " Destino: " + destino[i - 1]);
            for (int j = 0; j < 5; j++) {
                System.out.println("Algoritmo: " + algorithms[j].toString());
                n = graph.searchSolution(origem[i - 1], destino[i - 1], algorithms[j]);
                graph.showSolution(n);
                // graph.reset();
                graph = Romenia.defineGraph();

            }

        }

    }

}
