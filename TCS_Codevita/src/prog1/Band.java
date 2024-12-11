package prog1;

import java.util.Scanner;

public class Band
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        scanner.nextLine();  // Consume the remaining newline
        char[][] matrix = new char[S][S];
        
        // Input the matrix
        for (int i = 0; i < S; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        scanner.close();
        
        boolean[][] visited = new boolean[S][S];
        int overlaps = 0;
        
        // Traverse the matrix to check for overlaps
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (!visited[i][j] && (matrix[i][j] == '1' || matrix[i][j] == '2')) {
                    boolean[] result = detectOverlap(matrix, visited, i, j, matrix[i][j]);
                    if (result[1]) {
                        System.out.println("Impossible");
                        return;
                    } else if (result[0]) {
                        overlaps++;
                    }
                }
            }
        }
        overlaps=((overlaps-2)*2);
        System.out.println(overlaps==0?"Impossible":overlaps);
    }
    
    private static boolean[] detectOverlap(char[][] matrix, boolean[][] visited, int x, int y, char band) {
        int S = matrix.length;
        boolean[] result = {false, false}; // {overlap, impossible}
        visited[x][y] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        // Explore the neighbors to detect overlaps or impossibility
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < S && ny >= 0 && ny < S) {
                if (matrix[nx][ny] != '.' && matrix[nx][ny] != band) {
                    // If the neighboring cell is the opposite band, it's an overlap
                    if ((band == '1' && matrix[nx][ny] == '2') || (band == '2' && matrix[nx][ny] == '1')) {
                        result[0] = true; // overlap detected
                    } else {
                        result[1] = true; // impossible condition detected
                    }
                } else if (!visited[nx][ny] && matrix[nx][ny] == band) {
                    // If the neighbor is the same band and unvisited, recursively explore it
                    boolean[] nextResult = detectOverlap(matrix, visited, nx, ny, band);
                    result[0] = result[0] || nextResult[0];
                    result[1] = result[1] || nextResult[1];
                }
            }
        }
        
        return result;
    }
}