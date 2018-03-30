package step12.ex2;

public class LinkedList { // 패키지 클래스는 public, private 만 올 수 있음. 디폴트,프로텍티드 쓰면 오류남
    // 값을 저장할 바구니 클래스를 만든다.
    // 그 클래스는 LinkedList 에서만 사용할 것이기 때문에
    // 일반적인 클래스인 패키지 멤버 클래스로 정의하지 않고
    // LinkedList 안에 정의한다. 
    // 이렇게 클래스 안에 정의된 클래스를 "중첩 클래스(nested class)" 또는
    // "내부 클래스(inner class)" 라고 부른다.
    protected class Bucket {
        // 이 클래스의 역할은 기차에서 사람이나 물건을 싣는 객차의 역할을 수행한다.
        public Object value; // 이 변수에 값을 저장한다.
        public Bucket next; // 이 변수에는 다음 객차 주소를 저장한다.
        public Bucket prev; // 이 변수에는 이전 객차 주소를 저장한다.
        
    }
    // 디폴트여서 자신의 패키지 안에만 사용가능했는데
    // protected 하면 자신의 자식 클래스+패키지 까지 가능함. 접근범위 넓히기 
    protected Bucket head; // 리스트에서 맨 앞 객차의 주소를 저장하는 인스턴스 변수
    protected Bucket tail; // 리스트에서 맨 뒤 객차의 주소를 저장하는 인스턴스 변수
    
    public LinkedList() {
        // LinkedList를 만들면 일단 맨 앞에 있는 빈 객차를 준비한다.
        head = new Bucket();
        tail = head;
    }
    
    public void add(Object value) {
        // 맨 끝 객차에 짐을 싣는다.
        tail.value = value;
        
        // 새 객차를 만들어 맨 뒤에 붙인다.
        Bucket bucket = new Bucket();
        tail.next = bucket;
        
        // 새 객차의 이전 객차의 주소를 저장한다.
        bucket.prev = tail;
        
        // 새로 붙인 객차를 맨 끝 객차로 처리한다.
        tail = bucket;
    }
    
    public Object get(int i) { // 2번 찾는데 지금 0,1,2 까지 있음
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail) { // 객차가 하나라도 있으면
            if (count == i) // 객체를 찾으면
                return cursor.value; // 객체의 값을 리턴한다 못찾으면?
            count++; // count를 하나 올린다
            cursor = cursor.next; // 현재 위치를 다음 위치로 옮긴다
        }
        return null; // 전부다 돌았는데도 없으면 NULL 리턴
    }

    public int size() {
        Bucket cursor = head; // 현재 위치를 cursor 에 둔다
        int count = 0;
        
        while (cursor != tail) { // 값이 하나라도 있으면 while문 실행
            count++; // 카운트 하나 올리고
            cursor = cursor.next; // 다음값으로 넘어감
        }
        return count; // 최종 카운트를 리턴한다
    }

    public Object remove(int i) {
        Bucket cursor = head; // 첫번째 위치를 cursor 에 둔다
         
        if (i == 0) {
            if (head == tail) // 값이 없다면
                return null; 
            else {              // 값이 하나라도 있으면?
                head = head.next; // next가 가리키는 주소를 head주소로 지정
                head.prev = null; // 가비지를 가리키게 된 prev에 null 넣음
                return cursor.value; // 현재객차 값 리턴
            }
        }
        int count = 0;
        while(cursor != tail) { // 값이 하나라도 있으면 while문 실행
            if (count == i) {  // 삭제할 객차를 찾았다
                cursor.prev.next = cursor.next; 
                cursor.next.prev = cursor.prev;
                return cursor.value;
            }
                
            count++;
            cursor = cursor.next;
        }
        return null;
        
        
    }

    public void add(int i, Object value) {
        Bucket cursor = head;
        int count = 0;
        while(cursor != tail) {
            if (count == i) {
                Bucket bucket = new Bucket(); // 새 객차를 만든다
                bucket.value = value; // 새 객차의 value 값을 채운다
                bucket.prev = cursor.prev; // 새 객차의 prev로 현재 객차의 prev 주소 가져오기
                cursor.prev = bucket; // 현재 prev 로 새 객차 가리키기
                bucket.next = cursor;  // 새 객차의 다음 주소를 현재 객차로 가리키기
                if(bucket.prev != null) {
                    bucket.prev.next = bucket;
                    //새 객차의 prev.next 에 새 객차 주소를 가리키기
                } else { // 이전에 다른 객차가 없다면 이 객차를 헤드로 만든다.
                    head = bucket;
                }
                return;
            }
            count++;
            cursor = cursor.next;
        } // while 문 종료!
        
        if (count == i) { // head == tail 일 경우에 값 추가
            add(value); 
        }
    }
}
