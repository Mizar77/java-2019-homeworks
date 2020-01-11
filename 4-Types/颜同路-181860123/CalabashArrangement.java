import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class CalabashArrangement {
    public static void main(String[] args) {
        /*
1. �������һ��`NxN`�Ķ�ά�ռ䣨`N>10`)���ÿռ��е�����һ��λ�������Ͽ�վ��һ�������壨��«�ޡ���үү���߾���Ы�Ӿ���Сආ������������壩��
2. ���ó�ʼ������߸��ֵܰ���ͼ��ʾ�����еĳ����������ϴ������ߣ�վ�ӣ�
3. ����ͼ��ѡ��һ�����ͣ����߳��⣩��Ы�Ӿ�������Сආ�վ�ӣ�
4. ����«�ֵܵĳ�����Ӫ��Ы�Ӿ�Сආ���Ӫ�����ڶ�λ�ռ��У��γɶ��ž��棻
5. ��ѡ�����λ�ý���үү���߾������ڿռ��У�Ϊ����һ������������
6. ���������ž����ӡ�����
7. ����Ы�Ӿ�Сආ���Ӫ�任һ���󷨣����߳��⣩���ظ�4-6����
*/
        System.out.println("�Ϲź�ģ���«ɽ����������Ű��������ѡ���\n\n�Ϻ��ȱ�������ɫ��«����ƽϢ��������\n\nʱ�գ��Ϻ��ͺ�«����ͻȻ�������������ڹ�ս������\n");//��������
        Grandpa grandpa = new Grandpa();
        Snake snake = new Snake();
        snake.Talk("������������ץ��������ϼһ��ˣ�����Ҫ�������ɫ���ƣ�");
        snake.follower[2].Talk("�õģ�������\n");
        grandpa.Talk("�����ǣ���������үү��");
        System.out.println("��үүָ�Ӻ�«���ų�һ�ֳ����󣬲������ϴ���������\n");

        grandpa.Conduct(grandpa.calabashbrothers.get(0), 7, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(1), 8, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(2), 9, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(3), 10, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(4), 11, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(5), 12, 5);
        grandpa.Conduct(grandpa.calabashbrothers.get(6), 13, 5);
        //�������ų�һ��

        for (int i = 0; i < 6; i++) {       //үү��ð������ķ���ָ�Ӻ�«�ް����ϴ������ĳ�һ��
            for (int j = 0; j < 6; j++) {
                if(((Calabash)Map.map[7 + j][5]).rank > ((Calabash)Map.map[8 + j][5]).rank)//үүָ��������«�޻���λ��
                {
                    grandpa.Conduct(Map.map[7 + j][5], 7 + j, 6);
                    grandpa.Conduct(Map.map[8 + j][5], 7 + j, 5);
                    grandpa.Conduct(Map.map[7 + j][6], 8 + j, 5);
                }
            }
        }

        snake.Talk("߾����������ͷ�ӣ����úܣ�С���ǣ���첼����Ҫץס���߸���«�ޣ������ɵ����������ϣ�");
        snake.follower[0].Talk("���������������һ��Ҫ GIVE THEM SOME COLOR TO SEE SEE!");
        snake.Talk("˵�˶��ٴΣ���Ҫ���Ҵ�����Ҫ����Ů�����ˣ�");
        snake.follower[0].Talk("�õģ�������");
        System.out.println("�߾�ָ��Ы�Ӿ���Сආ��ǲ����˺�����\n");

        snake.Conduct(snake.follower[0], 8, 10);
        snake.Conduct(snake.follower[1], 9, 11);
        snake.Conduct(snake.follower[2], 10, 12);
        snake.Conduct(snake.follower[3], 11, 13);
        snake.Conduct(snake.follower[4], 11, 14);
        snake.Conduct(snake.follower[5], 10, 15);
        snake.Conduct(snake.follower[6], 9, 16);
        snake.Conduct(snake.follower[7], 8, 17);

        Map.Print();

        grandpa.Talk("�����Ǽ��ͣ�����Ϊ���Ǽ���������");
        grandpa.Goto(11,3);
        grandpa.Cheer();
        System.out.println("����үү��������ս����Ϊ��«���Ǽ������� [��«�޷�ʿ��ÿ�غ� +10]\n");

        snake.Talk("С���ǣ�����Ҳ����׼��и��һ��Ҫ����ץס��«�ޣ�");
        snake.Goto(11, 17);
        snake.Cheer();
        System.out.println("���߾���������ս����Ϊ��«���Ǽ������� [������ʿ��ÿ�غ� +10]\n");

        Map.Print();

        System.out.println("��«���������Ƕ��Ƕ��£�˫�����ֲ��¡���\n");

        snake.follower[0].Talk("��ѽѽѽѽѽѽ��������ЩСƨ���������Ѳ����������е���������ʰ���ǣ�");
        System.out.println("�߾�ָ��Ы�Ӿ���Сආ��ǽ��󷨱����������\n");

        snake.Conduct(snake.follower[0], 8, 10);
        snake.Conduct(snake.follower[1], 9, 11);
        snake.Conduct(snake.follower[2], 10, 12);
        snake.Conduct(snake.follower[3], 11, 13);
        snake.Conduct(snake.follower[4], 12, 14);
        snake.Conduct(snake.follower[5], 13, 15);
        snake.Conduct(snake.follower[6], 14, 16);
        snake.Conduct(snake.follower[7], 15, 17);

        grandpa.Goto(4, 5);
        grandpa.Cheer();

        System.out.println();

        snake.Talk("������ͷ��棡");
        snake.Goto(12, 9);
        snake.Cheer();

        System.out.println();

        Map.Print();

        System.out.println("\n˫���������˶��š���\n");

        System.out.println("\nδ���������");

        return;
    }
}

