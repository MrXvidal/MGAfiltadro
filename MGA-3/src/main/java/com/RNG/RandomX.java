
package com.RNG;

public class RandomX {
	       
	        MersenneTwister num = new Random();
	        
	        
	        public String rtp() {
	        	
	        
	        Random r 	= new Random(); 
	        double c = 100 * r.nextFloat() ;
	        System.out.println("tu numero es " + c);
	        
	        if((c -= 0.010) <0 )
	        {
	       /* 	if (Bet == 0.20) {
	        		Win = 80;
	        	} 
	        	else if (Bet == 0.40){
	        		Win = 160;
	        	}
	        	else {
	        		Win = 240;
	        	} */
	            return 	"DiamantesA";      		      		
	        }
	        else if((c -= 0.1) <0 )
	        {	
	        	   /* 	if (Bet == 0.20) {
        		Win = 20;
        	} 
        	else if (Bet == 0.40){
        		Win = 40;
        	}
        	else {
        		Win = 60;
        	} */
	        	return "DiamantesR"; //premio: DiamantesR
	        }
	        else if((c -= 0.19) <0 )
	        {	
	        	   /* 	if (Bet == 0.20) {
        		Win = 8;
        	} 
        	else if (Bet == 0.40){
        		Win = 16;
        	}
        	else {
        		Win = 24;
        	} */
	        	return "DiamantesV"; // premio: DiamantesV
	        }
	        else if((c -= 0.4) <0 )
	        {	      
	        	   /* 	if (Bet == 0.20) {
        		Win = 4;
        	} 
        	else if (Bet == 0.40){
        		Win = 8;
        	}
        	else {
        		Win = 12;
        	} */
	        	return "Campanas";	// premio: Campanas
	        	}
	        else if((c -= 0.6) <0 )
	        {	        
	        	   /* 	if (Bet == 0.20) {
        		Win = 3.20;
        	} 
        	else if (Bet == 0.40){
        		Win = 6.40;
        	}
        	else {
        		Win = 9.60;
        	} */
	        	return "Fresas";	//  premio: Fresas
	        	}
	        else if((c -= 0.8) <0 )
	        {	        
	        	   /* 	if (Bet == 0.20) {
        		Win = 2.40;
        	} 
        	else if (Bet == 0.40){
        		Win = 4.80;
        	}
        	else {
        		Win = 7.20;
        	} */
	        	return "Limones";	 // premio Limones
	        	}
	        else if((c -= 1.2) <0 )
	        {	        
	        	   /* 	if (Bet == 0.20) {
        		Win = 1.60;
        	} 
        	else if (Bet == 0.40){
        		Win = 3.20;
        	}
        	else {
        		Win = 4.80;
        	} */
	        	return "Ciruelas";	 //  premio Ciruelas
	        	}
	        else if((c -= 2.3) <0 )
	        {	     	
	        	   /* 	if (Bet == 0.20) {
        		Win = 0.80;
        	} 
        	else if (Bet == 0.40){
        		Win = 1.60;
        	}
        	else {
        		Win = 2.40;
        	} */
	        	return "Naranjas"; // premio Nranjas	
	        	}
	        else if((c -= 3.2) <0 )
	        {
	        	   /* 	if (Bet == 0.20) {
        		Win = 0.40;
        	} 
        	else if (Bet == 0.40){
        		Win = 0.80;
        	}
        	else {
        		Win = 1.20;
        	} */
	        	return "Diamantes3";	// premio Diamantes3
	        }
	        else if((c -= 21) <0 ) // EMPIEZAN LOS NADA 
	        {
	        	return "Nada1";	//premio: NADA
	        }
	        else if((c -= 25) <0 )
	        {
	        	return "Nada2";	//premio: NADA
	        }        	        
	        else if((c -= 28) <0 )
	        {
	        	return "Nada3";	//premio: NADA
	        } 
	        else if((c -= 32) <0 )
	        {
	        	return "Nada4";	//premio: NADA
	        }  
	        else if((c -= 37) <0 )
	        {
	        	return "Nada5";	//premio: NADA
	        }   
	        else if((c -= 41) <0 )
	        {
	        	return "Nada6";	//premio: NADA
	        }  
	        else if((c -= 45) <0 )
	        {
	        	return "Nada7";	//premio: NADA
	        }
	        else if((c -= 50) <0 )
	        {
	        	return "Nada8";	//premio: NADA
	        }  
	        else  if((c -= 61) <0 )
	        {
	        	return "Nada9";	//premio: NADA
	        }   
	        else if((c -= 66) <0 )
	        {
	        	return "Nada10";	//premio: NADA
	        }  
	        else  if((c -= 70) <0 )
	        {
	        	return "Nada11";	//premio: NADA
	        }
	        else if((c -= 71) <0 )
	        {
	        	return "Nada12";	//premio: NADA
	        }  
	        else if((c -= 81) <0 )
	        {
	        	return "Nada13";	//premio: NADA
	        }
	        else if((c -= 86) <0 )
	        {
	        	return "Nada14";	//premio: NADA
	        }  
	        else if((c -= 91) <0 )
	        {
	        	return "Nada15";	//premio: NADA
	        }
	        
	        else return "Cosa";
	       	    
	       }
	    	  
}
