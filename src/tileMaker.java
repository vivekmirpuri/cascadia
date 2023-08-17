public interface tileMaker {
     int rows = 6;
     int columns =18;




     default void emptyTile(int offset, int frequency, int threshold) {
            if (threshold <= rows){

                for (int j = 0; j < offset; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < columns - 2*offset; k++) {
                    if (k % frequency == 0 || k == 0) {

                        System.out.print("*");

                    } else {

                        System.out.print(" ");

                    }
                }
            }
    }




    default void tile() {
        int n = 1;
        emptyTile(3,5,n);
        switch (n) {
        case 1:
            System.out.println();
            n++;
            emptyTile(1,14, n);
        case 2:
            System.out.println();
            n++;
            emptyTile(0,16, n);
        case 3:
            System.out.println();
            n++;
            emptyTile(0,16, n);
        case 4:
            System.out.println();
            n++;
            emptyTile(1,14, n);
        case 5:
            System.out.println();
            n++;
            emptyTile(3,5, n);
        case 6:
            System.out.println();

    }

    }
}

