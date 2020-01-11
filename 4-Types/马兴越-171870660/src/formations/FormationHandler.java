/*
 * 布阵管理器。类似代理，在这里实现布阵。
 */
package formations;

import exceptions.NoSpaceForFormationException;
import exceptions.PathNotFoundException;
import field.Position;
import field.Field;
import items.Living;
import items.PassedFlag;
import java.lang.reflect.*;

public class FormationHandler <T extends Formation>{
    private Field field;
    private T formation;
    private Living leader;
    private Living[] followers;
    public FormationHandler(Field field,Living leader,
                     Living[] followers,Class<T> formType){
        this.field=field;
        this.leader=leader;
        this.followers=followers;
        int n=followers.length;
        Constructor cons=formType.getConstructors()[0];
        try{
            formation=(T)cons.newInstance(n);
        }
        catch(Exception e){
            System.err.println("failed to create formation object!");
            throw new RuntimeException(e);
        }
    }

    /*
     * 公共接口。
     * 先寻找合适位置，再进行布阵。
     */
    public boolean embattle() throws NoSpaceForFormationException {
        findPlace();
        leader.setMovable(false);
        Position[] positions=formation.positions(leader.getPosition());
        for(int i=0;i<positions.length;i++){
            try {
                followers[i].walkTowards(positions[i]);
            }
            catch (PathNotFoundException e){
                System.out.println(
                        "Cannot format as "+toString()+" due to "+e);
                NoSpaceForFormationException n=
                        new NoSpaceForFormationException(formation);
                n.initCause(e);
                throw n;
            }
            followers[i].setMovable(false);
        }
        return true;
    }

    /*
     * 当前leader的位置是否适合排布本阵型。
     * 检查所有要到的位置上是否有不可移动对象。
     */
    protected boolean ready(){
        Position[] positions=formation.positions(leader.getPosition());
        for(Position p:positions){
            if(field.unreachable(p))
                return false;
        }
        return true;
    }

    /**
     * 从scorpionDemon移植过来。
     * 寻找适合布阵的leader位置。
     */
    protected void findPlace() throws NoSpaceForFormationException {
        Field passed=new Field();
        for(Living l:followers){
            l.setMovable(true);
        }
        if(! findPlace(passed))
            throw new NoSpaceForFormationException(formation);
    }

    private boolean findPlace(Field passed) {
        if(ready())
            return true;
        Position position=leader.getPosition();
        passed.addLiving(new PassedFlag(position.copy(),passed));
        Position.Direction dir=position.new Direction(Position.Direction.S);
        Position p;
        for(int i=0;i<8;i++){
            p=dir.adjacentPosition();
            if(field.inside(p) && passed.livingAt(p)==null &&
                    leader.moveOrSwap(dir.dx(),dir.dy()))
                if(findPlace(passed))
                    return true;
                else
                    //移动失败，先退回来
                    leader.moveOrSwap(-dir.dx(),-dir.dy());
            dir.next();
        }
        return false;
    }
}
