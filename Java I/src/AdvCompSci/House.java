package AdvCompSci;

import java.util.ArrayList;

public class House {
	ArrayList<Room> rooms = new ArrayList<Room>();
	public House() {
		
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public double getPrice() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getPrice();
		}
		return t;
	}
	
	public double getVolume() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getVolume();
		}
		return t;
	}
	
	public double getSquareFt() {
		double t = 0;
		for(int i = 0; i < rooms.size(); i++) {
			t += rooms.get(i).getArea();
		}
		return t;
	}
	
	public void setName(int i, String name){
        rooms.get(i).setName(name);
    }

    public void setL(int i, double l){
    	rooms.get(i).setL(l);
    }

    public void setW(int i, double w){
    	rooms.get(i).setW(w);
    }

    public void setH(int i, double h){
    	rooms.get(i).setH(h);
    }

    public void setMaterial(int i, ArrayList<Material> materials){
    	rooms.get(i).setMaterial(materials);
    }

    public void setAmountMaterial(int i, ArrayList<Double> amountMaterial){
    	rooms.get(i).setAmountMaterial(amountMaterial);
    }
}
