package homework_nr_8;

public class Elephant extends Erbivor implements Animalble {
    int eyes;
    int legs;
    int teeth;
    int weight;
    String name;
    AnimalColorEnum color;

    public Elephant(String name, int eyes, int legs, int teeth, int weight,  AnimalColorEnum color) {
        this.eyes = eyes;
        this.legs = legs;
        this.teeth = teeth;
        this.weight = weight;
        this.name = name;
        this.color = color;
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
        if (animal.color.isColorScary())
            System.out.println(animal.name + " color: " + animal.color + " a bit scary");
        else
            System.out.println(animal.name + " color: " + animal.color + " Not scary at all )");
    }
}
