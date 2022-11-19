class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        List<String> heading = new ArrayList<>();
        heading.add("Table");
        Map<Integer, Map<String,Integer>> map = new TreeMap<>();
        Set<String> foodItems = new TreeSet<>();
        for (List<String> order: orders){
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            
            foodItems.add(foodItem);
            // if table number/food item isn't already in map then add it to map
            map.putIfAbsent(tableNumber, new TreeMap<>());
            map.get(tableNumber).merge(foodItem, 1, Integer::sum);
        }
        heading.addAll(foodItems);
        
        // add the heading
        result.add(heading);
        // add the rest of the table
        for(int key:map.keySet()){
            Map<String,Integer> m = map.get(key);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(key));
            for(String foodItem:foodItems){
                if(m.containsKey(foodItem)){
                    row.add(Integer.toString(m.get(foodItem)));
                }
                else row.add("0");
            }
            result.add(row);
        }
        return result;
    }
}