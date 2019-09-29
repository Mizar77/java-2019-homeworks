//阵营
public class Camp{
    Being cheerUper;
    Being []members;
    Map m;
    FormationBook book = new FormationBook();
    public void changeMap(String form){
        m = book.getMap(form);
    }
    public void arrangePosition(String form){
        System.out.println(form);
        changeMap(form);
        int order = 0;
        for(int i = 0; i < m.map.length; i++){
            for(int j = 0; j < m.map[0].length; j++){
                if(m.map[i][j] == true){
                    members[order++].move(i, j); 
                }
            }
        }
    }
}
