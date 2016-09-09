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
    public Fraction add(Fraction _f)
    {

        return new Fraction((_f.getNumerator()*this.getDenomiator() + this.getNumerator()*_f.getDenomiator()) , (_f.getDenomiator()*this.getDenomiator()));

    }

    public Fraction subtract(Fraction _f)
    {
        return new Fraction ((this.getNumerator()*_f.getDenomiator() - _f.getNumerator()*this.getDenomiator()) , (this.getDenomiator()*_f.getDenomiator()));
    }

    public Fraction multiply(Fraction _f)
    {
        return new Fraction((_f.getNumerator()*this.getNumerator()) , (_f.getDenomiator()*this.getDenomiator()));
    }

    public Fraction divide(Fraction _f)
    {
        return new Fraction((_f.getNumerator()*this.getDenomiator()) , (_f.getDenomiator()*this.getNumerator()));
    }

    public boolean isEqualTo(Fraction _f)
    {
        return (double)_f.getNumerator()/_f.getDenomiator() == (double)this.getNumerator()/this.getDenomiator();
    }

    public String toString()
    {
        return this.getNumerator()+" / "+ this.getDenomiator();
    }
}
