package uebungenProg2.uebungEigen;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ereignisbehandlung extends JFrame implements ActionListener
{

	JLabel unten; // muss global deklariet werden damit wir übder die actionPerformed Zugriff drauf haben
	Integer anzKlicks = 0;
	
    public Ereignisbehandlung()
    {
        super();
        setTitle("Ereignisbehandlung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = init();

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        setSize(200,150);
        setVisible(true);
    }

    private JPanel init()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        JPanel oben = new JPanel();
        JButton minus = new JButton("-");
        JButton plus = new JButton("+");
        minus.addActionListener(this);
        plus.addActionListener(this);
        oben.add(minus);
        oben.add(plus);
        
        
        

        this.unten = new JLabel(this.anzKlicks.toString()); // wurde 3 mal geklickt wird also eine 3 angezeigt als Stringtext
        unten.setFont(new Font("Verdana", Font.BOLD, 24));
        unten.setHorizontalAlignment(JLabel.CENTER);

        panel.add(oben, BorderLayout.NORTH);
        panel.add(unten, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) 
    {
        new Ereignisbehandlung();
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object quelle = e.getSource();    // welche Komponente hat das Actionevent ausglöst, d.h. welcher Button wurde geklickt?
		if(quelle instanceof JButton) 
		{
			JButton button = (JButton) quelle;
			if(button.getText().equals("+")) 
			{
				this.anzKlicks++;
			}
			else if(button.getText().equals("-"))
			{
				this.anzKlicks--;
			}
		}
		this.unten.setText(this.anzKlicks.toString());
	}

}


