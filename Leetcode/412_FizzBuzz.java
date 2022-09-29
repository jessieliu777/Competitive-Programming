class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i<= n; i++){
            StringBuilder str = new StringBuilder();
            if (i % 3 == 0){
                str.append("Fizz");
            }
            if (i % 5 == 0){
                str.append("Buzz");
            }
            if (str.length() == 0){
                str.append(i);
            }
            result.add(str.toString());
        }
        return result;
    }
}