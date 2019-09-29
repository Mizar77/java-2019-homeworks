我创建了Hulu_bro作为对象，使用int num来标识不同的葫芦兄弟；
创建了构造器来初始化；

使用enum来使得int和颜色和年龄大小一一对应：
enum作为类，我们可以使用values()方法将其转化为数组，以实现一一对应的关系；
enum My_color{
    红色,橙色,黄色,绿色,青色,蓝色,紫色
};

enum Rank{
    老大,老二,老三,老四,老五,老六,老七
};

使用函数来使得葫芦兄弟报数：这里体现了对象之间消息传递的机制
public void tell_self(){
        System.out.print(Rank.values()[num] + " ");
}

public void tell_col(){
       System.out.print(My_color.values()[num] + " ");
}

使用对象数组来存储葫芦兄弟，对该对象数组进行冒泡和二分排序；
Hulu_bro []bros;
bros = new Hulu_bro[7];

以及使用了list类来将数组转化为list，调用Collections.shuffle(list); 来实现随机赋值

在排序的时候使用了构造器类来存储Hulu_bro这个对象，来实现对象之间的交换
class BroWrapper{
    Hulu_bro x;
    BroWrapper(Hulu_bro x){
        this.x=x;
    }
}

public static void swap(BroWrapper x1,BroWrapper x2)
    {
        Hulu_bro temp=x1.x;
        x1.x=x2.x;
        x2.x=temp;
    }
