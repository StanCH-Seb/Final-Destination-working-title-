import java.util.Scanner;

public class GameEngine {
 
    Scanner sc = new Scanner(System.in);
    Scene currentScene;
 
    Scene scene1, scene2, scene3;
 
    public void startGame() {
 
        createScenes();
 
        while (true) {
            // Show main menu
            System.out.println("\nScenario 1:");
            System.out.println("A. Start");
            System.out.println("B. Quit");
            System.out.print("Choice: ");
            
            String mainChoice = sc.nextLine().toUpperCase();
            
            if (mainChoice.equals("A")) {
                // Reset to scene1 and start the game
                currentScene = scene1;
                
                boolean gameActive = true;
                while (gameActive) {
                    currentScene.displayScene();
                    System.out.print("Choice: ");
                    String answer = sc.nextLine().toUpperCase();
                    
                    if (answer.equals("A")) {
                        gameActive = processChoice(currentScene.choiceA);
                    }
                    else if (answer.equals("B")) {
                        gameActive = processChoice(currentScene.choiceB);
                    }
                    else {
                        System.out.println("Invalid choice.");
                    }
                }
            }
            else if (mainChoice.equals("B")) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
 
    public boolean processChoice(Choice choice) {
 
        if (choice.gameOver) {
            // Show death message
            System.out.println("\n" + choice.deathMessage);
            System.out.println("Game Over");
            return false; // Game over, go back to main menu
        }
 
        if (choice.nextScene == 2) {
            currentScene = scene2;
        }
        else if (choice.nextScene == 3) {
            currentScene = scene3;
        }
        
        return true; // Game continues
    }
 
    public void createScenes() {
 
        scene1 = new Scene(
            1,
            "You feel your usual path will kill you. Which way do you go?",
            new Choice("Same Path", 0, true, "An Aircon falls on your head. You died instantly."),
            new Choice("Different Path", 2, false, null)
        );
 
        scene2 = new Scene(
            2,
            "A dog blocks the road. What do you do?",
            new Choice("Feed Biscuit", 0, true, "The dog asked for more food, you run out of biscuits, the dog attacked you."),
            new Choice("Pick Object", 3, false, null)
        );
 
        scene3 = new Scene(
            3,
            "You survived Scene 2. More danger awaits...",
            new Choice("Continue", 0, true, "A trap door opens beneath you. You fall into darkness."),
            new Choice("Run Home", 0, true, "On your way home, you slip and fall off a cliff.")
        );
    }
}