import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CalabashTeam {
    private List<Calabash> calabashes;

    public CalabashTeam() {
        this.calabashes = new ArrayList<>();
        for(int i = 0; i < 7; ++i){
            Calabash calabash = new Calabash(i);
            calabashes.add(calabash);
        }
    }

    public void RinkList(){
        System.out.println("打乱后队列：");
        show(false);
        System.out.println("排序过程：");
        BubbleSortList();
        System.out.println("排序完队列：");
        show(false);
    }

    public void ColorList(){
        System.out.println("打乱后队列：");
        show(true);
        System.out.println("排序过程：");
        BinarySortList();
        System.out.println("排序完队列：");
        show(true);
    }

    /**
     * 展示葫芦娃，flag=true按Color，否则按Rank
     * @param flag
     */
    private void show(boolean flag){
        for(Calabash calabash: calabashes){
            calabash.shout(flag);
        }
        System.out.println("");
    }

    /**
     * 冒泡法排序列表
     */
    private void BubbleSortList(){
        int length = calabashes.size();
        Calabash temp;
        for(int i = 0; i < length - 1; ++i){
            for(int j = 0; j < length - i - 1; ++j){
                if(calabashes.get(j).getId() > calabashes.get(j + 1).getId()){
                    calabashes.get(j).move(j + 1);
                    calabashes.get(j + 1).move(j);
                    temp = calabashes.get(j);
                    calabashes.set(j, calabashes.get(j + 1));
                    calabashes.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * 二分法排序列表
     */
    private void BinarySortList(){
        int numSorted = 1;
        List<Calabash> calabashList = new LinkedList<>();
        calabashList.add(calabashes.get(0));
        for (int i = 1; i < 7; ++i){
            Calabash temp = calabashes.get(i);
            int start = 0, end = numSorted - 1;
            int mid = (start + end + 1) / 2;
            while(start <= end){
                if(temp.getId() > calabashList.get(mid).getId()){
                    start = mid + 1;
                    mid = (start + end + 1) / 2;
                }else{
                    end = mid - 1;
                    mid = (start + end + 1) / 2;
                }
            }
            calabashList.add(mid, temp);
            numSorted++;
            //葫芦娃们移动，mid后的依次移动一次
            if(i > mid){
                temp.move(mid);
            }
            for(int index = mid + 1; index < numSorted; ++index){
                calabashList.get(index).move(index);
            }
        }
        calabashes = calabashList;
    }

    /**
     * 打乱列表
     */
    public void shuffle(){
        Collections.shuffle(calabashes);
        for (int i = 0; i < 7; ++i){    //打乱顺序，葫芦娃们各自移动
            calabashes.get(i).setPosition(i);
        }
    }

}
