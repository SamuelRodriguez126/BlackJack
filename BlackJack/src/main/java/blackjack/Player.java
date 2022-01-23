package blackjack;


public class Player {
    private final String name;
    private Deal deal;
    
    public Player(String name) {
        this.name = name;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
    
    @Override
    public String toString(){
       return this.name;
    }
}
