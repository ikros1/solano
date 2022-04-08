//该项目已上传github
//尝试idea本地验证
package cn.trdu.submarine;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.image.ImageObserver;
class TerPoint {
    //导弹坐标数据中转类
    double x;
    double y;
}
public class World extends JPanel {


    // 这是显示另外一个图片的方法
    public  void drawTransImage(Graphics g, Artemis a,int i){
        //绘制导弹的方法
        double roteAngle = a.degree;//角度
        int w = a.width;
        int h = a.height;
        //if(artg.length<=i){
        //artg=Arrays.copyOf(artg,artg.length+1);
        //artg[artg.length-1]=(Graphics2D)g;}
        // 设置一个新的原点
        Graphics2D gd=(Graphics2D)g;//画笔类型转换
        /*artg[i].translate(a.x,a.y);
            // 旋转变换， [旋转弧度,x,y]   (>> 右移一位，就是缩小两倍)  旋转图像的原点确实就在 长和宽的一半处的位置
        artg[i].rotate(Math.toRadians(roteAngle),w >> 1,h >> 1);
        artg[i].drawImage(a.img2, 0,0,w,h,0,0,w,h,null);
        artg[i].translate(-a.x,-a.y);
         */
        gd.translate(a.x,a.y);//瞎写的不知道有没有对修复问题方法的测试

        gd.rotate(Math.toRadians(roteAngle),w >> 1,h >> 1);// 旋转变换， [旋转弧度,x,y]   (>> 右移一位，就是缩小两倍)  旋转图像的原点确实就在 长和宽的一半处的位置
        gd.drawImage(a.img2, 0,0,w,h,0,0,w,h,null);
        gd.translate(-a.x,-a.y);// 把坐标原点给变回去;
        g.translate(-a.x,-a.y);//为了修bug瞎写的

    }



   // public Graphics2D[] artg ={};
    private KaSaNe ka= new KaSaNe();//实例化风音日和对象
    private DoMoKi[] domo={};//建立智树数组
    private PanCi[] pan={};//胖次
    private Artemis[] atm={};//导弹
    private TerPoint po =new TerPoint();//中专数据对象数组
    private Vedio[] artmisvedio ={};//导弹音效数组
    private Vedio[] boomvedio = {};//爆炸音效数组
    private WeiYan[] weiyan={};//尾焰数组
    private Bao[] bao={};//爆炸图片数组
    private int anibool=0;//播放大招动画标志位，位为1开始播放
    private int aniboolindex=0;//大招动画时长标记位
    private int anispeed=1;//大招动画速度标志位
    private int juexing=0;//发动大招次数或者叫觉醒程度
    private Animei animei=new Animei();//大招动画对象

