class TextEditor {
    StringBuilder s;
    int ptr;

    public TextEditor() {
        s = new StringBuilder("");
        ptr = 0;
    }
    
    public void addText(String text) {
        s.insert(ptr, text);
        ptr += text.length();
    }
    
    public int deleteText(int k) {
        int temp = ptr;
        ptr -= k;

        if(ptr < 0) ptr = 0;
        s.delete(ptr, temp);
        return temp - ptr;
    }
    
    public String cursorLeft(int k) {
        ptr -= k;
        if(ptr < 0) ptr = 0;
        if(ptr < 10) return s.substring(0, ptr);
        return s.substring(ptr - 10, ptr);
    }
    
    public String cursorRight(int k) {
        ptr = ptr + k;
        if(ptr >= s.length()) ptr = s.length();
        if(ptr < 10) return s.substring(0, ptr);
        return s.substring(ptr - 10, ptr);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */