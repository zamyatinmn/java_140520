package Lesson1;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {
                new Human("Вася"),
                new Cat("Пух"),
                new Robot("r2d2")
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new Treadmill(1000),
                new Wall(3)
        };

        for (Competitor c : competitors) {
            c.info();
        }

        for (Competitor c : competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }

        for (Competitor c : competitors) {
            c.info();
        }

    }
}
