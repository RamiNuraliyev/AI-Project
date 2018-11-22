package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyView extends Observable implements View{

	//JTextArea planText=new JTextArea("plan content");
	JTextArea planText=new JTextArea(10,20);
	JButton[][] squers;
	JPanel container;
	public MyView(){

	}

	public void udateView(Object arg){

		planText.setText((String) arg);

	}
	@Override
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});


	}

	public class ButtonAction extends JPanel implements ActionListener{
		String level=null;
		String steps=null;
		Scanner scan;
		public ButtonAction() {
			JButton easy =new JButton("easy");
			JButton medium =new JButton("medium");
			JButton hard =new JButton("hard");
			JButton extreme =new JButton("extreme");
			JButton solve =new JButton("solve");
			JButton step =new JButton("step");
			JButton allSteps =new JButton("allSteps");
			this.add(easy);
			this.add(medium);
			this.add(hard);
			this.add(extreme);
			this.add(solve);
			this.add(step);
			this.add(allSteps);
			easy.setActionCommand("easy");
			medium.setActionCommand("medium");
			hard.setActionCommand("hard");
			extreme.setActionCommand("extreme");
			solve.setActionCommand("solve");
			step.setActionCommand("step");
			allSteps.setActionCommand("all");
			easy.addActionListener(this);
			medium.addActionListener(this);
			hard.addActionListener(this);
			extreme.addActionListener(this);
			solve.addActionListener(this);
			allSteps.addActionListener(this);
			step.addActionListener(this);

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("solve"))
			{
				setChanged();
				notifyObservers(level);
				level=null;
			}
			else 
				if(e.getActionCommand().equals("all"))
				{
					if(planText!=null)
					{
						String plan=planText.getText();
						Scanner scanAll =new Scanner(plan);
						while(scanAll.hasNext())
						{
							actionToView(scanAll.nextLine());
						}
						scanAll.close();
					}
				}
				else
					if(e.getActionCommand().equals("step"))
					{
						if(!planText.getText().equals("plan content"))
						{
							if(steps==null)
							{
								steps=planText.getText();
								scan= new Scanner(steps);
							}
							String act=scan.nextLine();
							if(act.contains("Time"))
							{
								steps=null;
								scan.close();
							}
							else
								actionToView(act);
						}
					}
					else
					{ 
						level=e.getActionCommand();
						setboard(level);
					}
		}
	}

	protected void createAndShowGUI() {
		JFrame frame = new JFrame("UnblockMe-Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		container =new JPanel(new BorderLayout()); 
		//buttons
		container.add(new ButtonAction(),BorderLayout.PAGE_START);
		//plan text
		JPanel plan =new JPanel();
		plan.setLayout(new BoxLayout(plan,BoxLayout.PAGE_AXIS));
		JScrollPane scroll= new JScrollPane(planText);
		planText.setFont(new Font("Dialog-Bold", Font.BOLD, 16));
		planText.setText("plan content");
		frame.add(scroll);
		JLabel label =new JLabel("               ~Plan~ ");
		label.setFont(new Font("Dialog-Bold", Font.BOLD, 25));
		planText.setBackground(new Color(0,255,127));
		planText.setEditable(false);
		plan.add(label);
		plan.add(scroll);
		container.add(plan,BorderLayout.EAST);

		//board
		JPanel board =new JPanel(new GridLayout(6, 6));
		squers = new JButton[6][6];
		for(int i=0;i<6;i++)
			for (int j = 0; j < 6; j++) {
				squers[i][j]=new JButton();
				squers[i][j].setBackground(new Color(205,133,63));
				board.add(squers[i][j]);
			}

		container.add(board);
		container.setPreferredSize(new Dimension(900,500));
		frame.add(container);
		frame.pack();
		frame.setVisible(true);
	}


	public void setboard(String level) {
		clearBoard();
		int k=1;
		Color brown=new Color(139,69,19);
		if(level.equals("easy")) {
			squers[0][1].setBackground(brown);
			squers[1][1].setBackground(brown);
			squers[1][1].setText(Integer.toString(k));
			squers[0][1].setText(Integer.toString(k++));
			
			squers[2][2].setBackground(brown);
			squers[3][2].setBackground(brown);
			squers[2][2].setText(Integer.toString(k));
			squers[3][2].setText(Integer.toString(k++));
			
			squers[1][4].setBackground(brown);
			squers[2][4].setBackground(brown);
			squers[1][4].setText(Integer.toString(k));
			squers[2][4].setText(Integer.toString(k++));
			
			squers[4][0].setBackground(brown);
			squers[5][0].setBackground(brown);
			squers[4][0].setText(Integer.toString(k));
			squers[5][0].setText(Integer.toString(k++));
			
			squers[4][3].setBackground(brown);
			squers[4][4].setBackground(brown);
			squers[4][5].setBackground(brown);
			squers[4][3].setText(Integer.toString(k));
			squers[4][4].setText(Integer.toString(k));
			squers[4][5].setText(Integer.toString(k));
			
			squers[2][0].setBackground(Color.red);
			squers[2][1].setBackground(Color.red);
		}
		else
			if(level.equals("medium")) {
				squers[0][0].setBackground(brown);
				squers[0][1].setBackground(brown);
				squers[0][0].setText(Integer.toString(k));
				squers[0][1].setText(Integer.toString(k++));
				
				squers[1][0].setBackground(brown);
				squers[1][1].setBackground(brown);
				squers[1][2].setBackground(brown);
				squers[1][0].setText(Integer.toString(k));
				squers[1][1].setText(Integer.toString(k));
				squers[1][2].setText(Integer.toString(k++));
				
				squers[2][0].setBackground(brown);
				squers[3][0].setBackground(brown);
				squers[2][0].setText(Integer.toString(k));
				squers[3][0].setText(Integer.toString(k++));
				
				squers[2][1].setBackground(brown);
				squers[3][1].setBackground(brown);
				squers[2][1].setText(Integer.toString(k));
				squers[3][1].setText(Integer.toString(k++));
				
				squers[4][1].setBackground(brown);
				squers[5][1].setBackground(brown);
				squers[4][1].setText(Integer.toString(k));
				squers[5][1].setText(Integer.toString(k++));
				
				squers[1][4].setBackground(brown);
				squers[2][4].setBackground(brown);
				squers[1][4].setText(Integer.toString(k));
				squers[2][4].setText(Integer.toString(k++));
				
				squers[3][4].setBackground(brown);
				squers[3][5].setBackground(brown);
				squers[3][4].setText(Integer.toString(k));
				squers[3][5].setText(Integer.toString(k++));
				
				squers[4][4].setBackground(brown);
				squers[4][5].setBackground(brown);
				squers[4][4].setText(Integer.toString(k));
				squers[4][5].setText(Integer.toString(k++));
				
				squers[0][5].setBackground(brown);
				squers[1][5].setBackground(brown);
				squers[2][5].setBackground(brown);
				squers[0][5].setText(Integer.toString(k));
				squers[1][5].setText(Integer.toString(k));
				squers[2][5].setText(Integer.toString(k));
				
				squers[2][2].setBackground(Color.red);
				squers[2][3].setBackground(Color.red);
			}
			else
				if(level.equals("hard")) {
					squers[0][0].setBackground(brown);
					squers[1][0].setBackground(brown);
					squers[0][0].setText(Integer.toString(k));
					squers[1][0].setText(Integer.toString(k++));
					
					squers[0][3].setBackground(brown);
					squers[0][4].setBackground(brown);
					squers[0][3].setText(Integer.toString(k));
					squers[0][4].setText(Integer.toString(k++));
					
					squers[1][3].setBackground(brown);
					squers[1][4].setBackground(brown);
					squers[1][3].setText(Integer.toString(k));
					squers[1][4].setText(Integer.toString(k++));
					
					squers[0][5].setBackground(brown);
					squers[1][5].setBackground(brown);
					squers[0][5].setText(Integer.toString(k));
					squers[1][5].setText(Integer.toString(k++));
					
					squers[2][4].setBackground(brown);
					squers[3][4].setBackground(brown);
					squers[2][4].setText(Integer.toString(k));
					squers[3][4].setText(Integer.toString(k++));
					
					squers[2][5].setBackground(brown);
					squers[3][5].setBackground(brown);
					squers[2][5].setText(Integer.toString(k));
					squers[3][5].setText(Integer.toString(k++));
					
					squers[4][1].setBackground(brown);
					squers[5][1].setBackground(brown);
					squers[4][1].setText(Integer.toString(k));
					squers[5][1].setText(Integer.toString(k++));
					
					squers[4][3].setBackground(brown);
					squers[4][4].setBackground(brown);
					squers[4][5].setBackground(brown);
					squers[4][3].setText(Integer.toString(k));
					squers[4][4].setText(Integer.toString(k));
					squers[4][5].setText(Integer.toString(k++));
					
					squers[3][0].setBackground(brown);
					squers[3][1].setBackground(brown);
					squers[3][2].setBackground(brown);
					squers[3][0].setText(Integer.toString(k));
					squers[3][1].setText(Integer.toString(k));
					squers[3][2].setText(Integer.toString(k));
									
					squers[2][0].setBackground(Color.red);
					squers[2][1].setBackground(Color.red);
				}
				else
					if(level.equals("extreme")) {
						squers[0][0].setBackground(brown);
						squers[1][0].setBackground(brown);
						squers[0][0].setText(Integer.toString(k));
						squers[1][0].setText(Integer.toString(k++));
						
						squers[0][4].setBackground(brown);
						squers[1][4].setBackground(brown);
						squers[0][4].setText(Integer.toString(k));
						squers[1][4].setText(Integer.toString(k++));
						
						squers[2][2].setBackground(brown);
						squers[3][2].setBackground(brown);
						squers[2][2].setText(Integer.toString(k));
						squers[3][2].setText(Integer.toString(k++));
						
						squers[2][3].setBackground(brown);
						squers[3][3].setBackground(brown);
						squers[2][3].setText(Integer.toString(k));
						squers[3][3].setText(Integer.toString(k++));
						
						squers[2][4].setBackground(brown);
						squers[3][4].setBackground(brown);
						squers[2][4].setText(Integer.toString(k));
						squers[3][4].setText(Integer.toString(k++));
						
						squers[3][0].setBackground(brown);
						squers[3][1].setBackground(brown);
						squers[3][0].setText(Integer.toString(k));
						squers[3][1].setText(Integer.toString(k++));
						
						squers[4][3].setBackground(brown);
						squers[5][3].setBackground(brown);
						squers[4][3].setText(Integer.toString(k));
						squers[5][3].setText(Integer.toString(k++));
						
						squers[4][4].setBackground(brown);
						squers[4][5].setBackground(brown);
						squers[4][4].setText(Integer.toString(k));
						squers[4][5].setText(Integer.toString(k++));
						
						squers[5][4].setBackground(brown);
						squers[5][5].setBackground(brown);
						squers[5][4].setText(Integer.toString(k));
						squers[5][5].setText(Integer.toString(k++));
						
						squers[0][5].setBackground(brown);
						squers[1][5].setBackground(brown);
						squers[2][5].setBackground(brown);
						squers[0][5].setText(Integer.toString(k));
						squers[1][5].setText(Integer.toString(k));
						squers[2][5].setText(Integer.toString(k++));
						
						squers[1][1].setBackground(brown);
						squers[1][2].setBackground(brown);
						squers[1][3].setBackground(brown);
						squers[1][1].setText(Integer.toString(k));
						squers[1][2].setText(Integer.toString(k));
						squers[1][3].setText(Integer.toString(k++));
										
						squers[2][0].setBackground(Color.red);
						squers[2][1].setBackground(Color.red);
					}

	}

	public void clearBoard(){
		for(int i=0;i<6;i++)
			for (int j = 0; j < 6; j++) {
				squers[i][j].setBackground(new Color(205,133,63));
				squers[i][j].setText(Integer.toString(0));
			}
	}

	public void actionToView(String plan)
	{
		String action = plan;
		int location=0,i,j;
		Color bg=new Color(205,133,63);
		Color brick=new Color(139,69,19);
		if(plan!=null)
		{
			Scanner ActScan = null;
			Color brickColor;
			ActScan =new Scanner(action);
			ActScan.useDelimiter(" l");
			if(action.contains("red"))
				brickColor=Color.red;
			else
				brickColor=brick;
			if(action.contains("mov"))//part of the plan
			{
				String beforeMov;
				if(action.contains("small")) //******small brick actions
				{
					if(action.contains("movright"))
					{
						ActScan.next();//skip the command
						location=Integer.parseInt(ActScan.next()); //location1
						i=(location/10)-1;
						j=(location%10)-1;
						beforeMov=squers[i][j].getText();
						squers[i][j].setBackground(bg);
						squers[i][j].setText(Integer.toString(0));
						location=Integer.parseInt(ActScan.next()); //location2
						i=(location/10)-1;
						j=(location%10)-1;
						squers[i][j].setBackground(brickColor);
						location=Integer.parseInt(ActScan.next()); //Destination
						i=(location/10)-1;
						j=(location%10)-1;
						squers[i][j].setBackground(brickColor);
						squers[i][j].setText(beforeMov);
						
					}
					else 
						if(action.contains("movleft"))
						{
							ActScan.next();//skip the command
							location=Integer.parseInt(ActScan.next()); //location1
							i=(location/10)-1;
							j=(location%10)-1;
							squers[i][j].setBackground(brickColor);
							location=Integer.parseInt(ActScan.next()); //location2
							i=(location/10)-1;
							j=(location%10)-1;
							beforeMov=squers[i][j].getText();
							squers[i][j].setBackground(bg);
							squers[i][j].setText(Integer.toString(0));
							location=Integer.parseInt(ActScan.next()); //Destination
							i=(location/10)-1;
							j=(location%10)-1;
							squers[i][j].setBackground(brickColor);
							squers[i][j].setText(beforeMov);
						}
						else 
							if(action.contains("movup"))
							{
								ActScan.next();//skip the command
								location=Integer.parseInt(ActScan.next()); //location1
								i=(location/10)-1;
								j=(location%10)-1;
								squers[i][j].setBackground(brickColor);
								location=Integer.parseInt(ActScan.next()); //location2
								i=(location/10)-1;
								j=(location%10)-1;
								beforeMov=squers[i][j].getText();
								squers[i][j].setBackground(bg);
								squers[i][j].setText(Integer.toString(0));
								location=Integer.parseInt(ActScan.next()); //Destination
								i=(location/10)-1;
								j=(location%10)-1;
								squers[i][j].setBackground(brickColor);
								squers[i][j].setText(beforeMov);
							}
							else 
								if(action.contains("movdown"))
								{
									ActScan.next();//skip the command
									location=Integer.parseInt(ActScan.next()); //location1
									i=(location/10)-1;
									j=(location%10)-1;
									beforeMov=squers[i][j].getText();
									squers[i][j].setBackground(bg);
									squers[i][j].setText(Integer.toString(0));
									location=Integer.parseInt(ActScan.next()); //location2
									i=(location/10)-1;
									j=(location%10)-1;
									squers[i][j].setBackground(brickColor);
									location=Integer.parseInt(ActScan.next()); //Destination
									i=(location/10)-1;
									j=(location%10)-1;
									squers[i][j].setBackground(brickColor);
									squers[i][j].setText(beforeMov);
								}
				}
				else //****************************************************************Big brick actions
					if(action.contains("movright"))
					{
						ActScan.next();//skip the command
						location=Integer.parseInt(ActScan.next()); //location1
						i=(location/10)-1;
						j=(location%10)-1;
						beforeMov=squers[i][j].getText();
						squers[i][j].setBackground(bg);
						squers[i][j].setText(Integer.toString(0));
						location=Integer.parseInt(ActScan.next()); //location2
						i=(location/10)-1;
						j=(location%10)-1;
						squers[i][j].setBackground(brickColor);
						location=Integer.parseInt(ActScan.next()); //location3
						i=(location/10)-1;
						j=(location%10)-1;
						squers[i][j].setBackground(brickColor);
						location=Integer.parseInt(ActScan.next()); //Destination
						i=(location/10)-1;
						j=(location%10)-1;
						squers[i][j].setBackground(brickColor);
						squers[i][j].setText(beforeMov);
					}
					else 
						if(action.contains("movleft"))
						{
							ActScan.next();//skip the command
							location=Integer.parseInt(ActScan.next()); //location1
							i=(location/10)-1;
							j=(location%10)-1;
							squers[i][j].setBackground(brickColor);
							location=Integer.parseInt(ActScan.next()); //location2
							i=(location/10)-1;
							j=(location%10)-1;
							squers[i][j].setBackground(brickColor);
							location=Integer.parseInt(ActScan.next()); //location3
							i=(location/10)-1;
							j=(location%10)-1;
							beforeMov=squers[i][j].getText();
							squers[i][j].setBackground(bg);
							squers[i][j].setText(Integer.toString(0));
							location=Integer.parseInt(ActScan.next()); //Destination
							i=(location/10)-1;
							j=(location%10)-1;
							squers[i][j].setBackground(brickColor);
							squers[i][j].setText(beforeMov);
						}
						else 
							if(action.contains("movup"))
							{
								ActScan.next();//skip the command
								location=Integer.parseInt(ActScan.next()); //location1
								i=(location/10)-1;
								j=(location%10)-1;
								squers[i][j].setBackground(brickColor);
								location=Integer.parseInt(ActScan.next()); //location2
								i=(location/10)-1;
								j=(location%10)-1;
								squers[i][j].setBackground(brickColor);
								location=Integer.parseInt(ActScan.next()); //location3
								i=(location/10)-1;
								j=(location%10)-1;
								beforeMov=squers[i][j].getText();
								squers[i][j].setBackground(bg);
								squers[i][j].setText(Integer.toString(0));
								location=Integer.parseInt(ActScan.next()); //Destination
								i=(location/10)-1;
								j=(location%10)-1;
								squers[i][j].setBackground(brickColor);
								squers[i][j].setText(beforeMov);
							}
							else 
								if(action.contains("movdown"))
								{
									ActScan.next();//skip the command
									location=Integer.parseInt(ActScan.next()); //location1
									i=(location/10)-1;
									j=(location%10)-1;
									beforeMov=squers[i][j].getText();
									squers[i][j].setBackground(bg);
									squers[i][j].setText(Integer.toString(0));
									location=Integer.parseInt(ActScan.next()); //location2
									i=(location/10)-1;
									j=(location%10)-1;
									squers[i][j].setBackground(brickColor);
									location=Integer.parseInt(ActScan.next()); //location3
									i=(location/10)-1;
									j=(location%10)-1;
									squers[i][j].setBackground(brickColor);
									location=Integer.parseInt(ActScan.next()); //Destination
									i=(location/10)-1;
									j=(location%10)-1;
									squers[i][j].setBackground(brickColor);
									squers[i][j].setText(beforeMov);
								}			
				ActScan.close();
			}
		}

	}



}
