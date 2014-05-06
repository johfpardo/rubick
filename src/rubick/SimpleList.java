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
public class SimpleList {

    private Object list[];
    private int head;

    public SimpleList() {
        this.list = new Object[4];
        this.head = 0;
    }

    public void updateUp(Object value) {
        this.list[this.head] = value;
    }

    public void updateRight(Object value) {
        this.list[(this.head + 1) % 4] = value;
    }

    public void updateDown(Object value) {
        this.list[(this.head + 2) % 4] = value;
    }

    public void updateLeft(Object value) {
        this.list[(this.head + 3) % 4] = value;
    }

    public Object getUp() {
        return this.list[this.head];
    }

    public Object getRight() {
        return this.list[(this.head + 1) % 4];
    }

    public Object getDown() {
        return this.list[(this.head + 2) % 4];
    }

    public Object getLeft() {
        return this.list[(this.head + 3) % 4];
    }

    public void leftShift() {
        if (this.head == 0) {
            this.head = 3;
        } else {
            this.head = this.head - 1;
        }
    }

    public void rightShift() {
        this.head = (this.head + 1) % 4;
    }
}
