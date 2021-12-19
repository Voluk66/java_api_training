package fr.lernejo.navy_battle;

import java.util.ArrayList;

public interface Boat {
    String type();
    int size();
    void SetBoat(ArrayList<String> p_pos);
    ArrayList<String> getPos();
    void set_Hitbox(String p_pos);
    ArrayList<String> get_Hitbox();
    void update();
    ArrayList<Boolean> Is_alive();
}
