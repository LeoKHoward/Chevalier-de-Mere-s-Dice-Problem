package Relax;

public class DiceGame {

    // attempts allowed to roll in each game
    private final int rollAttempts;

    // sixes required in each game
    private final int sixesRequired;

    // number of games to be played
    public static final int NUMBER_OF_GAMES = 1_000_000; // belongs to the class and initialized only once at the start of the execution


    public DiceGame(int rollAttempts, int sixesRequired) {
        this.rollAttempts = rollAttempts;
        this.sixesRequired = sixesRequired;
    }

    /**
     * Regardless of rules, this one method establishes if the player has won in allotted number of throws
     **/
    public boolean isPlayerWinner() {
        for (int attempt = 0; attempt < rollAttempts; attempt++) {
            boolean winningThrow = true; // default result to true unless if you do not win and then set to false

            for (int diceRoll = 0; diceRoll < sixesRequired; diceRoll++) {
                if (Die.throwDie() != 6) {
                    winningThrow = false;
                    break;
                }
            }
            if (winningThrow) {
                return true;
            }
        }
        return false;
    }

    public int getRollAttempts() {
        return rollAttempts;
    }
}
