package main;

import main.entryTypes.Checkable;
import main.entryTypes.Enemy;
import main.entryTypes.EsperData;

import java.util.ArrayList;
import java.util.List;

public class SearchFunctions {
    //TODO refactor filterByString function to work with classes
    static List<Integer> filterByName(List<Enemy> list, String query) {
        List<Integer> indexes = new ArrayList<>();
//        Collections.sort(rareGameList, new main.entryTypes.SortByName());
        for (int i = 0; i < list.size(); i++){

            if (list.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                indexes.add(i);
            }
        }
        return indexes;
    }

    List<Checkable> filterByLocation(String searched) {
        List<Checkable> results = new ArrayList<>();

        for (Enemy esper : EsperData.espers) {
            if (esper.getLocationMain().toLowerCase().contains( searched.toLowerCase() )) {
                results.add(esper);
            }
        }

        return results;
    }

    String searchQuery(String category){
        System.out.print(STR."What \{category} are you looking for: ");
        return App.input();
    }
}
