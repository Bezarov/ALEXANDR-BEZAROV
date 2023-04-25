package homework_nr_8;
public enum AnimalColorEnum {
    WHITE,
    BLACK,
    RED,
    GREEN,
    BLUE;

    public boolean isColorScary() {
        switch (this) {
            case RED:
            case BLACK:
                return true;
            default:
                return false;
        }
    }
}
