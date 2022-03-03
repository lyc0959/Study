package tankgame.version02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    private MyTank myTank;
    private int enemyNumber = 3;
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public MyPanel() {
        myTank = new MyTank(100, 100);
        myTank.setSpeed(5);
        for (int i = 0; i < enemyNumber; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//游戏区域
        drawTank(myTank.getX(), myTank.getY(), myTank.getDirection(), 0, g);//画坦克
        for (int i=0;i<enemyTanks.size();i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),enemyTank.getDirection(),1,g);
        }
    }

    /**
     * @param x         坦克横坐标
     * @param y         坦克纵坐标
     * @param direction 坦克的方向 0-上 1-右 2-下 3-左
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
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://1表示向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://2表示下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3://3表示左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            myTank.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            myTank.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            myTank.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
