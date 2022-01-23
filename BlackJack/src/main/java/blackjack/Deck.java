package blackjack;

import java.util.List;


public class Deck {
    private List<Card> cards;
    private int pointer;
    
    public Deck() {
        this.pointer = 0;
    }
    
    public Card getCard(){
        this.pointer += 1;
        return this.cards.get(this.pointer-1);
    }
    
    public void initializeDeck(List<Card> cards){
        this.cards = cards;
    }
}
