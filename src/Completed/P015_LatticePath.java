package Completed;


/* Problem No. 15 - Lattice Path */

public class P015_LatticePath {

    public static long latticePath(int size) {
        int n = size + 1; 
        long[][] paths = new long[n][n];
        
        for (int i=0; i<n; i++) {
            paths[i][0] = 1;
            paths[0][i] = 1;
        }
        
        for (int y=1; y<n; y++) {
            for (int x=1; x<n; x++) {
                paths[y][x] = paths[y-1][x] + paths[y][x-1];
            }
        }
        return paths[n-1][n-1];        
    }
    
    
}
