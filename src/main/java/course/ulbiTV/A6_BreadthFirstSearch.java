package course.ulbiTV;

import java.util.*;

import static util.ArrayUtil.print;

/**
 * Графы. Поиск в ширину
 */
public class A6_BreadthFirstSearch {

    public static void main(String[] args) {
        A6_BreadthFirstSearch search = new A6_BreadthFirstSearch();
        search.go();
    }

    private void go() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("f"));
        graph.put("c", List.of("d", "e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of("f"));
        graph.put("f", List.of("g"));

        boolean hasWay = breadthSearch(graph, "a", "g");
        System.out.println("Можно ли добраться: " + hasWay);
    }

    public boolean breadthSearch(Map<String, List<String>> graph, String start, String end) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            graph.putIfAbsent(current, Collections.emptyList());
            List<String> currentRoutes = graph.get(current);
            if (currentRoutes.contains(end)) {
                return true;
            } else {
                queue.addAll(currentRoutes);
            }
        }
        return false;
    }
}
