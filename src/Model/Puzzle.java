package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Puzzle extends Observable implements Runnable{

    private int m_nbColmn;
    private int m_nbRow;
    private int WIDHT = 500;
    private int HEIGHT = 500;
    private ArrayList<Agent> ml_agentsPuzzle;

    public Puzzle(int tailleX, int tailleY){
        m_nbColmn = tailleX;
        m_nbRow = tailleY;
        ml_agentsPuzzle = new ArrayList<>();
    }

    @Override
    public void run() {

    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDHT(){
        return WIDHT;
    }

    public int getNbRow(){
        return m_nbRow;
    }

    public int getNbColmn(){
        return m_nbColmn;
    }

    public void addAgentToPuzzle(Agent agent){ ml_agentsPuzzle.add(agent);}

    public ArrayList<Agent> getl_agentsPuzzle(){
        return ml_agentsPuzzle;
    }
}
