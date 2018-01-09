

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int moveCounter = 0;
    private Node startState;
    private Node goalState;
    private Node currentState = new Node();
    private Queue<Node> queue = new LinkedList();
    private ArrayList<Node> visit = new ArrayList<>();
    private int elements = 0;
    private int nodes = 0;

    public BFS(int state[][], int goal[][]) {
        startState = new Node(state);
        goalState = new Node(goal);
        queue.offer(startState);
        //visit.add(startState);
        elements++;

    }

   private void moveAction(Node currentState) {
        Node newState;
        Blocksworld b = new Blocksworld();

        newState = b.moveDown(currentState);
        if (newState != null) {
            queue.offer(newState);
            elements++;
            nodes ++;
        }

        newState = b.moveLeft(currentState);
        if (newState != null) {
            queue.offer(newState);
            elements++;
            nodes ++;
        }

        newState = b.moveUp(currentState);
        if (newState != null) {
            queue.offer(newState);
            elements++;
            nodes ++;           
        }

        newState = b.moveRight(currentState);
        if (newState != null) {
            queue.offer(newState);
            elements++;
            nodes ++;           
        }
    }
    
    public void BFSearch() {
        boolean findSolution = false;
        currentState = queue.poll();
        moveAction(currentState);
        while (!findSolution) {
            try {
                moveCounter++;               
                currentState = queue.poll();
                System.out.println("---------------------------\n" + currentState.showState() + "----------------------------\n");
                elements--;
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
        System.out.println("Total steps: " + moveCounter);
        System.out.println("Expanded nodes: " + nodes);
    }

    public void BFSgraph() {
        boolean findSolution = false;
        boolean visited;
        Node tempNode;
        currentState = queue.remove();
        elements--;
        visit.add(currentState);
        moveAction(currentState);
        while (!findSolution) {
            try {
                visited = false;
                currentState = queue.remove();                
                elements--;
                for (int i = 0; i < visit.size(); i++) {
                    tempNode = visit.get(i);
                    if (currentState.showState().equals(tempNode.showState())) {
                        visited = true;                        
                        break;
                    }
                }
                if (!visited) {
                    moveCounter++;                    
                    System.out.println("---------------------------\n" + currentState.showState() + "----------------------------\n");
                    if (currentState.getX(1) == goalState.getX(1) && currentState.getY(1) == goalState.getY(1) && currentState.getX(2) == goalState.getX(2) && currentState.getY(2) == goalState.getY(2) && currentState.getX(3) == goalState.getX(3) && currentState.getY(3) == goalState.getY(3)) {
                        findSolution = true;
                        System.out.println("Reached goal state!\n" + currentState.showState());
                        break;
                    } else {
                        moveAction(currentState);
                        visit.add(currentState);                        
                    }
                }

            } catch (Exception e) {
                System.out.println("No solutions found!");
                break;
            }
        }
        System.out.println("Total steps: " + moveCounter);
        System.out.println("Expanded nodes: " + nodes);
        System.out.println("Stored nodes:" + visit.size());
    }

}


