package org.nju.edu.Test;

import org.apache.poi.ss.formula.functions.Na;

public class GourdMan {
    private String Name;
    private String Color;
    private int NameRank;
    private int ColorRank;

    GourdMan(String name) throws Exception{
        Name = name;
        switch (name){
            case "大娃":{
                NameRank = RankingConstants.First;
                Color = "红色";
                ColorRank = RankingConstants.Red;
                break;
            }
            case "二娃": {
                NameRank = RankingConstants.Second;
                Color = "橙色";
                ColorRank = RankingConstants.Orange;
                break;
            }
            case "三娃": {
                NameRank = RankingConstants.Third;
                Color = "黄色";
                ColorRank = RankingConstants.Yellow;
                break;
            }
            case "四娃": {
                NameRank = RankingConstants.Forth;
                Color = "绿色";
                ColorRank = RankingConstants.Green;
                break;
            }
            case "五娃": {
                NameRank = RankingConstants.Fifth;
                Color = "青色";
                ColorRank = RankingConstants.Cyan;
                break;
            }
            case "六娃": {
                NameRank = RankingConstants.Sixth;
                Color = "蓝色";
                ColorRank = RankingConstants.Blue;
                break;
            }
            case "七娃": {
                NameRank = RankingConstants.Seventh;
                Color = "紫色";
                ColorRank = RankingConstants.Purple;
                break;
            }
            default: throw new Exception("你确定这是一个葫芦娃？");
        }
    }

    public String getName(){
        return Name;
    }

    public String getColor(){
        return Color;
    }

    public void SayName(){
        System.out.println(Name);
    }

    public void SayColor(){
        System.out.println(Color);
    }

    public int getNameRank(){
        return NameRank;
    }

    public int getColorRank(){
        return ColorRank;
    }

    public boolean CompareRankWith(GourdMan anotherGourdMan){
        return anotherGourdMan.getNameRank() < this.getNameRank();
    }

    public boolean CompareColorWith(GourdMan anotherGourdMan){
        return anotherGourdMan.getColorRank() < this.getColorRank();
    }
}
