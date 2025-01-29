class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        // 맞춰야할 공의 좌표를 y axios 또는 x axios 로 반전시켜야함
        // y가 같은데 목표공의 x길이가 더 작으면 스킵
        int[] answer = new int[balls.length];
        for(int i=0;i<balls.length;i++){
            int objX = balls[i][0];
            int objY = balls[i][1];
            int minLength = m*m+n*n+1;
            int x = -1;
            int y = -1;
            
            // 왼쪽 벽
            if(!(objY == startY && objX<startX)){
                //목적지의 벽 길이 제곱
                x = objX+startX;
                //출발지의 벽 길이 제곱 
                y = Math.abs(objY-startY);
                minLength = Math.min(minLength,x*x+y*y);
            }
            
            // 위쪽 벽
            if(!(objX == startX && startY<objY)){
                //목적지의 벽 길이 제곱
                x = Math.abs(objX-startX);
                //출발지의 벽 길이 제곱 
                y = (n-objY)+(n-startY);
                minLength = Math.min(minLength,x*x+y*y);
            }
            
            // 오른쪽 벽
            if(!(objY == startY && startX<objX)){
                //목적지의 벽 길이 제곱
                x = (m-objX)+(m-startX);
                //출발지의 벽 길이 제곱 
                y = Math.abs(objY-startY);
                minLength = Math.min(minLength,x*x+y*y);
            }
            
            // 아랫쪽 벽
            if(!(objX == startX && objY<startY)){
                //목적지의 벽 길이 제곱
                x = Math.abs(objX-startX);
                //출발지의 벽 길이 제곱 
                y = objY+startY;
                minLength = Math.min(minLength,x*x+y*y);
            }
            answer[i] = minLength;
        }
        return answer;
    }
}