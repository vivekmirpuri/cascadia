public interface tileMaker {
     int rows = 6;
     int columns =13;


     default void emptyTile(int offset, int frequency, int row) {
            int n = row;

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < offset; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < (columns - (2 * offset)); k++) {
                    if (k % frequency == 0 || k == 0) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            switch (n) {
                case 1:
                    System.out.println();
                    n++;
                    emptyTile(1,11, n);
                case 2:
                    System.out.println();
                    n++;
                    emptyTile(0,13, n);
                case 3:
                    System.out.println();
                    n++;
                    emptyTile(0,13, n);
                case 4:
                    System.out.println();
                    n++;
                    emptyTile(1,11, n);
                case 5:
                    System.out.println();
                    n++;
                    emptyTile(3,3, n);
                case 6:
                    System.out.println("done");
            }

    }




}

