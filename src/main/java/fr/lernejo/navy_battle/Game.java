package fr.lernejo.navy_battle;

import java.util.List;

public class Game {
    public final Sea my_sea = new Sea();
    private final Sea enemy_sea = new Sea();
    public final List<Boat> my_boats = List.of( new Porte_Avion(), new Croiseur(), new Contre_Torpilleur(), new Contre_Torpilleur(), new Torpilleur());
    public void init_Game(){
        my_sea.Display();
        enemy_sea.Display();
    }
}
