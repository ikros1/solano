package cn.trdu.submarine;

import javax.swing.*;
import java.util.Random;

public class PanCi extends Person{
    //胖次类
    int locked;//同理智树类，标志位为1销毁
    PanCi(int x,int y){
        super(133,132);
        locked=0;
        this.x=x;
        this.y=y;
        Random rand = new Random();
        speed=rand.nextInt(10)+3;//初始速度赋值
    }

    public void step(){
        x+=speed;
        //System.out.println("内裤炸弹移动");
    }
    public ImageIcon getImage(){
        return Images.panciimg;
    }
}
