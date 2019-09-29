public class CalabashBrothers extends Camp{
    public CalabashBrothers(){
        cheerUper = new Grandfather("爷爷");
        members = new Being[7];
        for(int i = 0; i < members.length; i++){
            members[i] = new Calabash(CalabashName.name[i], CalabashColor.color[i]);
        }
    }
    public void arrangePosition(String form){
        //安排葫芦娃
        super.arrangePosition(form);
        //安排爷爷
        cheerUper.move(6, 4);
    }

}