import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import distanceMatrix.*;

public class Main {

    static String[] e_1 = { "Atroeira", "Douro", "Pinhal", "Teixoso", "Ulgueira", "Vilar" };

    static String[] e_2 = { "Cerdeira", "Douro", "Gonta", "Infantado", "Lourel", "Nelas", "Oura", "Quebrada",
            "Roseiral", "Serra", "Teixoso", "Ulgueira" };
    static String[] e_3 = { "Belmar", "Cerdeira", "Douro", "Encosta", "Freita", "Gonta", "Horta", "Infantado", "Lourel",
            "Monte", "Nelas", "Oura", "Pinhal", "Quebrada", "Roseiral", "Serra", "Teixoso", "Ulgueira" };
    private static final int NUM_SOL = 10;
    private static final int INIT_ITER = 2000;
    public final static double DECTEMP = 0.91;
    public final static double PROB_INICIAL = 0.90;
    public final static double VAR_ITER = 1.1;
    static int n;

    // vars
    static DistanceMatrix dM, dM1;
    static double T;
    ArrayList<String> init;
    static ArrayList<String> corrente, proximo, melhor;
    static int n_iter;
    private static int timeInit;

    public static void main(String[] args) {
        String c = "../d.txt";
        n = 0;
        String c1 = "C://Users//joana//Documents//Engenharia Informática//3ºAno//1º Semestre//Inteligência Artificial//Práticas//Prática 2//cidades.txt";
        String c2 = "C://Users//joana//Documents//Escola//Engenharia Informática//3ºAno//1º Semestre//Inteligência Artificial//Práticas//Prática 2//cidades.txt";
        dM = new DistanceMatrix(c);
        // TODO
        results("BCGHJOQV");
        results("ABCEGIKLNOPRSTXY");
        results("BCDEFGHIJKLMNOPQRSTUWXYZ");
        // results(e_2);
        // results(e_3);
    }

    private static void results(String iniciais) {
        double max = 0.0;
        double average = 0.0;
        ArrayList<String> e1 = dM.getCities(iniciais);
        double bestDist = Double.POSITIVE_INFINITY;
        String bestSolution = "";
        String pior = "";
        dM1 = new DistanceMatrix(dM, e1);
        // timeInit = System.currentTimeMillis();
        for (int i = 0; i < NUM_SOL; i++) {
            ArrayList<String> solucao = simulatedAnnealing(e1);
            String s = dM.getInitials(solucao);
            double d = calcDist(solucao);
            if (d < bestDist) {
                bestDist = d;
                bestSolution = s;
            }
            System.out.println(s);
            System.out.println(d);
            System.out.println();
            if (d > max) {
                max = d;
                pior = s;
            }
            average += d;
        }
        // System.out.println("execution time: " + (System.currentTimeMillis() -
        // timeInit));
        System.out.println("Melhor solução: " + bestSolution + " com " + bestDist);
        System.out.println("Média: " + average / NUM_SOL + " Máximo: " + max);
        System.out.println("Pior: " + pior);
        System.out.println(n);

    }

    private static void results(String[] e) {
        double max = 0.0;
        double average = 0.0;
        double bestDist = Double.POSITIVE_INFINITY;
        String bestSolution = "";
        String pior = "";
        ArrayList<String> e1 = new ArrayList<>(Arrays.asList(e));
        dM1 = new DistanceMatrix(dM, e1);
        // timeInit = System.currentTimeMillis();
        for (int i = 0; i < NUM_SOL; i++) {
            ArrayList<String> solucao = simulatedAnnealing(e1);
            String s = dM.getInitials(solucao);
            double d = calcDist(solucao);
            if (d < bestDist) {
                bestDist = d;
                bestSolution = s;
            }
            if (d > max) {
                max = d;
                pior = s;
            }
            average += d;
            System.out.println(s);
            System.out.println(d);
            System.out.println();
        }
        // System.out.println("execution time: " + (System.currentTimeMillis() -
        // timeInit));
        System.out.println("Melhor solução: " + bestSolution + " com " + bestDist);
        System.out.println("Média: " + average / NUM_SOL + " Máximo: " + max);
        System.out.println("Pior: " + pior);
        System.out.println(n);

    }

