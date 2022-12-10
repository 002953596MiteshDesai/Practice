package com.AquaTurtle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer min = Integer.MIN_VALUE;
        String[][] matrix = {
                {"o","a","a","n"},
                {"e","t","a","e"},
                {"i","h","k","r"},
                {"p","f","l","v"}
        };
        String[] words = {"oath","pea","eat","rain","if"};
    
        ArrayList<String> matches = WordSearch2.getAllMatchesDiagonal(matrix, words);
        System.out.println(matches.toString());
    
        System.out.println("Hello world!");
    
        int[][] matrix1 =  {
                {0,0,0,0},
                {0,min,0,0},
                {0,0,0,0},
                {min,0,0,0},
                {0,min,0,0}
        };
        System.out.println(NumberOfWaysToReachObstacle.numWaysToReachEndWithObstacles(matrix1));
    
        int[][] matrix2 =  {
                {0,min},
                {0,0},
                
        };
    
        System.out.println(NumberOfWaysToReachObstacle.numWaysToReachEndWithObstacles(matrix2));
    
        int[][] matrix3 =  {
                {0,0,0},
                {0,min,0},
                {0,0,0},
        
        };
    
        System.out.println(NumberOfWaysToReachObstacle.numWaysToReachEndWithObstacles(matrix3));
    }
    }

