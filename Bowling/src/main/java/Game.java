public class Game {
    public static final int TOTAL_FRAMES = 10;
    public static final int ALL_PINS = 10;
    private int[] rolls;
    private int current;

    public Game() {
        this.rolls = new int[21];
        this.current = 0;
    }

    public void roll(int pins) {
        rolls[current] = pins;
        ++current;
    }

    public int score(){
        int score = 0;
        int rollIndex = 0;
        for (int frame = 1; frame <= TOTAL_FRAMES; ++frame) {
            if (isStrike(rollIndex)) {
                score += ALL_PINS + strikeBonus(rollIndex);
                ++rollIndex;
            } else if (isSpare(rollIndex)) {
                score += ALL_PINS + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += frameScore(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == ALL_PINS;
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private boolean isSpare(int rollIndex) {
        return frameScore(rollIndex) == ALL_PINS;
    }

    private int frameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
