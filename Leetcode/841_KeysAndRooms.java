class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>(); // the rooms to be visited via LIFO
        HashSet<Integer> unlocked = new HashSet<Integer>(); // the rooms already visited
        // start visiting 0th room
        stack.add(0);
        unlocked.add(0);
        while (!stack.isEmpty()) {
            // the cur room is the most recent room in the stack
            int curRoom = stack.pop();
            // get all the keys of cur room, visit the respected locked rooms which should be unlocked via keys
            for (int unlockedRoom : rooms.get(curRoom))
                // if the unlocked room is not already unlocked
                if (!unlocked.contains(unlockedRoom)) {
                    // add it to the rooms to be visited, also add it to the unlocked rooms
                    stack.add(unlockedRoom);
                    unlocked.add(unlockedRoom);
                    // if every room gets unlocked then we can visit every room
                    if (rooms.size() == unlocked.size()) return true;
                }
        }
        return false;
    }
}