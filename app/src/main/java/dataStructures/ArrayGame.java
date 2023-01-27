package dataStructures;

import java.util.Scanner;

public class ArrayGame {
    public static boolean canWin(int leap, int[] game, int pos) {
        if (pos < 0) {
            return false;
        }
        if (pos < game.length && game[pos] == 1) {
            return false;
        }
        
        if (pos + 1 >= game.length) {
            return true;
        }
        if (pos + leap > game.length) {
            return true;
        }
        
        game[pos] = 1;
        
        return canWin(leap, game, pos + leap) 
        || canWin(leap, game, pos + 1) 
        || canWin(leap, game, pos - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
