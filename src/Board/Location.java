/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Errors.StupidCantPlayThereError;
/**
 *
 * @author hzwerlla14
 */
public class Location {
    int x;
    int y;
    public Location(int x, int y){
        if(!(x>7||y>7)){
            this.x=x;
            this.y=y;
            //todo throw error
        }
    }
    public int getX(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setX(int x){
        this.x=x;
    }
}
