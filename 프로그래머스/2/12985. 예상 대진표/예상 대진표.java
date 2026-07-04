class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int cnt = 1;
        while (true) {
            if ((b-a == 1 && b/2 == a/2+1 ) || (a-b == 1 && b/2+1 == a/2 ))
                return cnt;
            a = chk(a);
            b = chk(b);
            cnt++;
        }
    }
    
    public int chk(int a) {
        return a % 2 == 1 ? a/2+1 : a/2;
    }
}