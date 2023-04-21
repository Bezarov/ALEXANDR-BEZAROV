package homework_nr_8;

public abstract class Erbivor {
    public void isAnimalScary(Elephant animal){
        if (animal.teeth > 50 || AnimalColorEnum.valueOf(animal.Color).isColorScary(animal.Color))
            System.out.println(animal.name + " scary, number teeth: " + animal.teeth + " but...");
        else
            System.out.println(animal.name + " not so scary, number teeth: " + animal.teeth + " but...");
    }
    public abstract void animalColor(Elephant animal);
}
