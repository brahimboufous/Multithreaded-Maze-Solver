import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

//1 : cell
//0 : wall
//-1 : visited

public class main {

    public static int[] exit={12,12};
    public static boolean goalAchieved=false;
    int[][] matrice = { 
    { 1,0, 0, 0,1, 1, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 0,0, 0, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 1,1, 0, 0,0, 0, 0,0, 0, 0 },
    { 1,0, 0, 1,1, 0, 1,1, 1, 1,1, 1, 0 },
    { 1,0, 0, 1,1, 0, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 0,0, 0, 1,1, 1, 1,0, 0, 0 },
    { 1,0, 0, 1,1, -1, 1,1, 1, 1,1, 1, 0 },
    { 1,0, 0, 0,1, 1, 1,0, 0, 0,0, 0, 0 },
    { 1,0, 0, 1,1, 1, 1,0, 1, 1,0, 0, 1 },
    { 1,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 7 },
    { 1,0, 0, 1,1, 1, 0,0, 1, 1,1, 0, 0 },
    { 1,0, 0, 0,0, 0, 0,0, 1, 0,1, 0, 0 },
    { 1,1, 1, 1,1, 1, 1,1, 1, 0,1, 1, 1 }};

    public static void setStatic() {
        goalAchieved=true;
    }
    
    main(int[][] matrice){
        //this.matrice=matrice;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                this.matrice[i][j]= matrice[j][i];
                this.matrice[j][i]=matrice[i][j];
            }
        }
    }

     public static void main(String[] args) {

        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1600,1000);
        frame.setLayout(null);
         
        int[][] mat = { 
                    { 1,0, 1, 1,1, 1, 1,1, 0, 1,1, 1, 1 },
                    { 1,0, 1, 0,0, 1, 0,1, 1, 1,0, 0, 1 },
                    { 1,0, 1, 1,0, 1, 0,0, 0, 0,1, 1, 1 },
                    { 1,0, 0, 1,0, 1, 1,1, 1, 1,1, 0, 1 },
                    { 1,0, 1, 1,0, 1, 0,0, 0, 0,0, 0, 1 },
                    { 1,0, 1, 0,0, 1, 0,1, 0, 0,1, 1, 1 },
                    { 1,0, 1, 1,1, 0, 1,1, 1, 1,1, 0, 1 },
                    { 1,1, 1, 0,0, 1, 1,0, 0, 0,0, 0, 1 },
                    { 0,0, 1, 0,1, 0, 1,0, 1, 1,1, 0, 1 },
                    { 1,0, 1, 0,0, 0, 0,0, 0, 0,1, 1, 1 },
                    { 1,1, 1, 1,1, 1, 1,1, 1, 1,0, 0, 1 },
                    { 0,0, 1, 0,1, 0, 0,0, 0, 1,0, 0, 1 },
                    { 1,1, 1, 0,1, 1, 1,1, 0, 1,1, 0, 1 }};

        main m=new main(mat);
        int[] start={0,0};
        Thread  mazeSolver=new MazeSolver(m.matrice,start,"main" ) ;
        mazeSolver.start();   
                
        JPanel panel=new JPanel();
        panel.setBounds(80, 80, (mat.length*50)+40,(mat.length*50)+40);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(MazeSolver.tt);      
        frame.add(panel);
        frame.setVisible(true);       
            
    }
}
