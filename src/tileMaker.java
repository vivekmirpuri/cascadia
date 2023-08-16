public interface tileMaker {
    final int rows = 6;
    final int columns =13;

    public default void emptyTile(int offset, int frequency) {

        for (int n= 1 ; n <= rows; n++){
            for (int i = 0 ; i < columns; i ++){

                for (int j = 0 ; j < offset; j ++){
                    System.out.print(" ");

                }
                for (int k = 0 ; k < (columns- frequency); k ++){
                    if (k%frequency==0 || k == 0){
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
            }
            switch (n){
                case 1:
                    offset -= 2;
                    frequency = 11; //number of cols minus offset in both sides
                    System.out.println();
                case 2:
                    offset = 0;
                    frequency = columns;
                    System.out.println();
                case 3:
                    System.out.println();
                case 4:
                    offset -= 2;
                    frequency = 11; //number of cols minus offset in both sides
                    System.out.println();
                case 5:
                    offset = 3;
                    frequency = 3;
            }

        }



    }

    public default void populateTile(int i, int j){

    }




}
