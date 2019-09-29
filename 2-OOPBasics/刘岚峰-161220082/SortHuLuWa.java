public class SortHuLuWa {
    public static void main(String[] args){
        HuLuWaArray HuLuXiongDi = new HuLuWaArray();
        HuLuXiongDi.distributeRandomly();
        HuLuXiongDi.reportHuLuWaBySeniority();
        System.out.println("对葫芦兄弟按照辈分进行冒泡排序");
        HuLuXiongDi.bubbleSortBySeniority();
        HuLuXiongDi.reportHuLuWaBySeniority();
        HuLuXiongDi.distributeRandomly();
        HuLuXiongDi.reportHuLuWaBySeniority();
        System.out.println("对葫芦兄弟按照代表色进行二分插入排序");
        HuLuXiongDi.binarySortByColor();
        HuLuXiongDi.reportHuLuWaByColor();
    }
}
