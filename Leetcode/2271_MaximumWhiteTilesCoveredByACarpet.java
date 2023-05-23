class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        // it's always better to place a carpet at the beginning of a range. The reason is: if you shift a carpet one tile right, you might cover another white tile, but you definitely uncover the previous white tile.
        int end = 1, start = 0;
        int result = 0, startTileIndex = 0, covered = 0;

        // So, we sort tile ranges, and check how many white tiles we can cover, starting from the beginning of each range.
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        for (int endTileIndex = 0; result < carpetLen && endTileIndex < tiles.length; ) {
            int endWindowIndex = tiles[startTileIndex][start] + carpetLen;
            // When we have space to cover the tiles in tiles[endTileIndex], we add those tiles (all the tiles in tiles[endTileIndex] = tiles[endTileIndex][end] - tiles[endTileIndex][start] + 1) to cover and extend the sliding window (increment the end tile index).
            if (endWindowIndex > tiles[endTileIndex][end]) {
                covered += tiles[endTileIndex][end] - tiles[endTileIndex][start] + 1;
                result = Math.max(result, covered);
                endTileIndex++;
            }
            // otherwise, try to add as much as we can
            else {
                int partial = Math.max(0, endWindowIndex - tiles[endTileIndex][start]);
                result = Math.max(result, covered + partial);
                // the next starting window jumps to the next white tile group. So the next iteration wouldn't have the first group of white tiles covered
                covered -= Math.max(0, tiles[startTileIndex][end] - tiles[startTileIndex][start] + 1);
                startTileIndex++;
            }
        }
        return result;
    }
}