    public TerPoint tergatArm (Artemis at){
        //导弹瞄准目标函数
        TerPoint poin = new TerPoint();
        poin.x=at.x;
        poin.y=at.y;
        //System.out.println("导弹传入坐标 x:"+poin.x+" y:"+poin.y);
        double artx= at.x;
        double arty= at.y;
        int domoid=0;
        int panid=0;
        double lengthdongdomo=9999999;
        double lengthdongpan=9999999;
        if(domo.length>0) {
            //System.out.println("domo数组大于零工作");
            lengthdongdomo = Math.sqrt(Math.pow((artx - domo[0].x), 2) + Math.pow((arty - domo[0].y), 2));
            for (int i = 0; i < domo.length; i++) {
                if (lengthdongdomo > Math.sqrt(Math.pow((artx - domo[i].x), 2) + Math.pow((arty - domo[i].y), 2))) {
                    lengthdongdomo = Math.sqrt(Math.pow((artx - domo[i].x), 2) + Math.pow((arty - domo[i].y), 2));
                    domoid = i;
                }
            }
            //System.out.println("domo数组筛选为"+domoid+"距离为"+lengthdongdomo);
        }
        if(pan.length>0) {
            //System.out.println("pan数组大于零工作");
            lengthdongpan = Math.sqrt(Math.pow((artx - pan[0].x), 2) + Math.pow((arty - pan[0].y), 2));
            for (int i = 0; i < pan.length; i++) {
                if (lengthdongpan > Math.sqrt(Math.pow((artx - pan[i].x), 2) + Math.pow((arty - pan[i].y), 2))) {
                    lengthdongpan = Math.sqrt(Math.pow((artx - pan[i].x), 2) + Math.pow((arty - pan[i].y), 2));
                    panid = i;
                }
            }
            //System.out.println("pan数组筛选为"+panid+"距离为"+lengthdongpan);
        }
        if(lengthdongdomo!=9999999||lengthdongpan!=9999999){
           // System.out.println("长度不都等于9999999");
            if(lengthdongdomo<lengthdongpan){
                if(lengthdongdomo>50){
                poin.x=domo[domoid].x;
                poin.y=domo[domoid].y;
               // System.out.println("domo为位点赋值 x:"+poin.x+"y:"+poin.y);
                }else {
                  //  System.out.println("domo已经被锁定id："+domoid);
                    domo[domoid].locked=1;
                    at.mubiao=0;
                }
            }
            else {
                if(lengthdongpan>50) {
                    poin.x = pan[panid].x;
                    poin.y = pan[panid].y;
                    //System.out.println("pan为位点赋值 x:" + poin.x + "y:" + poin.y);
                }else {
                    //System.out.println("pan已被锁定 id："+panid);
                    pan[panid].locked=1;
                    at.mubiao=0;
                }
            }
        }else {
            at.mubiao=0;
            return poin;
        }
        //System.out.println("返回位点的值 x:"+poin.x+" y:"+poin.y);
        return poin;


    }

    public DoMoKi nextDomoki(){
        //智树对象生产函数
        Random rand = new Random();
        int type = rand.nextInt(10);
        if(type<10){
            //日后的扩展 不用看着奇怪啊
            return new DoMoKi();

        }else if(type<15){
            return new DoMoKi();

        }else {
            return new DoMoKi();

        }

    }
    private int domokiEnterIndex=0;//智树生产频率位
    public void domokiEnterAction(){
        domokiEnterIndex++;
        if(domokiEnterIndex%80==0){
            //计数每80生产一个
            domokiEnterIndex=1;
            DoMoKi domokis = nextDomoki();
            domo = Arrays.copyOf(domo,domo.length+1);
            domo[domo.length-1]= domokis;

        }

    }
    public void panciEnterAction(){//胖次生产函数
        Random random = new Random();
        if(random.nextInt(30)==2){
            //按频率随机生产

            for (DoMoKi doMoKi : domo) {
                PanCi pans = doMoKi.shootPanci();
                pan = Arrays.copyOf(pan, pan.length + 1);
                pan[pan.length - 1] = pans;
            }

        }

    }
    public void domokiStep(){
        //智树移动
        for (DoMoKi doMoKi : domo) {
            doMoKi.step();
        }
    }
    public void panciStep(){
        //胖次移动
        for (PanCi panCi : pan) {
            panCi.step();
        }
    }
    public void delateDomo(){
        //清除失效智树对象
        DoMoKi[] domo_new ={};
        for (DoMoKi doMoKi : domo) {
            if (doMoKi.x < 1920&&doMoKi.locked==0) {
                domo_new = Arrays.copyOf(domo_new, domo_new.length + 1);
                domo_new[domo_new.length - 1] = doMoKi;
            }
            else {
                //智树失效时添加爆炸对象
                bao=Arrays.copyOf(bao,bao.length+1);
                bao[bao.length-1]=new Bao(doMoKi.x,doMoKi.y);
            }
        }
        domo=Arrays.copyOf(domo_new,domo_new.length);
    }
    public void delateWeiYan(){
        //清除失效尾焰对象
        WeiYan[] weiyan_new={};
        for(WeiYan weiyans :weiyan){
            if(weiyans.index<200){
                weiyan_new=Arrays.copyOf(weiyan_new,weiyan_new.length+1);
                weiyan_new[weiyan_new.length-1]=weiyans;
            }
        }
        weiyan =Arrays.copyOf(weiyan_new,weiyan_new.length);
    }
    public void delatebao(){
        //清除失效爆炸对象
        Bao[] bao_new={};
        for(Bao baos :bao){
            if(baos.index<200){
                bao_new=Arrays.copyOf(bao_new,bao_new.length+1);
                bao_new[bao_new.length-1]=baos;
            }
        }
        bao =Arrays.copyOf(bao_new,bao_new.length);
    }
    public void delateArtmis(){
        //清除失效导弹对象
        Artemis[] artemis_new ={};
        Vedio[] artemisvedio_new={};
        int i=0;
        for (Artemis artemis : atm) {

            if (artemis.mubiao!=0) {
                artemisvedio_new =Arrays.copyOf(artemisvedio_new,artemisvedio_new.length+1);
                artemisvedio_new[artemisvedio_new.length-1]=artmisvedio[i];
                artemis_new = Arrays.copyOf(artemis_new, artemis_new.length + 1);
                artemis_new[artemis_new.length - 1] = artemis;
            }
            else {
                //对象失效时播放爆炸音效
                Vedio boomnew =new Vedio("wav/panci.mp3");
                boomvedio=Arrays.copyOf(boomvedio,boomvedio.length+1);
                boomvedio[boomvedio.length-1]=boomnew;
                boomvedio[boomvedio.length-1].start();
            }
            i++;
        }
        atm=Arrays.copyOf(artemis_new,artemis_new.length);
    }
    public void delatePanci(){
        //清除失效胖次对象
        PanCi[] pan_new ={};
        for (PanCi panCi : pan) {
            if (panCi.x < 1920&&panCi.locked==0) {
                pan_new = Arrays.copyOf(pan_new, pan_new.length + 1);
                pan_new[pan_new.length - 1] = panCi;
            }
            else {
                //胖次失效时添加爆炸对象
                bao=Arrays.copyOf(bao,bao.length+1);
                bao[bao.length-1]=new Bao(panCi.x,panCi.y);
            }
        }
        pan=Arrays.copyOf(pan_new,pan_new.length);
    }
    public void artmisSpeedfix(Artemis a){
        //导弹角度速度加速度修正函数
        double degreex;
        double degreey;
       // System.out.println("导弹目标修正弹道启动");
        double deg=1;
       // System.out.println("导弹当前数据 目标坐标 x:"+a.tergatx+" y:"+a.tergaty+"坐标 x:"+a.x+" y:"+a.y+"加速度 x:"+a.ax+" y:"+a.ay+"速度 x:"+a.speedx+" y:"+a.speedy);
        deg=Math.sqrt(Math.pow((a.x-a.tergatx),2)+Math.pow((a.y-a.tergaty),2));
       // System.out.println("导弹与目标直线距离为"+deg);
        a.ax=a.engine*(a.tergatx-a.x)/deg;
        a.ay=a.engine*(a.tergaty-a.y)/deg;
       // System.out.println("横纵坐标受力 x："+a.ax+" y:"+a.ay);
        a.speedx+=a.ax;
        a.speedy+=a.ay;
        if(a.ax>=0){degreex=a.ax;}else {degreex=-a.ax;}
        /*if(a.ay>=0){degreey=a.ay;}else {degreey=-a.ay;}
        if(a.ax>0){a.degree=Math.toDegrees(Math.atan(degreey/degreex))+90;}
        if(a.ax<0){a.degree=-Math.toDegrees(Math.atan(degreey/degreex))+270;}*/
        if(a.ax>0){a.degree=Math.toDegrees(Math.atan(a.ay/degreex))+90;}
        if(a.ax<0){a.degree=-Math.toDegrees(Math.atan(a.ay/degreex))+270;}
     //   System.out.println("速度修正为 x："+a.speedx+" y:"+a.speedy+" 角度为："+a.degree);

    }
    public void artmisStep(){
        //导弹移动函数
        for (Artemis artemis : atm) {
            po = tergatArm(artemis);
          //  System.out.println("位点返回值 x："+po.x+" y:"+po.y);
            artemis.tergatx = po.x;
            artemis.tergaty = po.y;
          //  System.out.println("瞄准目标装载 x："+artemis.tergatx+" y:"+artemis.tergaty);
            artmisSpeedfix(artemis);
            artemis.step();


        }
    }
    public void weiyanstep(){
        //尾焰计时函数
        for (WeiYan weiYan: weiyan){
            weiYan.step();
        }

    }
    public void baostep(){
        //爆炸计时函数
        for (Bao baos: bao){
            baos.step();
        }

    }
    public void weijienter(){
        //尾焰对象添加函数
        for(Artemis artemis:atm){
            WeiYan weiYan=new WeiYan(artemis.x,artemis.y);
            weiyan=Arrays.copyOf(weiyan,weiyan.length+1);
            weiyan[weiyan.length-1]=weiYan;
        }
    }
    private int worldIndex=0;//世界信息播报计时位
    public void wordInfo(){
        //世界信息播报函数
        worldIndex++;
        if(worldIndex%500==0) {
            worldIndex=1;
           // System.out.println("domokeinfo" + domo.length + "个" + "artmis" + atm.length + "个" + "panci" + pan.length + "个");
        }
        }
    public void action(){
        //世界对象活动函数
        KeyAdapter k=new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //键盘事件监听
                if(e.getKeyCode()==KeyEvent.VK_SPACE){//空格
                    if(juexing==0){
                        //未觉醒时单发导弹
                        Artemis art = ka.shootArtmis();
                        atm = Arrays.copyOf(atm, atm.length + 1);
                        atm[atm.length - 1] = art;
                        artmisvedio = Arrays.copyOf(artmisvedio, artmisvedio.length + 1);
                        artmisvedio[artmisvedio.length - 1] = new Vedio("wav/artmis.mp3");
                        artmisvedio[artmisvedio.length - 1].start();
                    }

                    for(int i=0;i<juexing*5;i++) {
                        //按觉醒程度发射觉醒层数*5发导弹
                        Artemis art = ka.shootArtmis();
                        atm = Arrays.copyOf(atm, atm.length + 1);
                        atm[atm.length - 1] = art;
                        artmisvedio = Arrays.copyOf(artmisvedio, artmisvedio.length + 1);
                        artmisvedio[artmisvedio.length - 1] = new Vedio("wav/artmis.mp3");
                        artmisvedio[artmisvedio.length - 1].start();
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    //上方向键觉醒
                    //domokiEnterAction();
                    ka.yika=1;
                    anibool=1;
                    juexing++;
                }


            }



        };
        this.addKeyListener(k);

