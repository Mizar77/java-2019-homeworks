 /*葫芦娃有七兄弟（没看过的请参考豆瓣）。红娃排行老大、橙娃排行老二、黄娃排行老三、绿娃排行老四、青娃排行老五、蓝娃排行老六、紫娃排行老七，七兄弟各有一身独特的本领。

葫芦兄弟

请用面向对象编程方法，以Java语言编写程序，实现以下过程：

        先让七个兄弟随意站队，然后让他们按冒泡法依照各自排行（从老大到老七）进行排序，排序结束从第一个到最后一个报数（如老大报“老大”，以此类推）；
        然后让七兄弟再次随意站队，然后用让他们按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序，排序结束从第一个到最后一个报颜色（如老大报“红色”，以此类推）；
        排序过程中，每个葫芦娃在每次交换位置的时候报告交换动作（例如老大从位置5换至位置6，报告“老大：5->6“）
        请在个人作业提交目录下编写README.md文件，说明你是如何用面向对象编程思想来解决以上问题的。
*/
import java.util.*;
public class BrotherStandlSort{//this class is set as the solution of this problem
    static public class BrotherStandlList{
        //in the conditions of the problem
        //the order (or just the Grandpa) can only change the list of brotherstandl
        //the attribution of each brotherstandl can never change after its birth
        //so we treat the list as the class

        public class BrotherStandl{
            //some attributions are following 
            private int rank_of_brother;
            private int color;
            // the place he stand is not the attribution but the state of the brotherstandl
            // so it can be changed 
            // the stand_place is the number of the place , no matter the dimension of the place
            // the place can be following examples : one line, surface of someting or one whole 3-D space 
            int stand_place;
            // first we give birth to each brotherstandl (or just plant the amazing standl)
            BrotherStandl(int initial_rank,int initial_color,int initial_place)
            {
                rank_of_brother=initial_rank;
                color=initial_color;
                stand_place=initial_place;
            }
            BrotherStandl()
            {
                rank_of_brother=color=stand_place=1;
            }  
            // each place can hold over two brothers at one time
            void switch_place(int next_stand_place)// be ordered to the new number of stand place
                                                   // if one didn't need to move, he won't report this order
            {
                if(next_stand_place==stand_place)
                    return;
                else
                {
                    System.out.print("老");
                    switch(rank_of_brother)
                    {
                        case 1:System.out.print("大");break;
                        case 2:System.out.print("二");break;
                        case 3:System.out.print("三");break;
                        case 4:System.out.print("四");break;
                        case 5:System.out.print("五");break;
                        case 6:System.out.print("六");break;
                        case 7:System.out.print("七");break;
                        default:break;
                    }
                    System.out.println(": "+ stand_place +"->"+ next_stand_place);
                    stand_place=next_stand_place;
                }
            }
            int get_stand_place()// get the current stand place
            {  
                return stand_place;
            }
            void set_new_stand_place(int new_stand_palce)// set new stand place for one brother standl
                                                         // in this case, we simulate the brother standl free to move 
                                                         // so they own the freedom to get their favorite place 
            {
                stand_place=new_stand_palce;
            } 
            void report_rank(int stand_order) // check one's rank after sort the list
                                              // the order (or Grandpa) check each place one by one 
            {
                if(stand_order!=stand_place)
                    return;
                System.out.print("老");
                switch(rank_of_brother)
                {
                    case 1:System.out.print("大 ");break;
                    case 2:System.out.print("二 ");break;
                    case 3:System.out.print("三 ");break;
                    case 4:System.out.print("四 ");break;
                    case 5:System.out.print("五 ");break;
                    case 6:System.out.print("六 ");break;
                    case 7:System.out.print("七 ");break;
                    default:break;
                }
            }
            void report_color(int stand_order) // check one's color after sort the list
                                               // the order (or Grandpa) check each place one by one 
            {
                if(stand_place!=stand_order)
                return;
                switch(color)
                {
                    case 1:System.out.print("红");break;
                    case 2:System.out.print("橙");break;
                    case 3:System.out.print("黄");break;
                    case 4:System.out.print("绿");break;
                    case 5:System.out.print("青");break;
                    case 6:System.out.print("蓝");break;
                    case 7:System.out.print("紫");break;
                    default:break;
                }
                System.out.print("色 ");
            }

        }
        BrotherStandl []brotherstandls=new BrotherStandl[7]; // the fantastic standl
                                                             // this just represents the 7 brothers at the rank of them
                                                             // in the other word, the color order of them
                                                             // this does not represent the number of the place 
                                                             // so the order of this arry will not change by the place order
        
