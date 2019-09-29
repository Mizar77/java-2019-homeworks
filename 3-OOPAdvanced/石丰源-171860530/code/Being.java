//生物
public class Being{
    String name;
    int x;
    int y;
    //目前是瞬移版本，之后可以改成随机走路
    public void move(int destx, int desty){
        x = destx;
        y = desty;
    }
}