public class Main {
    public static void main(String args[]){
        int startState[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,2,3,4}};
        int goalState[][] = {{0,0,0,0},{0,1,0,0},{0,2,0,0},{0,3,0,0}};
        System.out.println("Start State:");
        for (int i = 0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(startState[i][j]);
            }
            System.out.print("\n");
        }
        long startTime = System.currentTimeMillis();
        DFS dfs = new DFS(startState, goalState);
        //dfs.DFSgraph();
        dfs.DFSearch();
        //BFS bfs = new BFS(startState, goalState);
        //bfs.BFSearch();
        //bfs.BFSgraph();
        //IDS ids = new IDS(startState, goalState);
        //ids.depthLimitedSearch();
        //ids.IDSgraph();
        //Astar a = new Astar(startState, goalState);
        //a.AStarSearch();
        //a.AStargraph();
        long endTime = System.currentTimeMillis();
        System.out.println("Program running time ：" + (endTime - startTime) + "ms");




    }
}
