import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Team {
    int num;
    Map map;
    List<GameObject> members;
    abstract void changeFormation();
}

class GourdTeam extends Team {
    enum GOURDS {
        老大, 老二, 老三, 老四, 老五, 老六, 老七
    }

    GourdTeam(int centerX, int centerY, Map map) {
        num = 8;
        this.map = map;
        members = new ArrayList<GameObject>();
        for (int i = 0; i < 7; i++) {
            members.add(new GameObject(GOURDS.values()[i].toString(), (char) ((int) '1' + i), map));
        }
        Collections.shuffle(members);
        for (int i = 0; i < 7; i++) {
            members.get(i).setPosition(centerX - 3 + i, centerY);
        }
        members.add(new GameObject("老爷爷", 'e', centerX, centerY - 2, map));
        map.printMap();
    }

    private void swap(int i, int j) {
        int tempX = members.get(j).x, tempY = members.get(j).y;
        members.get(j).setPosition(members.get(i).x, members.get(i).y);
        members.get(i).setPosition(tempX, tempY);
        GameObject temp=members.get(j);
        members.set(j, members.get(i));
        members.set(i,temp);
        map.printMap();
    }

    private void quickSort(int l, int r) {
        if (l >= r)
            return;
        int i = l;
        int j = r;
        GameObject key = members.get(l);
        while (i < j) {
            while (i < j && members.get(j).symbol >= key.symbol)
                j--;
            if (i < j) {
                swap(i,j);
                i++;
            }
            while (i < j && members.get(i).symbol < key.symbol)
                i++;
            if (i < j) {
                swap(j,i);
                j--;
            }
        }
        int tempX = members.get(j).x, tempY = key.y;
        key.setPosition(members.get(i).x, members.get(i).y);
        members.get(i).setPosition(tempX, tempY);
        members.set(i,key);
        quickSort(l, i - 1);
        quickSort(i + 1, r);
    }

    @Override
    void changeFormation() {
        quickSort(0,6);
        map.printMap();
    }
}

class MonsterTeam extends Team{
    MonsterTeam(int num,int centerX, int centerY, Map map){
        this.num=num%2==1?num+1:num;
        this.map=map;
        members=new ArrayList<GameObject>();
        members.add(new GameObject("蝎子精",'x',centerX,centerY,map));
        for(int i=1;i<=(this.num-2)/2;i++){
            members.add(new GameObject("小喽啰",'o',centerX-i,centerY+i,map));
            members.add(new GameObject("小喽啰",'o',centerX+i,centerY+i,map));
        }
        members.add(new GameObject("蛇精",'s',centerX,centerY+2,map));
        map.printMap();
    }
    @Override
    void changeFormation() {
        int centerX=members.get(0).x,centerY=members.get(0).y;
        for(int i=1;i<=(num-2)/2;i++){
            members.get(i*2-1).changePosition(centerX-i,i%2==1?centerY+1:centerY);
            members.get(i*2).changePosition(centerX+i,i%2==1?centerY+1:centerY);
        }
        map.printMap();
    }
}


