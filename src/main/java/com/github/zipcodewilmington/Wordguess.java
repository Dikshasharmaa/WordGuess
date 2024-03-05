package com.github.zipcodewilmington;

import java.util.Random;

public class Wordguess {
    public static void main(String[] args){
        Wordguess game = new Wordguess();
        game.runGame();
    }
    private String[] words = {"cat","dog","bag","cut"};
    private char[] secret;
    private char[] guesses;
    public void initializeGameState(){
        Random rand = new Random();
        int randomNum =rand.nextInt(words.length);
        String secretWord = words[randomNum];
        this.secret = secretWord.toCharArray();
        String temp = "";
        for(int i = 0;i<=secretWord.length();i++){
            temp = temp + "_";
        }
        this.guesses = temp.toCharArray();
    }
    public void announce_game(){
        System.out.println("Welcome to the game");
    }
    public void game_over(){
        System.out.println("Game Over");
    }
    public void runGame(){

    }



}
