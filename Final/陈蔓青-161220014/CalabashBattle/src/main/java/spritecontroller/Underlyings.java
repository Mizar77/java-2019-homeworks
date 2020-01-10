package spritecontroller;

import java.util.ArrayList;
import battlefield.BattleField;
import bullet.Bullet;

public class Underlyings extends Creature{

    private static final long serialVersionUID = 1L;
    private CalabashBrothers sevenBro;
    private Grandpa grandpa;
    private BattleField bt;
    private Creature targetEnemy = null;

    public Underlyings(int i){
        name = "小喽啰" + i;
        String path = "/underlying.png";
        loadImage(path);
        attackArea = 4;
        fullhp = currentHp = 150;
        atk = 25;
        defence = 15;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public int getdef() {
        return defence;
    }

    @Override
    public int getHp() {
        return currentHp;
    }

    @Override
    public void minusHp(int damage) {
        currentHp -= damage;
    }

    @Override
    public void run(){
        while(!isDead) {
            creatureLock.lock();
            if(isDead) {
                creatureLock.unlock();
                break;
            }
            findEnemy();
            if(targetEnemy != null && !targetEnemy.isDead) {
                int dx = targetEnemy.x() - posX;
                int dy = targetEnemy.y() - posY;
                if(dx * dx + dy * dy <= attackArea) {
                    //System.out.println(name + "attacked" + targetEnemy.tellName());
                    targetEnemy.attacked(bt, this);
                    allBullets.add(new Bullet(this, targetEnemy));
                }else {
                    findNextPos(dx, dy);
                }
            }else {
                creatureLock.unlock();
                break;
            }
            try {
                creatureLock.unlock();
                Thread.sleep(1000);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void findNextPos(int dx, int dy) {
        synchronized(bt) {
            if(dx < 0 && dy < 0) {
                if(posX != 0&&bt.isEmpty(posX - 1, posY)) {
                    bt.leave(posX, posY);
                    posX --;
                    bt.standOn(this);
                }else if(posY != 0 && bt.isEmpty(posX, posY - 1)){
                    bt.leave(posX, posY);
                    posY --;
                    bt.standOn(this);
                }
            }else if(dx > 0 && dy < 0) {
                if(posX != 14 && bt.isEmpty(posX + 1, posY)) {
                    bt.leave(posX, posY);
                    posX ++;
                    bt.standOn(this);
                }else if(posY !=0 &&bt.isEmpty(posX, posY - 1)) {
                    bt.leave(posX, posY);
                    posY --;
                    bt.standOn(this);
                }
            }else if(dx < 0 && dy > 0) {
                if(posX != 0 && bt.isEmpty(posX - 1, posY)) {
                    bt.leave(posX, posY);
                    posX --;
                    bt.standOn(this);
                }else if(posY !=14 && bt.isEmpty(posX, posY + 1)) {
                    bt.leave(posX, posY);
                    posY ++;
                    bt.standOn(this);
                }
            }else if(dx > 0 && dy > 0) {
                if(posX != 14 && bt.isEmpty(posX + 1, posY)) {
                    bt.leave(posX, posY);
                    posX ++;
                    bt.standOn(this);
                }else if(posY != 14 && bt.isEmpty(posX, posY + 1)) {
                    bt.leave(posX, posY);
                    posY ++;
                    bt.standOn(this);
                }
            }else {
                if(posX != 14 && bt.isEmpty(posX + 1, posY) && dx > 0) {
                    bt.leave(posX, posY);
                    posX++;
                    bt.standOn(this);
                }else if(posY != 14 && bt.isEmpty(posX, posY + 1) && dy > 0) {
                    bt.leave(posX, posY);
                    posY++;
                    bt.standOn(this);
                }else if(posX != 0 && bt.isEmpty(posX - 1, posY) && dx < 0) {
                    bt.leave(posX, posY);
                    posX --;
                    bt.standOn(this);
                }else if(posY != 0 && bt.isEmpty(posX, posY - 1) && dy < 0) {
                    bt.leave(posX, posY);
                    posY --;
                    bt.standOn(this);
                }else {
                    if(posX != 14 && bt.isEmpty(posX + 1, posY)) {
                        bt.leave(posX, posY);
                        posX++;
                        bt.standOn(this);
                    }else if(posY != 14 && bt.isEmpty(posX, posY + 1)) {
                        bt.leave(posX, posY);
                        posY++;
                        bt.standOn(this);
                    }else if(posX != 0 && bt.isEmpty(posX - 1, posY)) {
                        bt.leave(posX, posY);
                        posX --;
                        bt.standOn(this);
                    }else if(posY != 0 && bt.isEmpty(posX, posY - 1)) {
                        bt.leave(posX, posY);
                        posY --;
                        bt.standOn(this);
                    }
                }
            }
        }
    }

    private void findEnemy() {
        creatureLock.lock();
        boolean isEnemyAllDead = true;
        for(int i = 0; i < 7; i ++) {
            if(!sevenBro.sevenBro[i].isDead) {
                isEnemyAllDead = false;
                break;
            }
        }
        if(!grandpa.isDead)
            isEnemyAllDead = false;
        int distance = 2000;
        if(!isEnemyAllDead) {
            for(int i = 0; i < 7; i++) {
                int dx = posX - sevenBro.sevenBro[i].posX;
                int dy = posY - sevenBro.sevenBro[i].posY;
                int tmpD = dx * dx + dy * dy;
                if(tmpD < distance && !sevenBro.sevenBro[i].isDead) {
                    distance = tmpD;
                    targetEnemy = sevenBro.sevenBro[i];
                }
            }
            int dgx = posX - grandpa.x();
            int dgy = posY - grandpa.y();
            int tmpD = dgx * dgx + dgy * dgy;
            if(tmpD < distance && ! grandpa.isDead) {
                distance = tmpD;
                targetEnemy = grandpa;
            }
        }else {
            targetEnemy = null;
        }
        creatureLock.unlock();
    }

    public void observeEnemy(CalabashBrothers sevenBro, Grandpa grandpa, BattleField bt) {
        this.sevenBro = sevenBro;
        this.grandpa = grandpa;
        this.bt = bt;
    }

    public void getThread(ArrayList<Thread> t) {
        Thread t1 = new Thread(this);
        t.add(t1);
    }
}

