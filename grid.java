
public class grid{
        private int n;
        long result;

// Declare more variables here if you need...
        public int edge[][];
        public boolean visit[];

        public grid(int n){
                this.n = n;
                this.result = 0;
        }
        long numOfWays(){
                result = 0;
                int a = n+1;
                int nodes = a*a;
                edge = new int[nodes][nodes];
                visit = new boolean[nodes];
                for(int i = 0; i<nodes;i++)
                        visit[i] = false;

                for(int i = 0; i<nodes; i++){
                        for(int j = 0; j<nodes;j++)
                                edge[i][j] = 0;
                        }

                for(int i = 0; i<nodes-1;i++) {
                        if(i%a == a-1) {
                                edge[i][i+a] = 1;
                                edge[i+a][i] = 1;
                        }
                        else if(nodes-a<=i) {
                                edge[i][i+1] = 1;
                                edge[i+1][i] = 1;

                        }
                        else {
                                edge[i][i+1] = 1;
                                edge[i+1][i] = 1;
                                edge[i][i+a] = 1;
                                edge[i+a][i] = 1;
                                }
                        }
                DFS(0, nodes-1);

                return result;
        }
   void DFS(int v, int goal) {
        visit[v] = true;
        if(v == goal) result++;

        for(int i = 0; i<=goal; i++) {
                if(edge[v][i] == 1 && !visit[i]) {
                        DFS(i, goal);
                        visit[i] = false;
                }
        }

    }



}

