package com.amaresh;

public class PascalsTriangle {
    private int[][] triangle;
    
    public PascalsTriangle(int rows) {
        triangle = new int[rows][rows];
        triangle[0][0] = 1;
        int[] parent = triangle[0];
        
        for(int i=1; i<rows; i++) {
            int[] row = new int[i+1];
            for(int j=0; j<=i; j++) {
                if(j == 0) {
                    row[j] = 0 + parent[j];
                } else if(j == i) {
                    row[j] = parent[j-1] + 0;
                } else {
                    row[j] = parent[j-1] + parent[j];
                }
            }
            copy(row, triangle[i]);
            parent = triangle[i];
        }
    }
    
    public void print() {
        for(int i=0; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                System.out.print(triangle[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    private void copy(int[] fromArray, int[] toArray) {
        for(int i=0; i<fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }

}
