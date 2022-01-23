import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTests {

    private Player player1;
    private Player player2;
    private Player player3;
    private Player crupier;
    private Deck deck;
    
    private BlackJack blackJack;
    
    @Before
    public void setUp() {
        this.blackJack = new BlackJack();
        this.player1 = new Player("Player1");
        this.player2 = new Player("Player2");
        this.player3 = new Player("Player3");
        this.crupier = new Player("Crupier");
        this.deck = new Deck();
    }
    
    @Test
    public void case_1_return_player1_when_player1_has_blackjack(){
        String[] winners = new String[4];
        winners[0] = "Player1";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Ace()}));
        this.player2.setDeal(new Deal(new Card[]{new Number(10), new Number(5), new Number(6)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(3), new Number(6), new Ace(), new Number(3), new Ace(), new Royalty(FigureEnum.King)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(9), new Number(7)}));
        this.deck.initializeDeck(Arrays.asList(new Number(6), new Number(4), new Royalty(FigureEnum.Jack), new Number(2)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_2_return_player2_when_player2_win(){
        String[] winners = new String[4];
        winners[0] = "Player2";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Number(6)}));
        this.player2.setDeal(new Deal(new Card[]{new Number(10), new Number(5), new Number(6)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(5), new Number(6), new Number(7)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(4), new Number(7), new Number(9)}));
        this.deck.initializeDeck(Arrays.asList(new Number(3), new Number(3), new Royalty(FigureEnum.King), new Number(2)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_3_return_player1_player2_when_both_have_blackJack(){
        String[] winners = new String[4];
        winners[0] = "Player1";
        this.player1.setDeal(new Deal(new Card[]{new Number(8), new Number(2), new Number(9)}));
        this.player2.setDeal(new Deal(new Card[]{new Number(5), new Number(9), new Number(4)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(10), new Number(10), new Number(5)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(5), new Royalty(FigureEnum.Queen), new Number(3)}));
        this.deck.initializeDeck(Arrays.asList(new Number(4), new Number(5), new Number(8), new Royalty(FigureEnum.Queen)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_4_return_player11_when_player1_won_under_21(){
        String[] winners = new String[4];
        winners[0] = "Player1";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Ace()}));
        this.player2.setDeal(new Deal(new Card[]{new Number(5), new Number(8), new Number(9)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(2), new Number(9), new Royalty(FigureEnum.Queen)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(5), new Number(6), new Number(5), new Number(5)}));
        this.deck.initializeDeck(Arrays.asList(new Number(6), new Number(8), new Number(2), new Royalty(FigureEnum.Queen)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_5_return_player1_when_player1_has_blackJack_and_crupier_has_21(){
        String[] winners = new String[4];
        winners[0] = "Player1";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Ace()}));
        this.player2.setDeal(new Deal(new Card[]{new Number(5), new Number(8), new Number(9)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(2), new Number(9), new Royalty(FigureEnum.Queen)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(5), new Number(6), new Number(5), new Number(5)}));
        this.deck.initializeDeck(Arrays.asList(new Number(6), new Number(8), new Number(2), new Royalty(FigureEnum.Queen)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_6_return_crupier_when_crupier_won_without_take_a_card_from_deck(){
        String[] winners = new String[4];
        winners[0] = "Crupier";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Royalty(FigureEnum.Queen), new Number(5)}));
        this.player2.setDeal(new Deal(new Card[]{new Ace(), new Royalty(FigureEnum.Jack)}));
        this.player3.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Ace()}));
        this.crupier.setDeal(new Deal(new Card[]{new Ace(), new Royalty(FigureEnum.King)}));
        this.deck.initializeDeck(Arrays.asList(new Number(5), new Number(4), new Number(3), new Number(7)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_7_return_crupier_when_crupier_won_taking_one_card_from_deck(){
        String[] winners = new String[4];
        winners[0] = "Crupier";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Number(4), new Number(7)}));
        this.player2.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Number(5), new Number(6)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(2), new Number(8), new Number(9)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(5), new Number(6), new Number(5)}));
        this.deck.initializeDeck(Arrays.asList(new Number(5), new Number(6), new Number(8), new Ace()));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_8_return_crupier_when_crupier_has_blackJack_taking_one_card(){
        String[] winners = new String[4];
        winners[0] = "Crupier";
        this.player1.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack), new Number(4), new Number(7)}));
        this.player2.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Number(5), new Number(6)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(2), new Number(8), new Number(9)}));
        this.crupier.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Jack)}));
        this.deck.initializeDeck(Arrays.asList(new Ace(), new Number(6), new Number(8), new Ace()));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_9_return_crupier_when_crupier_won_taking_some_cards_from_deck(){
        String[] winners = new String[4];
        winners[0] = "Crupier";
        this.player1.setDeal(new Deal(new Card[]{new Number(5), new Number(10), new Number(8)}));
        this.player2.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Number(3), new Ace(), new Number(8)}));
        this.player3.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Royalty(FigureEnum.Jack)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(10), new Number(4)}));
        this.deck.initializeDeck(Arrays.asList(new Number(2), new Number(5), new Ace(), new Number(3)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
    
    @Test
    public void case_10_return_player1_when_player1_won_with_more_than_one_ace(){
        String[] winners = new String[4];
        winners[0] = "Player1";
        this.player1.setDeal(new Deal(new Card[]{new Number(5), new Ace(), new Ace(), new Number(4)}));
        this.player2.setDeal(new Deal(new Card[]{new Royalty(FigureEnum.Queen), new Royalty(FigureEnum.Jack), new Number(10)}));
        this.player3.setDeal(new Deal(new Card[]{new Number(10), new Number(9)}));
        this.crupier.setDeal(new Deal(new Card[]{new Number(3), new Number(10), new Number(6)}));
        this.deck.initializeDeck(Arrays.asList(new Number(2), new Number(5), new Ace(), new Number(3)));
        assertArrayEquals(winners, this.blackJack.getWinners(player1, player2, player3, crupier, deck));
    }
}
