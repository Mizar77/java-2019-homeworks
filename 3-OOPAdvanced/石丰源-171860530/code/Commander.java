public class Commander{
    public static void main(String[] args){
        CalabashBrothers cb = new CalabashBrothers();
        Monsters mt;
        for(int round = 0; round < 8; round++){
            System.out.println("------------------------------------------------------Round"+(round + 1)+"------------------------------------------------------");
            cb.arrangePosition("长蛇");
            mt = new Monsters(FormationMembers.num[round]);
            mt.arrangePosition(FormationName.name[round]);
            String [][]map = new String[7][14];
            for(int j = 0; j < mt.members.length; j++){
                map[mt.members[j].x][mt.members[j].y + 7] = mt.members[j].name;
            }
            for(int j = 0; j < cb.members.length; j++){
                map[cb.members[j].x][cb.members[j].y] = cb.members[j].name;
            }
            map[mt.cheerUper.x][mt.cheerUper.y + 7] = mt.cheerUper.name;
            map[cb.cheerUper.x][cb.cheerUper.y] = cb.cheerUper.name;
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 14; j++){
                    if(map[i][j] == null)
                        System.out.print("\t");
                    else
                        System.out.print(String.format("%-6s",map[i][j]));
                }
                System.out.println();
            }
            Grandfather gf = (Grandfather)cb.cheerUper;
            Snake s = (Snake)mt.cheerUper;
            gf.cheerUp();
            s.cheerUp();
        }
    }
}

