package Completed;


/* Problem No. 28 - Number Spiral Diagonals */

public class P028_NumberSpiralDiagonals {
    
    public static int[][] generateSpiral(int size) {
        int[][] spiral = new int[size][size];
        int x = size / 2;
        int y = size / 2;
        
        spiral[y][x] = 1;
        int counter = 2;
        int steps = 1;
        
        while(spiral[0][0] == 0) {
            for(int i=0; i<steps; i++) {
                x += 1;
                spiral[y][x] = counter;
                counter++;
            }
            for(int i=0; i<steps; i++) {
                y += 1;
                spiral[y][x] = counter;
                counter++;
            }
            steps++;
            for(int i=0; i<steps; i++) {
                x -= 1;
                spiral[y][x] = counter;
                counter++;
            }
            for(int i=0; i<steps; i++) {
                y -= 1;
                spiral[y][x] = counter;
                counter++;
            }
            steps++;
        }
        
        while (spiral[0][size-1] == 0) {
            x += 1;
            spiral[0][x] = counter;
            counter++;
        }
        
        return spiral;
    }
    
    public static int sumDiagonals(int[][] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i][i];
        }
        for (int i=0; i<array.length; i++) {
            sum += array[i][array.length-i-1];
        }
        sum--;
        return sum;
    }
    
    public static void print2DArray(int[][] array) {
        for (int j=0; j<array.length; j++) {
            for (int i=0; i<array[0].length; i++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] spiral = generateSpiral(1001);
        
        int sum = sumDiagonals(spiral);
        System.out.println(sum);
        
    }

}
