
/**
 * Exercício 3 - alterada função searchSolution na classe Graph
 */

import searchalgorithm.*;
import searchproblem.*;
import undirectedgraph.*;

public class Main3 {

    public static void main(String[] args) {
        Graph graph = Romenia.defineGraph();
        /*
         * graph.showLinks(); graph.showSets();
         */
        Node n;
        /** Solução usando o novo grafo */
        n = graph.searchSolution("Zerind", "Urziceni", "Transilvania", Algorithms.AStarSearch);

        /** Mostrar a solução chamando o método no grafo original */
        graph.showSolution(n);
    }

}