    private static ArrayList<String> simulatedAnnealing(ArrayList<String> e) {
        corrente = new ArrayList<>(e);
        corrente = criaSolucaoInic(corrente);
        proximo = new ArrayList<>(corrente);
        melhor = new ArrayList<>(corrente);
        // proximo = corrente;
        // melhor = corrente;
        n_iter = INIT_ITER;
        T = temperaturaInicial();
        double d = 1;
        while (!criterioParagem(d)) {
            int i;
            for (i = 0; i < n_iter; i++) {
                n++;
                int[] corte = vizinho();
                d = calculoD(corte[0], corte[1]);
                if (d < 0) {
                    // corrente = proximo;
                    corrente = new ArrayList<>(proximo);
                    double d2 = calculoD(corrente, melhor);
                    if (d2 < 0) {
                        melhor = new ArrayList<>(corrente);
                    }

                } else if (Math.random() > Math.exp(-d / T)) {
                    corrente = new ArrayList<>(proximo);
                }
                if (criterioParagem(d)) {
                    return melhor;
                }

            }
            n_iter = var_n_iter();
            decaimento();
        }
        return melhor;

    }

    private static double calcDist(ArrayList<String> c) {
        double dC = dM1.distance(c.get(0), c.get(c.size() - 1));
        for (int i = 0; i < c.size() - 1; i++) {
            dC += dM1.distance(c.get(i), c.get(i + 1));
        }

        return dC;
    }

    private static double calculoD(ArrayList<String> p, ArrayList<String> c) {
        double dP = dM1.distance(p.get(0), p.get(p.size() - 1));
        double dC = dM1.distance(c.get(0), c.get(c.size() - 1));
        for (int i = 0; i < p.size() - 1; i++) {
            dP += dM1.distance(p.get(i), p.get(i + 1));
            dC += dM1.distance(c.get(i), c.get(i + 1));

        }

        return dP - dC;
    }

    private static double calculoD(int i, int j) {
        double dij = dM1.distance(corrente.get(i), corrente.get(j));
        double di1j1 = dM1.distance(corrente.get(i + 1), corrente.get(j + 1));
        double dii1 = dM1.distance(corrente.get(i), corrente.get(i + 1));
        double djj1 = dM1.distance(corrente.get(j), corrente.get(j + 1));
        return dij + di1j1 - dii1 - djj1;
    }

    private static void decaimento() {
        T *= DECTEMP;
    }

    // TODO
    private static double temperaturaInicial() {
        double d1 = 0;
        double d2 = 0;
        for (int i = 0; i < corrente.size() - 1; i++) {
            for (int j = i + 1; j < corrente.size(); j++) {
                double dis = dM1.distance(corrente.get(i), corrente.get(j));
                if (dis > d2) {
                    if (dis > d1) {
                        d1 = dis;
                    } else {
                        d2 = dis;
                    }
                }
            }
        }
        return -(d1 + d2) / Math.log(PROB_INICIAL);

    }

    /*
     * private static ArrayList<String> criaSolucaoInicial(ArrayList<String> e) {
     * ArrayList<String> aux = new ArrayList<String>(e); ArrayList<String> newArr =
     * new ArrayList<String>(); ArrayList<Integer> ind = new ArrayList<Integer>();
     * int j = -1; for (int i = 0; i < aux.size(); i++) { while (ind.contains(j) ||
     * j < 0) j = (int) (Math.random() * (aux.size() - 1)); newArr.add(aux.get(j));
     * ind.add(j); } return newArr; // Collections.shuffle(e); }
     */

    private static ArrayList<String> criaSolucaoInic(ArrayList<String> e) {
        ArrayList<String> aux = new ArrayList<String>(e);
        Collections.shuffle(aux);
        return aux;
        // Collections.shuffle(e);
    }

    private static int var_n_iter() {
        return (int) (n_iter * VAR_ITER);

    }

    private static int[] vizinho() {
        int indexIPlusOne = 1 + (int) (Math.random() * (corrente.size() - 4));
        int indexJ = indexIPlusOne + 1 + (int) (Math.random() * (corrente.size() - indexIPlusOne - 2));
        int[] corte = { indexIPlusOne - 1, indexJ };
        String city1;
        String city2;
        proximo = new ArrayList<String>(corrente);
        while (indexIPlusOne < indexJ) {
            city2 = proximo.remove(indexJ);
            city1 = proximo.remove(indexIPlusOne);
            proximo.add(indexIPlusOne++, city2);
            proximo.add(indexJ--, city1);
        }
        return corte;
    }

    private static boolean criterioParagem(double d) {
        return Math.exp(-d / T) < 0.00001;

    }

}
