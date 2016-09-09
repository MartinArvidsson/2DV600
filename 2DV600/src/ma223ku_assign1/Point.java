package ma223ku_assign1;

/**
 * Created by marti on 2016-09-09.
 */
public class Point
{
    int _y;
    int _x;

    public static void main(String[] args)
    {
        Point p1 = new Point();
        Point p2 = new Point(3,4);

        System.out.println(p1.toString());   // ==> (0,0)
        System.out.println(p2.toString());   // ==> (3,4)

        if (p1.isEqualTo(p2))              // False!
           System.out.println("The two points are equal");

        double dist = p1.distanceTo(p2);
        System.out.println("Point Distance: "+dist);

        p2.move(5,-2);         // ==> (8,2)
        p1.moveToXY(8,2);      // ==> (8,2)

        if (p1.isEqualTo(p2))              // True!
           System.out.println("The two points are equal");
    }

    public String toString()
    {
        return ("Point value : " + this.getX() + "," + this.getY());
    }

    public Point()
    {
       _x = 0;
       _y = 0;
    }

    public Point(int x , int y)
    {
        _x = x;
        _y = y;
    }

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public void setX(int x)
    {
        _x = x;
    }

    public void setY(int y)
    {
        _y = y;
    }

    public Boolean isEqualTo(Point _point)
    {
        if(_point.getX() == this.getX() && _point.getY() == this.getY())
        {
            return true;
        }
        else
            return false;
    }

    public double distanceTo(Point _p)
    {
        return Math.sqrt(Math.pow((_p.getX()-this.getX()),2) + Math.pow((_p.getY()-this.getY()),2));
    }

    public void move(int x,int y)
    {
        this._x += x;
        this._y += y;
    }

    public void moveToXY(int x,int y)
    {
        this._x = x;
        this._y = y;
    }

}
