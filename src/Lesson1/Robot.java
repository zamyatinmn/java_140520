package Lesson1;

public class Robot implements Competitor {
    String name;
    int MAX_RUN_DISTANCE = 100000;
    int MAX_JUMP_HEIGHT = 0;
    boolean onDistance;

    public Robot(String name) {
        this.name = name;
        onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " метров.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= MAX_JUMP_HEIGHT) {
            System.out.println(name + " перепрыгнул " + height + " метров.");
        } else {
            System.out.println(name + " не смог перепрыгнуть " + height + " метров.");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(name + " " + (onDistance ? " на дистанции" : " выбыл из соревнований"));
    }
}
