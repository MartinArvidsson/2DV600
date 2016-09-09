package ma223ku_assign1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Martin on 2016-09-09.
 */
public class Deck
{
    private List<Card> deckofcards = new ArrayList<>();
    public Deck()
    {
        for (Card.Suit _suit : Card.Suit.values())
        {
            for (Card.Rank _rank : Card.Rank.values())
            {
                deckofcards.add(new Card(_rank,_suit));
            }
        }
    }
    void Shuffle()
    {
        try
        {
            if(deckofcards.size() != 52)
            {
                throw new IllegalArgumentException();
            }
            else
            {
                //Shuffle deck
                Collections.shuffle(deckofcards);
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred :( ");
        }
    }
    Card handOutNextCard()
    {
        Card topcard = deckofcards.get(deckSize() - 1);
        deckofcards.remove(deckSize() - 1);

        return topcard;
    }
    int deckSize()
    {
        return deckofcards.size();
    }
}
