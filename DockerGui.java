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
		int x = 400, y = 400;

		Globals val = new Globals();

		JFrame frame = new JFrame("DockerGUI");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x,y); 
		val.out.setBackground(Color.white);
		val.out.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints c = new GridBagConstraints();
		int w = 1, h = 1;

		val.out.setEditable(false);

		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		c.gridwidth = w*4;
		frame.add(val.out, c);

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

		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = w;
		c.gridheight = h;
		c.weightx = 1;
		c.weighty = 1;
		frame.setSize(x, y-100);


		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*0;
		c.gridx = w*0;
		c.gridy += 1;
		c.gridwidth = w*2;
		frame.add(clear, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*0;
		c.gridx = w*2;
		c.gridy += 1;
		c.gridwidth = w;
		frame.add(ans, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*0;
		c.gridx = w*3;
		c.gridy += 1;
		frame.add(divide, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*1;
		c.gridx = w*0;
		c.gridy += 1;
		frame.add(seven, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*1;
		c.gridx = w*1;
		c.gridy += 1;
		frame.add(eight, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*1;
		c.gridx = w*2;
		c.gridy += 1;
		frame.add(nine, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*1;
		c.gridx = w*3;
		c.gridy += 1;
		frame.add(multiply, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*2;
		c.gridx = w*0;
		c.gridy += 1;
		frame.add(four, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*2;
		c.gridx = w*1;
		c.gridy += 1;
		frame.add(five, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*2;
		c.gridx = w*2;
		c.gridy += 1;
		frame.add(six, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*2;
		c.gridx = w*3;
		c.gridy += 1;
		frame.add(minus, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*3;
		c.gridx = w*0;
		c.gridy += 1;
		frame.add(one, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*3;
		c.gridx = w*1;
		c.gridy += 1;
		frame.add(two, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*3;
		c.gridx = w*2;
		c.gridy += 1;
		frame.add(three, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*3;
		c.gridx = w*3;
		c.gridy += 1;
		frame.add(plus, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*4;
		c.gridx = w*0;
		c.gridy += 1;
		c.gridwidth = w*2;
		frame.add(zero, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*4;
		c.gridx = w*2;
		c.gridy += 1;
		c.gridwidth = w;
		frame.add(decimal, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = h*4;
		c.gridx = w*3;
		c.gridy += 1;
		frame.add(calc, c);

		frame.setVisible(true);
	}

	static class ans implements ActionListener{
		Globals ref;

		public ans(Globals _ref){
			ref = _ref;
		}

		public void actionPerformed(ActionEvent ev) {
			if(ref.clear){
				ref.clear = false;
				ref.toEval = "";
			}
			ref.toEval += ref.ans;
			ref.out.setText(ref.toEval);
		}
	}

	static class clear implements ActionListener{
		Globals ref;

		public clear(Globals _ref){
			ref = _ref;
		}

		public void actionPerformed(ActionEvent ev) {
			if(ref.clear){
				ref.clear = false;
				ref.toEval = "";
			}
			ref.toEval = "";
			ref.out.setText(ref.toEval);
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
			if(ref.clear){
				ref.clear = false;
				ref.toEval = "";
			}
			ref.toEval += val;
			ref.out.setText(ref.toEval);
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
			    ref.ans = ans;
			    ref.out.setText(ref.toEval+" = "+ref.ans);
			    ref.clear = true;
			} catch(Exception e) {
				System.out.println("Error");
			    ref.toEval = "";
			    ref.ans = "";
			    ref.out.setText(ref.toEval);
				return;
			}
		}
	}

	static class Globals {
	   public static String toEval = "";
	   public static String ans = "";

	   public static JTextField out = new JTextField();
	   public static boolean clear = false;
	}
}
