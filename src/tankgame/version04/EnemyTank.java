package tankgame.version04;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    private boolean isLive = true;

    private Vector<Shoot> shoots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shoot> getShoots() {
        return shoots;
    }

    public void setShoots(Vector<Shoot> shoots) {
        this.shoots = shoots;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        Shoot shoot = null;
        while (true) {
            //限制敌方坦克子弹数量,若坦克存活且子弹数量10以内就创建子弹对象加入集合中
            if (isLive && shoots.size() <= 10) {
                switch (getDirection()) {
                    case 0:
                        shoot = new Shoot(getX() + 20, getY(), getDirection());
                        break;
                    case 1:
                        shoot = new Shoot(getX() + 60, getY() + 20, getDirection());
                        break;
                    case 2:
                        shoot = new Shoot(getX() + 20, getY() + 60, getDirection());
                        break;
                    case 3:
                        shoot = new Shoot(getX(), getY() + 20, getDirection());
                        break;
                }
                //子弹放入集合并启动子弹线程
                shoots.add(shoot);
                new Thread(shoot).start();
            }
            //根据坦克当前方向继续前行
            switch (getDirection()) {
                case 0:
                    //让坦克在同一方向走N步，不要只走1步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);//这里要进行休眠，否则坦克会瞬移30步
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;//不能忘记break，否则会出现穿透现象
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //随机改变坦克的方向 Math.random()取得是[0-1)的数值，左边闭右边开
            setDirection((int) (Math.random() * 4));
            //并发编程，一定要考虑该线程什么时候结束！
            //敌方坦克被我方子弹消灭，线程退出
            if (!isLive) {
                break;
            }
        }
    }
}
