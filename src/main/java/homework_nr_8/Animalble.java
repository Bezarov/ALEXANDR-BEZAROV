package homework_nr_8;

public interface Animalble {
    default void willBeAnimalEaten(Elephant input){
        if (input.legs < 4 || isAnimalHeavy(input.weight))
            System.out.println(input.name + " is running but not fast enough... \n" +
                    "it probably will be eaten");
        else
            System.out.println(input.name + " is running FAST enough... \n" +
                    "it probably won't be eaten");
    }
    static boolean isAnimalHeavy(int weight) {return weight < 500;}
    void animalSeeYou();
    void animalIsMoving();
}
