
public class Creature { // 生物类，包含人物的基本属性，用到外观类
    private int id; // 生物的全局唯一编号，避免重复
    public String name; // 生物的名称，允许重复
    public BioAppearance apperrance; // 生物的外观，包含颜色

    public Creature() {
        name = new String();
        apperrance = new BioAppearance();
    }

    public int getId() {
        return id;
    }

    protected void setId(int _id) {
        id = _id;
    }
}