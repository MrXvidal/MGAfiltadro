package com.RNG;

public class Random extends MersenneTwister{
   
    
   
    public double MersenneTwister()
    {
        double c = 100 * nextFloat() ;
       
        if((c -= 0.010) <0 )
        {      
            return 1;
        }
        if((c -= 0.1) <0 )
        {       	
            return 2;
        }
        if((c -= 0.19) <0 )
        {        	
            return 3;
        }
        if((c -= 0.4) <0 )
        {       
            return 4;
        }
        if((c -= 0.6) <0 )
        {       
            return 5;
        }
        if((c -= 0.8) <0 )
        {        	
            return 6;
        }
        if((c -= 1.2) <0 )
        {	
            return 7;
        }
        if((c -= 2.3) <0 )
        {	
            return 8;
        }
        if((c -= 3.2) <0 )
        {	
            return 9;
        }
        if((c -= 91.2) <0 )
        {	
            return 10;
        }
       
       
        return c;
    }
   
}

