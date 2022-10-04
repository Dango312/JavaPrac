package prac6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Match {
    int MilanScore, MadridScore;
    String lastScorer;
    private JFrame mainFrame;
    JLabel resultLabel;
    JLabel lastScorerLabel;
    JLabel winnerLabel;
    JPanel textPannel;
    JPanel controlPanel;


    public Match(){
        prepareGUI();
    }
    public static void main(String[] args){
        Match match = new Match();
        match.showEventDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Match");
        mainFrame.setSize(170,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        resultLabel = new JLabel("",JLabel.CENTER );
        lastScorerLabel = new JLabel("",JLabel.CENTER);
        winnerLabel = new JLabel("", JLabel.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        textPannel = new JPanel();
        //controlPanel.setLayout(new FlowLayout());

        mainFrame.add(resultLabel);
        mainFrame.add(lastScorerLabel);
        mainFrame.add(winnerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(textPannel);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){

        JButton MilanButton = new JButton("Milan");
        JButton MadridButton = new JButton("Madrid");

        MilanButton.setActionCommand("Milan");
        MadridButton.setActionCommand("Madrid");

        MilanButton.addActionListener(new ButtonClickListener());
        MadridButton.addActionListener(new ButtonClickListener());

        controlPanel.add(MilanButton);
        controlPanel.add(MadridButton);

        textPannel.add(resultLabel);
        textPannel.add(lastScorerLabel);
        textPannel.add(winnerLabel);
        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if( command.equals("Milan"))  {
                MilanScore += 1;
                lastScorer = "Milan";
            } else if( command.equals("Madrid") )  {
                MadridScore += 1;
                lastScorer = "Madrid";
            }
            resultLabel.setText("Result: " + MilanScore + " X " + MadridScore);
            lastScorerLabel.setText("Last Scorer: " + lastScorer);
            if(MadridScore > MilanScore){
                winnerLabel.setText("Winner: " + "Madrid");
            }
            else if(MilanScore > MadridScore){
                winnerLabel.setText("Winner: " + "Milan");
            }
            else{
                winnerLabel.setText("Winner: " + "Draw");

            }
        }
    }
}