        BrotherStandlList()// plant the standl and give birth to the 7 brother standls
        { 
            for(int i=1;i<=7;++i)
            {
                brotherstandls[i-1]=new BrotherStandl(i, i, i);
            }
        }

        // the following two functions are solutions of sort
        void bubblesort()// the tradional bubble sort
        {
            //give each brothers free to choose their place 
            List<Integer> now_stand_place_list=new ArrayList<Integer>();
            for(int i=1;i<=7;++i)
            {
                now_stand_place_list.add(i);
            }
            Collections.shuffle(now_stand_place_list);
            //the following codes aim to get the initial state of the list
            /*  for(int i=0;i<7;++i)
            {
                System.out.print(now_stand_place_list.get(i));
                System.out.print(" ");
            }*/
            for(int i=0;i<7;++i)
            {
                brotherstandls[i].set_new_stand_place(now_stand_place_list.get(i));
            }
            for(int i=0;i<7;++i)
            {
                for(int j=0;j<6-i;++j)
                {
                    if(brotherstandls[j].get_stand_place()>brotherstandls[j+1].get_stand_place())
                    {
                        int temp_for_swap=brotherstandls[j].get_stand_place();
                        brotherstandls[j].switch_place(brotherstandls[j+1].get_stand_place());
                        brotherstandls[j+1].switch_place(temp_for_swap);
                    }
                }   
            }
            // report rank
            for(int j=1;j<=7;++j)
                for(int i=0;i<7;++i)
                    brotherstandls[i].report_rank(j);    
            System.out.print('\n');
        }      

        void binarysort()// the tradional binary insert sort
        {
            //give each brothers free to choose their place 
            List<Integer> now_stand_place_list=new ArrayList<Integer>();
            for(int i=1;i<=7;++i)
            {
                now_stand_place_list.add(i);
            }
            Collections.shuffle(now_stand_place_list);
            // the following codes aim to get the initial state of the list
            /*  for(int i=0;i<7;++i)
            {
                System.out.print(now_stand_place_list.get(i));
                System.out.print(" ");
            }*/
            for(int i=0;i<7;++i)
            {
                brotherstandls[i].set_new_stand_place(now_stand_place_list.get(i));
            }
            System.out.print('\n');
            for(int i=1;i<7;++i)
            {
                int temp_for_find=brotherstandls[i].get_stand_place();
                int left_for_find=0;
                int right_for_find=i-1;
                int mid_for_find=(left_for_find+right_for_find)/2;
                while(left_for_find<=right_for_find)
                {
                    if(brotherstandls[mid_for_find].get_stand_place()>temp_for_find)  
                        right_for_find=mid_for_find-1;
                    else
                        left_for_find=mid_for_find+1;
                    mid_for_find=(left_for_find+right_for_find)/2;
                }
                for(int j=i-1;j>=left_for_find;--j)
                brotherstandls[j+1].switch_place(brotherstandls[j].get_stand_place());
                brotherstandls[left_for_find].switch_place(temp_for_find);
            }
            // report color
            for(int j=1;j<=7;++j)
                for(int i=0;i<7;++i)
                    brotherstandls[i].report_color(j);
            System.out.print('\n');
        } 
    }
    public static void main(String[] args)
    {
        // the following codes are simulate of the description of the problem
        // thank you!
        BrotherStandlList brotherstandllist=new BrotherStandlList();
        brotherstandllist.bubblesort();
        brotherstandllist.binarysort();   
    }
}
