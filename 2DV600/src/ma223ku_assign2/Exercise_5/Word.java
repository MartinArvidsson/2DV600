package ma223ku_assign2.Exercise_5;

/**
 * Created by marti on 2016-09-21.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str)
    {
    }
    public String toString()
    {
        return word;
    }
    /* Override Object methods */
    public int hashCode()
    {
        "compute a hash value for word"
    }
    public boolean equals(Object other)
    {
        "true if two words are equal"
    }
    /* Implement Comparable */
    public int compareTo(Word w)
    { "compares two words lexicographically"
    }
}
