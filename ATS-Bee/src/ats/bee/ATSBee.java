/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.bee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phillip Braun
 */
public class ATSBee
{
    private List<Tile> Grid = new ArrayList<>();
    private Bee honeybee = new Bee();
    private Bee middle = new Bee();
    
    
    private boolean setup()
    {
        for(int i = -7; i <= 7; i++)
        {
            for(int j = 7; j >= -7; j++)
            {
                Tile t = new Tile(i,j);
                Grid.add(t);
            }
        }
        
        middle.fly(middle.searchTile(0,0));
        
        return true;
    }
    

    
    private boolean beeGo()
    {
        boolean b;
        while(!honeybee.check(middle))
        {
            b = honeybee.see(Grid);
            System.out.println("X: " + honeybee.getLocation().getX());
            System.out.println("Y: " + honeybee.getLocation().getY());
            honeybee.fly(honeybee.calcRoute());
            
        }
        System.out.println("Finished");
        
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        System.out.println("Honeybee");
        setup();
        Pillar p = new Pillar();
        honeybee.searchTile(3.5, 2).setP(p);
        honeybee.searchTile(3.5, -2).setP(p);
        honeybee.searchTile(0, -4).setP(p);
        
        beeGo();
    }
    
    
    
    
    
}
