package homework_nr_8;

public class Main {
    public static void main(String[] args) {
        Animalble Sheep = new Elephant("Manea",4, 39, 501, 2, AnimalColorEnum.valueOf("WHITE"));
        Animalble Goat = new Elephant("Marusea",1, 39, 499, 2, AnimalColorEnum.valueOf("BLACK"));
        Erbivor Cow = new Elephant("Bureonka", 4, 30, 300,2, AnimalColorEnum.valueOf("RED"));
        Erbivor Crocodile = new Elephant("Gena", 4, 150,200,2, AnimalColorEnum.valueOf("GREEN"));

        Sheep.willBeAnimalEaten((Elephant) Sheep);
        Goat.willBeAnimalEaten((Elephant) Goat);

        Sheep.animalIsMoving();
        Sheep.animalSeeYou();

        Goat.animalSeeYou();
        Goat.animalIsMoving();

        Cow.isAnimalScary((Elephant) Cow);
        Cow.animalColor((Elephant) Cow);

        Crocodile.isAnimalScary((Elephant) Crocodile);
        Crocodile.animalColor((Elephant) Crocodile);
    }
}
