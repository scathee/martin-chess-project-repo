/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;
import ChessGame.Move;
import Pieces.*;//need to use all of them

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author hzwerlla14
 * this class just holds the board which is a simple 2d array
 * and has some utilities for interacting with pieces on the board
 * because those don't really fit in the piece anything
 */
public class Mat {
    Piece board[][];
    public Mat(){
        board=new Piece[8][8];
        addPieces();//made into its own function for constructor readability
    }
    public Mat(Piece[][]a){
        board=a;
    }
    /*
     * prints
     */
    public void printOutBoard(){
        for(int y=0;y<8;y++){
            System.out.print((y+1)+"  ");
            for(int x=0;x<8;x++){
                if(board[x][y]!=null){
                    String b=(board[x][y].isBlack()) ? "B":"W";//tetrinary operator if you don't recognize it
                    System.out.print(b+Mat.getPieceLetter(board[x][y])+" ");
                }
                else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }
    //moves pieces returns false if you can't do that
    public void movePiece(Location oldLoc, Location newLoc){
        board[oldLoc.getX()-1][oldLoc.getY()-1].setLocation(newLoc.getX(), newLoc.getY());
        board[newLoc.getX()-1][newLoc.getY()-1]=board[oldLoc.getX()-1][oldLoc.getY()-1];
        board[oldLoc.getX()-1][oldLoc.getY()-1]=null;
    }
    public void movePiece(Move m){
        board[m.getOldX()-1][m.getOldY()-1].setLocation(m.getNewX(), m.getNewY());
        board[m.getNewX()-1][m.getNewY()-1]=board[m.getOldX()-1][m.getOldY()-1];
        board[m.getOldX()-1][m.getOldY()-1]=null;
    }
    public boolean isOccupied(Location l){
        if(board[l.getX()-1][l.getY()-1]!=null){
            return true;
        }
        return false;
    }
    public ArrayList<Location> getValidMoves(Piece a){
        ArrayList<Location> list=new ArrayList<Location>();
        if(a instanceof Bishop){
            list=ValidMoves.ForBishop(a,this);
        }
        if(a instanceof Pawn){
            list=ValidMoves.ForPawn(a,this);
        }
        if(a instanceof Knight){
            list=ValidMoves.ForKnight(a,this);
        }
        if(a instanceof Rook){
            list=ValidMoves.ForRook(a,this);
        }
        if(a instanceof Queen){
            list=ValidMoves.ForQueen(a,this);
        }
        if(a instanceof King){
            list=ValidMoves.ForKing(a,this);
        }
        return list;
    }
    public boolean isWhiteKingInCheck(){
        ArrayList<Location>allofthem=new ArrayList<>();
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(board[x][y]instanceof Piece)
                    if(board[x][y].isBlack()){
                        allofthem.addAll(getValidMoves(board[x][y]));
                    } 
        for(Location l:allofthem){
            if(l.equals(this.getWhiteKing().getLocation())){
                return true;
            }
        }
        return false;
    }
    public boolean moveDoesntPutInCheck(Move m){
        Piece[][]board2=new Piece[8][8];
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                    board2[x][y]=Mat.newPiece(board[x][y]);
        board[m.getOldX()-1][m.getOldY()-1].setLocation(m.getNewX(), m.getNewY());
        board[m.getNewX()-1][m.getNewY()-1]=board[m.getOldX()-1][m.getOldY()-1];
        board[m.getOldX()-1][m.getOldY()-1]=null;
        if(isWhiteKingInCheck()){
            for(int x=0;x<8;x++)
                for(int y=0;y<8;y++)
                    board[x][y]=Mat.newPiece(board2[x][y]);
            return false;
        }
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                board[x][y]=Mat.newPiece(board2[x][y]);
        return true;
    }
    /*
    * sadly this is the best way to do it
    */
    public Piece getPiece(Location l){
        return board[l.getX()-1][l.getY()-1];
    }
    public static Piece newPiece(Piece p){
        if(p instanceof King)
            return new King(p.isBlack(),p.getLocation());
        if(p instanceof Pawn)
            return new Pawn(p.isBlack(),p.getLocation());
        if(p instanceof Rook)
            return new Rook(p.isBlack(),p.getLocation());
        if(p instanceof Knight)
            return new Knight(p.isBlack(),p.getLocation());
        if(p instanceof Bishop)
            return new Bishop(p.isBlack(),p.getLocation());
        if(p instanceof Queen)
            return new Queen(p.isBlack(),p.getLocation());
        return null;
    }
    public void getPawnUpgrade(char color){
        if(color=='W'){
            for(int i=0;i<8;i++){
                if(board[i][7]instanceof Pawn){
                    System.out.println("what piece do you want to upgrade your pawn at "+new Location(i+1,8)+" to?");
                    Scanner s=new Scanner(System.in);
                    do{
                        color=s.nextLine().charAt(0);//micht as well reuse it
                        if(color=='P'||color=='K')//yeah you cant make a pawn to a pawn or a king
                         color='z';
                    }while(Mat.isCharValid(color));
                    switch(color){
                        case 'Q':
                            board[i][7]=new Queen(false, new Location(i+1,8));
                            break;
                        case 'N':
                            board[i][7]=new Knight(false, new Location(i+1,8));
                            break;
                        case 'R':
                            board[i][7]=new Rook(false, new Location(i+1,8));
                            break;
                        case 'B':
                            board[i][7]=new Bishop(false, new Location(i+1,8));
                            break;                          
                    }
                }
            }
        }
        else{
            for(int i=0;i<8;i++){
                if(board[i][0]instanceof Pawn){
                    System.out.println("what piece do you want to upgrade your pawn at "+new Location(i+1,8)+" to?");
                    Scanner s=new Scanner(System.in);
                    do{
                        color=s.nextLine().charAt(0);//micht as well reuse it
                        if(color=='P'||color=='K')//yeah you cant make a pawn to a pawn or a king
                         color='z';
                    }while(Mat.isCharValid(color));
                    switch(color){
                        case 'Q':
                            board[i][0]=new Queen(true, new Location(i+1,1));
                            break;
                        case 'N':
                            board[i][0]=new Knight(true, new Location(i+1,1));
                            break;
                        case 'R':
                            board[i][0]=new Rook(true, new Location(i+1,1));
                            break;
                        case 'B':
                            board[i][0]=new Bishop(true, new Location(i+1,1));
                            break;                          
                    }
                }
            }
        }
    }
    public void getPawnCompuUpgrade(char color){
        if(color=='W'){
            for(int i=0;i<8;i++){
                if(board[i][7]instanceof Pawn){
                    board[i][7]=new Queen(false, new Location(i+1,8));
                }
            }
        }
        else{
            for(int i=0;i<8;i++){
                if(board[i][0]instanceof Pawn){
                    board[i][0]=new Queen(true, new Location(i+1,1));
                }
            }
        }
    }
    public void addPieces(){
        //white pieces
        for(int i=0;i<8;i++){
            board[i][1]=new Pawn(false, i+1, 2);
        }
        board[0][0]=new Rook(false,1,1);
        board[7][0]=new Rook(false,8,1);
        board[6][0]=new Knight(false,7,1);
        board[1][0]=new Knight(false,2,1);
        board[5][0]=new Bishop(false,6,1);
        board[2][0]=new Bishop(false,3,1);
        board[4][0]=new King(false,5,1);
        board[3][0]=new Queen(false,4,1);
        //black pieces
        for(int i=0;i<8;i++){
            board[i][6]=new Pawn(true, i+1, 7);
        }
        board[0][7]=new Rook(true,1,8);
        board[7][7]=new Rook(true,8,8);
        board[6][7]=new Knight(true,7,8);
        board[1][7]=new Knight(true,2,8);
        board[5][7]=new Bishop(true,6,8);
        board[2][7]=new Bishop(true,3,8);
        board[4][7]=new King(true,5,8);
        board[3][7]=new Queen(true,4,8);
    }
    public Piece[][] getBoard(){
        return board;
    }
    public Piece getPiece(int x,int y){
        if(x>8||x<1||y>8||y<1)
            return null;
        return board[x-1][y-1];
    }
    public void removePiece(Location l){
        board[l.getX()][l.getY()]=null;
    }
    public void addNewPiece(Piece p,Location l){
    
    }
    public ArrayList<Location> getAllPossibleWhiteMoves(){
        ArrayList<Location>abcd=new ArrayList<>();
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(board[x][y]!=null)
                    if(board[x][y].isBlack()==false)
                        abcd.addAll(this.getValidMoves(board[x][y]));
        return abcd;
    }
    public ArrayList<Location> getAllPossibleBlackMoves(){
        ArrayList<Location>abcd=new ArrayList<>();
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(board[x][y]!=null)
                    if(board[x][y].isBlack()==true)
                        abcd.addAll(this.getValidMoves(board[x][y]));
        return abcd;
    }
    public King getWhiteKing(){
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(board[x][y]instanceof King)
                    if(board[x][y].isBlack()==false)
                        return (King)board[x][y];
        return null;
    }
    public King getBlackKing(){
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(board[x][y]instanceof King)
                    if(board[x][y].isBlack()==true)
                        return (King)board[x][y];
        return null;
    }
    public static char rowNumberToChar(int i){
        char c=0;
        switch(i){
            case 1:
                c='A';
                break;
            case 2:
                c='B';
                break;
            case 3:
                c='C';
                break;
            case 4:
                c='D';
                break;
            case 5:
                c='E';
                break;
            case 6:
                c='F';
                break;
            case 7:
                c='G';
                break;
            case 8:
                c='H';
                break;
            default:
                c='Z';
                break;
        }
        return c;
    }
    //for input
    public static int rowCharToNumber(char c){
        int i;
        switch(c){
            case 'A':
                i=1;
                break;
            case 'B':
                i=2;
                break;
            case 'C':
                i=3;
                break;
            case 'D':
                i=4;
                break;
            case 'E':
                i=5;
                break;
            case 'F':
                i=6;
                break;
            case 'G':
                i=7;
                break;
            case 'H':
                i=8;
                break;
            default:
                i=-1;
        }
        return i;
    }
    public static int rowNumberCharToNumber(char c){
        int i=0;
        switch(c){
            case '1':
                i=1;
                break;
            case '2':
                i=2;
                break;
            case '3':
                i=3;
                break;
            case '4':
                i=4;
                break;
            case '5':
                i=5;
                break;
            case '6':
                i=6;
                break;
            case '7':
                i=7;
                break;
            case '8':
                i=8;
                break;
            default:
                i=-1;
                break;
        }
        return i;
    }
    public static String getFullPieceNameFromChar(char c){
        switch(c){
            case 'k':
            case 'K':
                return "King";
            case 'Q':
            case 'q':
                return "Queen";
            case 'N':
            case 'n':
                return "Knight";
            case 'B':
            case 'b':
                return "Bishop";
            case 'R':
            case 'r':
                return "Rook";
            case 'p':
            case 'P':
                return "Pawn";
        }
        return null;///this makes netbeans happy because it wouldent accept my default case
    }
    public static char getPieceLetter(Piece p){
        if(p instanceof Pawn)
            return 'P';
        if(p instanceof Bishop)
            return 'B';
        if(p instanceof Rook)
            return 'R';
        if(p instanceof Knight)
            return 'N';  
        if(p instanceof King)
            return 'K';
        if(p instanceof Queen)
            return 'Q';
        return 'z';
    }
    public static ArrayList<Piece> getAllPieces(Piece [][] a){
        ArrayList<Piece> list=new ArrayList<Piece>();
        for(int i=0;i<8;i++)
            for(int x=0;x<8;x++)
                if(!(a[i][x]==null))
                    list.add(a[x][i]);
        return list;
    }
    public static ArrayList<Piece> getAllBlackPieces(Piece [][] a){
        ArrayList<Piece> list=new ArrayList<Piece>();
        for(int i=0;i<8;i++)
            for(int x=0;x<8;x++)
                if(!(a[i][x]==null))
                    if(a[i][x].isBlack()==true)
                        list.add(a[x][i]);
        return list;
    }
    public static ArrayList<Piece> getAllWhitePieces(Piece [][] a){
        ArrayList<Piece> list=new ArrayList<Piece>();
        for(int i=0;i<8;i++)
            for(int x=0;x<8;x++)
                if(!(a[i][x]==null))
                    if(a[i][x].isBlack()==false)
                        list.add(a[x][i]);
        return list;
    }
    public static boolean isThereKing(Piece [][] a){
        int z=0;
        for(int x=0;x<8;x++)
             for(int i=0;i<8;i++)
                 if(a[x][i] instanceof King)
                     z++;
        if(z>1){
            return true;
        }
        return false;
    }
    /*
     called if there is not two kings to determine iwnner
     */
    public static boolean isThereBlackKing(Piece [][] a){
        boolean isWhiteKing=false;
        boolean isBlackKing=false;
        for(int x=0;x<8;x++){
             for(int i=0;i<8;i++)
                 if(a[x][i] instanceof King){
                     if(a[x][i].isBlack()==true){
                         isBlackKing=true;
                     }
                     else{
                         isWhiteKing=false;
                     }
                 }
        }
        if(isWhiteKing==false)             
            return true;
        return true;
    }
    public ArrayList<Piece> getAllPieces(){
        ArrayList<Piece>dapolice=new ArrayList<>();
        for(int i=0;i<8;i++)
            for(int z=0;z<8;z++)
                dapolice.add(board[i][z]);
        return dapolice;
    }
    public ArrayList<Location> getAllLocations(){
        ArrayList<Location>dapolice=new ArrayList<>();
        for(int i=1;i<9;i++)
            for(int z=1;z<9;z++)
                dapolice.add(new Location(i,z));
        return dapolice;
    }
    public static boolean isCharValid(char c){
        if(c=='Q'||c=='K'||c=='P'||c=='N'||c=='R'||c=='B')
            return true;
        return false;
    }
}
