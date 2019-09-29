# 作业2：面向葫芦娃编程

## 主要思路

分为三个类，葫芦娃，排序，Main

### 葫芦娃类

葫芦娃分别用rank和color两个成员来描述属性，只有七只不同的葫芦娃，所以属性域有七只葫芦娃和一个出错时的属性，便于调试代码。葫芦娃通过给定的方法，将自己的排行和颜色传给外部，并报告交换位置信息

```java
public enum Huluwa {
//    枚举葫芦娃   排行老× 颜色
    hlw1("老大", "红色"),
    hlw2("老二", "橙色"),
    hlw3("老三", "黄色"),
    hlw4("老四", "绿色"),
    hlw5("老五", "青色"),
    hlw6("老六", "蓝色"),
    hlw7("老七", "紫色"),
//    七个葫芦娃  再加一个出错类型
    hlw0("错误","错误");
    private String rank;
    private String color;
    Huluwa(String rank, String color) {
        this.rank = rank;
        this.color = color;

    }
//返回排行
    public String getRank() {
        return this.rank;
    }
//    返回颜色
    public String getColor() {
        return this.color;
    }
public String getCompareRank(Integer first, Integer last) {first = first + 1;
        last = last + 1;
        return rank + ":" + " " + first.toString() + "->" + last.toString();
    }
    
```



### 排序类

在排序类，需要实现葫芦兄的的初始化，随机站队，冒泡排序和二分排序

要让葫芦娃随机站队，通过随机数的方法，初始化七只葫芦娃实现随机位置。

```java
ystem.out.println("葫芦娃随机站队：");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        while (arrayList.size() < 7) {
            int rand = random.nextInt(7) % 7;
            if (!arrayList.contains(rand))
                arrayList.add(rand);
        }
        int i = 1;
        for (int j : arrayList) {
            brothers[j] = getHuluwa(i);
            Integer index = j + 1;
            i++;
        }
        for (int t = 0; t < 7; t++) {
            System.out.print(brothers[t].getRank() + brothers[t].getColor() + " ");
        }
        System.out.println();
```

冒泡排序方法

```java
public void bubbleSort() {
        System.out.println("冒泡排序：");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (brothers[j].compareTo(brothers[j + 1]) > 0) {
                    Huluwa t = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = t;
                    System.out.println(brothers[j + 1].getCompareRank(j, j + 1));

                }
            }
        }
        System.out.println("冒泡排序结果：");
        for (int i = 0; i < 7; i++) {
            System.out.print(brothers[i].getRank() + "  ");
        }
        System.out.println();

```

二分排序

```java
public void binarySort() {
        System.out.println("二分法排序：");
        for(int i=0;i<brothers.length;i++){
            Huluwa t=brothers[i];
            int left=0;
            int right=i-1;
            int mid=0;
            while   (left<=right){
                mid=(left+right)/2;
                if(t.compareTo(brothers[mid])<0){
                    right=mid-1;

                }else {
                    left=mid+1;
                }
            }
            for(int j=i-1;j>=left;j--){
                brothers[j+1]=brothers[j];
                System.out.println( brothers[j].getCompareRank(j,j+1));
            }
            if(left!=i){
                brothers[left]=t;

            }
        }

        System.out.println("二分法排序结果：");
        for (int l = 0; l < 7; l++) {
            System.out.print(brothers[l].getColor() + "  ");
        }
        System.out.println();

    }

```

### Main

```java
package tgc;
public class CalabashBrothers {
    public static void main(String[] args) {
        BrothersSort brothersSort1 = new BrothersSort();
        brothersSort1.bubbleSort();
        System.out.println();
        BrothersSort brothersSort2 = new BrothersSort();
        brothersSort2.binarySort();
    }


}

```