class Creature{
    public String name = "";
    public int x = 0;
    public int y = 0;
    //x��y��ʾ��������ڵ�ͼ�ϵ�λ��

    Creature(String name) { //������
        this.name = name;
    }

    public void Goto(int nx, int ny){   //Goto��������������
        Map.map[x][y] = null;
        x = nx;
        y = ny;
        Map.map[x][y] = this;
    }

    public void Talk(String s){     //Talk����������˵��
        System.out.println(name + "��" + s);
    }
}

class Calabash extends Creature{    //��«����
    static int morale = 100;//ʿ��ֵ
    public int rank = 0;//����
    public void skill(){};//�鷽�������صļ���
    Calabash(String name, int i){
        super(name);    //���ø���Ĺ�����
        rank = i;
    }
}

class Conductor extends Creature{       //ָ�ӹ��࣬үү���߾��ĸ���
    Conductor(String s){
        super(s);
    }

    public void Cheer(){};//Cheer��������������
    public void Conduct(Creature c, int nx, int ny){};//�鷽����ָ���Լ���һ���ű�����11.10�ٴγ����������и�д�ɹ� :)���������м�����ȷ��ָ�ӵ�����Ϊ�Լ�����ָ�ӵı�����ɫ
}


final class Grandpa extends Conductor{     //үү��
    public static ArrayList<Calabash> calabashbrothers = new ArrayList<Calabash>();//үү���е�����߸���«�ޣ������ã�
    Grandpa(){
        super("үү");
        calabashbrothers.add(new Calabash("����", 1));
        calabashbrothers.add(new Calabash("����", 2));
        calabashbrothers.add(new Calabash("����", 3));
        calabashbrothers.add(new Calabash("����", 4));
        calabashbrothers.add(new Calabash("����", 5));
        calabashbrothers.add(new Calabash("����", 6));
        calabashbrothers.add(new Calabash("����", 7));
        Collections.shuffle(calabashbrothers);//���ҳ�ʼ˳��
    }

    @Override   //��д����д��
    public void Cheer(){
        Random r = new Random();
        int i = r.nextInt(5);
        Calabash.morale += i;   //�������ʿ��ֵ
        switch (i){
            case 0:Talk("���ͣ������ǣ�");break;
            case 1:Talk("��ס��������Ӯ��");break;
            case 2:Talk("���̾�����ǰ��");break;
            case 3:Talk("�־�����������");break;
            case 4:Talk("��»���������棡");break;
        }
    }

