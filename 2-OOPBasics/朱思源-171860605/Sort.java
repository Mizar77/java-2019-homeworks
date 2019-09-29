package CalabashBrothers;

class Sort {

    void BubbleSort(Boy[] boys) {
        for(int i=6;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(boys[j].GetAgeRank()>boys[j+1].GetAgeRank())
                {
                    boys[j].ReportSwap(j,j+1);
                    boys[j+1].ReportSwap(j+1,j);
                    Boy temp=boys[j];
                    boys[j]=boys[j+1];
                    boys[j+1]=temp;
                }
            }
        }
    }

    void DichotomySort(Boy[] boys)
    {
        for(int i=0;i<boys.length;i++)
        {
            int start, end, mid;
            start=0;
            end=i-1;
            mid=0;
            Boy temp=boys[i];
            while(start<=end)
            {
                mid=(start+end)/2;
                if(boys[mid].GetColorRank()>temp.GetColorRank())
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            for(int j=i-1;j>end;j--)
            {
                boys[j].ReportSwap(j,j+1);
                boys[j+1]=boys[j];
            }
            if(i!=end+1)
            {
                boys[end+1].ReportSwap(i,end+1);
            }
            boys[end+1]=temp;
        }
    }
}
