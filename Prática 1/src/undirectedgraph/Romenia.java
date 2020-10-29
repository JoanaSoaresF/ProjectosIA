package undirectedgraph;

public class Romenia {

	public static Graph defineGraph() {

		Graph g = new Graph();
		// Define cities:
		g.addVertice("Oradea", 47.103463342428206, 22.014517353239057);
		g.addVertice("Zerind", 46.71471654964447, 21.41763359920502);
		g.addVertice("Bucharest", 44.38177100515366, 26.237914173135756);
		g.addVertice("Urziceni", 44.71702300789833, 26.550842566604615);
		g.addVertice("Arad", 46.14819674547195, 21.2778636211586);
		g.addVertice("Mehadia", 44.76229383097649, 22.310945753831863);
		g.addVertice("Neamt", 46.91089439856529, 26.349299081926343);
		g.addVertice("Iasi", 47.16411684603691, 27.546529960098265);
		g.addVertice("R. Vilcea", 45.05097210352898, 24.43857919651985);
		g.addVertice("Eforie", 44.027819499893184, 28.580642219171526);
		g.addVertice("Pitesti", 44.82147055624008, 24.74954008477211);
		g.addVertice("Timisoara", 45.797149082775114, 21.246311070613864);
		g.addVertice("Craiova", 44.2945031511116, 23.792533871774673);
		g.addVertice("Hirsova", 44.55606491861343, 28.062494628582);
		g.addVertice("Vaslui", 46.50594706648827, 27.845299215459825);
		g.addVertice("Giurgiu", 43.8745998961544, 26.0341304609108);
		g.addVertice("Sibiu", 45.80322592552185, 24.045402907447816);
		g.addVertice("Dobreta", 44.5311283477974, 22.653995937805174);
		g.addVertice("Fagaras", 45.81110349740028, 25.04516475138664);
		g.addVertice("Lugoj", 45.629197161426546, 21.802857152662277);
		// Define routes:
		g.addEdge("Bucharest","Giurgiu");
		g.addEdge("R. Vilcea","Sibiu");
		g.addEdge("Iasi","Vaslui");
		g.addEdge("Iasi","Neamt");
		g.addEdge("Lugoj","Mehadia");
		g.addEdge("Arad","Timisoara");
		g.addEdge("Arad","Sibiu");
		g.addEdge("Bucharest","Fagaras");
		g.addEdge("Eforie","Hirsova");
		g.addEdge("Fagaras","Sibiu");
		g.addEdge("Bucharest","Urziceni");
		g.addEdge("Craiova","Pitesti");
		g.addEdge("Dobreta","Mehadia");
		g.addEdge("Hirsova","Urziceni");
		g.addEdge("Arad","Zerind");
		g.addEdge("Craiova","R. Vilcea");
		g.addEdge("Craiova","Dobreta");
		g.addEdge("Urziceni","Vaslui");
		g.addEdge("Lugoj","Timisoara");
		g.addEdge("Bucharest","Pitesti");
		g.addEdge("Pitesti","R. Vilcea");
		g.addEdge("Oradea","Zerind");
		g.addEdge("Oradea","Sibiu");
		// Define regions:
		g.addVerticeSet("Banat");
		g.addVerticeToSet("Banat","Mehadia");
		g.addVerticeToSet("Banat","Timisoara");
		g.addVerticeToSet("Banat","Lugoj");
		g.addVerticeSet("Crisana");
		g.addVerticeToSet("Crisana","Oradea");
		g.addVerticeToSet("Crisana","Zerind");
		g.addVerticeToSet("Crisana","Arad");
		g.addVerticeSet("Dobrogea");
		g.addVerticeToSet("Dobrogea","Eforie");
		g.addVerticeToSet("Dobrogea","Hirsova");
		g.addVerticeSet("Moldova");
		g.addVerticeToSet("Moldova","Neamt");
		g.addVerticeToSet("Moldova","Iasi");
		g.addVerticeToSet("Moldova","Vaslui");
		g.addVerticeSet("Muntenia");
		g.addVerticeToSet("Muntenia","Bucharest");
		g.addVerticeToSet("Muntenia","Urziceni");
		g.addVerticeToSet("Muntenia","Giurgiu");
		g.addVerticeSet("Oltenia");
		g.addVerticeToSet("Oltenia","R. Vilcea");
		g.addVerticeToSet("Oltenia","Pitesti");
		g.addVerticeToSet("Oltenia","Craiova");
		g.addVerticeToSet("Oltenia","Dobreta");
		g.addVerticeSet("Transilvania");
		g.addVerticeToSet("Transilvania","Sibiu");
		g.addVerticeToSet("Transilvania","Fagaras");

		return g;
	}

}
