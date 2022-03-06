package tankgame.version03;

public class MyTank extends Tank {
    private Shoot shoot = null;

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shootEnemy() {
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
        //启动子弹线程
        new Thread(shoot).start();
    }

    public Shoot getShoot() {
        return shoot;
    }

    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }
}
