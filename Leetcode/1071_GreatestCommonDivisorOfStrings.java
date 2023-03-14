class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // if str1+str2 != str2 + str1 then they have no gcd
        // for ex str1 = abc, sr2 = ab. abcab != ababc
        // by def of gcd there are no gcd for abcab and ababc as wanted
        // assume on the contrary there is some string that is gcd g of str1, and str2, and str1+str2 != str2+str1. Then g must divide into str1+str2, str2+str1, let g * count = str1+str2. since str1+str2 and str2+str1 have the same length, then it must be that g*count = str2+str1. However if str1+str2 != str2+str1 then g*count != g*count and that's impossible

        if (!(str1+str2).equals(str2+str1)) return "";
        
        // get the gcd len of the str's len
        int gcdVal = gcd(str1.length() , str2.length());
        // the the gcd is simply the substring from start to gcd len
        // consider the case that g is a gcd of str1, and str2
        // then str1 = g + g... + g count1 times
        // str2 is the same count2 times
        // if count1 = count2 then str1 = str2, str1.length = str2.length, so gcd(len1, len2) is str1.length = str2.length as wanted
        // if count != count2 then g.length has length gcd(len1, len2)
        // by def both strs must start with g for g to be a gcd of both
        // since g has len gcd(len1, len2) and both strs start with g, then
        // we can just return the substr of either str from 0 to gcd(len1, len2)
        return str1.substring(0, gcdVal);
    }

    public int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
}