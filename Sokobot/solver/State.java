package solver;
import java.util.*;

public class State {
    private StringBuilder moves;
    private char[][] charMap;
    private int prioVal;
    private StringBuilder strMap;

    // initial state constructor
    public State(int width, int height, char[][] itemsData) {
        prioVal = 0;
        moves = new StringBuilder();
        charMap = new char[height][width];
        strMap = new StringBuilder();
        inputMap(width, height, itemsData);
    }

    // nextState constructor
    public State(int width, int height, StringBuilder currMoves, char[][] itemsData, char[][] mapData) {
        moves = new StringBuilder(currMoves);
        charMap = new char[height][width];
        strMap = new StringBuilder();
        inputMap(width, height, itemsData);
        prioVal = calcPrioVal(width, height, mapData);
    }

    private void inputMap(int width, int height, char[][] itemsData) {
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                charMap[i][j] = itemsData[i][j];
                strMap.append(charMap[i][j]);
            }
            strMap.append('\n');
        }
    }

    public int calcPrioVal(int width, int height, char[][] mapData) {

        int heuristic = findHeuristic(width, height, mapData);
        if (moves != null)
            return moves.length() + heuristic;
        return heuristic;
    }

    private int findHeuristic(int width, int height, char[][] mapData) {
        //  this function: estimates cost of moving ALL crates to their closest goals while making sure each crate is assigned to their own target
        int heuristic = 0;

        ArrayList<Integer> crateX = new ArrayList<>();
        ArrayList<Integer>  crateY = new ArrayList<>();
        ArrayList<Integer>  targetX = new ArrayList<>();
        ArrayList<Integer>  targetY = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (charMap[y][x] == '$') {
                    crateX.add(x);
                    crateY.add(y);
                }
                if (mapData[y][x] == '.') {
                    targetX.add(x);
                    targetY.add(y);
                }
            }
        }

        // Create an array to track which goals have been assigned to crates
        boolean[] goalAssigned = new boolean[targetX.size()];

        for (int i = 0; i < crateX.size(); i++) {
            int cratePosX = crateX.get(i);
            int cratePosY = crateY.get(i);

            int minDistance = Integer.MAX_VALUE;
            int nearestGoalIndex = -1;

            for (int j = 0; j < targetX.size(); j++) {
                if (!goalAssigned[j]) {
                    int goalPosX = targetX.get(j);
                    int goalPosY = targetY.get(j);

                    int distance = Math.abs(cratePosX - goalPosX) + Math.abs(cratePosY - goalPosY);

                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestGoalIndex = j;
                    }
                }
            }

            heuristic += minDistance;

            // Mark the assigned goal to ensure each crate is assigned to one target
            goalAssigned[nearestGoalIndex] = true;
        }

        return heuristic;
    }

    public String getMoves () {
        return moves.toString();
    }

    public void addMoves (char c) { moves.append(c); }

    public int getPrioVal () {
        return prioVal;
    }

    public char[][] getCharMap () { return charMap; }

    public StringBuilder getMovesSB () { return moves; }

    public StringBuilder getStrMap() {
        return strMap;
    }
}