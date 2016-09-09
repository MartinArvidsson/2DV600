package ma223ku_assign1;

/**
 * Created by Martin on 2016-09-09.
 */
public class PlayCardsMain
{
    public static void main(String[] args)
    {
        Deck _deck = new Deck();
        _deck.Shuffle();
        for (int i = 0; i < 52; i++)
        {
            Card _card = _deck.handOutNextCard();
            System.out.println(_card.getSuit() + "," +_card.getRank());
            System.out.println("Decksize left: " + _deck.deckSize());
        }
    }
}
