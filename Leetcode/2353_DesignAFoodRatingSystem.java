class FoodRatings {
    class Food{
        int rating;
        String name, cuisine;
        Food(String name, String cuisine, int rating){
            this.name = name; this.rating = rating; this.cuisine = cuisine;
        }
    }
    HashMap<String, PriorityQueue<Food>> cuisineToPq; // get pq from cuisine name
    HashMap<String, Food> foodNameToObj = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineToPq = new HashMap<>();
        // go thru every food
        for(int i=0; i<foods.length; i++){
            // create a food obj for it
            Food foodObj = new Food(foods[i], cuisines[i], ratings[i]);
            // put a new pq for its cuisine if dne that's sorted via rating, then name if rating is same
            cuisineToPq.putIfAbsent(cuisines[i], new PriorityQueue<>((a,b)->
                b.rating==a.rating ? a.name.compareTo(b.name) : b.rating-a.rating));
            // retrieve the pq of the cuisine, and add the food object to it
            PriorityQueue<Food> pq = cuisineToPq.get(cuisines[i]);
            pq.add(foodObj);
            foodNameToObj.put(foods[i], foodObj);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food foodObj = foodNameToObj.get(food);
        PriorityQueue<Food> pq = cuisineToPq.get(foodObj.cuisine);
        pq.remove(foodObj);
        foodObj.rating = newRating;
        pq.add(foodObj);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToPq.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */