public class Blocksworld{
    private int BOARD_SIZE = 4;
    public Blocksworld(){}
    private void swap(Node newState, int newPosition[]){
        int emptyTile[] = new int[2];
        int tempNum;
        newState.getAxis(emptyTile,4);
        tempNum = newState.getNum(newPosition[0],newPosition[1]);
        newState.setNum(4,newPosition[0],newPosition[1]);
        newState.setNum(tempNum,emptyTile[0],emptyTile[1]);
        //System.out.println(newState.showState());
    }

    public Node moveDown(Node currentState){
        Node downState = new Node();
        downState = null;
        int downstate[][];
        int newPosition[] = new int[2];
        if (currentState.getX(4) + 1 < BOARD_SIZE){
            downstate = currentState.getState();
            downState = new Node(downstate);
            newPosition[0] = downState.getX(4) + 1;
            newPosition[1] = downState.getY(4);
            swap(downState,newPosition);
        }
        return downState;
    }

    public Node moveUp(Node currentState){
        Node upState = new Node();
        upState = null;
        int upstate[][];
        int newPosition[] = new int[2];
        if (currentState.getX(4) -1 >= 0){
            upstate = currentState.getState();
            upState = new Node(upstate);
            newPosition[0] = upState.getX(4) -1;
            newPosition[1] = upState.getY(4);
            swap(upState,newPosition);
        }
        return upState;

    }


    public Node moveLeft(Node currentState){
        Node leftState;
        leftState = null;
        int leftstate [][] = new int[4][4];
        int newPosition[] = new int[2];
        if (currentState.getY(4) - 1 >= 0){
            leftstate = currentState.getState();
            leftState = new Node(leftstate);
            newPosition[0] = leftState.getX(4);
            newPosition[1] = leftState.getY(4) - 1;
            swap(leftState,newPosition);
            //System.out.println(currentState.showState());
        }
        return leftState;
    }


    public Node moveRight(Node currentState){
        Node rightState = new Node();
        rightState = null;
        int rightstate[][];
        int newPosition[] = new int[2];
        if (currentState.getY(4) + 1 < BOARD_SIZE){
            rightstate = currentState.getState();
            rightState = new Node(rightstate);
            newPosition[0] = rightState.getX(4);
            newPosition[1] = rightState.getY(4)+1;
            swap(rightState,newPosition);
        }
        return rightState;
    }

}