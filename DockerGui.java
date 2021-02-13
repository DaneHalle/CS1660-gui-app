import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

public class DockerGui {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndRunGUI();
			}
		});
	}

	public static void createAndRunGUI(){

		Globals val = new Globals();

		JFrame frame = new JFrame("DockerGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);

		// console output
		JTextArea console = new JTextArea();
		console.setEditable(false);
		PrintStream printStream = new PrintStream(new GuiConsole(console));
		System.setOut(printStream);
		System.setErr(printStream);

		JScrollPane consoleShell = new JScrollPane(console);

		// USER ACTIONS
		// get a user token
		JButton add_ten_button = new JButton("ADD 10");
		add_ten_button.addActionListener(new compAS(val, 10));


		JButton add_five_button = new JButton("ADD 5");
		add_five_button.addActionListener(new compAS(val, 5));


		JButton add_one_button = new JButton("ADD 1");
		add_one_button.addActionListener(new compAS(val, 1));


		JButton sub_one_button = new JButton("SUBTRACT 1");
		sub_one_button.addActionListener(new compAS(val, -1));


		JButton sub_five_button = new JButton("SUBTRACT 5");
		sub_five_button.addActionListener(new compAS(val, -5));


		JButton sub_ten_button = new JButton("SUBTRACT 10");
		sub_ten_button.addActionListener(new compAS(val, -10));


		JButton mul_ten_button = new JButton("MULTIPLY 10");
		mul_ten_button.addActionListener(new compM(val, 10));


		JButton mul_five_button = new JButton("MULTIPLY 5");
		mul_five_button.addActionListener(new compM(val, 5));


		JButton mul_one_button = new JButton("MULTIPLY 1");
		mul_one_button.addActionListener(new compM(val, 1));


		JButton div_ten_button = new JButton("DIVIDE 10");
		div_ten_button.addActionListener(new compD(val, 10));


		JButton div_five_button = new JButton("DIVIDE 5");
		div_five_button.addActionListener(new compD(val, 5));


		JButton div_one_button = new JButton("DIVIDE 1");
		div_one_button.addActionListener(new compD(val, 1));

		JPanel action_panel = new JPanel(new GridLayout(3,4));
		// action_panel.setLayout(new BoxLayout(action_panel, BoxLayout.Y_AXIS));
		action_panel.add(add_ten_button);
		action_panel.add(sub_ten_button);
		action_panel.add(mul_ten_button);
		action_panel.add(div_ten_button);
		action_panel.add(add_five_button);
		action_panel.add(sub_five_button);
		action_panel.add(mul_five_button);
		action_panel.add(div_five_button);
		action_panel.add(add_one_button);
		action_panel.add(sub_one_button);
		action_panel.add(mul_one_button);
		action_panel.add(div_one_button);

		//layout
		frame.add(consoleShell, BorderLayout.CENTER);
		frame.add(action_panel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	static class compAS implements ActionListener{
		Globals ref;
		double toCompAS;

		public compAS(Globals val, double _toCompAS){
			ref = val;
			toCompAS = _toCompAS;
		}

		public void actionPerformed(ActionEvent ev) {
			if(toCompAS>0){
				System.out.print(ref.curVal+"+"+toCompAS+" = ");
			} else {
				System.out.print(ref.curVal+""+toCompAS+" = ");
			}
			ref.curVal += toCompAS;
			System.out.println(ref.curVal);
		}
	}

	static class compM implements ActionListener{
		Globals ref;
		double toCompM;

		public compM(Globals val, double _toCompM){
			ref = val;
			toCompM = _toCompM;
		}

		public void actionPerformed(ActionEvent ev) {
			System.out.print(ref.curVal+"*"+toCompM+" = ");
			ref.curVal *= toCompM;
			System.out.println(ref.curVal);
		}
	}

	static class compD implements ActionListener{
		Globals ref;
		double toCompD;

		public compD(Globals val, double _toCompD){
			ref = val;
			toCompD = _toCompD;
		}

		public void actionPerformed(ActionEvent ev) {
			System.out.print(ref.curVal+"/"+toCompD+" = ");
			ref.curVal /= toCompD;
			System.out.println(ref.curVal);
		}
	}

	static class Globals {
	   public static double curVal = 0;
	}
}
