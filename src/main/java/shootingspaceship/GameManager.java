package shootingspaceship;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    protected List<GameUnit> units;
    private static GameManager instance;
    

    private Attacker attacker;
    private Defenser defenser;

    public enum JobList { //static 메소드 대신, 상수들을 그룹으로 묶음
        ATTACKER,
        DEFENSER
    }

    public GameManager() {
        units = new ArrayList<>();
    }

    private static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }

    public void addPlayer(JobList job) {
        switch (job) {
            case ATTACKER:
                attacker = new Attacker(100,500, 0, 800, 300, 500);
                units.add(attacker);
                break;
            case DEFENSER:
                defenser = new Defenser(200, 500, 0, 800, 200);
                units.add(defenser);
                break;
        }
    }

    public void addEnemy(Enemy enemy) {
        units.add(enemy);
    }

    public List<GameUnit> getUnits() {
        return units;
    }

    public void update() {
        //추후추가
    }

    public GameUnit selectAlly() {
        for (GameUnit unit : units) {
            if (unit.getTeam() == GameUnit.Team.PLAYER && unit.isAlive()) {
                return unit;
            }
        }
        return null;
    }
}
