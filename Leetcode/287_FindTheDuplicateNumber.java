class Solution {
    //     If there is no duplicate in the array, we can map each indexes to each numbers in this array. In other words, we can have a mapping function f(index) = number
    // For example, let's assume
    // nums = [2,1,3], then the mapping function is 0->2, 1->1, 2->3.
    // If we start from index = 0, we can get a value according to this mapping function, and then we use this value as a new index and, again, we can get the other new value according to this new index. We repeat this process until the index exceeds the array. Actually, by doing so, we can get a sequence. Using the above example again, the sequence we get is 0->2->3. (Because index=3 exceeds the array's size, the sequence terminates!)
    
    // However, if there is duplicate in the array, the mapping function is many-to-one.
    // For example, let's assume
    // nums = [2,1,3,1], then the mapping function is 0->2, {1,3}->1, 2->3. Then the sequence we get definitely has a cycle. 0->2->3->1->1->1->1->1->........ The starting point of this cycle is the duplicate number.
    // We can use Floyd's Tortoise and Hare Algorithm to find the starting point.
    
    // According to Floyd's algorithm, first step, if a cycle does exist, and you advance the tortoise one node each unit of time but the hare two nodes each unit of time, then they will eventually meet. This is what the first while loop does. 
    
    // *Second step, take tortoise or hare to the start point of the list (i.e. let one of the animal be 0) and keep the other one staying at the meeting point. Now, advance both of the animals one node each unit of time, the meeting point is the starting point of the cycle. This is what the second while loop does. 
    
    // They will reach at the point where the loop starts in the linked list
        public int findDuplicate(int[] nums) {
            // same idea as detect cycle in LinkedList
            // map every index to a num, so i: nums[i]
            // let each 'node' in nums have a next pointer such that nums[i].next = nums[nums[i]]
            // need to find i, such that i != j and nums[i] = nums[j]
            // have 2 pointers, slow and fast. There's a cycle iff slow=fast
    
            // initially start with the first element in nums, index 0
            // For ex 1, 3, 4, 2, 2
            // <=> 0 -> 1 -> 3 -> (second last) 2 -> 4 -> (last) 2 -> 4
            // <=> 0 -> 1 -> 3 -> 2 -> 4 
            //                      <-
            // the start of the cycle is 2. 
            int slow = 0, fast = 0;
            // first pass to find an occurence of slow=fast, which is any point in the cycle
            do{
                // iter 0: slow = 0.next = 1, fast = 0.next.next = 1.next = 3
                // iter 1: slow = 1.next = 3, fast = 3.next.next = 4
                // iter 2: slow = 3.next = 2, fast = 4.next.next = 2.next = 4 => slow = fast = 4
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while(slow != fast);
            // in the ex we end at slow = fast = 4
            // second pass to find the start of the cycle
            // reset slow to start from the beginning, fast stays in the cycle
            slow = 0;
            while(slow != fast){
                // iter 0: slow = 0.next = 1, fast = 4.next = 2
                // iter 1: slow = 1.next = 3, fast = 2.next = 4
                // iter 2: slow = 3.next = 2, fast = 4.next = 2 => slow = fast
                // in this case slow reached the first 2, fast reached the last
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }