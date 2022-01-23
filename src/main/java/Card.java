
public abstract class Card {
    protected final int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }    
    
    @Override
    public abstract String toString();
}
