
package bitcamp.java106.pms;
import java.util.Scanner;
import bitcamp.java106.pms.domain.Board;

/* import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; */


public class App {
    static Scanner keyScan = new Scanner(System.in);
    public static void main(String[] args) {
        Board[] boards = new Board[1000];
        int boardIndex = 0;
        // List listA = new ArrayList();

        while(true) {
            System.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String input = arr[0];
            String option = null;

            if (arr.length == 2) {
                option = arr[1];
            }
            if (input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.equals("board/add")) {
                System.out.println("[게시글 등록]");
                Board board = new Board(); 
                System.out.print("제목? ");
                board.name = keyScan.nextLine();
                System.out.print("내용? ");
                board.content = keyScan.nextLine();
                System.out.print("등록일? ");
                board.date = keyScan.nextLine();
                boards[boardIndex++] = board; // 현재 board 값 저장
                System.out.println();
                continue;
            } else if (input.equals("board/list")) {
                System.out.println("[게시글 목록]");
                for (int i = 0; i < boardIndex; i++) {
                    if (boards[i] == null) continue;
                    System.out.printf("%d, %s, %s \n",
                    i, boards[i].name, boards[i].date);
                }
            } else if (input.equals("board/view")) {
                System.out.println("[게시글 조회]");
                Board board = null;
                if (option == null) {
                    System.out.println("게시물의 제목을 입력하세요.");
                    System.out.println();   
                    continue;
                } else {
                    for (int i = 0; i < boardIndex; i++) {
                        if (option.toLowerCase().equals(boards[i].name)) {
                            board = boards[i];
                            break;
                        }
                    }
                }
                if (board == null) {
                    System.out.println("없는 게시물이거나, 잘못 입력하셨습니다.");
                } else {
                    System.out.printf("제목: %s \n",board.name);
                    System.out.printf("내용: %s \n",board.content);
                    System.out.printf("등록일: %s \n",board.date);
                }
                
            } else if (input.equals("board/update")) {
                System.out.println("[게시글 변경]");
                int i;
                Board board = null;
                if (option == null) {
                    System.out.println("게시물의 제목을 입력하세요.");
                    System.out.println();   
                    continue;
                } else {
                    for (i = 0; i < boardIndex; i++) {
                        if (option.toLowerCase().equals(boards[i].name)) {
                            board = boards[i];
                            break;
                        }
                    }
                }
                if (board == null) {
                    System.out.println("없는 게시물이거나, 잘못 입력하셨습니다.");
                } else {
                    Board boardNull = new Board();
                    System.out.printf("제목(%s) ",board.name);
                    boardNull.name = keyScan.nextLine();
                    System.out.printf("내용(%s) ",board.content);
                    boardNull.content = keyScan.nextLine();
                    boards[i].name = boardNull.name;
                    boards[i].content = boardNull.content;
                    System.out.println("변경되었습니다.");
                }
            } else if (input.equals("board/delete")) {
                System.out.println("[게시글 삭제]");
                Board board = null;
                int i;
                if (option == null) {
                    System.out.println("게시물의 제목을 입력하세요.");
                    System.out.println();   
                    continue;
                } else {
                    for (i = 0; i < boardIndex; i++) {
                        if (option.toLowerCase().equals(boards[i].name)) {
                            board = boards[i];
                            break;
                        }
                    }
                }
                if (board == null) {
                    System.out.println("없는 게시물이거나, 잘못 입력하셨습니다.");
                } else {
                    System.out.println("정말 삭제하시겠습니까? (y,n) ");
                    String okok = keyScan.nextLine().toLowerCase();
                    if (okok.equals("y")) {
                        boards[i] = null;
                    }
                    System.out.println("삭제되었습니다.");
                    
                }
            }
            System.out.println();
        }
    }
}