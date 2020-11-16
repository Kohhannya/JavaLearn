package Homework9;

import Homework2.*;

public interface Visitor {
    String visitTablet(Tablet computer);

    String visitNotebook(Notebook computer);

    String visitNetbook(Netbook computer);

    String visitPersonalComputer(PersonalComputer computer);

    String visitNettop(Nettop computer);

    String visitMonoblock(Monoblock computer);

    String visitServer(Server computer);
}

