
public class RockPaperScissors {
	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();
		int p1Win = 0, p2Win = 0, draw = 0;

		boolean won = false;
		while (!won) {
			Choice p1Choice = p1.getChoice();
			Choice p2Choice = p2.getChoice();
			System.out.println("Player 1 choice is 	" + p1Choice.toString());
			System.out.println("Player 2 choice is 	" + p2Choice.toString());

			switch (compare(p1Choice, p2Choice)) {
			case -1:
				System.out.println("Player 2 wins   	" + ++p2Win);
				break;
			case 1:
				System.out.println("Player 1 wins   	" + ++p1Win);
			default:
				System.out.println("Its a draw	    	" + ++draw);
			}
			System.out.println("*********************************");
			if (p1Win >= 30 || p2Win >= 30)
				won = true;
		}
	}

	private static int compare(Choice p1, Choice p2) {
		if (p1.value == 2 && p2.value == 0)
			return -1;
		if (p1.value == 0 && p2.value == 2)
			return 1;
		return Integer.compare(p1.value, p2.value);
	}

}

class Player {
	int wins = 0;
	Choice choice;

	Choice getChoice() {
		int rand = (int) (Math.random() * 3);
		if (rand < 1)
			choice = Choice.ROCK;
		else if (rand < 2)
			choice = Choice.PAPER;
		else
			choice = Choice.SCISSORS;
		return this.choice;
	}
}

enum Choice {
	ROCK(0), PAPER(1), SCISSORS(2);

	int value;

	Choice(int value) {
		this.value = value;
	}
}