        Timer timer = new Timer();
        int intervel =10;//画图时间间隔
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //每次画图时执行的事件
                if(anibool==0){
                    artmisStep();
                    delateArtmis();
                domokiEnterAction();
                panciEnterAction();
                weijienter();
                domokiStep();
                panciStep();

                weiyanstep();
                baostep();
                ka.kasaneStep();
                delateDomo();
                delatePanci();
                delateWeiYan();
                delatebao();
                wordInfo();
                    if(aniboolindex==33){
                        anibool=0;
                        aniboolindex=0;
                    }
                repaint();}
                else {
                    if(aniboolindex==33){
                        anibool=0;
                        aniboolindex=0;
                    }

                    repaint();
                }

            }
        }, intervel, intervel);

    }
    public void paint(Graphics g){
        //初始画笔g绘制各个部分
        if(anibool==0) {
            Images.backgroundimg.paintIcon(null, g, 0, 0);

            for (WeiYan weiYan : weiyan) {
                weiYan.paintImage(g);
            }
            for(Bao baos :bao){
                baos.paintImage(g);
            }
            for (DoMoKi doMoKi : domo) {
                doMoKi.paintImage(g);
            }

            for (PanCi panCi : pan) {
                panCi.paintImage(g);
            }
            ka.paintImage(g);
            for (int i = 0; i < atm.length; i++) {
                drawTransImage(g, atm[i], i);
            }

        }
        else {
            //大招标志位激活播放大招动画
            if(anispeed%6==0){
            animei.paintImage(g,aniboolindex);
            aniboolindex++;
            anispeed=1;
            if(aniboolindex==33){
                anibool=0;
                aniboolindex=0;
            }}
            else {anispeed++;}

        }
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        new Vedio("wav/fight.mp3").start();//背景音乐
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920+16,1080+39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        world.action();



    }


}
