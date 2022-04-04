package cn.trdu.submarine;

import javax.swing.*;
import java.util.Random;

public class Bao extends Person{
    //导弹爆炸的图片类
    int index=0;//图片停留时间的定时位
    Bao(int x,int y){
        super(90,90);
        this.x=x;
        this.y=y;
        this.index=0;
    }
    public void step(){
        //图片停留时间定时开始
        this.index++;

    }
    public ImageIcon getImage(){
        return Images.bao;
    }
}
