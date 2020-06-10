package Assets.Codes;

public class Level {

    private Player p;

    public Level(Player p) {
        this.p = p;
    }

    public int changeLevel() {
        int level = 0;
        if (p.getScore() > 49 && p.getScore() < 100) {
            level = 1;
        } else if (p.getScore() > 99 && p.getScore() < 200) {
            level = 2;
        } else if (p.getScore() > 199 && p.getScore() < 300) {
            level = 3;
        } else if (p.getScore() > 299) {
            level = 4;
        }
        return level;
    }

}