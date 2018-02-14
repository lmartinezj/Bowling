import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        this.game = new Game();
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void anSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.score(), is(16));
    }

    @Test
    public void aStrike() throws Exception {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(17, 0);
        assertThat(game.score(), is(24));
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int times = 1; times <= n; ++times) {
            game.roll(pins);
        }
    }
}
