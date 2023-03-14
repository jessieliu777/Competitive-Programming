class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // For example, for plantTime = [1,4,3,2] and growTime = [2,6,1,8], it produces the following output:
        // Let . = one day of plany time, ^ = one day of grow time
        // sort by grow time desc -> plantTime = [2,4,1,3], growTime = [8, 6, 2, 1]
        // ..^^^^^^^^ [2, 8] -> earliestDay = max(0, 2 + 8) = max(0, 10) = 10
        //   ....^^^^^^ [4, 6] -> earliestDay = max(10, (2 + 4) + 6) = max(10, 12) = 12 Visually we know this is the final answer, but let's see the rest if we continue to calculate:
        //       .^^ [1, 2] -> earliestDay = max(12, (2 + 4 + 1) + 2) = max(12, 9) = 12
        //        ...^ [3, 1] -> earliestDay = max(12, (2 + 4 + 1 + 3) + 1) = max(12, 11) = 12
        int n = growTime.length;
        // get a list of indices that works for both arrs
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) indices.add(i);
        // sort indices in reverse order according to grow time
        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        int result = 0;
        int sumPlantTime = 0;
        // go thru everything in indicies (it's already sorted by reverse grow time)
        for (int i = 0; i < n; i++) {
            int index = indices.get(i);
            int time = sumPlantTime + plantTime[index] + growTime[index];
            result = Math.max(result, time);
            sumPlantTime += plantTime[index];
        }
        return result;
    }
}