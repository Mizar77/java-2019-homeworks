package CalabashBrothers;

class Boy {
    private String name;
    private String color;
    private int age_rank;
    private int color_rank;
    Boy(String name, String color, int age_rank, int color_rank)
    {
        this.name=name;
        this.color=color;
        this.age_rank=age_rank;
        this.color_rank=color_rank;
    }
    void ReportNumber()
    {
        System.out.print(" "+name);
    }
    void ReportColor()
    {
        System.out.print(" "+color);
    }
    void ReportSwap(int prev, int next)
    {
        System.out.println(name+": "+prev+"->"+next);
    }

    int GetColorRank()
    {
        return color_rank;
    }

    int GetAgeRank()
    {
        return age_rank;
    }
}
