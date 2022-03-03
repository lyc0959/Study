package tankgame.version01;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private MyTank myTank;

    public MyPanel() {
        myTank = new MyTank(100, 100);//初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//游戏区域
        drawTank(myTank.getX(),myTank.getY(),0,0,g);//画坦克
    }

    /**
     * @param x         坦克横坐标
     * @param y         坦克纵坐标
     * @param direction 坦克的方向 0-上
     * @param type      坦克的类型 0-我方坦克 1-敌方坦克
     * @param g         画笔
     */
    public void drawTank(int x, int y, int direction, int type, Graphics g) {
        switch (type) {
            case 0://我方坦克，亮浅蓝色
                g.setColor(Color.CYAN);
                break;
            case 1://敌方坦克，黄色
                g.setColor(Color.YELLOW);
                break;
        }
        switch (direction) {
            case 0://0表示坦克向上
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.fill3DRect(x+30,y,10,60,false);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            default:
                System.out.println("暂时不作处理!");
        }
    }
}
