class Monsters extends Camp{
    public Monsters(int n){
        cheerUper = new Snake("蛇精");
        members = new Being[n];
        members[0] = new Scorpion("蝎子精");
        for(int i = 1; i < n; i++){
            members[i] = new Heeler("小喽啰" + i + "号");
        }
    }
    public void arrangePosition(String form){
        //安排蝎子精和小喽啰
        super.arrangePosition(form);
        //安排蛇精
        cheerUper.move(6, 0);
    }

}