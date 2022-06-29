import static java.lang.Math.min;
import static java.util.Arrays.fill;


public class Matrix {
    private final int INFINITY = 10001;
    // Матрица смежности индексов

    private int[][] price;
    public Matrix(int vertices) {
        price = new int[vertices][vertices];
    }

    public void setEdge(int i, int j, int weight) {
        price[i][j] = weight;
    }
// Стоимость перевозки
    private int getCost(int i, int j) {
        if (i == j) {
            return 0;
        }

     if (price[i][j] == 0) {
        return INFINITY;
    }
    return price[i][j];
}

    private int getUntaggedVertex(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < price.length; i++) {
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) {
                best = i;
            }
        }
        return best;
    }
    // Путь с минимальной стоимостью между городами
    public Integer[] waysOfCities(int startIndex) {
        boolean[] visited = new boolean[price.length];
        Integer[] result = new Integer[price.length];
        fill(result, INFINITY);
        result[startIndex] = startIndex;

        for (int[] aPrice : price) {
            int city = getUntaggedVertex(result, visited);
            visited[city] = true;
            for (int j = 0; j < price.length; j++) {
                result[j] = min(result[j], result[city] + getCost(city, j));
            }
        }
        return result;
    }
}