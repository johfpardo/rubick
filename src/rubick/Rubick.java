/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubick;

/**
 *
 * @author Chucho
 */
public class Rubick {

    private final SimpleList horizontalCenters;
    private final SimpleList verticalCenters;

    public Rubick() {
        
        Center red = new Center(Cubies.redColor);
        Center white = new Center(Cubies.whiteColor);
        Center orange = new Center(Cubies.orangeColor);
        Center blue = new Center(Cubies.blueColor);
        Center yellow = new Center(Cubies.yellowColor);
        Center green = new Center(Cubies.greenColor);
        
        horizontalCenters = new SimpleList();
        horizontalCenters.updateUp(white);
        horizontalCenters.updateRight(blue);
        horizontalCenters.updateDown(yellow);
        horizontalCenters.updateLeft(green);
       
        verticalCenters = new SimpleList();
        verticalCenters.updateUp(white);
        verticalCenters.updateRight(red);
        verticalCenters.updateDown(yellow);
        verticalCenters.updateLeft(orange);
        
        initEdges(red, Cubies.redColor);
        initEdges(white, Cubies.whiteColor);
        initEdges(orange, Cubies.orangeColor);
        initEdges(blue, Cubies.blueColor);
        initEdges(yellow, Cubies.yellowColor);
        initEdges(green, Cubies.greenColor);
    }

    public String toString() {
        String aux = "";
        aux += "" + (Center) horizontalCenters.getUp()
                + (Center) horizontalCenters.getLeft()
                + (Center) verticalCenters.getLeft()
                + (Center) horizontalCenters.getRight()
                + (Center) horizontalCenters.getDown()
                + (Center) verticalCenters.getRight();
        return aux;
    }

    private void initEdges(Center center, int color) {

        Cubies leftUpCorner = new Cubies(color);
        Cubies leftDownCorner = new Cubies(color);
        Cubies rightUpCorner = new Cubies(color);
        Cubies rightDownCorner = new Cubies(color);

        Edges upEdge = new Edges(leftUpCorner, rightUpCorner, new Cubies(color));
        Edges rightEdge = new Edges(rightUpCorner, rightDownCorner, new Cubies(color));
        Edges downEdge = new Edges(rightDownCorner, leftDownCorner, new Cubies(color));
        Edges leftEdge = new Edges(leftDownCorner, leftUpCorner, new Cubies(color));

        center.edges.updateUp(upEdge);
        center.edges.updateRight(rightEdge);
        center.edges.updateDown(downEdge);
        center.edges.updateLeft(leftEdge);

    }
    
    private void moveUpEdges(SimpleList list) {
        
        Center aux = (Center) list.getUp();
        ((Edges) aux.edges.getLeft()).right = ((Edges) aux.edges.getUp()).left;
        ((Edges) aux.edges.getRight()).left = ((Edges) aux.edges.getUp()).right;
        
        aux = (Center) list.getRight();
        ((Edges) aux.edges.getLeft()).right = ((Edges) aux.edges.getUp()).left;
        ((Edges) aux.edges.getRight()).left = ((Edges) aux.edges.getUp()).right;
        
        aux = (Center) list.getDown();
        ((Edges) aux.edges.getLeft()).right = ((Edges) aux.edges.getUp()).left;
        ((Edges) aux.edges.getRight()).left = ((Edges) aux.edges.getUp()).right;

        aux = (Center)list.getLeft();
        ((Edges)aux.edges.getLeft()).right = ((Edges)aux.edges.getUp()).left;
        ((Edges)aux.edges.getRight()).left = ((Edges)aux.edges.getUp()).right;
        
    }

    private void moveDownEdges(SimpleList list) {
        
        Center aux = (Center) list.getUp();
        ((Edges) aux.edges.getLeft()).left = ((Edges) aux.edges.getDown()).right;
        ((Edges) aux.edges.getRight()).right = ((Edges) aux.edges.getDown()).left;
        
        aux = (Center) list.getRight();
        ((Edges) aux.edges.getLeft()).left = ((Edges) aux.edges.getDown()).right;
        ((Edges) aux.edges.getRight()).right = ((Edges) aux.edges.getDown()).left;
        
        aux = (Center) list.getDown();
        ((Edges) aux.edges.getLeft()).left = ((Edges) aux.edges.getDown()).right;
        ((Edges) aux.edges.getRight()).right = ((Edges) aux.edges.getDown()).left;
        
        aux = (Center) list.getLeft();
        ((Edges) aux.edges.getLeft()).left = ((Edges) aux.edges.getDown()).right;
        ((Edges) aux.edges.getRight()).right = ((Edges) aux.edges.getDown()).left;
        
    }
    private void moveLeftEdges(SimpleList list) {
        Center aux = (Center) list.getUp();
        ((Edges) aux.edges.getUp()).left = ((Edges) aux.edges.getLeft()).right;
        ((Edges) aux.edges.getDown()).right = ((Edges) aux.edges.getLeft()).left;
        
        aux = (Center) list.getRight();
        ((Edges) aux.edges.getUp()).left = ((Edges) aux.edges.getLeft()).right;
        ((Edges) aux.edges.getDown()).right = ((Edges) aux.edges.getLeft()).left;
    
        aux = (Center) list.getDown();
        ((Edges) aux.edges.getUp()).left = ((Edges) aux.edges.getLeft()).right;
        ((Edges) aux.edges.getDown()).right = ((Edges) aux.edges.getLeft()).left;
    
        aux = (Center) list.getLeft();
        ((Edges) aux.edges.getUp()).left = ((Edges) aux.edges.getLeft()).right;
        ((Edges) aux.edges.getDown()).right = ((Edges) aux.edges.getLeft()).left;
    
    }
    private void moveRightEdges(SimpleList list) {
        Center aux = (Center) list.getUp();
        ((Edges) aux.edges.getUp()).right = ((Edges) aux.edges.getRight()).left;
        ((Edges) aux.edges.getDown()).left = ((Edges) aux.edges.getRight()).right;
    
        aux = (Center) list.getRight();
        ((Edges) aux.edges.getUp()).right = ((Edges) aux.edges.getRight()).left;
        ((Edges) aux.edges.getDown()).left = ((Edges) aux.edges.getRight()).right;
    
        aux = (Center) list.getDown();
        ((Edges) aux.edges.getUp()).right = ((Edges) aux.edges.getRight()).left;
        ((Edges) aux.edges.getDown()).left = ((Edges) aux.edges.getRight()).right;
    
        aux = (Center) list.getLeft();
        ((Edges) aux.edges.getUp()).right = ((Edges) aux.edges.getRight()).left;
        ((Edges) aux.edges.getDown()).left = ((Edges) aux.edges.getRight()).right;
    
    }
    private class Center {

        SimpleList edges;
        Cubies color;

        public Center(int color) {
            this.color = new Cubies(color);
            edges = new SimpleList();
        }

        @Override
        public String toString() {
            String aux = "";
            aux += ((Edges) this.edges.getUp()).left;
            aux += ((Edges) this.edges.getUp()).color;
            aux += ((Edges) this.edges.getUp()).right + "\n";
            aux += ((Edges) this.edges.getLeft()).color;
            aux += this.color;
            aux += ((Edges) this.edges.getRight()).color + "\n";
            aux += ((Edges) this.edges.getDown()).right;
            aux += ((Edges) this.edges.getDown()).color;
            aux += ((Edges) this.edges.getDown()).left + "\n";
            return aux;
        }
    }

    private class Edges {

        Cubies left;
        Cubies right;
        Cubies color;

        public Edges(Cubies left, Cubies right, Cubies color) {
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
