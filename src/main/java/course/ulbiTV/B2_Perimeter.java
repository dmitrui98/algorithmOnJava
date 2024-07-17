package course.ulbiTV;


import util.ArrayUtil;

/**
 * Дана матрица из нулей и единиц. Единицы образуют фигуры, длина одной грани-ячейки=1, посчитать периметр всех фигур
 */
public class B2_Perimeter {

    public static void main(String[] args) {
        new B2_Perimeter().go();
    }

    private void go() {
        int perimeter = perimeter(getMatrix());
        System.out.println("Периметр всех фигур: " + perimeter);
    }

    private int perimeter(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        ArrayUtil.printArray(matrix);
        int[][] matrixFramed = getMatrixFramed(matrix);
        System.out.println("Framed matrix:");
        ArrayUtil.printArray(matrixFramed);

        int p = 0;
        for (int i = 1; i < matrixFramed.length - 1; i++) {
            for (int j = 1; j < matrixFramed[i].length - 1; j++) {
                if (matrixFramed[i][j] == 1) {
                    p += getPointPerimeter(matrixFramed, j, i);
                }
            }
        }
        return p;
    }

    private int getPointPerimeter(int[][] matrix, int iw, int ih) {
        int p = 0;
        if (matrix[ih][iw - 1] == 0) p++;
        if (matrix[ih][iw + 1] == 0) p++;
        if (matrix[ih - 1][iw] == 0) p++;
        if (matrix[ih + 1][iw] == 0) p++;
        return p;
    }

    private int[][] getMatrixFramed(int[][] matrix) {
        int w = matrix[0].length + 2;
        int[][] matrixFramed = new int[matrix.length + 2][matrix[0].length + 2];
        matrixFramed[0] = new int[w];
        matrixFramed[matrixFramed.length - 1] = new int[w];
        for (int i = 1; i < matrixFramed.length - 1; i++) {
            for (int j = 1; j < matrixFramed[i].length - 1; j++) {
                matrixFramed[i][j] = matrix[i - 1][j - 1];
            }
        }
        return matrixFramed;
    }

    private int[][] getMatrix() {
        return new int[][]{
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        };
    }
}
