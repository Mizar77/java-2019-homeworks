
class Map{
    int xmin;
    int ymin;
    int xmax;
    int ymax;
    Creature[][]map;
    Map(int xmin,int ymin,int xmax,int ymax){
        map=new Creature[xmax-xmin][ymax-ymin];
        this.xmin=xmin;
        this.ymin=ymin;
        this.xmax=xmax;
        this.ymax=ymax;
    }
    boolean isInmap(int x,int y){
        if(x>=xmin&&x<xmax&&y>=ymin&&y<ymax){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isOccupied(int x,int y){
        if(isInmap(x, y)){
            if(map[x][y]==null){
                return false;
            }   
        }
        return true;
    }
    void printMap(){
        for(int i=xmin;i<xmax;i++){
            for(int j=ymin;j<ymax;j++){
                if(map[i][j]==null)
                    System.out.print(".");
                else
                    System.out.print("x");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}

class Formation{
    int num;//队员数量不包括队长
    Location[]locations;
    int xmin;
    int ymin;
    int xmax;
    int ymax;
    Formation(Location[]locations){
        num=locations.length;
        this.locations=new Location[num];
        for(int i=0;i<num;i++){
            this.locations[i]=locations[i];
            if(locations[i].x<xmin){
                xmin=locations[i].x;
            }
            else if(locations[i].x>xmax){
                xmax=locations[i].x;
            }
            if(locations[i].y<ymin){
                ymin=locations[i].y;
            }
            else if(locations[i].y>ymax){
                ymax=locations[i].y;
            }
        }
    }
    Location getLocation(int i){
        if(i<num){
            return locations[i];
        }
        else{
            return new Location(-1,-1);
        }

    }
}

class Location{
    int x;
    int y;
    Location(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Creature{
    String name;
    int x;
    int y;
    Map map;
    boolean camp;
    Creature(){
        x=-1;
        y=-1;
    }
    Creature(String name,Map map,boolean camp){
        x=-1;
        y=-1;
        this.name=name;//先糊弄上了
        this.map=map;
        this.camp=camp;
    }
    void getLocation(int x,int y){
        if(!map.isOccupied(x,y)){
            moveTo(x,y);
        }
    }
    void moveTo(int x,int y){
        if(map.isInmap(this.x, this.y))
            map.map[this.x][this.y]=null;
        map.map[x][y]=this;
        this.x=x;
        this.y=y;
    }
    void warpTo(Map map){
        this.map.map[x][y]=null;
        map.map[x][y]=this;
        this.map=map;
    }
}

class Member extends Creature{
    Member(String name,Map map,boolean camp){
        x=-1;
        y=-1;
        this.name=name;//先糊弄上了
        this.map=map;
        this.camp=camp;
    }
    Captain captain;
}

class Captain extends Creature{
    int nom;//队员数量不包括自己
    Member[]members;
    Formation formation;//阵型
    boolean inline;
    Captain(String name,Map map,boolean camp,Member[]members,Formation formation){
        x=-1;
        y=-1;
        this.name=name;//先糊弄上了
        this.map=map;
        this.camp=camp;

        this.nom=members.length;
        this.members=members;
        this.formation=formation;
        inline=false;
    }
    void lineUp(){
       if((this.x+formation.xmax<map.xmax&&
       this.x+formation.xmin>=map.xmin&&
       this.y+formation.ymax<map.ymax&&
       this.y+formation.ymin>=map.ymin)){
           for(int i=0;i<nom;i++){
               members[i].getLocation(this.x+formation.getLocation(i).x, this.y+formation.getLocation(i).y);
           }
       }
       inline=true;
    }   
    void disMiss(){
        int i=0;
        while(i<nom){
            int randx=(int)(map.xmin+Math.random()*(map.xmax-map.xmin+1));
            int randy=(int)(map.ymin+Math.random()*(map.ymax-map.ymin+1));
            if(!map.isOccupied(randx, randy)){
                members[i].getLocation(randx,randy);
                i++;
            }
        }
        inline=false;
    } 
    void warpJump(Map map){
        if(map.isOccupied(x, y))
            return;
        for(int i=0;i<nom;i++){
            if(map.isOccupied(members[i].x, members[i].y))
                return;
        }
        warpTo(map);
        for(int i=0;i<nom;i++){
            members[i].warpTo(map);
        }
    }
    void march(int x,int y){
    }
}

public class OOPAdvanced{
    static public void main(String[]args){
        Formation lfor=new Formation(new Location[]{new Location(0,1),new Location(0,-1),new Location(0,2),
            new Location(0,-2),new Location(0,3),new Location(0,-3)});
        Formation vfor=new Formation(new Location[]{new Location(1,1),new Location(1,-1),new Location(2,2),
            new Location(2,-2),new Location(3,3),new Location(3,-3)});
        Formation ofor=new Formation(new Location[]{new Location(1,1),new Location(1,-1),new Location(2,2),
            new Location(2,-2),new Location(3,1),new Location(3,-1)});
        Map hulumap=new Map(0,0,16,16);
        Map yaojmap=new Map(0,0,16,16);
        Map totamap=new Map(0,0,16,16);
        Member wa2=new Member("erwa",hulumap,true);
        Member wa3=new Member("sanwa",hulumap,true);
        Member wa4=new Member("siwa",hulumap,true);
        Member wa5=new Member("wuwa",hulumap,true);
        Member wa6=new Member("liuwa",hulumap,true);
        Member wa7=new Member("qiwa",hulumap,true);
        Member[]hulumember={wa2,wa3,wa4,wa5,wa6,wa7};
        Member[]yaojmember={new Member("louluo",yaojmap,false),new Member("louluo",yaojmap,false),new Member("louluo",yaojmap,false)
            ,new Member("louluo",yaojmap,false),new Member("louluo",yaojmap,false),new Member("louluo",yaojmap,false)};
        Captain wa1=new Captain("dawa", hulumap, true, hulumember, lfor);
        Captain xiezi=new Captain("xiezi",yaojmap,false,yaojmember,vfor);
        for(int i=0;i<6;i++){
            hulumember[i].captain=wa1;
            yaojmember[i].captain=xiezi;
        }
        wa1.getLocation(5, 8);
        wa1.disMiss();
        wa1.lineUp();
        //hulumap.printMap();
        //System.out.println("");
        
        xiezi.getLocation(11,8);
        xiezi.disMiss();
        xiezi.lineUp();
        //yaojmap.printMap();
        //System.out.println("");

        wa1.warpJump(totamap);
        xiezi.warpJump(totamap);
        totamap.printMap();
        System.out.println("");

        Creature yeye=new Creature("yeye",totamap,true);
        Creature shejing=new Creature("shejing",totamap,true);
        yeye.moveTo(3, 8);
        shejing.moveTo(13,8);
        totamap.printMap();
        System.out.println("");
        
        xiezi.warpJump(yaojmap);
        xiezi.formation=ofor;
        xiezi.disMiss();
        xiezi.lineUp();

        xiezi.warpJump(totamap);
        totamap.printMap();
        System.out.println("");

    }      
}