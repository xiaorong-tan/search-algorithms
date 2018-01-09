import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class DFS {
    private int moveCounter = 0;
    private Stack<Node> nodeStack = new Stack<Node>();
    private Node startState;
    private Node goalState;
    private Node currentState = new Node();
    private ArrayList<Node> visit = new ArrayList<>();
    private int nodes = 0;

    public DFS(int start[][], int goal[][]) {
        startState = new Node(start);
        goalState = new Node(goal);
        nodeStack.push(startState);
    }

    private void moveAction(Node currentState) {
        Node newState = new Node();
        Blocksworld b = new Blocksworld();
        Random random = new Random();
        boolean choose = false;
        while (choose == false) {
            int i = random.nextInt(4) + 1;
            switch (i) {
                case 1:
                    newState = b.moveUp(currentState);
                    if (newState != null) {
                        nodeStack.push(newState);
                        choose = true;
                        break;
                    }
                    break;
                case 2:
                    newState = b.moveRight(currentState);
                    if (newState != null) {
                        nodeStack.push(newState);
                        choose = true;
                        break;
                    }
                    break;
                case 3:
                    newState = b.moveDown(currentState);
                    if (newState != null) {
                        nodeStack.push(newState);
                        choose = true;
                        break;
                    }
                    break;
                case 4:
                    newState = b.moveLeft(currentState);
                    if (newState != null) {
                        nodeStack.push(newState);
                        choose = true;
                        break;
                    }
                    break;
            }
        }
    }

    private void moveActionG(Node currentState) {
        Node newState = new Node();
        Blocksworld b = new Blocksworld();
        Random random = new Random();

        newState = b.moveUp(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            nodes ++;
        }

        newState = b.moveRight(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            nodes ++;
        }

        newState = b.moveDown(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            nodes ++;
        }

        newState = b.moveLeft(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            nodes ++;
        }

    }


    public void DFSearch() {
        boolean findSolution = false;
        //Node tempNode = new Node();
        currentState = nodeStack.pop();
        moveAction(currentState);
        while (!findSolution) {
            try {

                //System.out.println(moveCounter);
                currentState = nodeStack.pop();
                moveCounter++;
                System.out.println("---------------------------\n" + currentState.showState() + "----------------------------\n");
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
    }

    public void DFSgraph() {
        boolean findSolution = false;
        //Node tempNode = new Node();
        boolean visited;
        Node tempNode;
        currentState = nodeStack.pop();
        visit.add(currentState);
        moveActionG(currentState);
        while (!findSolution) {
            try {
                visited = false;
                currentState = nodeStack.pop();
                for (int i = 0; i < visit.size(); i++) {
                    tempNode = visit.get(i);
                    if (currentState.showState().equals(tempNode.showState())) {
                        visited = true;
                        //System.out.println("保存的与首元素相同的元素：" + tempNode.showState());
                        //System.out.println("elements in queue:" + elements);
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
                        moveActionG(currentState);
                        visit.add(currentState);
                    }
                }
            } catch (Exception e) {
                System.out.println("No solutions found!");
                break;
            }
        }
        System.out.println("Total steps: " + moveCounter);
        System.out.println("Expanded nodes: " + moveCounter);
        System.out.println("Stored nodes:" + visit.size());
    }
}
