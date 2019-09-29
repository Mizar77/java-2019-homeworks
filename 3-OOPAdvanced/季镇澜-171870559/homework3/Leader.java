package homework3;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leader extends Creature {
    static Map<Integer, Pair<String, Integer>> formationMap = new HashMap<>();
    Creature[] subordinate;
    Checkerboard theBoard;
    int startX = 0, startY = 0;

    static {
        formationMap.put(0, new Pair<>("鹤翼阵", 7));
        formationMap.put(1, new Pair<>("雁行阵", 5));
        formationMap.put(2, new Pair<>("衝轭阵", 6));
        formationMap.put(3, new Pair<>("锋矢阵", 12));
        formationMap.put(4, new Pair<>("鱼鳞阵", 9));
        formationMap.put(5, new Pair<>("方円阵", 8));
        formationMap.put(6, new Pair<>("偃月阵", 19));
        formationMap.put(7, new Pair<>("长蛇阵", 7));
    }

    Leader(String n, Checkerboard cb) {
        super(n);
        theBoard = cb;
    }

    public void arrange(){}

    private void arrange0Heyi() {
        subordinate[0].changeLocation(startX + 1, startY + 1);
        theBoard.modify(startX + 1, startY + 1, subordinate[0].name);

        subordinate[1].changeLocation(startX + 2, startY + 2);
        theBoard.modify(startX + 2, startY + 2, subordinate[1].name);

        subordinate[2].changeLocation(startX + 3, startY + 3);
        theBoard.modify(startX + 3, startY + 3, subordinate[2].name);

        subordinate[3].changeLocation(startX + 4, startY + 4);
        theBoard.modify(startX + 4, startY + 4, subordinate[3].name);

        subordinate[4].changeLocation(startX + 3, startY + 5);
        theBoard.modify(startX + 3, startY + 5, subordinate[4].name);

        subordinate[5].changeLocation(startX + 2, startY + 6);
        theBoard.modify(startX + 2, startY + 6, subordinate[5].name);

        subordinate[6].changeLocation(startX + 1, startY + 7);
        theBoard.modify(startX + 1, startY + 7, subordinate[6].name);
    }

    private void arrange1Yanhang() {
        startX += 7;
        startY += 1;
        for (int i = 0; i < 5; i++) {
            subordinate[i].changeLocation(startX - i, startY + i);
            theBoard.modify(startX - i, startY + i, subordinate[i].name);
        }
    }

    private void arrange2Chonge() {
        startX += 2;
        startY += 1;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                subordinate[i].changeLocation(startX + i, startY + 1);
                theBoard.modify(startX + i, startY + 1, subordinate[i].name);
            } else {
                subordinate[i].changeLocation(startX + i, startY);
                theBoard.modify(startX + i, startY, subordinate[i].name);
            }
        }
    }

    private void arrange3Fengshi() {
        subordinate[0].changeLocation(startX + 2, startY + 3);
        theBoard.modify(startX + 2, startY + 3, subordinate[0].name);

        subordinate[1].changeLocation(startX + 3, startY + 2);
        theBoard.modify(startX + 3, startY + 2, subordinate[1].name);

        subordinate[2].changeLocation(startX + 3, startY + 3);
        theBoard.modify(startX + 3, startY + 3, subordinate[2].name);

        subordinate[3].changeLocation(startX + 3, startY + 4);
        theBoard.modify(startX + 3, startY + 4, subordinate[3].name);

        subordinate[4].changeLocation(startX + 4, startY + 1);
        theBoard.modify(startX + 4, startY + 1, subordinate[4].name);

        subordinate[4].changeLocation(startX + 4, startY + 3);
        theBoard.modify(startX + 4, startY + 3, subordinate[4].name);

        subordinate[5].changeLocation(startX + 4, startY + 5);
        theBoard.modify(startX + 4, startY + 5, subordinate[5].name);

        subordinate[6].changeLocation(startX + 5, startY);
        theBoard.modify(startX + 5, startY, subordinate[6].name);

        subordinate[7].changeLocation(startX + 5, startY + 3);
        theBoard.modify(startX + 5, startY + 3, subordinate[7].name);

        subordinate[8].changeLocation(startX + 5, startY + 6);
        theBoard.modify(startX + 5, startY + 6, subordinate[8].name);

        subordinate[9].changeLocation(startX + 6, startY + 3);
        theBoard.modify(startX + 6, startY + 3, subordinate[9].name);

        subordinate[10].changeLocation(startX + 7, startY + 3);
        theBoard.modify(startX + 7, startY + 3, subordinate[10].name);

        subordinate[11].changeLocation(startX + 8, startY + 3);
        theBoard.modify(startX + 8, startY + 3, subordinate[11].name);
    }

    private void arrange4Yulin() {
        subordinate[0].changeLocation(startX + 2, startY + 3);
        theBoard.modify(startX + 2, startY + 3, subordinate[0].name);

        subordinate[1].changeLocation(startX + 3, startY + 3);
        theBoard.modify(startX + 3, startY + 3, subordinate[1].name);

        subordinate[2].changeLocation(startX + 3, startY + 4);
        theBoard.modify(startX + 3, startY + 4, subordinate[2].name);

        subordinate[3].changeLocation(startX + 4, startY + 1);
        theBoard.modify(startX + 4, startY + 1, subordinate[3].name);

        subordinate[4].changeLocation(startX + 4, startY + 2);
        theBoard.modify(startX + 4, startY + 2, subordinate[4].name);

        subordinate[5].changeLocation(startX + 4, startY + 3);
        theBoard.modify(startX + 4, startY + 3, subordinate[5].name);

        subordinate[6].changeLocation(startX + 4, startY + 4);
        theBoard.modify(startX + 4, startY + 4, subordinate[6].name);

        subordinate[7].changeLocation(startX + 4, startY + 5);
        theBoard.modify(startX + 4, startY + 5, subordinate[7].name);

        subordinate[8].changeLocation(startX + 5, startY + 3);
        theBoard.modify(startX + 5, startY + 3, subordinate[8].name);
    }

    private void arrange5Fangyuan() {
        subordinate[0].changeLocation(startX + 2, startY + 4);
        theBoard.modify(startX + 2, startY + 4, subordinate[0].name);

        subordinate[1].changeLocation(startX + 3, startY + 3);
        theBoard.modify(startX + 3, startY + 3, subordinate[1].name);

        subordinate[2].changeLocation(startX + 3, startY + 5);
        theBoard.modify(startX + 3, startY + 5, subordinate[2].name);

        subordinate[3].changeLocation(startX + 4, startY + 2);
        theBoard.modify(startX + 4, startY + 2, subordinate[3].name);

        subordinate[4].changeLocation(startX + 4, startY + 6);
        theBoard.modify(startX + 4, startY + 6, subordinate[4].name);

        subordinate[5].changeLocation(startX + 5, startY + 3);
        theBoard.modify(startX + 5, startY + 3, subordinate[5].name);

        subordinate[6].changeLocation(startX + 5, startY + 5);
        theBoard.modify(startX + 5, startY + 5, subordinate[6].name);

        subordinate[7].changeLocation(startX + 6, startY + 4);
        theBoard.modify(startX + 6, startY + 4, subordinate[7].name);
    }

    private void arrange6Yanyue() {
        subordinate[0].changeLocation(startX + 1, startY + 6);
        theBoard.modify(startX + 1, startY + 6, subordinate[0].name);

        subordinate[1].changeLocation(startX + 2, startY + 5);
        theBoard.modify(startX + 2, startY + 5, subordinate[1].name);

        subordinate[2].changeLocation(startX + 2, startY + 4);
        theBoard.modify(startX + 2, startY + 4, subordinate[2].name);

        subordinate[3].changeLocation(startX + 3, startY + 4);
        theBoard.modify(startX + 3, startY + 4, subordinate[3].name);

        subordinate[4].changeLocation(startX + 3, startY + 3);
        theBoard.modify(startX + 3, startY + 3, subordinate[4].name);

        for (int i = 0; i < 3; i++) {
            for (int j = 5 + i * 3; j < 8 + i * 3; j++) {
                subordinate[j].changeLocation(startX + 4 + i, startY + j - 4 - i * 3);
                theBoard.modify(startX + 4 + i, startY + j - 4 - i * 3, subordinate[j].name);
            }
        }

        subordinate[14].changeLocation(startX + 7, startY + 3);
        theBoard.modify(startX + 7, startY + 3, subordinate[14].name);

        subordinate[15].changeLocation(startX + 7, startY + 4);
        theBoard.modify(startX + 7, startY + 4, subordinate[15].name);

        subordinate[16].changeLocation(startX + 8, startY + 4);
        theBoard.modify(startX + 8, startY + 4, subordinate[16].name);

        subordinate[17].changeLocation(startX + 8, startY + 5);
        theBoard.modify(startX + 8, startY + 5, subordinate[17].name);

        subordinate[18].changeLocation(startX + 9, startY + 6);
        theBoard.modify(startX + 9, startY + 6, subordinate[18].name);
    }

    private void arrange7Changshe() {
        startX += 1;
        startY += 1;
        for (int i = 0; i < 7; i++) {
            subordinate[i].changeLocation(startX + i, startY);
            theBoard.modify(startX + i, startY, subordinate[i].name);
        }
    }


    protected void arrangeFormation(int formationNo) {
        switch (formationNo) {
            case 0:
                arrange0Heyi();
                break;
            case 1:
                arrange1Yanhang();
                break;
            case 2:
                arrange2Chonge();
                break;
            case 3:
                arrange3Fengshi();
                break;
            case 4:
                arrange4Yulin();
                break;
            case 5:
                arrange5Fangyuan();
                break;
            case 6:
                arrange6Yanyue();
                break;
            case 7:
                arrange7Changshe();
                break;
            default:
        }
    }
}

class Elder extends Leader {

    Elder(Checkerboard cb) {
        super("老爷爷", cb);
    }

    @Override
    public void arrange() {
        changeLocation(0,0);
        theBoard.modify(0,0,name);

        subordinate = new Huluwa[]{
                new Huluwa("红娃", 1),
                new Huluwa("橙娃", 2),
                new Huluwa("黄娃", 3),
                new Huluwa("绿娃", 4),
                new Huluwa("青娃", 5),
                new Huluwa("蓝娃", 6),
                new Huluwa("紫娃", 7)
        };
        arrangeFormation(7);
    }
}

class Snake extends Leader{
    Snake(Checkerboard cb){
        super("蛇精",cb);
        startY+=4;
    }

    @Override
    public void arrange(){
        changeLocation(0,11);
        theBoard.modify(0,11,name);

        Random rand=new Random();
        int formationNo=rand.nextInt(7);
        int number=formationMap.get(formationNo).getValue();
        subordinate=new Creature[number];
        subordinate[0]=new Creature("蝎子精");
        for(int i=1;i<number;i++){
            subordinate[i]=new Creature("小喽啰");
        }
        arrangeFormation(formationNo);
    }
}
