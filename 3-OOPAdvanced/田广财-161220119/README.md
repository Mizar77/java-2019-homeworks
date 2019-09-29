## 作业3 葫芦兄弟 

161220119 田广财

### 设计思路

+ 两个阵营，葫芦娃和葫芦爷爷一个阵营，用a表示，喽啰，蝎子，蛇，一个阵营，用b表示

+ 设计一张11*20的战场，左边11 *10是葫芦娃阵营的地盘，右边剩余部分是妖孽阵营的地盘，两阵营相互对峙

+ 葫芦兄弟们，葫芦爷爷，蝎子，蛇，喽啰都是生物，都继承自生物类，他们在地图的位置用他们的名字表示出

  类图

  Creature   生物类，父类

  Calabash 葫芦娃类，继承自生物类

  Grandfa 爷爷类，继承自生物

  Snake 蛇类，继承自生物
  
  Scorpion 蝎子类，继承自生物
  
  Minion 喽啰类，继承自生物
  
  Calabashfield 葫芦娃阵营类
  
  Scorpionfield 妖孽阵营类
  
  Main 主类 运行用
  
  ![Top-Level Package.png](https://i.loli.net/2019/09/18/fL2IRJ9qltWEAOj.png)
  
  运行截图
  
  ![1.PNG](https://i.loli.net/2019/09/18/h9UC7AZryLVKfzS.png)
  
  

  ![2.PNG](https://i.loli.net/2019/09/18/qUphYTBQvJgSatG.png)
  
  ![3.PNG](https://i.loli.net/2019/09/18/erl2wQZHNvaWJ6O.png)
  
  ![4.PNG](https://i.loli.net/2019/09/18/KhJxFpl2IHecDuf.png)
  
  ![5.PNG](https://i.loli.net/2019/09/18/ikZru5pSPd4nxCz.png)
  
  ![6.PNG](https://i.loli.net/2019/09/18/sK3udFzyANp6VYf.png)
  
  ![7.PNG](https://i.loli.net/2019/09/18/EfvG7axqs6dKcyH.png)
  
  ### 父类
  
  生物类
  
  ```java
  public class Creature {
      protected String name;
      protected String type;
  
      public Creature() {
          name = null;
          type = null;
      }
  
      public String getName() {
          return name;
      }
  
      public String getType() {
          return type;
      }
  }
  ```
  
  

名字和阵营类别默认为空

### 葫芦娃阵营

+ 枚举出七个葫芦娃

+ ```java
  enum One {
      hlw1(1, "老大", "红色"),
      hlw2(2, "老二", "橙色"),
      hlw3(3, "老三", "黄色"),
      hlw4(4, "老四", "绿色"),
      hlw5(5, "老五", "青色"),
      hlw6(6, "老六", "蓝色"),
      hlw7(7, "老七", "紫色");
      private int rank;
      private String name;
      private String color;
  
      One(int rank, String name, String color) {
          this.rank = rank;
          this.name = name;
          this.color = color;
      }
  
      public int getRank() {
          return rank;
      }
  
      public String getColor() {
  
          return color;
      }
  
      public String getName() {
  
          return name;
      }
  }
  
  public class Calabash extends Creature {
      protected int rank;
      protected String color;
  
      public Calabash(int index) {
          if (index == 1) {
              rank = One.hlw1.getRank();
              name = One.hlw1.getName();
              color = One.hlw1.getColor();
              type = "a";
          } else if (index == 2) {
              rank = One.hlw2.getRank();
              name = One.hlw2.getName();
              color = One.hlw2.getColor();
              type = "a";
          } else if (index == 3) {
              rank = One.hlw3.getRank();
              name = One.hlw3.getName();
              color = One.hlw3.getColor();
              type = "a";
  
          } else if (index == 4) {
              rank = One.hlw4.getRank();
              name = One.hlw4.getName();
              color = One.hlw4.getColor();
              type = "a";
          } else if (index == 5) {
              rank = One.hlw5.getRank();
              name = One.hlw5.getName();
              color = One.hlw5.getColor();
              type = "a";
          } else if (index == 6) {
              rank = One.hlw6.getRank();
              name = One.hlw6.getName();
              color = One.hlw6.getColor();
              type = "a";
          } else if (index == 7) {
              rank = One.hlw7.getRank();
              name = One.hlw7.getName();
              color = One.hlw7.getColor();
              type = "a";
          } else {
  
          }
      }
  
      public int getRank() {
          return rank;
      }
  
      public String getColor() {
          return color;
      }
  
      public static void main(String[] args) {
          Calabash calabash = new Calabash(6);
          System.out.println(calabash.getRank() + calabash.getName() + calabash.getColor() + calabash.getType());
      }
  }
  
  ```

  

+ 葫芦娃类继承自生物类，有多了颜色，排行等相应属性

+ 在葫芦娃阵营中，县让七个葫芦娃随机站队，然后，给七个葫芦娃排序，将顺序的葫芦娃使用长蛇阵法复制到葫芦娃阵营中的相应位置

  ```java
  import java.util.ArrayList;
  import java.util.Random;
  
  public class Calabashfield {
      public Creature[][] creatures1 = new Creature[11][10];
      private    Calabash calabash[] = new Calabash[7];
      public Calabashfield() {
          for (int i = 0; i < 11; i++) {
              for (int j = 0; j < 10; j++) {
                  creatures1[i][j]=new Creature();
              }
          }
      }
      public void RandomCalabash(){
          ArrayList<Integer> arrayList = new ArrayList<>();
          Random random = new Random();
          while (arrayList.size() < 7) {
              int rand = random.nextInt(7) % 7;
              if (!arrayList.contains(rand))
                  arrayList.add(rand);
          }
          int t = 1;
          for (int j : arrayList) {
              calabash[j] = new Calabash(t);
              Integer index = j + 1;
              t++;
          }
      }
      public void SortCalabash() {
          for (int i = 0; i < 6; i++) {
              for (int j = 0; j < 6 - i; j++) {
                  if (calabash[j].getRank() > calabash[j + 1].getRank()) {
                      Calabash t = calabash[j];
                      calabash[j] = calabash[j + 1];
                      calabash[j + 1] = t;
                  }
              }
          }
      }
  
      public boolean isEmpty(int i, int j) {
          return creatures1[i][j].getType() == null;
      }
  
      public void SetGoodToField(Creature creature, int i, int j) {
          if (isEmpty(i, j)) {
              creatures1[i][j] = creature;
          } else
              return;
      }
      public void SetStyle(){
          SetGoodToField(new Grandfa(),0,0);
          for(int i=0;i<7;i++)
          {
              SetGoodToField(calabash[i],(i+2),6);
          }
      }
  
      public void PrintCalabash(){
          for(int i=0;i<7;i++){
              System.out.println(calabash[i].getName()+"\t");
          }
      }
      public void PrintCalabashfield(){
          for (int i = 0; i < 11; i++) {
              for (int j = 0; j < 10; j++) {
                  System.out.print(creatures1[i][j].getName() + "\t");
              }
              System.out.println();
          }
      }
  }
  
  ```

  

  

### 妖精阵营

蛇



继承自生物

```java
public class Snake extends Creature {
    public Snake(){
        name="蛇精";
        type="b";
    }
}

```



蝎子继承自生物

```java
import javafx.scene.Scene;

public class Scorpion extends Creature{
    public Scorpion(){
        name="蝎子";
        type="b";
    }
}

```

喽啰继承自生物

```java
public class Minion extends Creature {
    public Minion(){
        name="喽啰";
        type="b";
    }

}

```

在妖孽阵营设置一个11*10的图，将相应的动物设置到相应的位置，形成各种相应的阵法

```java
public class Scorpionfield {
    public Creature[][] creatures2 = new Creature[11][10];

    public Scorpionfield() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                creatures2[i][j] = new Creature();
            }
        }
    }

    public boolean isEmpty(int i, int j) {
        return creatures2[i][j].getType() == null;
    }

    public void SetBadToField(Creature creature, int i, int j) {
        if (isEmpty(i, j)) {
            creatures2[i][j] = creature;
        } else
            return;
    }

    public void SetStyle1() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Scorpion(), 1, 1);
        SetBadToField(new Minion(), 3, 2);
        SetBadToField(new Minion(), 5, 3);
        SetBadToField(new Minion(), 7, 4);
        SetBadToField(new Minion(), 5, 5);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 1, 7);
    }

    public void SetStyle2() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 1, 8);
        SetBadToField(new Minion(), 2, 7);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Minion(), 6, 3);
        SetBadToField(new Minion(), 7, 2);
        SetBadToField(new Scorpion(), 8, 1);
    }

    public void SetStyle3() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 0, 5);
        SetBadToField(new Minion(), 1, 4);
        SetBadToField(new Minion(), 2, 5);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Scorpion(), 5, 4);
        SetBadToField(new Minion(), 6, 5);
        SetBadToField(new Minion(), 7, 4);
        SetBadToField(new Minion(), 8, 5);
        SetBadToField(new Minion(), 9, 4);
//        SetBadToField(new Minion(), 10, 5);

    }

    public void SetStyle4() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 2, 5);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Minion(), 6, 5);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 5, 6);
        SetBadToField(new Minion(), 5, 7);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Scorpion(), 5, 3);
    }

    public void SetStyle5() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 1, 4);
        SetBadToField(new Minion(), 3, 3);
        SetBadToField(new Scorpion(), 5, 2);
        SetBadToField(new Minion(), 7, 3);
        SetBadToField(new Minion(), 9, 4);
        SetBadToField(new Minion(), 3, 5);
        SetBadToField(new Minion(), 7, 5);
        SetBadToField(new Minion(), 5, 6);

    }

    public void SetStyle6() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 4, 2);
        SetBadToField(new Scorpion(), 5, 2);
        SetBadToField(new Minion(), 6, 2);
        SetBadToField(new Minion(), 4, 3);
        SetBadToField(new Minion(), 5, 3);
        SetBadToField(new Minion(), 6, 3);
        SetBadToField(new Minion(), 4, 4);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Minion(), 6, 4);
        SetBadToField(new Minion(), 3, 3);
        SetBadToField(new Minion(), 7, 3);
        SetBadToField(new Minion(), 2, 4);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(),7,4);
        SetBadToField(new Minion(),8,4);
        SetBadToField(new Minion(),1,5);
        SetBadToField(new Minion(),2,5);
        SetBadToField(new Minion(),0,6);
        SetBadToField(new Minion(),1,6);
        SetBadToField(new Minion(),8,5);
        SetBadToField(new Minion(),9,5);
        SetBadToField(new Minion(),9,6);
        SetBadToField(new Minion(),10,6);
    }
    public void SetStyle7(){
        SetBadToField(new Snake(),0,9);
        SetBadToField(new Minion(),2,4);
        SetBadToField(new Minion(),3,4);
        SetBadToField(new Minion(),4,4);
        SetBadToField(new Minion(),5,4);
        SetBadToField(new Minion(),6,4);
        SetBadToField(new Minion(),7,4);
        SetBadToField(new Minion(),3,3);
        SetBadToField(new Scorpion(),4,2);
        SetBadToField(new Minion(),3,5);
        SetBadToField(new Minion(),4,6);

    }

    public void PrintScopionfield() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(creatures2[i][j].getName() + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scorpionfield scorpionfield = new Scorpionfield();
        scorpionfield.PrintScopionfield();
        scorpionfield.SetStyle7();
        scorpionfield.PrintScopionfield();
    }


}

```

### 战场

设置一个11*20的生物类型的二维数组，初始为空，左边将设置好的葫芦娃阵营数组复制过来，右边复制妖孽阵营的数组信息，然后打印

```java
public class Battlefield {
    private static int rows = 11, cols = 20;
    private Creature[][] creatures = new Creature[rows][cols];

    public Battlefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                creatures[i][j] = new Creature();
            }
        }
    }

    public void CopyGoodToBattlefield() {
        Calabashfield calabashfield = new Calabashfield();
        calabashfield.RandomCalabash();
        calabashfield.SortCalabash();
        calabashfield.SetStyle();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 10; j++) {
                creatures[i][j] = calabashfield.creatures1[i][j];
            }
        }
    }

    public void CopyBadToBattlefield(int index) {
        Scorpionfield scorpionfield = new Scorpionfield();
        if (index == 1) {
            scorpionfield.SetStyle1();
        } else if (index == 2) {
            scorpionfield.SetStyle2();
        } else if (index == 3) {
            scorpionfield.SetStyle3();
        } else if (index == 4) {
            scorpionfield.SetStyle4();
        } else if (index == 5) {
            scorpionfield.SetStyle5();
        } else if (index == 6) {
            scorpionfield.SetStyle6();
        } else {
            scorpionfield.SetStyle7();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 10; j < cols; j++) {
                creatures[i][j] = scorpionfield.creatures2[i][j - 10];
            }
        }
    }

    public void PrintBattlefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (creatures[i][j].getType() == null) {
                    System.out.print("    " + "\t");
                } else {
                    System.out.print(creatures[i][j].getName() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("good");
        Battlefield battlefield = new Battlefield();
        battlefield.CopyGoodToBattlefield();
        battlefield.PrintBattlefield();
    }
}

```