    //�� @Override   //���󣡲���������ֵ��ͬ������д(Override)��
    /*
    public void Conduct(Calabash c, int nx, int ny){     //ָ�Ӻ�«���ű�����
        c.Goto(nx, ny);
    }
    */
    //ע�⣺�˴������������ַ�ʽ����������ȷ���ã�
    //10.15���䣺�����ԭ���ǣ�����д����Ϊ������ͬ����û�и��Ǹ����еķ�����ʵ�������������أ�������һ��ȫ�µķ�����
    //������ʱ�����ڴ�map��ȡ������CreatureԪ�أ�����ƥ�䵽�˸���ķ��������������Ȼ�����գ�

    @Override   //11.10���³��Ը�д��ף�Һ��� :)
    public void Conduct(Creature c, int nx, int ny) //�����ͷ���ֵ��֤��ͬ
    {
        if(c.getClass() == Calabash.class)
        {
            c.Goto(nx, ny);
        }
        else System.out.println("үү����ָ�ӷǺ�«�ޣ�");
    }
}

class Leprechaun extends Creature{    //������
    static int morale = 100;//ʿ��ֵ
    public void evilskill(){};//�鷽����а��ļ���
    Leprechaun(String name){
        super(name);    //���ø���Ĺ�����
    }
}

final class Snake extends Conductor{     //�߾���
    public static Leprechaun[] follower = new Leprechaun[8];//�߾�������һ��Сආ��������ã�
    Snake(){
        super("�߾�");
        follower[0] = new Leprechaun("Ы�Ӿ�");//ί��Ы�Ӿ�һ�£���Сආ�����
        follower[1] = new Leprechaun("����");
        follower[2] = new Leprechaun("��󡾫");
        follower[3] = new Leprechaun("��򼾫");
        follower[4] = new Leprechaun("��ţ��");
        follower[5] = new Leprechaun("�Ʒ侫");
        follower[6] = new Leprechaun("Ұ��");
        follower[7] = new Leprechaun("֩�뾫");
    }

    @Override
    public void Cheer(){    //Cheer��������������
        Random r = new Random();
        int i = r.nextInt(5);
        Leprechaun.morale += i; //�������ʿ��ֵ
        switch (i){
            case 0:Talk("���ͣ�С���ǣ�");break;
            case 1:Talk("������������ˣ�");break;
            case 2:Talk("��Ҫ���Ҵ�����");break;
            case 3:Talk("Ҫ����Ů�����ˣ�");break;
            case 4:Talk("�������⣬˳�����⣡");break;
        }
    }

    /*
    public void Conduct(Leprechaun l, int nx, int ny){     //ָ��Сආ��ű�����
        l.Goto(nx, ny);
    }
    */
    //ע�⣺�˴������������ַ�ʽ������ȷ���ã�

    @Override   //11.10���¸�д
    public void Conduct(Creature c, int nx, int ny) //�����ͷ���ֵ��֤��ͬ
    {
        if(c.getClass() == Leprechaun.class)
        {
            c.Goto(nx, ny);
        }
        else System.out.println("�߾�����ָ�ӷ�С������");
    }
}

class Map{  //��ͼ��
    public static Creature[][] map= new Creature[20][20];//��ʼ��Ϊһ��20 * 20�ĵ�ͼ����ͼ��Ŷ��������
                public static void Print()//��̬���������ڴ�ӡ������ͼ
                {
                    System.out.println("��ӡ��ͼ��");
                    for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                if(map[i][j] != null) {
                    String s = String.format("%s\t", Map.map[i][j].name);
                    System.out.print(s);
                }
                else
                {
                    String b = String.format("%s\t", "0");//Ϊ������ս����������ӻ�����û��վ����ĵط����0�����Ʊ������
                    System.out.print(b);
                }
            }
            System.out.println();
        }
    }
}
