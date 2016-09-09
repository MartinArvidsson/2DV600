package ma223ku_assign1;

/**
 * Created by Martin on 2016-09-09.
 */
public class Game123
{
    public static void main(String[] args)
    {
        int totalwins = 0;
        int timestosim = 10000;
        for (int i = 0; i < timestosim; i++)
        {
            if(simgame())
            {
                totalwins ++;
            }

        }
        System.out.println("number of wins: " + (double)totalwins/(double)timestosim * 100);

    }

    private static boolean simgame()
    {
        int gamechecker = 0;
        Deck _deck = new Deck();
        _deck.Shuffle();
        for (int i = 0; i < 52; i++)
        {
            Card _card = _deck.handOutNextCard();
            if(_card.getRank().ordinal() == gamechecker)
            {
                return  false;
            }
            if(gamechecker > 2)
            {
                gamechecker = 0;
            }

            gamechecker +=1;
        }

        return true;
    }
}
