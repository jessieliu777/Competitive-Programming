class Solution {
    public long dividePlayers(int[] skill) {
        // sum up all the skills
        Arrays.sort(skill);
        int sum_per_pair = skill[0] + skill[skill.length-1];
        long sum_chemistry = 0;
        for (int i = 0; i < skill.length/2; i++){
            int first = skill[i];
            int second = skill[skill.length-1-i];
            if (first+second != sum_per_pair) return -1;
            sum_chemistry += first * second;
        }
        return sum_chemistry;
    }
}