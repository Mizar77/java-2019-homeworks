class Human {
    int id;
    String name;
    String color;
}

public class huluwa {
    Human[] h;

    void initialize() {
        h = new Human[7];
        for (int i = 0; i < 7; i++)
            h[i] = new Human();
        h[0].id = 0; h[0].name = "老大"; h[0].color="红色";
        h[1].id = 1; h[1].name = "老二"; h[1].color="橙色";
        h[2].id = 2; h[2].name = "老三"; h[2].color="黄色";
        h[3].id = 3; h[3].name = "老四"; h[3].color="绿色";
        h[4].id = 4; h[4].name = "老五"; h[4].color="青色";
        h[5].id = 5; h[5].name = "老六"; h[5].color="蓝色";
        h[6].id = 6; h[6].name = "老七"; h[6].color="紫色";
    }
    void randomstarter() {
        int[] rn = new int[7];
        int index=1;
        rn[0] = (int)(Math.random()*7);
        //System.out.print(rn[0]+"_");
        while (index<=6) {
            int r = (int)(Math.random()*7);
            //System.out.print(r+"_");
            boolean judge = true;
            for (int i = 0; i<index; i++) {
                if (r==rn[i]) {
                    judge = false;break;
                }
            }
            if (judge==true) {
                rn[index++]=r;
            }
        }
        //for (int i = 0; i < 7; i++)
        //    System.out.print(rn[i]+1+" ");
        //System.out.println();
        Human[] tmp = new Human[7];
        for (int i = 0; i < 7; i++)
            tmp[i]=h[i];
        for (int i = 0; i < 7; i++)
            h[i]=tmp[rn[i]];
    }
    void bubblesort() {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6-i; j++) {
                if (h[j].id > h[j+1].id) {
                    System.out.println(h[j].name+"："+j+"->"+(j+1));
                    System.out.println(h[j+1].name+"："+(j+1)+"->"+j);
                    Human temp = h[j];
                    h[j] = h[j+1];
                    h[j+1] = temp;
                }
            }
        for (int i = 0; i < 7; i++) {
            System.out.print(h[i].name+" ");
        }
        System.out.println();
    }
    void binarysort() {
        for (int i = 1; i < 7; i++) {
            Human temp = h[i];
            int left = 0; int right = i-1;
            int mid = -1;
            while (left <= right) {
                mid = (left+right)/2;
                if (h[mid].id > temp.id) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                System.out.println(h[j].name+"："+j+"->"+(j+1));
                h[j+1]=h[j];
            }
            System.out.println(temp.name+"："+i+"->"+left);
            h[left] = temp;
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(h[i].color+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        huluwa hu = new huluwa();
        hu.initialize();
        hu.randomstarter();
        hu.bubblesort();
        hu.randomstarter();
        hu.binarysort();
    }
}
