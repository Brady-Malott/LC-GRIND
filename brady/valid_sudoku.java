class Solution {
  
    // O(1) time, O(1) space
    public boolean isValidSudoku(char[][] board) {
        // Each number from 1-9 is mapped to a list of three sets:
        // 1) the rows this number has appeared in
        // 2) the columns this number has appeard in
        // 3) the blocks this number has appeared in
        Map<Character, List<Set<Integer>>> numSets = new HashMap<>();
        for (int i = 1; i <= 9; ++i) {
            List<Set<Integer>> list = new ArrayList<>(List.of(new HashSet<>(), new HashSet<>(), new HashSet<>()));
            numSets.put(String.valueOf(i).charAt(0), list);
        }

        // Iterate over every cell and add every filled number to the corresponding three sets, checking if there is a
        // conflict
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                if (board[r][c] == '.') continue;

                // block is (floor(r/3) * 3) + (c/3)
                int block = ((r/3)*3) + (c/3);
                char ch = board[r][c];
                if (!isValid(numSets, ch, r, c, block)) return false;

                numSets.get(ch).get(0).add(r);
                numSets.get(ch).get(1).add(c);
                numSets.get(ch).get(2).add(block);
            }
        }

        return true;
    }

    private boolean isValid(Map<Character, List<Set<Integer>>> numSets, char ch, int r, int c, int block) {
        if (numSets.get(ch).get(0).contains(r)) return false;
        if (numSets.get(ch).get(1).contains(c)) return false;
        if (numSets.get(ch).get(2).contains(block)) return false;
        return true;
    }
}
