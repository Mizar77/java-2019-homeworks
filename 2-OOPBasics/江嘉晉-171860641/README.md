思路
==

首先閱讀需求，然後寫出一個大概的結構，如要多少個類和對應的變量、方法等。

因為題目的主角是葫蘆娃們，所以可以先構想葫蘆娃的類，同時又因為題目要求葫蘆娃們排序，所以可以構想負責執行入操作的管理者類。

然後可以構想對應類應有的變量，因為排序過程中，位置更新需要報告輸出，故要一個變量去保存(pos)，同時每個娃都有一個不變的名字(name)、不變量的顏色(color)、不變的兄弟間的排名(level)；另外管理者也要管理一個順序去排序，故可用指向CalabashBros類的數組來保存(brosPos)，同時需要保證pos和brosPos所在位置的一致性。

再來想對應類應有的方法，娃們在改變位置時需要修改位置並且報告輸出(setAndReportName(),setAndReportColor())，在比較位置的時候需要傳回自己的兄弟間排名(getLevel())給Manager，在排序完成後也需要報告輸出自己的名字或顏色(getName(),getColor())；另一個方面，管理者報告輸出排序完成後的結果(reportName(),reportColor())，二種排序方法(sortBubble(),sortMerge())，還有隨機打亂順序的方法(randomPos())。


最後有了代碼的雛型就可以實現具體的代碼了。

***
## 綜上所述，得到雛型的代碼
```
class CalabashBros{
    private int pos;
    private final String name;
    private final String color;
    private final int level;

    public CalabashBros(...){...}
    public void setAndReportName(int newPos){...}
    public void setAndReportColor(int newPos){...}
    public void getLevel(){...}
    public void getName(){...}
    public void getColor(){...}
}

class Manager{
    private CalabashBros[] brosPos;

    Manager(...){...}
    public void reportName(){...}
    public void reportColor(){...}
    public void sortBubble(){...}
    public void sortMerge(){...}
    public void randomPos(){...}
}


```