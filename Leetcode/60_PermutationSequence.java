class Solution {
    //Example :- n=4 ,k=17
                                 /////////STEP 1
//We can have our permutation starting with either 1 or 2 or 3 or 4.
//If first position is occupied by one number then there are three more positions left.
//Then remaining three numbers can be permuted among themselves 3! = 6 sequences.

//if we consider sequences as 0-based index in sorted form              
// 0th block  |0th – 5th permutation will start with 1   | {2,3,4} i.e. 0th{1,2,3,4}, 1st{1,2,4,3}, 2nd{1,3,2,4}, 3rd{1,3,4,2}, 4th{1,4,2,3}, 5th{1,4,3,2}
// 1st block  |6th – 11th permutation will start with 2  | {1,3,4} i.e. 6th{2,1,3,4}, 7th{2,1,4,3}, 8th{2,3,1,4}, 9th{2,3,4,1}, 10th{2,4,1,3}, 11th{2,4,3,1}
// 2nd block  |12th – 17th permutation will start with 3 | {1,2,4} i.e. 12th{3,1,2,4}, 13th{3,1,4,2}, 14th{3,2,1,4}, 15th{3,2,4,1}, 16th{3,4,1,2}, 17th{3,4,2,1}
// 3rd block  |18th – 23rd permutation will start with 4 | {1,2,3} i.e. 18th{4,1,2,3}, 19th{4,1,3,2}, 20th{4,2,1,3}, 21st{4,2,3,1}, 22nd{4,3,1,2}, 23rd{4,3,2,1}

//make K = 17-1 considering 0-based indexing
//Since each of the four blocks illustrated above comprises 6 permutations, therefore the 16th permutation will lie in (16 / 6 ) = 2nd block i.e. 3 ans={3---}
// /and our answer is the (16 % 6) = 4th sequence from the 2nd block.
    
                                  //////////STEP 2
  //Our new search space comprises three elements {1,2,4} where K = 4 
  //If first position is occupied by one number then there are two more positions left.
  //Then remaining two numbers can be permuted among themselves 2! = 2 sequences.

// 0th block  |0th – 1st sequence starts with 1 | {2,4} 
// 1st block  |2nd – 3rd sequence starts with 2 | {1,4}
// 2nd block  |4th – 5th sequence starts with 4 | {1,2}

//(4/2) = 2nd block i.e 4   ans={34--}
//4%2 = 0th sequence from 2nd block

                                     /////////STEP 3
        //Our new search space comprises three elements {1,2} where K = 0
        //If first position is occupied by one number then there are one more positions left.
        //Then remaining one numbers can be permuted among themselves 1! = 1 sequences.
// 0th block |0th sequence starts with 1  | {2} 
// 1st block |1st sequence. starts with 2 | {1}

//(0/1) = 0th block i.e. ans={341}
//0%1 = 0th sequence from 0th block

                                   /////////STEP 4
//only 2 is remaining 
    public String getPermutation(int n, int k) {
        int fact = 1;
        List <Integer> numbers = new ArrayList <> ();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1; // since index start at 0
        int size = numbers.size();
        while (size > 0) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            k = k % fact;
            size--;
            if (size > 0) fact = fact / size;
        }
        return ans.toString();
    }
}