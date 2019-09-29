package tgc;
public enum Huluwa {
//    枚举葫芦娃   排行老× 颜色
    hlw1("老大", "红色"),
    hlw2("老二", "橙色"),
    hlw3("老三", "黄色"),
    hlw4("老四", "绿色"),
    hlw5("老五", "青色"),
    hlw6("老六", "蓝色"),
    hlw7("老七", "紫色"),
//    七个葫芦娃  再加一个出错类型
    hlw0("错误","错误");
    private String rank;
    private String color;
    Huluwa(String rank, String color) {
        this.rank = rank;
        this.color = color;

    }
//返回排行
    public String getRank() {
        return this.rank;
    }
//    返回颜色
    public String getColor() {
        return this.color;
    }
//    从一个位置移动到另一个位置
    public String getCompareRank(Integer first, Integer last) {
        first = first + 1;
        last = last + 1;
        return rank + ":" + " " + first.toString() + "->" + last.toString();
    }
    
}
