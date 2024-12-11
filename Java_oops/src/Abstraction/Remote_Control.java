package Abstraction;


import java.util.*;

abstract class RemoteControl
{
	abstract void powerOn();
	abstract void powerOff();
	abstract void changeChannel(int r);
}

class SamsungRemote extends RemoteControl
{
	boolean isOn=false;
	int currentChannel=10;

	void powerOn() {
		if(!isOn)
		{
			isOn=true;
			System.out.println("TV  on");
		}
		else
		{
			System.out.println("TV already on");
		}
		
	}

	void powerOff() {
		if(!isOn)
		{
			isOn=false;
			System.out.println("TV  off");
		}
		else
		{
			System.out.println("TV already off");
		}
		
	}

	void changeChannel(int channelNumber) {
		if(isOn)
		{
			this.currentChannel = channelNumber;
			System.out.println(currentChannel);
		}
		else
		{
			System.out.println("Tv is off kindly on the tv");
		}
		
	}
	
	
}


class Remote_Control {
    public static void main(String[] args) {

    	RemoteControl r=new SamsungRemote();
    	r.powerOff();
    	r.powerOn();
    	r.changeChannel(10);
        
    }
}
