package game;

import java.util.Scanner;

public class GameSystemDialog {

    private String nameOfGame;

    public GameSystemDialog(String nameOfGame) {
    this.nameOfGame = nameOfGame;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public void menu(String nameOfGame){
        Scanner scanner = new Scanner(System.in);
        p("Welcome to "+ nameOfGame);

        Backpack backpack = new Backpack(10,0);
        p("What is your name?");
        PlayableCharacter player = new PlayableCharacter(scanner.next(), backpack);
        p("Hello " + player.getName()+",\nIn your backpack you have " + backpack.getHowMuchRoom()+ " liters of space available and " + backpack.getHowMuchCash() + " coins.");




    }

    public void p(String words){
        System.out.println(words);
    }
}
