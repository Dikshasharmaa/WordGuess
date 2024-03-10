package com.github.zipcodewilmington;

import java.util.Random;
import java.util.Scanner;

public class Wordguess {
    public static void main(String[] args){
        Wordguess game = new Wordguess();
        game.runGame();
    }



    private String[] words = {"cat","dog","bag","cut","rat","run","bun","sun","mat"};
    private char[] secret;
    private char[] guesses;
    private int numberOfGuesses =0;

    public Wordguess() {
        announce_game();
        initializeGameState();

        //game_over();


    }

    private void initializeGameState(){
        Random rand = new Random();
        int randomNum =rand.nextInt(words.length);
        String secretWord = words[randomNum];
        System.out.println(secretWord);
        this.secret = secretWord.toCharArray();
        String temp = "";
        for(int i = 0;i<secretWord.length();i++){
            temp = temp + "_";
        }
       this.numberOfGuesses = this.secret.length;
        this.guesses = temp.toCharArray();
    }
    private void announce_game(){
        System.out.println("Welcome to the game");
    }
    private boolean gameOver(){
        System.out.println("Game Over");
        System.out.println("Do you want to play again?(Y/N)");
        Scanner userInput = new Scanner(System.in);
        char input1 = userInput.next().charAt(0);
        if(input1 == 'Y'|| input1 == 'y'){
            initializeGameState();
            return true;
        } else if (input1 == 'N'|| input1 == 'n') {
            return false;
        }
        else{
            System.out.println("Invalid input");
            return false;
        }
    }
    private void printArray(char[] a){
        for(char c : a){
            System.out.print(c+" ");
        }
    }
    private void currentGameState (){
        printArray(this.guesses);
        System.out.println("\nYou have "+ this.numberOfGuesses+" guesses left\n");
    }
    private void process(char input){
        for(int i =0;i<this.secret.length;i++){
            if(this.secret[i] == input) {
                this.guesses[i] = input;
            }
        }
        this.numberOfGuesses--;
    }
    private char playerGuess(){
        System.out.println("Enter your Guess: ");
        Scanner userInput = new Scanner(System.in);
        char input = userInput.next().charAt(0);
        return input;
    }
    private boolean isWordGuessed(){
        for(int i =0;i<this.secret.length;i++){
            if(this.secret[i] != this.guesses[i]){
                return false;
            }
        }
        return true;
    }

    private void playerWon(){
        System.out.println("Congratulations you won!");
    }
    private void playerLost(){
        System.out.println("Sorry! you lost");
    }



    private void runGame(){
        boolean wantToPlay = true;
        while (wantToPlay) { //outer loop
            //start the game
            boolean wordGuessed = false;
            currentGameState();
            while (!wordGuessed) { //inner loop
                char input =playerGuess();
                process(input);
                currentGameState();
                if(isWordGuessed() ==true){
                    playerWon();
                    wordGuessed = true;
                } else if (this.numberOfGuesses<=0) {
                    playerLost();
                    break;
                }
            }
            wantToPlay = gameOver();
        }

    }


}