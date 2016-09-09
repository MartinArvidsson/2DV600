package ma223ku_assign1;

/**
 * Created by Martin on 2016-09-09.
 */
public class Card
{
    private Suit suit;
    private Rank rank;

    public enum Rank
    {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King;
    }
    public enum Suit
    {
        Clubs,
        Spades,
        Hearts,
        Diamonds;
    }

    public Card(Rank rank,Suit suit)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }
}
