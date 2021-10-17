
import java.util.ArrayList;

public class MazeSolver extends Thread{
    int[][] matrice;
    int xPos,yPos;
    int n,m;
    String label;

    MazeSolver( int[][] matrice,int[] start,String label){
        this.matrice=matrice;
        this.xPos=start[0];
        this.yPos=start[1];
        this.m=matrice.length;
        this.n=matrice[0].length;
        this.label=label;
    }

    public void run(){
        System.out.println(this.label +" Thread N:"+this.getId() + " starts from: "+this.xPos+","+this.yPos);
        int fin=1;
        while(fin==1 && !main.goalAchieved){
            this.matrice[this.xPos][this.yPos]=-1;
            fin=this.move();
            if(  this.xPos==2  && this.yPos==12 ) {
                System.out.println("on est la sortie stat:"+main.goalAchieved);
                main.setStatic();
                System.out.println("on est a la sortie  stat after change :"+main.goalAchieved);}
        }
    }

    public int move(){
        ArrayList<int []> array=new ArrayList<int []>();
        array=this.checkNeigbours(this.xPos,this.yPos);
        if(array.size()==1){
            //continue
            this.xPos=(array.get(0))[0];
            this.yPos=(array.get(0))[1];
            System.out.println(this.label+" Thread N: "+this.getId() +" continue:"+(array.get(0))[0]+","+(array.get(0))[1]);
            return 1;
        
        }else if(array.size()==2){
            //continue and create 1 thread
            this.xPos=(array.get(0))[0];
            this.yPos=(array.get(0))[1];
            System.out.println(this.label+" Thread N: "+this.getId() +" continue:"+(array.get(0))[0]+","+(array.get(0))[1]);

            int [] start1={(array.get(1))[0],(array.get(1))[1]};
            Thread thread1=new MazeSolver(this.matrice, start1,"created");
            thread1.start();
            //System.out.println("created thread :"+(array.get(1))[0]+","+(array.get(1))[1]);
            return 1;

        }else if(array.size()==3){
            //continue and create 2 thread
            this.xPos=(array.get(0))[0];
            this.yPos=(array.get(0))[1];
            System.out.println(this.label+" Thread N: "+this.getId() +" continue:"+(array.get(0))[0]+","+(array.get(0))[1]);

            //thread1
            int [] start1={(array.get(1))[0],(array.get(1))[1]};
            Thread thread1=new MazeSolver(this.matrice, start1," created");
            thread1.start();

            //thread2
            int [] start2={(array.get(2))[0],(array.get(2))[1]};
            Thread thread2=new MazeSolver(this.matrice, start2,"  created");
            thread2.start();
            return 1;


        }else{
            //kill thread
            
            System.out.println("stop "+this.getId() + "thread ");
            
            return 0;
         }


        

      //return(0);

    }
    public ArrayList checkNeigbours(int xPos,int yPos){
        int[] couple={-1,-1};
        int[] couple1={-1,-1};
        int[] couple2={-1,-1};
        int[] couple3={-1,-1};
        ArrayList<int []> array=new ArrayList<int []>();
        
        if (xPos>0 && yPos>0 && xPos<n-1 && yPos<m-1){
            
            if(this.matrice[xPos+1][yPos]==1){
            couple[0]=xPos+1;
            couple[1]=yPos;
            array.add(couple);}

            if(this.matrice[xPos][yPos-1]==1){
            couple1[0]=xPos;
            couple1[1]=yPos-1;
            array.add(couple1);}

            if(this.matrice[xPos][yPos+1]==1){
            couple2[0]=xPos;
            couple2[1]=yPos+1;
            array.add(couple2);}

            if(this.matrice[xPos-1][yPos]==1){
                couple3[0]=xPos-1;
                couple3[1]=yPos;
                array.add(couple3);}

            return array;
             
        }else if(xPos==0 && yPos==0){
                
                if(this.matrice[xPos+1][yPos]==1){
                couple[0]=xPos+1;
                couple[1]=yPos;
                array.add(couple);}

                if(this.matrice[xPos][yPos+1]==1){
                couple1[0]=xPos;
                couple1[1]=yPos+1;
                array.add(couple1);}

                return array;


        }else if(xPos==0 &&yPos==m-1){
                
                if(this.matrice[xPos+1][yPos]==1){
                couple[0]=xPos+1;
                couple[1]=yPos;
                array.add(couple);}

                if(this.matrice[xPos][yPos-1]==1){
                couple1[0]=xPos;
                couple1[1]=yPos-1;
                array.add(couple1);}

                return array;

        }else if(xPos==0 && yPos>0 && yPos<m-1){
                
                if(this.matrice[xPos+1][yPos]==1){
                couple[0]=xPos+1;
                couple[1]=yPos;
                array.add(couple);}

                if(this.matrice[xPos][yPos-1]==1){
                couple1[0]=xPos;
                couple1[1]=yPos-1;
                array.add(couple1);}

                if(this.matrice[xPos][yPos+1]==1){
                couple2[0]=xPos;
                couple2[1]=yPos+1;
                array.add(couple2);}

                return array;
        
        }else if(xPos==n-1 && yPos==m-1){
            
               

                if(this.matrice[xPos][yPos-1]==1){
                couple[0]=xPos;
                couple[1]=yPos-1;
                array.add(couple);}

                if(this.matrice[xPos-1][yPos]==1){
                couple1[0]=xPos-1;
                couple1[1]=yPos;
                array.add(couple1);}

                return array;

        }else if(xPos==n-1 && yPos==0){
            
               

            if(this.matrice[xPos][yPos+1]==1){
            couple[0]=xPos;
            couple[1]=yPos+1;
            array.add(couple);}

            if(this.matrice[xPos-1][yPos]==1){
            couple1[0]=xPos-1;
            couple1[1]=yPos;
            array.add(couple1);}

            return array;

        }else if(xPos==n-1 && yPos>0 && yPos<m-1){
            
                if(this.matrice[xPos-1][yPos]==1){
                couple[0]=xPos-1;
                couple[1]=yPos;
                array.add(couple);}

                if(this.matrice[xPos][yPos-1]==1){
                couple1[0]=xPos;
                couple1[1]=yPos-1;
                array.add(couple1);}

                if(this.matrice[xPos][yPos+1]==1){
                couple2[0]=xPos;
                couple2[1]=yPos+1;
                array.add(couple2);}

                return array;
            
        }else if(yPos==0 && xPos>0 && xPos<n-1){
            
                if(this.matrice[xPos-1][yPos]==1){
                couple[0]=xPos-1;
                couple[1]=yPos;
                array.add(couple);}

                if(this.matrice[xPos+1][yPos]==1){
                couple1[0]=xPos+1;
                couple1[1]=yPos;
                array.add(couple1);}

                if(this.matrice[xPos][yPos+1]==1){
                couple2[0]=xPos;
                couple2[1]=yPos+1;
                array.add(couple2);}

                return array;
            
        }else if(yPos==m-1 && xPos>0 && xPos<n-1){
            
            if(this.matrice[xPos-1][yPos]==1){
            couple[0]=xPos-1;
            couple[1]=yPos;
            array.add(couple);}

            if(this.matrice[xPos+1][yPos]==1){
            couple1[0]=xPos+1;
            couple1[1]=yPos;
            array.add(couple1);}

            if(this.matrice[xPos][yPos-1]==1){
            couple2[0]=xPos;
            couple2[1]=yPos-1;
            array.add(couple2);}
            
            return array;
            
        }
        return array;

    }

    
}
