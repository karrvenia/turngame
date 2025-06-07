package shootingspaceship;

import java.util.ArrayList;
import java.util.List;

public class TeamTurnManager {
    private enum TurnPhase {
        PLAYER_TURN,
        ENEMY_TURN
    }

    private TurnPhase currentPhase = TurnPhase.PLAYER_TURN;
    private List<GameUnit> units;
    private int playerIndex = 0;

    public TeamTurnManager(List<GameUnit> units) {
        this.units = units;
    }

    public void startPlayerTurn() {
        playerIndex = 0;
        currentPhase = TurnPhase.PLAYER_TURN;
        System.out.println("[우리 팀 턴 시작]");
    }

    public void playerAct() {
        List<GameUnit> players = new ArrayList<>();
        for (int i = 0; i < units.size(); i++) {
            GameUnit u = units.get(i);
            if (u.getTeam() == GameUnit.Team.PLAYER && u.isAlive()) {
                players.add(u);
            }
        }

        if (playerIndex < players.size()) {
            GameUnit unit = players.get(playerIndex);
            unit.takeTurn(); // 플레이어 한 명의 행동 실행 (공격/스킬 등)
            playerIndex++;
        }

        if (playerIndex >= players.size()) {
            currentPhase = TurnPhase.ENEMY_TURN;
            enemyTurn();
        }
    }

    public void enemyTurn() {
        System.out.println("[적 턴 시작]");

        for (int i = 0; i < units.size(); i++) {
            GameUnit u = units.get(i);
            if (u.getTeam() == GameUnit.Team.ENEMY && u.isAlive()) {
                u.takeTurn(); // 적 유닛 자동 행동
            }
        }

        startPlayerTurn(); // 다음 우리 턴으로 넘어감
    }
}
