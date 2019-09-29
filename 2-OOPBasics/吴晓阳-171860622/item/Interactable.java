package item;

import figure.Figure;

/*
* 可以与figure进行互动的item
 */
public interface Interactable {
    /*
    * 与figure进行互动
    * /return 如果互动后会item消失，则返回false， 否则返回true
     */
    boolean interact(Figure figure);
}
