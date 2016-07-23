public class WordDictionary {
    class Trier{
        private Trier[] children;
        private char c;
        private boolean flag;

        public Trier(){
            children = new Trier[26];
            flag = false;
        }
    }

    // Root
    Trier root = new Trier();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Trier pointer = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(pointer.children[c - 'a'] == null){
                pointer.children[c - 'a'] = new Trier();
                pointer = pointer.children[c - 'a'];
            }else{
                pointer = pointer.children[c - 'a'];
            }
        }
        pointer.flag = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Trier pointer = root;
        return helper(word, 0, pointer);
    }

    private boolean helper(String word, int start, Trier cur){
        if(start == word.length()){
            if(cur.flag) return true;
            else return false;
        }

        char c = word.charAt(start);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(cur.children[i] != null){
                    if(helper(word, start + 1, cur.children[i])){
                        return true;
                    }
                }
            }
        }else{
            if(cur.children[c - 'a'] == null){
                return false;
            }else{
                return helper(word, start + 1, cur.children[c - 'a']);
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
