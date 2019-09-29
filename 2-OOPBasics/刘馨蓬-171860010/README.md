# 作业：面向葫芦娃编程

一、问题的对象<br/>
1.葫芦兄弟<br/>
2.进行排序的“上帝之手”<br/>
二、对象的属性和行为<br/>
1.葫芦兄弟<br/>
a.有姓名、位置编号、颜色和排序的优先级（按照年龄，年龄越大优先级越小）<br/>
    String name;<br/>
    int place;<br/>
    String color;<br/>
    int priority;<br/>
b.葫芦兄弟可以进行位置的改变、报出自己的名字、报出自己的颜色三种行为，其中位置改变包括更改位置以及说出更改的内容<br/>
void nameOff(){}<br/>
void colorOff(){}<br/>
void swapAction(int x){}<br/>
void placeChange(int x){}<br/>
2.上帝视角<br/>
a.上帝创造了七个葫芦兄弟，并且给他们名字、颜色与相应的优先值<br/>
Brother[] members;<br/>
void initialize(){}<br/>
b.让七个葫芦兄弟随意站街<br/>
void disruptTheOrder(){}<br/>
c.让七个葫芦兄弟按照冒泡法排序，并报名字<br/>
void bubbleSort(){}<br/>
d.让七个兄弟按照二分法进行排序，并报颜色<br/>
void dichotomy(){}<br/>