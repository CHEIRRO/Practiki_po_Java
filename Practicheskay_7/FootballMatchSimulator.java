package Practicheskay_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballMatchSimulator {
    private JFrame frame;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;
    private int milanScore = 0;
    private int madridScore = 0;

    public FootballMatchSimulator() {
        frame = new JFrame("Football Match Simulator");
        frame.setLayout(new GridLayout(4, 1));

        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        milanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateResultLabel();
                lastScorerLabel.setText("Last Scorer: AC Milan");
                updateWinnerLabel();
            }
        });

        madridButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateResultLabel();
                lastScorerLabel.setText("Last Scorer: Real Madrid");
                updateWinnerLabel();
            }
        });

        frame.add(resultLabel);
        frame.add(lastScorerLabel);
        frame.add(winnerLabel);
        frame.add(milanButton);
        frame.add(madridButton);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateResultLabel() {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
    }

    private void updateWinnerLabel() {
        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FootballMatchSimulator();
            }
        });
    }
}
