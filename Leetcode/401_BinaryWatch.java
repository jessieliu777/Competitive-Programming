class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++)
            for (int minute = 0; minute < 60; minute++)
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn)
                    times.add(String.format("%d:%02d", hour, minute));

        return times;
    }
}