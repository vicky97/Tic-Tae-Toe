package tictaetoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;    

public class TicTaeToe implements ActionListener{  

static int count=1;
static final JFrame f=new JFrame("Tic Tae Toe");  
static final JButton [][]board=new JButton[3][3];
static final ImageIcon oicon=new ImageIcon("o.jpg");
static final ImageIcon xicon=new ImageIcon("x.jpg");
static JLabel result=new JLabel();
static int values[][]=new int [3][3];
static boolean winner=false;


public static void main(String[] args) {  
    setIntialBoard();
    updatevalue();
}

static void setIntialBoard() {
	// TODO Auto-generated method stub
    TicTaeToe b1=new TicTaeToe();
	int posx=90,posy=50;
    for(int i=0;i<3;i++) {
    	
    	for(int j=0;j<3;j++) {
    		board[i][j]=new JButton();
    		board[i][j].setBounds(posx,posy, 70, 70);
    		board[i][j].addActionListener(b1);
    		f.add(board[i][j]);
    		posx+=70;
    	}
    	posy+=70;
    	posx=90;
    }
    result.setBounds(160, 280, 100, 30);
    f.add(result);
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);	
}


public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	  
	JButton jb =(JButton) arg0.getSource();
	
	if(jb.getIcon()!=null)
    return;

if(winner) return; 

	if(count%2==0)
		jb.setIcon(xicon);
	else
		jb.setIcon(oicon);
	
	count++;
if(count==10)
	result.setText("Match Draw!!!");
	updatevalue();
}

static void updatevalue() {
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			if(board[i][j].getIcon()==xicon)
				values[i][j]=0;
			else if(board[i][j].getIcon()==oicon)
				values[i][j]=1;
			else
				values[i][j]=-1;		
			
		}

	}
checkwinner();
}

 static void checkwinner() {
	int temp,i,j;
	int flag=0;
	 for(i=0;i<3;i++)
	{	flag=0;
		 temp=values[0][i];
		 
		for(j=1;j<3;j++)
		{	
			if(temp==-1 || temp!=values[j][i]) 
			{	flag=1; 
				break;}
			
		}
		if(flag==0) winnerIs(j-1,i);
		
		flag=0;
		temp=values[i][0];
		for(j=1;j<3;j++)
		{	
			if(temp==-1 ||temp!=values[i][j]) {flag=1; break;}			
		}
		if(flag==0)winnerIs(i,j-1);
	}
	 if(values[0][0]==values[1][1] && values[0][0]==values[2][2] && values[0][0]!=-1)
		 winnerIs(0,0);
	 else if(values[0][2]==values[1][1] && values[0][2]==values[2][0]&& values[0][2]!=-1)
		 winnerIs(0,2);
		 
}

 static void winnerIs(int i, int j) {
	 winner=true;
	 if(board[i][j].getIcon()==xicon)
	result.setText("X Wins !!!!");
	 else
	result.setText("O wins !!!!");
}  
}  