package ats.bee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phillip Braun
 */
public class Tile
{
    private double x;
    private double y;
    private Pillar p;
    
    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Pillar getP()
    {
        return p;
    }
    
    public boolean hasP()
    {
        if(p != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setP(Pillar p)
    {
        this.p = p;
    }
}
