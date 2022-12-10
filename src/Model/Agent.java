package Model;

import java.awt.*;

public class Agent extends Thread{

    private int m_positionActuelle;//sa position sur le puzzle (la zone)
    private int m_targetPosition; //la position sur laquelle il veut se déplacer
    private Color m_color;

    public Agent(int positionActuelle, int targetPosition, Color color){
        m_positionActuelle = positionActuelle;
        m_targetPosition = targetPosition;
        m_color = color;
    }

    public Color getColor(){
        return m_color;
    }

    public int getPositionActuelle(){
        return m_positionActuelle;
    }

    public int getTargetPosition(){
        return m_targetPosition;
    }
}
