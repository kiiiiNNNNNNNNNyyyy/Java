class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here!!";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A Shark eats a lot of people...!!";
    }
}

class Transformers extends Movie {
    public Transformers() {
        super("Transformers");
    }

    @Override
    public String plot() {
        return "Big ass robots...";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner!");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze...";
    }
}

class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over universe...";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable!!");
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i=0; i<11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + " : " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
        }

    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random Number generated was : " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new Transformers();
            case 3:
                return new StarWars();
            case 4:
                return new MazeRunner();
            case 5:
                return new Forgettable();
            default:
                return null;
        }
    }
}
