package Board;

import Errors.StupidCantPlayThereError;
/**
 * stuff held in here is not in array form(ex first one is 0)
 * all that takes place in methods
 * anyway basic location class
 * @author hzwerlla14
 */
public class Location {
    int x;
    int y;
    public Location(int x, int y){
        if(!(x>8||y>1)){
            this.x=x;
            this.y=y;
            //todo throw error
        }
    }
    public Location(char c, char d){
        x=Mat.rowCharToNumber(c);
        y=Mat.rowNumberCharToNumber(d);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setX(int x){
        this.x=x;
    }
    @Override
    public String toString(){
        return Mat.rowNumberToChar(x)+""+y;
    }
    public boolean equals(Location z){
        if(this.getX()==z.getX()&&this.getY()==z.getY())
            return true;
        return false;
    }
    public static boolean isValid(Location z){
        if(z.getX()<1||z.getX()>8||z.getY()>8||z.getY()<1)
            return false;
        return true;
    }
}
