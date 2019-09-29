class FormationName{
    static String []name = {"鹤翼","雁行","衡轭","长蛇","鱼鳞","方圆","偃月","锋矢"};
}
class FormationMembers{
    static int []num = {7,7,7,7,10,8,10,13};
}
class FormationMap{
    static boolean [][][]matirx = {
        {
           //鹤翼, 7个
            {false,false,false,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,false,true,false,false,false,false},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,false,true,false,false,false},
            {false,false,false,false,true,false,false}
        },
        {
            //雁行，7个
            {true,false,false,false,false,false,false},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,false,true,false,false,false},
            {false,false,false,false,true,false,false},
            {false,false,false,false,false,true,false},
            {false,false,false,false,false,false,true}
        },
        {
            //衡轭，7个
            {false,false,true,false,false,false,false},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false}
        },
        {
           //长蛇，7个
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,true,false,false,false,false}
        },
        {
           //鱼鳞，10个
            {false,false,false,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,false,true,false,true,false,false},
            {false,true,false,true,false,true,false},
            {false,false,false,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,false,false,false,true,false,false}
        },
        {
           //方圆，8个
            {false,false,false,false,false,false,false},
            {false,false,false,true,false,false,false},
            {false,false,true,false,true,false,false},
            {false,true,false,false,false,true,false},
            {false,false,true,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,false,false,false,false,false,false}
        },
        {
           //偃月，10个
            {false,false,false,false,true,false,false},
            {false,false,false,true,false,false,false},
            {false,true,true,false,false,false,false},
            {false,true,true,false,false,false,false},
            {false,true,true,false,false,false,false},
            {false,false,false,true,false,false,false},
            {false,false,false,false,true,false,false}
        },
        {
           //锋矢，13个
            {false,false,false,true,false,false,false},
            {false,false,true,false,false,false,false},
            {false,true,false,false,false,false,false},
            {true,true,true,true,true,true,true},
            {false,true,false,false,false,false,false},
            {false,false,true,false,false,false,false},
            {false,false,false,true,false,false,false}
        }
    };
}

//阵型图谱
class Formation{
    String name;
    Map m;
    Formation(){name = new String(); m = new Map();}
}
//阵型图谱书
public class FormationBook{
    Formation []formbook;
    FormationBook(){
        formbook = new Formation[8];
        for(int i = 0; i < 8; i++){
            //System.out.println(formbook[i] == null);
            //必须加
            formbook[i] = new Formation();
            formbook[i].m.map = FormationMap.matirx[i];
            formbook[i].name = FormationName.name[i];
        }
    }
    public Map getMap(String form){
        for(int i = 0; i < 8; i++){
            if(form == formbook[i].name)
                return formbook[i].m;
        }
        return null;
    }
}