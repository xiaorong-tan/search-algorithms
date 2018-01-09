public class Node {

    private int BOARD_SIZE = 4;
    int state[][] = new int[BOARD_SIZE][BOARD_SIZE];
    private int depthLevel;
    private int g;

    public Node() {
    }

    public Node(int state[][]) {
        this.state = state;
    }

    public int getNum(int posX, int posY) {
        return state[posX][posY];
    }

    public void setNum(int num, int x, int y) {
        state[x][y] = num;
    }

    public int getX(int num) {
        int positionX = 0;
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (state[x][y] == num) {
                    positionX = x;
                    break;
                }
            }
        }
        return positionX;
    }

    public int getY(int num) {
        int positionY = 0;
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (state[x][y] == num) {
                    positionY = y;
                    break;
                }
            }
        }
        return positionY;
    }

    public void getAxis(int axis[], int num) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (state[x][y] == num) {
                    axis[0] = x;
                    axis[1] = y;
                    break;
                }
            }
        }
    }


    public String showState() {
        String result = "";
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                result += state[i][j];
            }
            result += "\n";
        }
        return result;
    }

    public int[][]  getState() {
        int newstate[][] = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i=0;i<BOARD_SIZE;i++){
            for (int j=0;j<BOARD_SIZE;j++){
                newstate[i][j] = state[i][j];
            }
        }
        return newstate;
    }

    public void setDepthLevel(int depthLevel){
        this.depthLevel = depthLevel;
    }

    public int getDepthLevel(){
        return depthLevel;
    }

    public void setG(int g){this.g = g;}
    public int getG(){return g;}



}
