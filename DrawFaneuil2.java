//Aihoa Le (aihoale@bu.edu)
//Problem Set 3 | Part 2
//DrawFaneuil2 prints a scalable drawing that resembles the rear facade of Boston's Faneuil Hall.


public class DrawFaneuil2 {
    public static final int SCALE_FACTOR = 3;
    public static void main(String[] args) {
        drawRoof();
        drawDivider();
        drawWall();
        drawWindows();
        drawDivider();
        drawWindows();
        drawWall();
        drawDivider();
        drawBottomFloor1();
        drawBottomFloorMiddle();
        drawBottomFloor1();
        drawDivider();
    }
    
    //Print the roof
    public static void drawRoof() {
        for(int line = 1; line <= SCALE_FACTOR + 1; line++) {
            //Print spaces
            for(int i = 0; i < -3 * line + (3 * SCALE_FACTOR + 3); i++) {
                System.out.print(" ");
            }
            //Print characters that make up the roof
            if (line == 1) {
                for(int i = 0; i < SCALE_FACTOR - 2; i++) {
                    System.out.print("_");
                }
                System.out.print("^");
                for(int i = 0; i < SCALE_FACTOR - 2; i++) {
                    System.out.print("_");
                }
                System.out.println();
            } else {
                System.out.print("__/");
                for(int i = 0; i < 3 * line + SCALE_FACTOR - 8; i++) {
                    System.out.print(";");
                }
                
                if (line != 1) {
                    System.out.print("|");
                }
                for(int i = 0; i < 3 * line + SCALE_FACTOR - 8; i++) {
                    System.out.print(";");
                }
                System.out.println("\\__");
            }
        }
    }
    
    //Print the dividing line between each floor of the building
    public static void drawDivider() {
        for(int i = 0; i < 8 * SCALE_FACTOR - 3; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    //Print topmost line of the top two floors
    public static void drawWall() {
        System.out.print("|");
        for(int line = 0; line < 1; line++) {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 2 * SCALE_FACTOR - 2; j++) {
                    System.out.print(".");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
    
    //Print windows
    public static void drawWindows() {   
        for(int line = 0; line < SCALE_FACTOR; line++) {
            if (line == 0 || line == SCALE_FACTOR - 1) {
                System.out.print("|");
                for(int i = 0; i < 4; i++) {
                    System.out.print(".+");
                    for(int j = 0; j < 2 * SCALE_FACTOR - 6; j++) {
                        System.out.print("-");
                    }
                    System.out.print("+.|");
                }
                System.out.println();
            } else {
                System.out.print("|");
                for(int i = 0; i < 4; i++) {
                    System.out.print(".|");
                    for(int j = 0; j < 2 * SCALE_FACTOR - 6; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("|.|");
                }
                System.out.println();
            }
        }
    }
    
    //Print the topmost line of the bottom floor
    public static void drawBottomFloor1() {
        System.out.print("|.+");
        for(int j = 0; j < 2 * SCALE_FACTOR - 6; j++) {
            System.out.print("-");
        }
        System.out.print("+.|");
        
        for(int i = 0; i < SCALE_FACTOR - 2; i++) {
            System.out.print(".");
        }
        
        for(int i = 0; i < 2 * SCALE_FACTOR + 1; i++) {
            System.out.print("=");
        }
        
        for(int i = 0; i < SCALE_FACTOR - 2; i++) {
            System.out.print(".");
        }
        
        System.out.print("|.+");
        for(int i = 0; i < 2 * SCALE_FACTOR - 6; i++) {
            System.out.print("-");
        }
        System.out.println("+.|");
    }
    
    //Print the middle lines of the bottom floor
    public static void drawBottomFloorMiddle() {
        for(int line = 1; line <= SCALE_FACTOR - 1; line++) {
            System.out.print("|.|");
            for(int i = 0; i < 2 * SCALE_FACTOR - 6; i++) {
                System.out.print(" ");
            }
            System.out.print("|.|");
            
            for(int i = 0; i < SCALE_FACTOR - 2; i++) {
                System.out.print(".");
            }
            System.out.print("|");
            for(int i = 0; i < -line + (SCALE_FACTOR - 1); i++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for(int i = 0; i < line - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for(int i = 0; i < line - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("\\");
            for(int i = 0; i < -line + (SCALE_FACTOR - 1); i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for(int i = 0; i < SCALE_FACTOR - 2; i++) {
                System.out.print(".");
            }
            
            System.out.print("|.|");
            for(int i = 0; i < 2 * SCALE_FACTOR - 6; i++) {
                System.out.print(" ");
            }
            System.out.println("|.|");
        }
    }
    
}
            