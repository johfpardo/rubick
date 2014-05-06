package rubick;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chucho
 */
public class Cubies {

    public static final int redColor = 1;
    public static final int whiteColor = 2;
    public static final int orangeColor = 3;
    public static final int blueColor = 4;
    public static final int yellowColor = 5;
    public static final int greenColor = 6;
    int color;

    public Cubies(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        switch (color) {
            case redColor:
                return "r";
            case whiteColor:
                return "w";
            case orangeColor:
                return "o";
            case blueColor:
                return "b";
            case yellowColor:
                return "y";
            case greenColor:
                return "g";
        }
        return "";
    }
}
