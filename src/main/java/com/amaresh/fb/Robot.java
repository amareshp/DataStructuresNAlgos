package com.amaresh.fb;

/**
 * A robot has to move in a grid which is in the form of a matrix. It can go to 
 * 1.) A(i,j)--> A(i+j,j) (Down) 
 * 2.) A(i,j)--> A(i,i+j) (Right) 
 * Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
 * public static int minSteps(int m,int n) 
 * For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2) -> (3, 2) i.e. 2 steps
 * @author apatta2
 *
 */
public class Robot {
    int[][] graphMatrix;
    private boolean reached = false;
    int sCount = 0;
    
    public Robot(int n) {
        graphMatrix = new int[n][n];
        for(int i = 0; i < graphMatrix.length; i++) {
            for(int j = 0; j < graphMatrix.length; j++) {
                graphMatrix[i][j] = -1;
            }
        }
        graphMatrix[1][1] = 0;
    }
    
    public void populateNextStep(int i, int j) {
        if( (i+j) < graphMatrix.length) {
            graphMatrix[i][i+j] = graphMatrix[i][j] + 1;
            graphMatrix[i+j][j] = graphMatrix[i][j] + 1;
            populateNextStep(i, i+j);
            populateNextStep(i+j, j);
        }
    }
    public void populateNextStep2(int i, int j) {
        if( (i+j) < graphMatrix.length) {
            graphMatrix[i+j][j] = graphMatrix[i][j] + 1;
            graphMatrix[i][i+j] = graphMatrix[i][j] + 1;
            populateNextStep(i+j, j);
            populateNextStep(i, i+j);
        }
    }
    
    public int stepsTo(int fromRow, int fromCol, int toRow, int toCol, int step) {
        System.out.println("At: " + fromRow + "," + fromCol);
        if(fromRow == toRow && fromCol == toCol) {
            System.out.println("reached " + toRow + "," + toCol);
            reached = true;
            return sCount;
        } else {
            //check right.
            int row = fromRow;
            int col = fromRow + fromCol;
            if(row <= toRow && col <= toCol && (!reached)) {
                sCount = step + stepsTo(row, col, toRow, toCol, step+1);
            }

            //check down
            row = fromRow + fromCol;
            col = fromCol;
            if(row <= toRow && col <= toCol && (!reached)) {
                sCount = step + stepsTo(row, col, toRow, toCol, step+1);
            }
        }
        return sCount;
    }
    
    public static void printSteps(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.format("%3d  ", matrix[i][j]);
            }
            System.out.println();
        }
        
    }

}
