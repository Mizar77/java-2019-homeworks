package org.nju.edu.Test;

import org.nju.edu.Test.ReadDoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        GourdManQueue gourdMans = new GourdManQueue();
        gourdMans.AllSayName();
        gourdMans.RandomLineUP();
        gourdMans.AllSayName();
        gourdMans.SortByName();
        gourdMans.AllSayName();
        gourdMans.RandomLineUP();
        gourdMans.AllSayName();
        gourdMans.SortByColor();
        gourdMans.AllSayColor();
    }
}
