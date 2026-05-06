public class Choice {
    String description;
    int nextScene;
    boolean gameOver;
    String deathMessage; 
    
    public Choice(String description, int nextScene, boolean gameOver, String deathMessage) {
        this.description = description;
        this.nextScene = nextScene;
        this.gameOver = gameOver;
        this.deathMessage = deathMessage;
    }
}