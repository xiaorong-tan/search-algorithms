import java.util.ArrayList;
import java.util.Collections;

public class Astar {
    private int moveCounter = 0;
    private Node startState;
    private Node goalState;
    private Node currentState = new Node();
    private ArrayList<Node> openList = new ArrayList<>();
    private ArrayList<Node> minListState = new ArrayList<>();
    private ArrayList<Integer> stateValue = new ArrayList<>();
    private ArrayList<Integer> minListValue = new ArrayList<>();
    private ArrayList<Node> visit = new ArrayList<>();
    private int Fvalue;
    private int g;
    private int nodes = 0;


    public Astar(int start[][], int goal[][]) {
        startState = new Node(start);
        goalState = new Node(goal);
    }

    private void moveAction(Node currentState) {
        Node newState = new Node();
        Blocksworld b = new Blocksworld();
        int f;
        int g;

        newState = b.moveUp(currentState);
        if (newState != null) {
            g = calculateG(newState, currentState);
            f = calculateF(newState, g);
            openList.add(newState);
            stateValue.add(f);
            nodes++;

        }

        newState = b.moveRight(currentState);
        if (newState != null) {
            g = calculateG(newState, currentState);
            f = calculateF(newState, g);
            openList.add(newState);
            stateValue.add(f);
            nodes++;
        }

        newState = b.moveDown(currentState);
        if (newState != null) {
            g = calculateG(newState, currentState);
            f = calculateF(newState, g);
            openList.add(newState);
            stateValue.add(f);
            nodes++;
        }

        newState = b.moveLeft(currentState);
        if (newState != null) {
            g = calculateG(newState, currentState);
            f = calculateF(newState, g);
            openList.add(newState);
            stateValue.add(f);
            nodes++;
        }

    }

    private int manhattanH(Node currentState) {
        int h = 0;
        int goalX;
        int goalY;
        for (int i = 1; i < 4; i++) {
            goalX = goalState.getX(i);
            goalY = goalState.getY(i);
            h += Math.abs(currentState.getX(i) - goalX) + Math.abs(currentState.getY(i) - goalY);
        }
        return h;
    }

    private int calculateF(Node currentState, int g) {
        int h = manhattanH(currentState);
        int f;
        f = g + h;        
        return f;
    }

    private int calculateG(Node newState, Node currentState) {
        
        if (newState.getX(1) != currentState.getX(1) || newState.getY(1) != currentState.getY(1)) {
            newState.setG(currentState.getG() + 1);
        }
        if (newState.getX(2) != currentState.getX(2) || newState.getY(2) != currentState.getY(2)) {
            newState.setG(currentState.getG() + 1);
        }
        if (newState.getX(3) != currentState.getX(3) || newState.getY(3) != currentState.getY(3)) {
            newState.setG(currentState.getG() + 1);
        }       
        return newState.getG();

    }

    public void AStarSearch() {
        int minFValueIndex;
        boolean findSolution = false;
        startState.setG(0);
        moveAction(startState);
        while (!findSolution) {
            try {
                for (int i = 0; i < stateValue.size(); i++) {
                    if (stateValue.get(i) == Collections.min(stateValue)) {
                        minListValue.add(stateValue.get(i));
                        //Collections.reverse(openList);
                        minListState.add(openList.get(i));
                        //openList.remove(openList.get(stateValue.indexOf(stateValue.get(i))));
                        //System.out.println("最小值相同的状态：" + "\n" + (openList.get(i)).showState());
                    }
                }
                if (minListValue.size() > 1) {
                    openList.clear();
                    stateValue.clear();                    
                    stateValue.add(minListValue.get(minListValue.size() - 1));
                    Collections.shuffle(minListState);
                    openList.add(minListState.get(0));
                    minListValue.clear();
                    minListState.clear();
                }
                minFValueIndex = stateValue.indexOf(Collections.min(stateValue));
                currentState = openList.get(minFValueIndex);
                Fvalue = stateValue.get(minFValueIndex);
                stateValue.remove(minFValueIndex);
                openList.remove(minFValueIndex);
                System.out.println("Minimum F:" + Fvalue);
                System.out.println("Current State:" + "\n" + currentState.showState());
                moveCounter++;               
                if (currentState.getX(1) == goalState.getX(1) && currentState.getY(1) == goalState.getY(1) && currentState.getX(2) == goalState.getX(2) && currentState.getY(2) == goalState.getY(2) && currentState.getX(3) == goalState.getX(3) && currentState.getY(3) == goalState.getY(3)) {
                    findSolution = true;
                    System.out.println("Reached goal state!\n" + currentState.showState());
                    break;
                } else {
                    moveAction(currentState);
                }
            } catch (Exception e) {
                System.out.println("No solutions found!");
                break;
            }
        }
        System.out.println("Current State:" + "\n" + currentState.showState());
        System.out.println("Total steps: " + moveCounter);
        System.out.println("Value of F:" + Fvalue);
        System.out.println("Expanded nodes: " + nodes);
    }


}
