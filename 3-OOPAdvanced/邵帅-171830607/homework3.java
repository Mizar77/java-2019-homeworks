import java.util.ArrayList;
import java.util.Collections;
// ������
class Organism {

    // Point position; //λ��
    String name;

    public Organism() {
        name = "";
    }

    public Organism(String myname) {
        //this.position = mypos;
        this.name = myname;
    }
}
public class homework3 {

    public static void main(String[] args) {
        int N = 20;
        Organism[][] map = new Organism[20][20];
        // Organism []map = new Organism[10];
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++){
                map[i][j] = new Organism();		// ��������
            }
		}
        //for (int i = 0; i < 10; i++) {
           // map[i] = new Organism();
        //}

        // ��ʼ��������ֵܳ�����
        Organism brother1 = new Organism("�ϴ�");
        Organism brother2 = new Organism("�϶�");
        Organism brother3 = new Organism("����");
        Organism brother4 = new Organism("����");
        Organism brother5 = new Organism("����");
        Organism brother6 = new Organism("����");
        Organism brother7 = new Organism("����");
        ArrayList<Organism> bros = new ArrayList<>();
        bros.add(brother1);
        bros.add(brother2);
        bros.add(brother3);
        bros.add(brother4);
        bros.add(brother5);
        bros.add(brother6);
        bros.add(brother7);
        Collections.shuffle(bros);

        for(int i=1;i<=7;i++)
        {
            map[i][0] = bros.get(i-1);
        }
        // ������,�߸�Сආ�
        
        /*Organism badass1 = new Organism("Сආ�");
        Organism badass2 = new Organism("Сආ�");
        Organism badass3 = new Organism("Сආ�");
        Organism badass4 = new Organism("Сආ�");
        Organism badass5 = new Organism("Сආ�");
        Organism badass6 = new Organism("Сආ�");
        Organism badass7 = new Organism("Сආ�");
        */


        //������Ը���N�Ĵ�С�任��������������˾�����ֵ
        for(int i = 10;i<16;i++)
        {
            map[17-i][i] = new Organism("Сආ�");
        }
        Organism scorpion = new Organism("Ы�Ӿ�");

        map[1][16] = scorpion;
        Organism snake = new Organism("�߾�");
        //�����߾�
        map[0][17] = snake;
        //������үү
        Organism grandpa = new Organism("��үү");
        map[0][0] = grandpa;


        //��ӡ
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++){
                    System.out.print(map[i][j].name + "\t");
            }
            System.out.print("\n");
        }


        for(int i = 10;i<16;i++)
        {
            map[17-i][i] = new Organism();      //���֮ǰ��
        }
        
        map[1][16] = new Organism();
        map[0][17] = new Organism();
        //���ɺ�����
        for(int i=1;i<4;i++)
        {
            map[i][i+10] = new Organism("Сආ�");
        }
        map[4][14] = scorpion;
        map[5][14] = snake;
        for(int i=1;i<4;i++)
        {
            map[4-i][i+14] = new Organism("Сආ�");
        }

        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++){
                    System.out.print(map[i][j].name + "\t");
            }
            System.out.print("\n");
        }

    }
}