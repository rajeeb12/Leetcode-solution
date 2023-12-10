class Solution {
    public String decodeMessage(String key, String message) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character,Integer> map = new HashMap<>();
        
        int index = 0;
        for(char ch: key.toCharArray())
        {
            if(map.containsKey(ch) ||ch == ' ') continue;
            if(!map.containsKey(ch))
            {
                map.put(ch, index % alphabets.length());
            }
            index++;
        }

        String decodedMessage = "";
        for(char ch : message.toCharArray())
        {
            if(ch == ' ')
            {
                decodedMessage += " ";
                continue;
            }
            decodedMessage += alphabets.charAt(map.get(ch));
        }
        return decodedMessage;

    }
}