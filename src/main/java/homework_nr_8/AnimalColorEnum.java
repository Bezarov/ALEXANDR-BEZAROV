package homework_nr_8;
public enum AnimalColorEnum {
    WHITE,
    BLACK,
    RED,
    GREEN,
    BLUE;

    public boolean isColorScary(String color) {
        switch (color) {
            case "RED":
            case "BLACK":
                return true;
            default:
                return false;
        }
    }
}
