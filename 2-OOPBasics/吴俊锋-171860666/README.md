
# 主要类介绍

1. Position类：

    (1)private boolean occupied; //表示该位置是否被占据；
    
    (2)HuLuWa huluwa; //占据该位置的葫芦娃对象的引用；
    
    (3)方法boolean accept(HuLuWa wa); //接受一个葫芦娃对象，若该位置已经有其它葫芦娃，返回false
    
    (4)方法void leave(); //该位置上的葫芦娃离开；

2. Huluwa类：

    (1)private String name; //名字
    
    (2)private String color;  //颜色
    
    (3)boolean moveTo(Position prePos, Position nxtPos); //从当前位置移动到下一个位置，若失败返回false；
        

# 排序算法思想

1. 初始化7个HuLuWa对象，初始化8个Position对象，其中第8个Position对象用作暂存区；
2. 随机将葫芦娃对象填入Pos中；
3. 调用排序算法，其中调用HuLuWa类的moveTo方法来实现葫芦娃位置的移动；
