import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Mazet extends JPanel {
    BufferedImage pointSucces ;
    BufferedImage point ;
    BufferedImage point1 ;
    BufferedImage point2 ;
    BufferedImage point3 ;
    BufferedImage point4 ;
    BufferedImage point5 ;
    BufferedImage point6 ;
    BufferedImage point7 ;
    BufferedImage point8 ;
    BufferedImage point9 ;





    public Mazet() {

        this.setBackground(Color.BLACK);
        try {point = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\point.png"));
        point1 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\1.png"));
        point2 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\2.png"));
        point3 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\3.png"));
        point4 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\4.png"));
        point5 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\5.png"));
        point6 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\6.png"));
        point7 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\7.png"));
        point8 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\8.png"));
        point9 = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\9.png"));
        pointSucces = ImageIO.read(new File("C:\\Users\\pc hp\\Desktop\\Projets\\Java\\MultithreadedMaze\\Multithreaded-Maze-Solver\\assets\\pointSucces.png"));
        } catch (IOException e) {
            System.out.println("missing image file");
        }
    }
    
    public void paintComponent(Graphics g) {
        
        int[][] map =MazeSolver.matrice;
         for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int factori = i * 50;
                int factorj = j * 50;
                switch (map[i][j]) {
                case 0: {
                    g.setColor(Color.BLACK);
                    g.fillRect(factori, factorj, 50, 50);
    
                }break;
                case 1: {
                    g.setColor(Color.WHITE);
                    g.fillRect(factori, factorj,50,50);
    
                }break;
                case -22: {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(factori, factorj,50,50);
    
                }break;
                case 2: {
                    g.drawImage(pointSucces, factori, factorj, null);
                }break;    
                case -1: {
                    g.drawImage(point1,factori, factorj, null);
                }break;
                case -5: {
                    g.drawImage(point2,factori, factorj, null);
    
                }break;
                case -8: {
                    g.drawImage(point3,factori, factorj, null);
    
                }break;
                case -7: {
                    g.drawImage(point4,factori, factorj, null);
    
                }break;
                case -2: {
                    g.drawImage(point5,factori, factorj, null);
    
                }break;
                case -6: {
                    g.drawImage(point6,factori, factorj, null);
    
                }break;
                case -4: {
                    g.drawImage(point7,factori, factorj, null);
    
                }break;
                case -3: {
                    g.drawImage(point8,factori, factorj, null);
    
                }break;
                case -9: {
                    g.drawImage(point9,factori, factorj, null);
    
                }break;
                default : {
                    g.drawImage(point,factori, factorj, null);
    
                };
                }
            }
        }
    }
}