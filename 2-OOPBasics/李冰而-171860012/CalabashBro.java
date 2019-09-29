public class CalabashBro {
    private String rank;
    private String color;
    private int rankNo;
    private int colorNo;

    public CalabashBro(String r, String c){
        rank=r; color=c;
        switch(r){
            case "老大":rankNo=1; break;
            case "老二":rankNo=2; break;
            case "老三":rankNo=3; break;
            case "老四":rankNo=4; break;
            case "老五":rankNo=5; break;
            case "老六":rankNo=6; break;
            case "老七":rankNo=7; break;
            default:rankNo=0;
        }
        switch(c){
            case "红色":colorNo=1; break;
            case "橙色":colorNo=2; break;
            case "黄色":colorNo=3; break;
            case "绿色":colorNo=4; break;
            case "青色":colorNo=5; break;
            case "蓝色":colorNo=6; break;
            case "紫色":colorNo=7; break;
            default:colorNo=0;
        }
    }
    public void displayRank(){System.out.print(rank+" ");}
    public void displayColor(){System.out.print(color+" ");}
    public int getRankNo(){return rankNo;}
    public int getColorNo(){return colorNo;}
    public Boolean rankIsGreaterThan(CalabashBro cb){
        if(rankNo>cb.getRankNo()){
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
    }
    public Boolean colorIsGreaterThan(CalabashBro cb){
        if(colorNo>cb.getColorNo()){
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }
}
