
/**
 * Exercício 4 - alterada função searchSolution na classe Graph
 */

import searchalgorithm.*;
import searchproblem.*;
import undirectedgraph.*;

public class Main4 {

    public static void main(String[] args) {
        Graph graph = Romenia.defineGraph();
        /*
         * graph.showLinks(); graph.showSets();
         */
        Node n;
        /** Solução usando o novo grafo */

        String[] provs = { "Crisana", "Moldova", "Oltenia" };
        n = graph.searchSolution("Sibiu", "Eforie", provs, Algorithms.AStarSearch);

        /** Mostrar a solução chamando o método no grafo original */
        graph.showSolution(n);
    }

}
