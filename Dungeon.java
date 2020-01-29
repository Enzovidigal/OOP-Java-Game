//***********************************************************
// Name: Enzo Vidigal
// Title: Assignment8.java
// Author Info: Computer Science, 1216959224, C
// Description: 
// Time spent:  5 days
// Date: 12/02/2019
//**********************************************************

/*Part#1 Asnswer 
a) Rect x y Width Height Rect x y Width Height

b) 0 0 10 20 100 5 125 2 20 7 10 0

c) 0 0 1 0 2 0 1 0 0 5 1 2 5 2 2 0 7 1 0 0

d) Rect x     y      Width   Height
   Rect x  .  y  .  Width  .  Height  .

e) in.useDelimiter("[^0-9]+[\\W]");
*/

import java.util.Random;
public class Dungeon{
    private Monster[][] monsters;
    public int gridWidth;
    public int gridHeight;
    
    public Dungeon(int width, int height){
        monsters = new Monster[height][width];
        gridWidth = width;
        gridHeight = height;
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                monsters[i][j] = new Monster();
            }
        }
    }

    public void updateMonster(int x, int y, Monster m){
        Monster monster = new Monster();
        if (x<gridWidth && y<gridHeight){
            if (monster.equals(monsters[y][x])){
                    monsters[y][x]=m;
                }
            }
    }

    public void shift(char command){
        Monster[][] monsterTemp = new Monster[gridHeight][gridWidth];
        if (command=='w'){
            for (int i=0; i<gridHeight; i++){
                for (int j=0; j<gridWidth; j++){
                        monsterTemp[i][j]=monsters[(i+1)%gridHeight][j];
                    }
                }
                monsters = monsterTemp;
            }
        
        if (command=='a'){
            for (int i=0; i<gridHeight; i++){
                for (int j=0; j<gridWidth; j++){
                        monsterTemp[i][j]=monsters[i][(j+1)%gridWidth];
                    }
                }
                monsters = monsterTemp;
        }
        
        if (command=='s'){
            for (int i=0; i<gridHeight; i++){
                for (int j=0; j<gridWidth; j++){
                        monsterTemp[(i+1)%gridHeight][j]=monsters[i][j];
                    }
                }
                monsters = monsterTemp;
        }
        
        if (command=='d'){
            for (int i=0; i<gridHeight; i++){
                for (int j=0; j<gridWidth; j++){
                        monsterTemp[i][(j+1)%gridWidth]=monsters[i][j];
                    }
                }
                monsters = monsterTemp;
            }
    }



    private void swap(int x1, int y1, int x2, int y2){  
        Monster[][] monsterTemp = new Monster[gridHeight][gridWidth];
        monsterTemp[y1][x1]=monsters[y1][x1];
        monsters[y1][x1]=monsters[y2][x2];
        monsters[y2][x2]=monsterTemp[y1][x1];
    }

    public void shuffle(){
        Random random = new Random();
        Monster[][] monsterTemp = new Monster[gridHeight][gridWidth];
        for (int i=0; i<gridHeight; i++){
            for (int j=0; j<gridWidth; j++){
                monsterTemp[i][j]=monsters[i][j];
                int x1 = j;
                int x2 = random.nextInt(gridWidth-1);
                if (x1==x2){
                    x2 = random.nextInt(gridWidth-1);
                }
                int y1 = i;
                int y2 = random.nextInt(gridWidth-1);
                if (y1==y2){
                    y2 = random.nextInt(gridWidth-1);
                }

                   swap(x1, y1, x2, y2);
            }
        }

    }

    public String printInfo(){
        String temp="\n";
        for (int i=0; i<gridHeight; i++){
            for (int j=0; j<gridWidth; j++){
                temp+=monsters[i][j].getInfo();
            }
            temp+="\n";
        }
    return temp;
    }
}
