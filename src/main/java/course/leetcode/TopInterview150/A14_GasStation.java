package course.leetcode.TopInterview150;

/**
 * 134. Gas Station (not solved :( )
 * <a href="https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150">
 *     Task link
 * </a>
 * <br/>
 * There are n gas stations along a circular route, where the amount of gas at the i-th station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the i-th station
 * to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * <br/> <br/>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
 * the circuit once in the clockwise direction, otherwise return -1. If there exists a solution,
 * it is guaranteed to be unique.
 * <br/>
 * n == `gas.length` == `cost.length`
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 */
public class A14_GasStation {

    public static void main(String[] args) {
        new A14_GasStation().go();
    }

    private void go() {
        int[] gas;
        int[] cost;
        int result;

        gas = new int[] {5, 8, 2, 8};
        cost = new int[] {6, 5, 6, 6};
        result = canCompleteCircuit(gas, cost);
        assert result == 3;

        gas = new int[] {0, 0, 0, 0, 0, 2};
        cost = new int[] {0, 0, 0, 0, 1, 0};
        result = canCompleteCircuit(gas, cost);
        assert result == 5;

        gas = new int[] {5, 1, 2, 3, 4};
        cost = new int[] {4, 4, 1, 5, 1};
        result = canCompleteCircuit(gas, cost);
        assert result == 4;

        gas = new int[] {4, 5, 2, 6, 5, 3};
        cost = new int[] {3, 2, 7, 3, 2, 9};
        result = canCompleteCircuit(gas, cost);
        assert result == -1;

        gas = new int[] {1, 2, 3, 4, 5};
        cost = new int[] {3, 4, 5, 1, 2};
        result = canCompleteCircuit(gas, cost);
        assert result == 3;
        /*
        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 4. Your tank = 4 - 1 + 5 = 8
        Travel to station 0. Your tank = 8 - 2 + 1 = 7
        Travel to station 1. Your tank = 7 - 3 + 2 = 6
        Travel to station 2. Your tank = 6 - 4 + 3 = 5
        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        Therefore, return 3 as the starting index.
         */

        gas = new int[] {2, 3, 4};
        cost = new int[] {3, 4, 3};
        result = canCompleteCircuit(gas, cost);
        assert result == -1;
        /*
        You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
        Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 0. Your tank = 4 - 3 + 2 = 3
        Travel to station 1. Your tank = 3 - 3 + 3 = 3
        You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
        Therefore, you can't travel around the circuit once no matter where you start.
         */
    }

    /**
     * If the total amount of gas is greater or equal to costs, then even if gas runs out midway,
     * starting from a different location will allow a full circuit.
     * <br/>
     * Thus, by selecting a starting point where gas not run out in the end, we can determine the answer.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int resultIndex = 0; // предполагаемая искомая станция
        int n = gas.length;
        int totalRemainGas = 0;
        int currentGas = 0;;
        for (int i = 0; i < n; i++) {
            totalRemainGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                // для предполагаемой точки топливо закончилось, предполагаем, что следующая точка (i + 1) является искомой
                resultIndex = i + 1;
                currentGas = 0;
            }
        }
        if (totalRemainGas < 0) {
            // количество топлива меньше, чем расход на дорогу, проехать всю дорогу невозможно
            return -1;
        }
        return resultIndex;
    }

    /**
     * O(n^2)
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int resultIndex = -1;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean canReachNextPoint = true;
            for (int j = i; j < n && canReachNextPoint; j++) {
                tank = tank + gas[j] - cost[j];
                if (tank < 0) {
                    canReachNextPoint = false;
                }
            }
            for (int j = 0; j < i && canReachNextPoint; j++) {
                tank = tank + gas[j] - cost[j];
                if (tank < 0) {
                    canReachNextPoint = false;
                }
            }
            if (canReachNextPoint) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }
}
