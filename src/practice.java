import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class practice extends JFrame {
	JFrame frame = new JFrame ();
	JPanel difficultyPanel = new JPanel ();
	JPanel mainPanel = new JPanel ();
	JPanel answerPanel = new JPanel();
	Random random = new Random ();
	JButton getProblem = new JButton ();
	JComboBox selectDifficulty = new JComboBox ();
	JButton viewScore = new JButton ();
	JTextField answerField = new JTextField ();
	JButton submit = new JButton ();
	JButton viewHighScore = new JButton ();
	JLabel instructions = new JLabel ();
	public qbPractice () {
		setSize (800, 160);
		setTitle ("Quiz Bowl Practice");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout (new BorderLayout());
		buildMainPanel ();
		buildAnswerPanel ();
		add(mainPanel, BorderLayout.NORTH);
		add(answerPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	int score = 0;

	private void buildMainPanel () {
	mainPanel = new JPanel ();
	mainPanel.setBorder(BorderFactory.createTitledBorder("Get tossups! Note that getting one wrong will reset your score."));
	getProblem = new JButton ("Get New Problem");
	viewScore = new JButton ("View Score");
	viewScore.addActionListener(new scoreListener());
	viewHighScore = new JButton ("View HighScore");
	viewHighScore.addActionListener(new highListener());
	mainPanel.add(getProblem);
	getProblem.addActionListener(new problemListener());
	mainPanel.add(viewScore);
	mainPanel.add(viewHighScore);
}
	private void buildAnswerPanel () {
	answerPanel = new JPanel ();
	answerPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Answer"));
	answerField = new JTextField (6);
	submit = new JButton ("submit");
	submit.addActionListener(new submitListener());
	answerPanel.add(answerField);
	answerPanel.add(submit);
}
	int ans = 0;
	int highscore = 0;

	private class problemListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		Random rand = new Random ();
		int randomIndex = rand.nextInt(42);
		if (randomIndex == 0) {
			JOptionPane.showMessageDialog(null, "Jenn randomly chooses a number J from 1, 2, 3, 4, ..., 20. Bela then randomly chooses a number $B$ from $1, 2, 3, 4, ..., 20$ distinct from $J$. The value of $B - J$ is at least $2$ with a probability that can be expressed in the form $\tfrac{m}{n}$, where $m$ and $n$ are relatively prime positive integers. Find $m+n$.");
			ans = 29;
		}
		else if (randomIndex == 1) {
			JOptionPane.showMessageDialog(null, "A moving particle starts at the point $(4,4)$ and moves until it hits one of the coordinate axes for the first time. When the particle is at the point $(a,b)$, it moves at random to one of the points $(a-1,b)$, $(a,b-1)$, or $(a-1,b-1)$, each with probability $\frac{1}{3}$, independently of its previous moves. The probability that it will hit the coordinate axes at $(0,0)$ is $\frac{m}{3^n}$, where $m$ and $n$ are positive integers. Find $m + n$.");
			ans = 252;
		}
		else if (randomIndex == 2) {
			JOptionPane.showMessageDialog(null, "A soccer team has $22$ available players. A fixed set of $11$ players starts the game, while the other $11$ are available as substitutes. During the game, the coach may make as many as $3$ substitutions, where any one of the $11$ players in the game is replaced by one of the substitutes. No player removed from the game may reenter the game, although a substitute entering the game may be replaced later. No two substitutions can happen at the same time. The players involved and the order of the substitutions matter. Let $n$ be the number of ways the coach can make substitutions during the game (including the possibility of making no substitutions). Find the remainder when $n$ is divided by $1000$.");
			ans = 122;
		}
		else if (randomIndex == 3) {
			JOptionPane.showMessageDialog(null, "Lily pads 1,2,3... lie in a row on a pond. A frog makes a sequence of jumps starting on pad $1$. From any pad $k$ the frog jumps to either pad $k+1$ or pad $k+2$ chosen randomly with probability $\tfrac{1}{2}$ and independently of other jumps. The probability that the frog visits pad $7$ is $\tfrac{p}{q}$, where $p$ and $q$ are relatively prime positive integers. Find $p+q$.");
			ans = 107;
		}


	}
}
	private class submitListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		Random rand = new Random ();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		Color randomColor2 = new Color(b, g, r);
		answerPanel.setBackground(randomColor);
		mainPanel.setBackground(randomColor2);
		if (Integer.parseInt(answerField.getText()) == ans) {
			JOptionPane.showMessageDialog(null, "Correct!");
			score += 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong Answer, Sorry.");
			if (score > highscore) {
				highscore = score;
			}
			score = 0;
			
		}
	}
}
	private class scoreListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JOptionPane.showMessageDialog(null, score);
	}
}
	private class highListener implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JOptionPane.showMessageDialog(null, highscore);
	}
}
	public static void main(String[] args) {
	new practice ();

}

}