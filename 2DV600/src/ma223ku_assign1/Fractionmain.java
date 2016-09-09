package ma223ku_assign1;

/**
 * Created by Martin on 2016-09-09.
 */
public class Fractionmain
{
    public static void main(String[] args)
    {
        Fraction _f = new Fraction(2,6);
        Fraction _f2 = new Fraction(3,4);
        Fraction _testfraction;
        //Fraction _f2 = new Fraction(2,0); Used for testing that the denominator can't be equal to 0. Works
        System.out.println(_f.isNegative());
        System.out.println(_f.toString());
        _testfraction =_f.add(_f2);
        System.out.println(_testfraction.toString());
        _testfraction = _f.subtract(_f2);
        System.out.println(_testfraction.toString());
        _testfraction = _f.multiply(_f2);
        System.out.println(_testfraction.toString());
        _testfraction = _f.divide(_f2);
        System.out.println(_testfraction);
        System.out.println(_f.isEqualTo(_f2));
    }
}
