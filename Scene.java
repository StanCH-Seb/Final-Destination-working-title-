public class Scene {
 
    int id;
    String story;
    Choice choiceA;
    Choice choiceB;
 
    public Scene(int id, String story, Choice choiceA, Choice choiceB) {
        this.id = id;
        this.story = story;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
    }
 
    public void displayScene() {
    System.out.println("\n" + story);
    System.out.println("A. " + choiceA.description);  
    System.out.println("B. " + choiceB.description);  
    }
}