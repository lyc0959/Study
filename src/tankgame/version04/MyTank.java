package tankgame.version04;

import java.util.Vector;

public class MyTank extends Tank {
    private Shoot shoot = null;
    private Vector<Shoot> shoots = new Vector<>();

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shootEnemy() {
        //控制子弹最多发射5颗
        if(shoots.size() == 5) {
            return;
        }
        //根据当前坦克对象，创建当前子弹的位置和方向
        switch (this.getDirection()) {
            case 0 :
                shoot = new Shoot(this.getX()+20,this.getY(),this.getDirection());
                break;
            case 1:
                shoot = new Shoot(this.getX()+60,this.getY()+20,this.getDirection());
                break;
            case 2:
                shoot = new Shoot(this.getX()+20,this.getY()+60,this.getDirection());
                break;
            case 3:
                shoot = new Shoot(this.getX(),this.getY()+20,this.getDirection());
                break;
        }
        //每次按下J调用该方法，都会new一颗子弹，放入集合中
        shoots.add(shoot);
        //启动子弹线程
        new Thread(shoot).start();
    }

    public Shoot getShoot() {
        return shoot;
    }

    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }

    public Vector<Shoot> getShoots() {
        return shoots;
    }

    public void setShoots(Vector<Shoot> shoots) {
        this.shoots = shoots;
    }
}
