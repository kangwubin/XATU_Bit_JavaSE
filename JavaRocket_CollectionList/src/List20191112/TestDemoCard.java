package List20191112;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 23:52
 */
class Card {
    public String suit;//花色
    public int rank;//牌面值

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]", suit, rank);
    }
}

class CardDemo {
    public static final String[] SUITS = {"♠", "♦", "♣", "♥"};

    //买牌
    public List<Card> buyDeck() {
        List<Card> cardList = new ArrayList<>();
        //i代表花色，j代表牌面值
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                int rank = j;
                Card card = new Card(suit, rank);
                cardList.add(card);
            }
        }
        return cardList;
    }

    private void swap(List<Card> cards, int i, int index) {

    }

    //洗牌
    public void shuffle(List<Card> cards) {
        Random random = new Random();
    }
}

public class TestDemoCard {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> cards = cardDemo.buyDeck();
        System.out.println(cards);
    }
}
