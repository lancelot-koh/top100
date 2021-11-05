package day1;

public class RotateImage {
    public void rotate(int[][] images) {
        transpose(images);
        reflect(images);
    }

    void transpose(int[][] images) {
        int n = images.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int tmp = images[i][j];
                images[j][i] = images[i][j];
                images[i][j] = tmp;
            }
        }
    }

    void reflect(int[][] images) {
        int n = images.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = images[i][j];
                images[i][j] = images[i][n - j - 1];
                images[n - j - 1][i] = tmp;
            }
        }
    }
}
