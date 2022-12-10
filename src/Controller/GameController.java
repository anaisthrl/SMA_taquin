package Controller;

import Model.Agent;
import Model.Puzzle;

import java.awt.*;
import java.util.*;

public class GameController extends Canvas implements Observer {

    private Puzzle m_puzzle;
    private Thread m_thread;

    public GameController(int rows, int columns){
        m_puzzle = new Puzzle(rows, columns);
        m_puzzle.addObserver(this);
        m_thread = new Thread(m_puzzle);
        m_thread.start();
        AddAgentToPuzzle(rows,columns);
        //affichage du takin en console
        System.out.println("Takin initial :\n");
        for(Agent agent : m_puzzle.getl_agentsPuzzle()) System.out.print(agent.toString() + ' ' + agent.getPositionActuelle());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void paint(Graphics g){
        //dessin des zones
        int heightOfRow = m_puzzle.getHEIGHT() / m_puzzle.getNbColmn();
        for(int i = 0; i<m_puzzle.getNbRow(); i++){
            g.drawLine(0,i*heightOfRow, m_puzzle.getWIDHT(), i*heightOfRow);
        }
        int widthOfRow = m_puzzle.getWIDHT() / m_puzzle.getNbRow();
        for(int i= 0; i<m_puzzle.getNbColmn();i++){
            g.drawLine(i*widthOfRow,0,i*widthOfRow,m_puzzle.getHEIGHT());
        }

        //dessin du rectangle autour du puzzle
        g.drawRect(0,0,500,500);

        //dessin des agents dans les zones du puzzle
        for(Agent agent : m_puzzle.getl_agentsPuzzle()){
            g.setColor(agent.getColor());
            if(agent.getPositionActuelle() <5){
                g.fillOval(agent.getPositionActuelle()*100,0, 100, 100);
            }else if(agent.getPositionActuelle() >= 5 && agent.getPositionActuelle()<10){
                g.fillOval((agent.getPositionActuelle()%5)*100,100, 100, 100);
            }else if(agent.getPositionActuelle() >= 10 && agent.getPositionActuelle()<15){
                g.fillOval((agent.getPositionActuelle()%10)*100,200, 100, 100);
            }else if(agent.getPositionActuelle() >= 15 && agent.getPositionActuelle()<20){
                g.fillOval((agent.getPositionActuelle()%15)*100,300, 100, 100);
            }else if(agent.getPositionActuelle() >= 20 && agent.getPositionActuelle()<25){
                g.fillOval((agent.getPositionActuelle()%20)*100,400, 100, 100);
            }
        }

        //dessin de la zone d'arrivee des agents
        for(Agent agent : m_puzzle.getl_agentsPuzzle()){
            g.setColor(agent.getColor());
            if(agent.getTargetPosition() <5){
                g.fillRect(agent.getTargetPosition()*100,0, 100, 100);
            }else if(agent.getTargetPosition() >= 5 && agent.getTargetPosition()<10){
                g.fillRect((agent.getTargetPosition()%5)*100,100, 100, 100);
            }else if(agent.getTargetPosition() >= 10 && agent.getTargetPosition()<15){
                g.fillRect((agent.getTargetPosition()%10)*100,200, 100, 100);
            }else if(agent.getTargetPosition() >= 15 && agent.getTargetPosition()<20){
                g.fillRect((agent.getTargetPosition()%15)*100,300, 100, 100);
            }else if(agent.getTargetPosition() >= 20 && agent.getTargetPosition()<25){
                g.fillRect((agent.getTargetPosition()%20)*100,400, 100, 100);
            }
        }
    }


    //placement aléatoire des agents (4) dans le puzzle
    public void AddAgentToPuzzle(int rows, int columns){

        ArrayList<Integer>l_caseDejaChoisies = new ArrayList<>();
        int choixAleatoireDeLaCaseInitiale = (int) (Math.random() * (rows*columns));
        int choixAleatoireDeLaCaseArrivee = (int) (Math.random() * (rows*columns));

        for(int j=0; j<4; j++) {

            while(l_caseDejaChoisies.contains(choixAleatoireDeLaCaseInitiale))
                choixAleatoireDeLaCaseInitiale = (int) (Math.random() * (rows*columns));
            l_caseDejaChoisies.add(choixAleatoireDeLaCaseInitiale);

            while(l_caseDejaChoisies.contains(choixAleatoireDeLaCaseArrivee))
                choixAleatoireDeLaCaseArrivee = (int) (Math.random() * (rows*columns));
            l_caseDejaChoisies.add(choixAleatoireDeLaCaseArrivee);

            Agent agent = new Agent(choixAleatoireDeLaCaseInitiale, choixAleatoireDeLaCaseArrivee, getRandomColor());
            m_puzzle.addAgentToPuzzle(agent);
        }
    }

    //générateur aléatoire de couleur
    public Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}
