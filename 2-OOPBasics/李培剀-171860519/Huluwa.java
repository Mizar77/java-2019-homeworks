enum Color {
    red("老大","红色"),
    orange("老二", "橙色"),
    yellow("老三", "黄色"),
    green("老四", "绿色"),
    cyan("老五", "青色"),
    blue("老六", "蓝色"),
    purple("老七", "紫色");
    private final String AgeCN;
    private final String ColorCN;
    private Color(String AgeCN, String ColorCN) {this.AgeCN = AgeCN; this.ColorCN = ColorCN;}
    public String getAgeCN() {return AgeCN;}
    public String getColorCN() {return ColorCN;}
}

class Hulu {
    private int order;
    private Color color;
    public Hulu() {order = 0; color = Color.red;}
    public Hulu(int o, Color c) {order = o; color = c;}
    public void setOrder(int o) {order = o;}
    public void setColor(Color c) {color = c;}
    public int getOrder() {return order;}
    public Color getColor() {return color;}
    public void swap(Hulu another) {
        System.out.println(this.color.getAgeCN() + ": " + ("" + this.order) + "->" + ("" + another.getOrder()));
        System.out.println(another.color.getAgeCN() + ": " + ("" + another.getOrder()) + "->" + ("" + this.order));
        int tmp = this.order;
        this.order = another.getOrder();
        another.setOrder(tmp);
    }
}

public class Huluwa {
    public static void main(String[] args){
        int HULU_NUM = 7;
        boolean[] used = new boolean[HULU_NUM];
        Hulu[] hulus = new Hulu[HULU_NUM];

        /* 初始化和生成随机位置 */
        for(int i = 0; i < HULU_NUM; i++) {
            hulus[i] = new Hulu();
            switch (i) {
                case 1: hulus[i].setColor(Color.orange); break;
                case 2: hulus[i].setColor(Color.yellow); break;
                case 3: hulus[i].setColor(Color.green); break;
                case 4: hulus[i].setColor(Color.cyan); break;
                case 5: hulus[i].setColor(Color.blue); break;
                case 6: hulus[i].setColor(Color.purple); break;
                default: hulus[i].setColor(Color.red); break;
            }
            for(;;) {
                int tmp = (int) (Math.random() * 7);
                if(!used[tmp]) {
                    hulus[i].setOrder(tmp);
                    used[tmp] = true;
                    break;
                }
            }
        }

        /* 冒泡排序 */
        for(int i = 0; i < HULU_NUM - 1; i++) {
            for (int j = i + 1; j < HULU_NUM; j++) {
                if (hulus[i].getOrder() > hulus[j].getOrder())
                    hulus[i].swap(hulus[j]);
            }
        }
        for(int i = 0; i < HULU_NUM; i++)
            System.out.println(hulus[i].getColor().getAgeCN() + " 排序：" + hulus[i].getOrder());

        /* 重置和重新生成随机位置 */
        for(int i = 0; i < HULU_NUM; i++)
            used[i] = false;
        for(int i = 0; i < HULU_NUM; i++) {
            for(;;) {
                int tmp = (int) (Math.random() * 7);
                if(!used[tmp]) {
                    //System.out.println(tmp);
                    hulus[i].setOrder(tmp);
                    used[tmp] = true;
                    break;
                }
            }
        }

        /* 二分排序 */
        for (int i = 1; i < HULU_NUM; i++) {
            int tmp = hulus[i].getOrder();
            int low = 0;
            int high = i - 1;
            int mid = -1;
            for (; low <= high; ) {
                mid = low + (high - low) / 2;
                if (hulus[mid].getOrder() > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--)
                hulus[j + 1].swap(hulus[j]);
        }
        for(int i = 0; i < HULU_NUM; i++)
            System.out.println(hulus[i].getColor().getColorCN() + " 排序：" + hulus[i].getOrder());

        /* test */
        /*for(int i = 0; i < HULU_NUM; i++) {
            System.out.print(hulus[i].getOrder());
            System.out.print(' ' + hulus[i].getColor().getAgeCN() + ' ');
            System.out.println(hulus[i].getColor().getColorCN());
        }*/
    }
}
