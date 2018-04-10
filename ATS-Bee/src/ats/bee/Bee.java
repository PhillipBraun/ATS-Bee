/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.bee;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phillip Braun
 */
public class Bee
{
    private Tile location;
    private double abstandP1;
    private double abstandP2;
    private double abstandP3;
    private List<Tile> Grid = new ArrayList<>();
    
    public Tile fly(Tile t)
    {
        location = t;
        return location;
    }
    
    public boolean see(List<Tile> Grid)
    {
        Tile[] tArray = searchPillars();
        abstandP1 = calculateDistance(tArray[0], location);
        abstandP2 = calculateDistance(tArray[1], location);
        abstandP3 = calculateDistance(tArray[2], location);
        return true;
    }

    public Tile getLocation()
    {
        return location;
    }

    public double getAbstandP1()
    {
        return abstandP1;
    }

    public double getAbstandP2()
    {
        return abstandP2;
    }

    public double getAbstandP3()
    {
        return abstandP3;
    }
    private double calculateDistance(Tile t, Tile l)
    {
        double x = t.getX() + l.getX();
        double y = t.getY() + l.getY();
        double distance = sqrt((x*x) + (y*y));
        return distance;
                
    }
    private Tile[] searchPillars()
    {
        int i = 0;
        Tile[] tArray = new Tile[3];
        for(Tile t : Grid)
        {
            if(t.hasP())
            {
                tArray[i] = t;
                i++;
            }
        }
        return tArray;
    }
    public boolean check(Bee middle)
    {
        if(middle.getAbstandP1() == abstandP1)
        {
            if(middle.getAbstandP2() == abstandP2)
            {
                if(middle.getAbstandP3() == abstandP3)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public Tile calcRoute()
    {
        int i = (int)(location.getX() - 1);
        int j = (int)(location.getY() - 1);
        double min = 0.0;
        double distance;
        Tile bestTile = null;
        for(; i< (location.getX()+1); i++)
        {
            for(; j < (location.getY()+1); i++)
            {
                Tile l = searchTile(i,j);
                
                Tile[] tArray = searchPillars();
                double abstandP1 = calculateDistance(tArray[0], l);
                double abstandP2 = calculateDistance(tArray[1], l);
                double abstandP3 = calculateDistance(tArray[2], l);
                distance = abstandP1 + abstandP2 + abstandP3;
                if(distance < min)
                {
                    min = distance;
                    bestTile = l;
                }
            } 
        }
        return bestTile;
    }
    
        public Tile searchTile(double x, double y)
    {
        for(Tile t : Grid)
        {
            if(t.getX() == x)
            {
                if(t.getY() == y)
                {
                    return t;
                }
            }
        }
        return null;
    }
}
