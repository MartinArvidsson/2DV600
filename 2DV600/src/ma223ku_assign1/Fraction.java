package ma223ku_assign1;

/**
 * Created by marti on 2016-09-09.
 */
public class Fraction
{
    int numerator;
    int denominator;

    public Fraction(int n,int d)
    {
        try
        {
            if(d != 0)
            {
                numerator = n;
                denominator = d;
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong :(");
        }
    }
    public int getNumerator()
    {
        return numerator;
    }

    public int getDenomiator()
    {
        return denominator;
    }

    public boolean isNegative()
    {
        if((double)getNumerator()/(double)getDenomiator() < 0)
        {
            return true;
        }
        else
            return false;

    }
    //Formula to use: http://www.calculatorsoup.com/calculators/math/fractions.php
    public int add(Fraction _f)
    {

        return (_f.getNumerator()*this.getDenomiator() + this.getNumerator()*_f.getDenomiator()) / (_f.getDenomiator()*this.getDenomiator());

    }

    public int subtract()
    {
        return 0;
    }

    public int multiply()
    {
        return 0;
    }

    public int divide()
    {
        return 0;
    }

    public int isEqualTo()
    {
        return 0;
    }

    public String toString()
    {
        return getNumerator()+" / "+getDenomiator();
    }
}
