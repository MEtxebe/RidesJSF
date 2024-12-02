package eredua.bean;

import dataAccess.DataAccess;

public class testRides {
	    public static void main(String[] args) {
	        try {
	            DataAccess da = new DataAccess();
	            System.out.println("Conexión creada correctamente.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
