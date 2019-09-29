import java.util.*;
class OOPBasics{
    public static void main(String[] args){
        HuluWaSolution solution = new HuluWaSolution();
        solution.bubbleSort();
        solution.quickSort();
    }
}
//解决题目的Solution类，负责完成题目要求功能：
class HuluWaSolution{
    private HuluWa []_brothers;
    private void _pivot(int begin,int end){
        if(begin >= end)
            return;
        int i=begin,j=begin;
        int pivot = _brothers[begin].key();
        while(i < end){
            if(_brothers[i].key() < pivot){
                j++;
                if(i!=j){
                    _brothers[j].printMovement(j,i);
                    _brothers[i].printMovement(i,j);
                    HuluWa temp = _brothers[j];
                    _brothers[j]=_brothers[i];
                    _brothers[i]=temp;
                }  
            }
            i++;
        }
        if(j != begin){
            _brothers[j].printMovement(j,begin);
            _brothers[begin].printMovement(begin,j);
            HuluWa temp = _brothers[j];
            _brothers[j]=_brothers[begin];
            _brothers[begin]=temp;
        }
        _pivot(begin, j);
        _pivot(j+1, end);

    }    
    HuluWaSolution(){ 
        _brothers = new HuluWa[7];
        _brothers[0] = new HuluWa("老大","红色",1);
        _brothers[1] = new HuluWa("老二","橙色",2);
        _brothers[2] = new HuluWa("老三","黄色",3);
        _brothers[3] = new HuluWa("老四","绿色",4);
        _brothers[4] = new HuluWa("老五","青色",5);
        _brothers[5] = new HuluWa("老六","蓝色",6);
        _brothers[6] = new HuluWa("老七","紫色",7);
    }
    //随意站队，打乱葫芦兄弟数组顺序：
    private void shuffle(){   
        Random r = new Random();
        for(int i=0;i<7;i++)
        {
            int j = r.nextInt(7);
            HuluWa temp = _brothers[i];
            _brothers[i]=_brothers[j];
            _brothers[j]=temp;
        }
    }
    //冒泡排序   
    public void bubbleSort(){
        shuffle();
        for(int i=0;i<_brothers.length;i++)
            for(int j=0;j<_brothers.length-1-i;j++)
            {
                if(_brothers[j].key() > _brothers[j+1].key())
                {
                    _brothers[j].printMovement(j,j+1);
                    _brothers[j+1].printMovement(j+1,j);
                    HuluWa temp = _brothers[j];
                    _brothers[j]=_brothers[j+1];
                    _brothers[j+1]=temp;
                    
                }
            }
        for(int i=0;i<_brothers.length;i++)
        _brothers[i].printName();
    }
    //二分法快速排序
    public void quickSort(){
        shuffle();
        _pivot(0,_brothers.length);
        for(int i=0;i<_brothers.length;i++)
        _brothers[i].printColor();

    }


}
//葫芦娃类，描述葫芦娃对象
class HuluWa{
    //葫芦娃的名字:
    private String name; 
    //葫芦娃的颜色:
    private String color;
    //葫芦娃的序号，用来排序: 
    private int number;
    //构造函数:
    HuluWa(String name,String c,int n){
        this.name = name;
        this.color = c;
        this.number = n;
    }
    //按照名字报数：
    public void printName(){
        System.out.println(name);
    }
    //按照颜色报数：
    public void printColor(){
        System.out.println(color);
    }
    //交换位置时报告交换动作"name:b->e":
    public void printMovement(int b,int e){
        System.out.println(name+":"+b+"->"+e);
    }
    //返回该葫芦娃的序号:
    public int key(){
        return this.number;
    }
}