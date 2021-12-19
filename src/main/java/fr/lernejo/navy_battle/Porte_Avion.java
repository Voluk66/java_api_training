package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Porte_Avion implements Boat{
    private  final ArrayList<String> pos = new ArrayList<>();
    private  final ArrayList<String> hitbox = new ArrayList<>();
    private  final ArrayList<Boolean> still_here =new ArrayList<Boolean>(List.of(true));
    @Override
    public String type() {
        return "Porte Avion";
    }

    @Override
    public int size() {
        return 5;
    }

    @Override
    public void SetBoat(ArrayList<String> p_pos) {
        this.pos.addAll(p_pos);
    }

    @Override
    public ArrayList<String> getPos() {
        return this.pos;
    }

    @Override
    public void set_Hitbox(String pos) {
        this.hitbox.add(pos);
    }

    @Override
    public ArrayList<String> get_Hitbox() {
        return this.hitbox;
    }

    @Override
    public void update() {
        this.still_here.set(0,false);
    }

    @Override
    public ArrayList<Boolean> Is_alive() {
        return this.still_here;
    }
}
