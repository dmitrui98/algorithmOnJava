package course.ulbiTV;

import java.util.*;

/**
 * Графы. Поиск кратчайшего расстояния. Алгоритм Дейкстры
 */
public class A7_Deikstra {

    public static void main(String[] args) {
        A7_Deikstra search = new A7_Deikstra();
        search.go();
    }

    private void go() {
        Map<String, List<Route>> graph = new HashMap<>();
        graph.put("a", List.of(new Route("b", 4), new Route("c", 1)));
        graph.put("b", List.of(new Route("f", 1)));
        graph.put("c", List.of(new Route("d", 5), new Route("e", 2)));
        graph.put("d", List.of(new Route("f", 2)));
        graph.put("e", List.of(new Route("f", 4)));
        graph.put("f", List.of(new Route("g", 1)));
        graph.put("g", List.of());

        Map<String, Integer> minPathMap = shortPath(graph, "a", "g");
        System.out.println("Кратчайшее расстояние: " + minPathMap);
    }

    public Map<String, Integer> shortPath(Map<String, List<Route>> graph, String start, String end) {
        Map<String, Integer> minPathToVertexMap = new HashMap<>();
        List<String> processedVertex = new ArrayList<>();
        graph.keySet().stream()
                .filter(node -> !node.equals(start))
                .forEach(node -> minPathToVertexMap.put(node, Integer.MAX_VALUE));
        graph.get(start).forEach(route -> {
            minPathToVertexMap.put(route.vertex, route.path);
        });

        String node = findNodeWithLowestCost(minPathToVertexMap, processedVertex);
        while (node != null) {
            Integer cost = minPathToVertexMap.get(node);
            for (Route route : graph.get(node)) {
                int newCost = cost + route.path;
                if (newCost < minPathToVertexMap.get(route.vertex)) {
                    minPathToVertexMap.put(route.vertex, newCost);
                }
            }
            processedVertex.add(node);
            node = findNodeWithLowestCost(minPathToVertexMap, processedVertex);
        }
        return minPathToVertexMap;
    }

    private String findNodeWithLowestCost(Map<String, Integer> nodeToPath, List<String> processed) {
        int minCost = Integer.MAX_VALUE;
        String nodeWithMinCost = null;
        for (Map.Entry<String, Integer> entry : nodeToPath.entrySet()) {
            String node = entry.getKey();
            Integer cost = entry.getValue();
            if (cost < minCost && !processed.contains(node)) {
                minCost = cost;
                nodeWithMinCost = node;
            }
        }
       return nodeWithMinCost;
    }

    private static class Route {
        String vertex;
        Integer path;

        public Route(String vertex, Integer path) {
            this.vertex = vertex;
            this.path = path;
        }
    }
}
