import java.util.Arrays;
/*
*Домашнее задание №2
*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 */

public class HomeWork2 {
    public static void main(String[] args) {
        //Д.З. п.1
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        HomeWork2.changeValueInArr(arr);
        System.out.println(Arrays.toString(arr));

        //Д.З. п.2
        int[] myArr = new int[8];
        HomeWork2.fillArray(myArr);
        System.out.println(Arrays.toString(myArr));

        //Д.З. п.3
        int[] newArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        HomeWork2.reduceElementOfArray(newArr);
        System.out.println(Arrays.toString(newArr));

        //Д.З. п.4
        int SIZE = 4;
        int[][] someArr = new int[SIZE][SIZE];
        HomeWork2.fillOneDiagonalOfArray(someArr);
        System.out.println(Arrays.deepToString(someArr));

        //Д.З. п.5
        int[] nextArr = {5, 14, 7, 3, 12, 18, 2, 8, 6};
        HomeWork2.findMinAndMaxElementOfArray(nextArr);
        int result[] = findMinAndMaxElementOfArray(nextArr);
        System.out.println("Минимальный элемент: " + result[1] + " Максимальный элемент: " + result[0]);

        //Д.З. п.6
        int[] balanceArr = {2, 5, 8, 9, 4, 11};
        HomeWork2.checkBalance(balanceArr);

        //Д.З. п.7
        int[] oneArr = {11, 15, 28, 73, 14, 3};
        int n = -4;
        HomeWork2.shiftArr(oneArr, n);

    }

    /**
     * метод проходится по массиву и заменяет 1 на 0, а 0 на 1
     * @param arr
     */
    private static void changeValueInArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }

    /**
     * метод заполняет массив елементами, где кажный последующий элемент больше на 3 чем предыдущий
     * @param myArr
     */
    private static void fillArray(int[] myArr) {
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = i * 3;
        }
    }

    /**
     * метод перебирает массив и елементы со значением меньше 6 умножает на 2
     * @param newArr
     */
    private static void reduceElementOfArray(int[] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] < 6) {
                newArr[i] = newArr[i] * 2;
            }
        }
    }

    /**
     * метод заполняет массив 1 по диагоналям слева направо и справа налево
     * @param someArr
     */
    private static void fillOneDiagonalOfArray(int[][] someArr) {
        for (int i = 0; i < someArr.length; i++) {
            for (int j = 0; j < someArr[i].length; j++) {
                if (i == j || (i + j) == 3) {
                    someArr[i][j] = 1;
                }
            }
        }
    }

    /**
     * метод находит и возвращает минимальный и максимальный елементы массива
     * @param nextArr
     * @return
     */
    private static int[] findMinAndMaxElementOfArray(int[] nextArr){
        int elementMax = nextArr[0];
        int elementMin = nextArr[0];
        for (int i = 0; i < nextArr.length; i++) {
            if (nextArr[i] > elementMax) {
                elementMax = nextArr[i];
            }
            if (nextArr[i] < elementMin) {
                elementMin = nextArr[i];
            }
        }
        return new int[] {elementMax, elementMin};
    }

    /**
     * метод возвращает true, если в массиве есть место, в котором сумма левой и правой части массива равны
     * @param balanceArr
     * @return
     */
    private static boolean checkBalance ( int[] balanceArr){
            int sumLeft, sumRight;
            for (int i = 0; i < balanceArr.length; i++) {
                sumLeft = 0;
                sumRight = 0;
                for (int j = 0; j < i; j++) {
                    sumLeft = sumLeft + balanceArr[j];
                }
                for (int l = i + 1; l < balanceArr.length; l++) {
                    sumRight = sumRight + balanceArr[l];
                }
                if (sumLeft == sumRight) {
                    return true;
                }
            }
            return false;
    }
    
    /**
     * метод сдвигает елементы массива на n позиций
     * @param oneArr
     * @param n
     */
    private static void shiftArr ( int[] oneArr, int n){
        if (n > 0) {
            //проходимся циклом по массиву если n > 0
            for (int i = 0; i < n; i++) {
                //создаем буферную переменную, куда кладем предыдущее значение элемента, чтобы использовать её в следующей итерации
                int buff = oneArr[oneArr.length - 1];
                for (int j = oneArr.length - 1; j > 0; j--) {
                    oneArr[j] = oneArr[j - 1];
                }
                //по окончанию цикла в переменной buff будет предыдущее значение елемента со сдвигом на п позиций, ему присваеся индекс [0]
                oneArr[0] = buff;
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                int buff = oneArr[0];
                for (int j = 0; j < oneArr.length - 1; j++) {
                    oneArr[j] = oneArr[j + 1];
                }
                oneArr[oneArr.length - 1] = buff;
            }
        }
    }

}