package com.mindtraits;

/**
 * @author vignesh
 * @version 1.0
 * @since 2019-08-28
 * 
 */

abstract class Header {
	
	public static void Head(){
		
			for(int i=1;i<=3;i++){
			
				for(int j=1;j<=14;j++){
				
					if(i==1||j==1||i==3||j==14){
					
						System.out.print("* ");
						
					}else if(i==3||j==3){
					
						System.out.print("MindtraitsCollegeSystem ");
					
					}
				
				}
				
				System.out.println();
				
			}	

		}
	
	}
