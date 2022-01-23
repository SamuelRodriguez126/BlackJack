package blackjack;

public class Deal {
    private Card[] cards;

    public Deal(Card[] cards) {
        this.cards = cards;
    }

    public int sumValue(){
        int sum = 0;
        int aces = 0;
        Ace ace = new Ace();
        for (Card card : cards) {
            if(card.getClass().equals(Ace.class)){
                aces++;
            }
            sum += card.getValue();
        }        
        
        while(sum > BlackJack.limit && aces > 1){
            sum -= Math.abs(ace.getValue() - ace.getSecondValue());
        }
        return sum;
    }
    
    public int getLenght(){
        return this.cards.length;
    }
    
    public void addCard(Card card){
        Card[] newCards = new Card[this.cards.length + 1];
        System.arraycopy(this.cards, 0, newCards, 0, this.cards.length);
        newCards[this.cards.length] = card;
        this.cards = newCards;
    }
}
