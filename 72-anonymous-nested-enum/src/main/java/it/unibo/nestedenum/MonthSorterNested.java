package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                Month first = findMonth(arg0);
                Month second = findMonth(arg1);
                return first.nDays - second.nDays;

            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                Month first = findMonth(arg0);
                Month second = findMonth(arg1);
                return first.position - second.position;
            }
            
        };
    }

    private Month findMonth(String s){
        final List<String> possibleResults = new ArrayList<>();
        for (String str : Month.getNames()){
            if(str.startsWith(s.toLowerCase())){
                possibleResults.add(str);
            }
        }
        if(possibleResults.size() > 1 || possibleResults.isEmpty()){
            throw new IllegalArgumentException();
        }

        return Month.getCorrespondantMonth(possibleResults.getFirst());
    }

    public enum Month{
        JANUARY(1, 31),
        FEBRUARY(2, 28),
        MARCH(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUGUST(8, 31),
        SEPTEMBER(9, 30),
        OCTOBER(10, 31),
        NOVEMBER(11, 30),
        DECEMBER(12, 31);

        
        private int position;
        private int nDays;
        
        private Month( int position, int nDays){
            this.position = position;
            this.nDays = nDays;

        }

        public int getPosition() {
            return position;
        }

        public int getnDays() {
            return nDays;
        }

        public static List<String> getNames(){
            return List.of("january","february","march","april","may","june",
            "july","august","september","october","november","december");
        }

        public static Month getCorrespondantMonth(String s){
            if (s.equals("january")){return JANUARY;}
            if (s.equals("february")){return FEBRUARY;}
            if (s.equals("march")){return MARCH;}
            if (s.equals("april")){return APRIL;}
            if (s.equals("may")){return MAY;}
            if (s.equals("june")){return JUNE;}
            if (s.equals("july")){return JULY;}
            if (s.equals("august")){return AUGUST;}
            if (s.equals("september")){return SEPTEMBER;}
            if (s.equals("october")){return OCTOBER;}
            if (s.equals("november")){return NOVEMBER;}
            if (s.equals("december")){return DECEMBER;}
            throw new IllegalArgumentException();
        }

        
    }
}
