    package shootingspaceship;

    public abstract class GameUnit {
        public enum Team {
            PLAYER,
            ENEMY
        }
        
        protected int hp;
        protected int x,y;
        protected Team team;

        public abstract void takeTurn();

        public boolean isAlive() {
            return hp>0; //hp가 0 이상이면 true반환
        }

        public void takeDamage(int dmg) {
            hp -= dmg;
            if (hp<=0) {
                System.out.println("사망");
            }
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getHp() {
            return hp;
        }

        public Team getTeam() {
            return team;
        }
    }
