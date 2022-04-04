package cn.trdu.submarine;

import javax.swing.*;
import java.util.Random;

public class WeiYan extends Person{
    //导弹尾焰类
    int index=0;//尾焰停留时间位
    WeiYan(int x,int y){
        super(24,24);
        this.x=x;
        this.y=y;
        this.index=0;
    }
    public void step(){
        //停留时间计时
        this.index++;

    }
    public ImageIcon getImage(){
        return Images.weiyan;
    }
}
