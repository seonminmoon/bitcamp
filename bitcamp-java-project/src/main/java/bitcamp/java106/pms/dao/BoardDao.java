// Board 방 관리
package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    Board[] boards = new Board[1000];
    int boardIndex = 0;
    
    public void insert(Board board) {               // add
        board.no = boardIndex;
        this.boards[this.boardIndex++] = board;
    }
    
    public Board[] list() {                 // list
        Board[] arr = new Board[boardIndex]; 
        // boardIndex 만큼 만들어서 보내줘라
        // 선언 안하면 Board[1000] 을 보내버리는거라서 메모리 낭비
        for (int i = 0; i < boardIndex; i++)
            arr[i] = boards[i];  // 전체 1000개의 방 중에서, 게시물이 저장된 방만 배열에 옮겨서 리턴
        return arr;
    }
    
    public Board get(int i) {               // view
        if (i < 0 || i >= boardIndex)
            return null;
        return boards[i];
    }
    
    public void update(Board board) {           // update
        boards[board.no] = board;
    }
    
    public void delete(int i) {             // delete
        boards[i] = null;
    }
    
}

// ver 14 - BoardController 로부터 데이터 관리 기능을 분리하여 BoardDao 생성.