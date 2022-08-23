class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // return the min number of hours required to defeat all opponents
        // simulate the competition
        int ene = initialEnergy;
        int exp = initialExperience;
        int hrs = 0;
        for (int i = 0; i < energy.length; i++){
            int hrsEne = 0;
            int hrsExp = 0;
            if (ene <= energy[i]){
                hrsEne += energy[i] - ene +1;
                ene += hrsEne;
            }
            if (exp <= experience[i]){
                hrsExp += experience[i] - exp +1;
                exp += hrsExp;
            }
            // now it is guarenteed you have the stats to win, so fight
            ene -= energy[i];
            exp += experience[i];
            hrs += hrsEne + hrsExp;
        }
        return hrs;
    }
}