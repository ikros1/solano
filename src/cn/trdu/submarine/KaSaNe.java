package cn.trdu.submarine;

import javax.swing.*;
import java.awt.*;

public class KaSaNe extends Person{
    //鼠标移动的人物风衣日和
    int life;//暂未使用
    int yika;//伊卡标志位，为1时变身伊卡
    KaSaNe(){
        //super(358,247);
        width=358;
        height=247;
        x=960;
        y=247;
        speed=20;
        life=5;
        yika=0;
    }
    public void step(){
        System.out.println("风音日和移动");
    }
    public void kasaneStep(){
        //获取鼠标位置从而定位人物
        Point p = MouseInfo.getPointerInfo().getLocation();
        //System.out.println("kasane point x :"+p.getX()+"y:"+p.getY());
        this.x=(int) p.getX();
        this.y=(int) p.getY();
    }
    public Artemis shootArtmis(){
        //发射导弹函数
        System.out.println("永久追尾空对空导弹发射");
        return new Artemis(this.x,this.y);

    }
    public ImageIcon getImage(){
        if(yika==0){return Images.kasaneimg;}
        else {return Images.yika;}
    }
}
