import java.util.Scanner;

interface Player {
    void setPlayerName(String playerName);
}

interface StoryMode {
    void playStory();
}

interface SurvivalMode {
    void playSurvival();
}

interface GameController {
    void startGame();
    void endGame();
}

interface DefaultController {
    void defaultAction();
}

class TextGame implements Player, StoryMode, SurvivalMode, GameController, DefaultController {
    private String playerName;

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void playStory() {
        System.out.println("Welcome to Story Mode, " + playerName + "!");
        
        System.out.println("You are on a quest to save the kingdom.");
    }

    @Override
    public void playSurvival() {
        System.out.println("Welcome to Survival Mode, " + playerName + "!");
        
        System.out.println("Survive as long as you can against waves of enemies.");
    }

    @Override
    public void startGame() {
        System.out.println("Game Controller interface is being used.");
        System.out.println("Game is starting...");
        
    }

    @Override
    public void endGame() {
        System.out.println("Game over. Thanks for playing, " + playerName + "!");
        
    }

    @Override
    public void defaultAction() {
        System.out.println("Default Controller used for the game.");
        System.out.println("Game is starting...");
        System.out.println("Game over. Thanks for playing, " + playerName + "!");
        
    }
}

public class ConsoleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String playerName = scanner.nextLine();

        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");

        char choice = scanner.next().charAt(0);

        TextGame textGame = new TextGame();
        textGame.setPlayerName(playerName);

        switch (choice) {
            case '1':
                textGame.playStory();
                break;
            case '2':
                textGame.playSurvival();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
        }

        System.out.println("Choose your controller:");
        System.out.println("1 - Game Controller");
        System.out.println("2 - Default Controller");

        char controllerChoice = scanner.next().charAt(0);

        switch (controllerChoice) {
            case '1':
                textGame.startGame();
                
                textGame.endGame();
                break;
            case '2':
                
                textGame.defaultAction();
                break;
            default:
                System.out.println("Invalid controller choice. Exiting...");
                System.exit(0);
        }

        scanner.close();
    }
}