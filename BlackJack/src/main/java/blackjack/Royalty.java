package blackjack;


public class Royalty extends Card {
    
    private final FigureEnum symbol;
    
    public Royalty(FigureEnum symbol) {
        super(10);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Royalty{" + "symbol=" + symbol + '}';
    }
}
