package com.AquaTurtle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    
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
    }
    }

