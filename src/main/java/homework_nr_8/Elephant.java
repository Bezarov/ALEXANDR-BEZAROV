package homework_nr_8;

public class Elephant extends Erbivor implements Animalble {
    int eyes;
    int legs;
    int teeth;
    int weight;
    String name;
    AnimalColorEnum[] colorEnum;
    String Color;

    Elephant(String name, int legs, int teeth, int weight, int eyes, String Color) {
        this.name = name;
        this.legs = legs;
        this.eyes = eyes;
        this.teeth = teeth;
        this.weight = weight;
        this.Color = Color;
    }
    @Override
    public void willBeAnimalEaten(Elephant input) {
        Animalble.super.willBeAnimalEaten(input);
    }
    @Override
    public void animalSeeYou() {
        if (eyes > 0)
            System.out.println(this.name + " sees you");
        else
            System.out.println("This object - " + this.name + " can't moving, add more than " + this.legs + " legs");
    }
    @Override
    public void animalIsMoving() {
        if (legs > 1)
            System.out.println(this.name + " is moving");
        else
            System.out.println("This object - " + this.name + " can't moving, add more than " + this.legs + " legs");
    }
    @Override
    public void animalColor(Elephant animal) {
        if (AnimalColorEnum.valueOf(animal.Color).isColorScary(animal.Color))
            System.out.println(animal.name + " color: " + animal.Color + " a bit scary");
        else
            System.out.println(animal.name + " color: " + animal.Color + " Not scary at all )");
    }
}
