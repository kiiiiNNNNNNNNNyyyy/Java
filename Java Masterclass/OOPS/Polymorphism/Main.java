class Movie {
    private String name;

    Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String plot() {
        return "No plot here!!";
    }

}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "Sharks eats a lot of people!";
    }
}

class IndependenceDay extends Movie {
    IndependenceDay() {
        super("Independence Day");
    }
    
    @Override
    public String plot() {
        return "Aliens attempt to take over planet Earth!";
    }
}

class MazeRunner extends Movie {
    MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {
    StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

class Forgetable extends Movie {
    Forgetable() {
        super("Forgetable");
    }
}

class Main {

    public static Movie randomMovie() {
        int random = (int) (Math.random() * 5) + 1;
        System.out.println("Random number " + random);

        switch (random) {
            case 1: 
                return new Jaws();
            case 2: 
                return new IndependenceDay();
            case 3: 
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5: 
                return new Forgetable();
            default:
                return null;
        }
     }

     public static void main(String[] args) {

        for (int i=1; i<11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie is " + movie.getName());
            System.out.println("Plot: " + movie.plot());
            System.out.println();
        }
    }
}