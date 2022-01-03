package gameCenter;

import finalCode.FinalCode;
import guessTheNumber.GuessTheNumber;

public class GSwitch {
	private GUser using;

	public void Operate(int label) {
		System.out.println("-".repeat(40));
		Game gaming = using.play(label);

		switch (label) {
		case -1:
			Projects.logOut();
			break;
		case 0:
			GuessTheNumber g = (GuessTheNumber) gaming;
			g.guessTheNumber();
			break;
		case 1:
			FinalCode f = (FinalCode) gaming;
			f.finalCode();
			break;
		default:
			System.out.println("Null.");

		}

		System.out.println("-".repeat(40));
	}

	public void setUser(GUser u) {
		using = u;
	}
}
