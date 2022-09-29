class Solution {
    public int findParent(int x, int[] parent) {
        return parent[x] == x ? x : findParent(parent[x], parent);
    }
    
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26]; // map index to letter
        for (int i = 0; i < 25; i++){
            parent[i] = i;
        }
        for (String equation: equations){
            // if 2 chars are equal
            if (equation.charAt(1) == '='){
                // set the parent of the 2nd char to be the first char
                parent[findParent(equation.charAt(3) - 'a', parent)] = findParent(equation.charAt(0)- 'a', parent);
            }
        }
        for (String equation: equations){
            // if 2 chars are equal
            if (equation.charAt(1) == '!'){
                // if their parents are equal then that can't be satisfied since they shouldn't be equal
                if (findParent(equation.charAt(0) - 'a', parent) == findParent(equation.charAt(3) - 'a', parent)) return false;
            }
        }
        return true;
    }
}