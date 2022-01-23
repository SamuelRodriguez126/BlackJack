package blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.IntStream;

public class BlackJack {
    
    static int limit = 21;
    
    public String[] getWinners(Player player1, Player player2, Player player3, Player crupier, Deck deck){
        ArrayList<String> winners = new ArrayList<>();
        Player[] players = new Player[]{player1, player2, player3, crupier};
        ArrayList<Integer> score = new ArrayList<>();
        
        while(crupier.getDeal().sumValue() < 17){
            crupier.getDeal().addCard(deck.getCard());
        }
        
        if(this.checkBlackJack(crupier)){
            winners.add(crupier.toString());
            return winners.toArray(new String[players.length]);
        }
        
        for (Player player : players) {
            if (this.checkBlackJack(player)) {
                score.add(-1);
            } else {
                score.add(Math.abs(limit - player.getDeal().sumValue()));
            }
        }
        
        IntStream.range(0, players.length)
                .filter(i -> Objects.equals(score.get(i), Collections.min(score)))
                .forEach(i -> winners.add(players[i].toString()));

        if(winners.contains(crupier.toString())){
            winners.clear();
            winners.add(crupier.toString());
        }
        return winners.toArray(new String[players.length]);
    }
    
    private boolean checkBlackJack(Player player){
        return player.getDeal().sumValue() == 21 && player.getDeal().getLenght() == 2;
    }
}
