package shootingspaceship;

public class Character {
    public enum Team {
        PLAYER,
        ENEMY
    }

    protected String roleSet;
    protected int maxHp;
    protected int hp;
    protected int attackPower;
    protected int defensePower;
    protected int speed;
    boolean Invincible; //무적 판정
    int cc; //행동불가 판정
    Team team;

    public Team getTeam() {
        return team;
    }

    public Character() {}
    public Character(String roleSet, int hp, int attackPower, int defensePower, int speed) {
        this.roleSet = roleSet;
        this.maxHp = hp;
        this.hp = hp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.speed = speed;
        this.Invincible = false;
        this.cc = 0;
    }

    public void takeTurn() {
        // 턴 구현하기기
    }
}

class Skill extends Character {
    String name;
    String team;
    public Skill() {}
    public Skill(String name, String team) {
        this.name = name;
        this.team = team;
    }
}

class playerSkill extends Skill {}

class enemySkill extends Skill {}

class attackerSkill extends playerSkill {
    public void attackerSkill1(Character target) {
        System.out.println("딜러 스킬1 사용");
        if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower;
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
    public void attackerSkill2(Character target) {
    	System.out.println("딜러 고출력 레이저 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower*2; //스킬 계수는 임의로 설정바람 (기본2)
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
}

class tankerSkill extends playerSkill {
    public void tankerSkill1(Character target) {
    	System.out.println("탱커 스킬1 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower;
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
    public void tankerSkill2(Character target) {
    	System.out.println("탱커 방어 매트릭스 사용");
    	target.Invincible = true; //1턴 지나면 false로 바뀌게 시스템을 짜주세요.
    }
}

class healerSkill extends playerSkill {
    public void healerSkill1(Character target) {
    	System.out.println("힐러 스킬1 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower;
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
    public void healerSkill2(Character target) {
    	System.out.println("힐러 나노 리페어 사용");
    	int healing = Math.min(maxHp-hp, 1); //회복량은 임의로 설정바람 (기본1)
    	target.hp += healing;
    	System.out.println(target.roleSet + "의 체력을 " + healing + "만큼 회복하였습니다");
    }
}

class supporterSkill extends playerSkill {
    public void supporterSkill1(Character target) {
    	System.out.println("서포터 스킬1 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower;
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
    public void supporterSkill2(Character target) {
    	System.out.println("서포터 전자기 펄스 사용");
    	target.cc = 1; //cc가 0이 아닐때 행동하지 않고 cc가 1씩 감소하도록 시스템 짜주세요. 행동불가 턴수는 임의로 설정바람(기본1)
    }
}

class commonEnemySkill extends enemySkill {
    public void commonEnemySkill1(Character target) {
    	System.out.println("적 스킬1 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower;
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
    public void commonEnemySkill2(Character target) { //다른스킬을 넣고 싶으시면 카톡으로 연락주세요
    	System.out.println("적 스킬2 사용");
    	if(target.Invincible==true) {
			System.out.println("피해를 무효화하였습니다");
			return;
		}
        int skillAttackPower = this.attackPower*2; //스킬 계수는 임의로 설정바람(기본2)
        int finalDamage = skillAttackPower - target.defensePower;
        target.hp -= Math.max(finalDamage, 0);
        System.out.println(target.roleSet + "의 남은 체력은 " + target.hp);
    }
}
