
public class Ace extends Card {

    private final int secondValue;
    
    public Ace() {
        super(11);
        this.secondValue = 1;
    }

    public int getSecondValue() {
        return secondValue;
    }

    @Override
    public String toString() {
        return "Ace{" + '}';
    }
}
