import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

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
		JButton clear = new JButton("C");
		clear.addActionListener(new clear(val));

		JButton ans = new JButton("ANS");
		ans.addActionListener(new ans(val));

		JButton seven = new JButton("7");
		seven.addActionListener(new number_sign(val, "7"));

		JButton eight = new JButton("8");
		eight.addActionListener(new number_sign(val, "8"));

		JButton nine = new JButton("9");
		nine.addActionListener(new number_sign(val, "9"));

		JButton four = new JButton("4");
		four.addActionListener(new number_sign(val, "4"));

		JButton five = new JButton("5");
		five.addActionListener(new number_sign(val, "5"));

		JButton six = new JButton("6");
		six.addActionListener(new number_sign(val, "6"));

		JButton one = new JButton("1");
		one.addActionListener(new number_sign(val, "1"));

		JButton two = new JButton("2");
		two.addActionListener(new number_sign(val, "2"));

		JButton three = new JButton("3");
		three.addActionListener(new number_sign(val, "3"));

		JButton zero = new JButton("0");
		zero.addActionListener(new number_sign(val, "0"));

		JButton decimal = new JButton(".");
		decimal.addActionListener(new number_sign(val, "."));

		JButton blank1 = new JButton("");
		JButton blank2 = new JButton("");

		JButton plus = new JButton("+");
		plus.addActionListener(new number_sign(val, "+"));

		JButton minus = new JButton("-");
		minus.addActionListener(new number_sign(val, "-"));

		JButton multiply = new JButton("*");
		multiply.addActionListener(new number_sign(val, "*"));

		JButton divide = new JButton("/");
		divide.addActionListener(new number_sign(val, "/"));

		JButton calc = new JButton("=");
		calc.addActionListener(new equals(val));

		JPanel action_panel = new JPanel(new GridLayout(5, 4));

		action_panel.add(clear);
		action_panel.add(blank1);
		action_panel.add(ans);
		action_panel.add(divide);
		action_panel.add(seven);
		action_panel.add(eight);
		action_panel.add(nine);
		action_panel.add(multiply);
		action_panel.add(four);
		action_panel.add(five);
		action_panel.add(six);
		action_panel.add(minus);
		action_panel.add(one);
		action_panel.add(two);
		action_panel.add(three);
		action_panel.add(plus);
		action_panel.add(blank2);
		action_panel.add(zero);
		action_panel.add(decimal);
		action_panel.add(calc);

		//layout
		frame.add(consoleShell, BorderLayout.CENTER);
		frame.add(action_panel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	static class ans implements ActionListener{
		Globals ref;

		public ans(Globals _ref){
			ref = _ref;
		}

		public void actionPerformed(ActionEvent ev) {
			ref.toEval += ref.ans;
			System.out.println(ref.toEval);
		}
	}

	static class clear implements ActionListener{
		Globals ref;

		public clear(Globals _ref){
			ref = _ref;
		}

		public void actionPerformed(ActionEvent ev) {
			ref.toEval = "";
		}
	}

	static class number_sign implements ActionListener{
		Globals ref;
		String val;

		public number_sign(Globals _ref, String _val){
			ref = _ref;
			val = _val;
		}

		public void actionPerformed(ActionEvent ev) {
			ref.toEval += val;
			System.out.println(ref.toEval);
		}
	}

	static class equals implements ActionListener{
		Globals ref;

		public equals(Globals _ref){
			ref = _ref;
		}

		public void actionPerformed(ActionEvent ev){
			try{
			    ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
			    String foo = ref.toEval;
			    String ans = engine.eval(foo).toString();
			    System.out.println(foo+" = "+ans);
			    ref.ans = ans;
			    ref.toEval = "";
			} catch(Exception e) {
				System.out.println("Error");
			    ref.toEval = "";
			    ref.ans = "";
				return;
			}
		}
	}

	static class Globals {
	   public static String toEval = "";
	   public static String ans = "";
	}
}
