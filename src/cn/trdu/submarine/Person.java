package cn.trdu.submarine;

import javax.swing.*;
import java.util.Random;
import java.awt.Graphics;

public abstract class Person {
    //超类
    public static final int LIVE =0;//暂时没用
    public static final int DEAD =1;//暂时没用
    protected int state = LIVE;//暂时没用

    protected int width;//宽
    protected int height;//高
    protected int x;//位置
    protected int y;
    protected double speed;//速度
    public Person(int width,int height){
        this.width=width;
        this.height=height;

    }
    public Person(){

    }
    public abstract void step();
    public abstract ImageIcon getImage();
    public boolean isLive(){ return state ==LIVE;}
    public boolean isDead(){ return state ==DEAD;}
    public void paintImage(Graphics g){
        //调用画笔画出当前调用对象的图片

            this.getImage().paintIcon(null,g,this.x,this.y);


    }
}
