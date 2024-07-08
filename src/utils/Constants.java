package src.utils;

public class Constants {
    public static class Directions{
        public static final int UP =0;
        public static final int DOWN = 1;
        public static final int LEFT = 2;
        public static final int RIGHT =3;
    }
    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMPING = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HITTED = 5;
        public static final int ATTACK = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int getSprayAmounts(int playerAction) {
            return switch (playerAction) {
                case IDLE -> 5;
                case RUNNING -> 6;
                case JUMPING, ATTACK_JUMP_1, ATTACK, ATTACK_JUMP_2 -> 3;
                case FALLING -> 1;
                case GROUND -> 2;
                case HITTED -> 4;
                default -> 1;
            };
        }
    }


}
