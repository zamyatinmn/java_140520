package Lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                {"1", "1", "1"},
                {"1", "1asd", "1", "1"},
                {"1", "1", "1as", "2", "2"}
        };

        System.out.println("Сумма чисел массива равна - " + sumArraySquare(array));

    }


    public static int sumArraySquare(String[][] array){
        int sum = 0;
        if (array.length != 4){
            try {
                throw new MyArraySizeException("Количество строк в массиве не равно 4");
            }catch (MyArraySizeException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                try {
                    throw new MyArraySizeException("Количество ячеек в строке " + i + " не равно 4");
                }catch (MyArraySizeException e){
                    e.printStackTrace();
                    e.getMessage();
                }
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Ячейка [" + i + "][" + j + "] содержит нечисловые данные");
                    }
                }catch (MyArrayDataException e){
                    e.printStackTrace();
                    e.getMessage();

                }

            }
        }
        return sum;
    }
}
