import java.util.ArrayList;
import java.util.Stack;

public class IDS {
    private int moveCounter = 0;
    private Stack<Node> nodeStack = new Stack<Node>();
    private Node startState;
    private Node goalState;
    private Node currentState = new Node();
    private int depth = 0;
    private int limit = -1;
    private int node = 0;
    private ArrayList<Node> visit = new ArrayList<>();


    public IDS(int start[][], int goal[][]) {
        startState = new Node(start);
        goalState = new Node(goal);

    }

    private void moveAction(Node currentState) {
        Node newState = new Node();
        Blocksworld b = new Blocksworld();

        newState = b.moveUp(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            node++;
            newState.setDepthLevel(currentState.getDepthLevel() + 1);
            //System.out.println("子节点层数：" + newState.getDepthLevel());
        }


        newState = b.moveRight(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            node++;
            newState.setDepthLevel(currentState.getDepthLevel() + 1);
            //System.out.println("子节点层数：" + newState.getDepthLevel());
        }

        newState = b.moveDown(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            node++;
            newState.setDepthLevel(currentState.getDepthLevel() + 1);
            //System.out.println("子节点层数：" + newState.getDepthLevel());
        }

        newState = b.moveLeft(currentState);
        if (newState != null) {
            nodeStack.push(newState);
            node++;
            newState.setDepthLevel(currentState.getDepthLevel() + 1);
            //System.out.println("子节点层数：" + newState.getDepthLevel());

        }

    }

    public void depthLimitedSearch() {
        boolean findSolution = false;
        while (!findSolution) {
            try {
                nodeStack.push(startState);
                limit++;
                //depth = 0;
                startState.setDepthLevel(0);
                while (!nodeStack.isEmpty()) {
                    moveCounter++;
                    //System.out.println("Step:" + moveCounter);
                    currentState = nodeStack.pop();
                    System.out.println("Depth: " + currentState.getDepthLevel() + "----------------\n" + currentState.showState() + "----------------------------\n");

                    //System.out.println("Depth：" + limit);
                    if (currentState.getX(1) == goalState.getX(1) && currentState.getY(1) == goalState.getY(1) && currentState.getX(2) == goalState.getX(2) && currentState.getY(2) == goalState.getY(2) && currentState.getX(3) == goalState.getX(3) && currentState.getY(3) == goalState.getY(3)) {
                        findSolution = true;
                        System.out.println("Reached goal state!\n" + currentState.showState());
                        break;
                    } else if (currentState.getDepthLevel() < limit) {
                        moveAction(currentState);
                        //depth++;
                    }
                }
            } catch (Exception e) {
                System.out.println("No solutions found!");
                break;
            }
        }
        System.out.println("Solution has been found!" + "\n" + currentState.showState());
        System.out.println("Total steps: " + moveCounter + "\n" + "Total depths:" + limit);
        System.out.println("Expanded nodes: " + node);
    }

    public void IDSgraph() {
        boolean findSolution = false;
        boolean visited;
        Node tempNode;
        while (!findSolution) {
            try {
                //visited = false;
                nodeStack.push(startState);
                visit.clear();
                limit++;
                //depth = 0;
                startState.setDepthLevel(0);
                while (!nodeStack.isEmpty()) {
                    moveCounter++;
                    visited = false;
                    //System.out.println("Step:" + moveCounter);
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
                        System.out.println("Depth: " + currentState.getDepthLevel() + "----------------\n" + currentState.showState() + "----------------------------\n");

                        //System.out.println("Depth：" + limit);
                        if (currentState.getX(1) == goalState.getX(1) && currentState.getY(1) == goalState.getY(1) && currentState.getX(2) == goalState.getX(2) && currentState.getY(2) == goalState.getY(2) && currentState.getX(3) == goalState.getX(3) && currentState.getY(3) == goalState.getY(3)) {
                            findSolution = true;
                            System.out.println("Reached goal state!\n" + currentState.showState());
                            break;
                        } else if (currentState.getDepthLevel() < limit) {
                            moveAction(currentState);
                            visit.add(currentState);

                            //depth++;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("No solutions found!");
                break;
            }
        }
        System.out.println("Solution has been found!" + "\n" + currentState.showState());
        System.out.println("Total steps: " + moveCounter + "\n" + "Total depths:" + limit);
        System.out.println("Expanded nodes: " + node);
        System.out.println("Stored nodes:" + visit.size());
    }
}


