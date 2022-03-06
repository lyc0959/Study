package tankgame.version04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    private MyTank myTank;
    private int enemyNumber = 3;
    private int shootNumber = 5;
    private Image image1 = null;
    private Image image2 = null;
    private Image image3 = null;
    Vector<Boom> booms = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public MyPanel() {
        myTank = new MyTank(100, 100);//初始化我方坦克
        myTank.setSpeed(5);//我方坦克速度设置为5
        //创建敌方坦克
        for (int i = 0; i < enemyNumber; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);//设置敌方坦克初始方向
            new Thread(enemyTank).start();//启动敌方坦克线程
            for (int j = 0; j < shootNumber; j++) {
                Shoot shoot = new Shoot(enemyTank.getX() + 20, enemyTank.getY() + 60 + 10 * j, enemyTank.getDirection());
                enemyTank.getShoots().add(shoot);
                new Thread(shoot).start();
            }
            enemyTanks.add(enemyTank);
        }
        //初始化炸弹图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/boom3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//游戏区域
        //画我方坦克
        drawTank(myTank.getX(), myTank.getY(), myTank.getDirection(), 0, g);
        //画坦克的子弹，需要开个线程重绘
        for (int i = 0; i < myTank.getShoots().size(); i++) {
            Shoot shoot = myTank.getShoots().get(i);
            //子弹不为空且子弹存活，画出子弹
            if (shoot != null && shoot.isLive == true) {
                g.fillOval(shoot.x, shoot.y, 8, 8);
            } else {
                myTank.getShoots().remove(shoot);//当子弹销毁后从集合中移除该子弹
            }
        }
        //若booms集合中有炸弹对象，就要画出炸弹
        for (int i = 0; i < booms.size(); i++) {
            Boom boom = booms.get(i);
            //当炸弹生命值为678，就一直画image1；456就一直画image2;123就一直画image3
            if (boom.getLife() > 6) {
                g.drawImage(image1, boom.getX(), boom.getY(), 60, 60, this);
            } else if (boom.getLife() > 3) {
                g.drawImage(image2, boom.getX(), boom.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, boom.getX(), boom.getY(), 60, 60, this);
            }
            //减少炸弹生命值，为了让爆炸效果更好
            boom.lifeDown();
            //如果炸弹生命值为0，移除
            if (boom.getLife() == 0) {
                booms.remove(boom);
            }
        }
        //画敌方坦克及其子弹
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断敌方坦克是否存活，存活则画否则不画
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirection(), 1, g);
                for (int j = 0; j < enemyTank.getShoots().size(); j++) {
                    Shoot shoot = enemyTank.getShoots().get(j);
                    if (shoot.isLive) {
                        g.fillOval(shoot.x, shoot.y, 8, 8);
                    } else {
                        enemyTank.getShoots().remove(shoot);//销毁的子弹从集合中移除
                    }
                }
            }
        }
    }

    /**
     * 判断子弹是否击中敌方坦克
     *
     * @param shoot
     * @param enemy
     */
    public void hitEnemy(Shoot shoot, EnemyTank enemy) {
        switch (enemy.getDirection()) {
            case 0:
            case 2:
                if (shoot.x > enemy.getX() && shoot.x < enemy.getX() + 40
                        && shoot.y > enemy.getY() && shoot.y < enemy.getY() + 60) {
                    shoot.isLive = false;
                    enemy.setLive(false);
                    enemyTanks.remove(enemy);
                    Boom boom = new Boom(enemy.getX(), enemy.getY());
                    booms.add(boom);
                }
                break;
            case 1:
            case 3:
                if (shoot.x > enemy.getX() && shoot.x < enemy.getX() + 60
                        && shoot.y > enemy.getY() && shoot.y < enemy.getY() + 40) {
                    shoot.isLive = false;
                    enemy.setLive(false);
                    enemyTanks.remove(enemy);
                    Boom boom = new Boom(enemy.getX(), enemy.getY());
                    booms.add(boom);
                }
                break;
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
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(2);
            if (myTank.getY() + 60 < 750) {
                myTank.moveDown();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(1);
            if (myTank.getX() + 60 < 1000) {
                myTank.moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //条件①一开始没有打子弹，子弹是空的可以打出子弹；条件②打出的子弹击中敌方坦克或者碰到边界了才能继续打出子弹
//            if (myTank.getShoot() == null || myTank.getShoot().isLive == false) {
//                myTank.shootEnemy();
//            }
            myTank.shootEnemy();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中敌方坦克
            for (int j = 0; j < myTank.getShoots().size(); j++) {
                Shoot shoot = myTank.getShoots().get(j);
                if (shoot != null && shoot.isLive) {
                    for (int i = 0; i < enemyTanks.size(); i++) {
                        hitEnemy(shoot, enemyTanks.get(i));
                    }
                }
            }
            this.repaint();
        }
    }
}
