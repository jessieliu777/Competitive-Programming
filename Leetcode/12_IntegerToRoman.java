class Solution {
    public String intToRoman(int num) {
        StringBuffer s = new StringBuffer();
        while(num>0)
        {
            if(num>=1000)
            {
                num=num-1000;
                s.append('M');
            }
            else if(num>=900)
            {
                num=num-900;

                s.append("CM");
            }
            else if(num>=500)
            {
                num=num-500;

                s.append('D');
            }
            else if(num>=400)
            {
                num=num-400;

                s.append("CD");
            }
            else if(num>=100)
            {

                s.append("C");
                num=num-100;
            }
            else if(num>=90)
            {
                num=num-90;
                s.append("XC");
            }
            else if(num>=50)
            {
                num=num-50;

                s.append("L");
            }
            else if(num>=40)
            {
                num=num-40;

                s.append("XL");
            }
            else if(num>=10)
            {
                num=num-10;

                s.append("X");
            }
            else if(num>=9)
            {
                num=num-9;

                s.append("IX");
            }
            else if(num>=5)
            {
                num=num-5;

                s.append("V");
            }
            else if(num>=4)
            {
                num=num-4;

                s.append("IV");
            }
            else if(num>=1)
            {
                num=num-1;

                s.append("I");
            }
        }
        return s.toString();
    }
}