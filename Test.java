给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }if(s.length()==1){
            return s;
        }
        StringBuffer sb=new StringBuffer();
        sb.append("$#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)).append("#");
        }
        String str=new String(sb);
        int reslen=0;
        int rescen=0;
        int[] p=new int[2*s.length()+2];
        int io=0;
        int mi=0;
        for(int i=1;i<p.length;i++){
            p[i]=mi>i?Math.min(p[2*io-i],mi-i):1;
            while(i+p[i]<p.length&&i-p[i]>=0&&str.charAt(i+p[i])==str.charAt(i-p[i])){
                p[i]++;
            }
            if(i+p[i]>mi){
                mi=i+p[i];
                io=i;
            }
            if(reslen<p[i]){
                reslen=p[i];
                rescen=i;
            }
        }
        int start=(rescen-reslen)>>>1;
        return s.substring(start,start+reslen-1);
    }
}

