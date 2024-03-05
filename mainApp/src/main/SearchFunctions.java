package main;

import main.entryTypes.Enemy;

import java.util.ArrayList;
import java.util.List;

public class SearchFunctions {
    //TODO refactor filterByString function to work with classes
    static List<Integer> filterByName(List<Enemy> list, String query) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }

}
