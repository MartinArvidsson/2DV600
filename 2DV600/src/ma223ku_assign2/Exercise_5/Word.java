package ma223ku_assign2.Exercise_5;

/**
 * Created by marti on 2016-09-21.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str)
    {
        word = str;
    }
    public String toString()
    {
        return word;
    }
    /* Override Object methods */

    public int hashCode()
    {
        word.toLowerCase();
        int hc = 0;
        for ( int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            hc += Character.getNumericValue(c); // ASCII number
        }
        return hc;
        //From slides
        //"compute a hash value for word"
    }
    public boolean equals(Object other)
    {
        if(other instanceof Word)
        {
            Word wordtocompare = (Word)other;
            return word.toLowerCase().equals(wordtocompare.word.toLowerCase());
        }
        return false;
        //"true if two words are equal"
    }
    /* Implement Comparable */
    public int compareTo(Word w)
    {
        //"compares two words lexicographically"

        return word.compareToIgnoreCase(w.toString());

    }
}
