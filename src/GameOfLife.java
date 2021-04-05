

	public class GameOfLife {
		private boolean[][] game;
		private boolean[][] nextgame;
		private int count;
		

		public GameOfLife(int rows, int cols) {
			if (rows<1||cols<1) {
				throw new IllegalArgumentException();
			}
			this.game = new boolean[rows][cols];
			this.nextgame = new boolean[rows][cols];
			for (int i = 0; i < this.game.length; i++) {
				for (int e = 0; e < this.game[i].length; e++) {
					game[i][e] = false;
				}
			}
		}
		
		public boolean isInBounds(int y, int x) {
			return (y>=0&&x>=0&&y<game.length&&x<game[0].length);
		}

		public void setAlive(int y, int x, boolean b) {
			if ((y < this.game.length && y >= 0) && 
					(x < this.game[0].length && x >= 0)) {
				this.game[y][x] = b;
			}
		}

		public int getRows() {
			return this.game.length;
		}

		public int getColumns() {
			return this.game[0].length;
		}

		public boolean isAlive(int y, int x) {
			return isInBounds(y, x)?game[y][x]:false;
		}

		public void calculateNextGeneration() {
			for (int y = 0; y < game.length; y++) {
				for(int x = 0; x < game[0].length; x++) {
					int neighbourcount = getNeighbourCount(y, x);
					if(! game[y][x]) {
						nextgame[y][x]=neighbourcount==3;
	                }else if(this.game[y][x]) {
	                	nextgame[y][x]=(neighbourcount==3 || neighbourcount==2);
	                }
				}
			}
			boolean[][] temp = game;
			game = nextgame;
			nextgame = temp;
		}

		public String toString() {
			String finalString = "";
			for (int y = 0; y < game.length; y++) {
				for(int x = 0; x < game[y].length; x++) {
					finalString += game[y][x]?'*':' ';
				}
				finalString += "\r\n";
			}
			return finalString;
		}
		
		public int getNeighbourCount(int y, int x) {
			count = 0;
			for(int j = -1; j<2; j++) {
				for(int i = -1; i<2; i++) {
					count += (isInBounds(y+j, x+i) && this.game[y+j][x+i]?1: 0);
				}
			}
			count -= this.game[y][x]? 1:0;
			return (count);
		}
	}


